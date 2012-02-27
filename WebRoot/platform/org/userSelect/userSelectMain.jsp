<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="com.wingo.wbase.model.ViewUserInfo"%>
<%@ page import="com.wingo.wbase.service.WbaseUserService"%>
<%@ page import="com.wingo.wbase.common.helper.SpringHelper"%>
<%
			WbaseUserService wbaseUserService = (WbaseUserService) SpringHelper
			.getBean("wbaseUserService");
	Long orgNodeNo = Long.valueOf(request.getParameter("orgNodeNo").toString());
	List<ViewUserInfo> userList = wbaseUserService.getNoOrgUserList("",
			"", orgNodeNo);
%>
<html:html lang="true">
<head>
	<html:base />
	<title>添加用户到组织</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript"
		src="<%=baseURL%>/dwr/interface/wbaseOrgUserService.js"></script>
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

//移出到用户列表
function doAddDefaultUser(list)
{
	var box = document.getElementById("defaultUser");
	for (var i = 0;i<list.length;i++)
	{
		var o = document.createElement('option')
		o.value = list[i][0];
		o.text = list[i][1];		
		box.options.add(o);
	}
}


//加入策略
function addUser(isAll)
{

	var box = document.getElementById("defaultUser");
	
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
var orgNodeNo = "<%=orgNodeNo%>";
var selIds = [];
if(cbox.length>0){
	for (var i=0;i<cbox.length;i++)
	{
		var val=cbox.options[i].value;
		selIds[i] = val;
	}
		wbaseOrgUserService.updateOrgUserByUserIds(selIds,orgNodeNo,function(bool){alert(bool==true?"添加成功！":"添加失败");window.close();});
	}else{
		alert("请添加组织用户！");
	}
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
						<td  class="table_thead">
							用户列表
						</td>
						<td style="border: 1px solid #C0C0C0; padding: 1px;padding:5px"
							width="4%" rowspan="2">
							<input type="button" value="添加 >" name="add" class="button1"
								title="将该用户添加到组织" onclick="addUser(true);">
							<br>
							<br>
							<input type="button" value="&lt; 移除" name="rem" class="button1"
								title="将该用户移出组织" onclick="removeUser(true);">
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
													if (userList != null) {
													Iterator userIter = userList.iterator();
													while (userIter.hasNext()) {
														ViewUserInfo user = (ViewUserInfo) userIter.next();
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
								style="width:100%; height:350px" multiple>
							</select>
						</td>
					</tr>
					<tr>
						<td align="right" colspan="3" height="20">
							<p align="center">
								<input type="submit" value="保  存" name="B1" class="button1" onclick="save();" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<wbase:showMessage />
</body>
</html:html>
