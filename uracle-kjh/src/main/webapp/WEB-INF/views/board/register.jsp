<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../include/header.jsp"%>

</head>
<body>
	<section class="content">
		<div class="box-header">
			<h3 class="box-title">게시판 글쓰기</h3>
		</div>

		<form role="form" method="post" action="/jh/board/register.do">
			<div class="box-body">
				<div class="form-group">
					<label>제목</label> 
					<input type="text" name='title' class="form-control" placeholder="제목을 입력하세요">
				</div>
				<div class="form-group">
					<label>내용</label>
					<textarea class="form-control" name="body" rows="3" placeholder="내용을 입력하세요"></textarea>
				</div>

				<div class="form-group">
					<label>작성자</label> 
					<input type="text" name="writer" class="form-control" placeholder="작성자를 입력하세요">
				</div>
			</div>

			<div class="box-footer">
				<button type="submit" class="btn btn-primary">작성완료</button>
			</div>
		</form>
	</section>
	<%@include file="../include/footer.jsp"%>
</body>
</html>