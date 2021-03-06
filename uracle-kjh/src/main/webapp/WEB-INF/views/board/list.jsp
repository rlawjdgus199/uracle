<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>목록보기</title>
</head>
<body>
	<%@include file="../include/header.jsp"%>
	<div class="box">
	<p><b>${sessionScope.login.userid}</b>님이 로그인중입니다.</p> 
		<div class="box-header with-border">
			<c:if test="${msg == null}">
				<h3 class="box-title">게시판 목록보기</h3>
			</c:if>
			<c:if test="${msg != null}">
				<h3 class="box-title">${msg}</h3>
			</c:if>
		</div>
		<div class="box-body">
			<table class="table table-bordered table-hover">
				<tr>
					<th width="11%">글번호</th>
					<th width="46%"><a href="detail">제목</a></th>
					<th width="16%">작성자</th>
					<th width="16%">작성일</th>
					<th width="16%">조회수</th>
					
				</tr>
				<c:forEach var="vo" items="${list}" varStatus="status">
					<tr>
						<td align="right">${status.count}&nbsp;</td>
						<td>&nbsp; <a href="detail?id=${vo.id}">${vo.title}</a></td>
						<td>&nbsp;${vo.writer}</td>
						
			<td>&nbsp;<fmt:formatDate value="${vo.regDate}" type="date"
					pattern="yyyy-MM-dd" />
			</td>
			<td>&nbsp;${vo.redcnt}</td>
			</c:forEach>
			</table>
		</div>
		<div class="box-footer">
			<div class="text-center">
				<button id='writeBtn' class="btn-primary">글쓰기</button>
				<button id='logout' class="btn-primary">로그아웃</button>
			</div>
			
			<script>
				$(function() {
					$('#writeBtn').on("click", function(event) {
						location.href = "register";
					});
					
					$('#logout').on("click", function(event) {
						location.href = "../user/logout";
				});
				});
			</script>
		</div>
	</div>
	<%@include file="../include/footer.jsp"%>
	 
	
</body>

<style>
.table th {
	text-align: center;
}
</style>

</html>


