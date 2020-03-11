<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ç»å½</title>
		<style type="text/css">
			.form-sub1 {
				margin-top: 10px;
				margin-bottom: 10px;
			}
		</style>
		<script type="text/javascript" src="./js/utils.js"></script>
	</head>
	<body>
		<form action="/JavaEE/user?method=login" method="post" id="loginForm" onsubmit="return checkUser()">
			<div class="form-sub1" id="check-username">
				<label for="username">ç¨æ·åï¼</label>
				<input type="text" required="required" name="username" value="" id="username" />
			</div>
			<div class="form-sub1">
				<label for="password">ç»å½å¯ç ï¼</label>
				<input type="password" required="required" name="password" value="" id="password" />
			</div>
			<div class="form-sub1">
				<input id="input2" type="checkbox" name="autologin" value="1" /><label for="input2">èªå¨ç»å½</label>
				<input id="input1" type="checkbox" name="persis" value="1" /><label for="input1">è®°ä½å¯ç </label>
			</div>
			<a href="/JavaEE/regist.html"><label>æ³¨å</label></a>
			<div class="form-sub1">
				<input type="submit" value="æäº¤" />
			</div>
		</form>
		<script type="text/javascript">
			//å¼æ­¥æ ¡éªç¨æ·åæ¯å¦å­å¨
			Utils.on(document.getElementById("username"), "blur", function() {
				var node = '';
				if (Utils.strIsBlank(this.value)) {
					node = document.createTextNode("è¯·è¾å¥æ­£ç¡®çç¨æ·åã");
					checkNameTip(node);
				} else {
					//å¼æ­¥æ ¡éª
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
				//å¼æ­¥æ ¡éª
				Utils.async("post", formData, "/JavaEE/user?method=checkUserLogin", function(data) {
					if (200 != data.code) {
						flag = false;
						window.alert(data.msg);
					}
				}, false, 'json',false,false);
				return flag;
			}

			Utils.on(document.getElementById("input2"), "change", function() {
				if (this.checked) {
					document.getElementById("input1").checked = "checked";
				}
			});

			function checkNameTip(node) {
				//åå»ºåç´ ï¼å¹¶æ¾ç¤º
				var newSubE = document.createElement("b");
				newSubE.style = 'color: red;';
				newSubE.appendChild(node);

				var parentE = document.getElementById("check-username");
				var exitSubE = document.getElementById("username");
				parentE.appendChild(newSubE, exitSubE);

				//1så é¤æ°åå»ºçåç´ 
				setTimeout(function() {
					parentE.removeChild(newSubE);
				}, 1500);
			}
		</script>
	</body>
</html>
