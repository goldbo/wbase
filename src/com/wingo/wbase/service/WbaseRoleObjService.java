package com.wingo.wbase.service;

import java.util.List;

import com.wingo.wbase.common.base.BaseServiceImpl;
import com.wingo.wbase.dao.WbaseRoleObjDao;
import com.wingo.wbase.model.WbaseRoleObj;

/**
 * @Title: WbaseRoleObjService.java
 * @Package com.wingo.wbase.service;
 * @Description: 角色对象SERVICE
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */
public class WbaseRoleObjService extends BaseServiceImpl {
	private WbaseRoleObjDao wbaseRoleObjDao;

	public void setWbaseRoleObjDao(WbaseRoleObjDao wbaseRoleObjDao) {
		this.wbaseRoleObjDao = wbaseRoleObjDao;
	}

	/**
	 * 获取所有角色数据集合
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public List<WbaseRoleObj> getRoleObjList() {
		return wbaseRoleObjDao.getRoleObjList();
	}
	
	/**
	 * 查找角色信息 BY objNo
	 * 
	 * @param id
	 * @return
	 */
	public List<WbaseRoleObj>  findRoleObjByObjNo(String objType,String objNo) {
		return wbaseRoleObjDao.findRoleObjByObjNo(objType,objNo);
	}
	
	/**
	 * 查看角色用户信息 BY roleNo
	 * @param objType
	 * @param roleNo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<WbaseRoleObj> findRoleObjByRoleNo(String objType,String roleNo) {
		return wbaseRoleObjDao.findRoleObjByRoleNo(objType, roleNo);
	}

	/**
	 *  删除角色对象
	 * @param objType
	 * @param objNo
	 */
	public void deleteRoleObjByObjNo(String objType,String objNo) {
		wbaseRoleObjDao.deleteRoleObjByObjNo(objType, objNo);
	}
	/**
	 *  更新 角色－用户－组织信息
	 * @param objIds
	 * @param objType
	 * @param roleNo
	 * @return
	 */
	public boolean updateRoleObjByObjIds(String[] objIds, String objType,String roleNo) {
		return wbaseRoleObjDao.updateRoleObjByObjIds(objIds, objType, roleNo);
	}

}
