<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
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
    
    <!-- ***** Preloader Start ***** -->
    <div id="preloader"></div>  
    <!-- ***** Preloader End ***** -->
    
       <!-- ***** Header Area Start ***** -->
    <header class="header-area header-area">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav class="main-nav">
                        <!-- ***** Logo Start ***** -->
                        <a href="./main.jsp" class="logo" >
                            <img  src="./../../assets/images/logo.png">
                        </a>
                        <!-- ***** Logo End ***** -->
                            <a id="today" class="today">일자</a><br>
                            <a id="time"  class="time">시간</a>
                        <!-- ***** Menu Start ***** -->
                        <ul class="nav">
                            <li class="scroll-to-section"><a href="./main.jsp" class="active">메인페이지</a></li>
                            <li class="scroll-to-section"><a href="#">공지사항</a></li>
                            <li class="submenu">
                                <a href="javascript:;">근태관리</a>
                                <ul>
                                    <li><a href="<%=request.getContextPath()%>/work.do">근태관리</a></li>
                                    <li><a href="<%=request.getContextPath()%>/document/listDocument.do">결재대기 </a></li>
                                    <li><a href="<%=request.getContextPath()%>/document/passDocument.do">승인결과 </a></li>
                                </ul>
                            </li>
                            <li class="scroll-to-section"><a href="#">중고장터</a></li>
                            <li class="scroll-to-section"><a href="#">메세지</a></li>
                             <li class="submenu">
                                <a href="javascript:;">전자결재</a>
                                <ul>
                                    <li><a href="./4-00.통합페이지.jsp">통합페이지</a></li>
                                    <li><a href="<%=request.getContextPath()%>/document/writeDocument.do">전자결재</a></li>
                                    <li><a href="<%=request.getContextPath()%>/document/listDocument.do">결재대기 </a></li>
                                    <li><a href="<%=request.getContextPath()%>/document/passDocument.do">승인결과 </a></li>
                                </ul>
                            </li>
                            <li class="submenu">
                                <a href="javascript:;">마이페이지</a>
                                <ul>
                                    <li><a href="/logout.do">로그아웃</a></li>
                                    <li><a href="#">개인정보</a></li>
                                    <li><a href="#">Features Page 3</a></li>
                                </ul>
                            </li>
                            
                        </ul>        
                        <a class='menu-trigger'>
                            <span>Menu</span>
                        </a>
                        <!-- ***** Menu End ***** -->
                    </nav>
                </div>
            </div>
        </div>
      
    </header>
  <script src="<%=request.getContextPath()%>/assets/js/timeJs.js"></script>
    
    