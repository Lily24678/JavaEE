<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/26
  Time: 下午3:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="update_contain">
    <iframe name="form_iframe" style="display: none;"></iframe>
    <form action="${pageContext.request.contextPath}/mg/bguser?method=add" method="post" target="form_iframe"
          id="add_form">
        <table>
            <caption>后台用户管-新增</caption>
            <tbody>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username" vale="" required="required"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password" value="" required="required"></td>
            </tr>
            <tr>
                <td>确认密码</td>
                <td><input type="password" name="repassword" value="" required="required"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="保存"></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
<script>
    $("#add_form").submit(function () {
        const username = $(this).find("input[name='username']").val();
        const url = $(this).attr("action");
        $.ajax({
            async: false, url: "${pageContext.request.contextPath}/mg/bguser?method=checkusername",data:{username:username,type:"add"},success: function (result) {
                if (200!=result.code) {
                    alert(result.msg);
                } else {
                    $.post(url, $("#add_form").serialize(), function (data, status, xhr) {
                        $("#main_content").html(data);
                    });
                }
            }, dataType: "json"
        });

        return false;
    });
</script>
