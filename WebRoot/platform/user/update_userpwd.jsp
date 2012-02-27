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
	<title>修改密码</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript"
		src="<%=baseURL%>/common/js/validator_pwd.js"></script>
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

function checkForm(){
	var newPwd = document.getElementById("newPwd").value;
	var reNewPwd = document.getElementById("reNewPwd").value;
	if(isNull(newPwd)){
		alert("请输入用户密码！");
		return false;
	}else if(isNull(reNewPwd)){
		alert("请输入确认密码！");
		return false;
	
	}else if(newPwd!=reNewPwd){
		alert("确认密码不一致.");
		return false;
	}else{
		return true;
	}

}

</script>
</head>

<body>
	<DIV ID=MainArea>
		<html:form action="/UserAction.do?action=updateUserPwd"
			styleId="wbaseUserForm" method="post">
			<CENTER>
				<DIV CLASS=ItemBlock_Title1>
					<img border="0" src="<%=baseURL%>/common/images/title_arrow.gif" />
					修改密码
				</DIV>
				<DIV CLASS=ItemBlockBorder>
					<DIV CLASS=ItemBlock>
						<BR>
						<TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0>
							<TR HEIGHT=27>
								<TD WIDTH=20 ALIGN=RIGHT>
									<img border="0" src="<%=baseURL%>/common/images/item_point.gif" />
								</TD>
								<TD WIDTH=130 VALIGN=MIDDLE>
									&nbsp;请输入原密码
								</TD>
								<TD WIDTH=150>
									<html:password property="userPwd" name="wbaseUserForm"
										maxlength="16" value=""></html:password>
								</TD>
								<TD COLSPAN=2></TD>
							</TR>
							<TR HEIGHT=27>
								<TD ALIGN=RIGHT>
									<img border="0" src="<%=baseURL%>/common/images/item_point.gif" />
								</TD>
								<TD VALIGN=MIDDLE>
									&nbsp;请填写新密码
								</TD>
								<TD>
									<%--									<input onkeyup="pwStrength(this.value);"--%>
									<%--										onblur="pwStrength(this.value);" class="InputStyle"--%>
									<%--										id="newPwd" type="password" name="newPwd" />--%>
									<html:password property="newPwd" name="wbaseUserForm"
										maxlength="16" onkeyup="pwStrength(this.value);"
										onblur="pwStrength(this.value);"></html:password>
								</TD>
								<TD WIDTH=10></TD>
								<TD STYLE="DISPLAY: block" ID=passwdBarDiv VALIGN=MIDDLE NOWRAP
									WIDTH=180>
									<TABLE border=0 cellSpacing=0 cellPadding=0>
										<TR>
											<TD vAlign=top width=0 noWrap>
												<FONT size=-1 face="Arial, sans-serif">密码强度</FONT>
											</TD>
											<TD vAlign=top noWrap>
												<FONT color=#808080 size=-1 face="Arial, sans-serif"><B>
														<span id=passwdRating> &nbsp; </span> </B> </FONT>
											</TD>
										</TR>
										<TR>
											<TD colSpan=2>
												<TABLE id=passwdBar border=0 cellSpacing=0 cellPadding=0
													width=160 bgColor=#ffffff>
													<TR>
														<TD style="WIDTH: 0px; BACKGROUND: #ffcc33" id=posBar
															bgColor=#e0e0e0 height=4 width=0%></TD>
														<TD style="WIDTH: 180px" id=negBar bgColor=#e0e0e0
															height=4 width="100%"></TD>
													</TR>
												</TABLE>
											</TD>
										</TR>
									</TABLE>
								</TD>
							</TR>
							<TR HEIGHT=27>
								<TD ALIGN=RIGHT>
									<img border="0" src="<%=baseURL%>/common/images/item_point.gif" />
								</TD>
								<TD VALIGN=MIDDLE>
									&nbsp;再次输入新密码
								</TD>
								<TD>
									<input type="password" name="reNewPwd" maxlength="16" />
								</TD>
								<TD COLSPAN=2></TD>
							</TR>
							<TR HEIGHT=20>
								<TD></TD>
								<TD COLSPAN=4>
									(建议您把密码长度设为6位以上,混合使用大小写字母、数字和特殊符号)
								</TD>
							</TR>
							<TR HEIGHT=20>
								<TD COLSPAN=5>
								</TD>
							</TR>
							<TR HEIGHT=25>
								<TD COLSPAN=5 align="center">
									<html:hidden property="id" name="wbaseUserForm" value="<%=user.getId().getUid() %>" />
									<html:hidden property="todo" name="wbaseUserForm" />
									<input type="button" value="保存" class="button1"
										onclick="saveUser('');">
									<input type="button" value="返回" class="button1"
										onclick="window.close();">
								</TD>
							</TR>

						</TABLE>
						<BR>
					</DIV>
				</DIV>
			</CENTER>
		</html:form>
	</DIV>

	<wbase:showMessage />
</body>
</html:html>
