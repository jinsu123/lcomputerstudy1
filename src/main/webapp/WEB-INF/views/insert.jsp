<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
<h1>글쓰기</h1>
	<sec:authentication property="principal" var="principal"/>
	<form action="/board/insertProcess" name="board" method="post">
	
		<p> 작성자 : ${principal.uName}</p>
		<p> 제   목 : <input type="text" maxlength="100" size="40" name="bTitle" placeholder="제목을 작성해주세요.">
		<p> <div style="text-align:middle">내   용 :</div><textarea  style="overflow:auto; height:150px; resize:none;"  cols="100	" rows="100" name="bContent" placeholder="내용을 작성해주세요."></textarea>
		<p>파일: <input type="file"  name="upload1"></p>
		<p>파일: <input type="file"  name="upload2"></p>
		<hr width="40%" align="left">
		<p> <input type="submit" value="등록"><input type="button" onclick="location.href='/board/insert'" value="다시쓰기"><input type="button" onclick="location.href='/board/list'" value="리스트">
	</form>	

</body>
</html>