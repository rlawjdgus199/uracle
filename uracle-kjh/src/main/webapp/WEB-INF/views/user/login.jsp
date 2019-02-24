<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
	<%@ include file="../include/header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div class="login-box well">
					<form accept-charset="UTF-8" role="form" method="post" action="login">
						<legend>로그인</legend>
						<div id="loginfail"></div>
						<div class="form-group">
							<label for="username-email">아이디</label> <input name="userid" id="userid"
								placeholder="아이디를 입력하세요" type="text" class="form-control" required="required" />
						</div>
						<div class="form-group">
							<label for="password">비밀번호</label> <input name="pw" id="pw"
								placeholder="비밀번호를 입력하세요" type="password" class="form-control" required="required" />
						</div>
						<div class="form-group">
							<input type="submit"
								class="btn btn-default btn-login-submit btn-block m-t-md"
								value="로그인" />
						</div>
						<div class="form-group">
							<a href="member" class="btn btn-default btn-block m-t-md">회원가입</a>
						</div>

					
					</form>
				
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	
	
	
		<script>
      	$(function(){
      		if("${fail}"){
      		$("#loginfail").text("아이디가 없거나 비밀번호가 틀렸습니다.");
      	}
      	});
      
      </script>

	<%@ include file="../include/footer.jsp"%>

</body>
</html>
