<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="5;/JavaEE/file.html">
<title>é¦é¡µ</title>
<script type="text/javascript" src="./js/utils.js"></script>
</head>
<body>
ä½ å¥½<b id="username"></b>ï¼ä½ å·²ç»è¿å¥çæ§é¶æ®µï¼å°å¨5ç§åè¿å¥ç»éé¡µé¢ã<span id="countdown1">5</span>
<script type="text/javascript">
var username_cookie = Utils.getCookie("username");
var split = username_cookie.split("-");
document.getElementById("username").innerHTML=split[0];

//æ¨¡æè®¡æ¶å¨
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