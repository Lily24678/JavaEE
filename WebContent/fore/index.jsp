<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/12
  Time: 下午4:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <%@include file="head.jsp" %>
    <title>首页</title>
</head>
<body>
<div class="container-fluid">
    <!-- 顶部内容 -->
    <%@include file="top.jsp" %>
    <!-- 主体内容 -->
    <div class="container-fluid">
        <!-- 轮播图 -->
        <div class="container-fluid">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <c:forEach var="product" items="${beanPage.list}" varStatus="status">
                        <li data-target="#carousel-example-generic" data-slide-to="${status.index}"
                            <c:if test="${status.index==0}">class="active"</c:if>></li>
                    </c:forEach>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <c:forEach var="product" items="${beanPage.list}" varStatus="status">
                        <div class="item <c:if test="${status.index==0}">active</c:if>">
                            <img src="/imgUrl/${product.pimage}" alt="图片无法显示" style="height: 300px;width: 100%;">
                            <div class="carousel-caption">${product.pname}</div>
                        </div>
                    </c:forEach>
                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button"
                   data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>

        <!-- 热门商品 -->
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <h2>
                        热门商品<img alt="图片无法显示" src="${pageContext.request.contextPath}/images/title2.jpg">
                    </h2>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    <a href="${pageContext.request.contextPath}/fore/product?method=productpage&pid=big01"><img
                            alt="图片无法显示"
                            src="${pageContext.request.contextPath}/images/big01.jpg"
                            width="100%"
                            height="404"/></a>
                </div>
                <div class="col-md-10">
                    <div class="row">
                        <div class="col-md-6">
                            <a href="${pageContext.request.contextPath}/fore/product?method=productpage&pid=middle01"><img
                                    alt="图片无法显示"
                                    src="${pageContext.request.contextPath}/images/middle01.jpg"
                                    width="100%"
                                    height="200"></a>
                        </div>
                        <c:forEach var="product" items="${beanPage.list}">
                            <div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
                                <a href="${pageContext.request.contextPath}/fore/product?method=productpage&pid=${product.pid}"><img
                                        alt="图片无法显示"
                                        src="/imgUrl/${product.pimage}"
                                        width="100%" height="140"></a>
                                <p>${product.pname}
                                </p>
                                <p>价格：￥${product.shop_price}
                                </p>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <!-- 最新商品-->
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <h2>
                        最新商品<img alt="图片无法显示" src="${pageContext.request.contextPath}/images/title2.jpg">
                    </h2>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    <a href="${pageContext.request.contextPath}/fore/product?method=productpage&pid=big01"><img
                            alt="图片无法显示"
                            src="${pageContext.request.contextPath}/images/big01.jpg"
                            width="100%"
                            height="404"/></a>
                </div>
                <div class="col-md-10">
                    <div class="row">
                        <div class="col-md-6">
                            <a href="${pageContext.request.contextPath}/fore/product?method=productpage&pid=middle01"><img
                                    alt="图片无法显示"
                                    src="${pageContext.request.contextPath}/images/middle01.jpg"
                                    width="100%"
                                    height="200"></a>
                        </div>
                        <c:forEach var="product" items="${beanPage.list}">
                            <div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
                                <a href="${pageContext.request.contextPath}/fore/product?method=productpage&pid=${product.pid}"><img
                                        alt="图片无法显示"
                                        src="/imgUrl/${product.pimage}"
                                        width="100%" height="140"></a>
                                <p>${product.pname}
                                </p>
                                <p>价格：￥${product.shop_price}
                                </p>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <!-- 页码 -->
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <%@include file="pagenum.jsp" %>
                </div>
            </div>
        </div>
        <!-- 历史浏览记录 -->
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <h2>
                        历史浏览记录<a href="${pageContext.request.contextPath}/fore/product?method=clearhistory"
                                 style="font-size: small;">清空浏览记录</a><img alt="图片无法显示"
                                                                          src="${pageContext.request.contextPath}/images/title2.jpg">
                    </h2>
                </div>
            </div>
            <div class="row">
                <c:forTokens items="${cookie.history.value}" delims="-" var="pid">
                    <div class="col-md-1">
                        <a href="${pageContext.request.contextPath}/fore/product?method=productpage&pid=${pid}">
                            <img style="width: 100%;"
                                 src="${pageContext.request.contextPath}/fore/product?method=findpimage&pid=${pid}">
                        </a>
                    </div>
                </c:forTokens>
            </div>
        </div>
    </div>

    <!-- 底部内容 -->
    <%@include file="foot.jsp" %>
</div>

<script type="text/javascript">
    /* 轮播图 */
    $('.carousel').carousel({
        interval: 2000
    })
</script>
</body>

</html>