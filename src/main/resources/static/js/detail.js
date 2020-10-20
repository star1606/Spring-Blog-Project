

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