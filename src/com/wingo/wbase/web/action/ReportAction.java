package com.wingo.wbase.web.action;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Timer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wingo.wbase.common.base.BaseAction;
import com.wingo.wbase.common.helper.SpringHelper;
import com.wingo.wbase.common.module.quartz.task.MyTask;
import com.wingo.wbase.report.FreeMarkerUtils;
import com.wingo.wbase.report.pojo.ClusteredLine;
import com.wingo.wbase.report.pojo.StackedLine;
import com.wingo.wbase.report.pojo.TreeLine;
import com.wingo.wbase.service.ReportService;

/**
 * @Title: ReportAction.java
 * @Package com.wingo.wbase.web.action
 * @Description: 报表中心
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午02:42:14
 * @version V1.0
 */
public class ReportAction extends BaseAction {

	private ReportService reportService = (ReportService) SpringHelper
			.getBean("reportService");

	/**
	 * 
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward showAmline(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		FreeMarkerUtils freeMarkerUtils = new FreeMarkerUtils();

		List list = reportService.viewData();
		freeMarkerUtils.lineType(list);

		return mapping.findForward("report");
	}
	
	/**
	 * 
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward showTreeLineChart(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		FreeMarkerUtils freeMarkerUtils = new FreeMarkerUtils();

		List<TreeLine> list = reportService.treeLineReport();
		freeMarkerUtils.TreeLineChart(list);

		return mapping.findForward("treeLineReport");
	}
	
	/**
	 * 
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward showClusteredLineChart(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		FreeMarkerUtils freeMarkerUtils = new FreeMarkerUtils();

		List<ClusteredLine> list = reportService.clusteredLineReport();
		freeMarkerUtils.ClusteredLineChart(list);

		return mapping.findForward("clusteredLineReport");
	}
	
	/**
	 * 
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward showStackedLineChart(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		FreeMarkerUtils freeMarkerUtils = new FreeMarkerUtils();

		List<StackedLine> list = reportService.stackedLineReport();
		freeMarkerUtils.StackedLineChart(list);

		return mapping.findForward("stackedLineReport");
	}
	
	
	/**
	 * 
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward onAmline(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Timer timer = new Timer(); 
        MyTask task = new MyTask(); 
        Calendar cal = new GregorianCalendar(2006, 9, 28, 12, 49, 0); 
        Date date = cal.getTime(); 
        System.out.println("date :" + date.toLocaleString()); 
        timer.schedule(task, date, 1000); 

		return mapping.findForward("report");
	}

}
