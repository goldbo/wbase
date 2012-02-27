<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base target="_self" />

	<title>创建资源</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="description" content="cate edit">

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
function saveResource(){
	if(checkForm()){
		wbaseResourceForm.submit();
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
	if(!isNumberOrLetter(document.getElementById("resNo").value)){
		alert("资源编号需要由数字或字母组成！");
		return false;
	}else if(!isChinaOrNumbOrLett(document.getElementById("resName").value)){
		alert("资源名称需要由汉字或字母或数字组成！");
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
		<html:form action="/ResourceAction.do?action=createResource"
			styleId="wbaseResourceForm" method="post">
			<table border="0" width="85%" id="table2">
				<tr style="display: none">
					<td width="42%" height="30" align="right">
						节点编号：
					</td>
					<td width="75%">
						<html:text property="nodeNo" name="wbaseResourceForm"
							readonly="true" style="background-color: pink"></html:text>
					</td>
				</tr>
				<tr>
					<td width="42%" height="30" align="right">
						资源编号：
					</td>
					<td width="75%">
						<html:text property="resNo" name="wbaseResourceForm"
							style="background-color: pink" maxlength="16"></html:text>
					</td>
				</tr>
				<tr>
					<td height="30" align="right">
						资源名称：
					</td>
					<td>
						<html:text property="resName" name="wbaseResourceForm"
							style="background-color: pink" maxlength="16"></html:text>
					</td>
				</tr>
				<tr>
					<td height="30" align="right">
						资源级别：
					</td>
					<td>
						<html:text property="resLevel" name="wbaseResourceForm" maxlength="10"></html:text>
					</td>
				</tr>
				<tr>
					<td height="30" align="right">
						上级资源：
					</td>
					<td>
						<wbase:selectResTree edit="true" isSingle="true" propertyId="subNodeNo" propertyName="subResName" propertyValue="${wbaseResourceForm.subNodeNo }" />
					</td>
				</tr>
				<tr>
					<td height="30" align="right">
						资源路径：
					</td>
					<td>
						<html:text property="resPath" name="wbaseResourceForm" maxlength="512"></html:text>
					</td>
				</tr>
				<tr>
					<td height="30" align="right">
						资源图片：
					</td>
					<td>
						<wbase:uploadImage propertyId="resPic" propertyName="resPic" propertyValue="${wbaseResourceForm.resPic }"/>
					</td>
				</tr>
				<tr>
					<td height="30" align="right">
						是否为弹出窗口：
					</td>
					<td>
						<logic:equal name="wbaseResourceForm" property="isTarget" value="1">
							<input type="checkbox" onchange="setChkFlag(this.checked,'isTarget');"
								checked="checked" />
						</logic:equal>
						<logic:notEqual name="wbaseResourceForm" property="isTarget"
							value="1">
							<input type="checkbox" onchange="setChkFlag(this.checked,'isTarget');" />
						</logic:notEqual>
						<html:hidden property="isTarget" name="wbaseResourceForm" />
					</td>
				</tr>
				<tr>
					<td height="30" align="right">
						前台是否显示：
					</td>
					<td>
						<logic:equal name="wbaseResourceForm" property="isFlag" value="1">
							<input type="checkbox" onchange="setChkFlag(this.checked,'isFlag');"
								checked="checked" />
						</logic:equal>
						<logic:notEqual name="wbaseResourceForm" property="isFlag"
							value="1">
							<input type="checkbox" onchange="setChkFlag(this.checked,'isFlag');" />
						</logic:notEqual>
						<html:hidden property="isFlag" name="wbaseResourceForm" />
					</td>
				</tr>
				<tr>
					<td height="30" align="right">
						显示顺序：
					</td>
					<td>
						<html:text property="viewOrder" name="wbaseResourceForm"></html:text>
					</td>
				</tr>
				<tr>
					<td width="42%" height="30" align="right">
						备注：
					</td>
					<td width="75%">
						<html:textarea property="remark" name="wbaseResourceForm" rows="4"></html:textarea>
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2" height="30">
						<hr>
						<%--						<input type="hidden" id="id" name="id" value="${wbaseResourceForm.id }" />--%>
						<input type="button" value="保存" class="button1"
							onclick="saveResource();">
						<%--							<html:submit value="保存"></html:submit>--%>
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
