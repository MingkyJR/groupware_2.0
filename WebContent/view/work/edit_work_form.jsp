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
 <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
 <title>출퇴근 수정 요청</title>
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
    <%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/work/work.css"> --%>
    <style>
    th{
    background-color: #f2f7ff;
    }
    </style>

</head>
<body>
<%@ include file="../module/top00.jsp" %>

<form method="post">
<div class="container" style="margin-top: 10px;">
	<div class="row">
	 <div class="col">
	 <h3 style="border-bottom: solid black; padding-bottom: 5px;">출퇴근 수정요청</h3>
	 <h4 style="padding-bottom: 10px; padding-top: 25px;">조정 정보</h4>
		<table class="table table-bordered">
		  <tbody>
		    <tr>
		      <th scope="row">근무일</th>
		      <td>${date}</td>
		    </tr>
		    <tr>
		      <th scope="row">수정요청 시간</th>
		      <td><input type="time" name="newInTime" value="${inTime}" min="08:30" max="18:00"> ~ <input type="time" name="newOutTime"></td>
		    </tr>
		    <tr>
		      <th scope="row" style="line-height: 252px;">사유</th>
		      <td><textarea name="reason" rows="10" style="width: 100%; resize: none;"></textarea></td>
		    </tr>
		  </tbody>
		</table>
		<input type="hidden" name="date" value="${date}">
		<input type="submit">
	 </div>
	</div>
</div>
</form>

<%@ include file="../module/bottom00.jsp" %>
</body>
</html>






