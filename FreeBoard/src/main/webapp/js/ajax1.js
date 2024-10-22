/**
 * ajax1.js
 * Asynchronous Javascript And Xml. (비동기방식: 서버에 리소스를 호출하는 방식)
 */

/*
//비동기 설명용코드
setTimeout(function() {
	console.log("1")
}, 1000); //1000ms -> 1초 //작업큐에 넣고 다른거부터 실행함.

setTimeout(function() {
	console.log("2")
}, 1000);

setTimeout(function() {
	console.log("3")
}, 1000);
*/

let xhtp = new XMLHttpRequest(); //비동기방식 처리 객체(Ajax).
xhtp.open('get', 'memberJson.do');//서버타입 리소스 호출
xhtp.send(); //서버상 resource 요청.

let data = [];
xhtp.onload = function() {
	let obj = JSON.parse(xhtp.responseText);
	console.log(obj);
	data = obj;
	console.log('1', data);
	for (let i = 0; i < data.length; i++) {
		console.log(data[i]);
	}
}

console.log('2', data);