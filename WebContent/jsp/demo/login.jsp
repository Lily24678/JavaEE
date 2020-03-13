<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登录</title>
		<style type="text/css">
			.form-sub1 {
				margin-top: 10px;
				margin-bottom: 10px;
			}
		</style>
		<script type="text/javascript" src="../../js/utils.js"></script>
	</head>
	<body>
		<form action="/JavaEE/jsp/demo/index.jsp" method="post" id="loginForm" onsubmit="return checkUser()">
			<div class="form-sub1" id="check-username">
				<label for="username">用户名：</label>
				<input type="text" required="required" name="username" value="" id="username" />
			</div>
			<div class="form-sub1">
				<label for="password">登录密码：</label>
				<input type="password" required="required" name="password" value="" id="password" />
			</div>
			<div class="form-sub1">
				<input id="input2" type="checkbox" name="autologin" value="1" /><label for="input2">自动登录</label>
				<input id="input1" type="checkbox" name="persis" value="1" /><label for="input1">记住密码</label>
			</div>
			<a href="/JavaEE/regist.html"><label>注册</label></a>
			<div class="form-sub1">
				<input type="submit" value="提交" />
			</div>
		</form>
		
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