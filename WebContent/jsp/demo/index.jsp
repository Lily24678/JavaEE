<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="5;/JavaEE/file.html">
<title>首页</title>
<script type="text/javascript" src="./js/utils.js"></script>
</head>
<body>
你好<b id="username"></b>，你已经进入监控阶段，将在5秒后进入登陆页面。<span id="countdown1">5</span>
<script type="text/javascript">
var username_cookie = Utils.getCookie("username");
var split = username_cookie.split("-");
document.getElementById("username").innerHTML=split[0];

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