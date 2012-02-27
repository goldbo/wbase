package com.wingo.wbase.service;

import java.util.List;

import com.wingo.wbase.common.base.BaseServiceImpl;
import com.wingo.wbase.dao.WbaseUserDao;
import com.wingo.wbase.model.ViewUserInfo;
import com.wingo.wbase.model.WbaseUser;
import com.wingo.wbase.web.form.WbaseUserForm;

/**
 * @Title: WbaseUserService.java
 * @Package com.wingo.wbase.service;
 * @Description: 组织对象SERVICE
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */
public class WbaseUserService extends BaseServiceImpl {
	private WbaseUserDao wbaseUserDao;

	public void setWbaseUserDao(WbaseUserDao wbaseUserDao) {
		this.wbaseUserDao = wbaseUserDao;
	}

	/**
	 * 用户登录返回相关信息
	 * 
	 * @param id
	 * @return
	 */
	public ViewUserInfo findUserByLogin(String account,String userPwd) {
		return wbaseUserDao.findUserByLogin(account,userPwd);
	}
	
	/**
	 * 从视图获取用户信息
	 * @return
	 */
	public List<ViewUserInfo> getViewUserInfoList() {
		return wbaseUserDao.getViewUserInfoList();
	}
	
	/**
	 * 从视图获取用户信息 BY ID
	 * 
	 * @param id
	 * @return
	 */
	public ViewUserInfo findUserInfoById(String id) {
		return wbaseUserDao.findUserInfoById(id);
	}

	/**
	 * 查找用户信息 BY userNo
	 * 
	 * @param id
	 * @return
	 */
	public WbaseUser findUserByAccount(String account) {
		return wbaseUserDao.findUserByAccount(account);
	}

	/**
	 * 获取查询结果集
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public List getUserInfoListByOther(WbaseUserForm form,int pageSize,
			int startRow) {
		return wbaseUserDao.getUserInfoListByOther(form, pageSize, startRow);
	}
	
	/**
	 * 获取总记录数
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public int getTotalByOther(WbaseUserForm form) {
		return wbaseUserDao.getTotalByOther(form);
	}

	/**
	 * 返回所有用户信息集合
	 * 
	 * @return
	 */
	public List<WbaseUser> getUserList() {
		return wbaseUserDao.getUserList();
	}

	/**
	 * 创建用户
	 * 
	 * @param User
	 */
	public boolean createUser(WbaseUser user) {
		return wbaseUserDao.createUser(user);
	}

	/**
	 * 修改用户
	 * 
	 * @param User
	 */
	public void updateUser(WbaseUser user) {
		wbaseUserDao.updateUser(user);
	}

	/**
	 * 查找用户信息 BY ID
	 * 
	 * @param id
	 * @return
	 */
	public WbaseUser findUserById(String id) {
		return wbaseUserDao.findUserById(id);
	}
	
	/**
	 * 删除用户信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean deleteUserById(String id) {
		return wbaseUserDao.deleteUserById(id);
	}

	/**
	 * 删除用户信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean deleteUserByIds(String[] ids) {
		return wbaseUserDao.deleteUserByIds(ids);
	}
	
	/**
	 * 根据组织查询用户列表
	 * @param account
	 * @param userName
	 * @param orgNo
	 * @return
	 */
	public List<ViewUserInfo> getNoOrgUserList(String account,String userName,Long orgNodeNo) {
		return wbaseUserDao.getNoOrgUserList(account, userName, orgNodeNo);
	}
	
	/**
	 * 查找角色信息 BY roleNo
	 * @param objType
	 * @param roleNo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ViewUserInfo> findUserInfoByRoleNo(String roleNo) {
		return wbaseUserDao.findUserInfoByRoleNo(roleNo);
	}
	
	/**
	 * 查找角色信息 BY postNo
	 * @param objType
	 * @param roleNo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ViewUserInfo> findUserInfoByPostNo(String postNo) {
		return wbaseUserDao.findUserInfoByPostNo(postNo);
	}
	
	/**
	 * 更新组织用户信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean updateOrgUserByIds(String[] ids,Long orgNodeNo) {
		return wbaseUserDao.updateOrgUserByIds(ids,orgNodeNo);
	}
}
