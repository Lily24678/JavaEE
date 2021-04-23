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
    <form action="${pageContext.request.contextPath}/mg/category?method=edit" method="post" target="form_iframe"
          id="edit_form">
        <table>
            <caption>商品类目管理-编辑</caption>
            <tbody>
            <tr>
                <td>类目名称</td>
                <td><input type="text" name="cname" value="${bean.cname}" required="required"></td>
            </tr>
            <tr>
                <input type="hidden" name="cid" value="${bean.cid}">
                <td colspan="2"><input type="submit" value="保存"></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
<script>
    $("#edit_form").submit(function () {
        const cid = $(this).find("input[name='cid']").val();
        const cname = $(this).find("input[name='cname']").val();
        const url = $(this).attr("action");
        $.ajax({
            async: false, url: "${pageContext.request.contextPath}/mg/category?method=checkcname",data:{cid:cid,cname:cname,type:"edit"},success: function (result) {
                if (200!=result.code) {
                    alert(result.msg);
                }else {
                    $.ajax({
                        async: false,
                        url: "${pageContext.request.contextPath}/mg/category",
                        data: {method: "findProduct", cid: cid},
                        dataType:"json",
                        success: function (result) {
                            if (0 == result.length) {
                                $.post(url, $("#edit_form").serialize(), function (data, status, xhr) {
                                    $("#main_content").html(data);
                                });
                            } else {
                                window.alert("禁止编辑")
                            }
                        }
                    });

                }
            }, dataType: "json"
        });
        return false;
    });
</script>
