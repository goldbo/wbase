package com.wingo.wbase.model;

import java.util.Date;

/**
 * WbaseRole generated by MyEclipse Persistence Tools
 */

public class WbaseRole implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8934833317147549289L;

	private String id;

	private String roleNo;

	private String roleName;

	private String remark;

	private Integer viewOrder;

	private Date createDate;

	private Integer isFlag;

	// Constructors

	/** default constructor */
	public WbaseRole() {
	}

	/** minimal constructor */
	public WbaseRole(String roleNo, String roleName) {
		this.roleNo = roleNo;
		this.roleName = roleName;
	}

	/** full constructor */
	public WbaseRole(String roleNo, String roleName, String remark,
			Integer viewOrder, Date createDate, Integer isFlag) {
		this.roleNo = roleNo;
		this.roleName = roleName;
		this.remark = remark;
		this.viewOrder = viewOrder;
		this.createDate = createDate;
		this.isFlag = isFlag;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleNo() {
		return this.roleNo;
	}

	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getViewOrder() {
		return this.viewOrder;
	}

	public void setViewOrder(Integer viewOrder) {
		this.viewOrder = viewOrder;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getIsFlag() {
		return this.isFlag;
	}

	public void setIsFlag(Integer isFlag) {
		this.isFlag = isFlag;
	}

}