<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文件上传与下载</title>
<script type="text/javascript" src="../../js/utils.js"></script>
<style type="text/css">
	.form-sub1 {
		margin-top: 10px;
		margin-bottom: 10px;
	}
</style>
</head>
<body>
	<a href="/JavaEE/file/0.jpg" download="0.jpg">超链接下载图片0.jpg</a>
	<br>
	<a href="/JavaEE/file?filename=0.jpg">手动设置下载0.jpg</a>
	<form action="/JavaEE/file?method=uploadFile" method="post" enctype="multipart/form-data" onsubmit="return uploadFile();" id="uploadFileForm">
		<div class="form-sub1">
			<label for="file">选择文件:</label>
			<input type="file" name="file" value="" id="file"/>
		</div>
		<div class="form-sub1">
			<label for="file">input未设置name,在提交表单时不会提交该input：例</label>
			<input type="text" name="" value=""/>
		</div>
		<div class="form-sub1">
			<input type="submit" value="提交"/>
		</div>
	</form>
	<script type="text/javascript">
	Utils.on(document.getElementById("file"),"change",function(){//type="file"时，文件名一致，位置不一致也会被监听到
		window.alert("文件改变啦");
	});
	function uploadFile() {
		var formData = new FormData(document.getElementById("uploadFileForm"));
		Utils.async("post", formData, "/JavaEE/file?method=uploadFile", function(data) {
			if(200!=data.code){
				window.alert(data.msg);
			}else{
				window.alert(data.msg);
				
			}
		}, false, 'json',false,false);	
		return false;
	} 
	</script>
</body>
</html>