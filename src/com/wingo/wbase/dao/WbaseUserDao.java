package com.wingo.wbase.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wingo.wbase.common.Constants;
import com.wingo.wbase.common.base.BaseDAOHibernate;
import com.wingo.wbase.common.helper.PowerHelper;
import com.wingo.wbase.model.ViewUserInfo;
import com.wingo.wbase.model.WbaseUser;
import com.wingo.wbase.web.form.WbaseUserForm;

/**
 * @Title: WbaseUserDao.java
 * @Package com.wingo.wbase.dao;
 * @Description: 用户DAO
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */

public class WbaseUserDao extends BaseDAOHibernate {
	private static final Log log = LogFactory.getLog(WbaseUserDao.class);

	protected Class getModelClass() {
		return WbaseUser.class;
	}

	/**
	 * 获取所有用户信息的集合 后台使用
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<WbaseUser> getUserList() {
		List<WbaseUser> userList = new ArrayList<WbaseUser>();
		List oList = this.doFind("from WbaseUser order by account");
		userList = oList;
		return userList;
	}

	/**
	 * 获取查询用户数据集合
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public List getUserInfoListByOther(WbaseUserForm form, int pageSize,
			int startRow) {

		StringBuffer query = new StringBuffer();
		// 根据账号查询
		query.append("from ViewUserInfo o where 1=1 \n");
		if (form.getAccount().trim().length()>0) {
			query.append(" and o.account like '%" + form.getAccount().trim()
					+ "%' \n");
		}
		// 根据姓名查询
		if (form.getUserName().trim().length()>0) {
			query.append(" and o.userName like '%" + form.getUserName().trim()
					+ "%' \n");
		}
		// 根据是否有效查询
		if (form.getIsFlag() == 0 || form.getIsFlag() == 1) {
			query.append(" and o.isFlag = " + form.getIsFlag() + " \n");
		}
		// 根据组织查询
		if (form.getOrgNodeNo()!=null) {
			query.append(" and o.orgNodeNo = " + form.getOrgNodeNo() + " \n");
		}
		query.append(" order by o.account ");
		List datas = super.doFind(query.toString(), pageSize, startRow);

		return datas;
	}

	/**
	 * 获取总数
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public int getTotalByOther(WbaseUserForm form) {

		StringBuffer query = new StringBuffer();
		// 根据账号查询
		query.append("from ViewUserInfo o where 1=1 \n");
		if (form.getAccount().trim().length()>0) {
			query.append(" and o.account like '%" + form.getAccount().trim()
					+ "%' \n");
		}
		// 根据姓名查询
		if (form.getUserName().trim().length()>0) {
			query.append(" and o.userName like '%" + form.getUserName().trim()
					+ "%' \n");
		}
		// 根据是否有效查询
		if (form.getIsFlag() == 0 || form.getIsFlag() == 1) {
			query.append(" and o.isFlag = " + form.getIsFlag() + " \n");
		}
		// 根据组织查询
		if (form.getOrgNodeNo()!=null) {
			query.append(" and o.orgNodeNo = " + form.getOrgNodeNo() + " \n");
		}

		int total = super.getRowsByHQL("select count(*) " + query.toString());

		return total;
	}

	/**
	 * 获取查询用户数据集合
	 * 
	 * @param account
	 * @param userName
	 * @param orgNo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ViewUserInfo> getNoOrgUserList(String account, String userName,
			Long orgNodeNo) {

		StringBuffer query = new StringBuffer();
		// 根据账号查询
		query.append("from ViewUserInfo o where 1=1 \n");
		if (account.trim().length()>0) {
			query.append(" and o.account like '%" + account.trim() + "%' \n");
		}
		// 根据姓名查询
		if (userName.trim().length()>0) {
			query.append(" and o.userName like '%" + userName.trim() + "%' \n");
		}
		// 根据组织查询
		if (orgNodeNo!=null) {
			query.append(" and o.orgNodeNo <> " + orgNodeNo + " \n");
		}

		query.append(" order by o.account ");
		List<ViewUserInfo> userList = new ArrayList<ViewUserInfo>();
		List datas = super.doFind(query.toString());
		userList = datas;
		return userList;
	}

	/**
	 * 创建用户
	 * 
	 * @param user
	 */
	public boolean createUser(WbaseUser user) {
		return this.doCreateObjectReturn(user);
	}

	/**
	 * 修改用户
	 * 
	 * @param user
	 */
	public void updateUser(WbaseUser user) {
		this.doUpdateObject(user);
	}

	/**
	 * 查找用户信息 BY ID
	 * 
	 * @param id
	 * @return
	 */
	public WbaseUser findUserById(String id) {
		WbaseUser user = (WbaseUser) this.doFindObjectById(id);
		return user;
	}

