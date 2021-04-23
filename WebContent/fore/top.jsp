<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/12
  Time: 下午5:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid">
    <!-- 菜单栏 -->
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-4">
                <%--<img alt="图片无法显示" src="${pageContext.request.contextPath}/images/logo2.png">--%>
            </div>
            <div class="col-md-5">
                <%--<img alt="图片无法显示" src="${pageContext.request.contextPath}/images/header.png">--%>
            </div>
            <div class="col-md-3" style="padding-top: 20px">
                <ol id="menuList" class="list-inline">
                    <c:if test="${user!=null}">
                        <li><img src="/imgUrl/${user.headimg}" alt="..." class="img-circle"
                                 style="width: 20px">${user.username},欢迎登陆
                        </li>
                    </c:if>
                    <li><a href="${pageContext.request.contextPath}/fore/user?method=registpage">注册</a></li>
                    <li><a href="${pageContext.request.contextPath}/fore/user?method=loginpage">登录</a></li>
                    <li><a href="${pageContext.request.contextPath}/fore/cart?method=cartpage">购物车</a></li>
                    <li>
                        <a href="${pageContext.request.contextPath}/fore/order?method=orderlistpage&currentPage=1">我的订单</a>
                    </li>
                </ol>
            </div>
        </div>
    </div>
    <!-- 导航条  -->
    <div class="container-fluid">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand"
                       href="${pageContext.request.contextPath}/fore/product?method=indexpage&currentPage=1">首页</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->s
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="float: left">
                    <ul class="nav navbar-nav" id="menus">
                    </ul>
                    <form class="navbar-form navbar-right" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div> <!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
    </div>
</div>
<script>
    $(function(){
        $.get("${pageContext.request.contextPath}/fore/product?method=findCategory",function (result) {
            $(result).each(function(index,item){
                $("#menus").append('<li><a href="${pageContext.request.contextPath}/fore/product?method=indexpage&currentPage=1&cid='+item.cid+'">'+item.cname+'</a></li>');
            });
        },'json');
    });
</script>
