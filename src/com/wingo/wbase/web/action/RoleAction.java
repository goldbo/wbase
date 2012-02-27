package com.wingo.wbase.web.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wingo.wbase.common.Constants;
import com.wingo.wbase.common.base.BaseAction;
import com.wingo.wbase.common.helper.PagerHelper;
import com.wingo.wbase.common.helper.SpringHelper;
import com.wingo.wbase.common.vo.page.Pager;
import com.wingo.wbase.model.WbaseRole;
import com.wingo.wbase.service.WbaseRoleService;
import com.wingo.wbase.web.form.WbaseRoleForm;

/**
 * @Title: PostAction.java
 * @Package com.wingo.wbase.web.action
 * @Description: TODO(用一句话描述该文件做什么)
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午02:42:14
 * @version V1.0
 */
public class RoleAction extends BaseAction {

	private WbaseRoleService wbaseRoleService = (WbaseRoleService) SpringHelper
			.getBean("wbaseRoleService");

	private static WbaseRoleForm pageRoleForm = null;

	/**
	 * 显示所有角色信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward showRoleList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		pageRoleForm = (WbaseRoleForm) form;
		List datas = null;
		int total = 0;// 总记录数
		Pager pager = null;// 分页信息
		total = wbaseRoleService.getTotalByOther(pageRoleForm);
		pager = PagerHelper.getPager(request, total);

		datas = wbaseRoleService.getRoleListByOther(pageRoleForm, pager
				.getPageSize(), pager.getStartRow());

		request.setAttribute("datas", datas);
		request.setAttribute("pager", pager);
		request.setAttribute("wbaseRoleForm", pageRoleForm);

		return mapping.findForward("showRoleList");
	}

	/**
	 * 编辑角色
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward editRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbaseRoleForm RoleForm = (WbaseRoleForm) form;
		String todo = RoleForm.getTodo();
		String forward = "";
		if (TODO_CREATE.equals(todo)) {
			RoleForm.setIsFlag(1);
			forward = "createRole";
		} else if (TODO_UPDATE.equals(todo)) {
			String id = RoleForm.getId();
			WbaseRole Role = wbaseRoleService.findRoleById(id);
			RoleForm = (WbaseRoleForm) this.modelToForm(Role,
					"com.wingo.wbase.web.form.WbaseRoleForm");
			forward = "updateRole";
		} else {
			log.error("createOrUpdateRole－TODO参数传递错误或为空！");
		}

		request.setAttribute("wbaseRoleForm", RoleForm);
		return mapping.findForward(forward);
	}

	/**
	 * 新建角色
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward createRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbaseRoleForm RoleForm = (WbaseRoleForm) form;
		WbaseRole Role = new WbaseRole();
		String todo = RoleForm.getTodo();
		String msg = "新增成功!";
		String roleNo = RoleForm.getRoleNo();
		WbaseRole roleObj = wbaseRoleService.findRoleByRoleNo(roleNo);
		if (roleObj == null) {
			Role = (WbaseRole) this.formToModel(RoleForm,
					"com.wingo.wbase.model.WbaseRole");
			boolean flag = false;
			Role.setCreateDate(new Date());
			flag = wbaseRoleService.createRole(Role);
			msg = flag ? "新增成功!" : "新增失败!";
		} else {
			msg = "该角色编号已被使用,新增失败!";
			RoleForm = new WbaseRoleForm();
			RoleForm.setIsFlag(1);
			request.setAttribute("wbaseRoleForm", RoleForm);
			request.setAttribute(Constants.ALERT_MESSAGE, msg);
			return mapping.findForward("createRole");
		}
		if (TODO_CREATE.equals(todo)) {
			RoleForm = new WbaseRoleForm();
			RoleForm.setIsFlag(1);
			request.setAttribute("wbaseRoleForm", RoleForm);
			request.setAttribute(Constants.ALERT_MESSAGE, msg);
			return mapping.findForward("createRole");
		} else {
			request.setAttribute("wbaseRoleForm", RoleForm);
			this.returnJsMsg(response, msg, "window.close();");
			return null;
		}

	}

	/**
	 * 修改角色
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbaseRoleForm RoleForm = (WbaseRoleForm) form;
		boolean flag = true;
		try {
			WbaseRole Role = wbaseRoleService.findRoleById(RoleForm.getId());
			Role.setRoleName(RoleForm.getRoleName());
			Role.setViewOrder(RoleForm.getViewOrder());
			Role.setIsFlag(RoleForm.getIsFlag());
			Role.setRemark(RoleForm.getRemark());
			wbaseRoleService.updateRole(Role);
			RoleForm.setTodo("update");
			request.setAttribute("wbaseRoleForm", RoleForm);
		} catch (Exception e) {
			flag = false;
		}
		request.setAttribute(Constants.ALERT_MESSAGE, flag == true ? "修改成功！"
				: "修改失败！");
		return mapping.findForward("updateRole");
	}

	/**
	 * 删除角色
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbaseRoleForm RoleForm = (WbaseRoleForm) form;
		boolean flag = wbaseRoleService.deleteRoleByIds(RoleForm
				.getSelectedRow());
		request.setAttribute(Constants.ALERT_MESSAGE, flag == true ? "删除成功！"
				: "删除失败！");
		pageRoleForm = new WbaseRoleForm();
		request.setAttribute("wbaseRoleForm", pageRoleForm);
		return showRoleList(mapping, form, request, response);
	}

}
