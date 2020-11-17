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
    <%@include file="top.jsp"%>

    <!-- 主体内容 -->
    <div class="container-fluid">
        <div class="container-fluid" style="width: 97.8%; background: url('<%=request.getContextPath()%>/img/regist_bg.jpg');">
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8"
                     style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
                    <span size="4">会员注册</span>&nbsp;&nbsp;USER REGISTER <a href="<%=request.getContextPath()%>/file?method=downFile&filename=用户手册.jpg">下载用户手册</a>
                    <form action="<%=request.getContextPath()%>/page?method=login" method="POST" id="registForm" class="form-horizontal"
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
                            <label for="exampleInputTel1" class="col-sm-2 control-label">Telephone</label>
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
                                <img alt="校验码无法显示" src="<%=request.getContextPath()%>/img/captcha.jhtml">
                            </div>
                        </div>
                    </form>
                    <input type="text" form="registForm" id="headImgUrl" name="headImgUrl" value=""
                           hidden="hidden" />
                    <form action="<%=request.getContextPath()%>/file?method=uploadFile" enctype="multipart/form-data" method="POST"
                          target="form_iframe" id="uploadHeadImg" class="form-horizontal">
                        <div class="form-group">
                            <label for="exampleInputDate1" class="col-sm-2 control-label">上传用户头像</label>
                            <div class="col-sm-6">
                                <input type="file" form="uploadHeadImg" name="headImg" accept="image/*"
                                       class="form-control" id="headImg" placeholder="请选择图片格式的文件">
                            </div>
                        </div>
                    </form>
                    <!-- 此iframe作用：防止表单提交后做跳转 -->
                    <iframe id="form_iframe" name="form_iframe" style="display:none;"></iframe>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <input type="submit" form="registForm" value="注册"
                                   style="background: url('<%=request.getContextPath()%>/img/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
                        </div>
                    </div>
                </div>
                <div class="col-md-2"></div>
            </div>
        </div>
    </div>

    <!-- 底部内容 -->
    <%@include file="foot.jsp"%>
</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/utils.js"></script>
<script type="text/javascript">
    /**
     * 校验输入内容是否为空
     */
    //校验用户名是否为空
    Utils.on(document.getElementById("username"), "blur", function () {
        if (Utils.strIsBlank(this.value)) {
            const node = document.createTextNode("请输入正确的用户名。");
            showTip(this, node);
        }
    });
    //校验密码是否为空
    Utils.on(document.getElementById("exampleInputPassword1"), "blur", function () {
        if (Utils.strIsBlank(this.value)) {
            const node = document.createTextNode("请输入正确的密码。");
            showTip(this, node);
        }
    });
    //校验确认密码和密码是否一致
    Utils.on(document.getElementById("exampleInputPassword2"), "blur", function () {
        const exampleInputPassword1Value = document.getElementById("exampleInputPassword1").value;
        if (Utils.strIsBlank(this.value) || this.value != exampleInputPassword1Value) {
            var node = document.createTextNode("请保持确认秘密与密码一致。");
            showTip(this, node);
        }
    });

    /**
     * 表单校验
     */
    Utils.on(document.getElementById("registForm"), "submit", function (event) {
        //校验确认密码和密码是否一致
        const exampleInputPassword1Value = document.getElementById("exampleInputPassword1").value;
        const exampleInputPassword2Value = document.getElementById("exampleInputPassword2").value;
        if (exampleInputPassword2Value != exampleInputPassword1Value) {
            //取消事件的默认动作 event.preventDefault();
            event.returnValue = false;
            const node = document.createTextNode("请保持确认秘密与密码一致。");
            showTip(this, node);
            return false;//结束事件处理函数
        }

        //上传用户头像
        if (!Utils.strIsBlank(document.getElementById("headImg").value)) {
            Utils.async("post", new FormData(document.getElementById("uploadHeadImg")), "<%=request.getContextPath()%>/file?method=uploadFile", function (data) {
                if (200 != data.code) {
                    //取消事件的默认动作 event.preventDefault();
                    event.returnValue = false;
                    const node = document.createTextNode("头像上传失败，请重新上传图片并重新提交表单。");
                    showTip(document.getElementById("registForm"), node);
                    return false;//结束事件处理函数
                } else {//文件上传成功
                    document.getElementById("headImgUrl").setAttribute("value", data.data);
                }
            }, false, 'json', false, false);
        }

        //插入用户信息
        Utils.async("post", convert_FormData_to_json(new FormData(document.getElementById("registForm"))),
            "<%=request.getContextPath()%>/user?method=checkUserRegist", function (data) {
                if (200 != data.code) {
                    //取消事件的默认动作 event.preventDefault();
                    event.returnValue = false;
                    const node = document.createTextNode(data.msg);
                    showTip(document.getElementById("registForm"), node);
                }
            }, false, 'json');
    });




    function showTip(el, textNode) {
        //创建元素
        const newSubE = document.createElement("b");
        newSubE.setAttribute("style", "color: red;");
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
