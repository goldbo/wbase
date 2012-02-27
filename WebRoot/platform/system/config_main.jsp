<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base />
	<title>系统基础信息配置</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function openConfig(url,width,height){
	window.showModalDialog("<%=baseURL%>"+url, "", "dialogWidth="+width+"px;dialogHeight="+height+"px;status:no;");
}
</script>
</head>

<body>
	<table width="100%" height="100%" align="center" border="0"
		cellspacing="0" cellpadding="0">
		<tr>
			<td height="30" valign="top" bgcolor="#f1f7fb">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="10" class="tab_kp_off">
							&nbsp;
						</td>
						<td width="100" height="26" class="tab_kp_on">
							基础信息配置
						</td>
						<td class="tab_kp_off">
							&nbsp;
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr bgcolor="#f1f7fb">
			<td valign="top" align="center">
				<DIV CLASS=ItemBlock_Title1>
					<img border="0" src="<%=baseURL%>/common/images/title_arrow.gif" />
					系统常用设置
				</DIV>
				<DIV CLASS=ItemBlockBorder style="min-height:170px;">
					<DIV CLASS=ItemBlock style="min-height:170px;">
						<DIV STYLE="padding: 15px;">

							<DIV CLASS=DetailBlock>
								<img border="0" src="<%=baseURL%>/common/images/item_point.gif" />
								<a onclick="openConfig('/SysCompanyAction.do?action=showSysCompany',650,400);return false;"
									href="javascript:(0);" >企业基本信息设置</a>
							</DIV>

							<DIV CLASS=DetailBlock>
								<img border="0" src="<%=baseURL%>/common/images/item_point.gif" />
								<a  onclick="openConfig('/platform/system/shortcut/show_sys_shortcut.jsp',550,450);return false;"
									href="javascript:(0);">快捷菜单设置</a>
							</DIV>

							<DIV CLASS=DetailBlock>
								<img border="0" src="<%=baseURL%>/common/images/item_point.gif" />
<%--								<a onclick="openConfig('/SysMessagesAction.do?action=showSysMessagesList',700,550);return false;"--%>
<%--									href="javascript:(0);">桌面顶部滚动消息设置</a>--%>
									<a href="<%=baseURL %>/SysMessagesAction.do?action=showSysMessagesList">桌面顶部滚动消息设置</a>
							</DIV>

							<DIV CLASS=DetailBlock>
								<img border="0" src="<%=baseURL%>/common/images/item_point.gif" />
								<a href="<%=baseURL %>/SysNavigationAction.do?action=showSysNavigationList">桌面底部导航信息设置</a>
							</DIV>

							<DIV CLASS=DetailBlock>
								<img border="0" src="<%=baseURL%>/common/images/item_point.gif" />
								<a href="<%=baseURL %>/SysFiletypeAction.do?action=showSysFiletypeList">文件类型维护</a>
							</DIV>

<%--							<DIV CLASS=DetailBlock>--%>
<%--								<img border="0" src="<%=baseURL%>/common/images/item_point.gif" />--%>
<%--								<a href="#">登录设置</a>--%>
<%--							</DIV>--%>

						</DIV>
					</DIV>
				</DIV>
			</td>
		<tr>
<%--		<tr bgcolor="#f1f7fb">--%>
<%--			<td></td>--%>
<%--		<tr>--%>
<%--		<tr bgcolor="#f1f7fb">--%>
<%--			<td></td>--%>
<%--		<tr>--%>
	</table>

	<wbase:showMessage />
</body>
</html:html>
