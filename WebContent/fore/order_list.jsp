<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/12/14
  Time: 下午3:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="head.jsp" %>
    <title>我的订单</title>
</head>
<body>
<div class="container-fluid">
    <!-- 顶部内容 -->
    <%@include file="top.jsp" %>
    <!-- 主体内容 -->
    <div class="container-fluid">
        <div class="container-fluid">
            <h3 style="color: brown">订单列表</h3>
            <hr/>
            <div class="table-responsive">
                <table class="table">
                    <thead style="background-color: gainsboro;">
                    <tr>
                        <th>序号</th>
                        <th>订单编号</th>
                        <th>订单产生的时间</th>
                        <th>订单的状态</th>
                        <th>总计</th>
                        <th>收货人</th>
                        <th>收货人电话</th>
                        <th>收货地址</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${beanPage.list}" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <td>${item.oid}</td>
                            <td>${item.ordertime}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${item.state==0}">未付款</c:when>
                                    <c:when test="${item.state==1}">已付款</c:when>
                                    <c:when test="${item.state==2}">发货</c:when>
                                    <c:when test="${item.state==3}">收货</c:when>
                                    <c:otherwise>未知</c:otherwise>
                                </c:choose>
                            </td>
                            <td>${item.total}</td>
                            <td>${item.name}</td>
                            <td>${item.telephone}</td>
                            <td>${item.address}</td>
                            <td><a href="${pageContext.request.contextPath}/fore/order?method=ordeinforpage&oid=${item.oid}">查看订单详情</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <tfoot>
                    <tr>
                        <td colspan="9">
                            <%@include file="pagenum.jsp" %>
                        </td>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>
    <!-- 底部内容 -->
    <%@include file="foot.jsp" %>
</div>
</body>
</html>
