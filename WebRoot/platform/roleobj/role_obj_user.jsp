<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="com.wingo.wbase.model.WbaseUser"%>
<%@ page import="com.wingo.wbase.model.ViewUserInfo"%>
<%@ page import="com.wingo.wbase.service.WbaseUserService"%>
<%@ page import="com.wingo.wbase.common.helper.SpringHelper"%>
<%
			WbaseUserService wbaseUserService = (WbaseUserService) SpringHelper
			.getBean("wbaseUserService");
	String roleNo = request.getParameter("roleNo").toString();
	List<WbaseUser> userList = wbaseUserService.getUserList();
	List<ViewUserInfo> selList = wbaseUserService.findUserInfoByRoleNo(roleNo);
%>
<html:html lang="true">
<head>
	<html:base target="_self" />
	<title>添加用户到角色</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript"
		src="<%=baseURL%>/dwr/interface/wbaseRoleObjService.js"></script>
	<script type="text/javascript" src="<%=baseURL%>/dwr/util.js"></script>
	<script type="text/javascript" src="<%=baseURL%>/dwr/engine.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
//从已选择用户中　移除　用户
function removeUser(isAll)
{

	var box = document.getElementById("selectedUser");
	if(!isAll){
		var list = [];
		var length = box.options.length;
		for (var i=length-1;i>=0;i-- )
		{
			list[i] = [box.options[i].value, box.options[i].innerHTML];
			box.options.remove(i);		
		}
		doAddDefaultUser(list);
	}else{
	if(box.selectedIndex<0){
		return;
	}
	if (box.options.length==0)
	{
		return;
	}
	var list = [];
	var i = 0; j = 0;
	if (isAll)
	{
		var length = box.options.length;
		for (var i=length-1;i>=0;i-- )
		{
			if(box.options[i].selected){
				list[j] = [box.options[i].value, box.options[i].innerHTML];
				box.options.remove(i);		
				j++;			
			}
		}
	}
	else if(box.selectedIndex>=0)
	{
		
		var o = box.options[box.selectedIndex];
		list = [[o.value,o.text]];
		box.options.remove(box.selectedIndex);		
	}
	doAddDefaultUser(list);
	}
}

//移出到用户列表
function doAddDefaultUser(list)
{
	var box = document.getElementById("defaultUser");
	for (var i = 0;i<list.length;i++)
	{
		var o = document.createElement('option')
		var ovalue = list[i][0];
		var otext = list[i][1];
		var length = box.options.length;
		var flag = true;
		for (var k=length-1;k>=0;k-- )
		{
			if(box.options[k].value == ovalue){
				flag = false;			
			}
		}
		if(flag){	
			o.value = ovalue;
			o.text = otext;		
			box.options.add(o);
		}
	}
}


//加入策略
function addUser(isAll)
{

	var box = document.getElementById("defaultUser");
	if(!isAll){
		var list = [];
		var length = box.options.length;
		for (var i=length-1;i>=0;i-- )
		{
			list[i] = [box.options[i].value, box.options[i].innerHTML];
			box.options.remove(i);		
		}
		doAddSelectedUser(list);
	}else{
	if(box.selectedIndex<0){
		return;
	}
	if (box.options.length==0)
	{
		return;
	}
	var list = [];
	var i = 0; j = 0;
	if (isAll)
	{
		var length = box.options.length;
		for (var i=length-1;i>=0;i-- )
		{
			if(box.options[i].selected){
				list[j] = [box.options[i].value, box.options[i].innerHTML];
				box.options.remove(i);		
				j++;			
			}
		}
	}
	else if(box.selectedIndex>=0)
	{
		
		var o = box.options[box.selectedIndex];
		list = [[o.value,o.text]];
		box.options.remove(box.selectedIndex);		
	}
	doAddSelectedUser(list);
	}
}

//添加到已选择用户列表
function doAddSelectedUser(list)
{
	var box = document.getElementById("selectedUser");
	
	for (var i=0;i<list.length;i++)
	{
		var o = document.createElement('option');
		o.value = list[i][0];
		o.text = list[i][1];		
		box.options.add(o);
	}
}

//保存策略变更
function save(){
var cbox = document.getElementById("selectedUser");
var objType="user";
var roleNo = "<%=roleNo%>";
var selIds = [];
if(cbox.length>0){
	for (var i=0;i<cbox.length;i++)
	{
		var val=cbox.options[i].value;
		selIds[i] = val;
	}
	
	}else{
		alert("未添加任何角色用户!");
	}
	wbaseRoleObjService.updateRoleObjByObjIds(selIds,objType,roleNo,function(bool){alert(bool==true?"设置成功!":"设置失败!");});
}

</script>
</head>

<body topmargin="0">
	<table border="0" width="100%" cellspacing="0" cellpadding="0">

		<tr>
			<td height="100%" valign="top"
				style="border: 1px solid #C0C0C0; padding: 0" bgcolor="#FFFFFF">
				<table cellspacing="2" cellpadding="2" width="100%" height="100%">
					<tr>
						<td class="table_thead">
							用户列表
						</td>
						<td style="border: 1px solid #C0C0C0; padding: 1px;padding:5px"
							width="4%" rowspan="2">
							<input type="button" value="添加全部" name="add" class="button1"
								title="添加所有用户" onclick="addUser(false);">
							<br>
							<br>
							<input type="button" value="添加 >" name="add" class="button1"
								title="将该用户添加到角色" onclick="addUser(true);">
							<br>
							<br>
							<input type="button" value="&lt; 移除" name="rem" class="button1"
								title="将该用组移出角色" onclick="removeUser(true);">
							<br>
							<br>
							<input type="button" value="移除全部" name="remall" class="button1"
								title="移除所有用户" onclick="removeUser(false);">
							<br>
						</td>
						<td class="table_thead">
							已选用户
						</td>
					</tr>
					<tr>

						<td style="border: 1px solid #C0C0C0; padding: 1px" valign="top">
							<table cellspacing="0" cellpadding="0" align="center"
								width="100%" id="table1">
								<tr>
									<td>
										<select size="9" name="defaultUser" id="defaultUser"
											style="width:100%; height:350px" multiple>
											<%
													if (userList != null && !userList.isEmpty()) {
													Iterator userIter = userList.iterator();
													while (userIter.hasNext()) {
														WbaseUser user = (WbaseUser) userIter.next();
											%>
											<option value="<%=user.getAccount()%>">
												<%=user.getUserName()%>
											</option>
											<%
												}
												}
											%>
										</select>
									</td>
								</tr>
							</table>
						</td>

						<td align="left" style="border:1px solid #C0C0C0; padding:1px; "
							width="50%" valign="top">
							<select size="9" name="selectedUser" id="selectedUser"
								style="width:100%; height:100%" multiple>
								<%
										if (selList != null && !selList.isEmpty()) {
										Iterator selIter = selList.iterator();
										while (selIter.hasNext()) {
											ViewUserInfo userInfo = (ViewUserInfo) selIter.next();
								%>
								<option value="<%=userInfo.getAccount()%>">
									<%=userInfo.getUserName()%>
								</option>
								<%
									}
									}
								%>
							</select>
						</td>
					</tr>
					<tr>
						<td align="right" colspan="3" height="20">
							<p align="center">
								<input type="button" value="保  存" name="B1" class="button1"
									onclick="save();">
								<input type="button" value="关  闭" name="B2" class="button1"
									onclick="javascript:window.close();">
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<wbase:showMessage />
</body>
</html:html>
