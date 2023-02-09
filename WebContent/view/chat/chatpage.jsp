<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="description" content="member board Web Application">
<meta name="keywords" content="member, board, article, mvc">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<link rel="stylesheet" href="assets/css/chat.css">
<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/assets/css/font-awesome.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/templatemo-hexashop.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/owl-carousel.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/lightbox.css">
</head>


<style>
.container1 {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100%;
}

.app1 {
	margin-top: 45px;
	position: relative;
	width: 260px;
	height: 450px;
	border: gray 0.5px;
	border-color: solid;
	background-color: rgb(171, 193, 209);
}

.app1>h1 {
	font-size: 2em;
	text-align: center;
	margin: 10px 5px;
	border-bottom: 0.5px solid rgb(234, 234, 234);
}

ul1 {
	max-height: 420px;
	overflow: auto;
}

ul1>li {
	cursor: pointer;
	position: relative;
	left: 60px;
	list-style-type: none;
	width: 200px;
	height: 40px;
	margin-bottom: 10px;
	padding: 6px;
	background-color: rgb(254, 229, 77);
}

ul1>li::after {
	content: "";
	position: absolute;
	top: 10px;
	right: -10px;
	width: 0;
	height: 0;
	border-bottom: 16px solid transparent;
	border-left: 16px solid rgb(254, 229, 77);
}

ul1>li>span {
	display: flex;
	justify-content: center;
	align-items: center;
	width: 16px;
	height: 16px;
	border-radius: 8px;
	background-color: rgb(234, 234, 234);
	position: absolute;
	left: -20px;
	bottom: 2px;
}

form {
	background-color: rgb(240, 240, 240);
	position: absolute;
	bottom: 0;
}

input {
	margin: 0;
	border: none;
	height: 45px;
}

.input1 {
	margin: 0;
	border: none;
	width: 216px;
	height: 45px;
}

input1[type="text"] {
	width: 100%;
}

input1[type="text"]:focus {
	outline: none;
}

input1[type="submit"] {
	cursor: pointer;
	border-radius: 8px;
	background-color: rgb(254, 229, 77);
}

.done {
	color: rgb(93, 93, 93);
	background-color: rgb(234, 234, 234);
}

.done::after {
	border-left: 16px solid rgb(234, 234, 234);
}

table {
	text-align: center;
	border-collapse: collapse;
	border-style: hidden;
	border: solid gray 1px;
}

.tg {
font-weight:bolder;
	color:black;
	border-collapse: collapse;
	border-style: hidden;
	border: solid gray 1px;
	text-align: center;
	border-color: gray;
	border-spacing: 0;
	height:10px;
}

.tg td {
	border-color: gray;
	border-style: solid;
	border-width: 1px;
	font-size: 14px;
	overflow: hidden;
	padding: 17px;
	word-break: normal;
}

.tg th {
	border-color: gray;
	border-style: solid;
	border-width: 1px;
	font-size: 14px;
	font-weight: normal;
	overflow: hidden;
	padding: 10px 5px;
	word-break: normal;
}

.tg .tg-c3ow {
	text-align: center;
	border-color: inherit;
	vertical-align: top
}

.tg .tg-qla2 {
	background-color: #939397;
	border-color: inherit;
	vertical-align: top;
	height:10px;
}

.tg .tg-0pky {
	border-color: inherit;
	vertical-align: top
}

.main11 {
width:300px;
	margin-top: 300px;
	height: 600px;
	border: 0.5px solid gray;
	margin: 0px;
	display: inline-block;
	background: #9bbbd4;
}
    
