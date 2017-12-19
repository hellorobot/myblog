<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<title>blog</title>

</head>

<body>

<h1>上传头像</h1>

	<form method="POST" enctype="multipart/form-data" action="/userinf/uploadImg.do">
	  上传头像：<input type="file"  name="upfile" ><br/>
	  <br/>
	  <input type="submit" value="上传">
	</form>

</body>

<script type="text/javascript">
	
</script>


</html>