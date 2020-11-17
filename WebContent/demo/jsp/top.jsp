<%@ page import="com.lsy.code.demo.utils.ServletUtils" %>
<%@ page import="com.lsy.code.demo.utils.StringUtils" %><%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/12
  Time: 下午5:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid">
    <!-- 菜单栏 -->
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-4">
                <img alt="图片无法显示" src="<%=request.getContextPath()%>/img/logo2.png">
            </div>
            <div class="col-md-5">
                <img alt="图片无法显示" src="<%=request.getContextPath()%>/img/header.png">
            </div>
            <div class="col-md-3" style="padding-top: 20px">
                <ol id="menuList" class="list-inline">
                    <li><a href="<%=request.getContextPath()%>/demo/jsp/regist.jsp">注册</a></li>
                    <li><a href="<%=request.getContextPath()%>/demo//login.jsp">登录</a></li>
                    <li><a href="<%=request.getContextPath()%>/demo/jsp/shoppingCart.jsp">购物车</a></li>
                    <li><a href="#">我的订单</a></li>
                    <%
                        Cookie username = ServletUtils.getCookie("username", request);
                        if (null != username && StringUtils.isNotBlank(username.getValue())) {
                            Cookie showLastVisit = ServletUtils.getCookie("showLastVisit", request);
                            if (null != showLastVisit && StringUtils.isNotBlank(showLastVisit.getValue())) {
                    %>
                    <li><a href="javascript:void(0);"
                           style="color: green;">您是第<%=ServletUtils.getCookie("count", request).getValue()%>
                        位访问的用户.上次访问的时间是<%=ServletUtils.getCookie("showLastVisit", request).getValue()%>
                    </a></li>
                    <%} else {%>
                    <li><a href="javascript:void(0);"
                           style="color: green;">您是第<%=ServletUtils.getCookie("count", request).getValue()%>
                        位访问的用户.上次访问的时间是<%=ServletUtils.getCookie("showLastVisit", request).getValue()%>
                    </a></li>
                    <%
                            }
                        }
                    %>
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
                        <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span
                            class="icon-bar"></span> <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="<%=request.getContextPath()%>">首页</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">手机数码<span class="sr-only">(current)</span></a></li>
                        <li><a href="#">电脑办公</a></li>
                        <li><a href="#">电脑办公</a></li>
                        <li><a href="#">电脑办公</a></li>
                    </ul>
                    <form class="navbar-form navbar-right" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->
        </nav>
    </div>
</div>
