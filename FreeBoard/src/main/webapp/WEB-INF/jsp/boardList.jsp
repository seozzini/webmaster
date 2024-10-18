<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>글목록(boardList.jsp)</h3>

<!-- 검색조건 -->
<form action="boardList.do" class="row g-3">
	<div class="col-md-3">
		<select name="searchCondition" class="form-select">
			<option selected value="">선택하세요.</option>
			<option value="T"
			${searchCondition == "T" ? "selected" : "" }> 제목</option>
			<option value="W">작성자</option>
			<option value="TW">제목 & 작성자</option>
		</select>
	</div>
	<div class="col-md-4">
		<input type="text" class="form-control" name="keyword"
			value='<%=kw == null || kw.equals("") ? "" : kw%> '>
	</div>
	<div class="col-md-5">
		<button type="submit" class="btn btn-primary">조회</button>
	</div>
</form>

<table class="table table-hover">

	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>조회</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach var="board" items="${boardList }">
			<tr>
				<td><c:out value="${status.count } }" /></td>
				<td><a
					href='board.do?searchCondition=${searchCondition }&keyword=${keyword }$page=${page.page }&bno=${board.boardNo }'>${board.title }</a></td>
				<td><c:out value="${board.writer }" /></td>
				<td><fmt:formatDate value="${board.writeDate }"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td><c:out value="${board.viewCnt }" /></td>
			</tr>
		</c:forEach>


<!--현재 페이지 확인용-->




<!-- 데이터 없으면 -do data- -->

<c:if test="${fn:length(boardList)==0 }">
<tr>
<td align = "center" colspan="5"> -no data-</td>
</tr>
</c:if>
</tbody>
</table>


<!-- paging -->
<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">


		<!-- 이전페이지가 여부 -->

		<c:choose>
		<c:when test="${paging.isPrev()}">
			<li class="page-item"><a class="page-link"
			href="boardList.do?page=${paging.getStartPage() - 1 }">Previous</a></li>
		</c:when>
		<c:otherwise>
			<li class="page-item disabled"><a class="page-link">Previous</a></li>
		</c:otherwise>
	</c:choose>


		<!-- 페이지 출력. -->
		<%
		for (int p = paging.getStartPage(); p <= paging.getEndPage(); p++) {
		%>
		<%
		if (p == paging.getPage()) {
		%>
		<li class="page-item active" aria-current="page">
			<%
			} else {
			%>
		
		<li class="page-item">
			<%
			}
			%><a class="page-link"
			href="boardList.do?searchCondition=<%=sc%>&keyword=<%=kw%>&page=<%=p%>"><%=p%></a>
		</li>
		<%
		}
		%>
		
		<c:forEach var="p" begin="${page.startPage}" end="${page.endPage}">
		
		<c:choose>
		<c:when test="${page.page == p}">
			<li class="page-item active" aria-current="page">
		</c:when>
		<c:when test="${p != paging.getPage()}">
			<p>청인</p>
		</c:when>
		<c:otherwise>
			<p>미성년</p>
		</c:otherwise>
	</c:choose>
	
	</c:forEach>



		<!-- 다음페이지 여부. -->
		
		<c:choose>
		<c:when test="${paging.isNext()}">
			<li class="page-item"><a class="page-link"
			href="boardList.do?page=${paging.getEndPage() + 1}">Next</a></li>
		</c:when>
		<c:otherwise>
			<li class="page-itm disabled"><a class="page-link">Next</a></li>
		</c:otherwise>
	</c:choose>


	</ul>
</nav>

<jsp:include page="../includes/footer.jsp"></jsp:include>