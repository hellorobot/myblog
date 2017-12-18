<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<jsp:include page="webHEAD.jsp"></jsp:include>

<body>
	<div align="center">
		<h1>Modify Blog</h1>

		<h3 style="color: blue;">用户名：${user.username}</h3>
		<a href="/user/toUserCenter.do">>>返回>></a> <br /> <br /> <br />
		我的博文 <br />

		<form id="blog" method="post">
		<input type="hidden" id="id" >
			标题 ：<input type="text" id="title" > <br /> <br />
			博文 ：<input type="text" id="content" style="height:200px;width:600px;padding-left:5px;" value="${blog.content}"> 
			
			<!--  <textarea rows="5" style="width: 500px; padding-left: 5px;"
				id="context"></textarea>-->
			<br />
			<button onclick="modify();">提交</button>
			<br />
		</form>

		<br />
	</div>

</body>
<script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/js/json2.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	load();
});

function load(){
	$.post("/blog/modifyLoad.do",{
		id : ${id}
	},function(data,status){
		var ajaxDto =  data;
		
		if(ajaxDto.flag){
			$('#title').val(ajaxDto.data.title);
			$('#content').val(ajaxDto.data.content);		
		}else{
			alert(ajaxDto.message);
		}
	});
}

function modify(){
	var blog = {
			 title:$('#title').val() ,
			 content:$('#content').val(),
			 id:$('#id').val()
	};
// 	alert( $('#title').val());
// 	alert($('#context').val());
	
	$.post("/blog/modify.do",blog,function(data,status){
		var ajaxDto =  data;
		
		if(ajaxDto.flag){
			alert(ajaxDto.message);
			
			window.location.href='/user/toUserCenter.do';
			
		}else{
			alert(ajaxDto.message);
		}
	});
}

</script>

<jsp:include page="webFOOT.jsp" />
</html>