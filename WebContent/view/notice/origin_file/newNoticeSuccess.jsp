<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="description" content="member board Web Application">
  <meta name="keywords" content="member, board, notice, mvc">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
        <!-- Download방식으로 jQuery연동 -->
<!--         <script src="./js/jquery-3.6.3.min.js"></script> -->
        <!-- CDN방식으로 jQuery연동 -->
<!--         <script src="https://code.jquery.com/jquery-2.2.4.js"></script> -->
<!--         <script src="https://code.jquery.com/jquery-3.6.3.min.js"></script> -->
        <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
        <style>
        </style>
        <script>
        	$(document).ready(function(){
        		//alert('jQuery 연결 성공~~~');
        	});
        </script>
        
</head>
<body>
<%--
 WriteNoticeHandler 컨트롤러에 의해 아래와 같이 Model받았다
 	int newNoticeNo : article테이블 입력된 글번호
 	request.setAttribute("newNoticeNo", newNoticeNo);
 	request.setAttribute("rowSize", rowSize); //로우사이즈
 --%>
 rowSize=${rowSize}
<%--  <a href="<%=request.getContextPath()%>/index.jsp">HOME</a> --%>
 <a href="<%=request.getContextPath()%>/view/main.jsp">HOME</a>
 <hr/>
 <h3>입력성공!!!(newNoticeSuccess.jsp)</h3>
 	 <%----%>
 	 <c:set var="변수명" value="변수값"/>
 	 <c:set var="pageNo" 
 	    value="${(empty param.pageNo)?'1':param.pageNo}"/>                      
 	 
 	 	<a href="<%=request.getContextPath()%>/notice/list.do?pageNo=1&rowSize=${rowSize}">목록보기</a>
 	 	<a href="<%=request.getContextPath()%>/notice/read.do?no=${newNoticeNo}&pageNo=1&rowSize=${rowSize}">작성한 글 보기</a>
 	 	
</body>
</html>