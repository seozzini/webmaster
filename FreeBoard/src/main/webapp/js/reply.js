/**
 * reply.js
 * replyService 생성했던 메소드 호출해서 활용.
 * 
 * <table id="replyList" class="table">
	<thead>
		<tr>
			<th>댓글번호</th><th>내용</th><th>작성자</th>
		</tr>
	</thead>
	<tbody></tbody>
</table>

let li = document.createElement('li');
		li.className = 'page-item';
		let a = document.createElement('a');
		li.className = 'page-link';
		a.setAttribute('href','#');
		a.innerText = p;
		li.appendChild(a);

 */

//svc.showMsg('Hello');

let page = 1; //댓글페이지 변수

// 댓글등록 버튼.
document.querySelector('#addReply').addEventListener('click', addReplyHandlerFnc);

// 댓글 이벤트 핸들러
function addReplyHandlerFnc(e) {
	let reply = document.querySelector('#reply').value; //추가할 댓글내용.
	if (!reply || !logId) {
		alert('필수값이 없습니다.')
		return;
	}
	// 게시글번호: bno, 댓글내용: reply, 댓글작성자:logId
	svc.addReply({ bno, reply, replyer: logId },

		result => {
			//OK:화면에 한줄추가. FAIL:"에러발생"
			if (result.retCode == 'OK') {
				alert('정상 등록');
				//let template = makeLi(result.retVal);
				//document.querySelector(".reply ul li").after(template);
				page = 1;
				showList();
				svc.getReplyCount(bno, createPageList, err => console.log(err));
			} else if (result.retCode == 'FAIL') {
				alert('등록중 오류 발생');
			} else {
				alert('알 수 없는 코드');
			}
		},
		err => {
			console.log(err);
		}
	)
};

// pagination a 클릭이벤트.
function linkMove() {
	document.querySelectorAll('nav ul.pagination a').forEach(function(aTag) {
		//console.log(a,b,c); //function(a,b,c->a:태그 b:index , c:nodeList 클래스 자체
		aTag.addEventListener('click', function(e) {
			e.preventDefault(); // 이동 차단.
			page = aTag.dataset.page; //<a data-page="2">2</a>
			showList(); // 목록보여주고.
			svc.getReplyCount(bno, createPageList, err => console.log(err)); // 페이징목록보여주고.
		})
	})
}

//페이지목록을 출력하는 함수.
svc.getReplyCount(bno, createPageList, err => console.log(err));
//createPageList();
function createPageList(result) { //ex) page = 2
console.log(result);
	let totalCnt = result.totalCount;   //32
	let startPage, endPage, realEnd;
	let prev, next;

	endPage = Math.ceil(page / 5) * 5; //5page.
	startPage = endPage - 4; //1
	realEnd = Math.ceil(totalCnt / 5) //7page.
	endPage = endPage > realEnd ? realEnd : endPage;

	prev = startPage > 1; //false.
	next = endPage < realEnd; //true(이후 페이지가 더 있다)

	//페이지리스트 출력.
	let list = '';
	//<li class="page-item"><a class="page-link" href="#">1</a></li>

	list += '<li class="page-item">';
	if (prev) // 이전페이지 출력.
		list += '  <a class="page-link" href="#" aria-label="Previous" data-page="' + (startPage - 1) + '">&laquo;</a>';
	else
		list += '  <span class="page-link disabled" aria-hidden="true">&laquo;</span>';
	list += '    </li>';

	for (let p = startPage; p <= endPage; p++) {

		list += '<li class="page-item"><a class="page-link" href="#" data-page = "' + p + '">' + p + '</a></li>';

	}


	list += '<li class="page-item">';
	if (next) // 이후페이지 출력.
		list += '  <a class="page-link" href="#" aria-label="Next" data-page="' + (endPage + 1) + '">&raquo;</a>';
	else
		list += '  <span class="page-link disabled" aria-hidden="true">&raquo;</span>';
	list += '    </a></li>';

	document.querySelector('nav ul.pagination').innerHTML = list;

	linkMove();
}


// 댓글목록 출력하는 함수.
showList();
function showList() {
	// 이미 출력된 목록 화면에서 삭제
	document.querySelectorAll('div.reply div.content li').forEach((li, idx) => {
		if (idx > 0)
			li.remove();
	})
	// 목록출력.
	svc.rlist({ bno, page }// bno
		, // successFnc 
		function(result) {
			//console.log(result);
			for (let i = 0; i < result.length; i++) {

				let template = makeLi(result[i]);
				document.querySelector(".reply ul").appendChild(template);

			}
		}
		/*
		//다 보여주고 싶을 때
		let obj = result[0];
		for(let i=0; i<result.length;i++){
		for(let prop in obj){
			console.log(result[i][prop]);
			}
		}
		*/

		, // errorFnc
		function(err) {
			console.log('요기', err);
		}
	);
}; //end of showList
// 댓글정보 한 건 있으면 <li>....</li> 함수 생성해서 반환
function makeLi(rvo = { replyNo, reply, replyer }) {
	let template = document.querySelector(".reply ul li").cloneNode(true);
	//console.log(template);
	template.querySelector('span').innerText = rvo.replyNo;
	template.querySelector('span:nth-of-type(2)').innerText = rvo.reply;
	template.querySelector('span:nth-of-type(3)').innerText = rvo.replyer;
	template.querySelector('span:nth-of-type(4)').innerHTML = '<button type="button" class="btn btn-outline-secondary btn-sm" onclick="deleteRow(event)"><i class="bi bi-x"></i>삭제</button>';
	return template;
}

// 댓글삭제하는 함수.
function deleteRow(e) {
	let rno = e.target.parentElement.parentElement.firstElementChild.innerText;
	console.log(rno);
	// 삭제 기능 호출.
	svc.removeReply(rno, //삭제할 댓글번호.
		result => {    //정상처리 실행할 함수.
			if (result.retCode == 'OK') {
				alert('정상 처리');
				e.target.parentElement.parentElement.remove();
				showList();
				svc.getReplyCount(bno, createPageList, err => console.log(err)); 
			} else if (result.retCode == 'FAIL') {
				alert('처리중 예외');
			} else {
				alert('알 수 없는 코드');
			}
		},
		err => console.log(err)		 //예외발생 실행함수.

	)

}


function makeList(result) {
	console.log(result);
	//작성.
	for (let i = 0; i < result.length; i++) {
		let tr = makeRow(result[i]);
		document.querySelector('#replyList tbody').appendChild(tr);
	}

}

function makeRow(obj = {}) {
	let fields = ['replyNo', 'reply', 'replyer'];
	let tr = document.createElement('tr');
	tr.setAttribute('data-id', obj.memberId);

	// td*4 생성.
	for (let j = 0; j < fields.length; j++) {
		let td = document.createElement('td');
		td.innerText = obj[fields[j]];
		tr.appendChild(td);
	}
	let td = document.createElement('td');
	tr.appendChild(td);

	return tr;
}


