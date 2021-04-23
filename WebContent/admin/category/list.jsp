<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/26
  Time: 下午3:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .list_contain > table > thead > tr:first-child {
        text-align: right;
    }
</style>
<div class="list_contain">
    <table>
        <caption>商品类目管理</caption>
        <colgroup>
            <col span="3" style="background-color:cadetblue;">
            <col style="background-color:lightblue">
        </colgroup>
        <thead>
        <tr>
            <th colspan="5">
                <a href="javascript:$('#main_content').load('${pageContext.request.contextPath}/mg/category?method=addpage');">新增商品类目</a>
            </th>
        </tr>
        <tr>
            <th>序号</th>
            <th>类目名称</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${beanPage.list}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${item.cname}</td>
                <td>
                    <a href="javascript:$('#main_content').load('${pageContext.request.contextPath}/mg/category?method=editpage&cid=${item.cid}')">编辑</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a
                        href="javascript:promptWindow('${item.cname}','${item.cid}');">删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="3">
                <%@include file="../pagenum.jsp" %>
            </td>
        </tr>
        </tfoot>
    </table>
</div>
<script>
    function promptWindow(cname, cid) {
        const recname = prompt("请输入要删除的类目名称", "");
        if (recname != null) {
            if (recname != "" && recname == cname) {
                $.ajax({
                    async: false,
                    url: "${pageContext.request.contextPath}/mg/category",
                    data: {method: "findProduct", cid: cid},
                    dataType:"json",
                    success: function (result) {
                        if (0 == result.length) {
                            $.post("${pageContext.request.contextPath}/mg/category?method=del", {cid: cid}, function (data) {
                                $("#main_content").html(data);
                            });
                        } else {
                            window.alert("禁止删除")
                        }
                    }
                });
            } else {
                promptWindow(cname, cid);
            }
        }
    }
</script>