	/**
	 * 查找用户信息 BY userNo
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public WbaseUser findUserByAccount(String account) {

		List<WbaseUser> list = new ArrayList<WbaseUser>();
		List<WbaseUser> doFindObjectListByParam = (List<WbaseUser>) this
				.doFindObjectListByParam(
						"from WbaseUser o where o.account=:account", "account",
						account);
		list = doFindObjectListByParam;
		WbaseUser user = null;
		if (list != null && !list.isEmpty()) {
			user = list.get(0);
		}
		return user;
	}

	/**
	 * 删除用户信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean deleteUserById(String id) {
		boolean bool = false;
		try {
			WbaseUser user = this.findUserById(id);
			if (!user.getAccount().equals(Constants.WBASE_SYS_ADMIN)) {
				this.doDeleteObject(user);
				PowerHelper.deleteRoleObjByObjNo("user", user.getAccount());
				PowerHelper.deletePostUserByUser(user.getAccount());
			}
			bool = true;
		} catch (Exception e) {
			bool = false;
		}
		return bool;
	}

	/**
	 * 删除用户信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean deleteUserByIds(String[] ids) {
		boolean bool = false;
		try {
			if (ids != null && ids.length > 0) {
				for (int i = 0; i < ids.length; i++) {
					this.deleteUserById(ids[i]);
				}
			}
			bool = true;
		} catch (Exception e) {
			bool = false;
		}
		return bool;
	}

	/**
	 * 获取所有用户信息的集合 后台使用
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ViewUserInfo> getViewUserInfoList() {
		List<ViewUserInfo> userList = new ArrayList<ViewUserInfo>();
		List oList = this.doFind("from ViewUserInfo v order by v.account");
		userList = oList;
		return userList;
	}

	/**
	 * 查找用户信息 BY ID
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ViewUserInfo findUserInfoById(String id) {
		List<ViewUserInfo> list = new ArrayList<ViewUserInfo>();
		List<ViewUserInfo> doFindObjectListByParam = (List<ViewUserInfo>) this
				.doFindObjectListByParam(
						"from ViewUserInfo o where o.id.uid=:uid", "uid", id);
		list = doFindObjectListByParam;
		ViewUserInfo user = null;
		if (list != null && !list.isEmpty()) {
			user = list.get(0);
		}
		return user;
	}

	/**
	 * 用户登录验证
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ViewUserInfo findUserByLogin(String account, String userPwd) {

		List<ViewUserInfo> list = new ArrayList<ViewUserInfo>();
		String params[] = { "account", "userPwd" };
		String values[] = { account, userPwd };
		List<ViewUserInfo> doFindObjectListByParam = (List<ViewUserInfo>) this
				.doFindObjectListByParams(
						"from ViewUserInfo o where o.account=:account and o.userPwd=:userPwd and o.isFlag = 1",
						params, values);
		list = doFindObjectListByParam;
		ViewUserInfo user = null;
		if (list != null && !list.isEmpty()) {
			user = list.get(0);
		}
		return user;
	}

	/**
	 * 查找角色信息 BY roleNo
	 * @param objType
	 * @param roleNo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ViewUserInfo> findUserInfoByRoleNo(String roleNo) {

		List<ViewUserInfo> list = new ArrayList<ViewUserInfo>();
		List<ViewUserInfo> doFindObjectListByParam = (List<ViewUserInfo>) this
				.doFindObjectListByParam(
						"from ViewUserInfo o where o.roleNo=:roleNo", "roleNo", roleNo);
		list = doFindObjectListByParam;
		return list;
	}
	
	/**
	 * 查找角色信息 BY postNo
	 * @param objType
	 * @param roleNo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ViewUserInfo> findUserInfoByPostNo(String postNo) {

		List<ViewUserInfo> list = new ArrayList<ViewUserInfo>();
		List<ViewUserInfo> doFindObjectListByParam = (List<ViewUserInfo>) this
				.doFindObjectListByParam(
						"from ViewUserInfo o where o.postNo=:postNo", "postNo", postNo);
		list = doFindObjectListByParam;
		return list;
	}
	
	/**
	 * 删除组织用户信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean updateOrgUserByIds(String[] ids, Long orgNodeNo) {
		boolean bool = false;
		try {
			if (ids != null && ids.length > 0) {
				for (int i = 0; i < ids.length; i++) {
					PowerHelper.updateOrgUser(ids[i], orgNodeNo);
				}
			}
			bool = true;
		} catch (Exception e) {
			bool = false;
		}
		return bool;
	}
}
