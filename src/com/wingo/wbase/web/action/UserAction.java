package com.wingo.wbase.web.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wingo.wbase.common.Constants;
import com.wingo.wbase.common.base.BaseAction;
import com.wingo.wbase.common.helper.MD5Helper;
import com.wingo.wbase.common.helper.PagerHelper;
import com.wingo.wbase.common.helper.SpringHelper;
import com.wingo.wbase.common.vo.page.Pager;
import com.wingo.wbase.model.ViewUserInfo;
import com.wingo.wbase.model.WbaseOrgUser;
import com.wingo.wbase.model.WbasePostUser;
import com.wingo.wbase.model.WbaseUser;
import com.wingo.wbase.service.WbaseOrgUserService;
import com.wingo.wbase.service.WbasePostUserService;
import com.wingo.wbase.service.WbaseUserService;
import com.wingo.wbase.web.form.WbaseUserForm;

/**
 * @Title: UserAction.java
 * @Package com.wingo.wbase.web.action
 * @Description: TODO(用一句话描述该文件做什么)
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午02:42:14
 * @version V1.0
 */
public class UserAction extends BaseAction {

	private WbaseUserService wbaseUserService = (WbaseUserService) SpringHelper
			.getBean("wbaseUserService");

	private WbaseOrgUserService wbaseOrgUserService = (WbaseOrgUserService) SpringHelper
			.getBean("wbaseOrgUserService");
	

	private WbasePostUserService wbasePostUserService = (WbasePostUserService) SpringHelper
			.getBean("wbasePostUserService");

	private static WbaseUserForm pageUserForm = null;

