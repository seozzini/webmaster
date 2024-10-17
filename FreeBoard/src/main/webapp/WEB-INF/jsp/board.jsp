<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="java.awt.Button"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>상세페이지(board.jsp)</h3>
<%
BoardVO bno = (BoardVO) request.getAttribute("boardvo");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>

<table class="table">

	<tr>
		<th>글번호</th>
		<td><%=bno.getBoardNo()%></td>
		<th>조회수</th>
		<td><%=bno.getViewCnt()%></td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="3"><%=bno.getTitle()%></td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3"><textarea readonly rows="4" cols="30"
				class="form-control"><%=bno.getContent()%></textarea></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td colspan="3"><%=bno.getWriter()%></td>
	</tr>
	<tr>
		<th>작성일시</th>
		<td colspan="3"><%=sdf.format(bno.getWriteDate())%></td>
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
    	location.href = 'modifyBoard.do?bno=<%=bno.getBoardNo() %>';
    });
    
    document.querySelector('input[value="삭제"]')//
    .addEventListener('click',function(e){
  	location.href = 'removeBoard.do?bno=<%=bno.getBoardNo() %>';
  });
</script>