package com.wingo.wbase.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wingo.wbase.common.base.BaseDAOHibernate;
import com.wingo.wbase.common.helper.SystemCacheHelper;
import com.wingo.wbase.model.WbaseSysCompany;

/**
 * @Title: WbaseSysCompanyDao.java
 * @Package com.wingo.wbase.dao;
 * @Description: 系统基础配置－企业信息配置DAO
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */

public class WbaseSysCompanyDao extends BaseDAOHibernate {
	private static final Log log = LogFactory.getLog(WbaseSysCompanyDao.class);

	protected Class getModelClass() {
		return WbaseSysCompany.class;
	}

	/**
	 * 获取企业
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public WbaseSysCompany getSysCompany() {
		List<WbaseSysCompany> list = new ArrayList<WbaseSysCompany>();
		List oList = this.doFind("from WbaseSysCompany");
		list = oList;
		WbaseSysCompany com = null;
		if (list != null && !list.isEmpty()) {
			com = list.get(0);
		}
		return com;
	}
	
	/**
	 * 创建企业
	 * 
	 * @param Post
	 */
	public boolean createSysCompany(WbaseSysCompany SysCompany) {
		boolean bool =this.doCreateObjectReturn(SysCompany);
		SystemCacheHelper.updateSysCompanyCache();
		return bool;
	}

	/**
	 * 修改企业
	 * 
	 * @param SysCompany
	 */
	public void updateSysCompany(WbaseSysCompany SysCompany) {
		this.doUpdateObject(SysCompany);
		SystemCacheHelper.updateSysCompanyCache();
	}

	/**
	 * 查找企业信息 BY ID
	 * 
	 * @param id
	 * @return
	 */
	public WbaseSysCompany findSysCompanyById(String id) {
		WbaseSysCompany SysCompany = (WbaseSysCompany) this.doFindObjectById(id);
		return SysCompany;
	}

}
