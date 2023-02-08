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
 <title>ASTRO SOFTWARE</title>
 <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/font-awesome.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/templatemo-hexashop.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/owl-carousel.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/lightbox.css">
     </head>
    
                    <div class="service-item">
<body>
<%@ include file="module/top00.jsp" %>
<!-- ***** Main Banner Area Start ***** -->
  
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
                        <p>사원이름: <br>
                        사원번호:<br>
                        직급:<br>
                        부서:<br></p>
                        
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
                        <h4>공지?</h4>
                        
                        <img src="" alt="">
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





 <%@ include file="module/bottom00.jsp" %> 
</body>
</html>






