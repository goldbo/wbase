package com.wingo.wbase.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wingo.wbase.common.base.BaseDAOHibernate;
import com.wingo.wbase.model.WbaseRoleObj;

/**
 * @Title: WbaseRoleObjDao.java
 * @Package com.wingo.wbase.dao;
 * @Description: 角色对象DAO
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */

public class WbaseRoleObjDao extends BaseDAOHibernate {
	private static final Log log = LogFactory.getLog(WbaseRoleObjDao.class);

	protected Class getModelClass() {
		return WbaseRoleObj.class;
	}

	/**
	 * 获取所有角色信息的集合 后台使用
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<WbaseRoleObj> getRoleObjList() {
		List<WbaseRoleObj> RoleObjList = new ArrayList<WbaseRoleObj>();
		List oList = this.doFind("from WbaseRoleObj ");
		RoleObjList = oList;
		return RoleObjList;
	}


	/**
	 * 查找角色信息 BY RoleObjNo
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<WbaseRoleObj> findRoleObjByObjNo(String objType,String objNo) {

		List<WbaseRoleObj> list = new ArrayList<WbaseRoleObj>();
		String params[] = { "objType", "objNo" };
		String values[] = { objType, objNo };
		List<WbaseRoleObj> doFindObjectListByParam = (List<WbaseRoleObj>) this
				.doFindObjectListByParams(
						"from WbaseRoleObj o where o.objType=:objType and o.objNo=:objNo", params,
						values);
		list = doFindObjectListByParam;
		return list;
	}
	
	/**
	 * 删除角色对象 
	 * @param objType 对象类型
	 * @param roleNo 角色编号
	 */
	@SuppressWarnings("unchecked")
	public void deleteRoleObjByObjNo(String objType,String objNo) {

		List<WbaseRoleObj> list = new ArrayList<WbaseRoleObj>();
		String params[] = { "objType", "objNo" };
		String values[] = { objType, objNo };
		List<WbaseRoleObj> doFindObjectListByParam = (List<WbaseRoleObj>) this
				.doFindObjectListByParams(
						"from WbaseRoleObj o where o.objType=:objType and o.objNo=:objNo", params,
						values);
		list = doFindObjectListByParam;
		if (list != null && !list.isEmpty()) {
				this.doDeleteObjects(list);
		}
	}
	
	/**
	 * 删除角色对象 
	 * @param objType 对象类型
	 * @param roleNo 角色编号
	 */
	@SuppressWarnings("unchecked")
	public void deleteRoleObjByRoleNo(String objType,String roleNo) {

		List<WbaseRoleObj> list = new ArrayList<WbaseRoleObj>();
		String params[] = { "objType", "roleNo" };
		String values[] = { objType, roleNo };
		List<WbaseRoleObj> doFindObjectListByParam = (List<WbaseRoleObj>) this
				.doFindObjectListByParams(
						"from WbaseRoleObj o where o.objType=:objType and o.roleNo=:roleNo", params,
						values);
		list = doFindObjectListByParam;
		if (list != null && !list.isEmpty()) {
				this.doDeleteObjects(list);
		}
	}
	
	/**
	 * 查看角色用户信息 BY roleNo
	 * @param objType
	 * @param roleNo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<WbaseRoleObj> findRoleObjByRoleNo(String objType,String roleNo) {

		List<WbaseRoleObj> list = new ArrayList<WbaseRoleObj>();
		String params[] = { "objType", "roleNo" };
		String values[] = { objType, roleNo };
		List<WbaseRoleObj> doFindObjectListByParam = (List<WbaseRoleObj>) this
				.doFindObjectListByParams(
						"from WbaseRoleObj o where o.objType=:objType and o.roleNo=:roleNo", params,
						values);
		list = doFindObjectListByParam;
		return list;
	}
	
	/**
	 * 更新 角色－用户－组织信息
	 * @param objIds
	 * @param objType
	 * @param roleNo
	 * @return
	 */
	public boolean updateRoleObjByObjIds(String[] objIds, String objType,String roleNo) {
		int max = objIds.length;
		this.deleteRoleObjByRoleNo(objType,roleNo);
		if(max>0){
			for(int i = 0 ;i<max ;i++){
				String objNo = objIds[i];
				WbaseRoleObj roleObj = new WbaseRoleObj();
				roleObj.setObjNo(objNo);
				roleObj.setObjType(objType);
				roleObj.setRoleNo(roleNo);
				roleObj.setCreateDate(new Date());
				this.doCreateObject(roleObj);
			}
		}
		return true;
	}

}
