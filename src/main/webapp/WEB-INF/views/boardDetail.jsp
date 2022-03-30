<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
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
		ul{
		width:600px;
		height:50px;
		margin:10px auto;
	}
	
</style>
</head>
<body>
	<sec:authentication property="principal" var="principal"/>
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

<br>
<p>첨부파일</p>
<br>
<c:forEach items="${file}" var="fload">
<p><img src="/img/${fload.fName}" height="200" width="200"></p>
</c:forEach>
<br>

	<tr style="height:50px;">
		<td style="border:none;">
			<p style="width:5%; font-weight:700;background-color:#818181;color:#fff;"><a href="/board/edit?bId=${board.bId }">수정</a></p>
		</td>
		<td style="border:none;">
			<p style="width:5%; font-weight:700;background-color:red;color:#fff;"><a href="/board/delete?bId=${board.bId }">삭제</a></p>
		</td>
	</tr>
<br>
<p style="width:4%; font-weight:700;background-color:#818181;color:#fff;"><a href="/board/insert?bGroup=${board.bGroup}&bOrder=${board.bOrder}&bDepth=${board.bDepth}">답글쓰기</a></p>
<br>
<a href="/board/list">리스트로 돌아가기</a>

<br>
	<p>댓글쓰기</p>
<br>	
	
	<p> 작성자 : ${board.user.uName}</p>
	<p> 내용 : <input type="text" size="40" maxlength="100" name="cContent" id="content" ></p>
	<button type="button" id="insertForm" u_idx="${board.user.uName}"  cGroup="0" cOrder="0" cDepth="0">댓글쓰기</button>


	<div id="aj_list">
		<table>
			<tr>
				<td colspan="3">전체 댓글 수 : ${pagination.count}</td>
			<tr>
			<tr>
				<th>작성자</th>
				<th style="width:50%">내용</th>
				<th style="width:35%">작성일</th>
			</tr>
			<c:forEach items="${list}" var="list" >
				<tr>
					<th>${list.user.uName}</th>
					<th class="tdAlign">
						<c:if test="${list.cDepth > 0 }">
							<c:forEach begin="1" end="${list.cDepth}">
								&nbsp;&nbsp;
							</c:forEach>
							<c:forEach begin="1" end="${list.cDepth}">
								RE :
							</c:forEach>
						</c:if>
					${list.cContent}</th>
					<th>${list.cDatetime }  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="replyForm" >댓글쓰기</button>
						<button type="button" id="editForm">수정</button>
						<button type="button" id="deleteForm" cIdx="${list.cIdx }">삭제</button>
					
					</th>
				</tr>
				<tr style="display: none;">
					<td colspan="2">
						<textarea cols="100" rows="1"></textarea>
					</td>
					<td>
						<button type="button" class="reInsertForm" cIdx="${list.cIdx }" cGroup="${list.cGroup }" cOrder="${list.cOrder }" cDepth="${list.cDepth }">등록</button>
						<button type="button" class="cancelForm">취소</button>
					</td>
				</tr>
				<tr style="display: none;">
					<td colspan="2">
						<textarea cols="100" rows="1">${list.cContent }</textarea>
					</td>
					<td>
						<button type="button" class="reEditForm" cIdx="${list.cIdx }" >수정</button>
						<button type="button" class="cancelForm">취소</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	
		<div>
			<ul>
				<c:choose>
					<c:when test="${pagination.prevPage >= 5 }">
						<li>
							<a class="page" page="${pagination.prevPage}">
								◀
							</a>
						</li>
					</c:when>	
				</c:choose>
				<c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
					<c:choose>
						<c:when test="${pagination.page == i }">
							<li style="background-color:#ededed;">	
								<a class="page">${i}</a>
							</li>
						</c:when>
						<c:when test="${pagination.page != i}">
							<li>
								<a class="page" page="${i}" >${i}</a>
							</li>
						</c:when>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${pagination.nextPage <= pagination.lastPage}">
						<li style="">
							<a class="page" page="${pagination.nextPage}">▶</a>
						</li>
					</c:when>
				</c:choose>
			</ul>
		</div>
	</div>

<script>
$(document).on('click', '.replyForm', function () {
	console.log('asdfsadf')
	$(this).parent().parent().next().show();
});


