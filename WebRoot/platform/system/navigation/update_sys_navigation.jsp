<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base target="_self" />

	<title>更新系统底部导航</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="description" content="cate edit">

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
function saveSysNavigation(todo){
	if(checkForm()){
		document.getElementById("todo").value=todo;
		wbaseSysNavigationForm.submit();
		return true;
	}else{
		return false;
	}
}


function setChkFlag(cs,name){
	if(cs){
		document.getElementById(name).value=1;
	}else{
		document.getElementById(name).value=0;
	}
}

function checkForm(){
	if(isNull(document.getElementById("navName").value)){
		alert("导航名称需要由数字或字母组成!");
		return false;
	}else{
		return true;
	}
}
</script>
</head>

<body >
	<div align="center">
		<html:form action="/SysNavigationAction.do?action=updateSysNavigation"
			styleId="wbaseSysNavigationForm" method="post">
			<table border="0" width="85%" id="table2">
				<tr>
					<td height="25" align="right">
						导航名称:
					</td>
					<td>
						<html:text property="navName" name="wbaseSysNavigationForm"
							style="background-color: pink;width: 300px" maxlength="16"></html:text>
					</td>
				</tr>

				<tr>
					<td height="25" align="right">
						导航链接:
					</td>
					<td>
					<html:text property="navLink" name="wbaseSysNavigationForm"
							style="background-color: pink;width: 300px" maxlength="256"></html:text>
					</td>
				</tr>
				
				<tr>
					<td height="30" align="right">
						是否弹出窗口：
					</td>
					<td>
						<logic:equal name="wbaseSysNavigationForm" property="navOpen" value="1">
							<input type="checkbox" onchange="setChkFlag(this.checked,'navOpen');"
								checked="checked" />
						</logic:equal>
						<logic:notEqual name="wbaseSysNavigationForm" property="navOpen"
							value="1">
							<input type="checkbox" onchange="setChkFlag(this.checked,'navOpen');" />
						</logic:notEqual>
						<html:hidden property="navOpen" name="wbaseSysNavigationForm" />
					</td>
				</tr>
				<tr>
					<td height="30" align="right">
						是否显示：
					</td>
					<td>
						<logic:equal name="wbaseSysNavigationForm" property="navFlag" value="1">
							<input type="checkbox" onchange="setChkFlag(this.checked,'navFlag');"
								checked="checked" />
						</logic:equal>
						<logic:notEqual name="wbaseSysNavigationForm" property="navFlag"
							value="1">
							<input type="checkbox" onchange="setChkFlag(this.checked,'navFlag');" />
						</logic:notEqual>
						<html:hidden property="navFlag" name="wbaseSysNavigationForm" />
					</td>
				</tr>

				<tr>
					<td align="center" colspan="2" height="25">
						<hr>
						<html:hidden property="id" name="wbaseSysNavigationForm"/>
						<html:hidden property="todo" name="wbaseSysNavigationForm" />
						<input type="button" value="保存" class="button1"
							onclick="saveSysNavigation('');">
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
