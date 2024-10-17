<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>삭제화면(removeForm.jsp)</h3>

<!-- 등록 오류 시, msg(메세지)값 있으면 보여주고 없으면 안보여줌. -->
<%
String msg = (String) request.getAttribute("msg");
BoardVO board = (BoardVO) request.getAttribute("boardvo");
%>

<%
if (msg != null) {
%>
<p style="color: red;"><%=msg%></p>
<%
}
%>
<p>
	<!-- 제목, 내용, 작성자만 있으면 됨 -->
<form action="removeBoard.do" method="post">


	<input type="hidden" name="bno" value="<%=board.getBoardNo()%>">
	<table class="table">

		<tbody>

			<tr>
				<th>글번호</th>
				<td><%=board.getBoardNo()%></td>
				<th>조회</th>
				<td><%=board.getViewCnt()%></td>
			</tr>

			<tr>
				<th>제목</th>
				<td colspan="3"><%=board.getTitle()%></td>
			</tr>

			<tr>
				<th>내용</th>
				<td colspan="3"><%=board.getContent()%></td>
			</tr>

			<tr>
				<th>작성자</th>
				<td colspan="3"><%=board.getWriter()%></td>
			</tr>

			<tr>
				<td colspan="4" align="center">
				<input type="submit" value="삭제" class="btn btn-danger"> 
				<input type="reset" value="취소" class="btn btn-success"></td>
			</tr>
		</tbody>
	</table>


</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>

<script>
    document.querySelector('input[value="취소"]')//
    .addEventListener('click',function(e){
  	location.href = 'board.do?bno=<%=board.getBoardNo() %>';
  });
</script>