<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base />
	<title>能率管理月表</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">

</script>
</head>

<body>
<!-- saved from url=(0013)about:internet -->
<!-- amline script-->
  <script type="text/javascript" src="swfobject.js"></script>
	<div id="flashcontent">
		<strong>You need to upgrade your Flash Player</strong>
	</div>

	<script type="text/javascript">
		// <![CDATA[		
		var so = new SWFObject("amline.swf", "amline", "90%", "60%", "8", "#FFFFFF");
		so.addVariable("path", "");
		so.addVariable("settings_file", encodeURIComponent("amline_settings.xml"));                // you can set two or more different settings files here (separated by commas)
		so.addVariable("data_file", encodeURIComponent("amline_data.xml"));
		
//	so.addVariable("chart_data", encodeURIComponent("data in CSV or XML format"));                    // you can pass chart data as a string directly from this file
//	so.addVariable("chart_settings", encodeURIComponent("<settings>...</settings>"));                 // you can pass chart settings as a string directly from this file
//	so.addVariable("additional_chart_settings", encodeURIComponent("<settings>...</settings>"));      // you can append some chart settings to the loaded ones
//  so.addVariable("loading_settings", "LOADING SETTINGS");                                           // you can set custom "loading settings" text here
//  so.addVariable("loading_data", "LOADING DATA");                                                   // you can set custom "loading data" text here
//	so.addVariable("preloader_color", "#999999");
//  so.addVariable("error_loading_file", "ERROR LOADING FILE");                                   // you can set custom "error loading file" text here
		so.write("flashcontent");
		// ]]>
	</script>
<!-- end of amline script -->


<wbase:showMessage/>
</body>
</html:html>
