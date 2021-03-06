var Utils = {
	/**
	 * 通用的事件添加方法
	 * @param elm 元素
	 * @param type 事件名
	 * @param handler 事件处理函数
	 * @returns {*}
	 */
	//
	on: function(elm, type, handler) {
		// 添加事件
		return elm.attachEvent ? elm.attachEvent("on" + type, handler) : elm.addEventListener(type, handler, false);
	},

	/**
	 * 校验字符串是否为空
	 * @param str 被校验字符串
	 * @returns {boolean}
	 */
	strIsBlank: function(str) {
		if (typeof str === "string") {
			if (str.trim() == "") return true;
		} else {
			throw "参数类型不正确:" + typeof str;
		}
		return false;
	},

	/**
	 * 发送请求
	 * @param method:方法名get、post
	 * @param params:参数FormData,json对象
	 * @param url：访问地址
	 * @param callback：回调函数
	 * @param isAsync:异步true，同步false
	 * @param processData:参数数FormData类型无需解析false，默认true需解析参数
	 * @param contentType:参数数FormData类型无需设置contentType，默认true需设置contentType
	 * @param dataType:xml,默认json
	 */
	async: function(method, params, url, callback, isAsync ,dataType,processData, contentType) {
		//1. 创建异步对象
		var xhr = createXHR();

		//2. 设置状态改变的监听 回调函数.
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				if ("xml" == dataType) {
					var result = xhr.responseXML;
					callback(result);
				}
				try {
					//var result = JSON.parse(xhr.responseText);//解析json字符串
					var result = eval('(' + xhr.responseText + ')'); //解析json字符串
					callback(result);
				} catch (e) {
					var result = xhr.responseText;
					callback(result);
				}
			}
		}

		//3. 规定请求的类型，URL，请求是否应该进行异步处理，
		xhr.open(method, url, isAsync);
		
		//初始化其他设置
		var data=initXHR(xhr,params,processData,contentType,dataType);
		if (method.toUpperCase() == "GET") {
			//4. 发送请求到服务器。
			xhr.send();
		} else if (method.toUpperCase() == "POST") {
			xhr.send(data);

		}
	},

	/**
	 * 设置cookie
	 * @param cname cookie名
	 * @param cvalue cookie值
	 * @param exdays cookie存在多少天
	 */
	setCookie: function(cname, cvalue, exdays) {
		const d = new Date();
		d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
		const expires = "expires=" + d.toGMTString();
		document.cookie = cname + "=" + cvalue + "; " + expires+";path=/";// path 参数告诉浏览器 cookie 的路径。默认情况下，cookie 属于当前页面
	},

	/**
	 * 通过cookie名获取cookie值
	 * @param cname cookie名
	 * @returns {string}
	 */
	getCookie: function(cname) {
		const name = cname + "=";
		const ca = document.cookie.split(';');
		for (var i = 0; i < ca.length; i++) {
			var c = ca[i].trim();
			if (c.indexOf(name) == 0) {
				return c.substring(name.length, c.length);
			}
		}
		return "";
	},
}

/**
 * 创建异步对象
 */
function createXHR() {
	let xhr = null;
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
	return xhr;
}

function initXHR(xhr,params,processData,contentType,dataType){
	let data = null;
	if(typeof dataType!='undefined'){
		dataType = dataType.toLowerCase()
	}else {
		dataType = 'json';
	}
	if (typeof processData=='undefined') processData=true;
	if (typeof contentType=='undefined') contentType=true;
	
	if (processData&&contentType){
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		if ("xml" == dataType) {
			xhr.overrideMimeType('application/xml');
		}else if("json" == dataType){
			data="";
			for(var key in params){
				data+=key+"="+params[key]+"&"
			}
		}		
	}else {
		data=params;
	}	
	return data;
}

function convert_FormData_to_json(formData) {
	const objData = {};
	for (const entry of formData.entries()) {
		objData[entry[0]] = entry[1];
	}
	return objData;
};
