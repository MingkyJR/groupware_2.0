<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
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
  <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/font-awesome.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/templatemo-hexashop.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/owl-carousel.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/lightbox.css">
     </head>
 
 
</head>
<body>
<%--
request.setAttribute("AUTHUSER", AUTHUSER);

 --%>
 ${AUTHUSER} 
<!-- ***** Main Banner Area Start ***** -->
  <%@ include file="../module/top00.jsp" %>
<section id="men" style="margin-top:-100px;">
        <div class="container">
            <div class="row">
                <div class="col-lg-5">
                    <div class="section-heading">
                        <h3><strong>Astro Company</strong></h3>
                     </div>
                </div>
            </div>
        </div>
        <div class="container" style="margin-top:-50px;">
            <div class="row">
                <div class="col-lg-10">
                    <div class="men-item-carousel">
                        <div class="owl-men-item owl-carousel">
                            <div class="item">
                                <div class="thumb">
                                    <img src="./../assets/images/sell.png" alt="">
                                </div>
                                <div class="down-content">
                                </div>
                            </div>
                            <div class="item">
                                <div class="thumb">
                                    <img src="./../assets/images/sell.png" alt="">
                                </div>
                                <div class="down-content">
                                </div>
                            </div>
                            <div class="item">
                                <div class="thumb">
                                    <img src="./../assets/images/sell.png" alt="">
                                </div>
                                <div class="down-content">
                                </div>
                            </div>
                            <div class="item">
                                <div class="thumb">
                                    <img src="./../assets/images/sell.png" alt="">
                                </div>
                                <div class="down-content">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- ***** Main Banner Area Start ***** -->
     <section class="our-services">
        <div class="container">
            <div class="row">
                <div class="col-lg-10">
                    <div class="section-heading">
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="service-item">
                        <h4>현재 접속자</h4>
                        <img src="./../assets/images/프로필.PNG" alt="">
                        <p>사원이름:${AUTHUSER.emp_kname}  <br>
                        사원번호:${AUTHUSER.emp_no}<br>
                        직급:${AUTHUSER.emp_position}<br>
                        부서:${AUTHUSER.dept_name}<br></p>
                        
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="service-item">
                        <h4>근태관리</h4><br>
                        <p>출퇴근관리<br> 출근 / 퇴근 </p><br><br><br>
                        <h4>전자결재</h4><br>
                        <p>대기문서<br>반려문서<br>승인문서<br> </p>
                    </div>
                </div>
                <div class="col-lg-4">

	<div id="main-container">
		<div id="chat-container">
		<c:forEach  var="item" items="${mVOList}">
			<div class="my-chat-box">
				<c:if test="${name==item.name}">
					<div class="chat my-chat">
						<c:out value="${item.content}"/></div>
							<div class="chat-info">
					<fmt:formatDate pattern="yyyy.MM.dd HH:mm:ss" value="${item.sendTime}" /><br/>
							</div>
				</c:if>
				</div>
				<div class="chat-box">
					<c:if test="${name!=item.name}">
					<div class="chat">
					<c:out value="${item.name}:${item.content}"/></div>
					<div class="chat-info chat-box">
					<fmt:formatDate pattern="yyyy.MM.dd HH:mm:ss" value="${item.sendTime}" /><br/>
					</div>
					</c:if>
					</div>
		</c:forEach>
		</div>
		<div id="bottom-container">
			<input name="inputMessage" id="inputMessage" type="text" class="inputMessage">
			<input id="btn-submit" type="submit" value="전송" >
		</div>
	</div>
	 </div>
                </div>
            </div>
        
    </section>
	<!-- jQuery -->
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

	<%@ include file="../module/bottom00.jsp" %> 
</body>


<script>
	

	var textarea = document.getElementById("messageWindow");
	//var webSocket = new WebSocket('ws://localhost/webChatServer');
	var webSocket = new WebSocket('ws://172.30.1.84/webChatServer');
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
<!-- 엔터 클릭시 send -->
<script>
	$(function(){
		$('#inputMessage').keydown(function(key){
			if(key.keyCode == 13){
				$('#inputMessage').focus();
				send();
			}
		});
		$('#btn-submit').click(function(){
			send();
		});
		
	})
</script>
</html>