aside {
	margin-top: -20px;
	float: left;
	width: 350px;
	height: 950px;
}
.t1{
width:1250px;
}
 	 	
 	 	.hang{ 
		height:50px;
 	 	} 
 	 	
 	 	tr:hover {background-color: #dcdcdc;}
	 	
	 	th {
/*  	border: 1px solid #bcbcbc; */
/* 		border: 1px solid #EFEFEF; */
	 	}
	 	
	 	#nu{ width:50px; background: #C5CAD7;
	 	}
	 	#ti{ width:230px; background: #C5CAD7;
	 	}
	 	#wr{ width:90px; background: #C5CAD7;
	 	}
	 	#rd{ width:150px; background: #C5CAD7;
	 	}
	 	#md{ width:230px; background: #C5CAD7;
	 	}
	 	#ct{ width:60px; background: #C5CAD7;
	 	}
	 	
	 	td {
	    width: 120px;
/*   	    border: 1px solid #bcbcbc; */
		
	 	}
	 	
 	 	tr { 
 	    height: 60px; 
/*  	    border: 1px solid #bcbcbc; */
		
 	 	} 
	 	
	 	h1 { text-align: center; }

		#bwr {margin:0 auto; max-width:950px; inline-block;}
		#sch {margin:0 auto; max-width:950px; inline-block;} 
	 	#sub{
	 	  color: white;
		  text-align: center;
		  background: #7C8EBF;
		  border: solid 1px #191970;
		  border-radius: 3px;
	 	}
	 	
	 	#wri{
	 	  color: white;
		  text-align: center;
		  background: #7C8EBF;
		  border: solid 1px #191970;
		  border-radius: 3px;
	 	}
		
		#list{
	 	  color: white;
		  text-align: center;
		  background: #7C8EBF;
		  border: solid 1px #191970;
		  border-radius: 3px;
	 	}
	 	
/* 	 	------------------------------------------------------------------ */
	 	.paging {
		  display: inline-block;
		}
		
		.paging a {
		  color: black;
		  float: left;
		  padding: 8px 16px;
		  text-decoration: none;
		}
		
		.paging a.active {
		  background-color: #4CAF50;
		  color: white;
		  border-radius: 5px;
		}
		
		.paging a:hover:not(.active) {
		  background-color: #ddd;
		  border-radius: 5px;
		}
	 	tr{
	 	height:10px;
	 	}
</style>
<body>
	<%--
request.setAttribute("AUTHUSER", AUTHUSER);

 --%>
	<!-- ***** Main Banner Area Start ***** -->
	<%@ include file="../module/top00.jsp"%>
	<aside>
		<table class="tg"
			style="table-layout: fixed; text-align: center;margin-top: 4px; width: 30px; " >
			<colgroup>
				<col style="width: 150px">
				<col style="width: 200px">
			</colgroup>
			<thead>
				<tr>
					<th class="tg-c3ow" colspan="2" rowspan="2"><img
						style="border-radius: 100px; height: 200px; width: 200px;"
						src="./../assets/images/프로필.PNG" alt=""></th>
				</tr>
				<tr>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="tg-qla2" >사원이름</td>
					<td class="tg-0pky">${AUTHUSER.emp_kname}</td>
				</tr>
				<tr>
					<td class="tg-qla2" >부서</td>
					<td class="tg-0pky">${AUTHUSER.dept_name}</td>
				</tr>
			</tbody>
		</table>

		<div id="main11" >
			<div id="chat-container" >
				<c:forEach var="item" items="${mVOList}">
					<div class="my-chat-box">
						<c:if test="${name==item.name}">
							<div class="chat my-chat">
								<c:out value="${item.content}" />
							</div>
							<div class="chat-info">
								<fmt:formatDate pattern="yyyy.MM.dd HH:mm:ss"
									value="${item.sendTime}" />
								<br />
							</div>
						</c:if>
					</div>
					<div class="chat-box">
						<c:if test="${name!=item.name}">
							<div class="chat">
								<c:out value="${item.name}:${item.content}" />
							</div>
							<div class="chat-info chat-box">
								<fmt:formatDate pattern="yyyy.MM.dd HH:mm:ss"
									value="${item.sendTime}" />
								<br />
							</div>
						</c:if>
					</div>
				</c:forEach>
			</div>
			<div id="bottom-container">
				<input name="inputMessage" id="inputMessage" type="text"
					class="inputMessage"> <input id="btn-submit" type="submit"
					value="전송">
			</div>
		</div>











	</aside>
	<section id="men" style="margin-top: -100px; margin-left: 239px;">
		<div class="container">
			<div class="row">
				<div class="col-lg-5">
					<div class="section-heading">
						<h2
							style="background: #505D93; background: linear-gradient(to right, #505D93 0%, #ABABAB 100%); -webkit-background-clip: text; -webkit-text-fill-color: transparent;">
							<strong>Astro Company</strong>
						</h2>
					</div>
				</div>
			</div>
		</div>
		<div class="container" style="margin-top: -50px; float: inherit;">
			<div class="row">
				<div class="col-lg-12">
					<div class="men-item-carousel">
						<div class="owl-men-item owl-carousel">
							<div class="item">
								<div class="thumb">
									<img src="./../assets/images/sell2.png" alt="">
								</div>
								<div class="down-content"></div>
							</div>
							<div class="item">
								<div class="thumb">
									<img src="./../assets/images/sell3.png" alt="">
								</div>
								<div class="down-content"></div>
							</div>
							<div class="item">
								<div class="thumb">
									<img src="./../assets/images/sell4.png" alt="">
								</div>
								<div class="down-content"></div>
							</div>
							<div class="item">
								<div class="thumb">
									<img src="./../assets/images/sell5.png" alt="">
								</div>
								<div class="down-content"></div>
							</div>
							<div class="item">
								<div class="thumb">
									<img src="./../assets/images/sell1.png" alt="">
								</div>
								<div class="down-content"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	
	
	
	<div style="height:500px; width:1300px; margin-left:450px;">	


