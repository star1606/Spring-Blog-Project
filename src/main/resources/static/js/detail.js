

function replyWrite (postId, userId) {
	
	//let content = $.("#reply__write__form").val();
	let content = $("#reply__form").serialize();
	let content2 = $("#reply__form").val(); // 이렇게는 못읽음
	console.log("content", content);
	console.log("content2", content2);
	let textareaContent = $("#reply__write__form").val();
	console.log("textareaContent", textareaContent);
	
	let data = {
			postId : postId,
			userId : userId,
			content : textareaContent
	}
//	key : value로 보내는 모습
	console.log("data", data);
	$.ajax({
		
		type: "POST",
		url: "/replyProc",
		data: data,	  
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType: "text" ,
		
	}).done(function(resp){
		console.log(resp);
		if(resp == 1) {
			// return이 "1"이라서 === 쓰면 안됨ㅋ
			alert("댓글쓰기 성공");
		} else {
			alert("댓글쓰기 실패");
		}
		
	}).fail(function(error){
		console.log(error.responseText);
		alert("서버오류");
	});

}




function deleteById(id){
	
	let data = {
			id : id
	}
	
	$.ajax({
		
		type: "DELETE",
		url: "/delete",
		data: data,
		contentType: "application/x-www-form-urlencoded; charset=utf-8", // 버튼클릭했을 때 사용하는 contentType은?
		dataType: "text",
		
		
	}).done(function(resp){
		console.log(resp);
		if(resp == 1){
			alert("삭제 성공");
			location.href="/";
		} else {
			alert("삭제 실패");
		}
		
	}).fail(function(error){
		console.log(error.responseText);
		console.log("서버 오류");
	});
		
	
	
	
	
	
	
	
}