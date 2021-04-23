<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/26
  Time: 下午3:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
    .list_contain > table > thead > tr:first-child {
        text-align: right;
    }

</style>
<div class="list_contain">
    <table>
        <caption>后台用户管理</caption>
        <colgroup>
            <col span="3" style="background-color:cadetblue;">
            <col style="background-color:lightblue">
        </colgroup>
        <thead>
        <tr>
            <th colspan="5">
                <a href="javascript:$('#main_content').load('${pageContext.request.contextPath}/mg/bguser?method=addpage');">新增管理用户</a>
            </th>
        </tr>
        <tr>
            <th>序号</th>
            <th>用户名</th>
            <th>禁用状态</th>
            <th>更新时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${beanPage.list}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${item.username}</td>
                <td>
                    <c:choose>
                        <c:when test="${item.state==0}"><span style="color:forestgreen">可用</span></c:when>
                        <c:when test="${item.state==1}"><span style="color: darkred">禁用</span></c:when>
                        <c:otherwise><span style="color: grey">未知</span></c:otherwise>
                    </c:choose>
                </td>
                <td><fmt:formatDate type="both" value="${item.updatetime}"/></td>
                <td>
                    <a href="javascript:$('#main_content').load('${pageContext.request.contextPath}/mg/bguser?method=editpage&bguid=${item.bguid}')">编辑</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a
                        href="javascript:promptWindow('${item.username}','${item.bguid}');">删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="5">
                <%@include file="../pagenum.jsp" %>
            </td>
        </tr>
        </tfoot>
    </table>
</div>
<script>
    function promptWindow(username, bguid) {
        const repassword = prompt("请输入" + username + "的密码", "");
        if (repassword!=null){
            if (repassword != "") {
                $.ajax({
                    async: false, url: "${pageContext.request.contextPath}/mg/bguser?method=checkpassword",data:{bguid:bguid,password:repassword},success: function (result) {
                        if (200!=result.code) {
                            alert(result.msg);
                        } else {
                            $.post("${pageContext.request.contextPath}/mg/bguser?method=del", {bguid: bguid}, function (data) {
                                $("#main_content").html(data);
                            });
                        }
                    }, dataType: "json"
                });
            } else {
                promptWindow(username, bguid);
            }
        }
    }
</script>
