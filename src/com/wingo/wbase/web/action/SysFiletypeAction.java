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
import com.wingo.wbase.model.WbaseSysFiletype;
import com.wingo.wbase.service.WbaseSysFiletypeService;
import com.wingo.wbase.web.form.WbaseSysFiletypeForm;

/**
 * @Title: SysFiletypeAction.java
 * @Package com.wingo.wbase.web.action
 * @Description: TODO(用一句话描述该文件做什么)
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午02:42:14
 * @version V1.0
 */
public class SysFiletypeAction extends BaseAction {

	private WbaseSysFiletypeService wbaseSysFiletypeService = (WbaseSysFiletypeService) SpringHelper
			.getBean("wbaseSysFiletypeService");

	private static WbaseSysFiletypeForm pageSysFiletypeForm = null;

	/**
	 * 显示所有文件类型信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward showSysFiletypeList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		pageSysFiletypeForm = (WbaseSysFiletypeForm) form;
		List datas = null;
		int total = 0;// 总记录数
		Pager pager = null;// 分页信息
		total = wbaseSysFiletypeService.getTotalByOther(pageSysFiletypeForm);
		pager = PagerHelper.getPager(request, total);

		datas = wbaseSysFiletypeService.getSysFiletypeListByOther(
				pageSysFiletypeForm, pager.getPageSize(), pager.getStartRow());

		request.setAttribute("datas", datas);
		request.setAttribute("pager", pager);
		request.setAttribute("wbaseSysFiletypeForm", pageSysFiletypeForm);

		return mapping.findForward("showSysFiletypeList");
	}

	/**
	 * 创建文件类型
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward editSysFiletype(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		WbaseSysFiletypeForm SysFiletypeForm = (WbaseSysFiletypeForm) form;
		String todo = SysFiletypeForm.getTodo();
		String forward = "";
		if (TODO_CREATE.equals(todo)) {
			forward = "createSysFiletype";
		} else if (TODO_UPDATE.equals(todo)) {
			String id = SysFiletypeForm.getId();
			WbaseSysFiletype SysFiletype = wbaseSysFiletypeService
					.findSysFiletypeById(id);
			SysFiletypeForm = (WbaseSysFiletypeForm) this.modelToForm(
					SysFiletype,
					"com.wingo.wbase.web.form.WbaseSysFiletypeForm");
			forward = "updateSysFiletype";
		} else {
			log.error("createOrupdateSysFiletype－TODO参数传递错误或为空！");
		}

		request.setAttribute("wbaseSysFiletypeForm", SysFiletypeForm);
		return mapping.findForward(forward);
	}

	/**
	 * 新建文件类型
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward createSysFiletype(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		WbaseSysFiletypeForm SysFiletypeForm = (WbaseSysFiletypeForm) form;
		String msg = "新增成功!";
		String todo = SysFiletypeForm.getTodo();
		WbaseSysFiletype fileType = wbaseSysFiletypeService
				.findSysFiletypeByFileSuffix(SysFiletypeForm.getFileSuffix());
		if (fileType == null) {
			WbaseSysFiletype SysFiletype = new WbaseSysFiletype();
			SysFiletype = (WbaseSysFiletype) this.formToModel(SysFiletypeForm,
					"com.wingo.wbase.model.WbaseSysFiletype");
			boolean flag = wbaseSysFiletypeService
					.createSysFiletype(SysFiletype);
			msg = flag ? "新增成功!" : "新增失败!";
		} else {
			msg = "该扩展名已添加!";
			request.setAttribute(Constants.ALERT_MESSAGE, msg);
			return mapping.findForward("createSysFiletype");
		}

		if (TODO_CREATE.equals(todo)) {
			SysFiletypeForm = new WbaseSysFiletypeForm();
			request.setAttribute("wbaseSysFiletypeForm", SysFiletypeForm);
			request.setAttribute(Constants.ALERT_MESSAGE, msg);
			return mapping.findForward("createSysFiletype");
		} else {
			this.returnJsMsg(response, msg, "window.close();");
			return null;
		}

	}

	/**
	 * 修改文件类型
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateSysFiletype(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		WbaseSysFiletypeForm SysFiletypeForm = (WbaseSysFiletypeForm) form;
		String msg = "修改成功!";
		try {
			WbaseSysFiletype fileType = wbaseSysFiletypeService
					.findSysFiletypeByFileSuffix(SysFiletypeForm
							.getFileSuffix());
			if (fileType != null) {
				if (fileType.getId().equals(SysFiletypeForm.getId())) {
					WbaseSysFiletype SysFiletype = wbaseSysFiletypeService
							.findSysFiletypeById(SysFiletypeForm.getId());
					SysFiletype.setFilePic(SysFiletypeForm.getFilePic());
					SysFiletype.setFileRemark(SysFiletypeForm.getFileRemark());
					SysFiletype.setFileSuffix(SysFiletypeForm.getFileSuffix());
					wbaseSysFiletypeService.updateSysFiletype(SysFiletype);
					SysFiletypeForm.setTodo("update");
					request.setAttribute("wbaseSysFiletypeForm",
							SysFiletypeForm);
				} else {
					msg = "该扩展名已被使用,修改失败!";
				}
			} else {
				WbaseSysFiletype SysFiletype = wbaseSysFiletypeService
						.findSysFiletypeById(SysFiletypeForm.getId());
				SysFiletype.setFilePic(SysFiletypeForm.getFilePic());
				SysFiletype.setFileRemark(SysFiletypeForm.getFileRemark());
				SysFiletype.setFileSuffix(SysFiletypeForm.getFileSuffix());
				wbaseSysFiletypeService.updateSysFiletype(SysFiletype);
				SysFiletypeForm.setTodo("update");
				request.setAttribute("wbaseSysFiletypeForm", SysFiletypeForm);
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "修改失败!";
		}
		request.setAttribute(Constants.ALERT_MESSAGE, msg);
		return mapping.findForward("updateSysFiletype");
	}

	/**
	 * 删除文件类型
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteSysFiletype(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		WbaseSysFiletypeForm SysFiletypeForm = (WbaseSysFiletypeForm) form;
		boolean flag = wbaseSysFiletypeService
				.deleteSysFiletypeByIds(SysFiletypeForm.getSelectedRow());
		request.setAttribute(Constants.ALERT_MESSAGE, flag == true ? "删除成功！"
				: "删除失败！");
		pageSysFiletypeForm = new WbaseSysFiletypeForm();
		request.setAttribute("wbaseSysFiletypeForm", pageSysFiletypeForm);
		return showSysFiletypeList(mapping, form, request, response);
	}

}
