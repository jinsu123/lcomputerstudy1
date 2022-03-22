<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 페이지</title>
<style >

	table{
		border-collapse:collapse;
	}
		table tr th{
		font-weight:700;
	}
	table tr td, table tr th{
		border:1px solid #818181;
		width:200px;
		text-align:center;
	}
	p{
		text-decoration:none;
		color:#000;
		font-weight:700;
		border:none;
		cursor:pointer;
		padding:10px;
		display:inline-block;
		text-align:center;
	}
	
</style>
</head>
<body>
<h1>상세 페이지</h1>


<table>
	<tr>
		<td>번호</td>
		<td style="width:70%">${board.bId}</td>
	</tr>
	<tr>
		<td>제목</td>
		<td style="width:70%">${board.bTitle}</td>
	</tr>
	<tr>
		<td>내용</td>
		<td style="width:70%">${board.bContent}</td>
	</tr>
	<tr>
		<td>작성자</td>
		<td style="width:70%">${board.user.uName}</td>
	</tr>
	<tr>
		<td>날짜</td>
		<td style="width:70%">${board.bDatetime}</td>
	</tr>
	<tr>
		<td>조회수</td>
		<td style="width:70%">${board.bViewCount}</td>
	</tr>
</table>

	<tr style="height:50px;">
		<td style="border:none;">
			<p style="width:5%; font-weight:700;background-color:#818181;color:#fff;"><a href="/board/edit?bId=${board.bId }">수정</a></p>
		</td>
		<td style="border:none;">
			<p style="width:5%; font-weight:700;background-color:red;color:#fff;"><a href="/board/delete?bId=${board.bId }">삭제</a></p>
		</td>
	</tr>
<br>
<p style="width:4%; font-weight:700;background-color:#818181;color:#fff;"><a href="/board/insert?b_group=${board.bGroup}&b_order=${board.bOrder}&b_depth=${board.bDepth}">답글쓰기</a></p>
<br>
<a href="/board/list">리스트로 돌아가기</a>
</body>
</html>