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
 <title>수정 요청 목록</title>
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
    <!-- 월별 누적 근태현황 -->
    <div class="col total">
      <h3>출퇴근 수정 요청 목록</h3> 
      <div class="page" style="text-align: right; margin-bottom: 10px;">
      <form action="editList.do" method="post">
      <p class="empNoInput">
      	 사원이름 : <input type="text" name="emp_name" size="5"> <button type="submit" style="border: 1px solid;">조회</button>
      </p>
      <%-- <p class="empNoInput"><c:if test="${errors.empNo}">조회할 사원 이름을 입력해주세요</c:if></p> --%>
      </form>
      </div>
    <table class="table">
  <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">요청일자</th>
      <th scope="col">근무일</th>
      <th scope="col">요청자</th>
      <th scope="col">사원번호</th>
      <th scope="col">수정요청 시간</th>
      <th scope="col">상태</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="edit" items="${editList}">
  	<tr>
  		<td>${edit.edit_num}</td>
      <td><fmt:formatDate type="date" value="${edit.edit_req_date}" pattern="YYYY.MM.dd kk:mm:ss"/></td>
      <td><fmt:formatDate type="date" value="${edit.reg_date}" pattern="YYYY.MM.dd"/></td>
      <td>${edit.emp_name}</td>
      <td>${edit.emp_no}</td>
      <td>
      <fmt:formatDate type="date" value="${edit.edit_in_time}" pattern="kk:mm"/>
       ~ 
      <fmt:formatDate type="date" value="${edit.edit_out_time}" pattern="kk:mm"/>
      </td>
      <td>
      <c:if test="${edit.edit_status eq '요청중'}">
      <span class="work_status ws3">${edit.edit_status}</span>
      </c:if>
      <c:if test="${edit.edit_status eq '수정'}">
      <span class="work_status" style="background-color: #8080ff;">${edit.edit_status}</span>
      </c:if>
      <c:if test="${edit.edit_status eq '반려'}">
      <span class="work_status" style="background-color: #f2c539;">${edit.edit_status}</span>
      </c:if>
      </td>
      <td><a href="listContent.do?num=${edit.edit_num}&emp_no=${edit.emp_no}&regDate=${edit.reg_date}">상세조회</a></td>
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






