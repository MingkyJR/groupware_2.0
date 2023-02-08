<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html lang="ko">
<head>
 <meta charset="UTF-8">
 <meta name="description" content="member board Web Application">
 <meta name="keywords" content="member, board, article, mvc">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
 <title>근태관리</title>
 <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/font-awesome.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/templatemo-hexashop.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/owl-carousel.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/lightbox.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/work/work.css">
 <script>
  $(document).ready(function(){
	  });
 
 	function confirmIn() {
 		var dd = new Date();
 		var dhur = dd.getHours();		// 시
		var dmin = dd.getMinutes();	//분
		var dsec = dd.getSeconds();	//초
		var dtime = +dhur+":"+dmin+":"+dsec
 		if(window.confirm("현재시간 : "+dtime+" 입니다. 출근하시겠습니까?")){
 			location.href = '/workIn.do';
 		}else{};
 	}
 	
 	function confirmOut() {
 		var dd = new Date();
 		var dhur = dd.getHours();		// 시
		var dmin = dd.getMinutes();	//분
		var dsec = dd.getSeconds();	//초
		var dtime = +dhur+":"+dmin+":"+dsec
 		if(window.confirm("현재시간 : "+dtime+" 입니다. 퇴근하시겠습니까?")){
 			location.href = '/workOut.do';
 		}else{};
 	}
 	
 	
 </script>
    
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
    
    <script type="text/javascript" src="/assets/js/work/time.js?ver=<%=System.currentTimeMillis()%>"></script>
     </head>
    

<body id="bd" onload="getTime()">
<%@ include file="../module/top00.jsp" %>

<div class="container" style="margin-top: 10px;">
  <div class="row">
  	<!-- 출퇴근 버튼, 정보 영역 -->
    <div class="col-md-3 inOut mr-2">
			<p>${AUTHUSER.emp_kname} 님, 안녕하세요</p>
			<p id="WhatDateIsItNow" class="date2"></p>
			<p id="WhatTimeIsItNow" class="time2"></p>
			<p>현재 [${work.status}]상태입니다</p>
			<p>
				<span class="ioText">출근시간</span>
				<span class="fmt_time">
					<c:if test="${work.work_in_time eq null}">미등록</c:if>
					<fmt:formatDate type="date" value="${work.work_in_time}" pattern="kk:mm:ss"/></span></p>
			<p>
				<span class="ioText">퇴근시간</span>
				<span class="fmt_time">
					<c:if test="${work.work_out_time eq null}">미등록</c:if>
					<fmt:formatDate type="date" value="${work.work_out_time}" pattern="kk:mm:ss"/></span></p>
			<hr/>
			<div class="find-btn">
			<c:if test="${work.work_in_time eq null}">
			<button type="button" class="btn btn-info find-btn1" onclick="confirmIn()">출근</button>
			<button type="button" class="btn btn-outline-info find-btn1" onclick="confirmOut()">퇴근</button></c:if>
			<c:if test="${not empty work.work_in_time}"><button type="button" class="btn btn-outline-info find-btn1" onclick="confirmIn()">출근</button></c:if>
			<c:if test="${work.work_out_time eq null && not empty work.work_in_time}"><button type="button" class="btn btn-info find-btn1" onclick="confirmOut()">퇴근</button></c:if>
			<c:if test="${not empty work.work_out_time}"><button type="button" class="btn btn-outline-info find-btn1" onclick="confirmOut()">퇴근</button></c:if>
			
			</div>
    </div>
    <!-- 월별 누적 근태현황 -->
  
   
    <div class="col-md-8 total">
      <h3>누적 근태현황</h3> 
      <div class="page">
      <h2>
      <a href="work.do?pageMon=${pageAtt.mon - 1}&pageYear=${pageAtt.year}"><img src="/assets/icon/chevron-left.svg" class="chevron"></a>
      <span>${pageAtt.year}.${pageAtt.mon}</span>
      <a href="work.do?pageMon=${pageAtt.mon + 1}&pageYear=${pageAtt.year}"><img src="/assets/icon/chevron-right.svg" class="chevron"></a>
      </h2>
      </div>
    <table class="table">
  <thead>
    <tr>
      <th scope="col">일자</th>
      <th scope="col">업무시작</th>
      <th scope="col">업무종료</th>
      <th scope="col">근무시간</th>
      <th scope="col">초과시간</th>
      <th scope="col">상태</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="month" items="${monthList}">
  	<tr>
      <th scope="row"><fmt:formatDate type="date" value="${month.work_reg_date}" pattern="dd [E]" /></th>
      <td><fmt:formatDate type="date" value="${month.work_in_time}" pattern="kk:mm:ss"/></td>
      <td><fmt:formatDate type="date" value="${month.work_out_time}" pattern="kk:mm:ss"/></td>
      <td><c:if test="${not empty month.work_out_time}">${month.total_day}</c:if></td>
      <td>${month.overtime}</td>
      <td>
      <c:if test="${month.work_status eq '근태이상'}">
      <span class="work_status ws1">${month.work_status}</span>
      </c:if>
      <c:if test="${month.work_status eq '정상처리'}">
      <span class="work_status ws2">${month.work_status}</span>
      </c:if>
      <c:if test="${month.work_status eq '요청중'}">
      <span class="work_status ws3">${month.work_status}</span>
      </c:if>
      </td>
      </td>
    </tr>
  	</c:forEach>
  </tbody>
</table>
    </div>
  </div>
</div>

<%@ include file="../module/bottom00.jsp" %>
</body>
</html>






