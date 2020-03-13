<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
<%
String username="";
Cookie[] cookies = request.getCookies();
if(null!=cookies){
	for(int i = 0;i<cookies.length;i++){
		if("username".equals(cookies[i].getName())){
			String[] split = cookies[i].getValue().split("-");
			username=split[0];
			break;
		}
	}
}
%>
<% 
response.setHeader("Refresh", "5;/JavaEE/jsp/demo/file.jsp");
%>
你好<b id="username"><%= username%></b>，你已经进入监控阶段，将在5秒后进入登陆页面。<span id="countdown1">5</span>
<script type="text/javascript">
//模拟计时器
var count=4;
var fn1 = setInterval(function(){
	document.getElementById("countdown1").innerHTML=count;
	count--;
	if(0>=count){
		clearInterval(fn1);
	}
},1000)
</script>
</body>
</html>