<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/page/common.jsp"%>
<html:html lang="true">
<head>
	<html:base target="_self" />
	<title>企业基本信息设置</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
function saveForm(todo){
	if(checkForm()){
		wbaseSysCompanyForm.submit();
		}else{
			return false;
		}
}

function checkForm(){
	if(!isChinaOrNumbOrLett(document.getElementById("comName").value)){
		alert("企业名称需要由数字或字母组成！");
		return false;
	}else if(document.getElementById("comRemark").value.length>512){
		alert("企业简介输入的字符过多！");
		return false;
	}else{
		return true;
	}
}

</script>
</head>

<body>
	<DIV ID=MainArea>
		<html:form action="/SysCompanyAction.do?action=updateSysCompany"
			styleId="wbaseSysCompanyForm" method="post">
			<CENTER>
				<DIV CLASS=ItemBlock_Title1>
					<img border="0" src="<%=baseURL%>/common/images/title_arrow.gif" />
					企业基本信息设置
				</DIV>
				<DIV CLASS=ItemBlockBorder>
					<DIV CLASS=ItemBlock>
						<TABLE align="center" BORDER=0 CELLSPACING=0 CELLSPACING=0>
							
							<TR>
								<TD colspan="4" align="center">
								<div id="Logo">
								<img border="0" width="291" height="41" id="logoimage" alt="企业LOGO"
										src="<%=baseURL %>${wbaseSysCompanyForm.comLogo }" onload="javascript:DrawImage(this,291,41);"/>
								</div>
								</TD>
							</TR>
							<TR HEIGHT=20>
								<TD COLSPAN=5>
								</TD>
							</TR>
							<TR>
								<TD></TD>
								<TD WIDTH=80>
									企业名称
								</TD>
								<TD >
									<html:text property="comName" name="wbaseSysCompanyForm" maxlength="16" style="width: 291px" ></html:text>
								</TD>
							</TR>
							<TR>
								<TD>
								</TD>
								<TD>
									企业LOGO
								</TD>
								<TD>
									<wbase:uploadImage propertyId="comLogo" propertyName="comLogo"
										propertyValue="${wbaseSysCompanyForm.comLogo }" />LOGO图片(推荐大小291px*41px)
								</TD>
							</TR>
							<TR>
								<TD></TD>
								<TD>
									企业简介
								</TD>
								<TD>
									<html:textarea property="comRemark" name="wbaseSysCompanyForm"
										cols="40" rows="8"></html:textarea>
								</TD>
							</TR>
							<TR HEIGHT=20>
								<TD COLSPAN=5>
								</TD>
							</TR>
							<TR HEIGHT=25>
								<TD COLSPAN=5 align="center">
									<html:hidden property="id" name="wbaseSysCompanyForm" />
									<input type="button" value="保存" class="button1"
										onclick="saveForm('');">
									<input type="button" value="返回" class="button1"
										onclick="window.close();">
								</TD>
							</TR>

						</TABLE>
					</DIV>
				</DIV>
			</CENTER>
		</html:form>
	</DIV>

	<wbase:showMessage />
</body>
</html:html>
