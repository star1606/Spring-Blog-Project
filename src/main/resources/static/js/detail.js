

function replyWrite (postId, userId) {
	
	//let content = $.("#reply__write__form").val();
	let content = $("#reply__form").serialize();
	//주의! serialize하면 key:value 형태로 만들어 주는 것. 
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
		console.log("resp", resp);
		console.log("resp data", resp.data);
		if(resp == 1) {
			// return이 "1"이라서 === 쓰면 안됨ㅋ
			alert("댓글쓰기 성공");
			
			
			// ajax로 목록 새로고침 없이 업데이트 하는 방법
			// 제이쿼리를 쓰면 될 것 같은데
			
			// 1. 먼저 list를 비운다
			$("#reply__list").empty();
			
			// 2. 아이템을 가져온다
			
			
			
			// for (var replyDto of resp) 변수만드는데서 막혔다
			// 응답한 데이터를 가지고 여러개의 아이템을 만들어 내는 과정이라는 것을 생각하자
			// 3. 만든 아이템을 for문을 돌린다
			for (var replyDto of resp) {
				
				//reply = "";		
				let reply = `<li id ="reply-${replyDto.id}" class="media">`;
				reply += `<img src="" alt="" class="img-circle">`;
				reply += `<div class="media-body">`;
				reply += `<strong class="text-primary">${replyDto.username}</strong>`;
				reply += `<p>${replyDto.content}</p>`;
				reply += `</div>`;
				reply += `<div class= "m-2">`;
				reply += `<i onclick="replyDelete(${replyDto.id})" style= "cursor=pointer;" class="material-icons i__btn">delete</i>`;
				reply += `</div>`;
				reply += `</li>`;
				
				console.log("reply", reply);
				$("#reply__list").append(reply);
			}
			
			
//			
			
			
			
			console.log("오케이");
			
			
			//$("").html("");
			
		} else {
			alert("댓글쓰기 실패");
		}
		
	}).fail(function(error){
		console.log(error.responseText);
		alert("서버오류");
	});

}



	



//	$.ajax({
//		type:"GET",
//		url:"/detail/" + id,
//		data:,
//		contentType:,
//		dataType:,
	
	
	// 여기에 c태그 들어가면 안되나?

		
		
	
	
	
		







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