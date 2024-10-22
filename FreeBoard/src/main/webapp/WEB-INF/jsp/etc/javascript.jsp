<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<h3>javascript.jsp</h3>

<table class="table">
<thead>
		<tr>
			<th>회원아이디</th><td><input type="text" id="mid" class="form-control"></td>
		</tr>
		<tr>
			<th>회원이름</th><td><input type="text" id="mname" class="form-control"></td>
		</tr>
		<tr>
			<th>연락처</th><td><input type="text" id="mphone" class="form-control"></td>
		</tr>
		<tr>
			<td align="center" colspan="2"><button id="addBtn" class="btn btn-primary"><i class="bi bi-plus-lg"></i> 등록</button></td>
		</tr>
		</thead>
		<tbody></tbody>
</table>

<div id="show">
	<!-- 회원목록출력. -->
	<table class="table">
		<thead>
		<tr>
			<th>회원아이디</th>
			<th>회원이름</th>
			<th>연락처</th>
			<th>삭제</th>
		</tr>
		</thead>
		<tbody></tbody>
	</table>
</div>

<script src="js/ajax1.js"></script>