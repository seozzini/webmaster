<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src='js/jquery-3.7.1.js'></script>
<script>
  document.addEventListener('DOMContentLoaded', function (e){
	// jquery 객체생성.
	  //$('<생성하고싶은 태그 />')
	  $('<ul />') // == document.createElement('ul')
	   .append($('<li>사과</li>')    
			   ,$('<li />').html('바나나')  // innerHTML = '바나나'
			   ,$('<li />').text('복숭아')   // innerText = '복숭아'
	   ).appendTo($('body')) 
  });
  
</script>
</head>
<body>
  <!-- webapp/sample.jsp -->
</body>
</html>