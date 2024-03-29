package com.wingo.wbase.model;

/**
 * WbasePower generated by MyEclipse Persistence Tools
 */

public class WbasePower implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7875322395752399320L;

	private String id;

	private String roleNo;

	private Long resNodeNo;

	private Integer powerLevel;

	// Constructors

	/** default constructor */
	public WbasePower() {
	}

	/** full constructor */
	public WbasePower(String roleNo, Long resNodeNo, Integer powerLevel) {
		this.roleNo = roleNo;
		this.resNodeNo = resNodeNo;
		this.powerLevel = powerLevel;
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

	public Long getResNodeNo() {
		return this.resNodeNo;
	}

	public void setResNodeNo(Long resNodeNo) {
		this.resNodeNo = resNodeNo;
	}

	public Integer getPowerLevel() {
		return this.powerLevel;
	}

	public void setPowerLevel(Integer powerLevel) {
		this.powerLevel = powerLevel;
	}

}