<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
    <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/signin.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>    
<script>
	function login(){
		$('#userId').focus();
		$("#signinbtn").click(function(){
			$("#frm").submit();
		})
	}
	
	$(function(){
		login();
	})
</script>
</head>
<body>
	<div class="container">
		<form class="form-signin" id="frm" action="${pageContext.request.contextPath }/loginUser" method="post">
	    	<h2 class="form-signin-heading">Please sign in</h2>
	        
	        <label for="userId" class="sr-only">UserId</label>
	        <input type="text" id="userId" name="userId" class="form-control" placeholder="아이디를 입력하세요" required autofocus>
			<br>
	        
	        <label for="password" class="sr-only">Password</label>
	        <input type="password" id="password" name="password" class="form-control" placeholder="비밀번호를 입력하세요" required>
			<div class="checkbox">
	          <label>
	            <input type="checkbox" id="remember" name="remember" value="remember-me"> 아이디 저장
	          </label>
	        </div>
	        <button id="signinbtn" class="btn btn-lg btn-primary btn-block" type="button">로그인</button>
	        
	    </form>
	 </div>
</body>
</html>