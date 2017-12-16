<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<title>博客系统</title>

</head>

<body bgcolor="#DC8349  ">
<div align="center">
<h1>登陆</h1>
		
	
			
			<% 
				request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
			%>

</body>

<script type="text/javascript">
</script>


</html>