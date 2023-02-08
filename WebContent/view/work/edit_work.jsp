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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/work/work.css">
    
</head>
<body>
<%@ include file="../module/top00.jsp" %>

<div class="container" style="margin-top: 10px;">
  <div class="row">
  	<!-- 출퇴근 버튼, 정보 영역 -->
    
    <!-- 월별 누적 근태현황 -->
   
    <div class="col total">
    <h2>출퇴근 수정 요청</h2>
      <div class="page">
      <h2>
      <a href="workEdit.do?pageMon=${pageAtt.mon - 1}&pageYear=${pageAtt.year}"><img src="/assets/icon/chevron-left.svg" class="chevron"></a>
      <span>${pageAtt.year}.${pageAtt.mon}</span>
      <a href="workEdit.do?pageMon=${pageAtt.mon + 1}&pageYear=${pageAtt.year}"><img src="/assets/icon/chevron-right.svg" class="chevron"></a>
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
      <th></th>
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
      <td>
      <c:if test="${month.work_status eq '근태이상'}">
      <a href="writeEdit.do?date=${month.work_reg_date}&empNo=${AUTHUSER.emp_no}&inTime=${month.work_in_time}"><img src="/assets/icon/pencil-square.svg"></a>
      </c:if>
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






