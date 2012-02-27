package com.wingo.wbase.model;

import java.util.Date;

/**
 * WbasePostUser generated by MyEclipse Persistence Tools
 */

public class WbasePostUser implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7719453511862834437L;

	private String id;

	private String userAccount;

	private String postNo;

	private Date createDate;

	// Constructors

	/** default constructor */
	public WbasePostUser() {
	}

	/** minimal constructor */
	public WbasePostUser(String userAccount, String postNo) {
		this.userAccount = userAccount;
		this.postNo = postNo;
	}

	/** full constructor */
	public WbasePostUser(String userAccount, String postNo, Date createDate) {
		this.userAccount = userAccount;
		this.postNo = postNo;
		this.createDate = createDate;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getPostNo() {
		return this.postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}