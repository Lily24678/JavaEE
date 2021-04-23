<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/17
  Time: 上午11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <%@include file="head.jsp" %>
    <title>购物车</title>
</head>
<body>
<div class="container-fluid">
    <!-- 顶部内容 -->
    <%@include file="top.jsp" %>
    <!-- 主体内容 -->
    <div class="container-fluid">
        <div class="container-fluid">
            <h3 style="color: #a52a2a">购物车</h3>
            <hr/>
            <c:if test="${fn:length(cart.cartItems)==0}">
                <h1>购物车空空的哦~，去看看心仪的商品吧~ </h1>
            </c:if>
            <form action="${pageContext.request.contextPath}/fore/order?method=add" method="POST"
                  class="form-horizontal">
                <div class="table-responsive">
                    <table class="table">
                        <thead style="background-color: gainsboro;">
                        <tr>
                            <th>序号</th>
                            <th>图片</th>
                            <th>商品名称</th>
                            <th>价格</th>
                            <th>数量</th>
                            <th>小记</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${cart.cartItems}" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td><img src="/imgUrl/${item.value.product.pimage}" alt="图片无法查看"
                                         style="width: 80px;height: 80px;"></td>
                                <td>${item.value.product.pname}</td>
                                <td>${item.value.product.shop_price}</td>
                                <td><input type="number" value="${item.value.count}" min="1" name="quantity"
                                           placeholder="商品数量"></td>
                                <td>${item.value.subPrice}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                        <tfoot>
                        <tr>
                            <td colspan="6">
                                <div class="form-group">
                                    <label for="inoutname" class="col-sm-2 control-label">收货人姓名</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="name" required="required" class="form-control" id="inoutname" placeholder="收货人姓名">
                                    </div>
                                </div>
                               <div class="form-group">
                                    <label for="inputtelephone" class="col-sm-2 control-label">收货人电话</label>
                                    <div class="col-sm-10">
                                        <input type="tel" name="telephone" required="required" class="form-control" id="inputtelephone" placeholder="收货人电话">
                                    </div>
                                </div>
                               <div class="form-group">
                                    <label for="inputaddress" class="col-sm-2 control-label">收货人地址</label>
                                    <div class="col-sm-10">
                                        <textarea name="address" required="required" class="form-control" id="inputaddress" placeholder="收货人地址"></textarea>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        </tfoot>
                    </table>
                </div>
                <div class="form-group" style="margin-top: 20px;">
                    <div class="col-sm-12" style="text-align: right">
                        <a href="${pageContext.request.contextPath}/fore/cart?method=clear">清空购物车</a>
                        <button type="submit" class="btn btn-danger">合计￥${cart.tolalPrice}&nbsp;&nbsp;提交订单</button>
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
