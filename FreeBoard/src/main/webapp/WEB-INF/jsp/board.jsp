<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="java.awt.Button"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<style>
.reply span {
	display: inline-block;
}

.reply ul {
	list-style-type: none;
}

#reply {
	display: inline;
}
</style>

<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>상세페이지(board.jsp)</h3>

<%
BoardVO bno = (BoardVO) request.getAttribute("boardvo");
String pg = (String) request.getAttribute("page");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String sc = (String) request.getAttribute("searchCondition");
String kw = (String) request.getAttribute("keyword");
kw = kw == null ? "" : kw; //null 처리하기
%>

<table class="table">

	<tr>
		<th>글번호</th>
		<td>${boardvo.boardNo }</td>
		<th>조회수</th>
		<td>${boardvo.viewCnt }</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${boardvo.title}</td>
		<th>작성자</th>
		<td>${boardvo.writer}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3"><textarea readonly rows="4" cols="30"
				class="form-control">${boardvo.content }</textarea></td>
	</tr>
	<tr>
		<th>이미지</th>
		<td colspan="3"><c:if test="${boardvo.img != null }">
				<img src="images/${boardvo.img}" width="100	px">
			</c:if></td>
	</tr>
	<tr>
		<th>작성일시</th>
		<td colspan="3"><fmt:formatDate value="${boardvo.writeDate }"
				pattern="yyyy-MM-dd HH:mm:ss" /></td>
	</tr>

	<tr>
		<td align="center" colspan="4"><input type="button" value="수정"
			class="btn btn-warning"> <input type="button" value="삭제"
			class="btn btn-danger"></td>
	</tr>

</table>

<!-- 댓글관련 -->
<div class="container reply">

	<!-- 댓글등록. -->
	<div class="header">
		<h5>댓글</h5>
		<input class="form-control col-sm-8" id="reply">
		<button class="btn btn-secondary" id="addReply">등록</button>
	</div>

	<!-- 댓글목록. -->
	<div class="content">
		<ul>
			<li><span class="col-sm-2">글번호</span> <span class="col-sm-5">내용</span>
				<span class="col-sm-2">작성자</span> <span class="col-sm-2">삭제</span></li>
			<!-- 참고 샘플
			<li>
				<span class="col-sm-2">3</span>
				<span class="col-sm-5">댓글입니다</span>
				<span class="col-sm-2">user01</span>
				<span class="col-sm-2"><button>삭제</button></span>
			</li> 
			-->
		</ul>
	</div>
	<!-- 댓글페이징. -->
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<li class="page-item">
			<a class="page-link" href="#" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span>
			</a>
			</li>
			
			<li class="page-item"><a class="page-link" href="#">1</a></li>
			<li class="page-item"><a class="page-link" href="#">2</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<li class="page-item"><a class="page-link" href="#"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>
</div>

<jsp:include page="../includes/footer.jsp"></jsp:include>

<script>
	const bno = "${boardvo.boardNo }"; //원본글 번호
	const logId = "${logId}";
	//console.log(logId);
	//console.log(bno);
	document
			.querySelector('input[value="수정"]')
			//
			.addEventListener(
					'click',
					function(e) {
						location.href = 'modifyBoard.do?searchCondition=${searchCondition }&keyword=${keyword }&bno=${boardvo.boardNo }&page=${page }';
					});

	document.querySelector('input[value="삭제"]')//
	.addEventListener('click', function(e) {
		location.href = 'removeBoard.do?bno=${boardvo.boardNo }';
	});
</script>

<!-- <script src="js/replyService.js"></script> -->
<!--<script src="js/reply.js"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="js/jreply.js"></script>