<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
  	<meta charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <title>Dashboard Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
    <script>
		$(function(){
			//게시판 추가
			$('#addBoard').click(function(){
				document.location="${pageContext.request.contextPath}/board/boardPageInsert.jsp";
			})
				$('#bp_title').focus();
			
			$('#boardAdd').click(function(){
				if($('#bp_title').val().trim()==""){
					alert("게시판 제목을 입력하세요.");
					return;
				}
				
				$('#frm').submit();
			})
		})
	</script>
  </head>

  <body>
  
	<%@ include file="/layout/header.jsp" %>
	
    <div class="container-fluid">
      <div class="row">
		<%@ include file="/layout/left.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        	<h2>${userId }님 환영합니다.</h2>
        	<hr>
        	<h3><===게시판을 클릭하세요</h3>
        </div>
      </div>
    </div>


  </body>
</html>
