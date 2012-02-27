package com.wingo.wbase.service;

import java.util.List;

import com.wingo.wbase.common.base.BaseServiceImpl;
import com.wingo.wbase.dao.WbaseSysMessagesDao;
import com.wingo.wbase.model.WbaseSysMessages;
import com.wingo.wbase.web.form.WbaseSysMessagesForm;

/**
 * @Title: WbaseSysMessagesService.java
 * @Package com.wingo.wbase.service;
 * @Description: 系统消息对象SERVICE
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */
public class WbaseSysMessagesService extends BaseServiceImpl {
	private WbaseSysMessagesDao wbaseSysMessagesDao;

	public void setWbaseSysMessagesDao(WbaseSysMessagesDao wbaseSysMessagesDao) {
		this.wbaseSysMessagesDao = wbaseSysMessagesDao;
	}

	/**
	 * 获取所有系统消息数据集合
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public List<WbaseSysMessages> getSysMessagesList() {
		return wbaseSysMessagesDao.getSysMessagesList();
	}

	/**
	 * 查找系统消息信息 BY SysMessagesNo
	 * 
	 * @param id
	 * @return
	 */
	public WbaseSysMessages findSysMessagesBySysMessagesNo(String SysMessagesNo) {
		return wbaseSysMessagesDao.findSysMessagesBySysMessagesNo(SysMessagesNo);
	}

	/**
	 * 获取查询系统消息数据集合
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public List getSysMessagesListByOther(WbaseSysMessagesForm form, int pageSize,
			int startRow) {
		return wbaseSysMessagesDao.getSysMessagesListByOther(form, pageSize, startRow);
	}

	/**
	 * 获取总记录数
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public int getTotalByOther(WbaseSysMessagesForm form) {
		return wbaseSysMessagesDao.getTotalByOther(form);
	}

	/**
	 * 创建系统消息
	 * 
	 * @param SysMessages
	 */
	public boolean createSysMessages(WbaseSysMessages SysMessages) {
		return wbaseSysMessagesDao.createSysMessages(SysMessages);
	}

	/**
	 * 修改系统消息
	 * 
	 * @param SysMessages
	 */
	public void updateSysMessages(WbaseSysMessages SysMessages) {
		wbaseSysMessagesDao.updateSysMessages(SysMessages);
	}

	/**
	 * 查找系统消息信息 BY ID
	 * 
	 * @param id
	 * @return
	 */
	public WbaseSysMessages findSysMessagesById(String id) {
		return wbaseSysMessagesDao.findSysMessagesById(id);
	}

	/**
	 * 删除系统消息信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean deleteSysMessagesById(String id) {
		return wbaseSysMessagesDao.deleteSysMessagesById(id);
	}

	/**
	 * 删除系统消息信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean deleteSysMessagesByIds(String[] ids) {
		return wbaseSysMessagesDao.deleteSysMessagesByIds(ids);
	}

}
