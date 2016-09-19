<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/modern-business.css" rel="stylesheet">

<!-- user CSS -->
<link href="css/usermain.min.css" rel="stylesheet">

<!-- new-age CSS -->
<!-- <link href="css/new-age.min.css" rel="stylesheet"> -->

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
   type="text/css">

<link rel="stylesheet" type="text/css" href="css/login.css" />



<!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
<!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<title>재능 교육 사이트 - WhyNot?</title>
</head>
<body>
   <!-- 상단 메뉴바 -->
   <nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
      <div class="container">
         <!-- Brand and toggle get grouped for better mobile display -->
         <div class="navbar-header">
            <!-- 모바일 화면시 메뉴 버튼 -->
            <button type="button" class="navbar-toggle collapsed"
               data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
               <span class="sr-only">Toggle navigation</span> <span
                  class="icon-bar"></span> <span class="icon-bar"></span> <span
                  class="icon-bar"></span>
            </button>

            <!-- 좌측상단 팀명 -->
            <a class="navbar-brand" id="logo" href="main.app">WhyNot?</a>

            <!-- 모바일 화면시 검색버튼 -->
            <button type="button" class="navbar-search" data-toggle="collapse"
               data-target="#search-btn">검색</button>

            <!-- 검색 입력창 -->
            <form class="navbar-form navbar-left" role="search">
               <input type="text" class="form-control-search" placeholder="Search"
                  id="search-btn">
               <!-- <button type="submit" class="btn btn-default">Submit</button> -->
            </form>
         </div>

         <!-- 우측 상단 메뉴 -->
         <div class="collapse navbar-collapse"
            id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
               <li style="padding-top:8px">
                  <a href="login/login.jsp" type="button" id="login"
                     data-toggle="modal"
                     data-target=".bs-example-modal-sm" style="padding-top:8px; border:0; background-color: transparent;">Login</a>
               </li>


               <li><a href="insert.member" id="singup">Singup</a></li>

            </ul>
         </div>
         <!-- /.navbar-collapse -->
      </div>
      <!-- /.container-fluid -->
   </nav>
   <!-- 상단 메뉴바 끝 -->

   <!-- 로그인 - 모달 속성  -->	
   <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog"
      aria-labelledby="mySmallModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-sm">
         <div class="modal-content">...</div>
      </div>
   </div>
