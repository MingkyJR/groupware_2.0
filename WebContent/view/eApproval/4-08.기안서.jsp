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
<%@ include file="./../module/top00.jsp" %>
<style type="text/css">
table {
	width: 80%;
	margin: 5px;
	padding: 5px;
	    margin-left:auto; 
    margin-right:auto;
	
	
}
p{
	font-size: 3rem;
	text-align: center;
}

.tg {
	border-collapse: collapse;
	border-spacing: 0;
	background: #F0F0F0;
}

.tg td {
	border-color: black;
	border-style: solid;
	border-width: 1px;
	font-family: Arial, sans-serif;
	font-size: 14px;
	overflow: hidden;
	padding: 10px 5px;
	word-break: normal;
}

.tg th {
	border-color: black;
	border-style: solid;
	border-width: 1px;
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	overflow: hidden;
	padding: 10px 5px;
	word-break: normal;
}

.tg .tg-292c {
	background-color: #e0e0e0;
	border-color: inherit;
	text-align: center;
	vertical-align: top;
	width: 10%;
}

.tg .tg-c3ow {
	border-color: inherit;
	text-align: center;
	vertical-align: top
}

.tg .tg-0pky {
	border-color: inherit;
	text-align: left;
	vertical-align: top;
}

.tg .tg-c6of {
	background-color: #ffffff;
	border-color: inherit;
	text-align: left;
	vertical-align: top
}

textarea {
	width: 100%;
}
</style> 
<br><br><br><br><br><br><br><br>

<p>기안서</p><br><br><br>
${AUTHUSER}
<form name="writeFrm" id="writeFrm" method="post"
			action="<%=request.getContextPath()%>/document/writeDocument.do">
			<input type="hidden" name="rowSize" value="${rowSize}"/>
			<input type="hidden" name="dept_name"  id="dept_name" value="${AUTHUSER.dept_name}"/>
			<input type="hidden" name="emp_position" id="emp_position"  value="${AUTHUSER.emp_position}"/>
			<input type="hidden" name="emp_no" id="emp_no"  value="${AUTHUSER.emp_no}"/> 
<table class="tg">
	<thead>
		<tr>
			<th class="tg-0pky" colspan="2"><span style="float: left;">문서번호 : 자동채번 <input type="hidden"  name="do_no" id="do_no" value="" onFocus="this.blur()">
																			</span><input type="hidden" name="create_date" id="create_date" onFocus="this.blur()">
			<th class="tg-c3ow" rowspan="3">결<br> <br> <br> <br>재
			</th>
			<th class="tg-292c">담당부서</th>
			<th class="tg-292c">총무</th>
			<th class="tg-292c">회장</th>
		</tr>
		<tr>
			<th class="tg-0pky" colspan="2" rowspan="2">업무명: <textarea class="area0" name="title" id="title" rows="1"></textarea></th>
			<th class="tg-0pky" rowspan="2"></th>
			<th class="tg-0pky" rowspan="2"></th>
			<th class="tg-0pky" rowspan="2"></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td class="tg-292c"><br>업<br>무<br>계<br>획</td>
			<td class="tg-0pky" colspan="5"><textarea class="area1" rows="8" name="plans" id="plans"></textarea></td>
		</tr>
		<tr>
			<td class="tg-292c"><br> <br>건<br>의<br>사<br>항</td>
			<td class="tg-0pky" colspan="5"><textarea class="area2" rows="8" name="sugg" id="sugg"></textarea></td>
		</tr>
		<tr>
			<td class="tg-292c"><br>특<br>이<br>사<br>항</td>
			<td class="tg-0pky" colspan="5"><textarea class="area3" rows="8" name="uniq" id="uniq"></textarea></td>
		</tr>
	</tbody>
</table>
<input type="hidden" name="rowSize" value="${rowSize}"/><br><br>
<span style="float:right;" >작성자<br><input type="text" name="emp_kname" id="emp_kname" value="${AUTHUSER.emp_kname}" onFocus="this.blur()"/></span><br><br><br>
<span style="margin:20px; float: right; ">
<input type="submit" value="작성 완료" > 
<input type="reset" value="취소"> 
</span>
<input type="hidden" name="form_no"  id="form_no" /><!-- 양식번호 -->
<input type="hidden" name="form_name"  id="form_name" /><!-- 양식명 -->
<input type="hidden" name="creat_empno"  id="creat_empno"  /><!-- 작성사원번호 -->
</form>

<%@ include file="./../module/bottom00.jsp" %>
</body>
</html>






