<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
<h1>글쓰기</h1>
<form action="board-insert-process.do" name="board" method="post" enctype="multipart/form-data">
		<input type="hidden" name="u_idx" value="${board.u_idx}">
		<input type="hidden" name="b_idx" value="${board.b_idx}">
		<p> 작성자 : <input type="text" name="writer" value="${board.writer}" readonly>
		<p> 제   목 : <input type="text" maxlength="100" size="40" name="title">
		<p> <div style="text-align:middle">내   용 :</div><textarea  style="overflow:auto; height:150px; resize:none;"  cols="100	" rows="100" name="content"></textarea>
		<p>파일: <input type="file"  name="upload1"></p>
		<p>파일: <input type="file"  name="upload2"></p>
		<hr width="40%" align="left">
		<p> <input type="submit" value="등록"><input type="button" onclick="location.href='board/insert'" value="다시쓰기"><input type="button" onclick="location.href='board/list'" value="리스트">
	</form>	

</body>
</html>