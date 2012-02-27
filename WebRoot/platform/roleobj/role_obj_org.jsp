<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="com.wingo.wbase.model.WbaseOrg"%>
<%@ page import="com.wingo.wbase.model.WbaseRoleObj"%>
<%@ page import="com.wingo.wbase.common.SystemCache"%>
<%@ page import="com.wingo.wbase.service.WbaseRoleObjService"%>
<%@ page import="com.wingo.wbase.common.helper.SpringHelper"%>
<%
			WbaseRoleObjService wbaseRoleObjService = (WbaseRoleObjService) SpringHelper
			.getBean("wbaseRoleObjService");
	String roleNo = request.getParameter("roleNo").toString();
	Map orgMap = SystemCache.orgCache;//组织MAP
	List<WbaseRoleObj> selList = wbaseRoleObjService
			.findRoleObjByRoleNo("org", roleNo);
%>
<html:html lang="true">
<head>
	<html:base target="_self" />
	<title>添加组织到角色</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript"
		src="<%=baseURL%>/dwr/interface/wbaseRoleObjService.js"></script>
	<script type="text/javascript" src="<%=baseURL%>/dwr/util.js"></script>
	<script type="text/javascript" src="<%=baseURL%>/dwr/engine.js"></script>
	<script type="text/javascript"
		src="<%=baseURL%>/platform/roleobj/dtree/dtree.js"></script>
	<link rel="stylesheet"
		href="<%=baseURL%>/platform/roleobj/dtree/dtree.css" type="text/css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
//移除角色组织
function removeRoleOrg(isAll)
{

	var box = document.getElementById("selectedOrg");
	
	if(!isAll){
		var length = box.options.length;
		for (var i=length-1;i>=0;i-- )
		{
				box.options.remove(i);		
		}
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
	}
}



//加入角色组织
function addRoleOrg(isAll)
{
	var list;
	if(isAll){
		list = orgTree.getAllCheckTreeIDValue();
		doAddselectedOrg(list);
	}else{
		list = orgTree.getCheckTreeIDValue();
		if (list.length==0)
		{
			alert("请选择菜单!");
			return;
		}else{
			doAddselectedOrg(list);
		}
	}
	
}

//添加到已选择角色组织
function doAddselectedOrg(list)
{
	var box = document.getElementById("selectedOrg");
	
	for (var i=0;i<list.length;i++)
	{
		var o = document.createElement('option');
		var str = list[i];
		var val = str.split(",");
		var ovalue = val[0];
		var otext = val[1];
		
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

//保存角色组织
function save(){
var cbox = document.getElementById("selectedOrg");
var objType="org";
var roleNo = "<%=roleNo%>";
var selIds = [];
if(cbox.length>0){
	for (var i=0;i<cbox.length;i++)
		{
			var val=cbox.options[i].value;
			selIds[i] = val;
		}
	}else{
		alert("您未选择任何组织!");
	}
	wbaseRoleObjService.updateRoleObjByObjIds(selIds,objType,roleNo,function(bool){alert(bool==true?"设置成功!":"设置失败!");});
}
</script>
</head>

<body topmargin="0">
	<table border="0" width="100%" height="100%" cellspacing="0"
		cellpadding="0">
		<tr>
			<td height="100%" valign="top"
				style="border: 1px solid #C0C0C0; padding: 0" bgcolor="#FFFFFF">
				<table cellspacing="2" cellpadding="2" width="100%" height="100%">
					<tr>
						<td class="table_thead">
							组织树
						</td>
						<td style="border: 1px solid #C0C0C0; padding: 1px;padding:5px"
							width="4%" rowspan="2">
							<input type="button" value="添加全部" name="add" class="button1"
								title="添加所有组织" onclick="addRoleOrg(true);">
							<br>
							<br>
							<input type="button" value="添加 >" name="add" class="button1"
								title="添加组织" onclick="addRoleOrg(false);">
							<br>
							<br>
							<input type="button" value="&lt; 移除" name="rem" class="button1"
								title="移除选中的已选组织" onclick="removeRoleOrg(true);">
							<br>
							<br>
							<input type="button" value="移除全部" name="remall" class="button1"
								title="移除所有已选组织" onclick="removeRoleOrg(false);">
							<br>
						</td>
						<td class="table_thead">
							已选组织
						</td>
					</tr>
					<tr>

						<td style="border: 1px solid #C0C0C0; padding: 1px" valign="top">
							<table cellspacing="0" cellpadding="0" align="center"
								width="100%" id="table1">
								<tr>
									<td>
										<div align="left" id="orgTreeDiv">
											<%
												StringBuffer contents = new StringBuffer();
												contents.append("<div class=\"dtree\">\n");
												contents.append("<script type=\"text/javascript\">\n");
												contents.append("<!--\n");
												contents.append("var orgTree = new dTree('orgTree');\n");// create a
												contents.append("orgTree.config.check=true;\n");// 添加复选框
												contents.append("orgTree.config.isSingle=false ;\n");//可多选择
												// array in
												// javascript
												for (Iterator iter = orgMap.entrySet().iterator(); iter.hasNext();) {
													Map.Entry entry = (Map.Entry) iter.next();
													// Object key = entry.getKey();
													Object val = entry.getValue();
													WbaseOrg info = (WbaseOrg) val;
													contents.append("orgTree.add(");
													contents.append(info.getNodeNo());// 节点ID
													contents.append(",");
													contents.append(info.getSubNodeNo());// 节点父ID
													contents.append(",'");
													contents.append(info.getOrgName());// 节点名称
													contents.append("','");
													contents.append("','");
													contents.append(info.getOrgName());// Title for the node
													contents.append("','");
													contents.append("');\n");
												}
												contents.append("document.write(orgTree);\n");
												contents.append("//-->\n");
												contents.append("</script>\n");
												contents.append("<br>");
												contents.append("</div>\n");
												out.println(contents.toString());
											%>
										</div>
									</td>
								</tr>
							</table>
						</td>

						<td align="left" style="border:1px solid #C0C0C0; padding:1px; "
							width="50%" valign="top">
							<table cellspacing="0" cellpadding="0" align="center"
								width="100%" id="table2">
								<tr>
									<td>
										<select size="9" name="selectedOrg" id="selectedOrg"
											style="width:100%; height:350px;" multiple>
										</select>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td align="right" colspan="3" height="20">
							<p align="center">
								<input type="submit" value="保  存" name="B1" class="button1"
									onclick="save();" />
								<input type="button" value="关  闭" name="B2" class="button1"
									onclick="javascript:window.close();">
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
<% 
if (selList != null && !selList.isEmpty()) {
Iterator selIter = selList.iterator();
while (selIter.hasNext()) {
	WbaseRoleObj roleObj = (WbaseRoleObj) selIter.next();
	out.println("orgTree.showNode(" + roleObj.getObjNo()
	+ ");\n");
	out.println("addRoleOrg(false);\n");
	}
}
%>
</script>
	<wbase:showMessage />
</body>
</html:html>