<br/>
	
	<h2><strong>공지사항</strong></h2>
<br/><br/>
	
 <table class="t1" border="1" style="table-layout: fixed;">		
 	<thead>
 		<tr class="hang">
 			<th id="nu">번호</th>
 			<th id="ti">제목</th>
 			<th id="wr">작성자</th>
 			<th id="rd">작성일</th>
 			<th id="md">최종수정일</th>
 			<th id="ct">조회수</th>
 		</tr>
 	</thead>
 

 	<tbody>
 	<%--  keyword가 없으면서 게시글이 없는 경우 --%>
 	<%-- JSTL if조건문 이용하여 출력 --%>
 	<c:if test="${empty keyword or (keyword eq '')}">
	 	<c:if test="${noticePage.hasNoNotices()}"> 
	 	 <tr>
	 		<td colspan="6" style="text-align:center;">게시글이 없습니다.</td>
	 	</tr>
	 	</c:if>
 	</c:if>
 	<%--  keyword가 있으면서 결과가 없는 경우 --%>
 	<%-- JSTL if조건문 이용하여 출력 --%>
 	 <c:if test="${not empty keyword or (keyword ne '')}">
	 	<c:if test="${noticePage.hasNoNotices()}"> 
	 	 <tr>
	 		<td colspan="6" style="text-align:center;">결과가 없습니다.</td>
	 	</tr>
	 	</c:if>
 	</c:if>

 	<%-- JSTL forEach 반복문 이용하여 출력시작 
 		for(int i=1; i<=10; i++){syso (i)} 1 2 3 ....9 10  
 		for(타입 변수명 : 컬렉션명){ syso(변수명) }
 		--%>
<%--  	<c:forEach var="i" begin="1" end="10" step="1"> 
  	<c:forEach var="item" items="${listNotice}">
 		<c:out value="${item}" /><br/><br/>
 	</c:forEach>
 	<br/><br/><br/><br/><br/><br/> --%>
 	
<%--  	<c:forEach var="item" items="${listNotice}"> --%>
	<c:if test="${noticePage.hasNotices()}"> 
 	<c:forEach var="item" items="${noticePage.content}">
 	<tr>
 		<td>${item.number}</td>
 		<td><a href="<%=request.getContextPath()%>/notice/read.do?no=${item.number}&pageNo=${noticePage.currentPage}&rowSize=${rowSize}">${item.title}</a></td>
 		<td>${item.writer.writer_name}</td>
