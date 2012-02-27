package com.wingo.wbase.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wingo.wbase.common.base.BaseDAOHibernate;
import com.wingo.wbase.common.helper.PowerHelper;
import com.wingo.wbase.model.WbaseRole;
import com.wingo.wbase.web.form.WbaseRoleForm;

/**
 * @Title: WbaseRoleDao.java
 * @Package com.wingo.wbase.dao;
 * @Description: 角色DAO
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */

public class WbaseRoleDao extends BaseDAOHibernate {
	private static final Log log = LogFactory.getLog(WbaseRoleDao.class);

	protected Class getModelClass() {
		return WbaseRole.class;
	}

	/**
	 * 获取所有角色信息的集合 后台使用
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<WbaseRole> getRoleList() {
		List<WbaseRole> RoleList = new ArrayList<WbaseRole>();
		List oList = this.doFind("from WbaseRole r order by r.viewOrder");
		RoleList = oList;
		return RoleList;
	}
	
	/**
	 * 获取总数
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public int getTotalByOther(WbaseRoleForm form) {
		StringBuffer query = new StringBuffer();
		// 根据角色编号 
		query.append("from WbaseRole o where 1=1 \n");
		if (form.getRoleNo().trim().length()>0) {
			query.append(" and o.roleNo like '%" + form.getRoleNo().trim()
					+ "%' \n");
		}
		// 根据角色名称
		if (form.getRoleName().trim().length()>0) {
			query.append(" and o.roleName like '%" + form.getRoleName().trim()
					+ "%' \n");
		}
		
//		 根据是否有效查询
		if (form.getIsFlag() == 0 || form.getIsFlag() == 1) {
			query.append(" and o.isFlag = " + form.getIsFlag() + " \n");
		}
		
		int total = super.getRowsByHQL("select count(*) " + query.toString());
		
		return total;
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

		StringBuffer query = new StringBuffer();
		// 根据角色编号 
		query.append("from WbaseRole o where 1=1 \n");
		if (form.getRoleNo().trim().length()>0) {
			query.append(" and o.roleNo like '%" + form.getRoleNo().trim()
					+ "%' \n");
		}
		// 根据角色名称
		if (form.getRoleName().trim().length()>0) {
			query.append(" and o.roleName like '%" + form.getRoleName().trim()
					+ "%' \n");
		}
		
//		 根据是否有效查询
		if (form.getIsFlag() == 0 || form.getIsFlag() == 1) {
			query.append(" and o.isFlag = " + form.getIsFlag() + " \n");
		}
		
		query.append(" order by o.viewOrder ");
		List datas = super.doFind(query.toString(), pageSize, startRow);

		return datas;
	}

	/**
	 * 创建角色
	 * 
	 * @param Role
	 */
	public boolean createRole(WbaseRole Role) {
		return this.doCreateObjectReturn(Role);
	}

	/**
	 * 修改角色
	 * 
	 * @param Role
	 */
	public void updateRole(WbaseRole Role) {
		this.doUpdateObject(Role);
	}

	/**
	 * 查找角色信息 BY ID
	 * 
	 * @param id
	 * @return
	 */
	public WbaseRole findRoleById(String id) {
		WbaseRole Role = (WbaseRole) this.doFindObjectById(id);
		return Role;
	}

	/**
	 * 查找角色信息 BY RoleNo
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public WbaseRole findRoleByRoleNo(String roleNo) {

		List<WbaseRole> list = new ArrayList<WbaseRole>();
		List<WbaseRole> doFindObjectListByParam = (List<WbaseRole>) this
				.doFindObjectListByParam(
						"from WbaseRole o where o.roleNo=:roleNo", "roleNo",
						roleNo);
		list = doFindObjectListByParam;
		WbaseRole Role = null;
		if (list != null && !list.isEmpty()) {
			Role = list.get(0);
		}
		return Role;
	}

	/**
	 * 删除角色信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean deleteRoleById(String id) {
		boolean bool = false;
		try {
			WbaseRole Role = this.findRoleById(id);
			PowerHelper.deleteRoleObjByObjNo("org", Role.getRoleNo());
			PowerHelper.deleteRoleObjByObjNo("user", Role.getRoleNo());
			this.doDeleteObject(Role);
			bool = true;
		} catch (Exception e) {
			bool = false;
		}
		return bool;
	}

	/**
	 * 删除角色信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean deleteRoleByIds(String[] ids) {
		boolean bool = false;
		try {
			if (ids != null && ids.length > 0) {
				for (int i = 0; i < ids.length; i++) {
					this.deleteRoleById(ids[i]);
				}
			}
			bool = true;
		} catch (Exception e) {
			bool = false;
		}
		return bool;
	}

}
