package com.wingo.wbase.web.action;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wingo.wbase.common.Constants;
import com.wingo.wbase.common.base.BaseAction;
import com.wingo.wbase.common.helper.SpringHelper;
import com.wingo.wbase.model.WbaseOrg;
import com.wingo.wbase.service.WbaseOrgService;
import com.wingo.wbase.web.form.WbaseOrgForm;

/**
 * @Title: OrgAction.java
 * @Package com.wingo.wbase.web.action
 * @Description: TODO(用一句话描述该文件做什么)
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午02:42:14
 * @version V1.0
 */
public class OrgAction extends BaseAction {

	private WbaseOrgService wbaseOrgService = (WbaseOrgService) SpringHelper
			.getBean("wbaseOrgService");

	/**
	 * 创建组织对象
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward editOrg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbaseOrgForm wbaseOrgForm = (WbaseOrgForm) form;
		String todo = wbaseOrgForm.getTodo();
		String forward = "";
		if (TODO_CREATE.equals(todo)) {
			Long nodeNo = new Date().getTime();
			wbaseOrgForm.setNodeNo(nodeNo);
			wbaseOrgForm.setIsFlag(1);
			forward = "createOrg";
		} else if (TODO_UPDATE.equals(todo)) {
			Long nodeNo = wbaseOrgForm.getNodeNo();
			WbaseOrg org = wbaseOrgService.findOrgByNodeNo(nodeNo);
			wbaseOrgForm = (WbaseOrgForm) this.modelToForm(org,
					"com.wingo.wbase.web.form.WbaseOrgForm");
			forward = "updateOrg";
		} else {
			log.error("createOrUpdateOrg－TODO参数传递错误或为空！");
		}

		request.setAttribute("wbaseOrgForm", wbaseOrgForm);
		return mapping.findForward(forward);
	}

	/**
	 * 新建组织对象
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward createOrg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbaseOrgForm wbaseOrgForm = (WbaseOrgForm) form;
		String msg = "新增成功!";
		String todo = wbaseOrgForm.getTodo();
		Long subNodeNo = wbaseOrgForm.getSubNodeNo();
		String orgNo = wbaseOrgForm.getOrgNo();
		WbaseOrg orgObj = wbaseOrgService.findOrgByOrgNo(orgNo);
		if (orgObj == null) {
			WbaseOrg org = new WbaseOrg();
			org = (WbaseOrg) this.formToModel(wbaseOrgForm,
					"com.wingo.wbase.model.WbaseOrg");
			org.setCreateDate(new Date());
			boolean flag = wbaseOrgService.createOrg(org);
			msg = flag ? "新增成功!" : "新增失败!";
		}else{
			msg = "该组织编号已被使用,新增失败!";
			wbaseOrgForm = new WbaseOrgForm();
			Long nodeNo = new Date().getTime();
			wbaseOrgForm.setSubNodeNo(subNodeNo);
			wbaseOrgForm.setNodeNo(nodeNo);
			wbaseOrgForm.setIsFlag(1);
			request.setAttribute("wbaseOrgForm", wbaseOrgForm);
			request.setAttribute(Constants.ALERT_MESSAGE, msg);
			return mapping.findForward("createOrg");
		}
		if (TODO_CREATE.equals(todo)) {
			wbaseOrgForm = new WbaseOrgForm();
			Long nodeNo = new Date().getTime();
			wbaseOrgForm.setSubNodeNo(subNodeNo);
			wbaseOrgForm.setNodeNo(nodeNo);
			wbaseOrgForm.setIsFlag(1);
			request.setAttribute("wbaseOrgForm", wbaseOrgForm);
			request.setAttribute(Constants.ALERT_MESSAGE, msg);
			return mapping.findForward("createOrg");
		} else {
			request.setAttribute("wbaseOrgForm", wbaseOrgForm);
			this.returnJsMsg(response, msg,
					"window.close();");
			return null;
		}
	}

	/**
	 * 修改组织对象
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateOrg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbaseOrgForm wbaseOrgForm = (WbaseOrgForm) form;
		String orgNo = wbaseOrgForm.getOrgNo();
		String msg = "修改成功！";
		try {
			WbaseOrg orgObj = wbaseOrgService.findOrgByOrgNo(orgNo);
			if(orgObj!=null){
				if(orgObj.getId().equals(wbaseOrgForm.getId())){
					WbaseOrg org = wbaseOrgService.findOrgById(wbaseOrgForm.getId());
					org.setOrgNo(wbaseOrgForm.getOrgNo());
					org.setOrgName(wbaseOrgForm.getOrgName());
					org.setSubNodeNo(wbaseOrgForm.getSubNodeNo());
					org.setIsFlag(wbaseOrgForm.getIsFlag());
					org.setViewOrder(wbaseOrgForm.getViewOrder());
					org.setRemark(wbaseOrgForm.getRemark());
					wbaseOrgService.updateOrg(org);
					wbaseOrgForm.setTodo("update");
					request.setAttribute("wbaseOrgForm", wbaseOrgForm);
				}else{
					msg = "该资源编号已被使用,修改失败!";
				}
			}else{
				WbaseOrg org = wbaseOrgService.findOrgById(wbaseOrgForm.getId());
				org.setOrgNo(wbaseOrgForm.getOrgNo());
				org.setOrgName(wbaseOrgForm.getOrgName());
				org.setSubNodeNo(wbaseOrgForm.getSubNodeNo());
				org.setIsFlag(wbaseOrgForm.getIsFlag());
				org.setViewOrder(wbaseOrgForm.getViewOrder());
				org.setRemark(wbaseOrgForm.getRemark());
				wbaseOrgService.updateOrg(org);
				wbaseOrgForm.setTodo("update");
				request.setAttribute("wbaseOrgForm", wbaseOrgForm);
			}
		} catch (Exception e) {
			msg = "修改失败!";
		}
		request.setAttribute(Constants.ALERT_MESSAGE,msg);

		return mapping.findForward("updateOrg");
	}

	/**
	 * 删除组织对象
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteOrg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbaseOrgForm wbaseOrgForm = (WbaseOrgForm) form;
		boolean flag = true;
		try {
			wbaseOrgService.deleteOrgById(wbaseOrgForm.getId());
		} catch (Exception e) {
			flag = false;
		}
		request.setAttribute(Constants.ALERT_MESSAGE, flag == true ? "删除成功！"
				: "删除失败！");
		request.setAttribute(Constants.ALERT_EXTJS,
				"parent.window.location.reload(true);");
		return mapping.findForward("deleteOrg");
	}
}
