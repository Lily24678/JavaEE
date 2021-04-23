<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/17
  Time: 上午11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="head.jsp" %>
    <title>确认订单</title>
</head>
<body>
<div class="container-fluid">
    <!-- 顶部内容 -->
    <%@include file="top.jsp" %>
    <!-- 主体内容 -->
    <div class="container-fluid">
        <div class="container-fluid">
            <h3 style="color: brown">确认订单${order.oid}</h3>
            <hr/>
            <form action="${pageContext.request.contextPath}/demo/jsp/settlement.jsp" method="POST"
                  class="form-horizontal">
                <div class="table-responsive">
                    <table class="table">
                        <thead style="background-color: gainsboro;">
                        <tr>
                            <th>序号</th>
                            <th>订单项编号</th>
                            <th>图片</th>
                            <th>商品名称</th>
                            <th>价格</th>
                            <th>数量</th>
                            <th>小记</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${list}" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>${item.itemid}</td>
                                <td><img src="/imgUrl/${item.product.pimage}" alt="图片无法查看"
                                         style="width: 80px;height: 80px;"></td>
                                <td>${item.product.pname}</td>
                                <td>${item.product.shop_price}</td>
                                <td>${item.subcount}</td>
                                <td>${item.subtotal}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="form-group" style="margin-top: 20px;">
                    <div class="col-sm-12" style="text-align: right">
                        <p>订单的状态:
                            <c:choose>
                                <c:when test="${order.state==0}">未付款</c:when>
                                <c:when test="${order.state==1}">已付款</c:when>
                                <c:when test="${order.state==2}">发货</c:when>
                                <c:when test="${order.state==3}">收货</c:when>
                                <c:otherwise>未知</c:otherwise>
                            </c:choose>
                        </p>
                        <button type="submit" class="btn btn-danger">合计￥${order.total}&nbsp;&nbsp;结算</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!-- 底部内容 -->
    <%@include file="foot.jsp" %>
</div>
</body>
</html>
