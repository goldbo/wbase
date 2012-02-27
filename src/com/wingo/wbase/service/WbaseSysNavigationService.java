package com.wingo.wbase.service;

import java.util.List;

import com.wingo.wbase.common.base.BaseServiceImpl;
import com.wingo.wbase.dao.WbaseSysNavigationDao;
import com.wingo.wbase.model.WbaseSysNavigation;
import com.wingo.wbase.web.form.WbaseSysNavigationForm;

/**
 * @Title: WbaseSysNavigationService.java
 * @Package com.wingo.wbase.service;
 * @Description: 系统底部导航对象SERVICE
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */
public class WbaseSysNavigationService extends BaseServiceImpl {
	private WbaseSysNavigationDao wbaseSysNavigationDao;

	public void setWbaseSysNavigationDao(WbaseSysNavigationDao wbaseSysNavigationDao) {
		this.wbaseSysNavigationDao = wbaseSysNavigationDao;
	}

	/**
	 * 获取所有系统底部导航数据集合
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public List<WbaseSysNavigation> getSysNavigationList() {
		return wbaseSysNavigationDao.getSysNavigationList();
	}

	/**
	 * 查找系统底部导航信息 BY SysNavigationNo
	 * 
	 * @param id
	 * @return
	 */
	public WbaseSysNavigation findSysNavigationByNavName(String navName) {
		return wbaseSysNavigationDao.findSysNavigationByNavName(navName);
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
		return wbaseSysNavigationDao.getSysNavigationListByOther(form, pageSize, startRow);
	}

	/**
	 * 获取总记录数
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public int getTotalByOther(WbaseSysNavigationForm form) {
		return wbaseSysNavigationDao.getTotalByOther(form);
	}

	/**
	 * 创建系统底部导航
	 * 
	 * @param SysNavigation
	 */
	public boolean createSysNavigation(WbaseSysNavigation SysNavigation) {
		return wbaseSysNavigationDao.createSysNavigation(SysNavigation);
	}

	/**
	 * 修改系统底部导航
	 * 
	 * @param SysNavigation
	 */
	public void updateSysNavigation(WbaseSysNavigation SysNavigation) {
		wbaseSysNavigationDao.updateSysNavigation(SysNavigation);
	}

	/**
	 * 查找系统底部导航信息 BY ID
	 * 
	 * @param id
	 * @return
	 */
	public WbaseSysNavigation findSysNavigationById(String id) {
		return wbaseSysNavigationDao.findSysNavigationById(id);
	}

	/**
	 * 删除系统底部导航信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean deleteSysNavigationById(String id) {
		return wbaseSysNavigationDao.deleteSysNavigationById(id);
	}

	/**
	 * 删除系统底部导航信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean deleteSysNavigationByIds(String[] ids) {
		return wbaseSysNavigationDao.deleteSysNavigationByIds(ids);
	}

}
