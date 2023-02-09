<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/assets/css/joinSuccessStyle.css">
<title>회원가입성공</title>
</head>
<body>


	
	<div class="container">
		<div class="header">
				
		</div>
	
		<div class="field">
			<h3 id="name">"${param.emp_kname}"님</h3>
			<h3>입사를 진심으로 환영합니다!</h3>
		</div>	
	
		<div>
			<input type="button" class="button" onclick="location.href='<%=request.getContextPath()%>/index.jsp'" value="로그인페이지">
		</div>
 </div>
	


</body>
</html>