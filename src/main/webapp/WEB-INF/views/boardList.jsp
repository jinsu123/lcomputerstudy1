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
	ul{
		width:600px;
		height:50px;
		margin:10px auto;
	}
	li{
		list-style:none;
		width:50px;
		line-height:50px;
		border:1px solid #ededed;
		float:left;
		text-align:center;
		margin:0 5px;
		border-radius:5px;
	}
	
</style>
<body>
	<h1>게시판</h1>
	<table>
		<tr>
			<td colspan="6">전체 게시글 수 : ${boardCount} </td>
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
	
	<div>
		<ul>
			<c:choose>
				<c:when test="${pagination.prevPage >= 5 }">
					<li>
						<a href="board/list?page=${pagination.prevPage}">
							◀
						</a>
					</li>
				</c:when>	
			</c:choose>
			<c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
				<c:choose>
					<c:when test="${pagination.page == i }">
						<li style="background-color:#ededed;">	
							<span>${i}</span>
						</li>
					</c:when>
					<c:when test="${pagination.page != i}">
						<li>
							<a href="board/list?page=${i}">${i}</a>
						</li>
					</c:when>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${pagination.nextPage <= pagination.lastPage}">
					<li style="">
						<a href="board/list?page=${pagination.nextPage}">▶</a>
					</li>
				</c:when>
			</c:choose>
		</ul>
	</div>
	<p><a href="/board/insert">글쓰기</a></p>
	
</body>
</html>