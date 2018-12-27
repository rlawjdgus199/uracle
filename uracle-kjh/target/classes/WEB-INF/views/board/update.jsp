<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 웹브라우저에게 정보를 전달하기 위한 태그 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
</head>
<body>
	<%@ include file="../include/header.jsp"%>
	<section class="center">
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title">게시물 수정</h3>
			</div>
			<form role="form" method="post" id="updateForm">
				<!-- 글번호를 넘겨주기 위해서 숨김 객체로 생성 -->
				<input type="hidden" name="id" value="${vo.id}" />
				<div class="box-body">
					<div class="form-group">
						<label>제목</label> <input type="text" name="title"
							class="form-control" value="${vo.title}" />
					</div>
					<div class="form-group">
						<label>내용</label>
						<textarea name="body" class="form-control" placeholder="내용 입력"
							rows="5">${vo.body}</textarea>
					</div>

					<div class="form-group">
						<label>작성자</label> <input type="text" name="writer"
							class="form-control" value="${vo.writer}" readonly="readonly" />
					</div>
				</div>
			</form>

			<div class="box-footer">
				<button class="btn btn-success">수정완료</button>
				<button class="btn btn-warning">메인으로</button>
				<button class="btn btn-primary">목록보기</button>
			</div>
		</div>
		<script>
			$(function() {
				//메인 버튼을 눌렀을 때 처리
				$(".btn-warning").click(function() {
					location.href = "home";
				});
				//목록 버튼을 눌렀을 때 처리
				$(".btn-primary").click(function() {
					location.href = "list";
				});
				//수정 완료 버튼을 눌렀을 때 처리
				$(".btn-success").click(function() {
					$("#updateForm").submit();
				});
			})
		</script>
	</section>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>

