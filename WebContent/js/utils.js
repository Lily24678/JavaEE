var Utils = {

	//通用的事件添加方法
	on: function(elm, type, handler) {
		// 添加事件
		return elm.attachEvent ? elm.attachEvent("on" + type, handler) : elm.addEventListener(type, handler, false);
	},

	//校验字符串是否为空
	strIsBlank: function(str) {
		if (typeof str === "string") {
			if (str.trim() == "") return true;
		} else {
			throw "参数类型不正确:" + typeof str;
		}
		return false;
	},

	//发送请求
	async: function(method, params, url, callback, isAsync) {
		//1. 创建异步对象
		var xhr;
		try { //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
			xhr = new XMLHttpRequest();
		} catch (e) {
			try { // Internet Explorer
				xhr = new ActiveXObject("Msxml2.xhr");
			} catch (e) {
				try { // IE6, IE5 浏览器执行代码
					xhr = new ActiveXObject("Microsoft.xhr");
				} catch (e) {}
			}
		}
		//2. 设置状态改变的监听 回调函数.
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				if (xhr.getResponseHeader("content-type") == "application/json") {
					var result = JSON.parse(xhr.responseText);
					callback(result);
				} else {
					callback(xhr.responseText);
				}
			}
		}
		method = method.toUpperCase();
		//3. 规定请求的类型，URL，请求是否应该进行异步处理，
		xhr.open(method, url, isAsync);
		if (method == "GET") {
			//4. 发送请求到服务器。
			xhr.send();
		} else if (method == "POST") {
			//设置发送数据的请求格式
			xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			//4. 发送请求到服务器。
			var data = '';
			for(var key in params){
				data+=key+"="+params[key]+"&";
			}
			xhr.send(data);
		}
	},


}
