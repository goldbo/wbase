<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<%@ page import="com.wingo.wbase.common.Constants"%>
<html:html lang="true">
<head>
	<html:base />
	<title>用户管理</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
function createUser(url,width,height){
	window.showModalDialog("<%=baseURL%>"+url, "", "dialogWidth="+width+"px;dialogHeight="+height+"px;status:no;");
	wbaseUserForm.submit();
	//window.location.reload(true);
}

function updateUser(url,width,height){
	window.showModalDialog("<%=baseURL%>"+url, "", "dialogWidth="+width+"px;dialogHeight="+height+"px;status:no;");
	wbaseUserForm.submit();
	//window.location.reload(true);
}

function deleteUser(url){
	var num = getCheckBoxNum("selectedRow");
	if(num>0){
	 if (!confirm("确定要删除已选择用户？")){
	 	     return false;
	 	  }else{
	 	  	wbaseUserForm.action="<%=baseURL%>"+url;
			wbaseUserForm.submit();
	 	  	return true;
	 	  }
	}else{
		alert("请选择您要删除的用户！");
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
							用户管理
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
							用户列表
						</td>
					</tr>
					<tr>
						<td>

							<html:form action="/UserAction.do?action=showUserList" >
								<table>
									<tr height="35px">
										<td nowrap="nowrap" align="right">
											是否有效：
										</td>
										<td style="padding-right:5px" nowrap="nowrap">
											<html:select property="isFlag" name="wbaseUserForm">
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
										<%--				<td nowrap="nowrap" align="right">--%>
										<%--					所属岗位：--%>
										<%--				</td>--%>
										<%--				<td style="padding-right:5px" nowrap="nowrap">--%>
										<%--					<wbase:postSelect edit="true"/>--%>
										<%--				</td>--%>
										<%--				<td nowrap="nowrap" align="right">--%>
										<%--					所属角色：--%>
										<%--				</td>--%>
										<%--				<td style="padding-right:5px" nowrap="nowrap">--%>
										<%--					<wbase:roleSelect edit="true"/>--%>
										<%--				</td>--%>
										<td nowrap="nowrap" align="right">
											账号：
										</td>
										<td style="padding-right:5px" nowrap="nowrap">
											<html:text property="account" name="wbaseUserForm"></html:text>
										</td>
										<td nowrap="nowrap" align="right">
											姓名：
										</td>
										<td style="padding-right:5px" nowrap="nowrap">
											<html:text property="userName" name="wbaseUserForm"></html:text>
										</td>

										<td style="padding-right:5px" nowrap="nowrap">
											<wbase:powerButton onclick="wbaseUserForm.submit();"
												resNo="userManagement" type="4" value="查询" />
										</td>
										<td style="padding-right:5px" nowrap="nowrap">
											<wbase:powerButton
												onclick="createUser('/UserAction.do?action=editUser&todo=create',550,460);"
												resNo="userManagement" type="1" value="新增" />
										</td>
										<td style="padding-right:5px" nowrap="nowrap">
											<wbase:powerButton
												onclick="deleteUser('/UserAction.do?action=deleteUser&todo=delete')"
												resNo="userManagement" type="2" value="删除" />
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
												账号
											</td>
											<td>
												姓名
											</td>
											<td>
												所属部门
											</td>
											<td>
												岗位
											</td>
											<td>
												是否有效
											</td>
											<td>
												详细
											</td>
										</tr>
									</thead>
									<tbody>
										<c:if test="${!empty datas}">
											<c:forEach items="${datas}" var="user"
												varStatus="stauts">
												<tr onMouseMove="OM_table(this);"
													onMouseOut="OO_table(this);">
													<td align="center" height="25px">
														<input type='CheckBox' name='selectedRow'
															value='${user.id.uid }'
															onclick='clearAllSelect(this,"selectedRowAll")'>
													</td>
													<td align="center">
														${stauts.index+1 }
													</td>
													<td align="center">
														${user.account }
													</td>
													<td align="center">
														${user.userName }
													</td>
													<td align="center">
														${user.orgName}
													</td>
													<td align="center">
														${user.postName}
													</td>
													<td align="center">
														${user.isFlag==1?"是":"否"}
													</td>
													<td align="center">
														<wbase:powerButton
															onclick="updateUser('/UserAction.do?action=editUser&todo=read&id=${user.id.uid }',550,450);"
															resNo="userManagement" type="4" value="查看" />
														<wbase:powerButton
															onclick="updateUser('/UserAction.do?action=editUser&todo=update&id=${user.id.uid }',550,460);"
															resNo="userManagement" type="3" value="编辑" />
													</td>
												</tr>
											</c:forEach>
											<tr>
												<td colspan="8">
													<wbase:dispartPage formId="wbaseUserForm"/>
												</td>
											</tr>
										</c:if>
										<c:if test="${empty datas}">
											<tr>
												<td colspan="8" align="center" bgcolor="#EFF3F7">
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
