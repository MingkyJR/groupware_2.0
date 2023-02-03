<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resource/css/bootstrap.css">
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<style></style>
<script>
	$(document).ready(function(){
	});//
</script>
<title>Main페이지</title>
</head>
<body>
 	
<% System.out.println("메인페이지");  %>


	<c:if test="${! empty AUTHUSER}">
		${AUTHUSER}님, 안녕하세요 <br/>
		AUTHUSER = ${AUTHUSER}
		<a href="/logout.do">로그아웃</a>
		 	 
	</c:if>
	
	
	
	<a href="mypageForm.jsp">마이페이지</a>
	
<script type="text/javascript" src="/resource/js/bootstrap.js"></script>
</body>
</html>