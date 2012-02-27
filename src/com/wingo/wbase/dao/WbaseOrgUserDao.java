package com.wingo.wbase.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wingo.wbase.common.base.BaseDAOHibernate;
import com.wingo.wbase.model.WbaseOrgUser;

/**
 * @Title: WbaseOrgUserDao.java
 * @Package com.wingo.wbase.dao;
 * @Description: 组织用户DAO
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */

public class WbaseOrgUserDao extends BaseDAOHibernate {
	private static final Log log = LogFactory.getLog(WbaseOrgUserDao.class);

	protected Class getModelClass() {
		return WbaseOrgUser.class;
	}
	
	/**
	 * 设置组织用户
	 * @param OrgUser
	 * @return
	 */
	public boolean createOrgUser(WbaseOrgUser OrgUser) {
		return this.doCreateObjectReturn(OrgUser);
	}
	
	/**
	 * 修改组织用户信息
	 * 
	 * @param user
	 */
	public void updateOrgUser(WbaseOrgUser OrgUser) {
		this.doUpdateObject(OrgUser);
	}

	/**
	 * 获取所有角色信息的集合 后台使用
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<WbaseOrgUser> getOrgUserList() {
		List<WbaseOrgUser> OrgUserList = new ArrayList<WbaseOrgUser>();
		List oList = this.doFind("from WbaseOrgUser ");
		OrgUserList = oList;
		return OrgUserList;
	}


	/**
	 * 查找角色信息 BY OrgUserNo
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public WbaseOrgUser findOrgUserByUser(String userAccount) {

		List<WbaseOrgUser> list = new ArrayList<WbaseOrgUser>();
		List<WbaseOrgUser> doFindObjectListByParam = (List<WbaseOrgUser>) this
				.doFindObjectListByParam(
						"from WbaseOrgUser o where o.userAccount=:userAccount ", "userAccount",
						userAccount);
		list = doFindObjectListByParam;
		WbaseOrgUser OrgUser = null;
		if (list != null && !list.isEmpty()) {
			OrgUser = list.get(0);
		}
		return OrgUser;
	}
	
	/**
	 * 删除组织用户 
	 * @param userAccount  
	 */
	@SuppressWarnings("unchecked")
	public void deleteOrgUserByUser(String userAccount) {

		List<WbaseOrgUser> list = new ArrayList<WbaseOrgUser>();
		List<WbaseOrgUser> doFindObjectListByParam = (List<WbaseOrgUser>) this
				.doFindObjectListByParam(
						"from WbaseOrgUser o where o.userAccount=:userAccount ", "userAccount",
						userAccount);
		list = doFindObjectListByParam;
		if (list != null && !list.isEmpty()) {
				this.doDeleteObjects(list);
		}
	}
	
	/**
	 * 删除组织用户 
	 * @param objType 对象类型
	 * @param roleNo 角色编号
	 */
	@SuppressWarnings("unchecked")
	public void deleteOrgUserByOrgNodeNo(Long orgNodeNo) {

		List<WbaseOrgUser> list = new ArrayList<WbaseOrgUser>();
		List<WbaseOrgUser> doFindObjectListByParam = (List<WbaseOrgUser>) this
				.doFindObjectListByParam(
						"from WbaseOrgUser o where o.orgNodeNo=:orgNodeNo ", "orgNodeNo",
						orgNodeNo);
		list = doFindObjectListByParam;
		if (list != null && !list.isEmpty()) {
				for(int i=0;i<list.size();i++){
					WbaseOrgUser orgUser = list.get(i);
					orgUser.setOrgNodeNo(Long.valueOf(0));
					this.updateOrgUser(orgUser);
				}
		}
	}
	
	/**
	 * 更新 设置组织成员
	 * @param objIds
	 * @param objType
	 * @param roleNo
	 * @return
	 */
	public boolean updateOrgUserByUserIds(String[] objIds, String orgNodeNo) {
		int max = objIds.length;
//		this.deleteOrgUserByOrgNodeNo(Long.valueOf(orgNodeNo));
		if(max>0){
			for(int i = 0 ;i<max ;i++){
				String userAccount = objIds[i];
				WbaseOrgUser OrgUser = this.findOrgUserByUser(userAccount);
				if(OrgUser==null){
					OrgUser = new WbaseOrgUser();
					OrgUser.setUserAccount(userAccount);
					OrgUser.setOrgNodeNo(Long.valueOf(orgNodeNo));
					OrgUser.setCreateDate(new Date());
					this.doCreateObject(OrgUser);
				}else{
					OrgUser.setUserAccount(userAccount);
					OrgUser.setOrgNodeNo(Long.valueOf(orgNodeNo));
					OrgUser.setCreateDate(new Date());
					this.updateOrgUser(OrgUser);
				}
			}
		}
		return true;
	}

}
