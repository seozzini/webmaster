<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="java.awt.Button"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
		<td colspan="3">
		<c:if test="${boardvo.img != null }">
		<img src="images/${boardvo.img}" width="100	px">
		</c:if>
		</td>
	</tr>
	<tr>
		<th>작성일시</th>
		<td colspan="3"><fmt:formatDate value="${boardvo.writeDate }" pattern="yyyy-MM-dd"/></td>
	</tr>

	<tr>
		<td align="center" colspan="4">
		<input type="button" value="수정" class="btn btn-warning"> 
		<input type="button" value="삭제" class="btn btn-danger"></td>
	</tr>

</table>

<jsp:include page="../includes/footer.jsp"></jsp:include>

<script>
    document.querySelector('input[value="수정"]')//
      .addEventListener('click',function(e){
    	location.href = 'modifyBoard.do?page=${page }&bno=${boardvo.boardNo }&searchCondition=${searchCondition }&keyword=${keyword }';
    });
    
    document.querySelector('input[value="삭제"]')//
    .addEventListener('click',function(e){
  	location.href = 'removeBoard.do?bno=${boardvo.boardNo }';
  });
</script>