<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>

<html:html lang="true">
<head>
	<html:base />

	<title>资源树</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="<%=baseURL%>/platform/power/dtree/dtree.css" type="text/css">
<script type="text/javascript" src="<%=baseURL%>/platform/power/dtree/dtree.js"></script>
</head>

<body>
	<div align="left" id="powerTreeDiv">
		<br />
		<p>
			<a href="javascript: powerTree.openAll();">展开</a> |
			<a href="javascript: powerTree.closeAll();">收起</a>
		</p>
		<wbase:powerTree edit="false" target="rightDesk" type="system" roleNo="<%=request.getParameter("roleNo").toString() %>" />
		<br />
	</div>

	<wbase:showMessage />
</body>
</html:html>
