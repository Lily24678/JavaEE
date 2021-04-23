<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/25
  Time: 上午10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<html>
<head>
    <meta charset="UTF-8">
    <title>网上商城管理中心</title>
    <style>
        input:required {
            background-color: darkkhaki;
        }
    </style>
</head>
<body style="background: #278296;display: flex;align-items: center;justify-content: center;">
<form action="${pageContext.request.contextPath}/mg/bguser?method=homepage" method="POST" autocomplete="on"
      id="login_form"
      style="position: absolute;top: 50%;transform: translate(0, -50%);">
    <table style="border-spacing: 0 15px;">
        <tr>
            <td>管理员用户名：</td>
            <td><input type="text" name="username" maxlength="20" placeholder="请输入登陆名" required="required"
                       onblur="fillpassword(this.value);"></td>
        </tr>
        <tr>
            <td>管理员密码：</td>
            <td><input type="password" name="password" maxlength="20" placeholder="请输入登陆名" required="required">
            </td>
        </tr>
        <tr>
            <td>校验码：</td>
            <td><input type="text" name="checkcode" placeholder="请输入校验码" required="required"></td>
            <td>
                <img src="${pageContext.request.contextPath}/mg/chekimg" alt="无法查看，请联系管理员" onclick="switchImg(this)">
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="checkbox" name="autologin" value="1" checked="checked">自动登陆</td>
            <td><input type="checkbox" name="remenberpassword" value="1" checked="checked">记住密码</td>

        </tr>
        <tr>
            <td colspan="3" style="text-align: center;"><input type="submit" value="进入后台管理"></td>
        </tr>
    </table>
</form>
<script>
    function switchImg(checkimg) {
        $(checkimg).attr("src", $(checkimg).attr("src") + "?" + new Date().getTime());
    }

    $("#login_form").submit(function (event) {
        $.ajax({
            async: false,
            url: "${pageContext.request.contextPath}/mg/bguser?method=checklogin",
            data: $("#login_form").serialize(),
            success: function (result) {
                if (200 != result.code) {
                    alert(result.msg);
                    event.preventDefault();
                }
            },
            dataType: "json"
        });
    });

    function fillpassword(username) {
        const arr = document.cookie.split(";");
        for (let i = 0; i < arr.length; i++) {
            const arr1 = arr[i].split("=");
            if (arr1[0].trim() == username + "-password") {
                $("input[name='password']").val(arr1[1]);
                break;
            }
        }
    }

    document.onkeyup = function (event) {
        const key = event.key;
        if (key == "Enter") {
            $("#login_form").submit();
        }
    };
</script>
</body>
</html>
