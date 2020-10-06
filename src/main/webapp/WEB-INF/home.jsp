<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	홈페이지 입니다

	<table class="table">
		<thead>
			<tr>
				<th>id</th>
				<th>제목</th>
				<th>내용</th>
				<th>유저id</th>
				<th>작성시간</th>
			</tr>
		</thead>
		<tbody id="tbody">
			<c:forEach var="post" items="${posts}">
				<tr>
					<td>${post.id}</td>
					<td>${post.title}</td>
					<td>${post.content}</td>
					<td>${post.userId}</td>
					<td>${post.createDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>