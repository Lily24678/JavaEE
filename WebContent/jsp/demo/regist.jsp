<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>注册</title>
		<style type="text/css">
			.form-sub1 {
				margin-top: 10px;
				margin-bottom: 10px;
			}
		</style>
		<script type="text/javascript" src="./js/utils.js"></script>
	</head>
	<body>
		<form action="/JavaEE/user?method=regist" method="post" id="registForm" onsubmit="return checkUserTip();">
			<div class="form-sub1" id="check-username">
				<label for="username">用户名：</label>
				<input type="text" required="required" name="username" value="" id="username" />
			</div>
			<div class="form-sub1">
				<label for="password">登录密码：</label>
				<input type="password" required="required" name="password" value="" id="password" />
			</div>
			<div id="tip1" style="display: none;"><b style="color: red;">用户名、密码不可为空</b></div>
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
					}, "/JavaEE/user?method=checkNameRegist", function(data) {
						if(200!=data.code){
							node = document.createTextNode(data.msg);
							checkNameTip(node);
						}
					}, true,'json');
				}

			});
			
			//校验是否存在，存在则阻止表单提交
			function checkUserTip() {
				var flag=true;
				var formData = new FormData(document.getElementById("registForm"));
				Utils.async("post", params, "/JavaEE/user?method=checkNameRegist", function(data) {
					if(200!=data.code){
						flag=false;//阻止表单提交
						var tip1 = document.getElementById("tip1");
						tip1.style.display="";
						tip1.innerHTML='<b style="color: red;">'+data.msg+'</b>';
						//隐藏提示
						setTimeout(function() {
							tip1.style.display="none";
						}, 1500);	
					}
				},false, 'json',false,false);
				return flag;
			}

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
