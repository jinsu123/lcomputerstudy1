<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<style>
	table {
		border-collapse:collapse;
		margin:40px auto;
	}
	table tr th {
		font-weight:700;
	}
	table tr td, table tr th {
		border:1px solid #818181;
		width:200px;
		text-align:center;
	}
	a {
		text-decoration:none;
		color:#000;
		font-weight:700;
	}
	 h1 {
		text-align:center;
	}
	ul {
		width:400px;
		height:50px;
		margin:10px auto;
	}
	li {
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
<h1>회원 목록</h1>
<form action="/updateauth" method="POST" id="form_auth">
	<input type="hidden" name="auth" value="${item.u_auth}" id="auth">
	<input type="hidden" name="u_idx" value="" id="uIdx">
	<table>
		<tr>
			<td colspan="4">전체 회원 수 : ${pagination.count}</td>
		<tr>
			<th>No</th>
			<th>ID</th>
			<th>이름</th>
			<th>권한</th>
		</tr>
		<c:forEach items="${list}" var="list" varStatus="status">
			 <tr>
				<td><a href="userDetail.jsp?u_idx=${list.ROWNUM}">${list.ROWNUM}</a></td>
				<td>${list.username}</td>
				<td>${list.uName}</td>
				<td>
					<button class="btn_auth_user" uIdx="${list.uIdx}" type="button" ${list.u_auth == 'ROLE_USER' ? 'disabled' : ''}>사용자</button>
					<button class="btn_auth_admin" uIdx="${list.uIdx}" type="button" ${list.u_auth == 'ROLE_ADMIN' ? 'disabled' : ''}>관리자</button>
				</td>
		     <tr>
		</c:forEach>
	</table>
</form>
<!-- 아래부터 pagination -->
	<div>
		<ul>
			 <c:choose>
				<c:when test="${ pagination.prevPage >= 5}">
					<li>
						<a href="user-list.do?page=${pagination.prevPage}">
							◀
						</a>
					</li>
				</c:when>
			</c:choose> 
			<c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
				
					<c:choose>
						<c:when test="${ pagination.page == i }"> 
							
							<li style="background-color:#ededed;">
								<span>${i}</span>
							</li>
						</c:when>
						<c:when test="${ pagination.page != i }">
							<li>
								<a href="user-list.do?page=${i}">${i}</a>
							</li>
						</c:when>
					</c:choose>
			</c:forEach>
			 <c:choose>
				<c:when test="${ pagination.nextPage < pagination.lastPage }">
					<li style="">
						<a href="user-list.do?page=${pagination.nextPage}">▶</a>
					</li>
				</c:when>
			</c:choose> 
		</ul>
	</div>


<script>
$(document).on('click', '.btn_auth_user', function () {
	console.log('clicked ROLE_USER');
	$('#auth').val('ROLE_USER');
	console.log("user log:");
	console.log($('#auth').val('ROLE_USER'));
	let uIdx = $(this).attr('uIdx');
	$('#uIdx').val(uIdx);
	console.log("uIdx log:");
	console.log(uIdx);
	
	$('#form_auth').submit();
});

$(document).on('click', '.btn_auth_admin', function () {
	console.log('clicked ROLE_ADMIN');
	$('#auth').val('ROLE_ADMIN');
	let uIdx = $(this).attr('uIdx');
	$('#uIdx').val(uIdx);
	
	$('#form_auth').submit();
});
</script>
</body>
</html>