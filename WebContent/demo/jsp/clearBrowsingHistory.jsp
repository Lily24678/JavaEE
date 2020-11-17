<%@ page import="com.lsy.code.demo.utils.ServletUtils" %><%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/17
  Time: 上午10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--清空商品浏览记录--%>
<%
    ServletUtils.removeCookie(ServletUtils.getCookie("pidHistory",request),request,response);
    response.sendRedirect(request.getContextPath());
%>
