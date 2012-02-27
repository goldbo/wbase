package com.wingo.wbase.web.action;

import java.text.SimpleDateFormat;
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
import com.wingo.wbase.model.WbaseSysMessages;
import com.wingo.wbase.service.WbaseSysMessagesService;
import com.wingo.wbase.web.form.WbaseSysMessagesForm;

/**
 * @Title: SysMessagesAction.java
 * @Package com.wingo.wbase.web.action
 * @Description: TODO(用一句话描述该文件做什么)
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午02:42:14
 * @version V1.0
 */
public class SysMessagesAction extends BaseAction {

	private WbaseSysMessagesService wbaseSysMessagesService = (WbaseSysMessagesService) SpringHelper
			.getBean("wbaseSysMessagesService");

	private static WbaseSysMessagesForm pageSysMessagesForm = null;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 显示所有系统消息信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward showSysMessagesList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		pageSysMessagesForm = (WbaseSysMessagesForm) form;
		List datas = null;
		int total = 0;// 总记录数
		Pager pager = null;// 分页信息
		total = wbaseSysMessagesService.getTotalByOther(pageSysMessagesForm);
		pager = PagerHelper.getPager(request, total);

		datas = wbaseSysMessagesService.getSysMessagesListByOther(
				pageSysMessagesForm, pager.getPageSize(), pager.getStartRow());

		request.setAttribute("datas", datas);
		request.setAttribute("pager", pager);
		request.setAttribute("wbaseSysMessagesForm", pageSysMessagesForm);

		return mapping.findForward("showSysMessagesList");
	}

	/**
	 * 创建系统消息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward editSysMessages(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		WbaseSysMessagesForm SysMessagesForm = (WbaseSysMessagesForm) form;
		String todo = SysMessagesForm.getTodo();
		String forward = "";
		if (TODO_CREATE.equals(todo)) {
			SysMessagesForm.setMsgStarttime(sdf.format(new Date().getTime()));
			SysMessagesForm.setMsgEndtime(sdf.format(new Date().getTime()+24*60*60*1000));
			forward = "createSysMessages";
		} else if (TODO_UPDATE.equals(todo)) {
			String id = SysMessagesForm.getId();
			WbaseSysMessages SysMessages = wbaseSysMessagesService
					.findSysMessagesById(id);
			SysMessagesForm = (WbaseSysMessagesForm) this.modelToForm(
					SysMessages,
					"com.wingo.wbase.web.form.WbaseSysMessagesForm");
			forward = "updateSysMessages";
		} else if (TODO_READ.equals(todo)) {
			String id = SysMessagesForm.getId();
			WbaseSysMessages SysMessages = wbaseSysMessagesService
					.findSysMessagesById(id);
			SysMessagesForm = (WbaseSysMessagesForm) this.modelToForm(
					SysMessages,
					"com.wingo.wbase.web.form.WbaseSysMessagesForm");
			forward = "viewSysMessages";
		}else {
			log.error("createOrUpdateSysMessages－TODO参数传递错误或为空！");
		}

		request.setAttribute("wbaseSysMessagesForm", SysMessagesForm);
		return mapping.findForward(forward);
	}

	/**
	 * 新建系统消息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward createSysMessages(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		WbaseSysMessagesForm SysMessagesForm = (WbaseSysMessagesForm) form;
		WbaseSysMessages SysMessages = new WbaseSysMessages();
		String msg = "新增成功!";
		String todo = SysMessagesForm.getTodo();
		SysMessages = (WbaseSysMessages) this.formToModel(SysMessagesForm,
				"com.wingo.wbase.model.WbaseSysMessages");
		SysMessages.setMsgStarttime(sdf.parse(SysMessagesForm.getMsgStarttime()));
		SysMessages.setMsgEndtime(sdf.parse(SysMessagesForm.getMsgEndtime()));
		boolean flag = wbaseSysMessagesService.createSysMessages(SysMessages);
		msg = flag ? "新增成功!" : "新增失败!";

		if (TODO_CREATE.equals(todo)) {
			SysMessagesForm = new WbaseSysMessagesForm();
			SysMessagesForm.setMsgStarttime(sdf.format(new Date().getTime()));
			SysMessagesForm.setMsgEndtime(sdf.format(new Date().getTime()+36000));
			request.setAttribute("wbaseSysMessagesForm", SysMessagesForm);
			request.setAttribute(Constants.ALERT_MESSAGE, msg);
			return mapping.findForward("createSysMessages");
		} else {
			this.returnJsMsg(response, msg, "window.close();");
			return null;
		}

	}

	/**
	 * 修改系统消息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateSysMessages(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		WbaseSysMessagesForm SysMessagesForm = (WbaseSysMessagesForm) form;
		boolean flag = true;
		try {
			WbaseSysMessages SysMessages = wbaseSysMessagesService
					.findSysMessagesById(SysMessagesForm.getId());
			SysMessages.setMsgContents(SysMessagesForm.getMsgContents());
			SysMessages.setMsgEndtime(sdf.parse(SysMessagesForm.getMsgEndtime()));
			SysMessages.setMsgFlag(SysMessagesForm.getMsgFlag());
			SysMessages.setMsgStarttime(sdf.parse(SysMessagesForm.getMsgStarttime()));
			SysMessages.setMsgTitle(SysMessagesForm.getMsgTitle());
			SysMessages.setMsgAttachment(SysMessagesForm.getMsgAttachment());
			wbaseSysMessagesService.updateSysMessages(SysMessages);
			SysMessagesForm.setTodo("update");
			request.setAttribute("wbaseSysMessagesForm", SysMessagesForm);
		} catch (Exception e) {
			flag = false;
		}
		request.setAttribute(Constants.ALERT_MESSAGE, flag == true ? "修改成功！"
				: "修改失败！");
		return mapping.findForward("updateSysMessages");
	}

	/**
	 * 删除系统消息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteSysMessages(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		WbaseSysMessagesForm SysMessagesForm = (WbaseSysMessagesForm) form;
		boolean flag = wbaseSysMessagesService
				.deleteSysMessagesByIds(SysMessagesForm.getSelectedRow());
		request.setAttribute(Constants.ALERT_MESSAGE, flag == true ? "删除成功！"
				: "删除失败！");
		pageSysMessagesForm = new WbaseSysMessagesForm();
		request.setAttribute("wbaseSysMessagesForm", pageSysMessagesForm);
		return showSysMessagesList(mapping, form, request, response);
	}

}
