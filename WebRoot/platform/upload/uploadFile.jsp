<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base />
	<title>文件上传</title>
	<link rel="stylesheet" type="text/css"
		href="<%=baseURL%>/common/swfupload/css/swfUpload.css" />
	<link rel="stylesheet" type="text/css"
		href="<%=baseURL%>/common/swfupload/ext/resources/css/ext-all.css" />
	<script type="text/javascript"
		src="<%=baseURL%>/common/swfupload/ext/adapter/ext/ext-base.js"></script>
	<script type="text/javascript"
		src="<%=baseURL%>/common/swfupload/ext/ext-all.js"></script>
	<script type="text/javascript"
		src="<%=baseURL%>/common/swfupload/ext/ext-lang-zh_CN.js"></script>

	<script type="text/javascript"
		src="<%=baseURL%>/common/swfupload/js/swfupload/swfupload.js"></script>
	<script type="text/javascript"
		src="<%=baseURL%>/common/swfupload/js/swfupload/swfupload.swfobject.js"></script>
	<script type="text/javascript"
		src="<%=baseURL%>/common/swfupload/js/swfupload/swfupload.queue.js"></script>
	<script type="text/javascript"
		src="<%=baseURL%>/common/swfupload/js/swfupload/fileprogress.js"></script>
	<script type="text/javascript"
		src="<%=baseURL%>/common/swfupload/js/swfupload/handlers.js"></script>
	<script type="text/javascript">
			var obj = window.dialogArguments;
			//alert(obj.file_size_limit+obj.file_types+obj.file_types_description+obj.file_upload_limit);
			var swfu;
			SWFUpload.onload = function () {
			var settings = {
			flash_url :  "<%=baseURL%>/common/swfupload/js/swfupload/swfupload.swf",
			upload_url: "<%=baseURL%>/FileUploadServlet.do",
			use_query_string : true,
			//可以设置多个上传附件的键值对应属性.比如与附件相关的信息等
			post_params: {"user_id" : "wingo","pass_id" : "123456"},
			file_size_limit : obj.file_size_limit,
			file_types : obj.file_types,
			file_types_description : obj.file_types_description,
			file_upload_limit : obj.file_upload_limit,
			file_queue_limit : 0,
			custom_settings : {
			progressTarget : "fsUploadProgress",
			cancelButtonId : "btnCancel",
			uploadButtonId : "btnUpload",
			myFileListTarget : "idFileList"
			},
			debug: false,
			auto_upload:false,button_image_url : "<%=baseURL%>/common/swfupload/images/buttonUpload.gif",
			button_placeholder_id : "spanButtonPlaceholder",
			button_width: 100,
			button_height: 21,
			swfupload_loaded_handler : swfUploadLoaded,
			file_queued_handler : fileQueued,
			file_queue_error_handler : fileQueueError,
			file_dialog_complete_handler : fileDialogComplete,
			upload_start_handler : uploadStart,
			upload_progress_handler : uploadProgress,
			upload_error_handler : uploadError,
			upload_success_handler : uploadSuccess,
			upload_complete_handler : uploadComplete,
			queue_complete_handler : queueComplete,
			minimum_flash_version : "9.0.28",
			swfupload_pre_load_handler : swfUploadPreLoad,
			swfupload_load_failed_handler : swfUploadLoadFailed
			};
			swfu = new SWFUpload(settings);
			}
		</script>
