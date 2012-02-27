package com.wingo.wbase.web.form;

import com.wingo.wbase.common.base.BaseForm;

/**
 * @Title: WbaseOrgForm.java
 * @Package com.wingo.wbase.web.form
 * @Description: TODO(用一句话描述该文件做什么)
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午03:37:56
 * @version V1.0
 */
public class WbaseSysCompanyForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -803967263643816677L;

	private String id = "";

	private String comName = "";

	private String comLogo;

	private String comRemark = "";
	
	public String getComLogo() {
		return comLogo;
	}

	public void setComLogo(String comLogo) {
		this.comLogo = comLogo;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getComRemark() {
		return comRemark;
	}

	public void setComRemark(String comRemark) {
		this.comRemark = comRemark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
