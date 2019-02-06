<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<%@ include file="../include/header.jsp"%>
</head>
<body>
	<section class="content">
		<div class="box-header">
			<h3 class="box-title">회원가입</h3>
		</div>
		<form role="form" method="post" action="/jh/user/member.do">
			<div class="box-body">
				<div class="form-group">
					<label>아이디</label> <input type="text" name='userid'
						class="form-control" placeholder="아이디를 입력해주세요">
				</div>
				<div class="form-group">
					<label>이름</label>
					<input type="text" name='name'
						class="form-control" placeholder="이름을 입력해주세요">
				</div>

				<div class="form-group">
					<label>비밀번호</label>
					<input type="text" name='pw'
						class="form-control" placeholder="비밀번호를 입력해주세요">
				</div>
			</div>

			<div class="box-footer">
				<button type="submit" class="btn btn-primary">완료</button>
				<button class="btn btn-primary" id="cancel">취소</button>
			</div>
		</form>
	</section>
	<%@include file="../include/footer.jsp"%>
	<script>
		$(function() {
			$('#cancel').on("click", function(event) {
				location.href = "login";
			});
		});
	</script>



</body>
</html>