	/**
	 * 显示组织用户列表
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward showOrgUserList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		pageUserForm = (WbaseUserForm) form;
		if (pageUserForm.getOrgNodeNo() == null) {
			pageUserForm.setOrgNodeNo(Long.valueOf(request.getParameter("orgNodeNo").toString()));
		}

		List datas = null;
		int total = 0;// 总记录数
		Pager pager = null;// 分页信息
		total = wbaseUserService.getTotalByOther(pageUserForm);
		pager = PagerHelper.getPager(request, total);

		datas = wbaseUserService.getUserInfoListByOther(pageUserForm, pager
				.getPageSize(), pager.getStartRow());
		request.setAttribute("datas", datas);
		request.setAttribute("pager", pager);
		request.setAttribute("wbaseUserForm", pageUserForm);

		return mapping.findForward("showOrgUserList");
	}

	/**
	 * 显示所有用户信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward showUserList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		pageUserForm = (WbaseUserForm) form;
		List datas = null;
		int total = 0;// 总记录数
		Pager pager = null;// 分页信息
		total = wbaseUserService.getTotalByOther(pageUserForm);
		pager = PagerHelper.getPager(request, total);

		datas = wbaseUserService.getUserInfoListByOther(pageUserForm, pager
				.getPageSize(), pager.getStartRow());
		request.setAttribute("datas", datas);
		request.setAttribute("pager", pager);
		request.setAttribute("wbaseUserForm", pageUserForm);

		return mapping.findForward("showUserList");
	}

	/**
	 * 创建用户信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward editUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbaseUserForm userForm = (WbaseUserForm) form;
		String todo = userForm.getTodo();
		String forward = "";
		if (TODO_CREATE.equals(todo)) {
			userForm.setIsFlag(1);
			forward = "createUser";
		} else if (TODO_UPDATE.equals(todo)) {
			String id = userForm.getId();
			ViewUserInfo userInfo = wbaseUserService.findUserInfoById(id);
			//修改组织架构树方式
			WbaseOrgUser org = wbaseOrgUserService.findOrgUserByUser(userInfo.getAccount());
			userForm = (WbaseUserForm) this.modelToForm(userInfo,
					"com.wingo.wbase.web.form.WbaseUserForm");
			userForm.setId(userInfo.getId().getUid());
			if (org == null) {
				userForm.setOrgNodeNo(Long.valueOf("0"));
			} else {
				userForm.setOrgNodeNo(org.getOrgNodeNo());
			}

			forward = "updateUser";
		} else {
			String id = userForm.getId();
			ViewUserInfo userInfo = wbaseUserService.findUserInfoById(id);
			WbaseOrgUser orgUser = wbaseOrgUserService.findOrgUserByUser(userInfo.getAccount());
			userForm = (WbaseUserForm) this.modelToForm(userInfo,
					"com.wingo.wbase.web.form.WbaseUserForm");
			userForm.setId(userInfo.getId().getUid());
			if (orgUser == null) {
				userForm.setOrgNodeNo(Long.valueOf("0"));
			} else {
				userForm.setOrgNodeNo(orgUser.getOrgNodeNo());
			}
			forward = "showUserInfo";
		}

		request.setAttribute("wbaseUserForm", userForm);
		return mapping.findForward(forward);
	}

	/**
	 * 新建用户信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward createUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbaseUserForm userForm = (WbaseUserForm) form;
		WbaseUser user = new WbaseUser();
		String todo = userForm.getTodo();
		WbaseUser userCk = wbaseUserService.findUserByAccount(userForm
				.getAccount());
		String msg = "新增成功!";
		boolean flag = true;
		if (userCk == null) {
			user = (WbaseUser) this.formToModel(userForm,
					"com.wingo.wbase.model.WbaseUser");
			
			user.setUserPwd(MD5Helper.MD5Encode(userForm.getUserPwd()));
			user.setCreateDate(new Date());
			flag = wbaseUserService.createUser(user);

			WbasePostUser postUser = new WbasePostUser();
			postUser.setUserAccount(user.getAccount());
			postUser.setPostNo(userForm.getPostNo());
			postUser.setCreateDate(new Date());
			wbasePostUserService.createPostUser(postUser);
			
			WbaseOrgUser orgUser = new WbaseOrgUser();
			orgUser.setUserAccount(user.getAccount());
			orgUser.setOrgNodeNo(userForm.getOrgNodeNo());
			orgUser.setCreateDate(new Date());
			wbaseOrgUserService.createOrgUser(orgUser);
			
			userForm = new WbaseUserForm();
			userForm.setIsFlag(1);
			request.setAttribute("wbaseUserForm", userForm);
			msg = flag ? "新增成功!" : "新增失败!";

		} else {
			msg = "该资源编号已被使用,新增失败!";
			request.setAttribute(Constants.ALERT_MESSAGE, msg);
			return mapping.findForward("createUser");
		}

		if (TODO_CREATE.equals(todo)) {
			request.setAttribute(Constants.ALERT_MESSAGE, msg);
			return mapping.findForward("createUser");
		} else {
			this.returnJsMsg(response, msg, "window.close();");
			return null;
		}

	}

	/**
	 * 修改用户信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbaseUserForm userForm = (WbaseUserForm) form;
		boolean flag = true;
		try {
			WbaseUser user = wbaseUserService.findUserById(userForm.getId());
			String userAccount = user.getAccount();
			user.setUserName(userForm.getUserName());
			Object pwdObj = request.getParameter("userPwd");
			if (pwdObj != null) {
				user.setUserPwd(MD5Helper.MD5Encode(pwdObj.toString()));
			}
			user.setRealName(userForm.getRealName());
			user.setSex(userForm.getSex());
			user.setIsFlag(userForm.getIsFlag());
			user.setEmail(userForm.getEmail());
			user.setPhone(userForm.getPhone());
			user.setMobile(userForm.getMobile());
			user.setRemark(userForm.getRemark());
			wbaseUserService.updateUser(user);
			
			WbasePostUser postUser = wbasePostUserService.findPostUserByUser(userAccount);
			WbaseOrgUser orgUser = wbaseOrgUserService.findOrgUserByUser(userAccount);
			if(postUser==null){
				postUser = new WbasePostUser();
				postUser.setUserAccount(userAccount);
				postUser.setPostNo(userForm.getPostNo());
				postUser.setCreateDate(new Date());
				wbasePostUserService.createPostUser(postUser);
			}else{
				postUser.setPostNo(userForm.getPostNo());
				postUser.setCreateDate(new Date());
				wbasePostUserService.updatePostUser(postUser);
			}
			
			if(orgUser==null){
				orgUser = new WbaseOrgUser();
				orgUser.setUserAccount(userAccount);
				orgUser.setOrgNodeNo(userForm.getOrgNodeNo());
				orgUser.setCreateDate(new Date());
				wbaseOrgUserService.createOrgUser(orgUser);
			}else{
				orgUser.setOrgNodeNo(userForm.getOrgNodeNo());
				orgUser.setCreateDate(new Date());
				wbaseOrgUserService.updateOrgUser(orgUser);
			}
			
			userForm.setTodo("update");
			request.setAttribute("wbaseUserForm", userForm);
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
			log.error("updateUser error!");
		}
		request.setAttribute(Constants.ALERT_MESSAGE, flag == true ? "修改成功！"
				: "修改失败！");
		return mapping.findForward("updateUser");
	}
	
	/**
	 * 修改用户信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateUserInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbaseUserForm userForm = (WbaseUserForm) form;
		boolean flag = true;
		try {
			WbaseUser user = wbaseUserService.findUserById(userForm.getId());
			user.setPicture(userForm.getPicture());
			user.setEmail(userForm.getEmail());
			user.setOfficeTel(userForm.getOfficeTel());
			user.setFax(userForm.getFax());
			user.setPhone(userForm.getPhone());
			user.setMobile(userForm.getMobile());
			user.setAddress(userForm.getAddress());
			user.setZipcode(userForm.getZipcode());
			user.setRemark(userForm.getRemark());
			wbaseUserService.updateUser(user);
			userForm.setTodo("update");
			ViewUserInfo userInfo = wbaseUserService.findUserInfoById(userForm.getId());
			HttpSession session = request.getSession();
			session.setAttribute(Constants.LOGIN_USER, userInfo);
			request.setAttribute("wbaseUserForm", userForm);
		} catch (Exception e) {
			flag = false;
			log.error("updateUserInfo error!");
		}
		request.setAttribute(Constants.ALERT_MESSAGE, flag == true ? "修改成功！"
				: "修改失败！");
		return mapping.findForward("updateUserInfo");
	}
	
	/**
	 * 修改密码
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateUserPwd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbaseUserForm userForm = (WbaseUserForm) form;
		String msg = "密码修改成功！";
		boolean flag = true;
		try {
			WbaseUser user = wbaseUserService.findUserById(userForm.getId());
			if(MD5Helper.MD5Encode(userForm.getUserPwd()).equals(user.getUserPwd())){
				user.setUserPwd(MD5Helper.MD5Encode(userForm.getNewPwd()));
				wbaseUserService.updateUser(user);
			}else{
				msg = "密码输入错误,请重新输入.";
				flag = false;
			}
			userForm.setTodo("update");
			request.setAttribute("wbaseUserForm", userForm);
		} catch (Exception e) {
			msg = "密码修改失败！";
			flag = false;
			e.printStackTrace();
			log.error("updateUserPwd error!");
		}
		if (flag) {
			this.returnJsMsg(response, msg, "window.close();");
			return null;
		} else {
			request.setAttribute(Constants.ALERT_MESSAGE, msg);
			return mapping.findForward("updateUserPwd");
		}
	}

	/**
	 * 删除用户信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbaseUserForm userForm = (WbaseUserForm) form;
		boolean flag = wbaseUserService.deleteUserByIds(userForm
				.getSelectedRow());
		request.setAttribute(Constants.ALERT_MESSAGE, flag == true ? "删除成功！"
				: "删除失败！");
		pageUserForm = new WbaseUserForm();
		request.setAttribute("wbaseUserForm", pageUserForm);
		return showUserList(mapping, form, request, response);
	}

	/**
	 * 删除组织用户对象
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteOrgUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbaseUserForm userForm = (WbaseUserForm) form;
		boolean flag = wbaseUserService.updateOrgUserByIds(userForm
				.getSelectedRow(), Long.valueOf("0"));
		request.setAttribute(Constants.ALERT_MESSAGE, flag == true ? "移除成功！"
				: "移除失败！");
		pageUserForm = new WbaseUserForm();
		request.setAttribute("wbaseUserForm", pageUserForm);
		return showOrgUserList(mapping, form, request, response);
	}

}
