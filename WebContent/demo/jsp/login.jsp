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
    <%@include file="head.jsp"%>
    <title>登录</title>
</head>
<body>
<div class="container-fluid">
    <!-- 顶部内容 -->
    <%@include file="top.jsp"%>
    <!-- 主体内容 -->
    <div class="container-fluid" style="background: url(<%=request.getContextPath()%>/img/loginbg.jpg); width: 96.8;">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-7"></div>
                <div class="col-md-4"
                     style="background: #fff; padding: 40px 40px; margin: 100px 0rem; border: 7px solid #ccc;">
                    <form action="<%=request.getContextPath()%>" method="post" id="loginForm" class="form-horizontal" style="margin: 15px 0 0 0;">
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
                            <label for="checkimg" class="col-sm-2 control-label">验证码</label>
                            <div class="col-sm-2">
                                <input type="text" name="checkimg" id="checkimg" class="form-control">
                            </div>
                            <div class="col-sm-2">
                                <img alt="校验码无法显示" src="<%=request.getContextPath()%>/checkimg?method=checkImg" onclick="switchImg(this)">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="checkbox">
                                    <label> <input type="checkbox" name="autologin" value="1" id="input2" /> 自动登录
                                    </label>&nbsp;&nbsp;&nbsp;&nbsp; <label> <input type="checkbox" name="persis"
                                                                                    value="1" id="input1" /> 记住密码
                                </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <input type="submit" value="登录"
                                       style="background: url('<%=request.getContextPath()%>/img/login.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-md-1"></div>
            </div>
        </div>
    </div>
    <!-- 底部内容 -->
    <%@include file="foot.jsp"%>
</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/utils.js"></script>
<script type="text/javascript">
    /**
     * 验输入内容是否为空
     */
    //校验用户名是否为空
    Utils.on(document.getElementById("username"), "blur", function () {
        if (Utils.strIsBlank(this.value)) {
            const node = document.createTextNode("请输入正确的用户名。");
            showTip(this, node);
        }
    });
    //校验密码是否为空
    Utils.on(document.getElementById("exampleInputPassword2"), "blur", function () {
        if (Utils.strIsBlank(this.value)) {
            const node = document.createTextNode("请输入正确的密码。");
            showTip(this, node);
        }
    });

    /**
     * 验证码切换
     */
    function switchImg(el) {
        el.setAttribute("src","<%=request.getContextPath()%>/checkimg?method=checkImg&time="+new Date().getTime());
    }


    /**
     * 表单校验
     */
    Utils.on(document.getElementById("loginForm"), "submit", function (event) {
        var formData = new FormData(this);
        //异步校验
        Utils.async("post", convert_FormData_to_json(formData), "<%=request.getContextPath()%>/user?method=checkUserLogin", function (data) {
            if (200 != data.code) {
                //取消事件的默认动作 event.preventDefault();
                event.returnValue=false;
                const node = document.createTextNode(data.msg);
                showTip(document.getElementById("loginForm"), node);
            }
        }, false, 'json');
    });

    function showTip(el, textNode) {
        //创建元素
        const newSubE = document.createElement("b");
        newSubE.setAttribute("style","color: red;");
        //添加子元素
        newSubE.appendChild(textNode);

        el.parentNode.appendChild(newSubE);

        //1s删除新创建的元素
        setTimeout(function () {
            el.parentNode.removeChild(newSubE);
        }, 1500);

    }

</script>
</body>
</html>
