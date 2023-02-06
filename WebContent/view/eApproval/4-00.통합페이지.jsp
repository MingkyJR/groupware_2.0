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
<%@ include file="./../module/top00.jsp" %>
<div class="main-banner" id="top">


			<div
				style="border-radius: 10px; background-color: white; padding: 20px; box-shadow: 0px 0px 5px 0px gray; float: left; width: 16%; height:700px;box-sizing: border-box;">
				<!-- menu.jsp -->
				<span style="width: 100%; text-align: center;"><h2>
						<strong class="h2">결재문서</strong>
					</h2> </span>
				<hr>
				<h5 style="display: inline;">
					<strong>문서양식</strong>
				</h5>
				<select onchange="if(this.value) location.href=(this.value);">
					<option value="">선택하세요.
					<option value="<%=request.getContextPath()%>/document/writeDocument.do">기안서</option>
					<option value="4-00.통합페이지.jsp?contents=./4-08.보고서.jsp">보고서</option>
					<option value="4-00.통합페이지.jsp?contents=./4-08.품의서.jsp">품의서</option>
				</select> <br>
				<br>
				<div style="border-radius: 10px; padding: 20px; box-shadow: 0px 0px 5px 0px gray; width:90%;">
					<input class="btn1" type="button" value="기안서(일반)"><br>
					<input class="btn1" type="button" value="보고서"><br>
					<input class="btn1" type="button" value="품의서"><br>
					<input class="btn1" type="button" value="경조비지급신청서"><br>
					<input class="btn1" type="button" value="법인카드신청서"><br>
					<input class="btn1" type="button" value="불참사유서"><br>
					<input class="btn1" type="button" value="예산초과신청서"><br>
					<input class="btn1" type="button" value="재택근무보고일지"><br>
					<input class="btn1" type="button" value="휴가신청서"><br>
					<input class="btn1" type="button" value="사직서"><br>
				</div>
				<br>	<br>	<br>	<br>	<br>
			</div>

			<div style="border-radius: 10px; background-color: white; padding: 20px; box-shadow: 0px 0px 5px 0px gray; margin-left: 1%; float: left; height:700px; width: 47%; box-sizing: border-box;">
				<span style="text-align: center;"><strong class="h2">결재대기</strong> </span><hr>
					<iframe style=" width: 100%; height: 85%;" src="http://localhost/document/listSelfDocument.do"></iframe>	<br>	<br>	<br>	<br>
			</div>
			
			<div style="border-radius: 10px; background-color: white; padding: 20px; box-shadow: 0px 0px 5px 0px gray; margin-left: 1%; float: left; height:700px; width:35%; box-sizing: border-box;">
				<span style="text-align: center;"><strong class="h2">결재결과</strong> </span><hr>
					<iframe style=" width: 100%; height: 45%;" src="http://localhost/document/returnDocument.do"></iframe>
					<iframe style=" width: 100%; height: 45%;" src="http://localhost/document/passDocument.do"></iframe><br>	<br>	<br>	<br>	 
			</div>	
		</div>
		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

</body>
</html>






