<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="Cache-Control" content="no-cache, must-revalidate" />
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<title>首页</title>
	<!--可以在收藏夹中显示出图标-->
	<link rel="Bookmark" type="image/x-icon"
		href="<%=baseURL%>/common/images/favicon.ico" />
	<!--可以在地址栏中显示出图标-->
	<link rel="icon" type="image/x-icon"
		href="<%=baseURL%>/common/images/favicon.ico" />
	<link rel="shortcut icon" type="image/x-icon"
		href="<%=baseURL%>/common/images/favicon.ico" />
	<link rel="stylesheet" type="text/css"
		href="<%=baseURL%>/common/css/style_login.css">
	<style type="text/css">
body {
	margin: 0;
	padding: 0;
	background: #898989;
}
</style>
	<SCRIPT type="text/javascript" language="javascript"> 
		function submitForm()
		{
		   if(document.wbaseUserForm.account.value == ''){
		        document.getElementById("login_tip").innerHTML="系统提示：请输入用户账号.";
		        document.wbaseUserForm.account.focus();
		        return false;
		   }else if(document.wbaseUserForm.userPwd.value == ''){
		        document.getElementById("login_tip").innerHTML="系统提示：请输入用户密码."
		        document.wbaseUserForm.userPwd.focus();
		        return false;
		   }else{		   
			    document.wbaseUserForm.action="<%=baseURL%>"+"/SystemLogin.do?action=showLogin&screenHeight="+screen.availHeight+"&screenWidth="+screen.availWidth;
				document.wbaseUserForm.submit();
				return true;
			}	 
		}
		
		//在输入回车//网页内按下回车触发
		function keypress(e){
			var currKey=0,e=e||event;
  			if(e.keyCode==13){
  				document.getElementById("submitBut").click();   
		        return false;
  			}
  		}
 		document.onkeypress=keypress;
		

		function resetForm(){
			document.wbaseUserForm.account.value = '';
			document.wbaseUserForm.userPwd.value = '';
			document.wbaseUserForm.account.focus();
		}
		
		function onload(){
		//获取系统屏幕高和宽
			document.wbaseUserForm.account.focus();
			document.getElementById("screenHeight").innerHTML=screen.availHeight;
			document.getElementById("screenWidth").innerHTML=screen.availWidth;
		}
	</SCRIPT>
</head>

<body style="overflow:auto"
	onload="onload();">
	<html:form action="/SystemLogin.do?action=showLogin"
		styleId="wbaseUserForm">
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="0"
			style="background:url(<%=baseURL%>/common/images/login/login_bg.jpg)">
			<tr>
				<td>

					<table align="center" width="471" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td height="50" align="right"></td>
						</tr>
						<tr>
							<td height="235" valign="top"
								background="<%=baseURL%>/common/images/login/loginKgb.jpg">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="100" height="90">
											&nbsp;
										</td>
										<td>
											&nbsp;
										</td>
									</tr>
									<tr>
										<td height="30" align="right">
											用户账号：
										</td>
										<td>
											<input type="text" name="account" id="account" size="20"
												style="width:150px; height:20px; border:1px solid #a8a9a9; background-color:#f6f9fb">
										</td>
									</tr>
									<tr>
										<td height="30" align="right">
											用户密码：
										</td>
										<td>
											<input type="password" name="userPwd" id="userPwd" size="20"
												style="width:150px; height:20px; border:1px solid #a8a9a9; background-color:#f6f9fb">
										</td>
									</tr>
									<%--          <tr>--%>
									<%--            <td height="30" align="right">验证码：</td>--%>
									<%--            <td><input type="text" name="key_m" size="10" style="width:80px; height:20px; border:1px solid #a8a9a9; background-color:#f6f9fb" onKeyUp="if(event.keyCode == 13)login()"></td>--%>
									<%--          </tr>--%>
									<tr>
										<td height="60">
											&nbsp;
										</td>
										<td>
											<input type="button" id="submitBut" onclick="submitForm()"
												style="background:url(<%=baseURL%>/common/images/login/btn_login.jpg); cursor:pointer; border:0px; width:63px; height:26px;"
												value="&nbsp;">
											&nbsp;&nbsp;&nbsp;
											<input type="reset" onclick="resetForm()"
												style="background:url(<%=baseURL%>/common/images/login/btn_loginrs.jpg); cursor:pointer; border:0px; width:63px; height:26px;"
												value="&nbsp;">
										</td>
									</tr>
									<tr>
										<td>
										</td>
										<td height="25">
											<font id="login_tip" color="red"></font>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td height="80" align="center">
								技术支持： 珠海市网佳科技有限公司
								<br>
								Screen Resolution: <span id="screenWidth"></span>&nbsp;x&nbsp;<span id="screenHeight"></span>&nbsp;Pixels 
								<br>
								© Copyright 2010 WINGOTECH All rights reserved.
							</td>
						</tr>
					</table>

				</td>
			</tr>
		</table>
	</html:form>
	<wbase:showMessage />
</body>

</html:html>
