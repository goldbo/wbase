<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>

<html:html lang="true">
<head>
	<html:base />

	<title>组织架构树测试</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="<%=baseURL%>/platform/org/dtree/dtree.css"
		type="text/css">
	<script type="text/javascript"
		src="<%=baseURL%>/dwr/interface/wbaseOrgService.js"></script>
	<script type="text/javascript" src="<%=baseURL%>/dwr/util.js"></script>
	<script type="text/javascript" src="<%=baseURL%>/dwr/engine.js"></script>
	<script type="text/javascript"
		src="<%=baseURL%>/platform/org/dtree/dtree.js"></script>
	<script type="text/javascript">
	//创建组织
function createOrg(url, width, height){
<%--	window.location.href=url;--%>
	var subNodeNo = orgTree.getSelected();
	subNodeNo = (subNodeNo==null)?0:subNodeNo;
	window.showModalDialog("<%=baseURL%>"+url+"&subNodeNo="+subNodeNo, "", "dialogWidth="+width+"px;dialogHeight="+height+"px;status:no;");
	window.location.reload(true);
}
//删除组织
function deleteOrg(){
	var orgNodeNos = orgTree.getCheckBoxValue();
	if(orgNodeNos.length>0){
	 if (!confirm("确定要删除已选择组织？")){
	 	     return false;
	 	  }else{
			//DWR METHOD
	 	  	wbaseOrgService.deleteOrg(orgNodeNos,function(bool){alert(bool);orgTree.clearCookie();parent.window.location.reload(true);});
	 	  	
	 	  	return true;
	 	  }
 	  }else{
 	  	alert("请选择您要删除的组织！");
 	  }
}

//修改组织
function updateOrg(url, width, height){
	var nodeNo = orgTree.getSelected();
	if(nodeNo!=null){
		window.showModalDialog("<%=baseURL%>"+url+"&nodeNo="+nodeNo, "", "dialogWidth="+width+"px;dialogHeight="+height+"px;status:no;");
		window.location.reload(true);
		
 	  }else{
 	  	alert("请选择一个您要修改的组织！");
 	  }
}

</script>

</head>

<body>

	<div align="left" id="dcDIV">
		<wbase:powerButton
			onclick="createOrg('/OrgAction.do?action=editOrg&todo=create', 500, 400);"
			resNo="orgManagement" type="1" value="新增组织" />
		<wbase:powerButton
			onclick="updateOrg('/OrgAction.do?action=editOrg&todo=update', 500, 400);"
			resNo="orgManagement" type="3" value="修改组织" />
		<wbase:powerButton
			onclick="deleteOrg();"
			resNo="orgManagement" type="2" value="删除组织" />
	</div>
	<div align="left" id="orgTreeDiv">
		<br />
		<p>
			<a href="javascript: orgTree.openAll();">展开</a> |
			<a href="javascript: orgTree.closeAll();">收起</a>
		</p>
		<wbase:orgTree edit="true" target="rightDesk" type="org" />
		<br />
	</div>

	<wbase:showMessage />
</body>
</html:html>
