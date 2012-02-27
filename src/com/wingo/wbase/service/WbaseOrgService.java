package com.wingo.wbase.service;

import java.util.List;

import com.wingo.wbase.common.base.BaseServiceImpl;
import com.wingo.wbase.dao.WbaseOrgDao;
import com.wingo.wbase.model.WbaseOrg;
/**
 * @Title: WbaseOrgService.java
 * @Package com.wingo.wbase.service;
 * @Description: 组织对象SERVICE
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */
public class WbaseOrgService extends BaseServiceImpl {
	private WbaseOrgDao wbaseOrgDao;

	public void setWbaseOrgDao(WbaseOrgDao wbaseOrgDao) {
		this.wbaseOrgDao = wbaseOrgDao;
	}
	
	/**
	 * 返回所有组织对象信息集合
	 * @return
	 */
	public List<WbaseOrg> getOrgList(){
		return wbaseOrgDao.getOrgList();
	}
	/**
	 * 创建组织对象
	 * @param org
	 */
	public boolean createOrg(WbaseOrg org) {
		return wbaseOrgDao.createOrg(org);
	}

	/**
	 * 修改组织对象
	 * @param org
	 */
	public void updateOrg(WbaseOrg org) {
		wbaseOrgDao.updateOrg(org);
	}

	/**
	 * 查找组织对象信息 BY ID
	 * @param id
	 * @return
	 */
	public WbaseOrg findOrgById(String id) {
		return wbaseOrgDao.findOrgById(id);
	}
	
	/**
	 * 查找组织对象信息 BY orgNo
	 * @param orgNo
	 * @return
	 */
	public WbaseOrg findOrgByOrgNo(String orgNo) {
		return wbaseOrgDao.findOrgByOrgNo(orgNo);
	}
	
	/**
	 * 查找组织对象信息 BY nodeNo
	 * @param nodeNo
	 * @return
	 */
	public WbaseOrg findOrgByNodeNo(Long nodeNo) {
		return wbaseOrgDao.findOrgByNodeNo(nodeNo);
	}

	/**
	 * 删除组织对象信息
	 * @param list
	 * @return
	 */
	public String deleteOrg(String orgNoIds) {
		return wbaseOrgDao.deleteOrg(orgNoIds);
	}
	
	/**
	 * 删除组织对象信息
	 * @param id
	 * @return
	 */
	public void deleteOrgById(String id) {
		 wbaseOrgDao.deleteOrgById(id);
	}
}
