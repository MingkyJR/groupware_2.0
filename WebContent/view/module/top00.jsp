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
                            <li class="scroll-to-section"><a href="<%=request.getContextPath()%>/view/main.jsp">메인페이지</a></li>
                            <li class="scroll-to-section"><a href="#">공지사항</a></li>
                            <li class="submenu">
                                <a href="<%=request.getContextPath()%>/work.do">근태관리</a>
                                <ul>
                                    <li><a href="<%=request.getContextPath()%>/work.do">근태관리</a></li>
                                    <li><a href="<%=request.getContextPath()%>/workEdit.do">출퇴근 수정</a></li>
                                    <c:if test="${AUTHUSER.emp_grade eq 5}">
                                    <li><a href="<%=request.getContextPath()%>/work_admin.do">직원 근태현황 조회</a></li>
                                    <li><a href="#">직원 출퇴근 수정</a></li>
                                    </c:if>
                                </ul>
                            </li>
                            <li class="scroll-to-section"><a href="<%=request.getContextPath()%>/secondHand/list.do">중고장터</a></li>
                            <li class="scroll-to-section"><a href="#">메세지</a></li>
                             <li class="submenu">
                                <a href="javascript:;">전자결재</a>
                  <c:if test="${!empty AUTHUSER && (AUTHUSER.emp_grade ne 5)}">
                                <ul>
                                    <li><a href="<%=request.getContextPath()%>/view/eApproval/4-00.통합페이지.jsp">통합페이지</a></li>
                                    <li><a href="<%=request.getContextPath()%>/document/writeDocument.do">전자결재</a></li>
                                    <li><a href="<%=request.getContextPath()%>/view/eApproval/4-12.대기문커버리스트.jsp">결재대기 </a></li>
                                    <li><a href="<%=request.getContextPath()%>/view/eApproval/4-13.승인문커버리스트.jsp">승인결과 </a></li>
                                </ul>
                  </c:if>
                  <c:if test="${not empty AUTHUSER && (AUTHUSER.emp_grade eq 5)}">
                                <ul>
                                    <li><a href="<%=request.getContextPath()%>/view/eApproval/4-00.통합페이지2.jsp">전자결재</a></li>
                                </ul>
                  </c:if>
                            </li>
                            <li class="submenu">
                                <a href="javascript:;">마이페이지</a>
                                <ul>
                                    <li><a href="/login.do">로그인</a></li>
                                    <li><a href="/logout.do">로그아웃</a></li>
                                    <li><a href="/changeMyInfo.do">개인정보</a></li>
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
    
    