$(document).on('click', '.cancelForm', function () {
	console.log('cancelForm')
	$(this).parent().parent().hide();
});



$(document).on('click', '#insertForm', function () {

	console.log('test')
	
	let bId = '${board.bId}'
	console.log('bId')
	console.log(bId)
	
	
	let count = '${pagination.count}'
	console.log('count')
	console.log(count)

	let id = '${board.user.uName}'
	console.log('id')
	console.log(id)

	let cContent = $(this).prev().find('input').val();
	console.log('cContent')
	console.log(cContent)
	let cGroup = $(this).attr('cGroup');
	console.log('cGroup')
	console.log(cGroup)
	let cOrder = $(this).attr('cOrder');
	console.log('cOrder')
	console.log(cOrder)
	let cDepth = $(this).attr('cDepth');
	console.log('cDepth')
	console.log(cDepth)

	$.ajax({
		method: "POST",
		url: "/comment/insert",
		data: { bId: bId, count:count,  id: id, cContent: cContent,  cGroup: cGroup, cOrder: cOrder, cDepth: cDepth }
	
	})
    .done(function( html ) {
        console.log(html)
    	 $('#aj_list').html(html);
    });
});



$(document).on('click', '.reInsertForm', function () {

	let bId = '${board.bId}'
	console.log('bId')
	console.log(bId)
	
	console.log('test')
	let id = '${board.user.uName}'
	console.log('id')
	console.log(id)
	let c_idx =  $(this).attr('cIdx');
	console.log('c_idx')
	console.log(c_idx)
	let c_content = $(this).parent().parent().find('textarea').val();
	console.log('c_content')
	console.log(c_content)
	let c_group = $(this).attr('cGroup');
	console.log('c_group')
	console.log(c_group)
	let c_order = $(this).attr('cOrder');
	console.log('c_order')
	console.log(c_order)
	let c_depth = $(this).attr('cDepth');
	console.log('c_depth')
	console.log(c_depth)

	$.ajax({
		method: "POST",
		url: "/comment/insert",
		data: { bId: bId, id: id, cIdx: c_idx, cContent: c_content,  cGroup: c_group, cOrder: c_order, cDepth: c_depth }
	
	})
    .done(function( html ) {
        console.log(html)
    	 $('#aj_list').html(html);
    });
});




$(document).on('click', '#deleteForm', function () {
	console.log('deleteForm')

	let bId = '${board.bId}'
	console.log('bId')
	console.log(bId)
	
	let c_idx = $(this).attr('cIdx');
	console.log('c_idx')
	console.log(c_idx)
	
	$.ajax({
		method: "POST",
		url: "/comment/delete",
		data: {bId: bId, cIdx: c_idx }
	
	})
    .done(function( html ) {
        console.log(html)
    	 $('#aj_list').html(html);
    });
	
});



$(document).on('click', '#editForm', function () {
	console.log('editForm')
	$(this).parent().parent().next().next().show();
});

$(document).on('click', '.reEditForm', function () {
	console.log('reEditForm')

	let bId = '${board.bId}'
	console.log('bId')
	console.log(bId)
	
	
	let c_idx = $(this).attr('cIdx');
	console.log('c_idx')
	console.log(c_idx)
	let id = '${board.user.uName}'
	console.log('id')
	console.log(id)

	let c_content = $(this).parent().parent().find('textarea').val();
	console.log('c_content')
	console.log(c_content)
	
	
	
	
	$.ajax({
		method: "POST",
		url: "/comment/edit",
		data: { bId:bId, cIdx: c_idx, id: id, cContent: c_content}
	
	})
    .done(function( html ) {
        console.log(html)
    	 $('#aj_list').html(html);
    });
	
});


$(document).on('click', '.page', function () {
	console.log('page')

	
	let bId = '${board.bId}'
	console.log('bId')
	console.log(bId)
	let c_idx = '${board.user.uName}'
	console.log('c_idx')
	console.log(c_idx)
	let page = $(this).attr('page');
	console.log('page')
	console.log(page)

	
	
	$.ajax({
		method: "GET",
		url: "/comment/list",
		data: {bId: bId, c_idx: c_idx, page: page }
	
	})
    .done(function( html ) {
        console.log(html)
    	 $('#aj_list').html(html);
    });
	
});

</script>

</body>
</html>