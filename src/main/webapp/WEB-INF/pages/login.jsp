<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<jsp:include page="webHEAD.jsp"></jsp:include>

<body >
<div align="center">
<h1>登陆</h1>
		<br>
		<form id="flowForm" method="post">
		账号：<input type="text" id="username">
		密码：<input type="password" id="password">		
		</form>
		<br>
		<button id="login" onclick="login();">登陆</button>
		<button id="regist" onclick="toRegist();">注册</button>
		<button id="forget" >忘记密码</button>

</div>

</body>

<script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
<script type="text/javascript">

	function ajaxFunction(data,status){
		var ajaxDto =  data;
		
		if(ajaxDto.flag){
			alert("login success!");
			
			window.location.href='/user/toUserCenter.do';
			
		}else{
			alert(ajaxDto.message);
		}
	}

	function login(){
		var user = {
			username : $('#username').val(),
			password : $('#password').val()
		};
		
		$.post("/user/login.do",user,ajaxFunction);
		
	}

	function toRegist(){
		 window.location.href="/user/toRegist.do"; 
	}

</script>

<jsp:include page="webFOOT.jsp"></jsp:include>
</html>