package com.wingo.wbase.common.taglib;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.wingo.wbase.common.Constants;
import com.wingo.wbase.common.helper.PowerHelper;

/**
 * @Title: ShowPowerButtonTag.java
 * @Package com.wingo.wbase.common.taglib
 * @Description: TODO(权限按钮)
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午03:16:49
 * @version V1.0
 */
public class ShowPowerButtonTag extends BodyTagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2338426562627532411L;

	/**
	 *  新增POWER_CREATE,删除POWER_DELETE,修改POWER_UPDATE,查看POWER_READ,默认(是否可见)POWER_AUTO = 5
	 */
	private Integer type;
	
	private String resNo;

	private String onclick;
	
	private String value;
	
	public String getResNo() {
		return resNo;
	}

	public void setResNo(String resNo) {
		this.resNo = resNo;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int doStartTag() {

		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		StringBuffer buffer = new StringBuffer();
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		HttpSession session = request.getSession();
		try {
			Map powerMap = (Map)session.getAttribute(Constants.ROLE_POWER);
			Object resNoObj = powerMap.get(this.resNo);
			if(resNoObj != null){
				Integer powerLevel = Integer.parseInt(resNoObj.toString());
				buffer =  showSystemButton(request, powerLevel);
				// System.out.print(buffer.toString());
				out.println(buffer.toString());
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return EVAL_PAGE;
	}

	/**
	 * 显示权限按钮
	 * 
	 * @param resList
	 * @return
	 */
	private StringBuffer showSystemButton(HttpServletRequest request,
			Integer powerLevel) {
		StringBuffer contents = new StringBuffer();
		if(PowerHelper.checkPower(powerLevel,this.type)){
			contents.append("<input type=\"button\" value=\""+this.value+"\"  class=\"button1\" onclick=\""+this.onclick+"\" >\n");
		}
		return contents;
	}
	
}
