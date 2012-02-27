var differentMillisec = 0;
//取得显示时间
function showTime(){
	now = new Date();
	now.setTime(differentMillisec + now.getTime());
	var year = now.getYear();
	if(year < 1900) year += 1900;
	var str = year + "年";
	var temp = now.getMonth() + 1;
	if (temp < 10) str += "0";
	str += temp +  "月";
	temp = now.getDate();
	if (temp < 10) str += "0";
	str += temp +  "日";
	var today = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
	str += " " + today[now.getDay()] + " ";
	temp = now.getHours();
	if (temp < 10) str += "0";
	str += temp +  ":";
	temp = now.getMinutes();
	if (temp < 10) str += "0";
	str += temp +  ":";
	temp = now.getSeconds();
	if (temp < 10) str += "0";
	str += temp;
	document.getElementById("Head1Right_Time").innerHTML = str;
	setTimeout("showTime()", 1000);
}