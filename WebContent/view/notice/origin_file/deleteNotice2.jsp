<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="description" content="member board Web Application">
  <meta name="keywords" content="member, board, article, mvc">
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
<%--DeleteNoticeHandler2 컨트롤러를 거쳐왔다면 아래와같이 Model을 받았다
	리턴타입 int cnt: 삭제(update)된 행 수. 1이면 삭제성공, 0이면 삭제실패*/
	request.setAttribute("cnt", cnt); --%>
 <h2>deleteNotice2.jsp</h2>
<%--  ${cnt} --%>
 <hr/>
 
 <c:if test="${cnt==1}">
 <script>
 	alert("삭제 성공");
 </script>
 </c:if>

 <c:if test="${cnt eq 0}"> 	
 <script>
 	alert("삭제 실패");
 </script>
 </c:if>
 
 <script>
<%--  location.href="<%=request.getContextPath()%>/view/notice/listNotice.jsp"; --%>
 location.href="<%=request.getContextPath()%>/notice/list.do"; //
//  "/notice/modify.do?no=${noticeData.notice.number}&pageNo=${pageNo}&rowSize=${rowSize}">
 </script>
 
 
 
</body>
</html>