<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<html>
<head>
<title>게시판</title>
</head>
<body>
	<h1>게시판 등록하기</h1>

	<form action="/board/insertBoard" method="POST">
		<div class="writeForm">
			<label>제목</label> <input type="text" name="title"
				class="writeForm" placeholder="게시판 제목">
		</div>
		<div class="writeForm">
			<label>내용</label>
			<textarea rows="4" cols="15" name="content" class="writeForm"
				placeholder="게시판 내용"></textarea>
		</div>
		<div class="createForm">
			<label>작성자</label> <input type="text" name="writer"
				class="writeForm" placeholder="작성자">
		</div>

		<div class="Formfooter">
			<button type="submit" class="btn_button">작성하기</button>
		</div>

	</form>


</body>
</html>


