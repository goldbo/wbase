package com.wingo.wbase.web.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wingo.wbase.common.Constants;
import com.wingo.wbase.common.base.BaseAction;
import com.wingo.wbase.common.helper.MD5Helper;
import com.wingo.wbase.common.helper.PowerHelper;
import com.wingo.wbase.common.helper.SpringHelper;
import com.wingo.wbase.model.ViewUserInfo;
import com.wingo.wbase.model.WbaseOrg;
import com.wingo.wbase.model.WbaseRoleObj;
import com.wingo.wbase.service.WbaseUserService;
import com.wingo.wbase.web.form.WbaseUserForm;

/**
 * @Title: SystemLogin.java
 * @Package com.wingo.wbase.web.action
 * @Description: TODO(用一句话描述该文件做什么)
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午02:42:14
 * @version V1.0
 */
public class SystemLogin extends BaseAction {

	private WbaseUserService wbaseUserService = (WbaseUserService) SpringHelper
			.getBean("wbaseUserService");

	/**
	 * 登录信息验证用户
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward showLogin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbaseUserForm userForm = (WbaseUserForm) form;

		String account = userForm.getAccount();
		String userPwd = userForm.getUserPwd();
		// 验证用户是否存在
		ViewUserInfo user = wbaseUserService.findUserByLogin(account, MD5Helper.MD5Encode(userPwd));
		if (user != null) {
			//得到用户所属组织集合：包括父组织
			List<WbaseOrg> orgList = PowerHelper.getUserOrgList(user);
			//获取用户所属角色集合
			List<WbaseRoleObj> roleObjList = PowerHelper.getUserRoleList(orgList, user);
			//得到这些角色权限的并集Map
			Map powerMap = PowerHelper.getPowerList(roleObjList);
			
			HttpSession session = request.getSession();
//			获取用户访问系统屏幕高和宽
			String screen_height = request.getParameter("screenHeight");
			String screen_width = request.getParameter("screenWidth");
			
			session.setAttribute(Constants.SCREEN_HEIGHT,screen_height);
			session.setAttribute(Constants.SCREEN_WIDTH,screen_width);
			session.setAttribute(Constants.LOGIN_USER, user);
			session.setAttribute(Constants.ROLE_POWER, powerMap);
			return mapping.findForward("success");
		} else {
			request.setAttribute(Constants.ALERT_MESSAGE,
					"登录失败,请检查您的账号和密码是否正确！");
			return mapping.findForward("failure");
		}
	}

}
