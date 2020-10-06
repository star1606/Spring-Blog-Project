<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<style>
	div {
		border: 1px solid black;
		margin: 5px;
		padding: 5px;
	}


</style>


<body>

<div id= "reply-box">
	<div id = "reply-1" class="re">
 	첫번째 댓글입니다.	
	</div>
</div>
<input type= "text" id="tf-reply"/><br/>
<button onclick = "start()">댓글쓰기</button>

<script>
var num = 1;
function start(){
	//$('#demo').html("<h1>hello</h1>");
	//$('#demo').val("hello");
	
	num++;
	
	var a = $('#tf-reply').val();

	var data = {
		username: "ssar",
		content: a

	}
	
	// 통신이 성공하면 아래 로직 실행
	$.ajax({ // ajax는 put, delete요청도 가능(form post get만)
			type: 'POST',
			url: 'AjaxResponseTest.jsp',  //url은 필수 값.
			//data: '{"username":"ssar", "password":"1234"}',
			data: JSON.stringify(data), // 보내는 데이터
			contnetType: 'application/json; charset=utf-8',
			dataType: 'json'  //받을 데이터를 어떻게 파싱할까를 정의 문자면text, json
			
		}).done(function(result){ //성공하면 done 콜백
			console.log(result);
			$('#reply-box').prepend("<div id='reply-"+num+"'>"+a+"</div>");
		}).fail(function(error){ // 실패하면 fail 콜백
			consoe.log('에러났어');
			consoe.log(error);

		});
	
	
}
</script>

</body>
</html>