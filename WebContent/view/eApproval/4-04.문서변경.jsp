<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
 <meta charset="UTF-8">
 <meta name="description" content="member board Web Application">
 <meta name="keywords" content="member, board, article, mvc">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title></title>
 <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/font-awesome.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/templatemo-hexashop.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/owl-carousel.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/lightbox.css">
     </head>
    
    <body>
    <script src="<%=request.getContextPath()%>/assets/js/jquery-2.1.0.min.js"></script>

    <!-- Bootstrap -->
    <script src="<%=request.getContextPath()%>/assets/js/popper.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>

    <!-- Plugins -->
    <script src="<%=request.getContextPath()%>/assets/js/owl-carousel.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/accordions.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/datepicker.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/scrollreveal.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/waypoints.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/jquery.counterup.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/imgfix.min.js"></script> 
    <script src="<%=request.getContextPath()%>/assets/js/slick.js"></script> 
    <script src="<%=request.getContextPath()%>/assets/js/lightbox.js"></script> 
    <script src="<%=request.getContextPath()%>/assets/js/isotope.js"></script> 
    
    <!-- Global Init -->
    <script src="<%=request.getContextPath()%>/assets/js/custom.js"></script>

</head>
<body>
<!-- <style>
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
div {
	padding: 10px;
	box-shadow: 0px 0px 5px 0px gray;
	width: 90%;
}
	</style>
	<script>
	$(document).ready(function)(){
		
	});//끝
	</script> -->
</head>
<body>
<%--DeleteArticleHandler2 컨트롤러를 거쳐오면 다음과 같은 모델을 받는다
		int cnt: 삭제(update)된 행 수 1 이면 삭제성공  ,0이면 실패
			request.setAttribute("cnt", cnt);  
		--%> 
	<h2>변경</h2>
	<hr/>
	<p>1 이면 변경성공  ,0이면 실패</p>
	${cnt}
	${cnt1}
	${cnt2}
	
	${conPath}/document/ListDocument.do"
	<c:if test="${cnt eq 1}">
	<script>
		alert("삭제성공");
	</script>
		</c:if>
		
			<c:if test="${cnt1 eq 1}">
	<script>
		alert("반려");
	</script>
		</c:if>
			<c:if test="${cnt2 eq 1}">
	<script>
		alert("승인성공");
	</script>
		</c:if>
	
	<script>
		location.href= ${conPath}"/document/listDocument.do";
	</script>

</body>
</html>






