<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="description" content="member board Web Application">
<meta name="keywords" content="member, board, article, mvc">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath()%>/assets/css/font-awesome.css">
<link rel="stylesheet"	href="<%=request.getContextPath()%>/assets/css/templatemo-hexashop.css">
<link rel="stylesheet"	href="<%=request.getContextPath()%>/assets/css/owl-carousel.css">
<link rel="stylesheet"	href="<%=request.getContextPath()%>/assets/css/lightbox.css">
</head>
<body>
	<script		src="<%=request.getContextPath()%>/assets/js/jquery-2.1.0.min.js"></script>
	<!-- Bootstrap -->
	<script src="<%=request.getContextPath()%>/assets/js/popper.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>
	<!-- Plugins -->
	<script src="<%=request.getContextPath()%>/assets/js/owl-carousel.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/accordions.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/datepicker.js"></script>
	<script	src="<%=request.getContextPath()%>/assets/js/scrollreveal.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/waypoints.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/jquery.counterup.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/imgfix.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/slick.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/lightbox.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/isotope.js"></script>
	<!-- Global Init -->
	<script src="<%=request.getContextPath()%>/assets/js/custom.js"></script>
</head>
<body>
	<%@ include file="./../module/top00.jsp"%>
	<!-- ***** Contact Area Starts ***** -->
	<section class="our-services">
		<div class="container">
			<div class="row">
				<div class="col-lg-5">
					<div class="service-item">
						<div id="map">
							<iframe
								src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d50626.28931655576!2d126.95279775413661!3d37.52812429931103!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357c989a38890123%3A0x8a8d7c332f9d03aa!2z7KSR7JWZ7KCV67O06riw7Iig7J247J6s6rCc67Cc7JuQ!5e0!3m2!1sko!2skr!4v1675785604795!5m2!1sko!2skr"
								width="100%" height="600px" style="border: 0;"></iframe>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="service-item">
						<div class="section-heading">
							<h2>마음의 소리</h2>
							<br> <span>사내에 불미스러운 일과 직접적으로 말할 수 <br> 없는 이야기를 사장님과 직접
								상담하세요</span>
						</div>

						<form method="post" action="SendProcess.jsp">
							<table>
								<tr>
									<td><strong>보내는 분</strong> <br>
									<input type="text" name="from" value="" /></td>
								</tr>
								<tr>
									<td><strong>사장님</strong> <br> <input type="text"
										name="to" value="ehdgydi@naver.com" />
								</tr>
								<tr>
									<td><strong>제목 </strong><br> <input type="text"
										name="subject" size="25" value="" />
								</tr>
								<tr>
									<td><strong>내용 </strong><br>
									<textarea name="content" cols="30" rows="10"></textarea></td>
								</tr>
								<tr>
									<td>
										<button type="submit" class="main-dark-button">
											<i class="fa fa-paper-plane"></i>
										</button>
									</td>
								</tr>
							</table>
							<input type="hidden" name="format" value="text" />
						</form>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="service-item"><br>
						<h2>
							<Strong>CEO</Strong>
						</h2>
						<br> <br> <br>
						<ul>
							<li><strong>주소></strong><br>
							<p>종로구, 249번지 24</p></li>
							<li><strong>전화번호></strong><br>
								<p>010-020-0340</p></li>
							<li><strong>사무실위치></strong><br>
								<p>6층 사장실</p></li>
							<li><strong>근무시간></strong><br>
								<p>08:30 AM - 5:30 PM</p></li>
							<li><strong>Email></strong><br>
								<p>info@company.com</p></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="./../module/bottom00.jsp"%>
</body>
</html>






