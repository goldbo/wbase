package com.wingo.wbase.common.module.quartz.task;

import java.io.IOException;
import java.util.Date;
import java.util.TimerTask;

import com.wingo.wbase.common.helper.SpringHelper;
import com.wingo.wbase.service.ReportService;

public class MyTask extends TimerTask {

	private ReportService reportService = (ReportService) SpringHelper
			.getBean("reportService");

	public void run() {
		Date dd = new Date();
		try {
			reportService.onAmline();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("MyTask 正在执行..." + dd.getHours() + ":"
				+ dd.getMinutes() + ":" + dd.getSeconds());
	}

}
