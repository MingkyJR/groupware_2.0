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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
	body {
		font-family: Arial;
	}
	div.second_container{
		width: 950px;
		margin: 0 auto;
		padding: 0 auto;
	}
	
	div.gallery {
		display: inline-block;
		margin: 20px 30px;
		border: 1px solid #ccc;
		overflow: hidden;
		border-radius: 10px;
		width: 250px;
	}
	
	div.gallery:hover {
		border: 1px solid #777;
	}
	
	div.gallery img {
		width: 100%;
		height: 270px;
	}
	div.desc {
		padding: 10px;
		text-align: center;
	}
	.second_pagination {
  		text-align: center;
  		margin: 20px 0 40px 0;
	}
	.second_pagination a {
		color: black;
		padding: 8px 16px;
		text-decoration: none;
	}
	.second_pagination a:hover {
		background-color: #ddd;
		border-radius: 5px;
	}
	.example input[type=text] {
		padding: 10px;
		font-size: 17px;
		border: 1px solid grey;
		width: 60%;
		background: #f1f1f1;
	}
	.example button {
		width: 8%;
		padding: 10px;
		background: #505D93;
		color: white;
		font-size: 17px;
		border: 1px solid grey;
		border-left: none;
		cursor: pointer;
	}
	.example button:hover {
		background: #788AD0;
	}
	.btnRegi {
		margin: 10px;
		color: white;
		padding: 12px 20px;
		border: none;
		border-radius: 4px;
		cursor: pointer;
		background-color: #ebad34;
	}

	.btnRegi:hover {
		background-color: #ffc500;
	}
</style>
</head>
<body>
<%@ include file="../module/top00.jsp" %>

	<div class="second_container">	<button class="btnRegi">
	<a href="registe.do" style="text-decoration: none; color: white;">게시글 등록</a></button>
	<form class="example" action="<%=request.getContextPath()%>/secondHand/searchList.do" style="text-align: center; margin: 15px 0;">
		<input type="text" placeholder="Search.." name="keyword">
		<button type="submit"><i class="fa fa-search"></i></button>
	</form>
	<c:forEach var="dto" items="${list}">
		<div class="gallery">
	  		<a href="<%=request.getContextPath()%>/secondHand/content.do?no=${dto.no}&views=${dto.views}&currentPage=${pageDTO.currentPage}&price=${dto.price}">
	  		<c:if test="${dto.refileName!=null}">
	    		<img src="<%=request.getContextPath()%>/secondHand/imageOut.do?reFileName=${dto.refileName}" alt="Cinque Terre" width="600" height="400">
	    	</c:if>
	    	<c:if test="${dto.refileName==null}">
	    		<img src="<%=request.getContextPath()%>/secondHand/imageOut.do?reFileName=no_image.jpg" alt="Cinque Terre" width="600" height="400">
	    	</c:if>	
	 		</a>
		<div class="desc">${dto.title}</div>
		<div class="desc">${dto.price}원</div>
		<div class="desc">조회수 ${dto.views}</div>
		</div>
	</c:forEach>
	<div class="second_pagination">
		<c:if test="${ pageDTO.startPage>1 }">
			<a href="<%=request.getContextPath()%>/secondHand/list.do?pageNo=${ pageDTO.startPage - 1 }&keyword=${keyword}">&laquo;</a>
		</c:if>
		<c:forEach var="pageNum" begin="${ pageDTO.startPage }" end="${ pageDTO.endPage }">
			<span><a href="<%=request.getContextPath()%>/secondHand/list.do?pageNo=${ pageNum }&keyword=${keyword}">${ pageNum }</a></span>
		</c:forEach>
		<c:if test="${ pageDTO.endPage<pageDTO.realEndPage }">
			<a href="<%=request.getContextPath()%>/secondHand/list.do?pageNo=${ pageDTO.endPage + 1 }&keyword=${keyword}">&raquo;</a>
		</c:if>
	</div>
	</div>
<%@ include file="../module/bottom00.jsp" %>
</body>
</html>





