package com.wingo.wbase.service;

import java.util.List;

import com.wingo.wbase.common.base.BaseServiceImpl;
import com.wingo.wbase.dao.WbaseRoleDao;
import com.wingo.wbase.model.WbaseRole;
import com.wingo.wbase.web.form.WbaseRoleForm;

/**
 * @Title: WbaseRoleService.java
 * @Package com.wingo.wbase.service;
 * @Description: 组织对象SERVICE
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */
public class WbaseRoleService extends BaseServiceImpl {
	private WbaseRoleDao wbaseRoleDao;
 
	public void setWbaseRoleDao(WbaseRoleDao wbaseRoleDao) {
		this.wbaseRoleDao = wbaseRoleDao;
	}

	/**
	 * 获取所有角色数据集合
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public List<WbaseRole> getRoleList() {
		return wbaseRoleDao.getRoleList();
	}
	
	/**
	 * 查找角色信息 BY RoleNo
	 * 
	 * @param id
	 * @return
	 */
	public WbaseRole findRoleByRoleNo(String roleNo) {
		return wbaseRoleDao.findRoleByRoleNo(roleNo);
	}

	/**
	 * 获取查询角色数据集合
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public List getRoleListByOther(WbaseRoleForm form, int pageSize,
			int startRow) {
		return wbaseRoleDao.getRoleListByOther(form, pageSize, startRow);
	}

	/**
	 * 获取总记录数
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public int getTotalByOther(WbaseRoleForm form) {
		return wbaseRoleDao.getTotalByOther(form);
	}

	/**
	 * 创建角色
	 * 
	 * @param Role
	 */
	public boolean createRole(WbaseRole Role) {
		return wbaseRoleDao.createRole(Role);
	}

	/**
	 * 修改角色
	 * 
	 * @param Role
	 */
	public void updateRole(WbaseRole Role) {
		wbaseRoleDao.updateRole(Role);
	}

	/**
	 * 查找角色信息 BY ID
	 * 
	 * @param id
	 * @return
	 */
	public WbaseRole findRoleById(String id) {
		return wbaseRoleDao.findRoleById(id);
	}
	
	/**
	 * 删除角色信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean deleteRoleById(String id) {
		return wbaseRoleDao.deleteRoleById(id);
	}

	/**
	 * 删除角色信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean deleteRoleByIds(String[] ids) {
		return wbaseRoleDao.deleteRoleByIds(ids);
	}

}
