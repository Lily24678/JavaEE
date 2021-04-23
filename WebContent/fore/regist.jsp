<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/17
  Time: 上午11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp" %>
    <title>注册</title>
</head>
<body>
<div class="container-fluid">
    <!-- 顶部内容 -->
    <%@include file="top.jsp" %>

    <!-- 主体内容 -->
    <div class="container-fluid">
        <div class="container-fluid"
             style="width: 97.8%; background: url('${pageContext.request.contextPath}/images/regist_bg.jpg');">
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8"
                     style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
                    <span size="4">会员注册</span>&nbsp;&nbsp;USER REGISTER <a
                        href="${pageContext.request.contextPath}/file?filename=用户手册.jpeg">下载用户手册</a>
                    <iframe name="form_iframe" style="display: none"></iframe>
                    <form action="${pageContext.request.contextPath}/fore/user?method=regist" method="POST"
                          id="registForm" target="form_iframe"
                          class="form-horizontal"
                          style="margin: 15px 0 0 0;">
                        <div class="form-group">
                            <label for="username" class="col-sm-2 control-label">用户名</label>
                            <div class="col-sm-6">
                                <input type="text" form="registForm" name="username" required="required"
                                       id="username" class="form-control" placeholder="请输入用户名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1" class="col-sm-2 control-label">密码</label>
                            <div class="col-sm-6">
                                <input type="password" form="registForm" name="repassword" required="required"
                                       class="form-control" id="exampleInputPassword1" placeholder="请输入密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword2" class="col-sm-2 control-label">确认密码</label>
                            <div class="col-sm-6">
                                <input type="password" form="registForm" name="password" required="required"
                                       class="form-control" id="exampleInputPassword2" placeholder="请输入确认密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1" class="col-sm-2 control-label">Email</label>
                            <div class="col-sm-6">
                                <input type="email" form="registForm" name="email" class="form-control"
                                       id="exampleInputEmail1" placeholder="Email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputTel1" class="col-sm-2 control-label">电话</label>
                            <div class="col-sm-6">
                                <input type="tel" form="registForm" name="telephone" class="form-control"
                                       id="exampleInputTel1" placeholder="请输入电话号码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputText2" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-6">
                                <input type="text" form="registForm" name="name" class="form-control"
                                       id="exampleInputText2" placeholder="请输入姓名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputRadio1" class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-6">
                                <input type="radio" form="registForm" name="sex" value="男" id="exampleInputRadio1"
                                       placeholder="男"><label
                                    for="exampleInputRadio1">男</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="radio" name="sex" value="女" id="exampleInputRadio2"
                                       placeholder="女"><label for="exampleInputRadio2">女</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputDate1" class="col-sm-2 control-label">出生日期</label>
                            <div class="col-sm-6">
                                <input type="date" form="registForm" name="birthday" class="form-control"
                                       id="exampleInputDate1" placeholder="年/月/日">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="exampleCheck1" class="col-sm-2 control-label">验证码</label>
                            <div class="col-sm-2">
                                <input type="text" id="exampleCheck1" class="form-control">
                            </div>
                            <div class="col-sm-2">
                                <img alt="校验码无法显示" src="${pageContext.request.contextPath}/fore/checkimg"
                                     onclick="switchImg(this);">
                            </div>
                        </div>
                    </form>
                    <input type="text" form="registForm" id="headImgUrl" name="headImgUrl" value=""
                           hidden="hidden"/>
                    <form action="${pageContext.request.contextPath}/file" enctype="multipart/form-data" method="POST"
                          target="form_iframe" id="file_form" class="form-horizontal">
                        <div class="form-group">
                            <label for="exampleInputDate1" class="col-sm-2 control-label">上传用户头像</label>
                            <div class="col-sm-6">
                                <input type="file" form="file_form" name="file" accept="image/*"
                                       class="form-control" placeholder="请选择图片格式的文件">
                                <input type="hidden" form="registForm" name="headimg">
                            </div>
                        </div>
                    </form>
                    <!-- 此iframe作用：防止表单提交后做跳转 -->
                    <iframe id="form_iframe" name="form_iframe" style="display:none;"></iframe>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <input type="submit" form="registForm" value="注册"
                                   style="background: url('${pageContext.request.contextPath}/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
                        </div>
                    </div>
                </div>
                <div class="col-md-2"></div>
            </div>
        </div>
    </div>

    <!-- 底部内容 -->
    <%@include file="foot.jsp" %>
</div>
<script>
    $("#registForm").submit(function () {
        $.ajax({
            url: "${pageContext.request.contextPath}/file",
            type: 'POST',
            data: new FormData(document.getElementById("file_form")),
            processData: false,
            contentType: false,
            success: function (result) {
                $("input[name='headimg']").val(result);
                console.log(result);
            },
            error: function (xhr, status, error) {
                window.alert("文件上传失败");
            }
        });
        // return false;
    });

    function switchImg(checkimg) {
        $(checkimg).attr("src", $(checkimg).attr("src") + "?" + new Date().getTime());
    }
</script>
</body>
</html>
