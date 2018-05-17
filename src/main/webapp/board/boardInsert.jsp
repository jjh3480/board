<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html lang="ko">
  <head>
  	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="crossorigin="anonymous"></script>
<script>
	$(function(){
		$('#bp_title').focus();
		
		$('#boardAdd').click(function(){
			if($('#title').val().trim()==""){
				alert("게시글 제목을 입력하세요.");
				return;
			}
			if($('#content').val().trim()==""){
				alert("내용을 입력하세요.");
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
				<form id="frm" action="${pageContext.request.contextPath }/insertBoard" class="form-horizontal" role="form"
				 enctype="multipart/form-data">
				 	<input type="hidden" name="bp_seq" value="${bp_seq }">
					<div class="form-group">
						<label for="boardTitle" class="col-sm-2 control-label">게시글 제목 : </label>
						<div class="col-sm-4" id="titleButton">
							<input type="text" class="form-control" id="title" name="title"
								placeholder="게시글 제목입력">
						</div>
						<input type="file" name="profile">
					</div>

					<div class="form-group">
						<label for="boardTitle" class="col-sm-2 control-label">게시글 내용 : </label>
						<div class="col-sm-4">
							<textarea class="form-control" name="content" id="content" rows="10" cols="100" style="width:766px; height:412px;"></textarea> 
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="boardAdd" type="button" class="btn btn-default">등록</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>