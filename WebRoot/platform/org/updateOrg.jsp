<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base target="_self" />

	<title>修改组织</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="description" content="cate edit">

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript"
		src="<%=baseURL%>/dwr/interface/wbaseOrgService.js"></script>
	<script type="text/javascript" src="<%=baseURL%>/dwr/util.js"></script>
	<script type="text/javascript" src="<%=baseURL%>/dwr/engine.js"></script>
	<script type="text/javascript">
function saveOrg(){
	if(checkForm()){
		wbaseOrgForm.submit();
		return true;
	}else{
		return false;
	}
}

function deleteOrg(orgNodeNos){
orgNodeNos += ",";
if (!confirm("确定要删除已选择组织？")){
	 	     return false;
	 	  }else{
	 	  wbaseOrgService.deleteOrg(orgNodeNos,function(bool){alert(bool);window.close();});
			return true;
	}
}

function cancel(){
	window.close();
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
		<html:form action="/OrgAction.do?action=updateOrg"
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
						<html:text property="orgLevel" name="wbaseOrgForm"  maxlength="10"></html:text>
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
						前台是否显示：
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
						<html:text property="viewOrder" name="wbaseOrgForm"  maxlength="10"></html:text>
					</td>
				</tr>
				<tr>
					<td width="42%" height="30" align="right">
						备注：
					</td>
					<td width="75%">
						<html:textarea property="remark" name="wbaseOrgForm" rows="4"></html:textarea>
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2" height="30">
						<hr>
						<html:hidden property="id" name="wbaseOrgForm" />
						<wbase:powerButton onclick="saveOrg();" resNo="orgManagement"
							type="3" value="保存" />
						<wbase:powerButton onclick="deleteOrg('${wbaseOrgForm.nodeNo }');"
							resNo="orgManagement" type="2" value="删除" />
						<wbase:powerButton onclick="cancel();" resNo="orgManagement"
							type="3" value="关闭" />
					</td>
				</tr>
			</table>
		</html:form>
	</div>
	<wbase:showMessage />
</body>
</html:html>
