<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="com.wingo.wbase.model.WbaseResource"%>
<%@ page import="com.wingo.wbase.model.WbaseSysShortcut"%>
<%@ page import="com.wingo.wbase.common.SystemCache"%>
<%@ page import="com.wingo.wbase.model.ViewUserInfo"%>
<%@ page import="com.wingo.wbase.common.Constants"%>
<%@ page import="com.wingo.wbase.common.helper.PowerHelper"%>
<%
			ViewUserInfo user = (ViewUserInfo) session
			.getAttribute(Constants.LOGIN_USER);//登录用户信息
	Map cutMap = SystemCache.cutCache;//快捷菜单MAP
	Map resMap = SystemCache.resCache;//系统资源MAP
	Map selMap = Collections.synchronizedMap(new LinkedHashMap());//已选择快捷菜单MAP
	Map powerMap = (Map) session.getAttribute(Constants.ROLE_POWER);//用户权限MAP
	for (Iterator iter = cutMap.entrySet().iterator(); iter.hasNext();) {
		Map.Entry entry = (Map.Entry) iter.next();
		Object key = entry.getKey();
		Object val = entry.getValue();
		WbaseSysShortcut cut = (WbaseSysShortcut) val;
		WbaseResource info = (WbaseResource) resMap.get(cut
		.getCutNodeNo());
		Object resNoObj = powerMap.get(info.getResNo());
		if (resNoObj != null) {
			Integer powerLevel = Integer.parseInt(resNoObj.toString());
			if (PowerHelper.checkPower(powerLevel, 5)) {
				if (user.getAccount().equals(cut.getCutUid())) {
					selMap.put(key, val);
				}
			}
		}
	}
%>
<html:html lang="true">
<head>
	<html:base target="_self" />
	<title>快捷菜单设置</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript"
		src="<%=baseURL%>/dwr/interface/wbaseSysShortcutService.js"></script>
	<script type="text/javascript" src="<%=baseURL%>/dwr/util.js"></script>
	<script type="text/javascript" src="<%=baseURL%>/dwr/engine.js"></script>
	<script type="text/javascript"
		src="<%=baseURL%>/platform/system/shortcut/dtree/dtree.js"></script>
	<link rel="stylesheet"
		href="<%=baseURL%>/platform/system/shortcut/dtree/dtree.css"
		type="text/css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
