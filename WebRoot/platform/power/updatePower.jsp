<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base target="_self" />

	<title>修改权限</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="description" content="cate edit">

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
function savePower(){
	wbasePowerForm.submit();
}

function cancel(){
	parent.window.close();
}

function setChk(cs,chk,num){
	if(cs){
		document.getElementById(chk).value=num;
	}else{
		document.getElementById(chk).value=0;
	}
}

</script>
</head>

<body>

	<div align="center">
		<html:form action="/PowerAction.do?action=updatePower" styleId="wbasePowerForm"
			method="post">
			<table border="0" width="85%" id="table2">
				<tr>
					<td height="30" align="right">
						默认(菜单是否可见)
					</td>
					<td>
						<logic:equal name="wbasePowerForm" property="auto" value="5">
							<input type="checkbox" onchange="setChk(this.checked,'auto',5);"
								checked="checked" />
						</logic:equal>
						<logic:notEqual name="wbasePowerForm" property="auto" value="5">
							<input type="checkbox" onchange="setChk(this.checked,'auto',5);" />
						</logic:notEqual>
						<html:hidden property="auto" name="wbasePowerForm" />
					</td>
				</tr>
				<tr>
					<td height="30" align="right">
						新增
					</td>
					<td>
						<logic:equal name="wbasePowerForm" property="create" value="1">
							<input type="checkbox" onchange="setChk(this.checked,'create',1);"
								checked="checked" />
						</logic:equal>
						<logic:notEqual name="wbasePowerForm" property="create" value="1">
							<input type="checkbox" onchange="setChk(this.checked,'create',1);" />
						</logic:notEqual>
						<html:hidden property="create" name="wbasePowerForm" />
					</td>
				</tr>
				<tr>
					<td height="30" align="right">
						删除
					</td>
					<td>
						<logic:equal name="wbasePowerForm" property="delete" value="2">
							<input type="checkbox" onchange="setChk(this.checked,'delete',2);"
								checked="checked" />
						</logic:equal>
						<logic:notEqual name="wbasePowerForm" property="delete" value="2">
							<input type="checkbox" onchange="setChk(this.checked,'delete',2);" />
						</logic:notEqual>
						<html:hidden property="delete" name="wbasePowerForm" />
					</td>
				</tr>
				<tr>
					<td height="30" align="right">
						修改
					</td>
					<td>
						<logic:equal name="wbasePowerForm" property="update" value="3">
							<input type="checkbox" onchange="setChk(this.checked,'update',3);"
								checked="checked" />
						</logic:equal>
						<logic:notEqual name="wbasePowerForm" property="update" value="3">
							<input type="checkbox" onchange="setChk(this.checked,'update',3);" />
						</logic:notEqual>
						<html:hidden property="update" name="wbasePowerForm" />
					</td>
				</tr>
				<tr>
					<td height="30" align="right">
						查看
					</td>
					<td>
						<logic:equal name="wbasePowerForm" property="read" value="4">
							<input type="checkbox" onchange="setChk(this.checked,'read',4);"
								checked="checked" />
						</logic:equal>
						<logic:notEqual name="wbasePowerForm" property="read" value="4">
							<input type="checkbox" onchange="setChk(this.checked,'read',4);" />
						</logic:notEqual>
						<html:hidden property="read" name="wbasePowerForm" />
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2" height="30">
						<hr>
						<html:hidden property="id" name="wbasePowerForm" />
						<html:hidden property="roleNo" name="wbasePowerForm" />
						<html:hidden property="resNodeNo" name="wbasePowerForm" />
						<input type="button" value="保  存" class="button1"
							onclick="savePower();">
						<input type="button" value="关  闭" class="button1"
							onclick="cancel();">
					</td>
				</tr>
			</table>
		</html:form>
	</div>
	<wbase:showMessage />
</body>
</html:html>
