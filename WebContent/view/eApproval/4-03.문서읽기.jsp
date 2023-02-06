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
<style type="text/css">

form{
	padding:5px;
	}
table {
	width: 100%;
	margin: 5px;
	padding: 5px;
}
p{
	font-size: 3rem;
	text-align: center;
	margin-bottom: -15%;
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
.btn{
margin-left:12px;
width:40%;
float: right;
padding:30px;
font-size: 1.2rem;
}
</style>
</head>
<body>
<pre>
  <주> Astro Software
</pre>
<%-- ${AUTHUSER} --%>
	<p>기안서</p>
<form name="writeFrm" id="writeFrm" method="post"
			action="<%=request.getContextPath()%>/document/modify.do">

<table class="tg" style="float: right; width:26% ;text-align: center;">
<tr>
<th class="tg-292c" style=" width:50% ;" >접수번호</th>
<td class="tg-0pky" style="text-align: center;">${documentData.document.do_no}</td>
</tr>
<tr>
<th class="tg-292c" style=" width:50% ;" >문서번호</th>
<td class="tg-0pky" style="text-align: center;">${documentData.document.title}</td>
</tr>
<tr>
<th class="tg-292c" style=" width:50% ;" >사원번호</th>
<td class="tg-0pky" style="text-align: center;">${documentData.document.draft_empno}</td>
</tr>
<tr>
<th class="tg-292c" style=" width:50% ;" >작성사원</th>
<td class="tg-0pky" style="text-align: center;">${documentData.document.writer.emp_kname}</td>
</tr>

</table>

<table class="tg">
	<thead>
		<tr>
			<th class="tg-0pky" colspan="2">작성일: ${documentData.content.create_date}
			<th class="tg-c3ow" rowspan="3">결<br> <br> <br> <br>재
			</th>
			<th class="tg-292c"style="text-align: center;">담당부서</th>
			<th class="tg-292c"style="text-align: center;">과장</th>
			<th class="tg-292c"style="text-align: center;">대표이사</th>
		</tr>
		<tr>
			<th class="tg-0pky" colspan="2" rowspan="2">업무명: ${documentData.content.title}</th>
			<th class="tg-0pky" rowspan="2"style="text-align: center;">${documentData.document.writer.dept_name}</th>
			<th class="tg-0pky" rowspan="2"style="text-align: center;">승인</th>
			<th class="tg-0pky" rowspan="2"><span></span></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td class="tg-292c"><br>업<br>무<br>계<br>획</td>
			<td class="tg-0pky" colspan="5"><textarea class="area1" rows="8" onFocus="this.blur()">${documentData.content.plans}</textarea></td>
		</tr>
		<tr>
			<td class="tg-292c"><br> <br>건<br>의<br>사<br>항</td>
			<td class="tg-0pky" colspan="5"><textarea class="area2" rows="8" onFocus="this.blur()">${documentData.content.sugg}</textarea></td>
		</tr>
		<tr>
			<td class="tg-292c"><br>특<br>이<br>사<br>항</td>
			<td class="tg-0pky" colspan="5"><textarea class="area3" rows="8" onFocus="this.blur()">${documentData.content.uniq}</textarea></td>
		</tr>
			<tr>
			<td class="tg-292c"><br>코<br>멘<br>트<br>
			<td class="tg-0pky" colspan="5"><textarea class="area3" rows="8" onFocus="this.blur()"></textarea></td>
		</tr>
	</tbody>
</table>

 		<c:set var="pgNo" 
	value="${(empty param.pageNo)?'1':param.pageNo }"/>
 <c:if test="${AUTHUSER.emp_no==documentData.content.create_empno}">
			<input class="btn" type="button" value="삭제" onclick="location.href='/document/deleteDocument.do?no=${documentData.document.do_no}'">
			<input class="btn" type="button" value="수정" onclick="location.href='/document/modify.do?no=${documentData.document.do_no}&pageNo=${pgNo}&rowSize=${rowSize}'">
	</c:if> 
	<c:if test="${not empty AUTHUSER && (AUTHUSER.emp_grade eq 5)}">
				<input class="btn" type="button" value="반려" onclick="location.href='/document/returnStatDocument.do?no=${documentData.document.do_no}'">
				<input class="btn" type="button" value="승인" onclick="location.href='/document/passStatDocument.do?no=${documentData.document.do_no}'">
</c:if> 
</form>

<script>
$("span:contains('1')").html("대기");
$("span:contains('2')").html("반려");
$("span:contains('3')").html("승인");
</script>
</body>
</html>






