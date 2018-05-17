<%@page import="board.model.BoardPageVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="col-sm-3 col-md-2 sidebar">
		<ul class="nav nav-sidebar">
			<li>
				<button id="addBoard" type="button" class="btn btn-default">게시판 추가</button>
			</li>
			<c:forEach items="${boardPageList }" var="vo">
				<li>
					<a href="${pageContext.request.contextPath }/getBoardPageList?bp_seq=${vo.bp_seq }">${vo.bp_title }</a>
				</li>
			</c:forEach>
		</ul>
	</div>