<%--  		<td>${item.regdate}(YYYY-MM-DD)</td> --%>
<%--  		<td><fmt:formatDate type="date" value="${item.regdate}" /></td> --%>
 		<td>
<%--  			<fmt:formatDate type="date" value="${item.regdate}" /><br/> --%>
<%--  			<fmt:formatDate pattern="yyyy-MM-dd" type="date" value="${item.regdate}" /><br/> --%>
<%--  			<fmt:formatDate pattern="yyyy년 MM월 dd일" type="date" value="${item.regdate}" /><br/> --%>
 			<fmt:formatDate pattern="yyyy.MM.dd. HH:mm:ss" type="date" value="${item.regdate}" /></td>
 		<td><fmt:formatDate pattern="yyyy.MM.dd. HH:mm:ss" type="date" value="${item.moddate}" /></td>
 		<td>${item.read_cnt}</td>
 	</tr>
 	</c:forEach>
 	</c:if>
 	</tbody>
  </table>	
		
 	
</div>
<br><br><br><br>





	<!-- jQuery -->
	<script
		src="<%=request.getContextPath()%>/assets/js/jquery-2.1.0.min.js"></script>

	<!-- Bootstrap -->
	<script src="<%=request.getContextPath()%>/assets/js/popper.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>

	<!-- Plugins -->
	<script src="<%=request.getContextPath()%>/assets/js/owl-carousel.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/accordions.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/datepicker.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/scrollreveal.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/waypoints.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/jquery.counterup.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/imgfix.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/slick.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/lightbox.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/isotope.js"></script>

	<!-- Global Init -->
	<script src="<%=request.getContextPath()%>/assets/js/custom.js"></script>
	<script>

       $(function() {
           var selectedClass = "";
            $("p").click(function(){
            selectedClass = $(this).attr("data-rel");
           $("#portfolio").fadeTo(50, 0.1);
               $("#portfolio div").not("."+selectedClass).fadeOut();
            setTimeout(function() {
              $("."+selectedClass).fadeIn();
              $("#portfolio").fadeTo(50, 1);
            }, 500);
           });
       });
    </script>

	<%@ include file="../module/bottom00.jsp"%>
</body>


<script>
	

	var textarea = document.getElementById("messageWindow");
	var webSocket = new WebSocket('ws://localhost/webChatServer');
  //var webSocket = new WebSocket('ws://172.30.1.57/webChatServer');
	var inputMessage = document.getElementById('inputMessage');
	
	webSocket.onerror = function(e){
		onError(e);
	};
	webSocket.onopen = function(e){
		onOpen(e);
	};
	webSocket.onmessage = function(e){
		onMessage(e);
	};
	
	function onMessage(e){
		var chatMsg = event.data;
		var date = new Date();	//시간
		var dateInfo = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
		if(chatMsg.substring(0,6) == 'Server'){
			var $chat = $("<div class='chat notice'>" + chatMsg + "</div>");
			$('#chat-container').append($chat);
		}else{
			var $chat = $("<div class='chat-box'><div class='chat'>" + chatMsg + "</div><div class='chat-info chat-box'>"+ dateInfo +"</div></div>");
			$('#chat-container').append($chat);
		}
		
		
		$('#chat-container').scrollTop($('#chat-container')[0].scrollHeight+20);
	}
	
	function onOpen(e){
		
	}
	
	function onError(e){
		alert("서비스 장애! 재 접속하세요");
		location.href="http://localhost/login.do";
	}
	
	function onClose(e) {
		alert("접속이 종료 되었습니다.")
	}
	
	function send(){
		var chatMsg = inputMessage.value;
		if(chatMsg == ''){
			return;
		}
		var date = new Date();
		var dateInfo = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
		var $chat = $("<div class='my-chat-box'><div class='chat my-chat'>" + chatMsg + "</div><div class='chat-info'>"+ dateInfo +"</div></div>");
		$('#chat-container').append($chat);
		webSocket.send(chatMsg);
		inputMessage.value = "";
		$('#chat-container').scrollTop($('#chat-container')[0].scrollHeight+20);
	}
	
</script>
</html>




