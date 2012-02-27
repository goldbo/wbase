package com.wingo.wbase.web.form;

import com.wingo.wbase.common.base.BaseForm;

/**   
 * @Title: WbaseResourceForm.java 
 * @Package com.wingo.wbase.web.form 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author  CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.  
 * @date 2011-1-20 上午10:07:57 
 * @version V1.0   
 */
public class WbaseResourceForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1787230189415115455L;

	private String id;

	private Long nodeNo;
	
	private String resNo;

	private String resName;

	private Integer resLevel = 1;

	private Long subNodeNo;

	private String resPath;

	private String resPic;

	private String remark;

	private Integer isFlag = 1;

	private Integer viewOrder = 1;
	
	private Integer isTarget = 0;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getIsTarget() {
		return isTarget;
	}

	public void setIsTarget(Integer isTarget) {
		this.isTarget = isTarget;
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

	public Integer getResLevel() {
		return resLevel;
	}

	public void setResLevel(Integer resLevel) {
		this.resLevel = resLevel;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public Long getNodeNo() {
		return nodeNo;
	}

	public void setNodeNo(Long nodeNo) {
		this.nodeNo = nodeNo;
	}

	public String getResNo() {
		return resNo;
	}

	public void setResNo(String resNo) {
		this.resNo = resNo;
	}

	public String getResPath() {
		return resPath;
	}

	public void setResPath(String resPath) {
		this.resPath = resPath;
	}

	public String getResPic() {
		return resPic;
	}

	public void setResPic(String resPic) {
		this.resPic = resPic;
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
