<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base />
	<title>已上传文件</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css"
		href="<%=baseURL%>/common/swfupload/css/swfUpload.css" />
	<script type="text/javascript"
		src="<%=baseURL%>/dwr/interface/wbaseFilesService.js"></script>
	<script type="text/javascript" src="<%=baseURL%>/dwr/util.js"></script>
	<script type="text/javascript" src="<%=baseURL%>/dwr/engine.js"></script>

	<script type="text/javascript">
		function deleteFiles(id){
			uploadFileForm.action="<%=baseURL%>/UploadAction.do?action=deleteFile&id="+id;
			uploadFileForm.submit();
		}
	</script>
</head>

<body>
	<DIV STYLE="width: 100%; height: 120px;">
		<html:form action="/UploadAction.do?action=deleteFile" styleId="uploadFileForm">
			<TABLE ID=uploadedFileList CLASS=uploadFileList>
				<TR CLASS=uploadTitle>
					<td WIDTH=5% ALIGN=CENTER CLASS=uploadTitleTd>
						NO.
					</td>
					<TD WIDTH=55% ALIGN=CENTER CLASS=uploadTitleTd>
						文件名
					</TD>
					<TD WIDTH=20% ALIGN=CENTER CLASS=uploadTitleTd>
						文件大小
					</TD>
					<TD WIDTH=20% ALIGN=CENTER CLASS=uploadTitleTd>
						详细
					</TD>
				</TR>
				<c:if test="${!empty fileList}">
					<c:forEach items="${fileList}" var="data" varStatus="stauts">
						<tr id="${stauts.index+1 }">
							<td align="center">
								${stauts.index+1 }
							</td>
							<td align="left">
								<img alt=""
									src="<%=baseURL%>/uploadfile/filetype/${data.fileExt }.gif">
								&nbsp;&nbsp;${data.fileName }
							</td>
							<td align="center">
								${data.fileSize }
							</td>
							<td align="center">
								<a href="javascript:void(0)"
									onclick="deleteFiles('${stauts.index }')">删除</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty fileList}">
					<tr>
						<td colspan="5" align="center" bgcolor="#EFF3F7">
							暂无已上传文件
						</td>
					</tr>
				</c:if>
			</TABLE>
		</html:form>
	</DIV>
	<wbase:showMessage />
</body>
</html:html>
