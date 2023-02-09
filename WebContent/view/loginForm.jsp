<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>login</title>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<link rel="stylesheet" type="text/css" href="/assets/css/loginStyle.css">
<style>
<
style type ="text/css">.tg {
	border-collapse: collapse;
	border-spacing: 0;
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

.tg .tg-0pky {
	border-color: inherit;
	text-align: left;
	vertical-align: top
}

.tg .tg-y698 {
	background-color: #efefef;
	border-color: inherit;
	text-align: left;
	vertical-align: top
}
</style>

</head>
<body>
	<div id="header"></div>
	<div id="container">
		<div id="aside">
			<img id="img" src="/assets/images/login_img.png">
		</div>
		<form action="/login.do" method="post">
			<div class="contents">
				<h2>Greeting</h2>
				<label> <span>ID</span><br /> <input type="text"
					name="emp_id" id="emp_id" value="${param.emp_id}" /> <c:if
						test="${errors.emp_id}">ID를 입력하세요</c:if>
				</label> <br /> <label> <span>PASSWORD</span><br /> <input
					type="password" name="emp_pw" id="emp_pw" /> <c:if
						test="${errors.emp_pw}">암호를 입력하세요</c:if> <br />
				<c:if test="${errors.idOrPwNotMatch}">아이디와 패스워드가 일치하지 않습니다</c:if>
				</label> <br />
				<button type="submit" class="login">Log In</button>
				<button type="button" class="signup"
					onclick="location.href='/join.do';">Sign Up</button>
			</div>
		</form>
	</div>

	<div id="footer">
		<table class="tg" style="margin-left:75%; margin-top:-15%;">
			<thead>
				<tr>
					<th class="tg-0pky"></th>
					<th class="tg-y698">아이디</th>
					<th class="tg-y698">비밀번호</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="tg-y698">일반사원1</td>
					<td class="tg-0pky">Umbrella_Kim</td>
					<td class="tg-0pky">test</td>
				</tr>
				<tr>
					<td class="tg-y698">일반사원2</td>
					<td class="tg-0pky">Wating Park</td>
					<td class="tg-0pky">test2</td>
				</tr>
				<tr>
					<td class="tg-y698">관리자1</td>
					<td class="tg-0pky">CEO</td>
					<td class="tg-0pky">test1</td>
				</tr>
				<tr>
					<td class="tg-y698">관리자2</td>
					<td class="tg-0pky">CEO2</td>
					<td class="tg-0pky">test3</td>
				</tr>
			</tbody>
		</table>
	</div>


</body>
</html>