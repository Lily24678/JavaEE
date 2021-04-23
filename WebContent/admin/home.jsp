<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/25
  Time: 上午10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>商城管理系统</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <style>
        .top, .bottom, .middle {
            border: 2px solid grey;
        }

        .clear {
            clear: both;
        }

        .top {
            /*height: 15%;*/
        }

        .bottom {
            height: 5%;
        }

        .middle {
            height: 80%;
        }

        .middle > *:first-child {
            height: 100%;
            width: 20%;
            float: left;
            border-right: 2px solid grey;
        }

        .middle > *:last-child {
            height: 100%;
            width: 79.5%;
            float: right;
        }

        /*art of sub*/
        table > caption {
            color: black;
            font-size: 30px;
            line-height: 50px;
        }

        input:required {
            background-color: darkkhaki;
        }

        .list_contain > table {
            width: 100%;
        }

        .list_contain > table td {
            text-align: center;
        }

        .list_contain > table > tfoot td:first-child {
            text-align: right;
        }

        .update_contain {
            display: flex;
            justify-content: center;
        }

        .update_contain table {
            border-spacing: 30px;
        }

        .update_contain table td:last-child {
            text-align: left;
        }

        .update_contain form {
            position: absolute;
            top: 50%;
            transform: translate(0, -50%);
        }
    </style>
</head>
<body>
<div class="page">
    <div class="top">
        <%@include file="top.jsp" %>
    </div>
    <div class="clear"></div>
    <div class="middle">
        <div>
            <%@include file="left.jsp" %>
        </div>
        <div id="main_content">
            <%@include file="welcome.jsp" %>
        </div>
    </div>
    <div class="clear"></div>
    <div class="bottom">
        <%@include file="bottom.jsp" %>
    </div>
</div>
</body>
</html>
