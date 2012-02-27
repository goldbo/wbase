package com.wingo.wbase.service;

import java.util.List;

import com.wingo.wbase.common.base.BaseServiceImpl;
import com.wingo.wbase.dao.WbaseResourceDao;
import com.wingo.wbase.model.WbaseResource;
/**
 * @Title: WbaseResourceService.java
 * @Package com.wingo.wbase.service;
 * @Description: 资源SERVICE
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */
public class WbaseResourceService extends BaseServiceImpl {
	private WbaseResourceDao wbaseResourceDao;

	public void setWbaseResourceDao(WbaseResourceDao wbaseResourceDao) {
		this.wbaseResourceDao = wbaseResourceDao;
	}
	
	/**
	 * 返回所有资源信息集合
	 * @return
	 */
	public List<WbaseResource> getResourceList(){
		return wbaseResourceDao.getResourceList();
	}
	
	/**
	 * 返回子节点信息
	 * @return
	 */
	public List<WbaseResource> getResourceListBySubNodeNo(Long subNodeNo){
		return wbaseResourceDao.getResourceListBySubNodeNo(subNodeNo);
	}
	
	/**
	 * 创建资源
	 * @param Resource
	 */
	public boolean createResource(WbaseResource Resource) {
		return wbaseResourceDao.createResource(Resource);
	}

	/**
	 * 修改资源
	 * @param Resource
	 */
	public void updateResource(WbaseResource Resource) {
		wbaseResourceDao.updateResource(Resource);
	}

	/**
	 * 查找资源信息 BY ID
	 * @param id
	 * @return
	 */
	public WbaseResource findResourceById(String id) {
		return wbaseResourceDao.findResourceById(id);
	}
	
	/**
	 * 查找资源信息 BYNO
	 * @param id
	 * @return
	 */
	public WbaseResource findResourceByNodeNo(Long nodeNo) {
		return wbaseResourceDao.findResourceByNodeNo(nodeNo);
	}
	
	/**
	 * 查找资源信息 BYNO
	 * @param id
	 * @return
	 */
	public WbaseResource findResourceByResNo(String resNo) {
		return wbaseResourceDao.findResourceByResNo(resNo);
	}

	/**
	 * 删除资源信息
	 * @param list
	 * @return
	 */
	public String deleteResource(String ResourceNoIds) {
		return wbaseResourceDao.deleteResource(ResourceNoIds);
	}
	
	/**
	 * 删除资源信息
	 * @param id
	 * @return
	 */
	public void deleteResourceById(String id) {
		wbaseResourceDao.deleteResourceById(id);
	}
	
}
