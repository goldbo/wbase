<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base target="_self" />

	<title>创建组织</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="description" content="cate edit">

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
function saveOrg(todo){
	if(checkForm()){
		document.getElementById("todo").value=todo;
		wbaseOrgForm.submit();
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

function checkForm(){
	if(!isNumberOrLetter(document.getElementById("orgNo").value)){
		alert("组织编号需要由数字或字母组成！");
		return false;
	}else if(!isChinaOrNumbOrLett(document.getElementById("orgName").value)){
		alert("组织名称需要由汉字或字母或数字组成！");
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

	<div align="center">
		<html:form action="/OrgAction.do?action=createOrg"
			styleId="wbaseOrgForm" method="post">
			<table border="0" width="85%" id="table2">
				<tr style="display: none">
					<td width="42%" height="30" align="right">
						节点编号：
					</td>
					<td width="75%">
						<html:text property="nodeNo" name="wbaseOrgForm" readonly="true"
							style="background-color: pink"></html:text>
					</td>
				</tr>
				<tr>
					<td width="42%" height="30" align="right">
						组织编号：
					</td>
					<td width="75%">
						<html:text property="orgNo" name="wbaseOrgForm"
							style="background-color: pink" maxlength="16"></html:text>
					</td>
				</tr>
				<tr>
					<td height="30" align="right">
						组织名称：
					</td>
					<td>
						<html:text property="orgName" name="wbaseOrgForm" maxlength="16"></html:text>
					</td>
				</tr>
				<tr>
					<td height="30" align="right">
						组织级别：
					</td>
					<td>
						<html:text property="orgLevel" name="wbaseOrgForm" maxlength="10"></html:text>
					</td>
				</tr>
				<tr>
					<td height="30" align="right">
						上级组织：
					</td>
					<td>
						<wbase:selectOrgTree edit="true" isSingle="true"
							propertyId="subNodeNo" propertyName="subOrgName"
							propertyValue="${wbaseOrgForm.subNodeNo }" />
					</td>
				</tr>
				<tr>
					<td height="30" align="right">
						是否有效：
					</td>
					<td>
						<logic:equal name="wbaseOrgForm" property="isFlag" value="1">
							<input type="checkbox" onchange="setChkFlag(this.checked);"
								checked="checked" />
						</logic:equal>
						<logic:notEqual name="wbaseOrgForm" property="isFlag" value="1">
							<input type="checkbox" onchange="setChkFlag(this.checked);" />
						</logic:notEqual>
						<html:hidden property="isFlag" name="wbaseOrgForm" />
					</td>
				</tr>
				<tr>
					<td height="30" align="right">
						显示顺序：
					</td>
					<td>
						<html:text property="viewOrder" name="wbaseOrgForm" maxlength="10"></html:text>
					</td>
				</tr>
				<tr>
					<td width="42%" height="30" align="right">
						备注：
					</td>
					<td width="75%">
						<html:textarea property="remark" name="wbaseOrgForm" rows="4" ></html:textarea>
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2" height="30">
						<hr>
						<html:hidden property="todo" name="wbaseOrgForm" />
						<wbase:powerButton onclick="saveOrg('create');"
							resNo="orgManagement" type="1" value="继续添加" />
						<wbase:powerButton onclick="saveOrg('');" resNo="orgManagement"
							type="1" value="保存" />
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
