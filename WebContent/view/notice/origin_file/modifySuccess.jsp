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
${keyword}

<%--
 컨트롤러에 의해 아래와 같이 Model받았다
 ModifyRequest modReq(로그인한userid,글번호,db의작성자명,db의title,db의내용)
		request.setAttribute("modReq", modReq);
 --%>
<%--  <a href="<%=request.getContextPath()%>/index.jsp">HOME</a> --%>
 <a href="<%=request.getContextPath()%>/view/main.jsp">HOME</a>
 <hr/>
 <h3>modifySuccess.jsp</h3>
 	 <%--
 	 <c:set var="변수명" value="변수값"/>--%>
<%--  	 <c:set var="pageNo"  --%>
<%--  	    value="${(empty param.pageNo)?'1':param.pageNo}"/>                       --%>
<!--  	 http://localhost/tp/notice/list.do?pageNo=1&rowSize=3&choice=writer_id&keyword=leeid -->
 	 	<a href="<%=request.getContextPath()%>/notice/list.do?pageNo=${pageNo}&rowSize=${rowSize}">목록보기</a>
<%--  	 	<a href="<%=request.getContextPath()%>/notice/list.do?pageNo=${pageNo}&rowSize=${rowSize}?choice=${choice}&keyword=${keyword}">목록보기</a> --%>
 	 	<a href="<%=request.getContextPath()%>/notice/read.do?no=${modReq.noticeNumber}&pageNo=${pageNo}&rowSize=${rowSize}">수정한 글 보기</a>
 	 	<%-- 수정과 삭제기능은
 	 	  로그인한 유저의 id와 작성자의 id가 일치하는 경우에만 노출하도록 한다 
 	 	<c:if test="${AUTHUSER.memberid==noticeData.notice.writer.writer_id}">
	 	 	<a href="/notice/modify.do?no=${noticeData.notice.number}&pageNo=${pgNo}&rowSize=${rowSize}">글수정</a>
	 	 	<a href="/notice/delete.do?no=${noticeData.notice.number}">글삭제(delete용)</a>
	 	 	<a href="/notice/delete2.do?no=${noticeData.notice.number}">글삭제(update용)</a>
 	 	</c:if>
 	 	--%>
 	 	
<%--  ${pageNo}	--%>
<%-- ${rowSize} --%>
 	 	
 	 	<script>
 	 	$(document).ready(function(){
	 		//let pageNoVal = ${pageNo};
			//let rowSizeVal = ${rowSize}; 
			
// 			let pageNoVal =  "<c:out value = '${pageNo}'/>";
// 			let rowSizeVal =  "<c:out value = '${rowSize}'/>";
			alert("수정완료");
// 			//alert("22222222222222222"+rowSizeVal);
<%--         	location.href="<%=request.getContextPath()%>/notice/list.do?pageNo="+pageNoVal+"&rowSize="+rowSizeVal; --%>
        	
 	 	});
        </script>
 	 	
 	 	
 	 	
</body>
</html>