<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base />
	<title>岗位管理</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
function createPost(url,width,height){
	window.showModalDialog("<%=baseURL%>"+url, "", "dialogWidth="+width+"px;dialogHeight="+height+"px;status:no;");
	wbasePostForm.submit();
	//window.location.reload(true);
}

function updatePost(url,width,height){
	window.showModalDialog("<%=baseURL%>"+url, "", "dialogWidth="+width+"px;dialogHeight="+height+"px;status:no;");
	wbasePostForm.submit();
	//window.location.reload(true);
}

function deletePost(url){
	var num = getCheckBoxNum("selectedRow");
	if(num>0){
	 if (!confirm("确定要删除已选择岗位？")){
	 	     return false;
	 	  }else{
	 	  	wbasePostForm.action="<%=baseURL%>"+url;
			wbasePostForm.submit();
	 	  	return true;
	 	  }
	}else{
		alert("请选择您要删除的岗位！");
		return false;
	}
}
</script>
</head>

<body>
	<table width="100%" height="100%" align="center" border="0"
		cellspacing="0" cellpadding="0">
		<tr>
			<td height="30" valign="top" bgcolor="#f1f7fb">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="10" class="tab_kp_off">
							&nbsp;
						</td>
						<td width="100" height="26" class="tab_kp_on">
							岗位管理
						</td>
						<td class="tab_kp_off">
							&nbsp;
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td valign="top">
				<table width="98%" align="center" border="1" cellspacing="0"
					cellpadding="0" bordercolor="#A6CCEB"
					style="border-collapse:collapse; margin:8px 0px;">
					<tr>
						<td class="table_thead tdl">
							岗位列表
						</td>
					</tr>
					<tr>
						<td>
							<html:form action="/PostAction.do?action=showPostList"
								styleId="wbasePostForm">
								<table>
									<tr height="35px">
										<%--				<td nowrap="nowrap" align="right">--%>
										<%--					是否有效：--%>
										<%--				</td>--%>
										<%--				<td style="padding-right:5px" nowrap="nowrap">--%>
										<%--					<html:select property="isFlag" name="wbasePostForm">--%>
										<%--						<html:option value="3">--%>
										<%--							--全部----%>
										<%--						</html:option>--%>
										<%--						<html:option value="1">--%>
										<%--							是--%>
										<%--						</html:option>--%>
										<%--						<html:option value="0">--%>
										<%--							否--%>
										<%--						</html:option>--%>
										<%--					</html:select>--%>
										<%----%>
										<%--				</td>--%>
										<td nowrap="nowrap" align="right">
											岗位编号：
										</td>
										<td style="padding-right:5px" nowrap="nowrap">
											<html:text property="postNo" name="wbasePostForm"></html:text>
										</td>
										<td nowrap="nowrap" align="right">
											岗位名称：
										</td>
										<td style="padding-right:5px" nowrap="nowrap">
											<html:text property="postName" name="wbasePostForm"></html:text>
										</td>
										<td style="padding-right:5px" nowrap="nowrap">
											<wbase:powerButton onclick="wbasePostForm.submit();"
												resNo="postManagement" type="4" value="查询" />
										</td>
										<td style="padding-right:5px" nowrap="nowrap">
											<wbase:powerButton
												onclick="createPost('/PostAction.do?action=editPost&todo=create',450,300);"
												resNo="postManagement" type="1" value="新增" />
										</td>
										<td style="padding-right:5px" nowrap="nowrap">
											<wbase:powerButton
												onclick="deletePost('/PostAction.do?action=deletePost&todo=delete');"
												resNo="postManagement" type="2" value="删除" />
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
												岗位编号
											</td>
											<td>
												岗位名称
											</td>
											<td>
												岗位级别
											</td>
											<td>
												创建时间
											</td>
											<td>
												详细
											</td>
										</tr>
									</thead>
									<tbody>
										<c:if test="${!empty datas}">
											<c:forEach items="${datas}" var="Post"
												varStatus="stauts">
												<tr onMouseMove="OM_table(this);"
													onMouseOut="OO_table(this);">
													<td align="center" height="25px">
														<input type='CheckBox' name='selectedRow'
															value='${Post.id }'
															onclick='clearAllSelect(this,"selectedRowAll")'>
													</td>
													<td align="center">
														${stauts.index+1 }
													</td>
													<td align="center">
														${Post.postNo }
													</td>
													<td align="center">
														${Post.postName }
													</td>
													<td align="center">
														${Post.postLevel}
													</td>
													<td align="center">
														<%--								${Post.createDate}--%>
														${fn:substring(Post.createDate, 0, 19)}
													</td>
													<td align="center">
														<wbase:powerButton
															onclick="updatePost('/PostAction.do?action=editPost&todo=update&id=${Post.id }',450,300);"
															resNo="postManagement" type="3" value="编辑" />
														<wbase:powerButton
															onclick="updatePost('/platform/post/post_user.jsp?postNo=${Post.postNo }',600,450);"
															resNo="postManagement" type="3" value="设置成员" />
													</td>
												</tr>
											</c:forEach>
											<tr>
													<td colspan="8">
														<wbase:dispartPage formId="wbasePostForm" />
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
