/**
 * replyService.js
 * 메소드: 목록, 등록, 삭제
 */

 const svc = {
	 rlist(bno = 1, successFnc, errorFnc){ // 댓글목록. (원본글을 파라미터로)
		 // Ajax 호출
		 fetch('replyList.do?bno='+bno)
		 .then(resolve => resolve.json())
		 .then(successFnc)
		 .catch(errorFnc)
	 },
	 /*
	 showMsg(msg){
		 console.log(msg);
	 }
	 */
 }