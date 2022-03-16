<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
</head>
<body>

	<sec:authentication property="principal" var="principal"/>
	<form action="/board/editProcess" name="board" method="post">
		<input type="hidden" name="bId" value="${board.bId}">
		<p> 작성자 : <input type="text" value="${principal.uName}" name="bWriter" readonly></p>
		<p> 제   목 : <input type="text" maxlength="100" size="40" name="bTitle" value="${board.bTitle }">
		<p> <div style="text-align:middle">내   용 :</div><textarea  style="overflow:auto; height:150px; resize:none;"  cols="100	" rows="100" name="bContent" >${board.bContent }</textarea>
		<p>파일: <input type="file"  name="upload1"></p>
		<p>파일: <input type="file"  name="upload2"></p>
		<hr width="40%" align="left">
		<p> <input type="submit" value="수정완료">
	</form>	


</body>
</html>