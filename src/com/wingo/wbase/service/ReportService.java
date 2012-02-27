package com.wingo.wbase.service;

import java.io.IOException;
import java.util.List;

import com.wingo.wbase.common.base.BaseServiceImpl;
import com.wingo.wbase.dao.ReportDao;
import com.wingo.wbase.report.pojo.ClusteredLine;
import com.wingo.wbase.report.pojo.StackedLine;
import com.wingo.wbase.report.pojo.TreeLine;
/**
 * 用户认证SERVICE
 * @author xms
 *
 */
public class ReportService extends BaseServiceImpl {
	private ReportDao reportDao;
	
	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}

	public List viewData(){
		return reportDao.viewData();
	}
	
	public void onAmline() throws IOException{
		reportDao.onAmline();
	}

	public List<StackedLine> stackedLineReport(){
		return reportDao.stackedLineData();
	}
	
	public List<ClusteredLine> clusteredLineReport(){
		return reportDao.clusteredLineData();
	}
	
	public List<TreeLine> treeLineReport(){
		return reportDao.treeLineData();
	}

}
