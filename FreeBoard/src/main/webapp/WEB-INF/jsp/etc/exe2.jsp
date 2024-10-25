<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script>
	document.addEventListener('DOMContentLoaded', function(e) {
		createCalender(document.querySelector('#list'));
	})

	function createCalender(target) {
		let space = 2;
		let tr = document.createElement('tr');
		for (let d = 1; d <= 31; d++) {
			let td = document.createElement('td');
			td.innerHTML = d;
			tr.appendChild(td);
			if (d % 7 == 0) {
				td.style.color='blue';
				document.querySelector('#list').appendChild(tr);
				tr = document.createElement('tr'); // 토요일(7번 td를 생성하면)이 되면 tr을 새롭게 생성.
			}else if ((d-1)%7 ==0){
				td.style.color='red';
			}
		}
		target.appendChild(tr);
	}
</script>

</head>

<style>
table th, td {
	width: 55px;
	height: 55px;
	text-align: center;
}

table th {
	backgrond-color: #eee;
}


</style>

<body>



	<div id="show">
		<table border="1" class="table-bordered">
			<thead>
				<tr>
					<th>Sun</th>
					<th>Mon</th>
					<th>Tue</th>
					<th>Wed</th>
					<th>Thr</th>
					<th>Fri</th>
					<th >Sat</th>
				</tr>
			</thead>
			<tbody id="list"></tbody>
		</table>

	</div>

</body>

</html>