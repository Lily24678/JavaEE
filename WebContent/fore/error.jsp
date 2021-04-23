<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/17
  Time: 下午3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>错误提示</title>
</head>
<body>
<h1 style="color: red;">你访问资源的不存在!!!请联系管理员！！！</h1>
<%=exception.getMessage()%>
</body>
</html>
