<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>

<html:html lang="true">
<head>
	<html:base />

	<title>资源树</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="<%=baseURL%>/platform/resource/dtree/dtree.css" type="text/css">
	<script type="text/javascript"
		src="<%=baseURL%>/dwr/interface/wbaseResourceService.js"></script>
	<script type="text/javascript" src="<%=baseURL%>/dwr/util.js"></script>
	<script type="text/javascript" src="<%=baseURL%>/dwr/engine.js"></script>
	<script type="text/javascript" src="<%=baseURL%>/platform/resource/dtree/dtree.js"></script>
	<script type="text/javascript">
	//创建资源
function createResource(url, width, height){
<%--	window.location.href=url;--%>
	var subNodeNo = resourceTree.getSelected();
	subNodeNo = (subNodeNo==null)?0:subNodeNo;
	window.showModalDialog("<%=baseURL%>"+url+"&subNodeNo="+subNodeNo, "", "dialogWidth="+width+"px;dialogHeight="+height+"px;status:no;");
	window.location.reload(true);
}
//删除资源
function deleteResource(){
	var ResourceIds = resourceTree.getCheckBoxValue();
	if(ResourceIds.length>0){
	 if (!confirm("确定要删除已选择资源？")){
	 	     return false;
	 	  }else{
			//DWR METHOD
	 	  	wbaseResourceService.deleteResource(ResourceIds,function(bool){alert(bool);resourceTree.clearCookie();window.location.reload(true);});
	 	  	
	 	  	return true;
	 	  }
 	  }else{
 	  	alert("请选择您要删除的资源！");
 	  }
}

</script>

</head>

<body>

	<div align="left" id="dcDIV">
		<wbase:powerButton onclick="createResource('/ResourceAction.do?action=editResource&todo=create', 500, 450);" resNo="resManagement"
							type="1" value="新增资源" />
		<wbase:powerButton onclick="deleteResource();" resNo="resManagement"
							type="2" value="删除资源" />
	</div>
	<div align="left" id="resourceTreeDiv">
		<br />
		<p>
			<a href="javascript: resourceTree.openAll();">展开</a> |
			<a href="javascript: resourceTree.closeAll();">收起</a>
		</p>
		<wbase:resourceTree edit="true" target="rightDesk" type="system" />
		<br />
	</div>

	<wbase:showMessage />
</body>
</html:html>
