<%@ page import="com.lsy.code.demo.dao.ProductDao" %>
<%@ page import="com.lsy.code.demo.domain.Product" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/17
  Time: 上午9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情</title>
    <%@include file="head.jsp"%>
</head>
<body>
<%
    Product product = new ProductDao().findById(request.getQueryString());
%>
<%--添加商品浏览记录--%>
<%
    String pid = request.getQueryString();
    Cookie pidHistory = ServletUtils.getCookie("pidHistory", request);
    if (null==pidHistory||StringUtils.isBlank(pidHistory.getValue())){//第一次浏览商品
        ServletUtils.addCookie("pidHistory",pid,request,response);
    }else {//不是第一次浏览商品
        List<String> pidList =  new ArrayList<>(Arrays.asList(pidHistory.getValue().split("-")));
        if (pidList.contains(pid)){//该商品已被浏览过
            pidList.remove(pid);
        }
        pidList.add(0,pid);
        ServletUtils.addCookie("pidHistory",String.join("-", pidList),request,response);
    }
%>
<%--将商品添加到购物车--%>
<%
    String pidCart = request.getParameter("pid");
    String count = request.getParameter("productCount");
    Map<String,Integer> map_cart = (Map<String, Integer>) session.getAttribute("shoppingCart");

    //未登陆状态
    if (null==map_cart)//购物车没有任何东西
        map_cart=new HashMap<>();
    if (StringUtils.isNotBlank(count)){
        if (!map_cart.containsKey(pidCart)){//购物车中没有该商品信息
            map_cart.put(pidCart,Integer.parseInt(count));
        }else {//购物车有该商品信息
            map_cart.put(pidCart,map_cart.get(pidCart)+Integer.parseInt(count));
        }
    }
    session.setAttribute("shoppingCart",map_cart);

    //登陆状态下，用户与商品信息关联
%>
<div class="container-fluid">
    <!-- 顶部内容 -->
    <%@include file="top.jsp"%>
    <!-- 主体内容 -->
    <div class="container-fluid">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-2">
                    <div><img id="pimg" src="<%=request.getContextPath()%>/img/products/<%=product.getImgurl()%>" alt="图片无法查看">
                    </div>
                </div>
                <div class="col-md-10">
                    <div class="row">
                        <div class="col-md-12"><span id="pname"><%=product.getPname()%></span></div>
                    </div>
                    <div class="row">
                        <div class="col-md-12"><span id="price">￥<%=product.getPrice()%></span></div>
                    </div>
                    <form action="<%=request.getContextPath()%>/demo/jsp/product.jsp?<%=product.getPid()%>" method="POST" target="form_iframe"
                          class="form-horizontal">
                        <div class="form-group">
                            <label for="productCount" class="col-sm-1 control-label" style="text-align: left">商品数量</label>
                            <div class="col-sm-2">
                                <input type="number" min="1" required="required"  class="form-control" id="productCount"
                                       name="productCount" value="0" placeholder="商品数量" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-2">
                                <input type="hidden" id="pid" name="pid" value="<%=product.getPid()%>"/>
                                <button type="submit" class="btn btn-danger">加入购物车</button>
                            </div>
                        </div>
                    </form>
                    <!-- 此iframe作用：防止表单提交后做跳转 -->
                    <iframe id="form_iframe" name="form_iframe" style="display:none;"></iframe>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <p id="describe">商品描述</p>
                </div>
            </div>
        </div>
    </div>
    <!-- 底部内容 -->
    <%@include file="foot.jsp"%>
</div>
</body>
</html>
