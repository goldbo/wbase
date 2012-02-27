<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base target="_self" />

	<title>更新用户信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="description" content="cate edit">
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

function setChkFlag(cs){
	if(cs){
		document.getElementById("isFlag").value=1;
	}else{
		document.getElementById("isFlag").value=0;
	}
}

function resetPwd(pwd){
	if(confirm("确定要重置该用户密码为："+pwd)){
		wbaseUserForm.action="<%=baseURL%>"+"/UserAction.do?action=updateUser&userPwd="+pwd;
		wbaseUserForm.submit();
		return true;
	}else{
		return false;
	}
}

function checkForm(){
	if(!isNumberOrLetter(document.getElementById("account").value)){
		alert("用户账号需要由数字或字母组成！");
		return false;
	}else if(!isChinaOrNumbOrLett(document.getElementById("userName").value)){
		alert("用户姓名需要由汉字或字母或数字组成！");
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

	<div align="left">
		<html:form action="/UserAction.do?action=updateUser"
			styleId="wbaseUserForm" method="post">
			<table border="0" width="90%" id="table2">
				<tr>
					<td width="25%" height="25" align="right">
						用户账号：
					</td>
					<td width="75%">
						<html:text property="account" name="wbaseUserForm" readonly="true"
							style="background-color: pink" maxlength="16"></html:text>
					</td>
				</tr>
				<tr>
					<td width="42%" height="25" align="right">
						用户密码：
					</td>
					<td width="75%">
						<input type="button" value="重置密码" class="button1" onclick="resetPwd('123456');" >
						<span style="color: red;font-size: x-small">重置后的密码为：123456！</span>
					</td>
				</tr>
				<tr>
					<td height="25" align="right">
						用户姓名：
					</td>
					<td>
						<html:text property="userName" name="wbaseUserForm"
							style="background-color: pink" maxlength="16"></html:text>
					</td>
				</tr>

				<tr>
					<td height="25" align="right">
						性别：
					</td>
					<td>
						<html:select property="sex" name="wbaseUserForm">
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
							propertyValue="${wbaseUserForm.orgNodeNo }" />
					</td>
				</tr>
				<tr>
					<td height="25" align="right">
						岗位：
					</td>
					<td>
						<wbase:postSelect edit="true" value="${wbaseUserForm.postNo }" />
					</td>
				</tr>
				<tr>
					<td height="25" align="right">
						真实姓名：
					</td>
					<td>
						<html:text property="realName" name="wbaseUserForm" maxlength="16"></html:text>
					</td>
				</tr>
				<tr>
					<td height="25" align="right">
						E-mail：
					</td>
					<td>
						<html:text property="email" name="wbaseUserForm" maxlength="32"></html:text>
					</td>
				</tr>
				<tr>
					<td height="25" align="right">
						移动电话：
					</td>
					<td>
						<html:text property="mobile" name="wbaseUserForm" maxlength="32"></html:text>
					</td>
				</tr>
				<tr>
					<td height="25" align="right">
						办公电话：
					</td>
					<td>
						<html:text property="phone" name="wbaseUserForm" maxlength="32"></html:text>
					</td>
				</tr>
				<tr>
					<td width="42%" height="25" align="right">
						备注：
					</td>
					<td width="75%">
						<html:textarea property="remark" name="wbaseUserForm" cols="30"
							rows="5"></html:textarea>
					</td>
				</tr>
				<tr>
					<td height="25" align="right">
						是否有效：
					</td>
					<td>
						<logic:equal name="wbaseUserForm" property="isFlag" value="1">
							<input type="checkbox" onchange="setChkFlag(this.checked);"
								checked="checked" />
						</logic:equal>
						<logic:notEqual name="wbaseUserForm" property="isFlag" value="1">
							<input type="checkbox" onchange="setChkFlag(this.checked);" />
						</logic:notEqual>
						<html:hidden property="isFlag" name="wbaseUserForm" />
					</td>
				</tr>

				<tr>
					<td align="center" colspan="2" height="25">
						<hr>
						<html:hidden property="id" name="wbaseUserForm" />
						<html:hidden property="todo" name="wbaseUserForm" />
						<input type="button" value="保存" class="button1"
							onclick="saveUser('');">
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
