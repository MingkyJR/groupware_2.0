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
 <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/font-awesome.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/templatemo-hexashop.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/owl-carousel.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/lightbox.css">
    
    
    <script src="<%=request.getContextPath()%>/assets/js/jquery-2.1.0.min.js"></script>

    <!-- Bootstrap -->
    <script src="<%=request.getContextPath()%>/assets/js/popper.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>

    <!-- Plugins -->
    <script src="<%=request.getContextPath()%>/assets/js/owl-carousel.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/accordions.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/datepicker.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/scrollreveal.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/waypoints.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/jquery.counterup.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/imgfix.min.js"></script> 
    <script src="<%=request.getContextPath()%>/assets/js/slick.js"></script> 
    <script src="<%=request.getContextPath()%>/assets/js/lightbox.js"></script> 
    <script src="<%=request.getContextPath()%>/assets/js/isotope.js"></script> 
    
    <!-- Global Init -->
    <script src="<%=request.getContextPath()%>/assets/js/custom.js"></script>
	<style>
		html, head{
			width: 100%;
			height: 100%;
		}
		.title{
		}
		.second_container{
			width: 800px;
			margin: 30px auto;
			padding: 10px;
			border: 1px solid #bbbbbb;
			border-radius: 10px;
		}
		.comment_option{
			border-top: 1px solid #979797;
			padding: 10px 0;
		}
		.comment_area{
			font-size: 13px;
			border-top: 1px solid #e5e5e5;
			padding: 5px 0;
		}
		button {
			margin: 5px 5px;
			background-color: #505D93;
			color: white;
			padding: 6px 20px;
			border: none;
			border-radius: 4px;
			cursor: pointer;
		}
		button:hover {
			background-color: #788AD0;
		}
		img{
			max-width: 100%;
		}
		.commentWriter{
			padding: 5px;
			border: 2px solid #e5e5e5;
			border-radius: 8px;
			height: auto;
		}
		textarea{
			width: 97%; 
			border: none; 
			outline: none; 
			resize: none;
		}
		#btnList{
			background-color: #ebad34;
		}
		#btnList:hover{
			background-color: #ffc500;
		}
	</style>
	<script>
		$(document).ready(function(){
			$("#btnDelete").click(function(){
				let no=${no};
				let del=confirm("삭제 하시겠습니까?");
				if(del){
					location.href="<%=request.getContextPath()%>/secondHand/delete.do?no="+no;
				}
			});
			
			$("#btnUpdate").click(function(){
				let no=${no};
				let title="<c:out value='${content.title}' />";
				let content="<c:out value='${content.content}' />";
				let price="<c:out value='${content.price}' />";
				let modi=confirm("수정 하시겠습니까?");
				if(modi){
					location.href="<%=request.getContextPath()%>/secondHand/update.do?"+
							"no="+no+"&title="+title+"&content="+content+"&price="+price;
				}
			});
			$("#btnReply").click(function(){
				let oriNo=${no};
				let empid="<c:out value='${AUTHUSER.emp_id}' />";
				let recontent=$("#recontent").val();
				let regi=confirm("댓글을 등록 하시겠습니까?");
				$.ajax({
					type:"GET",
					url:"<%=request.getContextPath()%>/secondHand/reply/registe.do?"+
						"oriNo="+oriNo+"&empid="+empid+"&recontent="+recontent,
					success:function(data){
						if(data==1){
							location.href="<%=request.getContextPath()%>/secondHand/content.do?no=${no}&views=${views}&currentPage=${currentPage}";
						}
					},
					error : function(request, status, error) { // 결과 에러 콜백함수
				        console.log(error);
				    }
				});
			});
			$(".replyDel").click(function(){
				let del=confirm("댓글을 삭제하시겠습니까?");
				let reNo=$(this).attr("param");
				$.ajax({
					type:"POST",
					url:"<%=request.getContextPath()%>/secondHand/reply/delete.do",
					data:{reNo:reNo},
					success:function(data){
						if(data==1){
							alert("해당 댓글이 삭제 되었습니다.");
						}else{
							alert("해당 댓글이 삭제에 실패 되었습니다.");
						}
						location.href="<%=request.getContextPath()%>/secondHand/content.do?no=${no}&views=${views}&currentPage=${currentPage}";
					},
					error : function(request, status, error) { // 결과 에러 콜백함수
				        console.log(error);
				    }
				});
			});
			$(".replyModi").click(function(){
				let del=confirm("댓글을 수정 하시겠습니까?");
				if(del){
					let reNo=$(this).attr("param");
					$("#commentModify"+reNo).show();
				}
			});
			$(".reModi").click(function(){
				let reNo=$(this).attr("param");
				$.ajax({
					type:"POST",
					url:"<%=request.getContextPath()%>/secondHand/reply/modify.do",
					data:{
						reNo:reNo,
						reContent:$("#reModiContent"+reNo).val()
						},
					success:function(data){
						if(data==1){
							alert("해당 댓글이 수정 되었습니다.");
						}else{
							alert("해당 댓글 수정이 실패 되었습니다.");
						}
						location.href="<%=request.getContextPath()%>/secondHand/content.do?no=${no}&views=${views}&currentPage=${currentPage}";
					},
					error : function(request, status, error) { // 결과 에러 콜백함수
				        console.log(error);
				    }
				});
			});
			$("textarea").keyup(function(e){
				$(this).css('height', 'auto');
				$(this).height(this.scrollHeight);
			});
		});
	</script>
