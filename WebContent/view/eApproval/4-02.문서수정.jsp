<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
 <meta charset="UTF-8">
 
</head>

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
	font-size: 2rem;
	text-align: center;
	margin-bottom: -3%;
}
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	background: #F0F0F0;
	width: 100%;
	margin: 5px;
	padding: 5px;
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
<body>
<br>
<span style="width: 100%; text-align: center;">
	<p>기안서</p>
</span>
<form  name="modifyFrm" id="modifyFrm" method="post"
			action="<%=request.getContextPath()%>/document/modify.do">
<span style="float: right;">문서번호: ${modReq.do_no}</span>
<table class="tg">
	<thead>
		<tr>
			<th class="tg-0pky" colspan="2">작성일: <%-- ${modReq.create_date} --%>
			<th class="tg-c3ow" rowspan="3">결<br> <br> <br> <br>재
			</th>
			<th class="tg-292c">담당부서</th>
			<th class="tg-292c">총무</th>
			<th class="tg-292c">회장</th>
		</tr>
		<tr>
			<th class="tg-0pky" colspan="2" rowspan="2"><span>업무명: <textarea class="area0" name="title" id="title"
					rows="1">${modReq.title}</textarea></span></th>
			<th class="tg-0pky" rowspan="2"></th>
			<th class="tg-0pky" rowspan="2"></th>
			<th class="tg-0pky" rowspan="2"></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td class="tg-292c"><br>업<br>무<br>계<br>획</td>
			<td class="tg-0pky" colspan="5"><textarea class="area1" rows="8" name="plans" id="plans">${modReq.plans}</textarea></td>
		</tr>
		<tr>
			<td class="tg-292c"><br> <br>건<br>의<br>사<br>항</td>
			<td class="tg-0pky" colspan="5"><textarea class="area2" rows="8" name="Sugg" id="Sugg">${modReq.sugg}</textarea></td>
		</tr>
		<tr>
			<td class="tg-292c"><br>특<br>이<br>사<br>항</td>
			<td class="tg-0pky" colspan="5"><textarea class="area3" rows="8" name="Uniq" id="Uniq">${modReq.uniq}</textarea></td>
			<td><input type="hidden" name="comm" id="comm" value="${modReq.comm}"/></td>
			
		</tr>
	</tbody>
</table>
<input type="hidden" name="no" id="no" value="${modReq.do_no}"/>
작성자:${AUTHUSER.emp_kname}
<span style="margin:20px; float: right; ">
<input type="submit" value="수정하기" > 
<input type="reset" value="취소"> 
</span>
</form>
</body>

</html>






