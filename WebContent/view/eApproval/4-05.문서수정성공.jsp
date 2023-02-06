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

</head>
<body>
<!-- <style>
		@font-face {
	font-family: "CookieRun-Regular";
	src:
		url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/CookieRun-Regular.woff")
		format("woff");
	font-weight: normal;
	font-style: normal;
}
* {
	font-family: "CookieRun-Regular";
}
div {
	padding: 10px;
	box-shadow: 0px 0px 5px 0px gray;
	width: 90%;
}
	</style> -->
	<script>
	</script>
</head>
<body>
<%--
 컨트롤러에 의해 아래와 같이 Model받았다
 ModifyRequest modReq(로그인한userid,글번호,db의작성자명,db의title,db의내용)
		request.setAttribute("modReq", modReq);
 --%>
 <a href="<%=request.getContextPath()%>/index.jsp">HOME</a>
 <hr/>
 <h3>수정성공!!!(modifySuccess.jsp)</h3>
 	 <%--
 	 <c:set var="변수명" value="변수값"/>--%>
 	 <c:set var="pgNo" 
 	    value="${(empty param.pageNo)?'1':param.pageNo}"/>                      
 	 	<a href="/document/listDocument.do">목록보기(rowSize파라미터설정해야함)</a>
 	 	<%-- 수정과 삭제기능은
 	 	  로그인한 유저의 id와 작성자의 id가 일치하는 경우에만 노출하도록 한다 
 	 	<c:if test="${AUTHUSER.memberid==articleData.article.writer.writer_id}">
	 	 	<a href="/article/modify.do?no=${articleData.article.number}&pageNo=${pgNo}&rowSize=${rowSize}">글수정</a>
	 	 	<a href="/article/deleteArticle.do?no=${articleData.article.number}">글삭제(delete용)</a>
	 	 	<a href="/article/deleteArticle2.do?no=${articleData.article.number}">글삭제(update용)</a>
 	 	</c:if>
 	 	--%>
	<script type="text/javascript">
			location.href = 'listDocument.do';
		</script>
</body>
</html>






