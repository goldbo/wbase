<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base />
	<title>用户详细信息</title>

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

<body>
	<DIV ID=MainArea>
		<CENTER>
			<DIV CLASS=ItemBlock_Title1>
				<img border="0" src="<%=baseURL%>/common/images/title_arrow.gif" />
				用户信息
			</DIV>
			<DIV CLASS=ItemBlockBorder>
				<DIV CLASS=ItemBlock>
					<TABLE BORDER=0 CELLSPACING=5 CELLPADDING=0 WIDTH=100%>
						<TR>
							<TD WIDTH=50></TD>
							<TD WIDTH=80>
								用户账号
							</TD>
							<TD WIDTH=300>
								<bean:write property="account" name="wbaseUserForm"></bean:write>
							</TD>
							<TD ALIGN=right ROWSPAN=4>
								<img border="0" width="100" height="100" alt="我的头像"
									src="<%=baseURL%>${wbaseUserForm.picture }" onload="javascript:DrawImage(this,100,100);"/>
							</TD>
						</TR>
						<TR>
							<TD></TD>
							<TD>
								姓名
							</TD>
							<TD>
								<bean:write property="userName" name="wbaseUserForm"></bean:write>
							</TD>
						</TR>
						<TR>
							<TD></TD>
							<TD>
								部门
							</TD>
							<TD>
								<wbase:selectOrgTree edit="true" isSingle="true"
									propertyId="orgNodeNo" propertyName="orgName"
									propertyValue="${wbaseUserForm.orgNodeNo }" readOnly="true" />
							</TD>
						</TR>
						<tr>
							<TD></TD>
							<td>
								岗位：
							</td>
							<td>
								<wbase:postSelect edit="false" value="${wbaseUserForm.postNo }" />
							</td>
						</tr>
						<tr>
							<TD></TD>
							<td>
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

					</TABLE>
				</DIV>
			</DIV>
			<DIV CLASS=ItemBlock_Title1>
				<img border="0" src="<%=baseURL%>/common/images/title_arrow.gif" />
				联络方式
			</DIV>
			<DIV CLASS=ItemBlockBorder>
				<DIV CLASS=ItemBlock>
					<TABLE BORDER=0 CELLSPACING=5 CELLPADDING=0>
						<TR>
							<TD WIDTH=50></TD>
							<TD WIDTH=80>
								办公电话
							</TD>
							<TD WIDTH=200>
								<bean:write property="officeTel" name="wbaseUserForm"></bean:write>
							</TD>
							<TD WIDTH=150></TD>
						</TR>
						<TR>
							<TD></TD>
							<TD>
								传真
							</TD>
							<TD>
								<bean:write property="fax" name="wbaseUserForm"></bean:write>
							</TD>
							<TD></TD>
						</TR>
						<TR>
							<TD></TD>
							<TD>
								手机
							</TD>
							<TD>
								<bean:write property="mobile" name="wbaseUserForm"></bean:write>
							</TD>
							<TD></TD>
						</TR>
						<TR>
							<TD></TD>
							<TD>
								移动电话：
							</TD>
							<TD>
								<bean:write property="phone" name="wbaseUserForm"></bean:write>
							</TD>
							<TD></TD>
						</TR>
						<TR>
							<TD></TD>
							<TD>
								E-mail
							</TD>
							<TD>
								<bean:write property="email" name="wbaseUserForm"></bean:write>
							</TD>
							<TD></TD>
						</TR>
						<TR>
							<TD></TD>
							<TD>
								邮政编码
							</TD>
							<TD>
								<bean:write property="zipcode" name="wbaseUserForm"></bean:write>
							</TD>
							<TD></TD>
						</TR>
						<TR>
							<TD></TD>
							<TD>
								通信地址
							</TD>
							<TD COLSPAN=2>
								<bean:write property="address" name="wbaseUserForm"></bean:write>
							</TD>
						</TR>

						<TR>
							<TD></TD>
							<TD>
								备注
							</TD>
							<TD COLSPAN=2>
								<bean:write property="remark" name="wbaseUserForm"></bean:write>
							</TD>
						</TR>
					</TABLE>
				</DIV>
			</DIV>
			<DIV>
				<input type="button" value="返回" class="button1"
					onclick="window.close();">
			</DIV>
		</CENTER>
	</DIV>



	<wbase:showMessage />
</body>
</html:html>
