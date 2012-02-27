<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="com.wingo.wbase.model.WbaseSysCompany"%>
<%@ page import="com.wingo.wbase.common.Constants"%>
<%@ page import="com.wingo.wbase.common.SystemCache"%>
<%
	Map sysCache = SystemCache.sysCache;
	WbaseSysCompany com = (WbaseSysCompany) sysCache
			.get(Constants.WBASE_SYS_COM);
%>
<html:html lang="true">
<head>
	<html:base />
	<title>管理平台－底部页面</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css"
		href="<%=baseURL%>/common/css/style_bottom.css">
</head>

<body leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
	<div id="StatusBar">
		<div id="Online">
			&nbsp;&nbsp;
		</div>
		<div id="Info">
			<wbase:navigation target="deskFrame" type="horizontal" />
		</div>
		<DIV id=DesktopText>
			<%=com==null?"":com.getComName() %>&nbsp;&nbsp;
		</DIV>
	</div>
</body>
</html:html>
