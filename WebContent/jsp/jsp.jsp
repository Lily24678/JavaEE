<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 该部分注释在网页中不会被显示--%> 
<%
out.println("Your IP address is " + request.getRemoteAddr());
%>
<br/>
<%! int day = 3; %> 
<br/>
<%= day%> 

  今天的日期是: <%= (new java.util.Date()).toLocaleString()%>
  
  <%@ include file="../file.html" %>
</body>
</html>