<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base />
	<title>管理平台－左边栏图标</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
<!--

body {
	margin:0px;
	padding:0px;
	height:100%;
	 
}
-->
</style>
	<script language="JavaScript" type="text/JavaScript">
<!--
function MM_reloadPage(init) {  //reloads the window if Nav4 resized
  if (init==true) with (navigator) {if ((appName=="Netscape")&&(parseInt(appVersion)==4)) {
    document.MM_pgW=innerWidth; document.MM_pgH=innerHeight; onresize=MM_reloadPage; }}
  else if (innerWidth!=document.MM_pgW || innerHeight!=document.MM_pgH) location.reload();
}
MM_reloadPage(true);
function resizeLeft()
{
	var leftImg=document.getElementById("left")
	var srcImg="";
	if(leftImg.src.indexOf("close.jpg")>0)
	{
		if(parent.document.getElementById("mainFrame").cols=='200,10,*')
		{
			parent.document.getElementById("mainFrame").cols='0,10,*'
		}
		srcImg='<%=baseURL%>/common/images/open.jpg'
	}

	if(leftImg.src.indexOf("open.jpg")>0)
	{
		if(parent.document.getElementById("mainFrame").cols=='0,10,*')
		{
			parent.document.getElementById("mainFrame").cols='200,10,*'
		}
		srcImg='<%=baseURL%>/common/images/close.jpg'
	}
	leftImg.src=srcImg
}
//-->
</script>
</head>

<body>

	<table id="Layer1" width="100%" height="100%" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td>
				<img src="<%=baseURL%>/common/images/close.jpg" width="10"
					height="295" onClick="resizeLeft()" id="left" style="cursor:hand ">
			</td>
		</tr>
	</table>
</body>
</html:html>
