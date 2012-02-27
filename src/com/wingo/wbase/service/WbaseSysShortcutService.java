package com.wingo.wbase.service;

import java.util.List;

import com.wingo.wbase.common.base.BaseServiceImpl;
import com.wingo.wbase.dao.WbaseSysShortcutDao;
import com.wingo.wbase.model.WbaseSysShortcut;

/**
 * @Title: WbaseSysShortcutService.java
 * @Package com.wingo.wbase.service;
 * @Description: 系统基础配置－快捷菜单配置SERVICE
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */
public class WbaseSysShortcutService extends BaseServiceImpl {
	private WbaseSysShortcutDao wbaseSysShortcutDao;

	public void setWbaseSysShortcutDao(WbaseSysShortcutDao wbaseSysShortcutDao) {
		this.wbaseSysShortcutDao = wbaseSysShortcutDao;
	}

	/**
	 * 获取快捷菜单
	 * 
	 * @return
	 */
	public List<WbaseSysShortcut> getSysShortcut() {
		return wbaseSysShortcutDao.getSysShortcut();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public WbaseSysShortcut findSysShortcutById(String id) {
		return wbaseSysShortcutDao.findSysShortcutById(id);
	}
	
	/**
	 * 查找快捷菜单信息 BY nodeNo
	 * 
	 * @param nodeNo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public void deleteCutByNodeNo(Long cutNodeNo) {
		wbaseSysShortcutDao.deleteCutByNodeNo(cutNodeNo);
	}

	/**
	 * 更新 快捷菜单信息 BY ID
	 * 
	 * @return
	 */
	public boolean updateSysShortcutByNodes(String[] nodes, String account) {
		return wbaseSysShortcutDao.updateSysShortcutByNodes(nodes, account);
	}

}
