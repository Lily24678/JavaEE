<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/26
  Time: 下午3:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="list_contain">
    <table>
        <caption>订单管理管理</caption>
        <colgroup>
            <col span="3" style="background-color:cadetblue;">
            <col style="background-color:lightblue">
        </colgroup>
        <thead>
        <tr>
            <th>序号</th>
            <th>订单状态</th>
            <th>订单总计</th>
            <th>订单产生的时间</th>
            <th>收货人名</th>
            <th>收货人名电话</th>
            <th>收货人名地址</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${beanPage.list}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>
                    <c:choose>
                        <c:when test="${item.state==0}">未付款</c:when>
                        <c:when test="${item.state==1}">付款</c:when>
                        <c:when test="${item.state==2}">发货</c:when>
                        <c:when test="${item.state==3}">收货</c:when>
                        <c:otherwise>未知</c:otherwise>
                    </c:choose>
                </td>
                <td>${item.total}</td>
                <td>${item.ordertime}</td>
                <td>${item.name}</td>
                <td>${item.telephone}</td>
                <td>${item.address}</td>
                <td>
                    <a href="javascript:void(0);" onclick="showDetail('${item.oid}')">查看订单详情</a>
                    <a href="javascript:$('#main_content').load('${pageContext.request.contextPath}/mg/order?method=deliver&oid=${item.oid}');" <c:if test="${item.state==2}">style="pointer-events: none;color: grey;"</c:if>>发货</a>
                </td>
            </tr>
            <%--订单详情展示--%>
            <tr>
                <td colspan="8">
                    <div id="div${item.oid}">

                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="8">
                <%@include file="../pagenum.jsp" %>
            </td>
        </tr>
        </tfoot>
    </table>
</div>
<script>
    let showflag = false;
    function showDetail(oid) {
        if (showflag){
            $("#div" + oid).fadeOut();
            showflag=false;
            return ;
        }
        if ($("#div" + oid).html().replace(/(^\s*)|(\s*$)/g,"")==""){
            $.post("${pageContext.request.contextPath}/mg/order", {method: "showDetail", oid: oid}, function (result) {
                let html = '';
                html += '<table>';
                html += '<caption>订单详情</caption>';
                html += '<thead><tr><th>序号</th><th>商品名称</th><th>售价</th><th>图片</th><th>购买数量</th><th>小记</th></tr></thead>';
                html += '<tbody>';
                $(result).each(function(index,orderitem){
                    html += '<tr><td>'+index+1+'</td><td>'+orderitem.product.pname+'</td><td>'+orderitem.product.shop_price+'</td><td><img src="/imgUrl/'+orderitem.product.pimage+'" alt="无法查看请联系管理员" width="20px" height="20px"/></td><td>'+orderitem.subcount+'</td><td>'+orderitem.subtotal+'</td></tr>';
                });
                html += '</tbody>';
                html += '</table>';
                $("#div" + oid).html(html);
                showflag=true;
            }, "json");
        }else {
            $("#div" + oid).fadeIn();
            showflag=true;
        }
    }
</script>
