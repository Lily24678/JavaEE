<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/25
  Time: 上午11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ztree/zTreeStyle.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/ztree/jquery.ztree.core.js"></script>

<div id="left">
    <p><a href="javascript:$.fn.zTree.getZTreeObj('treeDemo').expandAll(true);">展开全部</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="javascript:$.fn.zTree.getZTreeObj('treeDemo').expandAll(false);">关闭所有</a></p>
    <ul id="treeDemo" class="ztree"></ul>
    <script>
        let zTreeObj;
        // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
        const setting = {
            callback: {
                onClick: function (event, treeId, treeNode){
                    $("#main_content").load(treeNode.tourl);
                }
            }
        };
        // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
        const zNodes = [
            {
                name: "后台用户管理", open: true, children: [
                    {name: "后台用户管理",tourl:"${pageContext.request.contextPath}/mg/bguser?method=listpage&currentPage=1"}]
            },
            {
                name: "用户管理", open: true, children: [
                    {name: "用户管理",tourl:"${pageContext.request.contextPath}/mg/user?method=listpage&currentPage=1"}]
            },
            {
                name: "分类管理", open: true, children: [
                    {name: "分类管理",tourl:"${pageContext.request.contextPath}/mg/category?method=listpage&currentPage=1"}]
            },
            {
                name: "商品管理", open: true, children: [
                    {name: "商品管理",tourl:"${pageContext.request.contextPath}/mg/product?method=listpage&currentPage=1"}]
            },
            {
                name: "订单管理", open: true, children: [
                    {name: "订单管理",tourl:"${pageContext.request.contextPath}/mg/order?method=listpage&currentPage=1"}]
            }
            
        ];
        $(document).ready(function(){
            zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
        });
    </script>
</div>
