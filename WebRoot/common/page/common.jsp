<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/wbase.tld" prefix="wbase"%>

<%--WEBROOT基本路径 －－ JSP页面及JS脚本引用--%>
<%
String baseURL = request.getContextPath();
%>
<script language="javascript" type="text/javascript">
  var baseURL='<%=baseURL%>';       
 </script>

<%--引用通用 JS--%>
<script type="text/javascript" src="<%=baseURL%>/common/js/validator.js"></script>
<script type="text/javascript" src="<%=baseURL%>/common/js/public.js"></script>
<script type="text/javascript" src="<%=baseURL%>/common/js/collection.js"></script>
<script type="text/javascript" src="<%=baseURL%>/common/js/drag.js"></script>

<%--引用通用 CSS--%>
<link href="<%=baseURL%>/common/css/style_main.css" rel="stylesheet"
	type="text/css">
