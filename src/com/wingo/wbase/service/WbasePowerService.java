package com.wingo.wbase.service;

import java.util.List;
import java.util.Map;

import com.wingo.wbase.common.base.BaseServiceImpl;
import com.wingo.wbase.dao.WbasePowerDao;
import com.wingo.wbase.model.WbasePower;

/**
 * @Title: WbaseActionService.java
 * @Package com.wingo.wbase.service;
 * @Description: 组织对象SERVICE
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */
public class WbasePowerService extends BaseServiceImpl {
	private WbasePowerDao wbasePowerDao;

	public void setWbasePowerDao(WbasePowerDao wbasePowerDao) {
		this.wbasePowerDao = wbasePowerDao;
	}

	/**
	 * 获取用户所属角色权限
	 * 
	 * @param id
	 * @return
	 */
	public Map findPowerByRole(Map powerMap,String roleNo) {
		return wbasePowerDao.findPowerByRole(powerMap,roleNo);
	}

	/**
	 * 获取用户所属角色权限
	 * 
	 * @param id
	 * @return
	 */
	public List<WbasePower> findPowerByResNodeNo(Long resNodeNo) {
		return wbasePowerDao.findPowerByResNodeNo(resNodeNo);
	}

	/**
	 * 获取角色资源权限
	 * 
	 * @param id
	 * @return
	 */
	public WbasePower findPowerByRes(String roleNo, Long resNodeNo) {
		return wbasePowerDao.findPowerByRes(roleNo, resNodeNo);
	}

	/**
	 * 查找权限信息 BY ID
	 * 
	 * @param id
	 * @return
	 */
	public WbasePower findPowerById(String id) {
		return wbasePowerDao.findPowerById(id);
	}

	/**
	 * 修改权限信息
	 * 
	 * @param power
	 */
	public void updatePower(WbasePower power) {
		wbasePowerDao.updatePower(power);
	}

	/**
	 * 新增权限信息
	 * 
	 * @param power
	 */
	public String createPower(WbasePower power) {
		return wbasePowerDao.createPower(power);
	}

	/**
	 * 删除权限信息
	 * 
	 * @param power
	 */
	public void deletePower(WbasePower power) {
		wbasePowerDao.deletePower(power);
	}
	
	/**
	 * 删除权限信息 BY resNo
	 * 
	 * @param resNo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public void deletePowerByResNodeNo(Long resNodeNo) {
		wbasePowerDao.deletePowerByResNodeNo(resNodeNo);
	}
}
