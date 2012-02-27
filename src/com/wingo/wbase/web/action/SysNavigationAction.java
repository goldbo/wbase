package com.wingo.wbase.web.action;

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
import com.wingo.wbase.model.WbaseSysNavigation;
import com.wingo.wbase.service.WbaseSysNavigationService;
import com.wingo.wbase.web.form.WbaseSysNavigationForm;

/**
 * @Title: SysNavigationAction.java
 * @Package com.wingo.wbase.web.action
 * @Description: TODO(用一句话描述该文件做什么)
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午02:42:14
 * @version V1.0
 */
public class SysNavigationAction extends BaseAction {

	private WbaseSysNavigationService wbaseSysNavigationService = (WbaseSysNavigationService) SpringHelper
			.getBean("wbaseSysNavigationService");

	private static WbaseSysNavigationForm pageSysNavigationForm = null;
	
	/**
	 * 显示所有底部导航信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward showSysNavigationList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		pageSysNavigationForm = (WbaseSysNavigationForm) form;
		List datas = null;
		int total = 0;// 总记录数
		Pager pager = null;// 分页信息
		total = wbaseSysNavigationService.getTotalByOther(pageSysNavigationForm);
		pager = PagerHelper.getPager(request, total);

		datas = wbaseSysNavigationService.getSysNavigationListByOther(
				pageSysNavigationForm, pager.getPageSize(), pager.getStartRow());

		request.setAttribute("datas", datas);
		request.setAttribute("pager", pager);
		request.setAttribute("wbaseSysNavigationForm", pageSysNavigationForm);

		return mapping.findForward("showSysNavigationList");
	}

	/**
	 * 创建底部导航
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward editSysNavigation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		WbaseSysNavigationForm SysNavigationForm = (WbaseSysNavigationForm) form;
		String todo = SysNavigationForm.getTodo();
		String forward = "";
		if (TODO_CREATE.equals(todo)) {
			SysNavigationForm.setNavFlag(1);
			SysNavigationForm.setNavOpen(1);
			forward = "createSysNavigation";
		} else if (TODO_UPDATE.equals(todo)) {
			String id = SysNavigationForm.getId();
			WbaseSysNavigation SysNavigation = wbaseSysNavigationService
					.findSysNavigationById(id);
			SysNavigationForm = (WbaseSysNavigationForm) this.modelToForm(
					SysNavigation,
					"com.wingo.wbase.web.form.WbaseSysNavigationForm");
			forward = "updateSysNavigation";
		} else if (TODO_READ.equals(todo)) {
			String id = SysNavigationForm.getId();
			WbaseSysNavigation SysNavigation = wbaseSysNavigationService
					.findSysNavigationById(id);
			SysNavigationForm = (WbaseSysNavigationForm) this.modelToForm(
					SysNavigation,
					"com.wingo.wbase.web.form.WbaseSysNavigationForm");
			forward = "viewSysNavigation";
		}else {
			log.error("createOrUpdateSysNavigation－TODO参数传递错误或为空！");
		}

		request.setAttribute("wbaseSysNavigationForm", SysNavigationForm);
		return mapping.findForward(forward);
	}

	/**
	 * 新建底部导航
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward createSysNavigation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		WbaseSysNavigationForm SysNavigationForm = (WbaseSysNavigationForm) form;
		WbaseSysNavigation SysNavigation = new WbaseSysNavigation();
		String msg = "新增成功!";
		String todo = SysNavigationForm.getTodo();
		SysNavigation = (WbaseSysNavigation) this.formToModel(SysNavigationForm,
				"com.wingo.wbase.model.WbaseSysNavigation");
		boolean flag = wbaseSysNavigationService.createSysNavigation(SysNavigation);
		msg = flag ? "新增成功!" : "新增失败!";

		if (TODO_CREATE.equals(todo)) {
			SysNavigationForm = new WbaseSysNavigationForm();
			SysNavigationForm.setNavFlag(1);
			SysNavigationForm.setNavOpen(1);
			request.setAttribute("wbaseSysNavigationForm", SysNavigationForm);
			request.setAttribute(Constants.ALERT_MESSAGE, msg);
			return mapping.findForward("createSysNavigation");
		} else {
			this.returnJsMsg(response, msg, "window.close();");
			return null;
		}

	}

	/**
	 * 修改底部导航
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateSysNavigation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		WbaseSysNavigationForm SysNavigationForm = (WbaseSysNavigationForm) form;
		boolean flag = true;
		try {
			WbaseSysNavigation SysNavigation = wbaseSysNavigationService
					.findSysNavigationById(SysNavigationForm.getId());
			SysNavigation.setNavFlag(SysNavigationForm.getNavFlag());
			SysNavigation.setNavLink(SysNavigationForm.getNavLink());
			SysNavigation.setNavName(SysNavigationForm.getNavName());
			SysNavigation.setNavOpen(SysNavigationForm.getNavOpen());
			wbaseSysNavigationService.updateSysNavigation(SysNavigation);
			SysNavigationForm.setTodo("update");
			request.setAttribute("wbaseSysNavigationForm", SysNavigationForm);
		} catch (Exception e) {
			flag = false;
		}
		request.setAttribute(Constants.ALERT_MESSAGE, flag == true ? "修改成功！"
				: "修改失败！");
		return mapping.findForward("updateSysNavigation");
	}

	/**
	 * 删除底部导航
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteSysNavigation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		WbaseSysNavigationForm SysNavigationForm = (WbaseSysNavigationForm) form;
		boolean flag = wbaseSysNavigationService
				.deleteSysNavigationByIds(SysNavigationForm.getSelectedRow());
		request.setAttribute(Constants.ALERT_MESSAGE, flag == true ? "删除成功！"
				: "删除失败！");
		pageSysNavigationForm = new WbaseSysNavigationForm();
		request.setAttribute("wbaseSysNavigationForm", pageSysNavigationForm);
		return showSysNavigationList(mapping, form, request, response);
	}

}
