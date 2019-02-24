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
		<form role="form" id="frm" method="post" action="/jh/user/member.do">
			<div class="box-body">
				<div class="form-group">
					<label>아이디</label> <input type="text" name="userid" id="myid"
						class="form-control" placeholder="아이디를 입력해주세요">
					<p id="test2"></p>
					<button type="button" class="btn btn-primary" id="idck">중복체크</button>
				</div>
				<div class="form-group">
					<label>이름</label> <input type="text" name="name" id="uname"
						class="form-control" placeholder="이름을 입력해주세요">
				</div>

				<div class="form-group">
					<label>비밀번호</label> <input type="password" name="pw" id="mypwd"
						class="form-control" placeholder="비밀번호를 입력해주세요">
					<p id="test1"></p>
				</div>
			</div>

			<div class="box-footer">
				<button type="submit" class="btn btn-primary" id="SingUp">완료</button>
				<button class="btn btn-primary" id="cancel">취소</button>
			</div>
		</form>
	</section>
	<%@include file="../include/footer.jsp"%>
	<script>
		$(function() {
			$("#cancel").on("click", function(event) {
				location.href = "login";
			});
			//유효성 검사
			$("#SingUp").click(function(){
				var userid = $("#myid").val();
				var username = $("#uname").val();
				var userpwd = $("#mypwd").val();

				if (userid.length == 0) {
					$("#userid").focus();
					alert("아이디를 입력해 주세요");
					return false;
				}
				if (username.length == 0) {
					alert("이름을 입력해 주세요");
					$("#username").focus();
					return false;
				}
				if (userpwd.length == 0) {
					alert("비밀번호를 입력해 주세요");
					$("#userpwd").focus();
					return false;
				}
				if (confirm("회원가입을 하시겠습니까?")) {
					if (idck == 0) {
						alert("아이디 중복체크를 해주세요");
						return false;
					} else {
						$('#frm').attr('method', 'post');
						$('#frm').attr('action', 'member');
						$("#frm").submit();
					}
				}

			});
			//아이디 정규화
			/* $("#myid").focusout(function(){
				var userIdentified=document.getElementById("myid").value;
				var checkedid=/^[A-Za-z0-9]{4,12}$/;
				
				
				 if (userIdentified.length==0){
						cfm2=" ";
						document.getElementById("test2").innerHTML =cfm2 ;
					}  
				 else if(!checkedid.checked(userIdentified)){
						 alert("------------------------");
						 cfm3="아이디는 4~12자의 영문 대소문자와 숫자로만 입력가능합니다.";
						document.getElementById("test2").innerHTML =cfm3; 
						return false;
					} 
				
			}); */

			$("#mypwd").focusout(
							function() {
								//비밀번호 정규화
								var userPassword = document
										.getElementById("mypwd").value;
								var checkedpw = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,}/;

								if (userPassword.length == 0) {
									cfm1 = " ";
									document.getElementById("test1").innerHTML = cfm1;
								} else if (!checkedpw.test(userPassword)) {
	
									cfm = "영문 대소문자,숫자,특수문자 각1자리 이상 포함되어야 합니다.";
									document.getElementById("test1").innerHTML = cfm;
									return false;
								}

							});
			//아이디 체크여부 확인 (아이디 중복일 경우 = 0 , 중복이 아닐경우 = 1 )
			var idck = 0;
			//idck 버튼을 클릭했을 때 
			$("#idck").click(function() {

				//userid 를 param.
				var userid = $("#myid").val();

				$.ajax({
					async : true,
					type : 'POST',
					data : userid,
					url : "idcheck.do",
					dataType : "json",
					contentType : "application/json; charset=UTF-8",
					success : function(data) {
						if (data.cnt > 0) {
							
							alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
							$("#myid").focus();
							

						} else {
							alert("사용가능한 아이디입니다.");
							$("#myid").focus();
							idck = 1;

						}
					},
					error : function(error) {

						alert("error : " + error);
					}
				});
			});

		});
	</script>



</body>
</html>