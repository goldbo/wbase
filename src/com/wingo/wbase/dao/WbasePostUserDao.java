package com.wingo.wbase.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wingo.wbase.common.base.BaseDAOHibernate;
import com.wingo.wbase.model.WbasePostUser;

/**
 * @Title: WbasePostUserDao.java
 * @Package com.wingo.wbase.dao;
 * @Description: 岗位用户DAO
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */

public class WbasePostUserDao extends BaseDAOHibernate {
	private static final Log log = LogFactory.getLog(WbasePostUserDao.class);

	protected Class getModelClass() {
		return WbasePostUser.class;
	}
	
	/**
	 * 设置岗位用户
	 * @param postUser
	 * @return
	 */
	public boolean createPostUser(WbasePostUser postUser) {
		return this.doCreateObjectReturn(postUser);
	}
	
	/**
	 * 修改岗位用户信息
	 * 
	 * @param user
	 */
	public void updatePostUser(WbasePostUser postUser) {
		this.doUpdateObject(postUser);
	}

	/**
	 * 获取所有角色信息的集合 后台使用
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<WbasePostUser> getPostUserList() {
		List<WbasePostUser> PostUserList = new ArrayList<WbasePostUser>();
		List oList = this.doFind("from WbasePostUser ");
		PostUserList = oList;
		return PostUserList;
	}


	/**
	 * 查找角色信息 BY PostUserNo
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public WbasePostUser findPostUserByUser(String userAccount) {

		List<WbasePostUser> list = new ArrayList<WbasePostUser>();
		List<WbasePostUser> doFindObjectListByParam = (List<WbasePostUser>) this
				.doFindObjectListByParam(
						"from WbasePostUser o where o.userAccount=:userAccount ", "userAccount",
						userAccount);
		list = doFindObjectListByParam;
		WbasePostUser postUser = null;
		if (list != null && !list.isEmpty()) {
			postUser = list.get(0);
		}
		return postUser;
	}
	
	/**
	 * 删除岗位用户 
	 * @param userAccount  
	 */
	@SuppressWarnings("unchecked")
	public void deletePostUserByUser(String userAccount) {

		List<WbasePostUser> list = new ArrayList<WbasePostUser>();
		List<WbasePostUser> doFindObjectListByParam = (List<WbasePostUser>) this
				.doFindObjectListByParam(
						"from WbasePostUser o where o.userAccount=:userAccount ", "userAccount",
						userAccount);
		list = doFindObjectListByParam;
		if (list != null && !list.isEmpty()) {
				this.doDeleteObjects(list);
		}
	}
	
	/**
	 * 删除岗位用户 
	 * @param objType 对象类型
	 * @param roleNo 角色编号
	 */
	@SuppressWarnings("unchecked")
	public void deletePostUserByPostNo(String postNo) {

		List<WbasePostUser> list = new ArrayList<WbasePostUser>();
		List<WbasePostUser> doFindObjectListByParam = (List<WbasePostUser>) this
				.doFindObjectListByParam(
						"from WbasePostUser o where o.postNo=:postNo ", "postNo",
						postNo);
		list = doFindObjectListByParam;
		if (list != null && !list.isEmpty()) {
				this.doDeleteObjects(list);
		}
	}
	
	/**
	 * 更新 设置岗位成员
	 * @param objIds
	 * @param objType
	 * @param roleNo
	 * @return
	 */
	public boolean updatePostUserByUserIds(String[] objIds, String postNo) {
		int max = objIds.length;
		this.deletePostUserByPostNo(postNo);
		if(max>0){
			for(int i = 0 ;i<max ;i++){
				String userAccount = objIds[i];
				WbasePostUser postUser = this.findPostUserByUser(userAccount);
				if(postUser==null){
					postUser = new WbasePostUser();
					postUser.setUserAccount(userAccount);
					postUser.setPostNo(postNo);
					postUser.setCreateDate(new Date());
					this.doCreateObject(postUser);
				}else{
					postUser.setPostNo(userAccount);
					postUser.setPostNo(postNo);
					postUser.setCreateDate(new Date());
					this.updatePostUser(postUser);
				}
			}
		}
		return true;
	}

}
