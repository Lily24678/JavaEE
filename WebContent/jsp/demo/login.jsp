<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<link rel="stylesheet" href="/JavaEE/bootstrap/css/bootstrap.min.css">
<script src="/JavaEE/bootstrap/jquery-1.11.3.min.js"></script>
<script src="/JavaEE/bootstrap/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<!-- 主体内容 -->
		<div class="container-fluid"
			style="background: url(/JavaEE/img/loginbg.jpg); width: 96.8;">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-7"></div>
					<div class="col-md-4"
						style="background: #fff; padding: 40px 40px; margin: 100px 0rem; border: 7px solid #ccc;">
						<font size="4">会员登录</font>&nbsp;&nbsp;USER LOGIN<font size="4" style="float: right;"><a href="/JavaEE/user?method=regist">注册</a></font>
						<form action="/JavaEE/user?method=index" method="post"
							id="loginForm" onsubmit="return checkUser()"
							class="form-horizontal" style="margin: 15px 0 0 0;">
							<div class="form-group">
								<label for="username" class="col-sm-2 control-label">用户名</label>
								<div class="col-sm-9" id="check-username">
									<input type="text" name="username" required="required"
										id="username" class="form-control" placeholder="请输入用户名">
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword2"
									class="col-sm-2 control-label">确认密码</label>
								<div class="col-sm-9">
									<input type="password" name="password" required="required"
										class="form-control" id="exampleInputPassword2"
										placeholder="请输入确认密码">
								</div>
							</div>
							<div class="form-group">
								<label for="exampleCheck1" class="col-sm-2 control-label">验证码</label>
								<div class="col-sm-2">
									<input type="text" id="exampleCheck1" class="form-control">
								</div>
								<div class="col-sm-2">
									<img alt="校验码无法显示" src="/JavaEE/img/captcha.jhtml">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<div class="checkbox">
										<label> <input type="checkbox" name="autologin"
											value="1" id="input2" /> 自动登录
										</label>&nbsp;&nbsp;&nbsp;&nbsp; <label> <input
											type="checkbox" name="persis" value="1" id="input1" /> 记住密码
										</label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<input type="submit" value="登录"
										style="background: url('/JavaEE/img/login.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-1"></div>
				</div>
			</div>
		</div>
		<!-- 底部内容 -->
		<%@ include file="/JavaEE/jsp/demo/foot.jsp" %>
	</div>
	<script type="text/javascript" src="/JavaEE/js/utils.js"></script>
	<script type="text/javascript">
			//异步校验用户名是否存在
			Utils.on(document.getElementById("username"), "blur", function() {
				var node = '';
				if (Utils.strIsBlank(this.value)) {
					node = document.createTextNode("请输入正确的用户名。");
					checkNameTip(node);
				} else {
					//异步校验
					Utils.async("post", {
						username: this.value
					}, "/JavaEE/user?method=checkNameLogin", function(data) {
						if (200 != data.code) {
							node = document.createTextNode(data.msg);
							checkNameTip(node);
						}
					}, true, 'json');
				}

			});

			function checkUser() {
				var flag = true;
				var formData = new FormData(document.getElementById("loginForm"));
				var data = JSON.stringify(formData);
				//异步校验
				Utils.async("post", convert_FormData_to_json(formData), "/JavaEE/user?method=checkUserLogin", function(data) {
					if (200 != data.code) {
						flag = false;
						window.alert(data.msg);
					}
				}, false, 'json');
				return flag;
			}

			Utils.on(document.getElementById("input2"), "change", function() {
				if (this.checked) {
					document.getElementById("input1").checked = "checked";
				}
			});

			function checkNameTip(node) {
				//创建元素，并显示
				var newSubE = document.createElement("b");
				newSubE.style = 'color: red;';
				newSubE.appendChild(node);

				var parentE = document.getElementById("check-username");
				var exitSubE = document.getElementById("username");
				parentE.appendChild(newSubE, exitSubE);

				//1s删除新创建的元素
				setTimeout(function() {
					parentE.removeChild(newSubE);
				}, 1500);
			}
		</script>
</body>
</html>
