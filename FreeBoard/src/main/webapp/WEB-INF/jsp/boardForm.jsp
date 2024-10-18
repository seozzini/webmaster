<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>등록화면(boardForm.jsp)</h3>

<!-- 등록 오류 시, msg(메세지)값 있으면 보여주고 없으면 안보여줌. -->
<%
String msg = (String) request.getAttribute("msg");
String logId = (String) session.getAttribute("logId");
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
<form action="addBoard.do" method="get">
	<%
	//post하면 파라미터가 안보임 get으로 바꿔보기
	%>

	<input class="form-control" type="hidden" name="writer" value="<%=logId%>">
	<table class="table">
		<tr>
			<th>제목</th>
			<td><input class="form-control" type="text" name="title"></td>
		</tr>

		<tr>
			<th>내용</th>
			<td><textarea class="form-control" name="content" rows="3" cols="30"></textarea></td>
		</tr>

		<tr>
			<th>작성자</th>
			<td><%=logId%></td>
		</tr>

		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="저장" class="btn btn-success"> 
			<input type="reset" value="취소" class="btn btn-warning"></td>
		</tr>

	</table>


</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>