/**
 * exe1.js
 */
function delWords(){
	//console.log("test"); //연결확인
	let words = document.querySelectorAll("span"); //변수에 배열로 저장
	for(let i = 0; i<words.length; i++ ){
		if(words[i].innerHTML == userValue.value){
			words[i].remove();
		}
	}
	
	}