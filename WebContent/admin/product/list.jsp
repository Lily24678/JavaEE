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

    /**
思路：
	1.超出的文本隐藏
	2.溢出用省略号显示
	3.溢出不换行
	4.将对象作为弹性伸缩盒子模型显示
	5.从上到下垂直排列子元素（设置伸缩盒子的子元素排列方式）
	6.这个属性不是css的规范属性，需要组合上面两个属性，表示显示的行数
  */
    .text {
        width: 100px;
        word-break: break-all;
        display: -webkit-box;
        -webkit-line-clamp: 2;
        -webkit-box-orient: vertical;
        overflow: hidden;
    }
</style>
<div class="list_contain">
    <table>
        <caption>商品管理</caption>
        <colgroup>
            <col span="3" style="background-color:cadetblue;">
            <col style="background-color:lightblue">
        </colgroup>
        <thead>
        <tr>
            <th colspan="11">
                <a href="javascript:$('#main_content').load('${pageContext.request.contextPath}/mg/product?method=addpage');">新增商品</a>
            </th>
        </tr>
        <tr>
            <th>序号</th>
            <th>商品名称</th>
            <th>是否热门</th>
            <th>是否下架</th>
            <th>商品类目</th>
            <th>商城价</th>
            <th>售价</th>
            <th>商品图片</th>
            <th style="width: 100px;">商品描述</th>
            <th>更新日期</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${beanPage.list}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${item.pname}</td>
                <td>
                    <c:choose>
                        <c:when test="${item.is_hot==1}">是</c:when>
                        <c:when test="${item.is_hot==0}">否</c:when>
                        <c:otherwise>未知</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${item.pflag==1}">是</c:when>
                        <c:when test="${item.pflag==0}">否</c:when>
                        <c:otherwise>未知</c:otherwise>
                    </c:choose>
                </td>
                <td>${item.category.cname}</td>
                <td>${item.market_price}</td>
                <td>${item.shop_price}</td>
                <td><img src="/imgUrl/${item.pimage}" alt="无法查看请联系管理员" width="20px" height="20px"/></td>
                <td class="text">${item.pdesc}</td>
                <td><fmt:formatDate type="date" value="${item.pdate}"/></td>
                <td>
                    <a href="javascript:$('#main_content').load('${pageContext.request.contextPath}/mg/product?method=editpage&pid=${item.pid}')">编辑</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a
                        href="javascript:promptWindow('${item.pname}','${item.pid}');"
                        <c:if test="${item.pflag==0}">style="pointer-events: none;color: grey;"</c:if>>删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="11">
                <%@include file="../pagenum.jsp" %>
            </td>
        </tr>
        </tfoot>
    </table>
</div>
<script>
    function promptWindow(pname, pid) {
        const recname = prompt("请输入要删除的商品名称", "");
        if (recname != null) {
            if (recname != "" && recname == pname) {
                $.post("${pageContext.request.contextPath}/mg/product?method=del", {pid: pid}, function (data) {
                    $("#main_content").html(data);
                });
            } else {
                promptWindow(cname, cid);
            }
        }
    }
</script>
