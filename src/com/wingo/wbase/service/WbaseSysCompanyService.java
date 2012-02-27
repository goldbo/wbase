package com.wingo.wbase.service;

import com.wingo.wbase.common.base.BaseServiceImpl;
import com.wingo.wbase.dao.WbaseSysCompanyDao;
import com.wingo.wbase.model.WbaseSysCompany;

/**
 * @Title: WbaseSysCompanyService.java
 * @Package com.wingo.wbase.service;
 * @Description: 系统基础配置－企业信息配置SERVICE
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */
public class WbaseSysCompanyService extends BaseServiceImpl {
	private WbaseSysCompanyDao wbaseSysCompanyDao;

	public void setWbaseSysCompanyDao(WbaseSysCompanyDao wbaseSysCompanyDao) {
		this.wbaseSysCompanyDao = wbaseSysCompanyDao;
	}

	/**
	 * 获取企业
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public WbaseSysCompany getSysCompany() {
		return wbaseSysCompanyDao.getSysCompany();
	}

	/**
	 * 创建岗位
	 * 
	 * @param Post
	 */
	public boolean createSysCompany(WbaseSysCompany SysCompany) {
		return wbaseSysCompanyDao.createSysCompany(SysCompany);
	}

	/**
	 * 修改岗位
	 * 
	 * @param SysCompany
	 */
	public void updateSysCompany(WbaseSysCompany SysCompany) {
		wbaseSysCompanyDao.updateSysCompany(SysCompany);
	}

	/**
	 * 查找 企业信息 BY ID
	 * 
	 * @param id
	 * @return
	 */
	public WbaseSysCompany findSysCompanyById(String id) {
		return wbaseSysCompanyDao.findSysCompanyById(id);
	}

}
