package com.wingo.wbase.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wingo.wbase.common.Constants;
import com.wingo.wbase.common.base.BaseAction;
import com.wingo.wbase.common.helper.SpringHelper;
import com.wingo.wbase.model.WbaseSysCompany;
import com.wingo.wbase.service.WbaseSysCompanyService;
import com.wingo.wbase.web.form.WbaseSysCompanyForm;

/**
 * @Title: SysCompanyAction.java
 * @Package com.wingo.wbase.web.action
 * @Description: TODO(用一句话描述该文件做什么)
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午02:42:14
 * @version V1.0
 */
public class SysCompanyAction extends BaseAction {

	private WbaseSysCompanyService wbaseSysCompanyService = (WbaseSysCompanyService) SpringHelper
			.getBean("wbaseSysCompanyService");

	/**
	 * 显示企业信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward showSysCompany(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbaseSysCompanyForm sysCompanyForm = new WbaseSysCompanyForm();
		WbaseSysCompany com = wbaseSysCompanyService.getSysCompany();
		if (com != null) {
			sysCompanyForm = (WbaseSysCompanyForm) this.modelToForm(com,
					"com.wingo.wbase.web.form.WbaseSysCompanyForm");
		}
		request.setAttribute("wbaseSysCompanyForm", sysCompanyForm);

		return mapping.findForward("showSysCompany");
	}

	/**
	 * 修改企业
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateSysCompany(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		WbaseSysCompanyForm SysCompanyForm = (WbaseSysCompanyForm) form;
		boolean flag = true;
		String id = SysCompanyForm.getId();
		WbaseSysCompany com = new WbaseSysCompany();
		try {
			if (id.equals("") || id == "") {

				com = (WbaseSysCompany) this.formToModel(SysCompanyForm,
						"com.wingo.wbase.model.WbaseSysCompany");
				flag = wbaseSysCompanyService.createSysCompany(com);
			} else {
				com = wbaseSysCompanyService.findSysCompanyById(SysCompanyForm
						.getId());
				com.setComName(SysCompanyForm.getComName());
				com.setComLogo(SysCompanyForm.getComLogo());
				com.setComRemark(SysCompanyForm.getComRemark());
				wbaseSysCompanyService.updateSysCompany(com);
			}
			request.setAttribute("wbaseSysCompanyForm", SysCompanyForm);
		} catch (Exception e) {
			flag = false;
		}
		request.setAttribute(Constants.ALERT_MESSAGE, flag == true ? "修改成功！"
				: "修改失败！");
		return mapping.findForward("updateSysCompany");
	}

}
