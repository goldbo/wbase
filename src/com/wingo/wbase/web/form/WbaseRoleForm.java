package com.wingo.wbase.web.form;

import java.util.Date;

import com.wingo.wbase.common.base.BaseForm;

/**   
 * @Title: WbaseRoleForm.java 
 * @Package com.wingo.wbase.web.form 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author  CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.  
 * @date 2011-1-20 上午09:07:44 
 * @version V1.0   
 */
public class WbaseRoleForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4090367459400163955L;

	private String id;

	private String roleNo = "";

	private String roleName = "";

	private String remark = "";
	
	private Integer viewOrder = 1;

	private Date createDate = new Date();

	private Integer isFlag = 3;
	
	private String[] selectedRow;

	public String[] getSelectedRow() {
		return selectedRow;
	}

	public Integer getViewOrder() {
		return viewOrder;
	}

	public void setViewOrder(Integer viewOrder) {
		this.viewOrder = viewOrder;
	}

	public void setSelectedRow(String[] selectedRow) {
		this.selectedRow = selectedRow;
	}

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleNo() {
		return roleNo;
	}

	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}
	
}
