<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base target="_self"/>
	<title>系统消息管理</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
function createSysMessages(url,width,height){
	window.showModalDialog("<%=baseURL%>"+url, "", "dialogWidth="+width+"px;dialogHeight="+height+"px;status:no;");
	wbaseSysMessagesForm.submit();
	//window.location.reload(true);
}

function updateSysMessages(url,width,height){
	window.showModalDialog("<%=baseURL%>"+url, "", "dialogWidth="+width+"px;dialogHeight="+height+"px;status:no;");
	wbaseSysMessagesForm.submit();
	//window.location.reload(true);
}

function deleteSysMessages(url){
	var num = getCheckBoxNum("selectedRow");
	if(num>0){
	 if (!confirm("确定要删除已选择系统消息？")){
	 	     return false;
	 	  }else{
	 	  	wbaseSysMessagesForm.action="<%=baseURL%>"+url;
			wbaseSysMessagesForm.submit();
	 	  	return true;
	 	  }
	}else{
		alert("请选择您要删除的系统消息！");
		return false;
	}
}
</script>
</head>

<body>
	<table width="100%" height="100%" align="center" border="0"
		cellspacing="0" cellpadding="0">
		<tr>
			<td valign="top">
				<table width="98%" align="center" border="1" cellspacing="0"
					cellpadding="0" bordercolor="#A6CCEB"
					style="border-collapse:collapse; margin:8px 0px;">
					<tr>
						<td class="table_thead tdl">
							系统消息列表
						</td>
					</tr>
					<tr>
						<td>
							<html:form
								action="/SysMessagesAction.do?action=showSysMessagesList"
								styleId="wbaseSysMessagesForm">
								<table>
									<tr height="35px">
										<td nowrap="nowrap" align="right">
											消息标题：
										</td>
										<td style="padding-right:5px" nowrap="nowrap">
											<html:text property="msgTitle" name="wbaseSysMessagesForm"></html:text>
										</td>
										<td style="padding-right:5px" nowrap="nowrap">
											<wbase:powerButton onclick="wbaseSysMessagesForm.submit();"
												resNo="baseConifg" type="4" value="查询" />
										</td>
										<td style="padding-right:5px" nowrap="nowrap">
											<wbase:powerButton
												onclick="createSysMessages('/SysMessagesAction.do?action=editSysMessages&todo=create',750,600);"
												resNo="baseConifg" type="1" value="新增" />
										</td>
										<td style="padding-right:5px" nowrap="nowrap">
											<wbase:powerButton
												onclick="deleteSysMessages('/SysMessagesAction.do?action=deleteSysMessages&todo=delete');"
												resNo="baseConifg" type="2" value="删除" />
										</td>
										<td style="padding-right:5px" nowrap="nowrap">
											<input type="button" value="返回" class="button1"
												onclick="javascript:window.history.back();">
										</td>
									</tr>
								</table>
								<table width="100%" border="1" cellspacing="0" cellpadding="0"
									bordercolor="#D0D0D0" style="border-collapse:collapse; ">
									<thead>
										<tr height="25px" align="center">
											<td width="5%" align="center" class="listheadbg">
												<input type='CheckBox' id='selectedRowAll'
													name='selectedRowAll'
													onclick='selectAllGrid(this,"selectedRow")'>
											</td>
											<td>
												NO.
											</td>
											<td>
												消息标题
											</td>
											<td>
												开始时间
											</td>
											<td>
												结束时间
											</td>
											<td>
												是否发布
											</td>
											<td>
												详细
											</td>
										</tr>
									</thead>
									<tbody>
										<c:if test="${!empty datas}">
											<c:forEach items="${datas}" var="SysMessages"
												varStatus="stauts">
												<tr onMouseMove="OM_table(this);"
													onMouseOut="OO_table(this);">
													<td align="center" height="25px">
														<input type='CheckBox' name='selectedRow'
															value='${SysMessages.id }'
															onclick='clearAllSelect(this,"selectedRowAll")'>
													</td>
													<td align="center">
														${stauts.index+1 }
													</td>
													<td align="center">
														${SysMessages.msgTitle }
													</td>
													<td align="center">
														${fn:substring(SysMessages.msgStarttime, 0, 19)}
													</td>
													<td align="center">
														${fn:substring(SysMessages.msgEndtime, 0, 19)}
													</td>
													<td align="center">
														${SysMessages.msgFlag==1?"是":"否" }
													</td>
													<td align="center">
														<wbase:powerButton
															onclick="updateSysMessages('/SysMessagesAction.do?action=editSysMessages&todo=read&id=${SysMessages.id }',750,600);"
															resNo="baseConifg" type="4" value="查看" />
														<wbase:powerButton
															onclick="updateSysMessages('/SysMessagesAction.do?action=editSysMessages&todo=update&id=${SysMessages.id }',750,600);"
															resNo="baseConifg" type="3" value="编辑" />
													</td>
												</tr>
											</c:forEach>
											<tr>
												<td colspan="8">
													<wbase:dispartPage formId="wbaseSysMessagesForm" />
												</td>
											</tr>
										</c:if>
										<c:if test="${empty datas}">
											<tr>
												<td colspan="7" align="center" bgcolor="#EFF3F7">
													没有找到相应的记录
												</td>
											</tr>
										</c:if>
									</tbody>
								</table>
							</html:form>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>


	<wbase:showMessage />
</body>
</html:html>
