<%@ page import="java.util.Map" %>
<%@ page import="com.lsy.code.demo.dao.ProductDao" %>
<%@ page import="com.lsy.code.demo.domain.Product" %><%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/17
  Time: 上午11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <form action="<%=request.getContextPath()%>/demo/jsp/settlement.jsp" method="POST" id="account_form" class="form-horizontal">
                <%
                    float totalPrice = 0;
                    Map<String, Integer> map_cart = (Map<String, Integer>) session.getAttribute("shoppingCart");
                    if (null != map_cart && 0 < map_cart.size()) {
                        for (Map.Entry<String, Integer> entry : map_cart.entrySet()) {
                            Product product = new ProductDao().findById(entry.getKey());
                            totalPrice+=product.getPrice()*entry.getValue();
                %>
                <div class="col-md-2">
                    <div><img src="<%=request.getContextPath()%>/img/products/<%=product.getImgurl()%>" alt="图片无法查看">
                    </div>
                </div>
                <div class="col-md-10">
                    <div class="form-group">
                        <label class="col-sm-1 control-label">商品名称</label>
                        <div class="col-sm-10">
                            <p class="form-control-static"><%=product.getPname()%>
                            </p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pcount" class="col-sm-1 control-label">商品数量</label>
                        <div class="col-sm-2">
                            <input type="number" value="<%=entry.getValue()%>" min="1" name="pcount"
                                   class="form-control" id="pcount"
                                   placeholder="商品数量">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pprice" class="col-sm-1 control-label">商品价格</label>
                        <div class="col-sm-2">
                            <input type="text" name="pprice" readonly="readonly" value="<%=product.getPrice()*entry.getValue()%>"
                                   class="form-control"
                                   id="pprice" placeholder="商品价格">
                            <input type="hidden" name="pid" value="<%=product.getPid()%>"/>
                        </div>
                    </div>
                </div>
                <%
                        }
                    }
                %>
                <%
                    if (null != map_cart && 0 < map_cart.size()) {
                %>
                <div class="form-group">
                    <div class="col-sm-offset-1 col-sm-10">
                        <button type="submit" form="account_form" class="btn btn-danger">￥<%=totalPrice%>&nbsp;&nbsp;结算</button>
                    </div>
                </div>
                <%}%>
            </form>
        </div>
    </div>
    <!-- 底部内容 -->
    <%@include file="foot.jsp" %>
</div>
</body>
</html>
