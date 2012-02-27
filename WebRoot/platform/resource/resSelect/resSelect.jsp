<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="com.wingo.wbase.model.WbaseResource"%>
<%@ page import="com.wingo.wbase.common.SystemCache"%>
<html:html lang="true">
<head>
	<html:base />
	<title>资源选择</title>

	<meta http-equiv="Expires" CONTENT="0">
	<meta http-equiv="Cache-Control" CONTENT="no-cache">
	<meta http-equiv="Pragma" CONTENT="no-cache">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet"
		href="<%=baseURL%>/platform/resource/resSelect/dtree/dtree.css"
		type="text/css">
	<script type="text/javascript"
		src="<%=baseURL%>/platform/resource/resSelect/dtree/dtree.js"></script>
	<script type="text/javascript">


	function saveNode(){
		var revalue = resTree.getCheckBoxIDValue();
		if(revalue.length>0){
			window.returnValue = revalue;
 	  	}else{
 	  		alert("请选择组织!!");
 	  	}
 	  	closeDialog();
	}
	
	//关闭
	function closeDialog(){
		window.close();
	}
	
</script>

</head>
<%
	boolean edit = Boolean.parseBoolean(request.getParameter("edit"));
	String isSingle = request.getParameter("isSingle");
%>
<body>
	<div align="left" id="resTreeDiv">
		<%
			Map map = SystemCache.resCache;
			StringBuffer contents = new StringBuffer();
			contents.append("<div class=\"dtree\">\n");
			contents.append("<script type=\"text/javascript\">\n");
			contents.append("<!--\n");

			contents.append("var resTree = new dTree('resTree');\n");// create a
			if (edit) {
				contents.append("resTree.config.check=true;\n");// 添加复选框
			}
			contents.append("resTree.config.isSingle=" + isSingle + "\n");
			// array in
			// javascript
			for (Iterator iter = map.entrySet().iterator(); iter.hasNext();) {
				Map.Entry entry = (Map.Entry) iter.next();
				//Object key = entry.getKey();
				Object val = entry.getValue();
				WbaseResource info = (WbaseResource) val;
				// resTree.add(1, 0, 'My node', 'node.html', 'node title',
				// 'mainframe', 'img/musicfolder.gif');
				// resTree.add(0,-1,'My example tree');
				// define elements of array
				contents.append("resTree.add(");
				contents.append(info.getNodeNo());// 节点ID
				contents.append(",");
				contents.append(info.getSubNodeNo());// 节点父ID
				contents.append(",'");
				contents.append(info.getResName());// 节点名称
				contents.append("','");
				// Url for the node
				// 节点的链接
				// if("org".equals(this.type)){
				// contents.append(path+"/OrgAction.do?action=editOrg&todo=update&id="+info.getId());
				// }else if("orgUser".equals(this.type)){
				// contents.append(path+"/OrgAction.do?action=editOrg&todo=create");
				// }else{
				// contents.append(path);
				// }

				contents.append("','");
				contents.append(info.getResName());// Title for the node
				contents.append("','");
				// contents.append(this.target);//Target for the node
				contents.append("');\n");
				// contents.append("img/musicfolder.gif");//Image file to use as the
				// icon. Uses default if not specified
				// contents.append("','");
				// contents.append("img/musicfolder.gif");//Image file to use as the
				// open icon. Uses default if not specified
				// contents.append("',");
				// contents.append("false");//Boolean Is the node open
				// contents.append(");\n");
			}
			contents.append("document.write(resTree);\n");
			contents.append("resTree.showNode(window.dialogArguments);\n");
			contents.append("//-->\n");

			contents.append("</script>\n");
			contents.append("<br>");
			contents.append("</div>\n");

			contents.append("<div align=\"center\" >\n");
			contents
					.append("<input type='button' value='确定' class=\"button1\"  onclick='saveNode()'>");
			contents.append("&nbsp;");
			contents
					.append("<input type='button' value='取消' class=\"button1\"  onclick='closeDialog()'>\n");
			contents.append("</div>\n");
			
			out.println(contents.toString());
		%>
	</div>

	<wbase:showMessage />
</body>
</html:html>
