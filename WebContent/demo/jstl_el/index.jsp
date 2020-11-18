<%@ page import="com.lsy.code.demo.dao.ProductDao" %>
<%@ page import="com.lsy.code.demo.domain.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lsy.code.demo.utils.ServletUtils" %><%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/12
  Time: 下午4:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="../jsp/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="myjstl" %>--%>
<!DOCTYPE html>
<html>

<head>
    <%@include file="../jsp/head.jsp" %>
    <title>首页</title>
</head>
<body>
<div class="container-fluid">
    <!-- 顶部内容 -->
    <%@include file="../jsp/top.jsp" %>
    <!-- 主体内容 -->
    <div class="container-fluid">
        <!-- 轮播图 -->
        <div class="container-fluid">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src="${pageContext.request.contextPath}/img/1.jpg" alt="图片无法显示">
                        <div class="carousel-caption">...</div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/img/2.jpg" alt="图片无法显示">
                        <div class="carousel-caption">...</div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/img/3.jpg" alt="图片无法显示">
                        <div class="carousel-caption">...</div>
                    </div>
                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a> <a class="right carousel-control" href="#carousel-example-generic" role="button"
                        data-slide="next"> <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
            </div>
        </div>

        <!-- 热门商品 -->
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <h2>
                        热门商品<img alt="图片无法显示" src="${pageContext.request.contextPath}/img/title2.jpg">
                    </h2>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    <a href="${pageContext.request.contextPath}/demo/jsp/product.jsp?big01"><img alt="图片无法显示"
                                                                                                 src="${pageContext.request.contextPath}/img/products/big01.jpg"
                                                                                                 width="100%"
                                                                                                 height="404"/></a>
                </div>
                <div class="col-md-10">
                    <div class="row">
                        <div class="col-md-6">
                            <a href="${pageContext.request.contextPath}/demo/jsp/product.jsp?middle01"><img alt="图片无法显示"
                                                                                                            src="${pageContext.request.contextPath}/img/products/middle01.jpg"
                                                                                                            width="100%"
                                                                                                            height="200"></a>
                        </div>
                        <%
                            pageContext.setAttribute("list", new ProductDao().findAll());
                        %>
                        <c:forEach items="${list}" var="product">
                            <div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
                                <a href="${pageContext.request.contextPath}/demo/jsp/product.jsp?${product.pid}"><img
                                        alt="图片无法显示"
                                        src="${pageContext.request.contextPath}/img/products/${product.imgurl}"
                                        width="100%" height="130"></a>
                                <p>${product.pname}
                                </p>
                                <p>价格：￥${product.price}
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
                        最新商品<img alt="图片无法显示" src="${pageContext.request.contextPath}/img/title2.jpg">
                    </h2>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    <a href="${pageContext.request.contextPath}/demo/jsp/product.jsp?big01"><img alt="图片无法显示"
                                                                                                 src="${pageContext.request.contextPath}/img/products/big01.jpg"
                                                                                                 width="100%"
                                                                                                 height="404"/></a>
                </div>
                <div class="col-md-10">
                    <div class="row">
                        <div class="col-md-6">
                            <a href="${pageContext.request.contextPath}/demo/jsp/product.jsp?middle01"><img alt="图片无法显示"
                                                                                                            src="${pageContext.request.contextPath}/img/products/middle01.jpg"
                                                                                                            width="100%"
                                                                                                            height="200"></a>
                        </div>
                        <c:forEach items="${list}" var="product">
                            <div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
                                <a href="${pageContext.request.contextPath}/demo/jsp/product.jsp?${product.pid}"><img
                                        alt="图片无法显示"
                                        src="${pageContext.request.contextPath}/img/products/${product.imgurl}"
                                        width="100%" height="130"></a>
                                <p>${product.pname}
                                </p>
                                <p>价格：￥${product.price}
                                </p>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <!-- 历史浏览记录 -->
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <h2>
                        历史浏览记录<a href="${pageContext.request.contextPath}/demo/jsp/clearBrowsingHistory.jsp"
                                 style="font-size: small;">清空浏览记录</a><img alt="图片无法显示"
                                                                          src="${pageContext.request.contextPath}/img/title2.jpg">
                    </h2>
                </div>
            </div>
            <div class="row" id="pidHistory">
                <c:if test="${cookie.pidHistory.value!=''}">
                    <c:forTokens items="${cookie.pidHistory.value}" delims="-" var="pid">
                        <c:set var="spid" value="${pid}"/>
                        <%
                            pageContext.setAttribute("phistory", new ProductDao().findById((String) pageContext.getAttribute("spid")));
                        %>
                        <div class="col-md-1" style="text-align: center; height: 100px;">
                            <a href="${pageContext.request.contextPath}/demo/jsp/product.jsp?${phistory.pid}"><img
                                    alt="图片无法显示"
                                    src="${pageContext.request.contextPath}/img/products/${phistory.imgurl}"
                                    width="100%"
                                    height="130"></a>
                        </div>
                    </c:forTokens>
                </c:if>
            </div>
        </div>
    </div>

    <!-- 底部内容 -->
    <%@include file="../jsp/foot.jsp" %>
</div>

<script type="text/javascript">
    /* 轮播图 */
    $('.carousel').carousel({
        interval: 2000
    })
</script>
</body>

</html>