package com.wingo.wbase.model;

import java.util.Date;

/**
 * WbaseSysMessages generated by MyEclipse Persistence Tools
 */

public class WbaseSysMessages implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5707080234900936358L;

	private String id;

	private String msgTitle;

	private Date msgStarttime;

	private Date msgEndtime;

	private String msgContents;

	private String msgAttachment;

	private Integer msgFlag;

	// Constructors

	/** default constructor */
	public WbaseSysMessages() {
	}

	/** full constructor */
	public WbaseSysMessages(String msgTitle, Date msgStarttime,
			Date msgEndtime, String msgContents, String msgAttachment,
			Integer msgFlag) {
		this.msgTitle = msgTitle;
		this.msgStarttime = msgStarttime;
		this.msgEndtime = msgEndtime;
		this.msgContents = msgContents;
		this.msgAttachment = msgAttachment;
		this.msgFlag = msgFlag;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMsgTitle() {
		return this.msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	public Date getMsgStarttime() {
		return this.msgStarttime;
	}

	public void setMsgStarttime(Date msgStarttime) {
		this.msgStarttime = msgStarttime;
	}

	public Date getMsgEndtime() {
		return this.msgEndtime;
	}

	public void setMsgEndtime(Date msgEndtime) {
		this.msgEndtime = msgEndtime;
	}

	public String getMsgContents() {
		return this.msgContents;
	}

	public void setMsgContents(String msgContents) {
		this.msgContents = msgContents;
	}

	public String getMsgAttachment() {
		return this.msgAttachment;
	}

	public void setMsgAttachment(String msgAttachment) {
		this.msgAttachment = msgAttachment;
	}

	public Integer getMsgFlag() {
		return this.msgFlag;
	}

	public void setMsgFlag(Integer msgFlag) {
		this.msgFlag = msgFlag;
	}

}