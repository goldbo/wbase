package com.wingo.wbase.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wingo.wbase.common.base.BaseDAOHibernate;
import com.wingo.wbase.common.helper.PowerHelper;
import com.wingo.wbase.model.WbasePower;
import com.wingo.wbase.model.WbaseResource;

/**
 * @Title: WbaseActionDao.java
 * @Package com.wingo.wbase.dao;
 * @Description: 权限DAO
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */

public class WbasePowerDao extends BaseDAOHibernate {
	private static final Log log = LogFactory.getLog(WbasePowerDao.class);

	protected Class getModelClass() {
		return WbasePower.class;
	}

	/**
	 * 查找权限信息 BY roleNo
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map findPowerByRole(Map powerMap,String roleNo) {

		List<WbasePower> list =  new ArrayList<WbasePower>();;
		List<WbasePower> doFindObjectListByParam = (List<WbasePower>) this
				.doFindObjectListByParam(
						"from WbasePower o where o.roleNo=:roleNo", "roleNo",
						roleNo);
		list = doFindObjectListByParam;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				WbasePower power = (WbasePower)list.get(i);
				WbaseResource res = PowerHelper.findResourceByNodeNo(power.getResNodeNo());
				powerMap.put(res.getResNo(), power.getPowerLevel());
			}
		}
		return powerMap;
	}
	
	/**
	 * 查找权限信息 BY resNo
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<WbasePower> findPowerByResNodeNo(Long resNodeNo) {

		List<WbasePower> list =  new ArrayList<WbasePower>();;
		List<WbasePower> doFindObjectListByParam = (List<WbasePower>) this
				.doFindObjectListByParam(
						"from WbasePower o where o.resNodeNo=:resNodeNo", "resNodeNo",
						resNodeNo);
		list = doFindObjectListByParam;
		return list;
	}
	
	/**
	 * 
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public WbasePower findPowerByRes(String roleNo,Long resNodeNo) {

		List<WbasePower> list =  new ArrayList<WbasePower>();;
		String params[] = { "roleNo", "resNodeNo" };
		Object values[] = { roleNo, resNodeNo };
		List<WbasePower> doFindObjectListByParam = (List<WbasePower>) this
				.doFindObjectListByParams(
						"from WbasePower o where o.roleNo=:roleNo and resNodeNo=:resNodeNo ",params,
						values);
		list = doFindObjectListByParam;
		WbasePower power = null;
		if(list.size()>0){
			power = list.get(0);
		}
		return power;
	}
	
	/**
	 * 查找权限信息 BY ID
	 * 
	 * @param id
	 * @return
	 */
	public WbasePower findPowerById(String id) {
		WbasePower power = (WbasePower) this.doFindObjectById(id);
		return power;
	}
	
	/**
	 * 修改权限信息
	 * 
	 * @param power
	 */
	public void updatePower(WbasePower power) {
		this.doUpdateObject(power);
	}
	
	/**
	 * 新增权限信息
	 * 
	 * @param power
	 */
	public String createPower(WbasePower power) {
		return (String)super.doCreateObjectReturnId(power);
	}

	/**
	 * 删除权限信息
	 * 
	 * @param power
	 */
	public void deletePower(WbasePower power) {
		this.doDeleteObject(power);
	}
	
	/**
	 * 删除权限信息 BY resNo
	 * 
	 * @param resNo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public void deletePowerByResNodeNo(Long resNodeNo) {

		List<WbasePower> list = new ArrayList<WbasePower>();
		List<WbasePower> doFindObjectListByParam = (List<WbasePower>) this
				.doFindObjectListByParam(
						"from WbasePower o where o.resNodeNo=:resNodeNo", "resNodeNo",
						resNodeNo);
		list = doFindObjectListByParam;
		if(list.size()>0){
			this.doDeleteObjects(list);
		}
	}
}
