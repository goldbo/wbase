package com.wingo.wbase.service;

import java.util.List;

import com.wingo.wbase.common.base.BaseServiceImpl;
import com.wingo.wbase.dao.WbaseOrgUserDao;
import com.wingo.wbase.model.WbaseOrgUser;

/**
 * @Title: WbaseOrgUserService.java
 * @Package com.wingo.wbase.service;
 * @Description: 组织用户SERVICE
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */
public class WbaseOrgUserService extends BaseServiceImpl {
	private WbaseOrgUserDao wbaseOrgUserDao;

	public void setWbaseOrgUserDao(WbaseOrgUserDao wbaseOrgUserDao) {
		this.wbaseOrgUserDao = wbaseOrgUserDao;
	}
	
	/**
	 * 设置组织用户
	 * @param OrgUser
	 * @return
	 */
	public boolean createOrgUser(WbaseOrgUser OrgUser) {
		return wbaseOrgUserDao.createOrgUser(OrgUser);
	}
	
	/**
	 * 修改组织用户信息
	 * 
	 * @param user
	 */
	public void updateOrgUser(WbaseOrgUser OrgUser) {
		wbaseOrgUserDao.updateOrgUser(OrgUser);
	}

	/**
	 * 查找组织用户
	 * @param userAccount
	 * @return
	 */
	public WbaseOrgUser findOrgUserByUser(String userAccount) {
		return wbaseOrgUserDao.findOrgUserByUser(userAccount);
	}

	/**
	 * 获取所有组织用户数据集合
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public List<WbaseOrgUser> getOrgUserList() {
		return wbaseOrgUserDao.getOrgUserList();
	}
	
	/**
	 *  删除组织用户对象
	 * @param objType
	 * @param objNo
	 */
	public void deleteOrgUserByUser(String userAccount) {
		wbaseOrgUserDao.deleteOrgUserByUser(userAccount);
	}
	
	/**
	 *  删除组织用户对象
	 * @param objType
	 * @param objNo
	 */
	public void deleteOrgUserByOrgNodeNo(Long orgNodeNo) {
		wbaseOrgUserDao.deleteOrgUserByOrgNodeNo(orgNodeNo);
	}
	
	/**
	 *  更新 组织用户 
	 * @param objIds
	 * @param objType
	 * @param roleNo
	 * @return
	 */
	public boolean updateOrgUserByUserIds(String[] objIds,String OrgNo) {
		return wbaseOrgUserDao.updateOrgUserByUserIds(objIds, OrgNo);
	}

}
