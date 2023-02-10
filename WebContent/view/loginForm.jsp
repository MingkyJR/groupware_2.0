<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>login</title>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<link rel="stylesheet" type="text/css" href="/assets/css/loginStyle.css">
<style></style>
<script>
	$(document).ready(function(){
		
	});//
</script>

</head>
<body>
		<div id="header">
		</div>
		<div id="container">
			<div id="aside">
				<img id="img" src="/assets/images/login_img.png">
			</div>
		<form action="/login.do" method="post">
			<div class="contents">
				<h2>Greeting</h2>
				<label>
				<span>ID</span><br/>
				<input type="text" name="emp_id" id="emp_id" value="${param.emp_id}"/>
				<span class="error"><c:if test="${errors.emp_id}">ID를 입력하세요</c:if></span>
				</label>
				<br/>
				<label>
				<span>PASSWORD</span><br/>
				<input type="password" name="emp_pw" id="emp_pw"/>
				<span class="error"><c:if test="${errors.emp_pw}">암호를 입력하세요</c:if> </span>
				<span class="error"><br/><c:if test="${errors.idOrPwNotMatch}">아이디와 패스워드가 일치하지 않습니다</c:if></span>
				</label>
				<br/>
				<button type="submit" class="login">Log In</button>
				<button type="button" class="signup" onclick="location.href='/join.do';">Sign Up</button>
			</div>
		</form>
		</div>
		
		<div id="footer">
		</div>


</body>
</html>