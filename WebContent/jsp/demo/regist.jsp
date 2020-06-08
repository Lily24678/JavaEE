<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>注册</title>
<link rel="stylesheet" href="/JavaEE/bootstrap/css/bootstrap.min.css">
<script src="/JavaEE/bootstrap/jquery-1.11.3.min.js"></script>
<script src="/JavaEE/bootstrap/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<!-- 顶部内容 -->
		<%@ include file="head.jsp" %>

		<!-- 主体内容 -->
		<div class="container-fluid">
			<div class="container-fluid"
				style="width: 97.8%; background: url('/JavaEE/img/regist_bg.jpg');">
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-8"
						style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
						<font size="4">会员注册</font>&nbsp;&nbsp;USER REGISTER
						<form action="/JavaEE/user?method=login" method="post"
							id="registForm" onsubmit="return checkUserTip();"
							class="form-horizontal" style="margin: 15px 0 0 0;">
							<div class="form-group">
								<label for="username" class="col-sm-2 control-label">用户名</label>
								<div class="col-sm-6" id="check-username">
									<input type="text" name="username" required="required"
										id="username" class="form-control" placeholder="请输入用户名">
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1"
									class="col-sm-2 control-label">密码</label>
								<div class="col-sm-6">
									<input type="password" name="repassword" required="required" class="form-control"
										id="exampleInputPassword1" placeholder="请输入密码">
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword2"
									class="col-sm-2 control-label">确认密码</label>
								<div class="col-sm-6">
									<input type="password" name="password" required="required"
										class="form-control" id="exampleInputPassword2"
										placeholder="请输入确认密码">
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1" class="col-sm-2 control-label">Email</label>
								<div class="col-sm-6">
									<input type="email" name="email" class="form-control"
										id="exampleInputEmail1" placeholder="Email">
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputTel1" class="col-sm-2 control-label">Telephone</label>
								<div class="col-sm-6">
									<input type="tel" name="telephone" class="form-control"
										id="exampleInputTel1" placeholder="Email">
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputText2" class="col-sm-2 control-label">姓名</label>
								<div class="col-sm-6">
									<input type="text" name="name" class="form-control"
										id="exampleInputText2" placeholder="请输入姓名">
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputRadio1" class="col-sm-2 control-label">性别</label>
								<div class="col-sm-6">
									<input type="radio" name="sex" value="男"
										id="exampleInputRadio1" placeholder="男"><label
										for="exampleInputRadio1">男</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="sex" value="女"
										id="exampleInputRadio2" placeholder="女"><label
										for="exampleInputRadio2">女</label>
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputDate1" class="col-sm-2 control-label">出生日期</label>
								<div class="col-sm-6">
									<input type="date" name="birthday" class="form-control"
										id="exampleInputDate1" placeholder="年/月/日">
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
								<div id="tip1" style="display: none;">
									<b style="color: red;">用户名、密码不可为空</b>
								</div>							
								<div class="col-sm-offset-2 col-sm-10">
									<input type="submit" value="注册"
										style="background: url('/JavaEE/img/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-2"></div>
				</div>
			</div>
		</div>

		<!-- 底部内容 -->
		<%@ include file="foot.jsp" %>
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
					username : this.value
				}, "/JavaEE/user?method=checkNameRegist", function(data) {
					if (200 != data.code) {
						node = document.createTextNode(data.msg);
						checkNameTip(node);
					}
				}, true, 'json');
			}

		});

		//校验是否存在，存在则阻止表单提交
		function checkUserTip() {
			var flag = true;
			var formData = new FormData(document.getElementById("registForm"));
			if(formData.get("password")!==formData.get("repassword")){
				flag=false;
				alert("密码和确认密码需一致");
			}
			Utils.async("post", convert_FormData_to_json(formData),
					"/JavaEE/user?method=checkUserRegist", function(data) {
						if (200 != data.code) {
							flag = false;//阻止表单提交
							var tip1 = document.getElementById("tip1");
							tip1.style.display = "";
							tip1.innerHTML = '<b style="color: red;">'
									+ data.msg + '</b>';
							//隐藏提示
							setTimeout(function() {
								tip1.style.display = "none";
							}, 1500);
						}
					}, false, 'json');
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