package com.wingo.wbase.web.form;

import java.util.Date;

import com.wingo.wbase.common.base.BaseForm;

/**   
 * @Title: WbaseOrgForm.java 
 * @Package com.wingo.wbase.web.form 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author  CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.  
 * @date 2011-1-7 下午03:37:56 
 * @version V1.0   
 */
public class WbaseOrgForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2915481330616195903L;

	private String id;

	private Long nodeNo;
	
	private String orgNo;

	private String orgName;

	private Integer orgLevel = 1;

	private Long subNodeNo;

	private String remark;

	private Integer isFlag = 1;

	private Integer viewOrder = 1;

	private Date createDate = new Date();

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

	public Integer getOrgLevel() {
		return orgLevel;
	}

	public void setOrgLevel(Integer orgLevel) {
		this.orgLevel = orgLevel;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getNodeNo() {
		return nodeNo;
	}

	public void setNodeNo(Long nodeNo) {
		this.nodeNo = nodeNo;
	}

	public String getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	public Long getSubNodeNo() {
		return subNodeNo;
	}

	public void setSubNodeNo(Long subNodeNo) {
		this.subNodeNo = subNodeNo;
	}

	public Integer getViewOrder() {
		return viewOrder;
	}

	public void setViewOrder(Integer viewOrder) {
		this.viewOrder = viewOrder;
	}
	
}
