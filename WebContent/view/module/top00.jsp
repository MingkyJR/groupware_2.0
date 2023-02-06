<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
                        <a href="<%=request.getContextPath()%>/view/main.jsp" class="logo" >
                            <img  src="<%=request.getContextPath()%>/assets/images/logo.png">
                        </a>
                        <!-- ***** Logo End ***** -->
                        <!-- ***** Menu Start ***** -->
                        <ul class="nav">
                            <li class="scroll-to-section"><a href="<%=request.getContextPath()%>/view/main.jsp" class="active">메인페이지</a></li>
                            <li class="scroll-to-section"><a href="#">공지사항</a></li>
                            <li class="scroll-to-section"><a href="#">근태관리</a></li>
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
    <br>
    <br>
    <br>
    <br>
    
    