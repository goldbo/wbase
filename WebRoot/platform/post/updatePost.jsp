<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base target="_self" />

	<title>更新岗位信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="description" content="cate edit">

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
function savePost(todo){
	if(checkForm()){
		document.getElementById("todo").value=todo;
		wbasePostForm.submit();
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
	if(!isNumberOrLetter(document.getElementById("postNo").value)){
		alert("岗位编号需要由数字或字母组成！");
		return false;
	}else if(!isChinaOrNumbOrLett(document.getElementById("postName").value)){
		alert("岗位名称需要由汉字或字母或数字组成！");
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
		<html:form action="/PostAction.do?action=updatePost"
			styleId="wbasePostForm" method="post">
			<table border="0" width="85%" id="table2">
				<tr>
					<td width="40%" height="25" align="right">
						岗位编号：
					</td>
					<td>
						<html:text property="postNo" name="wbasePostForm" readonly="true"
							style="background-color: pink" maxlength="16"></html:text>
					</td>
				</tr>
				<tr>
					<td height="25" align="right">
						岗位名称：
					</td>
					<td>
						<html:text property="postName" name="wbasePostForm" style="background-color: pink" maxlength="16"></html:text>
					</td>
				</tr>
				<tr>
					<td height="25" align="right">
						岗位级别：
					</td>
					<td>
						<html:text property="postLevel" name="wbasePostForm" maxlength="10"></html:text>
					</td>
				</tr>
				<tr>
					<td height="25" align="right">
						备注：
					</td>
					<td >
						<html:textarea property="remark" name="wbasePostForm" cols="30" rows="5"></html:textarea>
					</td>
				</tr>
				
				<tr>
					<td align="center" colspan="2" height="25">
						<hr>
						<html:hidden property="id" name="wbasePostForm"/>
						<html:hidden property="todo" name="wbasePostForm"/>
						<input type="button" value="保存" class="button1"
							onclick="savePost('');">
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
