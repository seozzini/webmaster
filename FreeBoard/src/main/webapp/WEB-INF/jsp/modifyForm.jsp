<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>수정화면(modifyForm.jsp)</h3>

<!-- 등록 오류 시, msg(메세지)값 있으면 보여주고 없으면 안보여줌. -->
<%
String msg = (String) request.getAttribute("msg");
String pg = (String) request.getAttribute("page");
BoardVO board = (BoardVO) request.getAttribute("boardvo");
String sc = (String) request.getAttribute("searchCondition");
String kw = (String) request.getAttribute("keyword");
// 세션정보.
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
<form action="modifyBoard.do" method="post">

	<%
	//post하면 파라미터가 안보임 get으로 바꿔보기
	%>

	<input type="hidden" name="bno" value="<%=board.getBoardNo() %>">
	<input type="hidden" name="page" value="<%=pg %>">
	<input type="hidden" name="searchCondition" value="<%=sc %>">
	<input type="hidden" name="keyword" value="<%=kw %>">
	<table class="table">

		<tbody>

			<tr>
				<th>글번호</th>
				<td><%=board.getBoardNo() %></td>
				<th>조회</th>
				<td><%=board.getViewCnt() %></td>
			</tr>

			<tr>
				<th>제목</th>
				<td colspan="3"><input class="form-control" type="text" name="title"
					value="<%=board.getTitle() %>"></td>
			</tr>

			<tr>
				<th>내용</th>
				<td colspan="3"><textarea class="form-control" name="content" rows="3"
						cols="30"><%=board.getContent() %></textarea></td>
			</tr>
			
			<tr>
				<th>이미지</th>
				<td colspan="3"><input class="form-control" type="img" name="tit"
					value="<%=board.getTitle() %>"></td>
			</tr>

			<tr>
				<th>작성자</th>
				<td colspan="3"><%=board.getWriter() %></td>
			</tr>

			<tr>
				<td colspan="4" align="center">
				<input type="submit" value="저장" <%=logId != null && logId.equals(board.getWriter()) ? "" : "disabled" %> class="btn btn-success"> 
				<input type="reset" value="취소" class="btn btn-warning"></td>
			</tr>
		</tbody>
	</table>


</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>