</head>
<body>
	<CENTER>
		<form method="post" name="actForm2" enctype="multipart/form-data"
			action="<%=baseURL%>/FileUploadServlet.do">
			<ul STYLE="margin: 0px;">
				<LI STYLE="width: 100%;">
					<TABLE WIDTH=92% CELLSPACING=4 CELLPADDING=4 BORDER=0>
						<TR>
							<TD CLASS=DH2 WIDTH=100>
								<img border="0" src="<%=baseURL%>/common/images/item_point.gif" />
								批量上传
							</TD>
							<TD>
							</TD>
						</TR>
					</TABLE>
				</LI>
				<LI CLASS=Layer2 STYLE="width: 95%;">
					<DIV CLASS=ItemBlockBorder>
						<DIV CLASS=ItemBlock>
							<DIV ID=content>
								<TABLE WIDTH=100% CELLSPACING=0 CELLPADDING=0 BORDER=0>
									<TR>
										<TD VALIGN=TOP>
											<SPAN ID=spanButtonPlaceholder></SPAN> &nbsp;
											<input type="button" value="上传文件" class="DotButton"
												id="btnUpload" />
											&nbsp;
											<input type="button" disabled="disabled" value="全部取消"
												class="DotButton" id="btnCancel" />
										</TD>
									</TR>
								</TABLE>
								<TABLE>
									<TR>
										<TD HEIGHT=10></TD>
									</TR>
								</TABLE>
								<TABLE ID=idFileList CLASS=uploadFileList>
									<TR CLASS=uploadTitle>
										<TD WIDTH=50% ALIGN=CENTER CLASS=uploadTitleTd>
											文件名
										</TD>
										<TD WIDTH=20% ALIGN=CENTER CLASS=uploadTitleTd>
											文件大小
										</TD>
										<TD WIDTH=20% ALIGN=CENTER CLASS=uploadTitleTd>
											状态
										</TD>
										<TD WIDTH=10% CLASS=uploadTitleTd>
											&nbsp;
										</TD>
									</TR>
								</TABLE>
								<TABLE>
									<TR>
										<TD HEIGHT=5></TD>
									</TR>
								</TABLE>
								<TABLE WIDTH=100% BORDER=0 CELLSPACING=0 CELLPADDING=0>
									<TR>
										<TD ALIGN=LEFT>
											等待上传&nbsp;
											<SPAN ID=idFileListCount><FONT COLOR=#000000>0</FONT>
											</SPAN>&nbsp;个
											<SPAN ID=idFileListSuccessUploadCount></SPAN>
										</TD>
									</TR>
								</TABLE>
								<DIV ID=divSWFUploadUI STYLE="visibility: hidden;">
								</DIV>
								<DIV ID=divLoadingContent CLASS=content
									STYLE="background-color: #FFFF66; border-top: solid 4px #FF9966; border-bottom: solid 4px #FF9966; margin: 10px 25px; padding: 10px 15px; display: none;">
									文件上传界面正在载入，请稍后...
								</DIV>
								<DIV ID=divLongLoading CLASS=content
									STYLE="background-color: #FFFF66; border-top: solid 4px #FF9966; border-bottom: solid 4px #FF9966; margin: 10px 25px; padding: 10px 15px; display: none;">
									文件上传界面载入失败，请确保浏览器已经开启对JavaScript的支持，并且已经安装可以工作的Flash插件版本。
									<P></P>
								</DIV>
								<DIV ID=divAlternateContent CLASS=content
									STYLE="background-color: #FFFF66; border-top: solid 4px #FF9966; border-bottom: solid 4px #FF9966; margin: 10px 25px; padding: 10px 15px; display: none;">
									很抱歉，文件上传界面无法载入，请安装或者升级您的Flash插件。
								</DIV>
							</DIV>
						</DIV>
					</DIV>
				</LI>
			</ul>
		</form>
	</CENTER>

		<CENTER>
			<ul STYLE="margin: 0px;">
				<LI STYLE="width: 100%;">
					<TABLE WIDTH=90%>
						<TR>
							<TD HEIGHT=10 CLASS=NavigationListTitle WIDTH=100>
								<img border="0" src="<%=baseURL%>/common/images/item_point.gif" />
								已上传文件
							</TD>
							<TD CLASS=GrayDottedLine>
								&nbsp;
							</TD>
						</TR>
					</TABLE>
				</LI>
				<LI CLASS=Layer2 STYLE="width: 95%; ">
					<DIV CLASS=ItemBlockBorder>
						<DIV CLASS=ItemBlock>
							<iframe id="complete_frame" width="100%" height="200px" align="middle" frameborder="0" src="<%=baseURL %>/platform/upload/upload_complete.jsp"></iframe>
						</DIV>
					</DIV>
				</LI>
			</ul>
		</CENTER>
</body>
</html:html>
