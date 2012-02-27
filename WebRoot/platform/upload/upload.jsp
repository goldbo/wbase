<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base />
	<title>报表测试</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function uploadFile(url,width,height){
	var obj = new Object();
	obj.file_size_limit = "10 MB";
	obj.file_types = "*.*";
	obj.file_types_description = "所有文件";
	obj.file_upload_limit = "2";
	window.showModalDialog("<%=baseURL%>"+url, obj, "dialogWidth="+width+"px;dialogHeight="+height+"px;status:no;");
	//window.location.reload(true);
}
</script>
</head>

<body>
	<input type="button" value="上传附件" onclick="uploadFile('/platform/upload/uploadFile.jsp',800,500)">

<wbase:uploadFile file_size_limit="12" file_upload_limit="5"/>
<wbase:showMessage/>
</body>
</html:html>
