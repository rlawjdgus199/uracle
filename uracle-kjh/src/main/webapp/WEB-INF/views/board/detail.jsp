<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세보기</title>
</head>
<body>
	<%@ include file="../include/header.jsp" %>
	<section class="content">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">상세보기</h3>
			</div>
			<div class="box-body">
	<div class="form-group">
		<label>제목</label>
		<input type="text" name="title"
		class="form-control" value="${vo.title}"
		readonly="readonly" />
	</div>
				
	<div class="form-group">
		<label>내용</label>
		<textarea name="content" rows="5"
		readonly="readonly" class="form-control">${vo.body}</textarea>
	</div>
				
	<div class="form-group">
		<label>작성자</label>
		<input type="text" name="id"
		class="form-control" value="${vo.writer}"
		readonly="readonly" />
		</div>
	</div>
<div class="box-footer">
	<button class="btn btn-success">메인</button>
	<button class="btn btn-warning">수정</button>
	<button class="btn btn-danger">삭제</button>
	<button class="btn btn-primary">목록</button>
</div>
</div>
</section>
<%@ include file="../include/footer.jsp" %>
<script>
	$(function(){
		//메인 버튼을 눌렀을 때 처리
		$(".btn-success").click(function(){
			location.href="../";
		});
		//목록 버튼을 눌렀을 때 처리
		$(".btn-primary").click(function(){
			location.href="list";
		});
		//수정 버튼을 눌렀을 때 처리
		$(".btn-warning").click(function(){
			location.href="update?id=" + ${vo.id};
		});
		//삭제 버튼을 눌렀을 때 처리
		$(".btn-danger").click(function(){
			location.href="delete?id=" + ${vo.id};
		});

	})
</script>

</body>
</html>