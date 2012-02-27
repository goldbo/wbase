package com.wingo.wbase.web.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wingo.wbase.common.Constants;
import com.wingo.wbase.common.base.BaseAction;
import com.wingo.wbase.common.helper.SpringHelper;
import com.wingo.wbase.model.WbasePower;
import com.wingo.wbase.service.WbasePowerService;
import com.wingo.wbase.web.form.WbasePowerForm;

/**
 * @Title: PowerAction.java
 * @Package com.wingo.wbase.web.action
 * @Description: TODO(用一句话描述该文件做什么)
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午02:42:14
 * @version V1.0
 */
public class PowerAction extends BaseAction {

	private WbasePowerService wbasePowerService = (WbasePowerService) SpringHelper
			.getBean("wbasePowerService");

	/**
	 * 编辑权限
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward editPower(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbasePowerForm PowerForm = (WbasePowerForm) form;
		Long resNodeNo = PowerForm.getResNodeNo();
		String roleNo = PowerForm.getRoleNo();
		WbasePower power = wbasePowerService.findPowerByRes(roleNo, resNodeNo);

		if (power == null) {
			PowerForm.setAuto(0);
			PowerForm.setRead(0);
			PowerForm.setUpdate(0);
			PowerForm.setCreate(0);
			PowerForm.setDelete(0);
			PowerForm.setRoleNo(roleNo);
			PowerForm.setResNodeNo(resNodeNo);
		} else {
			PowerForm.setId(power.getId());
			PowerForm.setRoleNo(power.getRoleNo());
			PowerForm.setResNodeNo(power.getResNodeNo());
			Integer powerLevel = power.getPowerLevel();
			PowerForm
					.setAuto(this.checkPower(powerLevel, Constants.POWER_AUTO) ? Constants.POWER_AUTO
							: 0);
			PowerForm
					.setRead(this.checkPower(powerLevel, Constants.POWER_READ) ? Constants.POWER_READ
							: 0);
			PowerForm.setCreate(this.checkPower(powerLevel,
					Constants.POWER_CREATE) ? Constants.POWER_CREATE : 0);
			PowerForm.setUpdate(this.checkPower(powerLevel,
					Constants.POWER_UPDATE) ? Constants.POWER_UPDATE : 0);
			PowerForm.setDelete(this.checkPower(powerLevel,
					Constants.POWER_DELETE) ? Constants.POWER_DELETE : 0);
		}
		request.setAttribute("wbasePowerForm", PowerForm);
		return mapping.findForward("editPower");
	}

	/**
	 * 修改权限
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updatePower(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbasePowerForm PowerForm = (WbasePowerForm) form;
		Long resNodeNo = PowerForm.getResNodeNo();
		String roleNo = PowerForm.getRoleNo();
		String id = PowerForm.getId();
		boolean flag = true;
		try {
			WbasePower power = new WbasePower();
			PowerForm.setTodo("update");
			if (id == "") {
				power.setResNodeNo(resNodeNo);
				power.setRoleNo(roleNo);
				power.setPowerLevel(PowerForm.getPowerLevel());
				id = wbasePowerService.createPower(power);
				power.setId(id);
			} else {
				power = wbasePowerService.findPowerById(PowerForm.getId());
				power.setPowerLevel(PowerForm.getPowerLevel());
				wbasePowerService.updatePower(power);
			}
			PowerForm.setId(power.getId());
			PowerForm.setResNodeNo(power.getResNodeNo());
			PowerForm.setRoleNo(power.getRoleNo());
			PowerForm.setAuto(this.checkPower(power.getPowerLevel(),
					Constants.POWER_AUTO) ? Constants.POWER_AUTO : 0);
			PowerForm.setRead(this.checkPower(power.getPowerLevel(),
					Constants.POWER_READ) ? Constants.POWER_READ : 0);
			PowerForm.setCreate(this.checkPower(power.getPowerLevel(),
					Constants.POWER_CREATE) ? Constants.POWER_CREATE : 0);
			PowerForm.setUpdate(this.checkPower(power.getPowerLevel(),
					Constants.POWER_UPDATE) ? Constants.POWER_UPDATE : 0);
			PowerForm.setDelete(this.checkPower(power.getPowerLevel(),
					Constants.POWER_DELETE) ? Constants.POWER_DELETE : 0);
			request.setAttribute("wbasePowerForm", PowerForm);
		} catch (Exception e) {
			flag = false;
		}
		request.setAttribute(Constants.ALERT_MESSAGE, flag == true ? "修改成功！"
				: "修改失败！");
		return mapping.findForward("updatePower");
	}

	public WbasePowerService getWbasePowerService() {
		return wbasePowerService;
	}

	public void setWbasePowerService(WbasePowerService wbasePowerService) {
		this.wbasePowerService = wbasePowerService;
	}

	public boolean checkPower(int userPurview, int optPurview) {
		int purviewValue = (int) Math.pow(2, optPurview);
		return (userPurview & purviewValue) == purviewValue;
	}

}
