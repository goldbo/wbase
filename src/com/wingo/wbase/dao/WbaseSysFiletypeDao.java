package com.wingo.wbase.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wingo.wbase.common.base.BaseDAOHibernate;
import com.wingo.wbase.model.WbaseSysFiletype;
import com.wingo.wbase.web.form.WbaseSysFiletypeForm;

/**
 * @Title: WbaseSysFiletypeDao.java
 * @Package com.wingo.wbase.dao;
 * @Description: 系统文件类型DAO
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */

public class WbaseSysFiletypeDao extends BaseDAOHibernate {
	private static final Log log = LogFactory.getLog(WbaseSysFiletypeDao.class);

	protected Class getModelClass() {
		return WbaseSysFiletype.class;
	}

	/**
	 * 获取所有系统文件类型数据集合
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<WbaseSysFiletype> getSysFiletypeList() {
		List<WbaseSysFiletype> orgList = new ArrayList<WbaseSysFiletype>();
		List oList = this.doFind("from WbaseSysFiletype o order by fileSuffix");
		orgList = oList;
		return orgList;
	}

	/**
	 * 获取查询系统文件类型数据集合
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public int getTotalByOther(WbaseSysFiletypeForm form) {

		StringBuffer query = new StringBuffer();
		query.append("from WbaseSysFiletype o where 1=1 \n");
		// 根据系统文件类型标题
		if (form.getFileSuffix().trim().length()>0) {
			query.append(" and o.fileSuffix like '%" + form.getFileSuffix().trim()
					+ "%' \n");
		}

		int total = super.getRowsByHQL("select count(*) " + query.toString());

		return total;
	}

	/**
	 * 获取查询系统文件类型数据集合
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public List getSysFiletypeListByOther(WbaseSysFiletypeForm form, int pageSize,
			int startRow) {

		StringBuffer query = new StringBuffer();
		query.append("from WbaseSysFiletype o where 1=1 \n");
		// 根据系统文件类型标题
		if (form.getFileSuffix().trim().length()>0) {
			query.append(" and o.fileSuffix like '%" + form.getFileSuffix().trim()
					+ "%' \n");
		}

		query.append(" order by o.fileSuffix ");
		List datas = super.doFind(query.toString(), pageSize, startRow);

		return datas;
	}

	/**
	 * 创建系统文件类型
	 * 
	 * @param SysFiletype
	 */
	public boolean createSysFiletype(WbaseSysFiletype SysFiletype) {
		boolean bool = this.doCreateObjectReturn(SysFiletype);
		return bool;
	}

	/**
	 * 修改系统文件类型
	 * 
	 * @param SysFiletype
	 */
	public void updateSysFiletype(WbaseSysFiletype SysFiletype) {
		this.doUpdateObject(SysFiletype);
	}

	/**
	 * 查找系统文件类型信息 BY ID
	 * 
	 * @param id
	 * @return
	 */
	public WbaseSysFiletype findSysFiletypeById(String id) {
		WbaseSysFiletype SysFiletype = (WbaseSysFiletype) this.doFindObjectById(id);
		return SysFiletype;
	}

	/**
	 * 查找系统文件类型信息 BY SysFiletypeNo
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public WbaseSysFiletype findSysFiletypeByFileSuffix(String fileSuffix) {

		List<WbaseSysFiletype> list = new ArrayList<WbaseSysFiletype>();
		List<WbaseSysFiletype> doFindObjectListByParam = (List<WbaseSysFiletype>) this
				.doFindObjectListByParam(
						"from WbaseSysFiletype o where o.fileSuffix=:fileSuffix", "fileSuffix",
						fileSuffix);
		list = doFindObjectListByParam;
		WbaseSysFiletype SysFiletype = null;
		if (list != null && !list.isEmpty()) {
			SysFiletype = list.get(0);
		}
		return SysFiletype;
	}

	/**
	 * 删除系统文件类型信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean deleteSysFiletypeById(String id) {
		boolean bool = false;
		try {
			WbaseSysFiletype SysFiletype = this.findSysFiletypeById(id);
			this.doDeleteObject(SysFiletype);
			bool = true;
		} catch (Exception e) {
			bool = false;
		}
		return bool;
	}

	/**
	 * 删除系统文件类型信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean deleteSysFiletypeByIds(String[] ids) {
		boolean bool = false;
		try {
			if (ids != null && ids.length > 0) {
				for (int i = 0; i < ids.length; i++) {
					this.deleteSysFiletypeById(ids[i]);
				}
			}
			bool = true;
		} catch (Exception e) {
			bool = false;
		}
		return bool;
	}

}
