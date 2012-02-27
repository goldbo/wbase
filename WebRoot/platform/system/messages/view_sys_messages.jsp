<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base target="_self" />

	<title>系统消息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="description" content="cate edit">

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<div align="center">
		<table border="0" width="90%" id="table2">
			<tr>
				<td>
					<table width="100%">
						<tr>
							<td align="center">
								<b style="font-size: medium"><bean:write property="msgTitle" name="wbaseSysMessagesForm" /></b>
							</td>
						</tr>
						<tr>
							<td align="center">
								发布日期：<bean:write property="msgStarttime" name="wbaseSysMessagesForm"
									format="yyyyMMdd HH:mm:ss" />
							</td>
						</tr>
						<tr>
							<td >
								<hr>
							</td>
						</tr>
					</table>
				</td>
			</tr>

			<tr>
				<td>
					${wbaseSysMessagesForm.msgContents }
				</td>
			</tr>

			<tr>
				<td>
					<bean:write property="msgAttachment" name="wbaseSysMessagesForm" />
				</td>
			</tr>

			<tr>
				<td align="center" height="25">
					<hr>
					<html:hidden property="id" name="wbaseSysMessagesForm" />
					<input type="button" value="返回" class="button1"
						onclick="window.close();">
				</td>
			</tr>
		</table>
	</div>
</body>
</html:html>
