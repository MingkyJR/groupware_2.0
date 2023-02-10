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
 <title>수정요청 정보</title>
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
<div class="container" style="margin-top: 10px;">
	<div class="row">
	 <div class="col">
	 <h3 style="border-bottom: solid black; padding-bottom: 5px;">출퇴근 수정요청</h3>
	 <h4 style="padding-bottom: 10px; padding-top: 25px;">요청 내용</h4>
		<table class="table table-bordered">
		  <tbody>
		    <tr>
		      <th scope="row">번호</th>
		      <td>${edit.edit_num}</td>
		    </tr>
		    <tr>
		      <th scope="row">요청일자</th>
		      <td><fmt:formatDate type="date" value="${edit.edit_req_date}" pattern="YYYY.MM.dd kk:mm:ss"/></td>
		    </tr>
		    <tr>
		      <th scope="row">근무일</th>
		      <td><fmt:formatDate type="date" value="${edit.reg_date}" pattern="YYYY.MM.dd"/></td>
		    </tr>
		    <tr>
		      <th scope="row">요청자</th>
		      <td>${edit.emp_name}</td>
		    </tr>
		    <tr>
		      <th scope="row">수정요청 시간</th>
		      <td>
					<fmt:formatDate type="date" value="${edit.edit_in_time}" pattern="kk:mm"/>
       		~ 
      		<fmt:formatDate type="date" value="${edit.edit_out_time}" pattern="kk:mm"/>
					</td>
		    </tr>
		    <tr>
		      <th scope="row" style="line-height: 252px;">사유</th>
		      <td><textarea name="reason" readonly="readonly" rows="10" style="width: 100%; resize: none;">${edit.reason}</textarea></td>
		    </tr>
		  </tbody>
		</table>
		<div style="text-align: right;">
		<button type="button" onclick="location.href='<%=request.getContextPath()%>/editList.do'" style="float: left;">목록으로</button>
		<c:if test="${edit.edit_status eq '요청중'}">
		<button type="button" class="btn btn-success" onclick="location.href='approve.do?num=${edit.edit_num}&emp_no=${edit.emp_no}&regDate=${edit.reg_date}'">승인</button>
		<button type="button" class="btn btn-danger" onclick="location.href='return.do?num=${edit.edit_num}&emp_no=${edit.emp_no}&regDate=${edit.reg_date}'">반려</button>
		</c:if>
		</div>
	 </div>
	</div>
</div>

<%@ include file="../module/bottom00.jsp" %>
</body>
</html>






