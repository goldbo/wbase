package com.wingo.wbase.web.form;

import java.util.Date;

import com.wingo.wbase.common.base.BaseForm;

/**   
 * @Title: WbasePostForm.java 
 * @Package com.wingo.wbase.web.form 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author  CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.  
 * @date 2011-1-7 下午03:37:56 
 * @version V1.0   
 */
public class WbasePostForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7261659470937043902L;

	private String id;

	private String postNo = "";

	private String postName = "";

	private Integer postLevel;
	
	private String remark = "";

	private Date createDate = new Date();
	
	private String[] selectedRow;
 
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String[] getSelectedRow() {
		return selectedRow;
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

	public Integer getPostLevel() {
		return postLevel;
	}

	public void setPostLevel(Integer postLevel) {
		this.postLevel = postLevel;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getPostNo() {
		return postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}
	
}
