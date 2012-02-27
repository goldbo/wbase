<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base target="_self" />

	<title>修改资源</title>
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

function deleteResource(){
if (!confirm("确定要删除已选择资源？")){
	 	     return false;
	 	  }else{
	wbaseResourceForm.action = "<%=baseURL %>/ResourceAction.do?action=deleteResource";
	wbaseResourceForm.submit();
			return true;
	}
}

function cancel(){
	window.location.reload(true);
}

function setChkFlag(cs,name){
	if(cs){
		document.getElementById(name).value=1;
	}else{
		document.getElementById(name).value=0;
	}
}

function ResourceSelect(url,width, height){
	window.showModalDialog(url, "", "dialogWidth="+width+"px;dialogHeight="+height+"px;status:no;");
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
<logic:empty name="wbaseResourceForm" property="id">
	<div align="center">
		点击左侧 节点树 进行节点编辑！
	</div>
</logic:empty>
<logic:notEmpty name="wbaseResourceForm" property="id">
	<div align="center">
		<html:form action="/ResourceAction.do?action=updateResource"
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
							<span style="color: red;font-size: x-small">非特殊情况,资源编号请勿修改！</span>
					</td>
				</tr>
				<tr>
					<td height="30" align="right">
						资源名称：
					</td>
					<td>
						<html:text property="resName" name="wbaseResourceForm" maxlength="16"></html:text>
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
						<wbase:uploadImage propertyId="resPic" propertyName="resPic" propertyValue="${wbaseResourceForm.resPic }" />
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
							<input type="checkbox"  id="ckflag" onchange="setChkFlag(this.checked,'isFlag');"
								checked="checked" />
						</logic:equal>
						<logic:notEqual name="wbaseResourceForm" property="isFlag"
							value="1">
							<input type="checkbox" id="ckflag" onchange="setChkFlag(this.checked,'isFlag');" />
						</logic:notEqual>
						<html:hidden property="isFlag" name="wbaseResourceForm" />
					</td>
				</tr>
				<tr>
					<td height="30" align="right">
						显示顺序：
					</td>
					<td>
						<html:text property="viewOrder" name="wbaseResourceForm" maxlength="10"></html:text>
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
						<html:hidden property="id" name="wbaseResourceForm" />
						<wbase:powerButton onclick="saveResource();" resNo="resManagement"
							type="3" value="保存" />
						<wbase:powerButton onclick="deleteResource();" resNo="resManagement"
							type="2" value="删除" />
						<wbase:powerButton onclick="cancel();" resNo="resManagement"
							type="3" value="取消" />
					</td>
				</tr>
			</table>
		</html:form>
	</div>
	<wbase:showMessage />
</logic:notEmpty>
</body>
</html:html>
