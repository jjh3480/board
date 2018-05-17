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
		$('#btnOk').click(function(){
			$('#frm').submit();
		})
	})
</script>
<style>
	#width{
		width: 1000px;
	}
</style>
</head>
<body>
	<%@ include file="/layout/header.jsp" %>
	<div class="container-fluid">
		<div class="row">
		<%@ include file="/layout/left.jsp" %>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="form-group">
					<div class="col-sm-4">
						<form id="frm" action="${pageContext.request.contextPath }/insertReply" class="form-horizontal" role="form"
	 						enctype="multipart/form-data">
							<c:forEach items="${boardList }" var="vo">
								<input type="hidden" name="board_seq" value="${vo.board_seq }">
								<input type="hidden" name="reg_id" value="${vo.reg_id }">
								<table id="width">
									<tbody>
										<tr>
											<td>제목 : ${vo.title }</td>
											<td>작성일자 : <fmt:formatDate value="${vo.reg_dt }" pattern="yyyy-MM-dd"/></td>
										</tr>
										<tr>
											<td rowspan="1">작성자 : ${vo.reg_id }</td>
										</tr>
										<tr>
											<td rowspan="1" width="500px;">${vo.content }</td>
										</tr>
									</tbody>
								</table>
							</c:forEach>
							<br>
							<br>
							<div id="width">
								<%-- <c:forEach items="" var="">
								<!-- 입력된 댓글 나타나기 -->
								</c:forEach> --%>
								<div id="width">
										<textarea id="text" style="width: 500px; height: 50px;" name="content"></textarea>
										<button id="btnOk" type="button">입력</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>