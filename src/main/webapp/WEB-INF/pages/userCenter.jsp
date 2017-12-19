<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<jsp:include page="webHEAD.jsp"></jsp:include>

<body>
	<div align="center">
		<h1>用戶中心</h1>
		<h3 style = " color : blue; ">用户名：${user.username}</h3>
		
		<a href="/userinf/toUpload.do">
	<img src="/resource/image/${user.username}.png" width="80px" height="80px"
	onerror="javascript:this.src='/resource/image/zz.png';"/>
		</a>
		<br/>
		<a href="http://127.0.0.1:8080">》》》注銷》》》</a> 
				<br/>
				<br/>
		      	<br/>
	
		我的博文  <button onclick="writeBlog();">写博客</button><br/> 	
	<!-- 	
		
		<a href="/bankCard/toOpenaccount.do">開戶</a> 
		<a href="/user/upLoadIMG.do">上传照片</a>
		<a href="/user/tochangePSW.do">修改密码</a>
		<br /> --------------------------------- -->
		
		<table id="blogTable"></table>
		<span id="current"></span>
		<br/>
		<button onclick="goFirst();">首页</button>
		<button onclick="ahead();">前一頁</button>
		<button onclick="next();">后一頁</button>
		<button onclick="goLast();">末頁</button>

	</div>

</body>
<script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/js/json2.js"></script>

<script type="text/javascript">
var currentPage = 1;
var total = 1;

function next() { 
	if(currentPage >= total){
		return false;
	}
	currentPage = parseInt(currentPage) + 1;
	
	loadBlogList();
}

function goFirst() { 
	currentPage = 1;
	
	loadBlogList();
}

function goLast() {
	if(total <= 0){
		return;
	}
	currentPage = total;
	
	loadBlogList();
}

function ahead() { 
	if(currentPage == 1){
		return false;
	}
	currentPage = parseInt(currentPage) - 1;
	
	loadBlogList();
}

function toModify(id) {	
	window.location.href='/blog/toModify.do?id=' + id;
}

function deleteBlog(id) {
	window.location.href='/blog/delete.do?id=' + id;
}

function writeBlog() {
	window.location.href='/blog/toWrite.do?';
}

function callback(data,status){	

	var AjaxDto = data;
	if(AjaxDto.flag){
		var result = AjaxDto.data.obj;
		total = AjaxDto.data.pagesNum;

		var msg = '<tr><td >id</td><td >文章标题</td><td>修改时间</td><td>操作</td></tr>';
		
		for (var i = 0; i < result.length; i++) {
			msg += '<tr>';
			msg += '<td>' + result[i].blogid + '</td>  '
			msg += '<td>' + result[i].title + '</td>  '
			msg += '<td>' + new Date(result[i].modifytime).toLocaleString() + '</td>   '
			msg += '<td>' 
			msg += '<button onclick="toModify('+ result[i].id +');">修改</button>  ';
			msg += '<button onclick="deleteBlog('+ result[i].id +');">删除</button>  ';
			msg += '</td>'
			msg += '</tr>';
		}
		
		var pageNum = currentPage + '/' + total

		$('#blogTable').html(msg);
		$('#current').html(pageNum);

	}else{
		if(AjaxDto.statusCode == 302){
			alert(AjaxDto.message);
			window.location.href='/user/toLogin.do';
		}
		alert("數據異常，請聯係客服，電話：10086");
	}
}

function loadBlogList(){	
	var bloglist = {
			currentPage : currentPage
	};
	
	$.post('/user/loadBlogList.do',bloglist,callback);
	
}

$(document).ready(function(){
	loadBlogList();
});


</script>

<jsp:include page="webFOOT.jsp"/>
</html>