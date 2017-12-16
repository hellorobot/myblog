<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<jsp:include page="/WEB-INF/pages/webHEAD.jsp"></jsp:include>

<body >
	<div align="center">
		<h1>注册</h1>
		
		<form id="flowForm" method="post">
			[账号：    	]<input type="text" id="username"> <br/>
			[密码：    	]<input type="text"id="password"> <br/>
			[重复密码：]<input type="text" id="password2"><br/>
		</form>

		<button id="regist1" onclick="regist1();">注册</button>
		
	</div>

</body>

<script type="text/javascript" src="/js/jquery-3.2.1.js"></script>

<script type="text/javascript">

function ajaxfun(data,status){
	
	var ajaxDto = data;	
	
	if(ajaxDto.flag) {
		alert("注册成功！");
		window.location.href='/';
		
	} else {
		alert(ajaxDto.message);
	}
}

	function regist1() {
		var createUser = {
			username : $('#username').val(),
			password : $('#password').val(),
			password2 : $('#password2').val(),
		};
		
		if(createUser.password!=createUser.password2){
			alert("两次密码不同，请重新输入");
			return;
		}		
		$.post('/user/regist.do',createUser,ajaxfun);
	}
	




</script>

<jsp:include page="webFOOT.jsp"></jsp:include>
</html>