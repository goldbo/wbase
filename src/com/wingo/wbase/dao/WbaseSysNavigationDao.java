package com.wingo.wbase.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wingo.wbase.common.base.BaseDAOHibernate;
import com.wingo.wbase.common.helper.SystemCacheHelper;
import com.wingo.wbase.model.WbaseSysNavigation;
import com.wingo.wbase.web.form.WbaseSysNavigationForm;

/**
 * @Title: WbaseSysNavigationDao.java
 * @Package com.wingo.wbase.dao;
 * @Description: 系统底部导航DAO
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */

public class WbaseSysNavigationDao extends BaseDAOHibernate {
	private static final Log log = LogFactory.getLog(WbaseSysNavigationDao.class);

	protected Class getModelClass() {
		return WbaseSysNavigation.class;
	}

	/**
	 * 获取所有系统底部导航数据集合
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<WbaseSysNavigation> getSysNavigationList() {
		List<WbaseSysNavigation> orgList = new ArrayList<WbaseSysNavigation>();
		List oList = this.doFind("from WbaseSysNavigation o where o.navFlag=1 order by navName");
		orgList = oList;
		return orgList;
	}

	/**
	 * 获取查询系统底部导航数据集合
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public int getTotalByOther(WbaseSysNavigationForm form) {

		StringBuffer query = new StringBuffer();
		query.append("from WbaseSysNavigation o where 1=1 \n");
		// 根据系统底部导航标题
		if (form.getNavName().trim().length()>0) {
			query.append(" and o.navName like '%" + form.getNavName().trim()
					+ "%' \n");
		}

		int total = super.getRowsByHQL("select count(*) " + query.toString());

		return total;
	}

	/**
	 * 获取查询系统底部导航数据集合
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public List getSysNavigationListByOther(WbaseSysNavigationForm form, int pageSize,
			int startRow) {

		StringBuffer query = new StringBuffer();
		query.append("from WbaseSysNavigation o where 1=1 \n");
		// 根据系统底部导航标题
		if (form.getNavName().trim().length()>0) {
			query.append(" and o.navName like '%" + form.getNavName().trim()
					+ "%' \n");
		}

		query.append(" order by o.navName ");
		List datas = super.doFind(query.toString(), pageSize, startRow);

		return datas;
	}

	/**
	 * 创建系统底部导航
	 * 
	 * @param SysNavigation
	 */
	public boolean createSysNavigation(WbaseSysNavigation SysNavigation) {
		boolean bool = this.doCreateObjectReturn(SysNavigation);
		SystemCacheHelper.updateSysNavigationCache();
		return bool;
	}

	/**
	 * 修改系统底部导航
	 * 
	 * @param SysNavigation
	 */
	public void updateSysNavigation(WbaseSysNavigation SysNavigation) {
		this.doUpdateObject(SysNavigation);
		SystemCacheHelper.updateSysNavigationCache();
	}

	/**
	 * 查找系统底部导航信息 BY ID
	 * 
	 * @param id
	 * @return
	 */
	public WbaseSysNavigation findSysNavigationById(String id) {
		WbaseSysNavigation SysNavigation = (WbaseSysNavigation) this.doFindObjectById(id);
		return SysNavigation;
	}

	/**
	 * 查找系统底部导航信息 BY SysNavigationNo
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public WbaseSysNavigation findSysNavigationByNavName(String navName) {

		List<WbaseSysNavigation> list = new ArrayList<WbaseSysNavigation>();
		List<WbaseSysNavigation> doFindObjectListByParam = (List<WbaseSysNavigation>) this
				.doFindObjectListByParam(
						"from WbaseSysNavigation o where o.navName=:navName", "navName",
						navName);
		list = doFindObjectListByParam;
		WbaseSysNavigation SysNavigation = null;
		if (list != null && !list.isEmpty()) {
			SysNavigation = list.get(0);
		}
		return SysNavigation;
	}

	/**
	 * 删除系统底部导航信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean deleteSysNavigationById(String id) {
		boolean bool = false;
		try {
			WbaseSysNavigation SysNavigation = this.findSysNavigationById(id);
			this.doDeleteObject(SysNavigation);
			SystemCacheHelper.updateSysNavigationCache();
			bool = true;
		} catch (Exception e) {
			bool = false;
		}
		return bool;
	}

	/**
	 * 删除系统底部导航信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean deleteSysNavigationByIds(String[] ids) {
		boolean bool = false;
		try {
			if (ids != null && ids.length > 0) {
				for (int i = 0; i < ids.length; i++) {
					this.deleteSysNavigationById(ids[i]);
				}
			}
			bool = true;
		} catch (Exception e) {
			bool = false;
		}
		SystemCacheHelper.updateSysNavigationCache();
		return bool;
	}

}
