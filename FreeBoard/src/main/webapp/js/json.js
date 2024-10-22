/**
 * json.js
 * {name: "홍길동", age:20} => object
 * {"name": "홍길동", "age":20} => json object
 * json문자열 => 자바스크립트 객체 => json문자열. 
 * 
 * <table class="table">
	<thead>
		<tr>
			<th>ID</th><th>firstName</th><th>lastName</th><th>Email</th><th>Salary</th><th>삭제</th>
		</tr>
	</thead>
	
	<tbody>
	
	</tbody>
	
	</table>
	
 */

let obj = { name: "홍길동", age: 20 };
let json = JSON.stringify(obj); // object -> string(문자열)
obj = JSON.parse(json); // string -> object

// JSP => 페이지 출력.(jsp페이지 만들어서 화면에 보여줌)
// JSON 형태 데이터 => 페이지 작성.(DOM 활용)

fetch('js/MOCK_DATA.json') //promise타입(객체) 반환/then메소드에 전달 매개값으로 함수가짐/함수의 매개값으로 fetch에서 반환한값을 전달
	.then(function(resolve) {
		console.log(resolve);
		return resolve.json(); //String-> object 변환 반환
	})
	.then(function(result) {
		console.log(result); //배열
		makeList(result);
	})

//obj = JSON.parse(data);
//console.log(obj);

// DOM
// obj배열에 있는 건수만큼 tr 생성하고 tbody 하위요소.
// 함수선언
function makeList(obj = []) {
	let fields = ['id', 'first_name', 'last_name', 'email', 'salary'];//td네번 만드는것보다 배열생성 후 반복문으로 돌림
	for (i = 0; i < obj.length; i++) {
		let tr = document.createElement('tr');
		//이벤트생성
		tr.addEventListener('mouseover', function(e) { tr.style.backgroundColor = 'gray' });
		tr.addEventListener('mouseout', function(e) { tr.style.backgroundColor = null });
		// td*4 생성.
		for (let j = 0; j < fields.length; j++) {
			let td = document.createElement('td');
			td.innerText = obj[i][fields[j]]; // obj.name, obj['name'] (obj[i]배열 /[fields[j]] ex.필드이름 j가 0이면 id값 가져옴.)
			tr.appendChild(td);
		}
		let td = document.createElement('td');
		let btn = document.createElement('button');
		//btn.addEventListener('click',function(e){console.dir(btn)}); //이렇게하면 콘솔에서 조상찾기 가능
		btn.innerHTML = '삭제';
		td.appendChild(btn);
		tr.appendChild(td);
		document.querySelector('#show tbody').appendChild(tr);
		btn.addEventListener('click', function(e) { tr.remove() });

	}

}
// 함수호출
//makeList();
