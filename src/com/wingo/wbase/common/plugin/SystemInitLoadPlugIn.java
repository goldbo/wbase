package com.wingo.wbase.common.plugin;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

import com.wingo.wbase.common.Constants;
import com.wingo.wbase.common.SystemCache;
import com.wingo.wbase.common.helper.SpringHelper;
import com.wingo.wbase.model.WbaseSysCompany;
import com.wingo.wbase.model.WbaseSysMessages;
import com.wingo.wbase.model.WbaseSysNavigation;
import com.wingo.wbase.service.WbaseSysCompanyService;
import com.wingo.wbase.service.WbaseSysMessagesService;
import com.wingo.wbase.service.WbaseSysNavigationService;

/**
 * @Title: SystemInitLoadPlugIn.java
 * @Package com.wingo.wbase.common.plugin
 * @Description: 系统相关信息初始缓存
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-4-20 上午10:39:36
 * @version V1.0
 */
public class SystemInitLoadPlugIn implements PlugIn {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	public void init(ActionServlet servlet, ModuleConfig config)
			throws ServletException {
		Map sysCache = Collections.synchronizedMap(new LinkedHashMap());
		// TODO 初始化 企业信息
		WbaseSysCompanyService wbaseSysCompanyService = (WbaseSysCompanyService) SpringHelper
				.getBean("wbaseSysCompanyService");
		WbaseSysCompany com = wbaseSysCompanyService.getSysCompany();
		sysCache.put(Constants.WBASE_SYS_COM, com);

		// TODO 初始化 系统消息
		WbaseSysMessagesService wbaseSysMessagesService = (WbaseSysMessagesService) SpringHelper
				.getBean("wbaseSysMessagesService");
		List<WbaseSysMessages> msgList = wbaseSysMessagesService
				.getSysMessagesList();
		sysCache.put(Constants.WBASE_SYS_MSG, msgList);

		// TODO 初始化 系统文件扩展名
		WbaseSysNavigationService wbaseSysNavigationService = (WbaseSysNavigationService) SpringHelper
				.getBean("wbaseSysNavigationService");
		List<WbaseSysNavigation> navList = wbaseSysNavigationService
				.getSysNavigationList();
		sysCache.put(Constants.WBASE_SYS_NAV, navList);

		// 设置缓存
		SystemCache.sysCache = sysCache;
	}

}
