package com.wingo.wbase.dao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wingo.wbase.common.base.BaseDAOHibernate;
import com.wingo.wbase.report.pojo.ClusteredLine;
import com.wingo.wbase.report.pojo.StackedLine;
import com.wingo.wbase.report.pojo.TreeLine;
import com.wingo.wbase.web.form.Graphs;

public class ReportDao extends BaseDAOHibernate {
	private static final Log log = LogFactory.getLog(ReportDao.class);

	/**
	 * 累加柱状折线组合图
	 * @return
	 */
	public List<StackedLine> stackedLineData() {

		List<StackedLine> slist = new ArrayList<StackedLine>();

		for (int i = 1,k=4; i <= 12; i++) {
			StackedLine sline = new StackedLine();
			Random ra = new Random();
			sline.setXaxis(k+"月");
			sline.setColumnar1(ra.nextInt(100) + 1);
			sline.setColumnar2(ra.nextInt(56) + 1);
			sline.setColumnar3(ra.nextInt(43) + 1);
			sline.setColumnar4(ra.nextInt(78) + 1);
			sline.setLine(ra.nextInt(20) + 1);
			slist.add(sline);
			k++;
			if(k>12){
				k=1;
			}
		}

		return slist;

	}
	
	/**
	 * 柱状折线组合图
	 * @return
	 */
	public List<ClusteredLine> clusteredLineData() {

		List<ClusteredLine> slist = new ArrayList<ClusteredLine>();

		for (int i = 1,k=4; i <= 12; i++) {
			ClusteredLine sline = new ClusteredLine();
			Random ra = new Random();
			sline.setXaxis(k+"月");
			sline.setColumnar(ra.nextInt(100) + 1);
			sline.setLine(ra.nextInt(56) + 1);
			slist.add(sline);
			k++;
			if(k>12){
				k=1;
			}
		}

		return slist;

	}
	
	/**
	 * 折线组合图
	 * @return
	 */
	public List<TreeLine> treeLineData() {

		List<TreeLine> slist = new ArrayList<TreeLine>();

		for (int i = 1; i <= 31; i++) {
			TreeLine tline = new TreeLine();
			Random ra = new Random();
			tline.setXaxis(String.valueOf(i));
			tline.setLine1(ra.nextInt(56) + 1);
			tline.setLine2(ra.nextInt(26) + 1);
			tline.setLine3(ra.nextInt(46) + 1);
			slist.add(tline);
		}

		return slist;

	}
	
	/**
	 * 基本数据
	 * @return
	 */
	public List viewData() {

		Graphs graphs1 = new Graphs();
		Graphs graphs2 = new Graphs();
		Graphs graphs3 = new Graphs();

		List tempList = new ArrayList();

		List<String> timelist = new ArrayList<String>();

		List alist = new ArrayList();
		List blist = new ArrayList();
		List clist = new ArrayList();
		
		for (int i = 0; i < 31; i++) {
			timelist.add(String.valueOf(i));
			Random ra = new Random();
			alist.add(ra.nextInt(100) + 1);
			blist.add(ra.nextInt(99) + 1);
			clist.add(ra.nextInt(55) + 1);
		}

		graphs1.setTitle("第1条曲线");
		graphs1.setGraphValues(alist);

		graphs2.setTitle("第2条曲线");
		graphs2.setGraphValues(blist);
		
		graphs3.setTitle("第3条曲线");
		graphs3.setGraphValues(clist);

		tempList.add(0, timelist);
		tempList.add(1, graphs1);
		tempList.add(2, graphs2);
		tempList.add(2, graphs3);

		return tempList;

	}

	/**
	 * 实时数据填充
	 * @return
	 * @throws IOException 
	 */
	public void onAmline() throws IOException {

		Graphs graphs1 = new Graphs();
		Graphs graphs2 = new Graphs();

		List tempList = new ArrayList();

		List<String> timelist = new ArrayList<String>();

		List alist = new ArrayList();
		List blist = new ArrayList();

		Date dd = new Date();
		Long a = dd.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

		for (int i = 0; i < 10; i++) {
			a = a - 1000;
			String time = sdf.format(a);
			System.out.println("aaaaaaa" + time);
			timelist.add(time);
			Random ra = new Random();
			alist.add(ra.nextInt(100) + 1);
			blist.add(ra.nextInt(99) + 1);
		}

		graphs1.setTitle("第1条曲线");
		graphs1.setGraphValues(alist);

		graphs2.setTitle("第2条曲线");
		graphs2.setGraphValues(blist);

		tempList.add(0, timelist);
		tempList.add(1, graphs1);
		tempList.add(2, graphs2);
		
//		FreeMarkerUtils freeMarkerUtils = new FreeMarkerUtils();
//		freeMarkerUtils.amlineShow(tempList);


	}
}
