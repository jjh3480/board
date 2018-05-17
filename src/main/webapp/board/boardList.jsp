<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
  	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
	<link rel="icon" href="../../favicon.ico">

<script src="https://code.jquery.com/jquery-3.3.1.js"integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="crossorigin="anonymous"></script>
<link href="/board/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/board/css/dashboard.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
<script>
	$(function(){
		$('#newBoard').click(function(){
			$('#frm').submit();
		})
		$('#addBoard').click(function(){
				document.location="${pageContext.request.contextPath}/board/boardPageInsert.jsp";
			})
	})
</script>


<body>
	<%@ include file="/layout/header.jsp" %>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/layout/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h2 class="sub-header">게시글</h2>
				
				<div class="table-responsive">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<td>게시글번호</td>
								<td>제목</td>
								<td>작성자</td>
								<td>작성일시</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${boardList }" var="bvo">
								<tr>
									<td><a href="${pageContext.request.contextPath }/getBoard?board_seq=${bvo.board_seq}">${bvo.board_seq}</a></td>
									<td><a href="${pageContext.request.contextPath }/getBoard?board_seq=${bvo.board_seq}">${bvo.title}</a></td>
									<td><a href="${pageContext.request.contextPath }/getBoard?board_seq=${bvo.board_seq}">${bvo.reg_id}</a></td>
									<td><a href="${pageContext.request.contextPath }/getBoard?board_seq=${bvo.board_seq}"><fmt:formatDate value="${bvo.reg_dt }" pattern="yyyy-MM-dd"/></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<button id="newBoard" type="button" class="btn btn-default">게시글 추가</button>
				<form id="frm" action="${pageContext.request.contextPath }/bpSeq" class="form-horizontal" role="form"
				 	enctype="multipart/form-data">
					<input type="hidden" name="bp_seq" value="${boardCheck }">
				</form>
				${pageNav }
			</div>
		</div>
	</div>
	</body>
</html>