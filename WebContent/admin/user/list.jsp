<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/26
  Time: 下午3:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="list_contain">
    <table>
        <caption>用户管理</caption>
        <colgroup>
            <col span="3" style="background-color:cadetblue;">
            <col style="background-color:lightblue">
        </colgroup>
        <thead>
        <tr>
            <th>序号</th>
            <th>用户名</th>
            <th>姓名</th>
            <th>邮箱</th>
            <th>电话</th>
            <th>出生日期</th>
            <th>性别</th>
            <th>激活状态</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${beanPage.list}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${item.username}</td>
                <td>${item.name}</td>
                <td>${item.email}</td>
                <td>${item.telephone}</td>
                <td>${item.birthday}</td>
                <td>${item.sex}</td>
                <td>
                    <c:choose>
                        <c:when test="${item.state==0}"><span style="color:forestgreen">未激活</span></c:when>
                        <c:when test="${item.state==1}"><span style="color: darkred">激活</span></c:when>
                        <c:otherwise><span style="color: grey">未知</span></c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="8">
                <%@include file="../pagenum.jsp" %>
            </td>
        </tr>
        </tfoot>
    </table>
</div>
