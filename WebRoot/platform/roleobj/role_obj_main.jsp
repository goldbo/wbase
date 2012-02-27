<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<%
	String roleNo = request.getParameter("roleNo").toString();
%>
<html:html lang="true">
<head>
	<html:base target="_self" />
	<title>角色-用户-组织-设置</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function ocSTab(id,url){
	for(var i=1; i<3; i++){
	document.getElementById('STabMenuId_'+i).className='tab_kp_off';
	}
	document.getElementById('STabMenuId_'+id).className='tab_kp_on';
	document.getElementById('iframeCon').src=url;
}
</script>
</head>

<body>

	<table width="100%" height="100%" align="center" border="0"
		cellspacing="0" cellpadding="0" style="border:1px solid #c6d2e3">
		<tr>
			<td height="30" valign="bottom" bgcolor="#f1f7fb">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="10" height="30px" class="tab_kp_off">
							&nbsp;
						</td>
						<td width="100" class="tab_kp_on" id="STabMenuId_1"
							onClick="ocSTab(1,'<%=baseURL%>/platform/roleobj/role_obj_user.jsp?roleNo=<%=roleNo %>')">
							<img border="0" src="<%=baseURL%>/common/images/title_arrow.gif" />角色-用户
						</td>
						<td width="100" class="tab_kp_off" id="STabMenuId_2"
							onClick="ocSTab(2,'<%=baseURL%>/platform/roleobj/role_obj_org.jsp?roleNo=<%=roleNo %>')">
							<img border="0" src="<%=baseURL%>/common/images/title_arrow.gif" />角色-组织
						</td>
						<td class="tab_kp_off">
							&nbsp;
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<iframe id="iframeCon" name="iframeCon" width="100%" height="100%"
					frameborder="0" scrolling="auto" src="<%=baseURL%>/platform/roleobj/role_obj_user.jsp?roleNo=<%=roleNo %>"></iframe>
			</td>
		</tr>
	</table>

	<wbase:showMessage />
</body>
</html:html>
