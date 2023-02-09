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
<style>
body{
	background-color: #f2f2f2;
}
* {
	box-sizing: border-box;
}

input[type=text], select, textarea, input[type=number] {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	resize: vertical;
}

label {
	padding: 12px 12px 12px 0;
	display: inline-block;
}

input[type=submit] {
	background-color: #505D93;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	float: right;
}

input[type=submit]:hover {
	background-color: #45a049;
}

.second_container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}

.col-25 {
	float: left;
	width: 15%;
	text-align: center;
}

.col-75 {
	float: left;
	width: 85%;
	margin-top: 6px;
}

/* Clear floats after the columns */
.second_row:after {
	content: "";
	display: table;
	clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .col-25, .col-75, input[type=submit]{
    width: 100%;
    margin-top: 0;
  }
}
</style>
</head>
<body>
<%@ include file="../module/top00.jsp" %>
<body>
<div class="second_container">
  <form action="<%=request.getContextPath()%>/secondHand/update.do" method="post" enctype="multipart/form-data" >
  <input type="hidden" name="no" id="no" value="${no}"/>
  <div class="row">
    <div class="col-25">
      <label for="title">제목</label>
    </div>
    <div class="col-75">
      <input type="text" id="title" name="title" placeholder="제목을 입력하세요" value="${ title }" />
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="price">가격</label>
    </div>
    <div class="col-75">
      <input type="number" id="price" name="price" placeholder="가격을 입력하세요" value="${ price }" />
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="subject">내용</label>
    </div>
    <div class="col-75">
      <textarea id="content" name="content" placeholder="내용을 입력하세요" style="height:200px">${ content }</textarea>
    </div>
  </div>
  <div class="row">
	    <div class="col-25">
	      <label for="subject">이미지파일</label>
	    </div>
	    <div class="col-75">
	      <input type="file" name="fileName" style="padding-top: 6px;" />
	    </div>
	  </div>
  <div class="second_row">
    <input type="submit" value="수정">
  </div>
  </form>
</div>
<%@ include file="../module/bottom00.jsp" %>
</body>
</html>





