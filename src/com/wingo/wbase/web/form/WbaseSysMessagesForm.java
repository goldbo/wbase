package com.wingo.wbase.web.form;

import com.wingo.wbase.common.base.BaseForm;

/**
 * @Title: WbaseSysMessagesForm.java
 * @Package com.wingo.wbase.web.form
 * @Description: TODO(用一句话描述该文件做什么)
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-4-25 下午04:58:52
 * @version V1.0
 */
public class WbaseSysMessagesForm extends BaseForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7672389910726676821L;

	private String id;

	private String msgTitle = "";

	private String msgContents= "";
	
	private String msgAttachment= "";

	private String msgStarttime;

	private String msgEndtime;

	private Integer msgFlag = 1;
	
	private String[] selectedRow;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String[] getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(String[] selectedRow) {
		this.selectedRow = selectedRow;
	}

	public String getMsgAttachment() {
		return msgAttachment;
	}

	public void setMsgAttachment(String msgAttachment) {
		this.msgAttachment = msgAttachment;
	}

	public String getMsgContents() {
		return msgContents;
	}

	public void setMsgContents(String msgContents) {
		this.msgContents = msgContents;
	}

	public Integer getMsgFlag() {
		return msgFlag;
	}

	public void setMsgFlag(Integer msgFlag) {
		this.msgFlag = msgFlag;
	}

	public String getMsgEndtime() {
		return msgEndtime;
	}

	public void setMsgEndtime(String msgEndtime) {
		this.msgEndtime = msgEndtime;
	}

	public String getMsgStarttime() {
		return msgStarttime;
	}

	public void setMsgStarttime(String msgStarttime) {
		this.msgStarttime = msgStarttime;
	}

	public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}
	
	
}
