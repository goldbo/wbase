<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base target="_self" />

	<title>新增系统文件类型</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="description" content="cate edit">

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
function saveSysFiletype(todo){
	if(checkForm()){
		document.getElementById("todo").value=todo;
		wbaseSysFiletypeForm.submit();
		return true;
	}else{
		return false;
	}
}

function checkForm(){
	if(!isNumberOrLetter(document.getElementById("fileSuffix").value)){
		alert("扩展名需要由数字或字母组成!");
		return false;
	}else{
		return true;
	}
}

</script>
</head>

<body>
	<div align="center">
		<html:form action="/SysFiletypeAction.do?action=createSysFiletype"
			styleId="wbaseSysFiletypeForm" method="post">
			<table border="0" width="85%" id="table2">
				<tr>
					<td height="25" align="right">
						扩展名:
					</td>
					<td>
						<html:text property="fileSuffix" name="wbaseSysFiletypeForm"
							style="background-color: pink;width: 300px" maxlength="64"></html:text>
					</td>
				</tr>

				<tr>
					<td height="25" align="right">
						图标:
					</td>
					<td>
						<wbase:uploadImage propertyId="filePic" propertyName="filePic" rename="false" dirType="0" savePath="${wbaseSysFiletypeForm.savePath }"/>
					</td>
				</tr>

				<tr>
					<td height="25" align="right">
						说明:
					</td>
					<td>
						<html:text property="fileRemark" name="wbaseSysFiletypeForm" style="width: 300px" maxlength="128"></html:text>
					</td>
				</tr>

				<tr>
					<td align="center" colspan="2" height="25">
						<hr>
						<html:hidden property="todo" name="wbaseSysFiletypeForm" />
						<input type="button" value="继续添加" class="button1"
							onclick="saveSysFiletype('create');">
						<input type="button" value="保存" class="button1"
							onclick="saveSysFiletype('');">
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
