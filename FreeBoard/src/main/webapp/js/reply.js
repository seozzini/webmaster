/**
 * reply.js
 * replyService 생성했던 메소드 호출해서 활용.
 */

//svc.showMsg('Hello');



svc.rlist('159' // bno
	, function(result) {
		console.log(result);
		//작성.
		for (let i = 0; i < result.length; i++) {
			let tr = makeRow(result[i]);
			document.querySelector('#replyList tbody').appendChild(tr);
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
	} // successFnc
	, function(err) {
		console.log('요기', err);
	} // errorFnc
)

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


