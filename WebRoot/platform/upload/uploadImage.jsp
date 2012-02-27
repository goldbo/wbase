<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base target="_self" />
	<title>图片上传</title>

	<meta http-equiv="Expires" CONTENT="0">
	<meta http-equiv="Cache-Control" CONTENT="no-cache">
	<meta http-equiv="Pragma" CONTENT="no-cache">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css"> 
#preview_wrapper{   
    display:inline-block;   
    width:100%;   
    height:100%;   
    background-color:#CCC;   
}   
  
#preview{ /* 该对象用户在FF下显示预览图片 */   
    width:100px;   
    height:100px;   
}   
</style>


	<script type="text/javascript">
function uploadSubmit(){
	var fileValue=document.getElementById("file").value;
	if(check_file(fileValue)==false){
		return false;
	}else{
		uploadFileForm.action="<%=baseURL%>/UploadAction.do?action=uploadImage";
		uploadFileForm.submit();
		return true;
	}
}

	
	//关闭
function closeDialog(){
	window.close();
}
	
function check_file(strFileName){
  if (strFileName=="")
  {
    alert("请选择您要上传的图片！");
    return false;
  }
  var bool = strFileName.match( /.jpg|.jpeg|.gif|.png|.bmp/i );//[ /(\.xls)|(\.xls)|(\.xls)$/i ]
  if (bool){
    return true;
  }else{
    alert("系统暂不支持这种图片格式的上传！\r\n\n请选择jpg|jpeg|gif|png|bmp格式的图片并重新上传！");
	return false;
  }
}

function FileChange(path){
if( !path.match( /.jpg|.gif|.png|.bmp/i ) ){
        alert('图片格式无效！');
        return false;   
    }else{
		document.all.uploadimage.width=10;
		document.all.uploadimage.height=10;
		document.all.uploadimage.alt="";
		document.all.uploadimage.src=path;
	}
}
</script>

</head>
<body>
	<div id="preview_wrapper">
		<html:form action="/UploadAction.do?action=uploadImage" method="post"
			enctype="multipart/form-data" styleId="uploadFileForm">
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
				<tr height="25px">
					<td style="padding: 5px" align="center" colspan="2">

						<div id="preview">
							<IMG alt="预览图片" width="100px" height="100px" id="uploadimage"
								onload="javascript:DrawImage(this,100,100);">
						</div>

					</td>
				</tr>
				<tr height="25px">
					<td nowrap="nowrap" align="center" style="padding:5px" colspan="2">

						<input type="file" id="file" name="file" value=""
							style="width:350px; height:22px"
							onchange="javascript:FileChange(this.value);" />
					</td>
				</tr>
				<tfoot align="center">
					<tr>
						<td style="padding: 5px" colspan="2" align="center">
							<input type="button" value="保 存" onclick="uploadSubmit();"
								class="button1">
							<input type="hidden" id="filePath" name="filePath" value="<%=request.getParameter("filePath").toString() %>" >
							<input type="hidden" id="rename" name="rename" value="<%=request.getParameter("rename").toString() %>" >
							<input type="hidden" id="dirType" name="dirType" value="<%=request.getParameter("dirType").toString() %>" >
							<input type="button" value="取 消" onclick="closeDialog();"
								class="button1">
						</td>
					</tr>
				</tfoot>
			</table>
		</html:form>
	</div>
	<wbase:showMessage />
</body>
</html:html>
