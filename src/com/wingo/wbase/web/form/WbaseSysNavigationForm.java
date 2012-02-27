package com.wingo.wbase.web.form;

import com.wingo.wbase.common.base.BaseForm;

/**
 * @Title: WbaseSysNavigationForm.java
 * @Package com.wingo.wbase.web.form
 * @Description: TODO(用一句话描述该文件做什么)
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-4-28 下午03:44:11
 * @version V1.0
 */
public class WbaseSysNavigationForm extends BaseForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3122077018947443872L;

	private String id;

	private String navName = "";

	private String navLink = "http://";

	private Integer navOpen = 1;

	private Integer navFlag = 1;
	
	private String[] selectedRow;

	public String[] getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(String[] selectedRow) {
		this.selectedRow = selectedRow;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getNavFlag() {
		return navFlag;
	}

	public void setNavFlag(Integer navFlag) {
		this.navFlag = navFlag;
	}

	public String getNavLink() {
		return navLink;
	}

	public void setNavLink(String navLink) {
		this.navLink = navLink;
	}

	public String getNavName() {
		return navName;
	}

	public void setNavName(String navName) {
		this.navName = navName;
	}

	public Integer getNavOpen() {
		return navOpen;
	}

	public void setNavOpen(Integer navOpen) {
		this.navOpen = navOpen;
	}
	
}
