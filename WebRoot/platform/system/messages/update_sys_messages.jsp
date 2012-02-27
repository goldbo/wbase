<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base target="_self" />

	<title>更新系统消息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="description" content="cate edit">

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="<%=baseURL%>/common/ckeditor/ckeditor.js"
		type="text/javascript"></script>
	<script src="<%=baseURL%>/common/js/DateTimePicker.js"
		type="text/javascript"></script>
	<script type="text/javascript">
function saveSysMessages(todo){
	if(checkForm()){
		document.getElementById("todo").value=todo;
		wbaseSysMessagesForm.submit();
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
	var sdate = document.getElementById("msgStarttime").value;
	var edate = document.getElementById("msgEndtime").value;
	if(isNull(document.getElementById("msgTitle").value)){
		alert("请填写要发布的消息标题!");
		return false;
	}else if(sdate>edate){
		alert("有效期开始时间必须大于结束时间!");
		return false;
	}else{
		return true;
	}
}

window.onload = function(){  
       CKEDITOR.replace('msgContents',{filebrowserUploadUrl : '<%=baseURL%>/ckeditor/uploader?Type=File',   
filebrowserImageUploadUrl : '<%=baseURL%>/ckeditor/uploader?Type=Image',   
filebrowserFlashUploadUrl : '<%=baseURL%>/ckeditor/uploader?Type=Flash'  
        }); 
}
</script>
</head>

<body >
	<div align="center">
		<html:form action="/SysMessagesAction.do?action=updateSysMessages"
			styleId="wbaseSysMessagesForm" >
			<table border="0" width="95%" id="table2">
				<tr>
					<td height="25" align="right" width="60px">
						消息标题:
					</td>
					<td>
						<html:text property="msgTitle" name="wbaseSysMessagesForm"
							style="background-color: pink;width: 300px" maxlength="64"></html:text>
					</td>
				</tr>
				<tr>
					<td height="25" align="right">
						有效期:
					</td>
					<td>
						<table>
							<tr>
								<td>
									<html:text property="msgStarttime" name="wbaseSysMessagesForm"
										onclick="setday(this)" readonly="true"></html:text>
									<%--									<input type="text" id="msgStarttime" name="msgStarttime"--%>
									<%--										onclick="setday(this)" readonly="readonly">--%>
								</td>
								<td>
									--
								</td>
								<td>
									<html:text property="msgEndtime" name="wbaseSysMessagesForm"
										onclick="setday(this)" readonly="true"></html:text>
									<%--									<input type="text" id="msgEndtime" name="msgEndtime"--%>
									<%--										onclick="setday(this)" readonly="readonly">--%>
								</td>
							</tr>
						</table>
					</td>
				</tr>

				<tr>
					<td height="25" align="right">
						消息正文:
					</td>
					<td>
						<html:textarea property="msgContents" name="wbaseSysMessagesForm"
							rows="20" cols="60" ></html:textarea>
				</tr>

				<tr>
					<td height="25" align="right">
						附件:
					</td>
					<td>
						<html:text property="msgAttachment" name="wbaseSysMessagesForm"></html:text>
					</td>
				</tr>

				<tr>
					<td align="center" colspan="2" height="25">
						<hr>
						<html:hidden property="id" name="wbaseSysMessagesForm"/>
						<html:hidden property="todo" name="wbaseSysMessagesForm" />
						<input type="button" value="保存" class="button1"
							onclick="saveSysMessages('');">
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
