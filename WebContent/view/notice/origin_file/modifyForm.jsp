<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="description" content="member board Web Application">
  <meta name="keywords" content="member, board, notice, mvc">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Notice modify</title>
        <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
        <style>
		table {
	    width: 800px;
	    height: 600px;
	    margin-left: auto;
	    margin-right: auto;
	 	}
	 	textarea{ width:98%; border:0; resize: none;}
        </style>
        <script>
        	$(document).ready(function(){

        	});
        	
        	function formSubmit(){
        		$("#modifyFrm").submit();
//         		alert("게시글 수정에 성공하셨습니다.");

        	};
        	
        	
//         	function comMod(){
//     			let pageNoVal =  "<c:out value = '${pageNo}'/>";
//     			let rowSizeVal =  "<c:out value = '${rowSize}'/>";
//     			alert("수정완료");
//     			//alert("22222222222222222"+rowSizeVal);
<%--             	location.href="<%=request.getContextPath()%>/notice/list.do?pageNo="+pageNoVal+"&rowSize="+rowSizeVal; --%>
//         	}
        	
        </script>
        
</head>
<body>
<%-- ModifyNoticeHandler 컨트롤러에 의해 아래와 같이 Model 받았다.
	new ModifyRequest(로그인한 userid, 글번호, db의 작성자명, db의 title, db의 내용)
	request.setAttribute("modReq", modReq);
	request.setAttribute("pageNo", pageNo);
	request.setAttribute("rowSize", rsize);
	request.setAttribute("noticeData1", noticeData1);

*DB내용:${noticeData}<br/><br/>
*요청페이지:${pageNo}<br/><br/>
*1페이지당 게시글수:${rowSize}<br/><br/> 
${modReq}<br/><br/><br/><br/>
--%>

<%--  <a href="<%=request.getContextPath()%>/index.jsp">HOME</a> --%>
 <a href="<%=request.getContextPath()%>/view/main.jsp">HOME</a>
 <hr/>
 <h3>modifyForm.jsp</h3>
 <form name="modifyFrm" id= "modifyFrm"
 		method="post" action="<%=request.getContextPath()%>/notice/modify.do"> 
 <input type="hidden" name="pageNo" id="pageNo" value="${pageNo}"/>
 <input type="hidden" name="rowSize" id="rowSize" value="${rowSize}"/>
 
 <table border="1">
 	<tr>
 		<th>게시글 번호</th>
 		<td>${modReq.noticeNumber}</td>
 	</tr>
 	
 	 <tr>
 		<th>작성자명</th>
 		<td>${modReq.writer_name}</td>
 	</tr>

 	 <tr>
 		<th>최초 작성일</th>
 		<td><fmt:formatDate pattern="yyyy년 MM월 dd일  HH:mm:ss" type="date" value="${noticeData1.notice.regdate}" /></td>
 	</tr>
 	
 	 <tr>
 		<th>제목</th>
 		<td><%-- ${noticeData.notice.title} --%>
 		<input type="text" name="title" id="title" style="border:0;" value="${modReq.title}"/>
 		</td>
 	</tr>
 	
 	 <tr>
 		<th>내용</th>
 		<td>
 		<textarea name="content" id="content" rows="20" cols="60" autofocus>${modReq.content}</textarea>
 		</td>
 	</tr>
 	
 	 <tr>
 		<td colspan="2" style="text-align:center;">
 		<input type="submit" value="수정하기(submit)"/>
 		<button type="button" onclick="formSubmit();">수정하기(button)</button>
 		</td>
 	</tr>
 	
 	 <tr>
 		<td colspan="2" style="text-align:center;">
 		<button type="button" onclick="location.href='<%=request.getContextPath()%>/notice/list.do?pageNo=${pageNo}&rowSize=${rowSize}'">목록보기</button>
 		<button type="button" onclick="location.href='<%=request.getContextPath()%>/notice/read.do?no=${modReq.noticeNumber}&pageNo=${pageNo}&rowSize=3'">게시글 상세조회</button>
 		<button type="button" onclick="location.href='<%=request.getContextPath()%>/notice/delete.do?no=${modReq.noticeNumber}'">게시글 삭제</button>

<%--  		<a href="<%=request.getContextPath()%>/notice/list.do?pageNo=${pageNo}&rowSize=${rowSize}">목록보기(파라미터 처리 안함)</a> --%>
<%--  		<a href="<%=request.getContextPath()%>/notice/read.do?no=${modReq.noticeNumber}&pageNo=${pageNo}&rowSize=3">글 상세조회(모델보면서 보완예정)</a> --%>
<%--  		<a href="<%=request.getContextPath()%>/notice/read.do?no=${modReq.noticeNumber}">뒤로(글상세조회)</a> --%>
<%--  		<a href="<%=request.getContextPath()%>/notice/delete.do?no=${modReq.noticeNumber}">글삭제(delete용)</a> --%>
<%--  		<a href="<%=request.getContextPath()%>/notice/delete2.do?no=${modReq.noticeNumber}">글삭제(update용)</a> 기능상 필요 없어 삭제--%>
 		</td>
 	</tr>
 	
 
 </table>
 		<input type="hidden" name="no" id="no" value="${modReq.noticeNumber}"/>
<%--  		<input type="hidden" name="writer_name" id="writer_name" value="${modReq.writer_name}"/>   --%>
 		<!-- 런타임 익셉션 떨어져서 숨기고 no이름 값으로 속성을 안보이게 넘긴다.히든!! 위에 no값은 form태그 안에만 있으면 어디든 위치는 오케이다-->
 		<%-- 여기에서는 작성자명을 수정처리컨트롤러에 넘기는 방식으로 추가하였다.
 		현재방식이라면 DB의 작성자명과 세션에 담긴 이름이 동일하므로 세션으로 대체해도 된다 --%>
 </form>
 
 
 
 
</body>
</html>











