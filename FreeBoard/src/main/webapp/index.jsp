<%@page import="com.yedam.service.MemberService"%>
<%@page import="com.yedam.service.MemberServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- MVC 디자인: View(JSP페이지), Model(DB처리), 컨트롤 -->
	<!-- Expression Language : EL -->
	<!-- jsp action tag -->
	<!-- JSP Standerd Tag Library : JSTL // 태그라서 자바코드 덜어낼 수 있음-->

	<p>${logId}</p>

	<!-- JSTL 연습 -->
	<!-- 자바예시 -->
	<%
	String name = "Hong";
	%>

	<!-- 변수지정 -->
	<c:set var="name" value="Hong"></c:set>
	<!-- 변수출력 -->
	<c:out value="${name }"></c:out>

	<c:set var="age" value="20"></c:set>
	<c:if test="${age>=20 }">
		<p>성년입니다.</p>
	</c:if>
	
	<c:choose>
		<c:when test="${age>=60}">
			<p>노인</p>
		</c:when>
		<c:when test="${age>=20}">
			<p>청인</p>
		</c:when>
		<c:otherwise>
			<p>미성년</p>
		</c:otherwise>
	</c:choose>
	
	<c:forEach var="i" begin="1" end="5" step="2">
		<p>i의 값은 ${i}입니다. </p>
	</c:forEach>
	
	<c:set var="page" value="boardList.do"></c:set>
	<jsp:forward page="${page}"></jsp:forward>
	
</body>
</html>