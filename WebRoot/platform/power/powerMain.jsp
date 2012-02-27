<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>

<html:html lang="true">
<head>
	<html:base />

	<title>权限管理</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
</script>
</head>
<frameset cols="30%,*"  frameborder="yes" border="1" framespacing="2">
  <frame src="<%=baseURL%>/platform/power/powerTree.jsp?roleNo=<%=request.getParameter("roleNo").toString() %>" scrolling="auto"  name="leftDesk">
  <frame src="<%=baseURL%>/platform/power/powerDesk.jsp" scrolling="auto"   name="rightDesk">
</frameset>
<noframes>
<body>
</body>
</noframes>
</html:html>
