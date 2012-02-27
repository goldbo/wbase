package com.wingo.wbase.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wingo.wbase.common.base.BaseDAOHibernate;
import com.wingo.wbase.common.helper.SystemCacheHelper;
import com.wingo.wbase.model.WbaseSysMessages;
import com.wingo.wbase.web.form.WbaseSysMessagesForm;

/**
 * @Title: WbaseSysMessagesDao.java
 * @Package com.wingo.wbase.dao;
 * @Description: 系统消息DAO
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */

public class WbaseSysMessagesDao extends BaseDAOHibernate {
	private static final Log log = LogFactory.getLog(WbaseSysMessagesDao.class);

	protected Class getModelClass() {
		return WbaseSysMessages.class;
	}

	/**
	 * 获取所有系统消息数据集合
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<WbaseSysMessages> getSysMessagesList() {
		List<WbaseSysMessages> orgList = new ArrayList<WbaseSysMessages>();
		StringBuffer query = new StringBuffer();
		query.append("from WbaseSysMessages o where 1=1 \n");
		query.append(" and o.msgStarttime <= GETDATE() and o.msgEndtime >= GETDATE() \n");
		query.append(" order by o.msgStarttime DESC ");
		List oList = this.doFind(query.toString());
		orgList = oList;
		return orgList;
	}

	/**
	 * 获取查询系统消息数据集合
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public int getTotalByOther(WbaseSysMessagesForm form) {

		StringBuffer query = new StringBuffer();
		query.append("from WbaseSysMessages o where 1=1 \n");
		// 根据系统消息标题
		if (form.getMsgTitle().trim().length() > 0) {
			query.append(" and o.msgTitle like '%" + form.getMsgTitle().trim()
					+ "%' \n");
		}

		int total = super.getRowsByHQL("select count(*) " + query.toString());

		return total;
	}

	/**
	 * 获取查询系统消息数据集合
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public List getSysMessagesListByOther(WbaseSysMessagesForm form,
			int pageSize, int startRow) {

		StringBuffer query = new StringBuffer();
		query.append("from WbaseSysMessages o where 1=1 \n");
		// 根据系统消息标题
		if (form.getMsgTitle().trim().length() > 0) {
			query.append(" and o.msgTitle like '%" + form.getMsgTitle().trim()
					+ "%' \n");
		}

		query.append(" order by o.msgStarttime DESC ");
		List datas = super.doFind(query.toString(), pageSize, startRow);

		return datas;
	}

	/**
	 * 创建系统消息
	 * 
	 * @param SysMessages
	 */
	public boolean createSysMessages(WbaseSysMessages SysMessages) {
		boolean bool = this.doCreateObjectReturn(SysMessages);
		SystemCacheHelper.updateSysMessagesCache();
		return bool;
	}

	/**
	 * 修改系统消息
	 * 
	 * @param SysMessages
	 */
	public void updateSysMessages(WbaseSysMessages SysMessages) {
		this.doUpdateObject(SysMessages);
		SystemCacheHelper.updateSysMessagesCache();
	}

	/**
	 * 查找系统消息信息 BY ID
	 * 
	 * @param id
	 * @return
	 */
	public WbaseSysMessages findSysMessagesById(String id) {
		WbaseSysMessages SysMessages = (WbaseSysMessages) this
				.doFindObjectById(id);
		return SysMessages;
	}

	/**
	 * 查找系统消息信息 BY SysMessagesNo
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public WbaseSysMessages findSysMessagesBySysMessagesNo(String SysMessagesNo) {

		List<WbaseSysMessages> list = new ArrayList<WbaseSysMessages>();
		List<WbaseSysMessages> doFindObjectListByParam = (List<WbaseSysMessages>) this
				.doFindObjectListByParam(
						"from WbaseSysMessages o where o.SysMessagesNo=:SysMessagesNo",
						"SysMessagesNo", SysMessagesNo);
		list = doFindObjectListByParam;
		WbaseSysMessages SysMessages = null;
		if (list != null && !list.isEmpty()) {
			SysMessages = list.get(0);
		}
		return SysMessages;
	}

	/**
	 * 删除系统消息信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean deleteSysMessagesById(String id) {
		boolean bool = false;
		try {
			WbaseSysMessages SysMessages = this.findSysMessagesById(id);
			this.doDeleteObject(SysMessages);
			SystemCacheHelper.updateSysMessagesCache();
			bool = true;
		} catch (Exception e) {
			bool = false;
		}
		return bool;
	}

	/**
	 * 删除系统消息信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean deleteSysMessagesByIds(String[] ids) {
		boolean bool = false;
		try {
			if (ids != null && ids.length > 0) {
				for (int i = 0; i < ids.length; i++) {
					this.deleteSysMessagesById(ids[i]);
				}
			}
			bool = true;
		} catch (Exception e) {
			bool = false;
		}
		SystemCacheHelper.updateSysMessagesCache();
		return bool;
	}

}
