<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/27
  Time: 上午11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="update_contain">
    <iframe name="form_iframe" style="display: none;"></iframe>
    <form action="${pageContext.request.contextPath}/mg/bguser?method=edit" method="post" target="form_iframe"
          id="edit_form">
        <table>
            <caption>后台用户管-编辑</caption>
            <tbody>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username" value="${bean.username}" required="required"></td>
            </tr>
            <tr>
                <td>原始密码</td>
                <td><input type="password" name="oldpassword" value="" required="required"></td>
            </tr>
            <tr>
                <td>新密码</td>
                <td><input type="password" name="password" value="" required="required"></td>
            </tr>
            <tr>
                <td>确认新密码</td>
                <td><input type="password" name="repassword" value="" required="required"></td>
            </tr>
            <tr>
                <td>是否禁用</td>
                <td>
                    <select name="state" required="required">
                        <option value="0" <c:if test="${bean.state==0}">selected="selected"</c:if>>否</option>
                        <option value="1" <c:if test="${bean.state==1}">selected="selected"</c:if>>是</option>
                    </select>
                </td>
            </tr>
            <tr>
                <input type="hidden" name="bguid" value="${bean.bguid}">
                <td colspan="2"><input type="submit" value="保存"></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
<script>
    $("#edit_form").submit(function () {
        const oldpassword = $(this).find("input[name='oldpassword']").val();
        const bguid = $(this).find("input[name='bguid']").val();
        const username = $(this).find("input[name='username']").val();
        const url = $(this).attr("action");
        $.ajax({
            async: false, url: "${pageContext.request.contextPath}/mg/bguser?method=checkpassword",data:{bguid:bguid,password:oldpassword},success: function (result) {
                if (200!=result.code) {
                    alert(result.msg);
                } else {
                    $.ajax({
                        async: false, url: "${pageContext.request.contextPath}/mg/bguser?method=checkusername",data:{bguid:bguid,username:username,type:"edit"},success: function (result) {
                            if (200!=result.code) {
                                alert(result.msg);
                            } else {
                                $.post(url, $("#edit_form").serialize(), function (data, status, xhr) {
                                    $("#main_content").html(data);
                                });
                            }
                        }, dataType: "json"
                    });
                }
            }, dataType: "json"
        });
        return false;
    });
</script>
