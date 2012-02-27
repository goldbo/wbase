<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<%@ page import="com.wingo.wbase.common.helper.SpringHelper"%>
<%@page import="com.wingo.wbase.service.ReportService"%>
<html:html lang="true">
<head>
	<html:base />

	<title>报表测试</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
function online(){
	document.getElementById("lineFrame").src="ReportAction.do?action=onAmline";
}

function stackedLine(){
	document.getElementById("lineFrame").src="ReportAction.do?action=showStackedLineChart";
}

function clusteredLine(){
	document.getElementById("lineFrame").src="ReportAction.do?action=showClusteredLineChart";
}

function treeLine(){
	document.getElementById("lineFrame").src="ReportAction.do?action=showTreeLineChart";
}
</script>
</head>

<body>
	<div align="center">
		<table width="90%" align="center">
			<tr>
				<td>
<%--					<html:submit value="实时报表" onclick="online()"></html:submit>--%>
				</td>
				<td>
					<html:submit value="累加梳头拆线组合图报表" onclick="stackedLine()"></html:submit>
				</td>
				<td>
					<html:submit value="柱状折线组合图报表" onclick="clusteredLine()"></html:submit>
				</td>
				<td>
					<html:submit value="拆线组合图报表" onclick="treeLine()"></html:submit>
				</td>
			</tr>

		</table>
		<table width="90%" align="center">
			<tr>
				<td>
					<iframe id="lineFrame" frameborder=0 name=InfoList2
						src="<%=baseURL%>/ReportAction.do?action=showAmline" width=100%
						height=500 scrolling="yes"></iframe>
				</td>

			</tr>

		</table>
	</div>
</body>
</html:html>