</head>
<body>
<%@ include file="../module/top00.jsp" %>
	<div class="second_container">
		<div>
			<div class="title"><h3>${content.title}</h3></div>
			<div class="writer">작성자: ${content.empID}</div>
			<div>작성일자: ${content.regDate} 조회수: ${views}</div>
		</div>
		<div style="text-align: center; margin-top: 10px;">
			<c:if test="${not empty content.refileName}">
				<img src="<%=request.getContextPath()%>/secondHand/imageOut.do?reFileName=${content.refileName}" />
			</c:if>
		</div>
		<div style="margin: 10px 0;">${content.content}</div>
		<div class="comment_option">댓글</div>
		<c:forEach var="re" items="${ reply }">
			<div class="comment_area">
				<div style="font-weight:450; margin: 3px 0; font-size: medium;">${ re.empID }</div>		
				<div style="margin-bottom: 3px;">${ re.reContent }</div>
				<span style="font-style: italic;">${ re.str_Date }</span>
					<c:if test="${ re.empID==AUTHUSER.emp_id }">
						<a href="#" style="text-decoration: none; color: black;">
							<span class="replyDel" style="float: right; margin-right: 5px;" param="${ re.reNo }">댓글삭제</span>
						</a>
						<a href="#" style="text-decoration: none; color: black;">
							<span class="replyModi" style="float: right; margin-right: 5px;" param="${ re.reNo }">댓글수정 | </span>
						</a>
					</c:if>
				</div>
			<div class="commentWriter" id="commentModify${ re.reNo }" style="display: none;">
				<div style="margin: 5px 0;">${AUTHUSER.emp_id}</div>
				<textarea rows="" cols="" id="reModiContent${ re.reNo }" name="recontent" >${ re.reContent }</textarea>
				<div style="text-align: right;"><button id="btnReplyModi" param="${ re.reNo }" class="reModi" >수정</button></div>
			</div>
		</c:forEach>
		<div class="commentWriter">
			<div style="margin: 5px 0;">${AUTHUSER.emp_id}</div>
				<textarea rows="" cols="" placeholder="댓글을 입력해주세요." id="recontent" name="recontent" ></textarea>
			<div style="text-align: right;"><button id="btnReply">등록</button></div>
		</div>
		<button id="btnList"><a href="<%=request.getContextPath()%>/secondHand/list.do?pageNo=${currentPage}" style="text-decoration: none; color: white;">목록보기</a></button>
		<c:if test="${content.empID==AUTHUSER.emp_id}">
			<button id="btnDelete">삭제</button>
			<button id="btnUpdate">수정</button>
		</c:if>
	</div>
<%@ include file="../module/bottom00.jsp" %>
</body>
</html>





