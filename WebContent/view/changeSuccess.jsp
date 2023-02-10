<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<link rel="stylesheet" type="text/css" href="/assets/css/changeSuccessStyle.css">
<style></style>
<script>
$(document).ready(function(){
	

	let address = '${AUTHUSER.emp_address}';
	let split_address = address.split("/");
	$("#new_sample6_address").val(split_address[0]);
	$("#new_sample6_detailAddress").val(split_address[1]);
	$("#new_sample6_extraAddress").val(split_address[2]);
	
	let email = '${AUTHUSER.emp_email}';
	let split_email = email.split("@");
	$("#emp_email_id").val(split_email[0]);
	$("#emp_email_d").val(split_email[1]);
	
});
	
</script>
<title>회원정보 수정 성공</title>
</head>
<body>
	
	<div class="header">
		<h1> 회원정보수정 성공 </h1> <br/>
	</div>
		
		<div class="container">
			<div class="contant">
				
				<div class="field">
					<h3>현재 아이디 </h3>
					<input type="text"  value="${AUTHUSER.emp_id}" readonly="readonly"> <br/>
				</div> 
				
				
				<div class="field">
					<h3>수정된 한글이름*</h3> 
					<input type="text" id="new_kname" name="new_kname" required="required" value="${AUTHUSER.emp_kname}" readonly="readonly"> <br/>
				</div>
				
				<div class="field">
					<h3>수정된 영문이름*</h3> 
					<input type="text" id="new_ename" name="new_ename" value="${AUTHUSER.emp_ename}" readonly="readonly"> <br/>
				</div>
				
				<div class="field postcode">
 					<h3>수정된 우편번호*</h3> 
 					<input type="text" id="new_emp_postcode" name="new_emp_postcode"  pattern="[0-9]+" value="${AUTHUSER.emp_postcode}" readonly="readonly">
				</div>
				
				<div class="field">
					<h3>수정된 주소*</h3>
					<input type="text" id="new_sample6_address" name="new_sample6_address" required="required" readonly="readonly"> <br/>
					<h3>수정된 상세주소*</h3> 
					<input type="text" id="new_sample6_detailAddress" name="new_sample6_detailAddress" required="required" readonly="readonly" > <br/>
					<h3>수정된 참고항목*</h3> 
					<input type="text" id="new_sample6_extraAddress" name="new_sample6_extraAddress" required="required"  readonly="readonly">
				</div>
				
				<div class="field">
					<h3>수정된 생년월일* </h3>
					<input type="text" id="new_birthday" name="new_birthday" placeholder="6자리 숫자로 입력해주세요" pattern="[0-9]+" maxlength="6" value="${AUTHUSER.emp_birthday}" readonly="readonly">
				</div>
				
				<div class="field">
					<h3>수정된 연락처*</h3> 
					<input type="text" id="new_phonenumber" name="new_phonenumber" placeholder="숫자만 입력해주세요" pattern="[0-9]+" maxlength="11" value="${AUTHUSER.emp_phonenumber}" readonly="readonly">
				</div>
				
				<div class="email">
					<h3>수정된 이메일주소*</h3> 
					<input type="text" id="emp_email_id" name="emp_email_id" size="10" readonly="readonly">
					<div id="and"><h3 >@</h3></div>
					<input type="text" name="emp_email_d" id="emp_email_d" readonly="readonly"> <br/>
			 </div>
			 
			 <%-- <div class="field">
				<h3>부서선택*</h3>  
					<input type="text"  value="${AUTHUSER.dept_name}" readonly="readonly"> <br/>
				</div> --%>
				
			
				<div class="footer">
					<input type="button" onclick="location.href='<%=request.getContextPath()%>/chat.do'" value="메인페이지">
				</div>
			</div>
		</div>	



</body>
</html>