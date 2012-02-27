<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base />
	<title>角色管理</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
function createRole(url,width,height){
	window.showModalDialog("<%=baseURL%>"+url, "", "dialogWidth="+width+"px;dialogHeight="+height+"px;status:no;");
	wbaseRoleForm.submit();
	//window.location.reload(true);
}

function updateRole(url,width,height){
	window.showModalDialog("<%=baseURL%>"+url, "", "dialogWidth="+width+"px;dialogHeight="+height+"px;status:no;");
	wbaseRoleForm.submit();
	//window.location.reload(true);
}

function deleteRole(url){
	var num = getCheckBoxNum("selectedRow");
	if(num>0){
	 if (!confirm("确定要删除已选择角色？")){
	 	     return false;
	 	  }else{
	 	  	wbaseRoleForm.action="<%=baseURL%>"+url;
			wbaseRoleForm.submit();
	 	  	return true;
	 	  }
	}else{
		alert("请选择您要删除的角色！");
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
							角色管理
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
							角色列表
						</td>
					</tr>
					<tr>
						<td>
							<html:form action="/RoleAction.do?action=showRoleList"
								styleId="wbaseRoleForm">
								<table>
									<tr height="35px">
										<td nowrap="nowrap" align="right">
											是否有效：
										</td>
										<td style="padding-right:5px" nowrap="nowrap">
											<html:select property="isFlag" name="wbaseRoleForm">
												<html:option value="3">
							--全部--
						</html:option>
												<html:option value="1">
							是
						</html:option>
												<html:option value="0">
							否
						</html:option>
											</html:select>

										</td>
										<td nowrap="nowrap" align="right">
											角色编号：
										</td>
										<td style="padding-right:5px" nowrap="nowrap">
											<html:text property="roleNo" name="wbaseRoleForm"></html:text>
										</td>
										<td nowrap="nowrap" align="right">
											角色名称：
										</td>
										<td style="padding-right:5px" nowrap="nowrap">
											<html:text property="roleName" name="wbaseRoleForm"></html:text>
										</td>
										<td style="padding-right:5px" nowrap="nowrap">
											<wbase:powerButton onclick="wbaseRoleForm.submit();"
												resNo="roleManagement" type="4" value="查询" />
										</td>
										<td style="padding-right:5px" nowrap="nowrap">
											<wbase:powerButton
												onclick="createRole('/RoleAction.do?action=editRole&todo=create',450,300);"
												resNo="roleManagement" type="1" value="新增" />
										</td>
										<td style="padding-right:5px" nowrap="nowrap">
											<wbase:powerButton
												onclick="deleteRole('/RoleAction.do?action=deleteRole&todo=delete');"
												resNo="roleManagement" type="2" value="删除" />
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
												角色编号
											</td>
											<td>
												角色名称
											</td>
											<td>
												是否有效
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
											<c:forEach items="${datas}" var="Role"
												varStatus="stauts">
												<tr onMouseMove="OM_table(this);"
													onMouseOut="OO_table(this);">
													<td align="center" height="25px">
														<input type='CheckBox' name='selectedRow'
															value='${Role.id }'
															onclick='clearAllSelect(this,"selectedRowAll")'>
													</td>
													<td align="center">
														${stauts.index+1 }
													</td>
													<td align="center">
														${Role.roleNo }
													</td>
													<td align="center">
														${Role.roleName }
													</td>
													<td align="center">
														${Role.isFlag==1?"是":"否"}
													</td>
													<td align="center">
														<%--								${Role.createDate}--%>
														${fn:substring(Role.createDate, 0, 19)}
													</td>
													<td align="center">
														<table>
															<tr>
																<td>
																	<wbase:powerButton
																		onclick="updateRole('/RoleAction.do?action=editRole&todo=update&id=${Role.id }',450,300);"
																		resNo="roleManagement" type="3" value="编辑" />
																</td>
																<td>
																	<wbase:powerButton
																		onclick="updateRole('/platform/power/powerMain.jsp?roleNo=${Role.roleNo }',600,450);"
																		resNo="roleManagement" type="3" value="权限设置" />
																</td>
																<td>
																	<wbase:powerButton
																		onclick="updateRole('/platform/roleobj/role_obj_main.jsp?roleNo=${Role.roleNo }',700,450);"
																		resNo="roleManagement" type="3" value="成员设置" />
																</td>
														</table>
													</td>
												</tr>
											</c:forEach>
											<tr>
												<td colspan="8">
													<wbase:dispartPage formId="wbaseRoleForm" />
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
