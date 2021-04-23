<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/17
  Time: 上午9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品详情</title>
    <%@include file="head.jsp" %>
</head>
<body>

<div class="container-fluid">
    <!-- 顶部内容 -->
    <%@include file="top.jsp" %>
    <!-- 主体内容 -->
    <iframe name="form_iframe" style="display: none;"></iframe>
    <div class="container-fluid">
        <div class="container-fluid">
            <h3 style="color: brown">商品详情</h3>
            <hr/>
            <form action="${pageContext.request.contextPath}/fore/cart?method=add" method="POST" target="form_iframe"
                  class="form-horizontal">
                <div class="col-md-2">
                    <div><img src="/imgUrl/${product.pimage}" alt="图片无法查看" style="width: 100%;"/></div>
                </div>
                <div class="col-md-10">
                    <div class="form-group">
                        <label class="col-sm-1 control-label">商品名称</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${product.pname}
                            </p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pprice" class="col-sm-1 control-label">商品价格</label>
                        <div class="col-sm-2">
                            <input type="text" readonly="readonly" value="${product.shop_price}"
                                   class="form-control" id="pprice" placeholder="商品价格">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="quantity" class="col-sm-1 control-label">商品数量</label>
                        <div class="col-sm-2">
                            <input type="number" value="1" min="1" name="quantity"
                                   class="form-control" id="quantity"
                                   placeholder="商品数量">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label"></label>
                        <div class="col-sm-2">
                            <input type="hidden" name="pid" value="${product.pid}"/>
                            <button type="submit" class="btn btn-danger">加入购物车</button>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-1 col-sm-10" style="margin-top: 20px;">
                        ${product.pdesc}
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
