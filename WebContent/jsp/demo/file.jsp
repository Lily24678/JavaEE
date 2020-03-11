<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>æä»¶ä¸ä¼ ä¸ä¸è½½</title>
<script type="text/javascript" src="./js/utils.js"></script>
<style type="text/css">
	.form-sub1 {
		margin-top: 10px;
		margin-bottom: 10px;
	}
</style>
</head>
<body>
	<a href="/JavaEE/file/0.jpg" download="0.jpg">è¶é¾æ¥ä¸è½½å¾ç0.jpg</a>
	<br>
	<a href="/JavaEE/file?filename=0.jpg">æå¨è®¾ç½®ä¸è½½0.jpg</a>
	<form action="/JavaEE/file?method=uploadFile" method="post" enctype="multipart/form-data" onsubmit="return uploadFile();" id="uploadFileForm">
		<div class="form-sub1">
			<label for="file">éæ©æä»¶:</label>
			<input type="file" name="file" value="" id="file"/>
		</div>
		<div class="form-sub1">
			<label for="file">inputæªè®¾ç½®name,å¨æäº¤è¡¨åæ¶ä¸ä¼æäº¤è¯¥inputï¼ä¾</label>
			<input type="text" name="" value=""/>
		</div>
		<div class="form-sub1">
			<input type="submit" value="æäº¤"/>
		</div>
	</form>
	<script type="text/javascript">
	Utils.on(document.getElementById("file"),"change",function(){//type="file"æ¶ï¼æä»¶åä¸è´ï¼ä½ç½®ä¸ä¸è´ä¹ä¼è¢«çå¬å°
		window.alert("æä»¶æ¹åå¦");
	});
	function uploadFile() {
		var formData = new FormData(document.getElementById("uploadFileForm"));
		Utils.async("post", formData, "/JavaEE/file?method=uploadFile", function(data) {
			if(200!=data.code){
				window.alert(data.msg);
			}else{
				window.alert(data.msg);
				
			}
		},false, 'json',false,false);	
		return false;
	} 
	</script>
</body>
</html>