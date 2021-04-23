<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/17
  Time: 上午11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp" %>
    <title>登录</title>
</head>
<body>
<div class="container-fluid">
    <!-- 顶部内容 -->
    <%@include file="top.jsp" %>
    <!-- 主体内容 -->
    <div class="container-fluid"
         style="background: url(<%=request.getContextPath()%>/images/loginbg.jpg); width: 96.8%;">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-7"></div>
                <div class="col-md-4"
                     style="background: #fff; padding: 40px 40px; margin: 100px 0rem; border: 7px solid #ccc;">
                    <form action="${pageContext.request.contextPath}/fore/product?method=indexpage&currentPage=1"
                          method="post"
                          id="loginForm" class="form-horizontal" style="margin: 15px 0 0 0;">
                        <div class="form-group">
                            <label for="username" class="col-sm-2 control-label">用户名</label>
                            <div class="col-sm-9">
                                <input type="text" name="username" required="required" id="username"
                                       class="form-control" placeholder="请输入用户名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword2" class="col-sm-2 control-label">确认密码</label>
                            <div class="col-sm-9">
                                <input type="password" name="password" required="required" class="form-control"
                                       id="exampleInputPassword2" placeholder="请输入确认密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <input type="submit" value="登录"
                                       style="background: url('${pageContext.request.contextPath}/images/login.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-md-1"></div>
            </div>
        </div>
    </div>
    <!-- 底部内容 -->
    <%@include file="foot.jsp" %>
</div>
<script>
    $("#loginForm").submit(function (event) {
        $.ajax({
            async: false,
            url: "${pageContext.request.contextPath}/fore/user?method=login",
            data: $(this).serialize(),
            type: "post",
            success: function (result) {
                if (""!=result){
                    window.alert(result);
                    event.preventDefault();
                }
            }
        });
    });
</script>
</body>
</html>
