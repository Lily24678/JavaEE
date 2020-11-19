<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/19
  Time: 下午3:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session依赖cookie，如果浏览器禁用了cookie的解决办法</title>
</head>
<body>
<h1>session依赖cookie，如果浏览器禁用了cookie的解决办法</h1>
<h2>方法1：url后面追加;jsessonid=session.getId()</h2>
<form action='/JavaEE/disableCookie;jsessonid=<%=session.getId() %>' method="post" target="form_iframe">
    <input type="submit" value="提交（向session域中存储数据）"/>
</form>
<%-- 此iframe作用：防止表单提交后做跳转 --%>
<iframe name="form_iframe" style="display:none;"></iframe>
<form action='/JavaEE/disableCookie;jsessionid=<%=session.getId() %>' method="GET" target="form_iframe2">
    <input type="submit" value="提交（提取session域中的属性值）"/>
</form>
<%-- 此iframe作用：防止表单提交后做跳转 --%>
<iframe  name="form_iframe2"></iframe>


<h2>方法2（推荐）：response.encodeURL(url)</h2>
<form action='<%=response.encodeURL("/JavaEE/disableCookie")%>' method="post" target="form_iframe4">
    <input type="submit" value="提交（向session域中存储数据）"/>
</form>
<%-- 此iframe作用：防止表单提交后做跳转 --%>
<iframe name="form_iframe4" style="display:none;"></iframe>
<form action='<%=response.encodeURL("/JavaEE/disableCookie")%>' method="GET" target="form_iframe3">
    <input type="submit" value="提交（提取session域中的属性值）"/>
</form>
<%-- 此iframe作用：防止表单提交后做跳转 --%>
<iframe  name="form_iframe3"></iframe>
</body>
</html>
