<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- jstl의 core기능을 사용하기 위한 설정 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 외부파일 내용 가져오기 -->
<%@include file="../include/header.jsp"%>

</head>
<body>
<section class="content">
	<div class="box">
		<div class="box-header with-border"><a href="board/register"><h3 class="box-title">글쓰기</h3></a></div>
	</div>
	<div class="box-header with-border">
          <a href="board/list"><h3 class="box-title">게시판 목록보기</h3></a>
 </div>
	
</section>
<%@include file="../include/footer.jsp"%>
</body>
</html>

    