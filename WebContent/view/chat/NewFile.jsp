<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
  <meta name="description" content="member board web Application">
  <meta name="keywords" content="member, board, article, mvc">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" 	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.0/normalize.min.css" />
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<title> title </title>
	<style>
		@font-face {
	font-family: "CookieRun-Regular";
	src:
		url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/CookieRun-Regular.woff")
		format("woff");
	font-weight: normal;
	font-style: normal;
}
* {
	font-family: "CookieRun-Regular";
}

body {
	width: 510px;
	margin: 0 auto;
}
header {
	background: Salmon;
}
#content {
	overflow: hidden;
}
section {
	float: right;
	width: 350px;
	background: Khaki;
}
aside {
	float: left;
	width: 150px;
	height:600px;
	background: LightGreen;
}
footer {
	background: SkyBlue;
}
	</style>
</head>
<body>
<header>헤더</header>
<div id="content">
	<section>
		<p>본문 내용 ...</p>
		<p>본문 내용 ...</p>
		<p>본문 내용 ...</p>
	</section>
	<aside>사이드바</aside>
</div>
<footer>푸터</footer>
	
		<script>
	</script>
</body>
</html>