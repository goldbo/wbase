package com.wingo.wbase.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wingo.wbase.common.base.BaseDAOHibernate;
import com.wingo.wbase.common.helper.PowerHelper;
import com.wingo.wbase.common.helper.SystemCacheHelper;
import com.wingo.wbase.model.WbaseOrg;

/**
 * @Title: WbaseOrgDao.java
 * @Package com.wingo.wbase.dao;
 * @Description: 组织对象DAO
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */

public class WbaseOrgDao extends BaseDAOHibernate {
	private static final Log log = LogFactory.getLog(WbaseOrgDao.class);

	protected Class getModelClass() {
		return WbaseOrg.class;
	}

	/**
	 * 获取所有组织对象信息的集合 后台使用
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<WbaseOrg> getOrgList() {
		List<WbaseOrg> orgList = new ArrayList<WbaseOrg>();
		List oList = this
				.doFind("from WbaseOrg order by orgLevel,viewOrder");
		orgList = oList;
		return orgList;
	}

	/**
	 * 创建组织对象
	 * 
	 * @param org
	 */
	public boolean createOrg(WbaseOrg org) {
		boolean flag = this.doCreateObjectReturn(org);
		SystemCacheHelper.updateOrgCache();//更新缓存
		return flag;
	}

	/**
	 * 修改组织对象
	 * 
	 * @param org
	 */
	public void updateOrg(WbaseOrg org) {
		SystemCacheHelper.updateOrgCache();//更新缓存
		this.doUpdateObject(org);
	}

	/**
	 * 查找组织对象信息 BY ID
	 * 
	 * @param id
	 * @return
	 */
	public WbaseOrg findOrgById(String id) {
		WbaseOrg org = (WbaseOrg) this.doFindObjectById(id);
		return org;
	}

	/**
	 * 查找组织对象信息 BY orgNo
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public WbaseOrg findOrgByOrgNo(String orgNo) {
		
		List<WbaseOrg> list = new ArrayList<WbaseOrg>();
		List<WbaseOrg> doFindObjectListByParam = (List<WbaseOrg>) this.doFindObjectListByParam(
						"from WbaseOrg o where o.orgNo=:orgNo", "orgNo", orgNo);
		list = doFindObjectListByParam;
		WbaseOrg org = new WbaseOrg();
		if (list != null && !list.isEmpty()){
			org = list.get(0);
			return org;
		}else{
			return null;
		}
	}

	/**
	 * 查找组织对象信息 BY orgNo
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public WbaseOrg findOrgByNodeNo(Long nodeNo) {
		
		List<WbaseOrg> list = new ArrayList<WbaseOrg>();
		List<WbaseOrg> doFindObjectListByParam = (List<WbaseOrg>) this.doFindObjectListByParam(
						"from WbaseOrg o where o.nodeNo=:nodeNo", "nodeNo", nodeNo);
		list = doFindObjectListByParam;
		WbaseOrg org = new WbaseOrg();
		if (list != null && !list.isEmpty()){
			org = list.get(0);
			return org;
		}else{
			return null;
		}
		
	}

	/**
	 * 删除组织对象信息
	 * 
	 * @param list
	 * @return
	 */
	public String deleteOrg(String nodeNos) {
		String bool = "删除组织成功！";
		try {
			if (nodeNos.length() > 0) {
				List<WbaseOrg> olist = new ArrayList<WbaseOrg>();
				String list[] = nodeNos.split(",");
				for (int i = 0; i < list.length; i++) {
					Long nodeNo = Long.valueOf(list[i]);
					WbaseOrg org = this.findOrgByNodeNo(nodeNo);
					if(org!=null){
						olist.add(org);
						PowerHelper.deleteRoleObjByObjNo("org", nodeNo.toString());
						PowerHelper.deleteOrgUserByOrgNo(nodeNo);
						SystemCacheHelper.deleteOrgCache(nodeNo);//删除对应缓存
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
	 * 删除组织对象信息
	 * 
	 * @param id
	 * @return
	 */
	public void deleteOrgById(String id){
		WbaseOrg org = (WbaseOrg)this.doFindObjectById(id);
		PowerHelper.deleteRoleObjByObjNo("org", org.getNodeNo().toString());
		PowerHelper.deleteOrgUserByOrgNo(org.getNodeNo());
		SystemCacheHelper.deleteOrgCache(org.getNodeNo());//删除对应缓存
		this.doDeleteObject(org);
	}

}
