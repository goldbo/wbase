<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<%@ page import="com.wingo.wbase.model.ViewUserInfo"%>
<%@ page import="com.wingo.wbase.common.Constants"%>
<%
			ViewUserInfo user = (ViewUserInfo) session
			.getAttribute(Constants.LOGIN_USER);
%>
<html:html lang="true">
<head>
	<html:base target="_self" />
	<title>个人设置</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
function saveUser(todo){
	if(checkForm()){
		document.getElementById("todo").value=todo;
		wbaseUserForm.submit();
		return true;
	}else{
		return false;
	}
}

function openConfig(url,width,height){
	window.showModalDialog("<%=baseURL%>"+url, "", "dialogWidth="+width+"px;dialogHeight="+height+"px;status:no;");
}

function checkForm(){
	if(document.getElementById("address").value.length>256){
		alert("通信地址输入的字符过多！");
		return false;
	}else if(document.getElementById("remark").value.length>512){
		alert("备注输入的字符过多！");
		return false;
	}else{
		return true;
	}
	
}

</script>
</head>

<body>
	<DIV ID=MainArea>
		<html:form action="/UserAction.do?action=updateUserInfo"
			styleId="wbaseUserForm" method="post">
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
									用户ID
								</TD>
								<TD WIDTH=300>
									<%=user.getAccount()%>
								</TD>
								<TD ALIGN=right ROWSPAN=4>
									<img border="0" width="100" height="100" id="viewHeaderImage" alt="我的头像"
										src="<%=baseURL + user.getPicture()%>" onload="javascript:DrawImage(this,100,100);"/>
								</TD>
							</TR>
							<TR>
								<TD></TD>
								<TD>
									姓名
								</TD>
								<TD>
									<%=user.getUserName()%>
								</TD>
							</TR>
							<TR>
								<TD></TD>
								<TD>
									部门
								</TD>
								<TD>
									<%=user.getOrgName()%>
								</TD>
							</TR>

							<TR>
								<TD></TD>
								<TD>
									头像
								</TD>
								<TD>
									<table>
										<tr>
											<td>
												<wbase:uploadImage propertyId="picture"
													propertyName="picture"
													propertyValue="<%=user.getPicture()%>"
													savePath="/uploadfile/head/" />
											</td>
											<td valign="bottom">
												<input type="button" value="保存" class="button1"
													onclick="saveUser('');">
											</td>
										</tr>
									</table>
								</TD>
							</TR>
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
							<tr>
							<TR>
								<TD WIDTH=50></TD>
								<TD WIDTH=80>
									办公电话
								</TD>
								<TD WIDTH=200>
									<html:text property="officeTel" name="wbaseUserForm"
										value="<%=user.getOfficeTel()%>" maxlength="32"></html:text>
								</TD>
								<TD WIDTH=150></TD>
							</TR>
							<TR>
								<TD></TD>
								<TD>
									传真
								</TD>
								<TD>
									<html:text property="fax" name="wbaseUserForm"
										value="<%=user.getFax()%>" maxlength="32"></html:text>
								</TD>
								<TD></TD>
							</TR>
							<TR>
								<TD></TD>
								<TD>
									移动电话
								</TD>
								<TD>
									<html:text property="mobile" name="wbaseUserForm"
										value="<%=user.getMobile()%>" maxlength="32"></html:text>
								</TD>
								<TD></TD>
							</TR>
							<TR>
								<TD></TD>
								<TD>
									固定电话
								</TD>
								<TD>
									<html:text property="phone" name="wbaseUserForm"
										value="<%=user.getPhone()%>" maxlength="32"></html:text>
								</TD>
								<TD></TD>
							</TR>
							<TR>
								<TD></TD>
								<TD>
									E-mail
								</TD>
								<TD>
									<html:text property="email" name="wbaseUserForm"
										value="<%=user.getEmail()%>" maxlength="32"></html:text>
								</TD>
								<TD></TD>
							</TR>
							<TR>
								<TD></TD>
								<TD>
									邮政编码
								</TD>
								<TD>
									<html:text property="zipcode" name="wbaseUserForm"
										value="<%=user.getZipcode()%>" maxlength="16"></html:text>
								</TD>
								<TD></TD>
							</TR>
							<TR>
								<TD></TD>
								<TD>
									通信地址
								</TD>
								<TD COLSPAN=2>
									<html:textarea property="address" name="wbaseUserForm"
										cols="30" rows="5" value="<%=user.getAddress()%>"></html:textarea>
								</TD>
							</TR>
							<TR>
								<TD></TD>
								<TD>
									备注
								</TD>
								<TD COLSPAN=2>
									<html:textarea property="remark" name="wbaseUserForm" cols="30"
										rows="5" value="<%=user.getRemark()%>"></html:textarea>
								</TD>
							</TR>
							<TR>
								<TD COLSPAN=4>
								</TD>
							</TR>
							<tr>
								<td align="center" colspan="4" height="25">
									<html:hidden property="id" name="wbaseUserForm"
										value="<%=user.getId().getUid()%>" />
									<html:hidden property="todo" name="wbaseUserForm" />
									<input type="button" value="保存" class="button1"
										onclick="saveUser('');">
									<input type="button" value="返回" class="button1"
										onclick="window.close();">
								</td>
							</tr>
						</TABLE>
					</DIV>
				</DIV>

				<DIV CLASS=ItemBlock_Title1>
					<img border="0" src="<%=baseURL%>/common/images/title_arrow.gif" />
					其他设置
				</DIV>
				<DIV CLASS=ItemBlockBorder>
					<DIV CLASS=ItemBlock>
						<DIV STYLE="padding: 15px;">

							<DIV CLASS=DetailBlock>
								<img border="0" src="<%=baseURL%>/common/images/item_point.gif" />
								<a
									onclick="openConfig('/platform/user/update_userpwd.jsp',550,250);return false;"
									href="javascript:(0);" class="title">密码修改 </a>
							</DIV>
							
							<DIV CLASS=DetailBlock>
								<img border="0" src="<%=baseURL%>/common/images/item_point.gif" />
								<a
									onclick="openConfig('/platform/system/shortcut/show_sys_shortcut.jsp',550,450);return false;"
									href="javascript:(0);" class="title">我的快捷菜单 </a>
							</DIV>

						</DIV>
					</DIV>
				</DIV>
				<br>
				<br>
			</CENTER>
		</html:form>
	</DIV>

	<wbase:showMessage />
</body>
</html:html>
