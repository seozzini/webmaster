/**
 * calendarModal.js
 */

let body = document.querySelector("body");
let modal = document.querySelector('#exampleModal');
let div = document.createElement('div');

function modalShow(arg) {
	modalArg = arg; // 여러 함수에서 사용할 용도.

	// body 태그.
	body.className = 'modal-open';
	body.style.overflow = 'hidden';
	body.style.paddingRight = '16px';
	div.className = "modal-backdrop fade show";
	body.appendChild(div);

	//modal 태그.
	modal.classList.add('show');
	modal.setAttribute('aria-modal', true);
	modal.setAttribute('role', 'dialog');
	modal.setAttribute('aria-hidden', false);
	modal.style.display = 'block';


   if (modalArg.startStr.indexOf('+') != -1) {
  let test = modalArg.startStr.split('+')[0];
  modalArg.startStr = test.split('T')[0];
  let time = test.split('T')[1];
  
  } 

	start.value = modalArg.startStr; //id가 start인 input태그값
	end.value = modalArg.endStr;
};

function modalClose() {
	// body 속성 변경.
	body.className = '';
	body.style.overflow = '';
	body.style.paddingRight = '';
	div.remove();

	//modal div 속성 변경.
	modal.classList.remove('show');
	modal.setAttribute('aria-modal', false);
	modal.removeAttribute('role', 'dialog');
	modal.setAttribute('aria-hidden', true);
	modal.style.display = 'none';

	//back-drop 속성 변경.

};


function modalSave() {
	// title, startStr, endStr
	let title = document.querySelector('#title').value;
	let startStr = document.querySelector('#start').value;
	let endStr = document.querySelector('#end').value;
	
	fetch('addEvent.do?job=add&title=' + title + '&start=' + startStr + '&end=' + endStr)
		.then((resolve) => resolve.json())
		.then((result) => {
			//console.log(result);
			
			if (result.retCode == 'OK') {
				if(modalArg.allDay == false){
				calendar.addEvent({
					title: title,
					start: modalArg.start,
					end: modalArg.end,
					allDay: modalArg.allDay,
				})
				modalClose();
				return;	
			}
				
				//화면에 출력
				calendar.addEvent({
					title: title,
					start: modalArg.start,
					end: modalArg.end,
					allDay: modalArg.allDay,
				})
				modalClose();
			} else if (result.retCode == 'FAIL') {
				alert('등록 에러.');
			}
		}).catch(err => console.log(err));

}

function startChange(event){
	console.log(event);
	modalArg.start = new Date(event.target.value); // 2024-10-21
};

function endChange(event){
	console.log(event);
	modalArg.end = new Date(event.target.value); 
};