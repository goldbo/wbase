<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base target="_self" />

	<title>查看用户信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="description" content="cate edit">

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>

	<div align="left">
		<html:form action="/UserAction.do?action=updateUser"
			styleId="wbaseUserForm" method="post">
			<table border="0" width="90%" id="table2">
				<tr>
					<td width="25%" height="25" align="right">
						用户账号：
					</td>
					<td width="75%">
						<bean:write property="account" name="wbaseUserForm"></bean:write>
					</td>
				</tr>
				<tr>
					<td height="25" align="right">
						用户姓名：
					</td>
					<td>
						<bean:write property="userName" name="wbaseUserForm"></bean:write>
					</td>
				</tr>

				<tr>
					<td height="25" align="right">
						性别：
					</td>
					<td>
						<html:select property="sex" name="wbaseUserForm" disabled="true">
							<html:option value="1">
							男
						</html:option>
							<html:option value="0">
							女
						</html:option>
						</html:select>
					</td>
				</tr>
				<tr>
					<td height="25" align="right">
						所属部门：
					</td>
					<td>
						<wbase:selectOrgTree edit="true" isSingle="true"
							propertyId="orgNodeNo" propertyName="orgName"
							propertyValue="${wbaseUserForm.orgNodeNo }" readOnly="true" />
					</td>
				</tr>
				<tr>
					<td height="25" align="right">
						岗位：
					</td>
					<td>
						<wbase:postSelect edit="false" value="${wbaseUserForm.postNo }" />
					</td>
				</tr>
				<tr>
					<td height="25" align="right">
						真实姓名：
					</td>
					<td>
						<bean:write property="realName" name="wbaseUserForm"></bean:write>
					</td>
				</tr>
				<tr>
					<td height="25" align="right">
						邮箱：
					</td>
					<td>
						<bean:write property="email" name="wbaseUserForm"></bean:write>
					</td>
				</tr>
				<tr>
					<td height="25" align="right">
						移动电话：
					</td>
					<td>
						<bean:write property="mobile" name="wbaseUserForm"></bean:write>
					</td>
				</tr>
				<tr>
					<td height="25" align="right">
						固定电话：
					</td>
					<td>
						<bean:write property="phone" name="wbaseUserForm"></bean:write>
					</td>
				</tr>
				<tr>
					<td width="42%" height="25" align="right">
						备注：
					</td>
					<td width="75%">
						<bean:write property="remark" name="wbaseUserForm"></bean:write>
					</td>
				</tr>
				<tr>
					<td height="25" align="right">
						是否有效：
					</td>
					<td>
						<logic:equal name="wbaseUserForm" property="isFlag" value="1">
							<input type="checkbox" onchange="setChkFlag(this.checked);"
								checked="checked" disabled="disabled" />
						</logic:equal>
						<logic:notEqual name="wbaseUserForm" property="isFlag" value="1">
							<input type="checkbox" onchange="setChkFlag(this.checked);"
								disabled="disabled" />
						</logic:notEqual>
					</td>
				</tr>

				<tr>
					<td align="center" colspan="2" height="25">
						<hr>
						<input type="button" value="返回" class="button1"
							onclick="window.close();">
					</td>
				</tr>
			</table>
		</html:form>
	</div>
	<wbase:showMessage />
</body>
</html:html>
