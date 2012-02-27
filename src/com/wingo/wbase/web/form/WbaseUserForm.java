package com.wingo.wbase.web.form;

import java.util.Date;

import com.wingo.wbase.common.base.BaseForm;

/**   
 * @Title: WbaseUserForm.java 
 * @Package com.wingo.wbase.web.form 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author  CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.  
 * @date 2011-1-7 下午03:37:56 
 * @version V1.0   
 */
public class WbaseUserForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7024743233881106298L;

	private String id;

	private String account = "";

	private String userPwd = "123456";
	
	private String newPwd;

	private String userName = "";

	private String realName;

	private String postNo;
	
	private String postName;

	private String email;

	private Integer sex;
	
	private String officeTel;

	private String fax;

	private String phone;

	private String mobile;
	
	private String address;

	private String zipcode;
	
	private String picture = "/common/images/default_head.png";

	private String remark;

	private Date createDate = new Date();

	private String orgNo = "";
	
	private Long orgNodeNo ;
	
	private String orgName;
	
	private Integer isFlag = 3;
	
	private String[] selectedRow;

	public String[] getSelectedRow() {
		return selectedRow;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getOfficeTel() {
		return officeTel;
	}

	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setSelectedRow(String[] selectedRow) {
		this.selectedRow = selectedRow;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getIsFlag() {
		return isFlag;
	}

	public void setIsFlag(Integer isFlag) {
		this.isFlag = isFlag;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	public Long getOrgNodeNo() {
		return orgNodeNo;
	}

	public void setOrgNodeNo(Long orgNodeNo) {
		this.orgNodeNo = orgNodeNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
 
	public String getPostNo() {
		return postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
}
