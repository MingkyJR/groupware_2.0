<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<style></style>
<script>
	$(document).ready(function(){
		
	});//
</script>
<title>Insert title here</title>
</head>
<body>

<!-- forEach는 반복문. 서비스에서 setAttribute의 값으로 가져온 리스트를 쉽게 사용하기 위해 변수선언 -->
<c:forEach items="${list}" var="emp">

<!-- 여기서쓰는 $는 jstl은 아님. 변수 emp = ${list}인데, 
list는 DAO에서 DTO(Employee)안에 저장한값이니까 DTO안에 선언한 get메서드의 변수명을 호출할수있다.  -->
	${emp.emp_id},${emp.emp_kname} <br/>
	</c:forEach>
<!-- 	<table border="1">
		<tr>
			<td>직원번호</td>
			<td>아이디</td>
			<td>이름</td>
			<td>핸드폰번호</td>
			<td>이메일</td>
			<td>부서</td>
			<td>직급</td>
			<td>권한</td>
		</tr>
 -->
	


</body>
</html>