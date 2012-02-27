package com.wingo.wbase.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wingo.wbase.common.base.BaseDAOHibernate;
import com.wingo.wbase.common.helper.SystemCacheHelper;
import com.wingo.wbase.model.WbaseSysShortcut;

/**
 * @Title: WbaseSysShortcutDao.java
 * @Package com.wingo.wbase.dao;
 * @Description: 系统基础配置－快捷菜单配置DAO
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */

public class WbaseSysShortcutDao extends BaseDAOHibernate {
	private static final Log log = LogFactory.getLog(WbaseSysShortcutDao.class);

	protected Class getModelClass() {
		return WbaseSysShortcut.class;
	}

	/**
	 * 获取快捷菜单
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<WbaseSysShortcut> getSysShortcut() {
		List<WbaseSysShortcut> list = new ArrayList<WbaseSysShortcut>();
		List oList = this.doFind("from WbaseSysShortcut o order by o.cutOrder");
		list = oList;
		return list;
	}

	/**
	 * 创建快捷菜单
	 * 
	 * @param Post
	 */
	public boolean createSysShortcut(WbaseSysShortcut SysShortcut) {
		boolean bool = this.doCreateObjectReturn(SysShortcut);
		SystemCacheHelper.updateCutCache();//更新缓存
		return bool;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public WbaseSysShortcut findSysShortcutById(String id) {
		WbaseSysShortcut cut = (WbaseSysShortcut) this.doFindObjectById(id);
		return cut;
	}

	/**
	 * 查找快捷菜单信息 BY userNo
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public void deleteCutByAccount(String cutUid) {

		List<WbaseSysShortcut> list = new ArrayList<WbaseSysShortcut>();
		List<WbaseSysShortcut> doFindObjectListByParam = (List<WbaseSysShortcut>) this
				.doFindObjectListByParam(
						"from WbaseSysShortcut o where o.cutUid=:cutUid",
						"cutUid", cutUid);
		list = doFindObjectListByParam;

		if (list != null && !list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				WbaseSysShortcut cut = (WbaseSysShortcut) list.get(i);
				SystemCacheHelper.deletecutCache(cut.getId());
				this.doDeleteObject(cut);
			}
		}
	}
	
	/**
	 * 查找快捷菜单信息 BY nodeNo
	 * 
	 * @param nodeNo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public void deleteCutByNodeNo(Long cutNodeNo) {

		List<WbaseSysShortcut> list = new ArrayList<WbaseSysShortcut>();
		List<WbaseSysShortcut> doFindObjectListByParam = (List<WbaseSysShortcut>) this
				.doFindObjectListByParam(
						"from WbaseSysShortcut o where o.cutNodeNo=:cutNodeNo",
						"cutNodeNo", cutNodeNo);
		list = doFindObjectListByParam;

		if (list != null && !list.isEmpty()) {
			this.doDeleteObjects(list);
		}
	}

	/**
	 * 查找快捷菜单信息 BY ID
	 * 
	 * @param id
	 * @return
	 */
	public boolean updateSysShortcutByNodes(String[] nodes, String account) {
		int max = nodes.length;
		this.deleteCutByAccount(account);
		if(max>0){
			for(int i = 0 ;i<max ;i++){
				String[] col = nodes[i].split(",");
				Long cutNodeNo = Long.valueOf(col[0]);
				int cutOrder = Integer.valueOf(col[1]);
				WbaseSysShortcut cut = new WbaseSysShortcut();
				cut.setCutNodeNo(cutNodeNo);
				cut.setCutOrder(cutOrder);
				cut.setCutUid(account);
				this.createSysShortcut(cut);
			}
		}
		return true;
	}
}