//移除快捷菜单
function removeShortcut(isAll)
{

	var box = document.getElementById("selectedCut");
	
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



//加入快捷菜单
function addShortcut(isAll)
{

	var list = resTree.getCheckTreeIDValue();
	if (list.length==0)
	{
		alert("请选择菜单!");
		return;
	}else{
		doAddselectedCut(list);
	}
}

//添加到已选择快捷菜单
function doAddselectedCut(list)
{
	var box = document.getElementById("selectedCut");
	
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

function upMove() {
	var slctIndex = document.getElementById("selectedCut").selectedIndex;
	if (slctIndex == -1 || slctIndex == 0) return false;
	var itemValue = document.getElementById("selectedCut").item(slctIndex - 1).value;
	var itemText = document.getElementById("selectedCut").item(slctIndex - 1).text;
	document.getElementById("selectedCut").item(slctIndex - 1).text = document.getElementById("selectedCut").item(slctIndex).text;
	document.getElementById("selectedCut").item(slctIndex - 1).value = document.getElementById("selectedCut").item(slctIndex).value;
	document.getElementById("selectedCut").item(slctIndex).text = itemText;
	document.getElementById("selectedCut").item(slctIndex).value = itemValue;
	document.getElementById("selectedCut").selectedIndex = slctIndex - 1;
	return true;
}

//将选中的项目向下移一个项目
function downMove() {
	var slctIndex = document.getElementById("selectedCut").selectedIndex;
	var maxIndex = document.getElementById("selectedCut").length - 1;
	if (slctIndex == -1 || slctIndex == maxIndex) return false;
	var itemValue = document.getElementById("selectedCut").item(slctIndex + 1).value;
	var itemText = document.getElementById("selectedCut").item(slctIndex + 1).text;
	document.getElementById("selectedCut").item(slctIndex + 1).text = document.getElementById("selectedCut").item(slctIndex).text;
	document.getElementById("selectedCut").item(slctIndex + 1).value = document.getElementById("selectedCut").item(slctIndex).value;
	document.getElementById("selectedCut").item(slctIndex).text = itemText;
	document.getElementById("selectedCut").item(slctIndex).value = itemValue;
	document.getElementById("selectedCut").selectedIndex = slctIndex + 1;
	return true;
}


//保存快捷菜单
function save(){
var cbox = document.getElementById("selectedCut");
var userId = "<%=user.getAccount()%>";
var selCuts = [];
if(cbox.length>0){
	for (var i=0;i<cbox.length;i++)
		{
			var val=cbox.options[i].value+","+cbox.options[i].index;
			selCuts[i] = val;
		}
	}else{
		alert("您未选择任何快捷菜单,将使用系统默认快捷菜单!");
	}
	wbaseSysShortcutService.updateSysShortcutByNodes(selCuts,userId,function(bool){alert(bool==true?"设置成功!":"设置失败!");});
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
							系统菜单
						</td>
						<td style="border: 1px solid #C0C0C0; padding: 1px;padding:5px"
							width="4%" rowspan="2">
							<input type="button" value="添加 >" name="add" class="button1"
								title="添加快捷菜单" onclick="addShortcut(true);">
							<br>
							<br>
							<input type="button" value="&lt; 移除" name="rem" class="button1"
								title="移除选中的已选快捷菜单" onclick="removeShortcut(true);">
							<br>
							<br>
							<input type="button" value="移除全部" name="remall" class="button1"
								title="移除所有已选快捷菜单" onclick="removeShortcut(false);">
							<br>
						</td>
						<td class="table_thead">
							快捷菜单
						</td>
					</tr>
					<tr>

						<td style="border: 1px solid #C0C0C0; padding: 1px" valign="top">
							<table cellspacing="0" cellpadding="0" align="center"
								width="100%" id="table1">
								<tr>
									<td>
										<div align="left" id="resTreeDiv">
											<%
												StringBuffer contents = new StringBuffer();
												contents.append("<div class=\"dtree\">\n");
												contents.append("<script type=\"text/javascript\">\n");
												contents.append("<!--\n");
												contents.append("var resTree = new dTree('resTree');\n");// create a
												contents.append("resTree.config.check=true;\n");// 添加复选框
												contents.append("resTree.config.isSingle=false ;\n");//可多选择
												// array in
												// javascript
												for (Iterator iter = resMap.entrySet().iterator(); iter.hasNext();) {
													Map.Entry entry = (Map.Entry) iter.next();
													// Object key = entry.getKey();
													Object val = entry.getValue();
													WbaseResource info = (WbaseResource) val;
													if (info.getNodeNo() == 0) {
														contents.append("resTree.add(");
														contents.append(info.getNodeNo());// 节点ID
														contents.append(",");
														contents.append(info.getSubNodeNo());// 节点父ID
														contents.append(",'");
														contents.append(info.getResName());// 节点名称
														contents.append("','");
														contents.append("','");
														contents.append(info.getResName());// Title for the node
														contents.append("','");
														contents.append("');\n");
													} else {
														// 检查权限
														Object resNoObj = powerMap.get(info.getResNo());
														if (resNoObj != null) {
													Integer powerLevel = Integer.parseInt(resNoObj
															.toString());
													if (PowerHelper.checkPower(powerLevel, 5)) {
														contents.append("resTree.add(");
														contents.append(info.getNodeNo());// 节点ID
														contents.append(",");
														contents.append(info.getSubNodeNo());// 节点父ID
														contents.append(",'");
														contents.append(info.getResName());// 节点名称
														contents.append("','");
														contents.append("','");
														contents.append(info.getResName());// Title for the node
														contents.append("','");
														contents.append("');\n");
													}
														}
													}
												}
												contents.append("document.write(resTree);\n");
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
										<select size="9" name="selectedCut" id="selectedCut"
											style="width:100%; height:330px" multiple>
										</select>
									</td>
								</tr>
								<tr>
									<td>
										<input type="button" name="upmove" value="上移"
											onclick="upMove();" class="button1">
										<input type="button" name="downmove" value="下移"
											onclick="downMove();" class="button1">
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
								<input type="button" value="返  回" name="B2" class="button1"
									onclick="javascript:window.close();">
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
<% 
for (Iterator iter = selMap.entrySet().iterator(); iter.hasNext();) {
	Map.Entry entry = (Map.Entry) iter.next();
	Object val = entry.getValue();
	WbaseSysShortcut cut = (WbaseSysShortcut) val;
	out.println("resTree.showNode(" + cut.getCutNodeNo()
	+ ");\n");
	out.println("addShortcut(true);\n");
}
	
%>
</script>

	<wbase:showMessage />
</body>
</html:html>
