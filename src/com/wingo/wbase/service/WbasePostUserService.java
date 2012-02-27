package com.wingo.wbase.service;

import java.util.List;

import com.wingo.wbase.common.base.BaseServiceImpl;
import com.wingo.wbase.dao.WbasePostUserDao;
import com.wingo.wbase.model.WbasePostUser;

/**
 * @Title: WbasePostUserService.java
 * @Package com.wingo.wbase.service;
 * @Description: 岗位用户SERVICE
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */
public class WbasePostUserService extends BaseServiceImpl {
	private WbasePostUserDao wbasePostUserDao;

	public void setWbasePostUserDao(WbasePostUserDao wbasePostUserDao) {
		this.wbasePostUserDao = wbasePostUserDao;
	}
	
	/**
	 * 设置岗位用户
	 * @param postUser
	 * @return
	 */
	public boolean createPostUser(WbasePostUser postUser) {
		return wbasePostUserDao.createPostUser(postUser);
	}
	
	/**
	 * 修改岗位用户信息
	 * 
	 * @param user
	 */
	public void updatePostUser(WbasePostUser postUser) {
		wbasePostUserDao.updatePostUser(postUser);
	}

	/**
	 * 查找岗位用户
	 * @param userAccount
	 * @return
	 */
	public WbasePostUser findPostUserByUser(String userAccount) {
		return wbasePostUserDao.findPostUserByUser(userAccount);
	}

	/**
	 * 获取所有岗位用户数据集合
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public List<WbasePostUser> getPostUserList() {
		return wbasePostUserDao.getPostUserList();
	}
	
	/**
	 *  删除岗位用户对象
	 * @param objType
	 * @param objNo
	 */
	public void deletePostUserByUser(String userAccount) {
		wbasePostUserDao.deletePostUserByUser(userAccount);
	}
	
	/**
	 *  删除岗位用户对象
	 * @param objType
	 * @param objNo
	 */
	public void deletePostUserByPostNo(String postNo) {
		wbasePostUserDao.deletePostUserByPostNo(postNo);
	}
	
	/**
	 *  更新 岗位用户－用户－组织信息
	 * @param objIds
	 * @param objType
	 * @param roleNo
	 * @return
	 */
	public boolean updatePostUserByUserIds(String[] objIds,String postNo) {
		return wbasePostUserDao.updatePostUserByUserIds(objIds, postNo);
	}

}
