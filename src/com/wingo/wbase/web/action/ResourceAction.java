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
import com.wingo.wbase.model.WbaseResource;
import com.wingo.wbase.service.WbaseResourceService;
import com.wingo.wbase.web.form.WbaseResourceForm;

/**
 * @Title: ResourceAction.java
 * @Package com.wingo.wbase.web.action
 * @Description: TODO(用一句话描述该文件做什么)
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午02:42:14
 * @version V1.0
 */
public class ResourceAction extends BaseAction {

	private WbaseResourceService wbaseResourceService = (WbaseResourceService) SpringHelper
			.getBean("wbaseResourceService");

	/**
	 * 创建资源
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward editResource(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbaseResourceForm ResourceForm = (WbaseResourceForm) form;
		String todo = ResourceForm.getTodo();
		String forward = "";
		if (TODO_CREATE.equals(todo)) {
			Long nodeNo = new Date().getTime();
			ResourceForm.setNodeNo(nodeNo);
			ResourceForm.setIsFlag(1);
			forward = "createResource";
		} else if (TODO_UPDATE.equals(todo)) {
			Long nodeNo = ResourceForm.getNodeNo();
			WbaseResource Resource = wbaseResourceService
					.findResourceByNodeNo(nodeNo);
			ResourceForm = (WbaseResourceForm) this.modelToForm(Resource,
					"com.wingo.wbase.web.form.WbaseResourceForm");
			forward = "updateResource";
		} else {
			log.error("createOrUpdateResource－TODO参数传递错误或为空！");
		}

		request.setAttribute("wbaseResourceForm", ResourceForm);
		return mapping.findForward(forward);
	}

	/**
	 * 新建资源
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward createResource(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbaseResourceForm ResourceForm = (WbaseResourceForm) form;
		// 判断资源编号唯一
		WbaseResource resNoObj = wbaseResourceService
				.findResourceByResNo(ResourceForm.getResNo());
		String msg = "新增成功!";
		if (resNoObj == null) {
			WbaseResource Resource = new WbaseResource();

			Resource = (WbaseResource) this.formToModel(ResourceForm,
					"com.wingo.wbase.model.WbaseResource");
			boolean flag = wbaseResourceService.createResource(Resource);
			msg = flag ? "新增成功!" : "新增失败!";
		} else {
			msg = "该资源编号已被使用,新增失败!";
		}

		request.setAttribute("wbaseResourceForm", ResourceForm);
		this.returnJsMsg(response, msg, "window.close();");

		return null;
	}

	/**
	 * 修改资源
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateResource(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbaseResourceForm ResourceForm = (WbaseResourceForm) form;
		String msg = "修改成功!";
		try {
			// 判断资源编号唯一
			WbaseResource resNoObj = wbaseResourceService
					.findResourceByResNo(ResourceForm.getResNo());
			if (resNoObj != null) {

				if (resNoObj.getId().equals(ResourceForm.getId())) {
					WbaseResource Resource = wbaseResourceService
							.findResourceById(ResourceForm.getId());
					// 如果修改了资源编号，删除资源编号对应的权限信息
//					if (!resNoObj.getResNo().equals(
//							ResourceForm.getResNo().trim())) {
//						List<WbasePower> plist = wbasePowerService.findPowerByResNodeNo(resNodeNo)
//						if (plist != null) {
//							for (int i = 0; i < plist.size(); i++) {
//								WbasePower power = (WbasePower) plist.get(i);
//								wbasePowerService.deletePower(power);
//							}
//						}
//					}
					Resource.setResName(ResourceForm.getResName());
					Resource.setResNo(ResourceForm.getResNo());
					Resource.setSubNodeNo(ResourceForm.getSubNodeNo());
					Resource.setResLevel(ResourceForm.getResLevel());
					Resource.setResPath(ResourceForm.getResPath());
					Resource.setResPic(ResourceForm.getResPic());
					Resource.setIsFlag(ResourceForm.getIsFlag());
					Resource.setIsTarget(ResourceForm.getIsTarget());
					Resource.setViewOrder(ResourceForm.getViewOrder());
					Resource.setRemark(ResourceForm.getRemark());
					wbaseResourceService.updateResource(Resource);
					ResourceForm.setTodo("update");
					request.setAttribute("wbaseResourceForm", ResourceForm);
				} else {
					msg = "该资源编号已被使用,修改失败!";
				}

			} else {
				WbaseResource Resource = wbaseResourceService
						.findResourceById(ResourceForm.getId());
				// 如果修改了资源编号，删除资源编号对应的权限信息
//				if (!Resource.getResNo().equals(ResourceForm.getResNo().trim())) {
//					List<WbasePower> plist = wbasePowerService
//							.findPowerByResNo(Resource.getResNo());
//					if (plist != null) {
//						for (int i = 0; i < plist.size(); i++) {
//							WbasePower power = (WbasePower) plist.get(i);
//							wbasePowerService.deletePower(power);
//						}
//					}
//				}
				Resource.setResName(ResourceForm.getResName());
				Resource.setResNo(ResourceForm.getResNo());
				Resource.setSubNodeNo(ResourceForm.getSubNodeNo());
				Resource.setResLevel(ResourceForm.getResLevel());
				Resource.setResPath(ResourceForm.getResPath());
				Resource.setResPic(ResourceForm.getResPic());
				Resource.setIsFlag(ResourceForm.getIsFlag());
				Resource.setViewOrder(ResourceForm.getViewOrder());
				Resource.setRemark(ResourceForm.getRemark());
				wbaseResourceService.updateResource(Resource);
				ResourceForm.setTodo("update");
				request.setAttribute("wbaseResourceForm", ResourceForm);
			}
		} catch (Exception e) {
			msg = "修改失败!";
		}
		request.setAttribute(Constants.ALERT_MESSAGE, msg);
		request.setAttribute(Constants.ALERT_EXTJS,
				"parent.leftDesk.window.location.reload(true);");

		return mapping.findForward("updateResource");
	}

	/**
	 * 删除资源
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteResource(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbaseResourceForm ResourceForm = (WbaseResourceForm) form;
		boolean flag = true;
		try {
			wbaseResourceService.deleteResourceById(ResourceForm.getId());
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		request.setAttribute(Constants.ALERT_MESSAGE, flag == true ? "删除成功!"
				: "删除失败!");
		request.setAttribute(Constants.ALERT_EXTJS,
				"parent.window.location.reload(true);");
		return mapping.findForward("deleteResource");
	}

}
