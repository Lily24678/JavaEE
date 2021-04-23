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
    <form action="${pageContext.request.contextPath}/mg/category?method=add" method="post" target="form_iframe"
          id="add_form">
        <%--令牌机制--%>
        <input type="hidden" name="token" value="${token}"/>
        <table>
            <caption>商品类目管理-新增</caption>
            <tbody>
            <tr>
                <td>类目名称</td>
                <td><input type="text" name="cname" vale="" required="required"></td>
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
        const cname = $(this).find("input[name='cname']").val();
        const url = $(this).attr("action");
        $.ajax({
            async: false, url: "${pageContext.request.contextPath}/mg/category?method=checkcname",data:{cname:cname,type:"add"},success: function (result) {
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
