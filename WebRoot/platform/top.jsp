<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="com.wingo.wbase.model.ViewUserInfo"%>
<%@ page import="com.wingo.wbase.model.WbaseSysCompany"%>
<%@ page import="com.wingo.wbase.model.WbaseSysMessages"%>
<%@ page import="com.wingo.wbase.common.Constants"%>
<%@ page import="com.wingo.wbase.common.SystemCache"%>
<%
			ViewUserInfo user = (ViewUserInfo) session
			.getAttribute(Constants.LOGIN_USER);
	Map sysCache = SystemCache.sysCache;
	//企业信息
	WbaseSysCompany com = (WbaseSysCompany) sysCache
			.get(Constants.WBASE_SYS_COM);
	String logo = "/common/images/top/logo.jpg";
	if (com != null) {
		logo = com.getComLogo();
	}
	//滚动消息
	List<WbaseSysMessages> msgList = (List<WbaseSysMessages>) sysCache
			.get(Constants.WBASE_SYS_MSG);
%>
<html:html lang="true">
<head>
	<html:base />
	<title>管理平台－顶部页面</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css"
		href="<%=baseURL%>/common/css/style_top.css">
	<script type="text/javascript" src="<%=baseURL%>/common/js/top.js"></script>
	<script type="text/javascript">

function updateUserInfo(url,width,height){
	window.showModalDialog("<%=baseURL%>"+url, "", "dialogWidth="+width+"px;dialogHeight="+height+"px;status:no;");
}
</script>

</head>
<body topmargin="0">
	<div id="Head1">
		<div id="Logo">
			<img border="0" width="291" height="41" id="logoimage"
				src="<%=baseURL + logo%>" onload="javascript:DrawImage(this,291,41);" />
		</div>
		<div id="Head1Right">
			<div id="Head1Right_UserName">
				<img border="0" width="13" height="14"
					src="<%=baseURL%>/common/images/top/user.gif" />
				您好,
				<b><%=user.getUserName()%>
				</b>
			</div>
			<div id="Head1Right_UserDept">
				(
				<%=user.getOrgName()%>
				)
			</div>
			<div id="Head1Right_UserSetup">
				<a
					onclick="updateUserInfo('/platform/user/update_userinfo.jsp',750,600);return false;"
					href="javascript:(0);"> <img border="0" width="13" height="14"
						src="<%=baseURL%>/common/images/top/user_setup.gif" /> 个人设置 </a>
			</div>
			<div id="Head1Right_Time">
				<script type="text/javascript">showTime();</script>
			</div>
		</div>
		<div id="Head1Right_SystemButton">
			<a target="_parent" href="<%=baseURL%>/exit.jsp"><img width="78"
					height="20" alt="退出系统"
					src="<%=baseURL%>/common/images/top/logout.gif" /> </a>
		</div>
		<div id="Head1Right_Button">

			<a target="deskFrame" href="<%=baseURL%>/platform/desk.jsp"><img
					width="65" height="20" alt="显示首页"
					src="<%=baseURL%>/common/images/top/desktop.gif" /> </a>
		</div>
	</div>
	<div id="Head2">
		<div id="Head2_Awoke">
			<ul id="AwokeNum">
				<li style="width: 200px"></li>
				<wbase:shortcut target="deskFrame" type="horizontal" />
			</ul>
		</div>
		<div id="Head2_FunctionList">
			<MARQUEE ONMOUSEOVER=this.stop() STYLE="WIDTH: 100%;"
				ONMOUSEOUT=this.start() SCROLLAMOUNT=1 SCROLLDELAY=30 DIRECTION=left>
				<%
						if (!msgList.isEmpty() && msgList != null) {
						for (int max = msgList.size(), i = 0; i < max; i++) {
							WbaseSysMessages msg = msgList.get(i);
				%>
				<B><a
					href="<%=baseURL%>/SysMessagesAction.do?action=editSysMessages&todo=read&id=<%=msg.getId()%>"
					target="_blank" style="color: white"><%=msg.getMsgTitle()%>
				</a>
				</B>
				<%
					}
					}
				%>

			</MARQUEE>

		</div>
	</div>
</body>
</html:html>
