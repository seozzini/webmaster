/**
 * members.js
 */
// JSP => req.getDispatch...("board/boardList.tiles").forward(req.resp);
// json => json데이터 활용 페이지 그리기.

//json 형태의 회원목록을 출력하는 데이터.
// "등록" 버튼에 이벤트 추가.
document.querySelector('#addBtn').addEventListener('click', function(e) {
	let id = document.querySelector('#mid').value; //인풋속성은 value
	let name = document.querySelector("#mname").value;
	let phone = document.querySelector("#mphone").value;

	fetch('addMemberJson.do?id=' + id + '&name=' + name + '&phone=' + phone)
		.then(resolve => resolve.json())
		.then(result => {
			console.log(result); //{retCode: 'OK'} 리턴코드
			if (result.retCode == 'OK') {
				let tr = makeRow({ memberId: id, memberName: name, phone: phone });
				document.querySelector('#show tbody').appendChild(tr);

			} else if (result.retCode == 'FAIL') {
				alert('처리중 에러가 발생.');
			}
		})
		.catch(err => { console.log(err) })
})


// 1.목록출력.
fetch('memberJson.do')
	.then(resolve => resolve.json())
	.then(result => {
		console.log(result);
		makeList(result); //배열 (함수호출해야 실행됨.)
	})
	.catch(err => console.log(err))

function makeList(obj = []) {
	//작성.
	for (let i = 0; i < obj.length; i++) {
		let tr = makeRow(obj[i]);
		document.querySelector('#show tbody').appendChild(tr);
	}
}

function makeRow(obj = {}) {
	let fields = ['memberId', 'memberName', 'phone'];
	let tr = document.createElement('tr');
	tr.setAttribute('data-id', obj.memberId);
	//이벤트생성(마우스오버)
	//tr.addEventListener('mouseover', function(e) { tr.style.backgroundColor = 'gray' });
	//tr.addEventListener('mouseout', function(e) { tr.style.backgroundColor = null });

	// td*4 생성.
	for (let j = 0; j < fields.length; j++) {
		let td = document.createElement('td');
		td.innerText = obj[fields[j]];
		tr.appendChild(td);
	}
	let td = document.createElement('td');
	let btn = document.createElement('button');
	//btn.addEventListener('click',function(e){console.dir(btn)}); //이렇게하면 콘솔에서 조상찾기 가능
	btn.addEventListener('click', deleteRowFnc); //()괄호빼삼. 클릭 이벤트 발생시 실행될거임
	btn.innerHTML = "<i class='bi bi-trash'></i>삭제";
	btn.classList.add('btn','btn-light');

	td.appendChild(btn);
	tr.appendChild(td);

	return tr;
}

function deleteRowFnc(e) {
	//console.dir(e.target.parentElement.parentElement.firstElementChild.innerText); //삭제할 ID읽어오기
	console.dir(e.target.parentElement.parentElement.dataset.id); //삭제할 ID읽어오기
	let id = e.target.parentElement.parentElement.dataset.id;
	fetch('removeMemberJson.do?id=' + id)
		.then(resolve => resolve.json())
		.then(result => {
			if (result.retCode == 'OK') {
				alert('성공.');
				e.target.parentElement.parentElement.remove();

			} else if (result.retCode == 'FAIL'	) {
				alert('처리중 에러가 발생.');
			}	

		})
		.catch(err => console.log(err))
}

