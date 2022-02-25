<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<style>
table{
		border-collapse:collapse;
		margin:40px auto;
	}
	table tr th{
		font-weight:700;
	}
	table tr td, table tr th{
	
		width:200px;
		text-align:left;
	}
	th{
		background-color:#b0e0e6;
	}
	th-2{
		width:1000px;
	}
	
</style>
<body>
	<h1>게시판</h1>
	<table>
		<tr>
			<td colspan="6">전체 게시글 수 :</td>
		<tr>
			<th>번호</th>
			<th style="width:10%">제목</th>
			<th style="width:20%">내용</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${list}" var="list">
			<tr>
				<td>${list.bId}</td>
				<td>${list.bTitle}</td>
				<td>${list.bContent}</td>
				<td>${list.bWriter}</td>
				<td>${list.bDatetime}</td>
				<td>${list.bViewCount}</td>
			</tr>
		</c:forEach>
	</table>
	<p><a href="/board/insert">글쓰기</a></p>
	
</body>
</html>