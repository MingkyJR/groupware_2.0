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
<style>
.container1{
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
}

.app1{
  position: relative;
  width: 320px;
  height: 568px;
  border-radius: 16px;
  background-color: rgb(171, 193, 209);
}

.app1  > h1{
  font-size: 2em;
  text-align: center;
  margin: 10px 5px;
  border-bottom: 0.5px solid rgb(234, 234, 234);
}

ul1{
  max-height: 420px;
  overflow: auto;
}

ul1 > li{
  cursor: pointer;
  position: relative;
  left: 60px;
  list-style-type: none;
  width: 200px;
  height: 40px;
  margin-bottom: 10px;
  padding: 6px;
  background-color: rgb(254, 229, 77);
  border-radius: 8px;
}

ul1 > li::after{
  content: "";
  position: absolute;
  top: 10px;
  right: -10px;
  width: 0;
  height: 0; 
  border-bottom: 16px solid transparent;
  border-left: 16px solid rgb(254, 229, 77);
}

ul1 > li > span{
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

form{
  background-color: rgb(255, 255, 255);
  position: absolute;
  bottom: 0;
}
input{
  font-size: 1.4em;
  margin: 0;
  border: none;
  height: 45px;
}
input[type="text"]{
  width:70%;
  padding-left: 10px;
}
input[type="text"]:focus{
  outline: none;
}
input[type="submit"]{
  cursor: pointer;
  width: 80px;
  border-radius: 8px;
  background-color: rgb(254, 229, 77);
}

.done{
  color: rgb(93, 93, 93);
  background-color: rgb(234, 234, 234);
}

.done::after{
  border-left: 16px solid rgb(234, 234, 234);
}

</style>
<body>
<%@ include file="module/top00.jsp" %>
<!-- ***** Main Banner Area Start ***** -->
  
<section id="men" style="margin-top:-100px;">
        <div class="container">
            <div class="row">
                <div class="col-lg-5">
                    <div class="section-heading">
                        <h2 style="background: #505D93;background: linear-gradient(to right, #505D93 0%, #ABABAB 100%);-webkit-background-clip: text;-webkit-text-fill-color: transparent;">
                          <strong>Astro Company</strong>
                        </h2>
                     </div>
                </div>
            </div>
        </div>
        <div class="container" style="margin-top:-50px; float:inherit;">
            <div class="row">
                <div class="col-lg-12">
                    <div class="men-item-carousel">
                        <div class="owl-men-item owl-carousel">
                            <div class="item">
                                <div class="thumb">
                                    <img src="./../assets/images/sell1.png" alt="">
                                </div>
                                <div class="down-content">
                                </div>
                            </div>
                            <div class="item">
                                <div class="thumb">
                                    <img src="./../assets/images/sell2.png" alt="">
                                </div>
                                <div class="down-content">
                                </div>
                            </div>
                            <div class="item">
                                <div class="thumb">
                                    <img src="./../assets/images/sell3.png" alt="">
                                </div>
                                <div class="down-content">
                                </div>
                            </div>
                            <div class="item">
                                <div class="thumb">
                                    <img src="./../assets/images/sell4.png" alt="">
                                </div>
                                <div class="down-content">
                                </div>
                            </div>
                            <div class="item">
                                <div class="thumb">
                                    <img src="./../assets/images/sell5.png" alt="">
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
                        <h5>사원이름:오동효 </h5><br>
                        <h5>사원번호:23</h5><br>
                        <h5>직급:대리</h5><br>
                        <h5>부서:회계부</h5><br>
                        
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="service-item">
                    <div class="container1">
									    <div class="app1">
									      <h1>메 모 장</h1>
									      <ul id="todo-list" class="ul1">
									      </ul>
									      <form id="todo-form">
									        <input name="todo" type="text" placeholder="작성란" maxlength="16" autocomplete="off"><input type="submit" value="추가">
									      </form>
									    </div>
									  </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="service-item">
                        <h4>사내 메신져</h4>
                        
                        <p></p>
                        
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
       
    // 요소 선택 및 배열 선언
       const todoList = document.getElementById('todo-list')
       const todoForm = document.getElementById('todo-form')
       let todoArr = [];

       // displayTodos 함수
       function displayTodos(){
         todoList.innerHTML = ""
         todoArr.forEach((aTodo) => {
           const todoItem = document.createElement('li')
           const todoDelBtn = document.createElement('span')
           todoDelBtn.innerText = 'x'
           todoDelBtn.title = '클릭시 삭제'
           todoItem.innerText = aTodo.todoText
           todoItem.title = '클릭시 완료'
           todoItem.classList.add(aTodo.todoDone ? 'done' : 'yet')
           todoItem.appendChild(todoDelBtn)
           todoDelBtn.addEventListener('click', function(){
             handleTodoDelBtnClick(aTodo.todoId)
           })
           todoItem.addEventListener('click', function(){
             handleTodoItemClick(aTodo.todoId)
           })
           todoList.appendChild(todoItem)
         });
       }

       // handleTodoDelBtnClick 함수
       function handleTodoDelBtnClick(clickedId){
         todoArr = todoArr.filter(function(aTodo){
           return aTodo.todoId !== clickedId
         })
         displayTodos()
         saveTodos()
       }

       // handleTodoItemClick 함수
       function handleTodoItemClick(clickedId){
         todoArr = todoArr.map(function(aTodo){
           return aTodo.todoId !== clickedId ? 
           aTodo : { ...aTodo, todoDone: !aTodo.todoDone } 
         })
         displayTodos()
         saveTodos()
       }

       // saveTodos 함수
       function saveTodos(){
         const todoSting = JSON.stringify(todoArr)
         localStorage.setItem('myTodos', todoSting)
       }

       // loadTodos 함수
       function loadTodos(){
         const myTodos = localStorage.getItem('myTodos') 
         todoArr = myTodos !== null ? JSON.parse(myTodos) : todoArr
         displayTodos()
       }

       // 할일 입력 후 제출하면 발생하는 이벤트 핸들링
       todoForm.addEventListener('submit', function(e){
         e.preventDefault()
         const toBeAdded = {
           todoText: todoForm.todo.value,
           todoId: new Date().getTime(),
           todoDone: false
         }
         todoForm.todo.value = ""
         todoArr.push(toBeAdded)
         displayTodos()
         saveTodos()
       })

       loadTodos() 
    </script>





 <%@ include file="module/bottom00.jsp" %> 
</body>
</html>






