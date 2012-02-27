package com.wingo.wbase.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wingo.wbase.common.base.BaseDAOHibernate;
import com.wingo.wbase.common.helper.PowerHelper;
import com.wingo.wbase.common.helper.SystemCacheHelper;
import com.wingo.wbase.model.WbaseResource;

/**
 * @Title: WbaseResourceDao.java
 * @Package com.wingo.wbase.dao;
 * @Description: 资源DAO
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */

public class WbaseResourceDao extends BaseDAOHibernate {
	private static final Log log = LogFactory.getLog(WbaseResourceDao.class);

	protected Class getModelClass() {
		return WbaseResource.class;
	}

	/**
	 * 获取所有资源信息的集合 后台使用
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<WbaseResource> getResourceList() {
		List<WbaseResource> ResourceList = new ArrayList<WbaseResource>();
		List oList = this
				.doFind("from WbaseResource order by resLevel,viewOrder");
		ResourceList = oList;
		return ResourceList;
	}
	
	/**
	 * 返回子节点信息
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<WbaseResource> getResourceListBySubNodeNo(Long subNodeNo){
		List<WbaseResource> list = null;
		List<WbaseResource> doFindObjectListByParam = (List<WbaseResource>) this.doFindObjectListByParam(
						"from WbaseResource o where o.subNodeNo=:subNodeNo order by resLevel,viewOrder", "subNodeNo", subNodeNo);
		list = doFindObjectListByParam;
		return list;
	}

	/**
	 * 创建资源
	 * 
	 * @param Resource
	 */
	public boolean createResource(WbaseResource Resource) {
		boolean flag = this.doCreateObjectReturn(Resource);
		SystemCacheHelper.updateResCache();//更新缓存
		return flag;
	}

	/**
	 * 修改资源
	 * 
	 * @param Resource
	 */
	public void updateResource(WbaseResource Resource) {
		SystemCacheHelper.updateResCache();//更新缓存
		this.doUpdateObject(Resource);
	}

	/**
	 * 查找资源信息 BY ID
	 * 
	 * @param id
	 * @return
	 */
	public WbaseResource findResourceById(String id) {
		WbaseResource Resource = (WbaseResource) this.doFindObjectById(id);
		return Resource;
	}

	/**
	 * 查找资源信息 BY resNo
	 * 
	 * @param resNo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public WbaseResource findResourceByResNo(String ResourceNo) {
		
		List<WbaseResource> list = null;
		List<WbaseResource> doFindObjectListByParam = (List<WbaseResource>) this.doFindObjectListByParam(
						"from WbaseResource o where o.resNo=:resNo", "resNo", ResourceNo);
		list = doFindObjectListByParam;
		WbaseResource Resource = null;
		if (list != null && !list.isEmpty()){
			Resource = list.get(0);
		}
		return Resource;
	}
	
	/**
	 * 查找资源信息 BY nodeNo
	 * 
	 * @param nodeNo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public WbaseResource findResourceByNodeNo(Long nodeNo) {
		
		List<WbaseResource> list = null;
		List<WbaseResource> doFindObjectListByParam = (List<WbaseResource>) this.doFindObjectListByParam(
						"from WbaseResource o where o.nodeNo=:nodeNo", "nodeNo", nodeNo);
		list = doFindObjectListByParam;
		WbaseResource Resource = null;
		if (list != null && !list.isEmpty()){
			Resource = list.get(0);
		}
		return Resource;
	}

	/**
	 * 删除资源信息
	 * 
	 * @param ResourceNoIds
	 * @return
	 */
	public String deleteResource(String nodeNos) {
		String bool = "删除组织成功！";
		try {
			if (nodeNos.length() > 0) {
				List<WbaseResource> olist = new ArrayList<WbaseResource>();
				String list[] = nodeNos.split(",");
				for (int i = 0; i < list.length; i++) {
					Long nodeNo = Long.valueOf(list[i]);
					WbaseResource Resource = this.findResourceByNodeNo(nodeNo);
					if(Resource!=null){
						olist.add(Resource);
						PowerHelper.deletePowerByResNodeNo(nodeNo);
						SystemCacheHelper.deletecutCacheByNodeNo(nodeNo);
						SystemCacheHelper.deleteResCache(nodeNo);//删除对应缓存对象
					}
				}
				this.doDeleteObjects(olist);
			}
		} catch (Exception e) {
			bool = "删除组织失败！";
		}

		return bool;
	}
	
	/**
	 * 删除资源信息
	 * 
	 * @param id
	 * @return
	 */
	public void deleteResourceById(String id){
		WbaseResource Resource = (WbaseResource)this.doFindObjectById(id);
		PowerHelper.deletePowerByResNodeNo(Resource.getNodeNo());
		SystemCacheHelper.deletecutCacheByNodeNo(Resource.getNodeNo());//删除快捷菜单
		SystemCacheHelper.deleteResCache(Resource.getNodeNo());//删除对应缓存对象
		this.doDeleteObject(Resource);
	}

}
