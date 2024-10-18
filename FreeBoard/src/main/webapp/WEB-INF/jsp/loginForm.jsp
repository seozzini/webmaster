<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>로그인화면(loginForm.jsp)</h3>

<!-- 등록 오류 시, msg(메세지)값 있으면 보여주고 없으면 안보여줌. -->
<%
String msg = (String) request.getAttribute("msg");
%>

<%
if (msg != null) {
%>
<p style="color: red;"><%=msg%></p>
<%
}
%>
<p>

<form action="loginForm.do" method="post">
	<table class="table">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="logId"></td>
		</tr>

		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="logPw"></td>
		</tr>

		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="로그인" class="btn btn-success">
		</tr>

	</table>
</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>