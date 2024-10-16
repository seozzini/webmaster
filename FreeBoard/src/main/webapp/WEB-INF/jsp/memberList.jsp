<%@page import="com.yedam.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<!-- jsp는 파일 불러들이기 가능 -->
<jsp:include page="../includes/header.jsp"></jsp:include>

	<h3>회원목록</h3>
	<%
	List<MemberVO> list = (List<MemberVO>)request.getAttribute("memberList"); //request는 내장객체로, 멤버리스트컨트롤에서 넘겨준 값임
	System.out.println(list);
	%>
	<table class="table">
		<tbody>
			<%
			for (MemberVO mvo : list) {
			%>
			<tr>
				<td><%=mvo.getMemberId()%></td>
				<td><%=mvo.getMemberName()%></td>
				<td><%=mvo.getPhone()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

<jsp:include page="../includes/footer.jsp"></jsp:include>