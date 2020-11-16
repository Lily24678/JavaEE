<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/12
  Time: 下午4:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>首页</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
    <script src="<%=request.getContextPath()%>/bootstrap/jquery-1.11.3.min.js"></script>
    <script src="<%=request.getContextPath()%>/bootstrap/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/utils.js"></script>
</head>

<body>
<div class="container-fluid">
    <!-- 顶部内容 -->
    <%@include file="head.jsp"%>
    <!-- 主体内容 -->
    <div class="container-fluid">
        <!-- 轮播图 -->
        <div class="container-fluid">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src="<%=request.getContextPath()%>/img/1.jpg" alt="图片无法显示">
                        <div class="carousel-caption">...</div>
                    </div>
                    <div class="item">
                        <img src="<%=request.getContextPath()%>/img/2.jpg" alt="图片无法显示">
                        <div class="carousel-caption">...</div>
                    </div>
                    <div class="item">
                        <img src="<%=request.getContextPath()%>/img/3.jpg" alt="图片无法显示">
                        <div class="carousel-caption">...</div>
                    </div>
                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a> <a class="right carousel-control" href="#carousel-example-generic" role="button"
                        data-slide="next"> <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
            </div>
        </div>

        <!-- 热门商品 -->
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <h2>
                        最新商品<img alt="图片无法显示" src="<%=request.getContextPath()%>/img/title2.jpg">
                    </h2>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    <a href="<%=request.getContextPath()%>/demo/product.html?big01"><img alt="图片无法显示" src="<%=request.getContextPath()%>/img/products/big01.jpg"
                                                                   width="100%" height="404"/></a>
                </div>
                <div class="col-md-10">
                    <div class="row">
                        <div class="col-md-6">
                            <a href="<%=request.getContextPath()%>/demo/product.html?middle01"><img alt="图片无法显示"
                                                                              src="<%=request.getContextPath()%>/img/products/middle01.jpg"
                                                                              width="100%" height="200"></a>
                        </div>
                        <div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
                            <a href="<%=request.getContextPath()%>/demo/product.html?small01"><img alt="图片无法显示"
                                                                             src="<%=request.getContextPath()%>/img/products/small01.jpg"
                                                                             width="100%" height="130"></a>
                            <p>商品名称</p>
                            <p>价格：xx$</p>
                        </div>
                        <div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
                            <a href="<%=request.getContextPath()%>/demo/product.html?small02"><img alt="图片无法显示"
                                                                             src="<%=request.getContextPath()%>/img/products/small02.jpg"
                                                                             width="100%" height="130"></a>
                            <p>商品名称</p>
                            <p>价格：xx$</p>
                        </div>
                        <div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
                            <a href="<%=request.getContextPath()%>/demo/product.html?small03"></a><img alt="图片无法显示"
                                                                                 src="<%=request.getContextPath()%>/img/products/small03.jpg"
                                                                                 width="100%" height="130"/></a>
                            <p>商品名称</p>
                            <p>价格：xx$</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
                            <a href="<%=request.getContextPath()%>/demo/product.html?small04"></a><img alt="图片无法显示"
                                                                                 src="<%=request.getContextPath()%>/img/products/small04.jpg"
                                                                                 width="100%" height="130"></a>
                            <p>商品名称</p>
                            <p>价格：xx$</p>
                        </div>
                        <div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
                            <a href="<%=request.getContextPath()%>/demo/product.html?small05"><img alt="图片无法显示"
                                                                             src="<%=request.getContextPath()%>/img/products/small05.jpg"
                                                                             width="100%" height="130"></a>
                            <p>商品名称</p>
                            <p>价格：xx$</p>
                        </div>
                        <div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
                            <a href="<%=request.getContextPath()%>/demo/product.html?small06"><img alt="图片无法显示"
                                                                             src="<%=request.getContextPath()%>/img/products/small06.jpg"
                                                                             width="100%" height="130"></a>
                            <p>商品名称</p>
                            <p>价格：xx$</p>
                        </div>
                        <div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
                            <a href="<%=request.getContextPath()%>/demo/product.html?small07"><img alt="图片无法显示"
                                                                             src="<%=request.getContextPath()%>/img/products/small07.jpg"
                                                                             width="100%" height="130"></a>
                            <p>商品名称</p>
                            <p>价格：xx$</p>
                        </div>
                        <div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
                            <a href="<%=request.getContextPath()%>/demo/product.html?small08"><img alt="图片无法显示"
                                                                             src="<%=request.getContextPath()%>/img/products/small08.jpg"
                                                                             width="100%" height="130"></a>
                            <p>商品名称</p>
                            <p>价格：xx$</p>
                        </div>
                        <div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
                            <a href="<%=request.getContextPath()%>/demo/product.html?small09"><img alt="图片无法显示"
                                                                             src="<%=request.getContextPath()%>/img/products/small09.jpg"
                                                                             width="100%" height="130"></a>
                            <p>商品名称</p>
                            <p>价格：xx$</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- 最新商品-->
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <h2>
                        最新商品<img alt="图片无法显示" src="<%=request.getContextPath()%>/img/title2.jpg">
                    </h2>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    <a href="<%=request.getContextPath()%>/demo/product.html?big01"><img alt="图片无法显示" src="<%=request.getContextPath()%>/img/products/big01.jpg"
                                                                   width="100%" height="404"/></a>
                </div>
                <div class="col-md-10">
                    <div class="row">
                        <div class="col-md-6">
                            <a href="<%=request.getContextPath()%>/demo/product.html?middle01"><img alt="图片无法显示"
                                                                              src="<%=request.getContextPath()%>/img/products/middle01.jpg"
                                                                              width="100%" height="200"></a>
                        </div>
                        <div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
                            <a href="<%=request.getContextPath()%>/demo/product.html?small01"><img alt="图片无法显示"
                                                                             src="<%=request.getContextPath()%>/img/products/small01.jpg"
                                                                             width="100%" height="130"></a>
                            <p>商品名称</p>
                            <p>价格：xx$</p>
                        </div>
                        <div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
                            <a href="<%=request.getContextPath()%>/demo/product.html?small02"><img alt="图片无法显示"
                                                                             src="<%=request.getContextPath()%>/img/products/small02.jpg"
                                                                             width="100%" height="130"></a>
                            <p>商品名称</p>
                            <p>价格：xx$</p>
                        </div>
                        <div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
                            <a href="<%=request.getContextPath()%>/demo/product.html?small03"></a><img alt="图片无法显示"
                                                                                 src="<%=request.getContextPath()%>/img/products/small03.jpg"
                                                                                 width="100%" height="130"/></a>
                            <p>商品名称</p>
                            <p>价格：xx$</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
                            <a href="<%=request.getContextPath()%>/demo/product.html?small04"></a><img alt="图片无法显示"
                                                                                 src="<%=request.getContextPath()%>/img/products/small04.jpg"
                                                                                 width="100%" height="130"></a>
                            <p>商品名称</p>
                            <p>价格：xx$</p>
                        </div>
                        <div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
                            <a href="<%=request.getContextPath()%>/demo/product.html?small05"><img alt="图片无法显示"
                                                                             src="<%=request.getContextPath()%>/img/products/small05.jpg"
                                                                             width="100%" height="130"></a>
                            <p>商品名称</p>
                            <p>价格：xx$</p>
                        </div>
                        <div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
                            <a href="<%=request.getContextPath()%>/demo/product.html?small06"><img alt="图片无法显示"
                                                                             src="<%=request.getContextPath()%>/img/products/small06.jpg"
                                                                             width="100%" height="130"></a>
                            <p>商品名称</p>
                            <p>价格：xx$</p>
                        </div>
                        <div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
                            <a href="<%=request.getContextPath()%>/demo/product.html?small07"><img alt="图片无法显示"
                                                                             src="<%=request.getContextPath()%>/img/products/small07.jpg"
                                                                             width="100%" height="130"></a>
                            <p>商品名称</p>
                            <p>价格：xx$</p>
                        </div>
                        <div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
                            <a href="<%=request.getContextPath()%>/demo/product.html?small08"><img alt="图片无法显示"
                                                                             src="<%=request.getContextPath()%>/img/products/small08.jpg"
                                                                             width="100%" height="130"></a>
                            <p>商品名称</p>
                            <p>价格：xx$</p>
                        </div>
                        <div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
                            <a href="<%=request.getContextPath()%>/demo/product.html?small09"><img alt="图片无法显示"
                                                                             src="<%=request.getContextPath()%>/img/products/small09.jpg"
                                                                             width="100%" height="130"></a>
                            <p>商品名称</p>
                            <p>价格：xx$</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- 历史浏览记录 -->
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <h2>
                        历史浏览记录<a href="<%=request.getContextPath()%>/product?method=removeBrowsingHistory" style="font-size: small;">清空浏览记录</a><img alt="图片无法显示" src="<%=request.getContextPath()%>/img/title2.jpg">
                    </h2>
                </div>
            </div>
            <div class="row" id="pidHistory">
                <!--<div class="col-md-1" style="text-align: center; height: 100px;">
                    <a href="<%=request.getContextPath()%>/demo/product.html?small09"><img alt="图片无法显示"
                        src="<%=request.getContextPath()%>/img/products/small09.jpg"
                        width="100%" height="130"></a>
                </div>-->
            </div>
        </div>
    </div>

    <!-- 底部内容 -->
    <%@include file="fot.jsp" %>
