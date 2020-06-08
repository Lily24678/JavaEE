<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>首页</title>
<link rel="stylesheet" href="/JavaEE/bootstrap/css/bootstrap.min.css">
<script src="/JavaEE/bootstrap/jquery-1.11.3.min.js"></script>
<script src="/JavaEE/bootstrap/bootstrap.min.js"></script>
<script src="/JavaEE/js/utils.js"></script>
</head>
<body>
	<div class="container-fluid">
		<!-- 顶部内容 -->
		<%@ include file="head.jsp" %>
		
		<!-- 主体内容 -->
		<div class="container-fluid">
			<!-- 轮播图 -->
			<div class="container-fluid">
				<div id="carousel-example-generic" class="carousel slide"
					data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0"
							class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="/JavaEE/img/1.jpg" alt="图片无法显示">
							<div class="carousel-caption">...</div>
						</div>
						<div class="item">
							<img src="/JavaEE/img/2.jpg" alt="图片无法显示">
							<div class="carousel-caption">...</div>
						</div>
						<div class="item">
							<img src="/JavaEE/img/3.jpg" alt="图片无法显示">
							<div class="carousel-caption">...</div>
						</div>
					</div>

					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-example-generic"
						role="button" data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#carousel-example-generic"
						role="button" data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>

			<!-- 热门商品 -->
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<h2>
							热门商品<img alt="图片无法显示" src="/JavaEE/img/title2.jpg">
						</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2">
						<img alt="图片无法显示" src="/JavaEE/img/products/big01.jpg" width="100%"
							height="404" />
					</div>
					<div class="col-md-10">
					<div class="row">
						<div class="col-md-6">
							<img alt="图片无法显示" src="/JavaEE/img/products/middle01.jpg" width="100%"
								height="200">
						</div>
						<div class="col-md-2"
							style="text-align: center; height: 200px; padding: 10px 0px;">
							<img alt="图片无法显示" src="/JavaEE/img/products/small01.jpg" width="100%"
								height="130">
							<p>商品名称</p>
							<p>价格：xx$</p>
						</div>
						<div class="col-md-2"
							style="text-align: center; height: 200px; padding: 10px 0px;">
							<img alt="图片无法显示" src="/JavaEE/img/products/small02.jpg" width="100%"
								height="130">
							<p>商品名称</p>
							<p>价格：xx$</p>
						</div>
						<div class="col-md-2"
							style="text-align: center; height: 200px; padding: 10px 0px;">
							<img alt="图片无法显示" src="/JavaEE/img/products/small03.jpg" width="100%"
								height="130">
							<p>商品名称</p>
							<p>价格：xx$</p>
						</div>
					</div>
					<div class="row">
						<div class="col-md-2"
							style="text-align: center; height: 200px; padding: 10px 0px;">
							<img alt="图片无法显示" src="/JavaEE/img/products/small04.jpg" width="100%"
								height="130">
							<p>商品名称</p>
							<p>价格：xx$</p>
						</div>
						<div class="col-md-2"
							style="text-align: center; height: 200px; padding: 10px 0px;">
							<img alt="图片无法显示" src="/JavaEE/img/products/small05.jpg" width="100%"
								height="130">
							<p>商品名称</p>
							<p>价格：xx$</p>
						</div>
						<div class="col-md-2"
							style="text-align: center; height: 200px; padding: 10px 0px;">
							<img alt="图片无法显示" src="/JavaEE/img/products/small06.jpg" width="100%"
								height="130">
							<p>商品名称</p>
							<p>价格：xx$</p>
						</div>
						<div class="col-md-2"
							style="text-align: center; height: 200px; padding: 10px 0px;">
							<img alt="图片无法显示" src="/JavaEE/img/products/small07.jpg" width="100%"
								height="130">
							<p>商品名称</p>
							<p>价格：xx$</p>
						</div>
						<div class="col-md-2"
							style="text-align: center; height: 200px; padding: 10px 0px;">
							<img alt="图片无法显示" src="/JavaEE/img/products/small08.jpg" width="100%"
								height="130">
							<p>商品名称</p>
							<p>价格：xx$</p>
						</div>
						<div class="col-md-2"
							style="text-align: center; height: 200px; padding: 10px 0px;">
							<img alt="图片无法显示" src="/JavaEE/img/products/small09.jpg" width="100%"
								height="130">
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
							最新商品<img alt="图片无法显示" src="/JavaEE/img/title2.jpg">
						</h2>
					</div>
				</div>
				<div class="row">	
					<div class="col-md-2">
						<img alt="图片无法显示" src="/JavaEE/img/products/big01.jpg" width="100%"
							height="404" />
					</div>
					<div class="col-md-10">
					<div class="row">
						<div class="col-md-6">
							<img alt="图片无法显示" src="/JavaEE/img/products/middle01.jpg" width="100%"
								height="200">
						</div>
						<div class="col-md-2"
							style="text-align: center; height: 200px; padding: 10px 0px;">
							<img alt="图片无法显示" src="/JavaEE/img/products/small01.jpg" width="100%"
								height="130">
							<p>商品名称</p>
							<p>价格：xx$</p>
						</div>
						<div class="col-md-2"
							style="text-align: center; height: 200px; padding: 10px 0px;">
							<img alt="图片无法显示" src="/JavaEE/img/products/small02.jpg" width="100%"
								height="130">
							<p>商品名称</p>
							<p>价格：xx$</p>
						</div>
						<div class="col-md-2"
							style="text-align: center; height: 200px; padding: 10px 0px;">
							<img alt="图片无法显示" src="/JavaEE/img/products/small03.jpg" width="100%"
								height="130">
							<p>商品名称</p>
							<p>价格：xx$</p>
						</div>
					</div>
					<div class="row">
						<div class="col-md-2"
							style="text-align: center; height: 200px; padding: 10px 0px;">
							<img alt="图片无法显示" src="/JavaEE/img/products/small04.jpg" width="100%"
								height="130">
							<p>商品名称</p>
							<p>价格：xx$</p>
						</div>
						<div class="col-md-2"
							style="text-align: center; height: 200px; padding: 10px 0px;">
							<img alt="图片无法显示" src="/JavaEE/img/products/small05.jpg" width="100%"
								height="130">
							<p>商品名称</p>
							<p>价格：xx$</p>
						</div>
						<div class="col-md-2"
							style="text-align: center; height: 200px; padding: 10px 0px;">
							<img alt="图片无法显示" src="/JavaEE/img/products/small06.jpg" width="100%"
								height="130">
							<p>商品名称</p>
							<p>价格：xx$</p>
						</div>
						<div class="col-md-2"
							style="text-align: center; height: 200px; padding: 10px 0px;">
							<img alt="图片无法显示" src="/JavaEE/img/products/small07.jpg" width="100%"
								height="130">
							<p>商品名称</p>
							<p>价格：xx$</p>
						</div>
						<div class="col-md-2"
							style="text-align: center; height: 200px; padding: 10px 0px;">
							<img alt="图片无法显示" src="/JavaEE/img/products/small08.jpg" width="100%"
								height="130">
							<p>商品名称</p>
							<p>价格：xx$</p>
						</div>
						<div class="col-md-2"
							style="text-align: center; height: 200px; padding: 10px 0px;">
							<img alt="图片无法显示" src="/JavaEE/img/products/small09.jpg" width="100%"
								height="130">
							<p>商品名称</p>
							<p>价格：xx$</p>
						</div>
					</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 底部内容 -->
		<%@ include file="foot.jsp" %>
	</div>
	<script type="text/javascript">
	var username_cookie = Utils.getCookie("username");
	var split = username_cookie.split("-");
	
	
	/* 轮播图 */
	$('.carousel').carousel({
		  interval: 2000
		})
		
	</script>
</body>
</html>