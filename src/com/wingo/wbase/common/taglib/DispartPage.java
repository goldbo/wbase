package com.wingo.wbase.common.taglib;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.wingo.wbase.common.helper.DispartPageHTMLHelper;
import com.wingo.wbase.common.helper.WebHelper;
import com.wingo.wbase.common.vo.page.Pager;
/**
 * @Title: DispartPage.java
 * @Package com.wingo.wbase.common.taglib
 * @Description: TODO(分布标签控件)
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午03:16:49
 * @version V1.0
 */
public class DispartPage extends BodyTagSupport {
	private static final long serialVersionUID = 3828465519331177130L;

	private String formId;

	private String pagerKey = "pager";//      

	private String scope;
	
	public int doStartTag() {

		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException {
		// Pager pager = (Pager)this.getPagerObject();
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		Pager pager = (Pager) WebHelper.getObjectByWebContainer(request, scope,
				pagerKey);
		JspWriter out = pageContext.getOut();
		StringBuffer buf = DispartPageHTMLHelper.getDispartPageHTML(pager, formId);
		try {
			out.println(buf.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return EVAL_PAGE;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getPagerKey() {
		return pagerKey;
	}

	public void setPagerKey(String pagerKey) {
		this.pagerKey = pagerKey;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

}