</div>
<script type="text/javascript">
    /**
     * 用户登陆显示处理
     */
    const username_cookie = Utils.getCookie("username");
    if (!Utils.strIsBlank(username_cookie)) {//已登陆
        const liEle = document.createElement("li");
        const aEle = document.createElement("a");
        aEle.setAttribute("href", "javascript:void(0);");
        aEle.setAttribute("style", "color:green;");
        let textNote = null;
        if (Utils.strIsBlank(Utils.getCookie("showLastVisit"))) {
            textNote = document.createTextNode(username_cookie + "，您是第" + Utils.getCookie("count") + "位访问的用户");
        } else {
            textNote = document.createTextNode(username_cookie + "，您是第" + Utils.getCookie("count") + "位访问的用户。上次访问的时间是" + Utils.getCookie("showLastVisit"));
        }
        aEle.appendChild(textNote);
        liEle.appendChild(aEle);
        document.getElementById("menuList").appendChild(liEle);
    }

    /**
     * 显示历史浏览记录
     */
    const pids = Utils.getCookie("pidHistory");
    if(!Utils.strIsBlank(pids)){
        let pidArr = pids.split("-");
        let html='';
        for(let i=0;i<pidArr.length;i++){
            Utils.async("post",{pid:pidArr[i]},"<%=request.getContextPath()%>/product?method=findById",function(data){
                if(200==data.code){
                    const product = data.data;
                    html+='<div class="col-md-1" style="text-align: center; height: 100px;"><a href="<%=request.getContextPath()%>/demo/product.html?'+product.pid+'"><img alt="图片无法显示" src="<%=request.getContextPath()%>/img/products/'+product.imgurl+'"  width="100%" height="130"></a></div>';
                }

            },false,"json")
        }
        document.getElementById("pidHistory").innerHTML=html;
    }

    /* 轮播图 */
    $('.carousel').carousel({
        interval: 2000
    })

</script>
</body>

</html>
