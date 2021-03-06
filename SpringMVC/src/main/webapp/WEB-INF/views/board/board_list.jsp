<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../include/member_header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var result = '${msg}';

	if (result == '성공') {
		alert(result + '입니다.');
	}

	$(document).ready(function() {
		$("#btnWrite").click(function() {
			// 페이지 주소 변경(이동)
			location.href = "/board/write";
		});
	});
</script>
</head>
<body>
	<%@ include file="../menu/top_menu.jsp"%>
	<h2>게시글 목록</h2>
	<button type="button" id="btnWrite">글쓰기</button>
	<table class="table table-board" border="1px" width="80%"
		align="center">
		<tr>
			<th style="width: 10%">글 번호</th>
			<th style="width: 30%">제목</th>
			<th style="width: 20%">작성자</th>
			<th style="width: 20%">날짜</th>
			<th style="width: 20%">조회수</th>
		</tr>


		<c:forEach items="${boardList }" var="boardVO">
			<tr>
				<td>${boardVO.seq }</td>
				<td><a href="/board/view?seq=${boardVO.seq}">${boardVO.title }</a></td>
				<td>${boardVO.writer }</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
						value="${boardVO.regDate }" /></td>
				<td><span> ${boardVO.cnt }</span></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>


