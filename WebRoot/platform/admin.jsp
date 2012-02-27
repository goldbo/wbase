<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base />
	<title>网佳科技有限公司－WBASE平台</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--可以在收藏夹中显示出图标-->
	<link rel="Bookmark" type="image/x-icon"
		href="<%=baseURL%>/common/images/favicon.ico" />
	<!--可以在地址栏中显示出图标-->
	<link rel="icon" type="image/x-icon"
		href="<%=baseURL%>/common/images/favicon.ico" />
	<link rel="shortcut icon" type="image/x-icon"
		href="<%=baseURL%>/common/images/favicon.ico" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	
	</script>
</head>
<frameset rows="100,*,28" cols="*" frameborder="NO" border="0"
	framespacing="0">
	<frame src="<%=baseURL%>/platform/top.jsp" scrolling="NO" noresize
		name="topFrame" name="topFrame">
	<frameset cols="200,10,*" frameborder="NO" border="0" framespacing="0"
		id="mainFrame">
		<frame src="<%=baseURL%>/platform/left.jsp" noresize name="leftFrame"
			id="leftFrame">
		<frame src="<%=baseURL%>/platform/leftIcon.jsp" name="leftIcon"
			scrolling="NO" noresize id="leftIcon">
		<frame src="<%=baseURL%>/platform/desk.jsp" name="deskFrame"
			id="deskFrame">
	</frameset>
	<frame src="<%=baseURL%>/platform/bottom.jsp" scrolling="NO" noresize
		name="bottom" id="bottom">
</frameset>
<noframes>
	<body>
	</body>
</noframes>
</html:html>
