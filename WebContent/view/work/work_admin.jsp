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
 <title>직원 누적 근태현황</title>
 <script src="https://code.jquery.com/jquery-2.2.4.min.js" ></script>
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
 <script>
 $(document).ready(function(){
	  });
 
 	
 </script>
</head>
<body>
	<!-- 네비 바 인클루드 -->
<%@ include file="/view/module/top00.jsp" %>		
<div class="container" style="margin-top: 10px;">
  <div class="row">
    <!-- 월별 누적 근태현황 -->
    <div class="col total">
      <h3>직원 누적 근태현황</h3> 
      <div class="page">
      <%--<h2>
      
       <a href="work_admin.do?pageMon=${pageAtt.mon - 1}&pageYear=${pageAtt.year}&empNo=${pageAtt.emp_no}"><img src="/icon/chevron-left.svg" class="chevron"></a>
      <span>${pageAtt.year}.${pageAtt.mon}</span>
      <a href="work_admin.do?pageMon=${pageAtt.mon + 1}&pageYear=${pageAtt.year}&empNo=${pageAtt.emp_no}"><img src="/icon/chevron-right.svg" class="chevron"></a>
      </h2> --%>
      <form action="work_admin.do" method="post">
      <p class="empNoInput">
      <select name="pageYear" onchange="">
      	<option value="2023" ${pageAtt.year == '2023' ? 'selected="selected"' : '' }>2023년</option>
      	<option value="2022" ${pageAtt.year == '2022' ? 'selected="selected"' : '' }>2022년</option>
      	<option value="2021" ${pageAtt.year == '2021' ? 'selected="selected"' : '' }>2021년</option>
      	<option value="2020" ${pageAtt.year == '2020' ? 'selected="selected"' : '' }>2020년</option>
      	<option value="2019" ${pageAtt.year == '2019' ? 'selected="selected"' : '' }>2019년</option>
      </select>
      <select name="pageMon" id="pageMon" onchange="">
      	<option value="1" ${pageAtt.mon == '1' ? 'selected="selected"' : '' }>1월</option>
      	<option value="2" ${pageAtt.mon == '2' ? 'selected="selected"' : '' }>2월</option>
      	<option value="3" ${pageAtt.mon == '3' ? 'selected="selected"' : '' }>3월</option>
      	<option value="4" ${pageAtt.mon == '4' ? 'selected="selected"' : '' }>4월</option>
      	<option value="5" ${pageAtt.mon == '5' ? 'selected="selected"' : '' }>5월</option>
      	<option value="6" ${pageAtt.mon == '6' ? 'selected="selected"' : '' }>6월</option>
      	<option value="7" ${pageAtt.mon == '7' ? 'selected="selected"' : '' }>7월</option>
      	<option value="8" ${pageAtt.mon == '8' ? 'selected="selected"' : '' }>8월</option>
      	<option value="9" ${pageAtt.mon == '9' ? 'selected="selected"' : '' }>9월</option>
      	<option value="10" ${pageAtt.mon == '10' ? 'selected="selected"' : '' }>10월</option>
      	<option value="11" ${pageAtt.mon == '11' ? 'selected="selected"' : '' }>11월</option>
      	<option value="12" ${pageAtt.mon == '12' ? 'selected="selected"' : '' }>12월</option>
      </select>
      	 사원번호 : <input type="text" name="empNo" size="5" value="${pageAtt.emp_no}" pattern="[0-9]+"> <button type="submit" style="border: 1px solid;">조회</button>
      </p>
      <p class="empNoInput"><c:if test="${errors.empNo}">조회할 사원 번호를 입력해주세요</c:if></p>
      </form>
      <p>사원번호 ${pageAtt.emp_no}</p>
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






