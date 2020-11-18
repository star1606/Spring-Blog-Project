
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<%-- 
<%
	DetailResponseDto dto=
	(DetailResponseDto)request.getAttribute("dto");
%>
--%>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>



<div class="container">
	
	<a class = "btn btn-secondary" href ="javascript:history.back();">뒤로가기</a>
	<button class="btn btn-secondary" onclick="history.back()">뒤로가기</button>
	

		<!-- 안되는 이유가 자신이 만든 id가 아니라서? -> id 값을 못가져와서 -->
		<!-- principl로 가져온 Id와 post의 userId가 같으면 보여주게 하자 -->
		<c:if test="${sessionScope.principal.id == detailDto.boardDto.userId }">
		<a href="/update/${detailDto.boardDto.id}" class="btn btn-warning">수정</a>
		<button class="btn btn-danger" onclick="deleteById(${detailDto.boardDto.id} )">삭제</button>
		</c:if>
	<br />
	<br />
	<h6 class="m-2">
		작성자 : <i>${detailDto.boardDto.username}</i> 
		작성일자 : <i>${detailDto.boardDto.createDate}</i> 
		
<%-- 		작성자 : <i>${detailDto.boardDto.username}</i>  --%>
<%-- 		작성일자 : <i>${detailDto.boardDto.username}</i>  --%>
		
<%-- 		조회수 : <i>${detailDto.boardDto.board.readCount}</i> --%>
	</h6>
	<br />
	<h3 class="m-2">
		<b>${detailDto.boardDto.title}</b>
<%-- 		<b>${detailDto.boardDto.board.title}</b> --%>
	</h3>
	<hr />
	<div class="form-group">
		<div class="container p-3 my-3 border">${detailDto.boardDto.content}</div>
<%-- 		<div class="container p-3 my-3 border">${detailDto.boardDto.board.content}</div> --%>
	</div>

	<hr />
	
	</div>
	<hr />
<!-- 	댓글 박스 -->
	<div class="row bootstrap snippets">
		<div class="col-md-12">
			<div class="comment-wrapper">
				<div class="panel panel-info">
					<div class="panel-heading m-2"><b>Comment</b></div>
					<div class="panel-body">
<!-- 					form 버젼으로 해보기 -->



<!-- 댓글쓰기 userId -> 로그인사람만 쓸 수 있게하는데 그냥 hide하면 되겟지? -->
<!-- controller에서도 session잇는 사람이 로직 될 수 잇게 설정을 걸어줘야할까? -> 고민좀 -->
						
						
<%-- 히든 이거 때문에 오류터졌었음 form데이터가 제대로 안보내졌다 <input type = "hidden" value ="${boardDto.id}" name ="postId"/> --%>
						<form action="/replyProc" method="POST">
							<input type = "hidden" value ="${detailDto.boardDto.id}" name ="postId"/>
							<textarea id = "reply__write__form" name="content" class="form-control" placeholder="write a comment..." rows="3"></textarea>
							<br>
								<button type="submit" class="btn btn-primary pull-right">댓글쓰기임</button>
	<%-- 						<button onclick="replyWrite(${detailDto.boardDto.id}, ${sessionScope.principal.id })" type="button" class="btn btn-primary pull-right">댓글쓰기</button> --%>
						</form>
<!-- 						이렇게만 보내면 안된다 뭐가 잘못된걸까? -->
						
						<div class="clearfix"></div>
						<hr />
						<!--댓글 리스트 시작 -->
						<ul id="reply__list" class="media-list">
						
							<c:forEach var="replyDto" items="${detailDto.replyDtos}">
						<!-- 댓글 아이템 -->
								<li id ="reply-${replyDto.id}" class="media">	
									<img src="" alt="" class="img-circle">		
									<div class="media-body">
										<strong class="text-primary">${replyDto.username}</strong>
										<p>
											${replyDto.content}
										</p>
									</div>
									<div class= "m-2">									
										<c:if test= "${replyDto.userId eq sessionScope.principal.id}">
											<i onclick="replyDelete(${replyDto.id})" style= "cursor=pointer;" class="material-icons i__btn">delete</i>
										</c:if>
									</div>
								</li>
							</c:forEach>
						</ul>
					<!--댓글 리스트 끝 -->
					</div>
				</div>
			</div>

		</div>
	</div>











<!-- 	<div class="row bootstrap snippets"> -->
<!-- 		<div class="col-md-12"> -->
<!-- 			<div class="comment-wrapper"> -->
<!-- 				<div class="panel panel-info"> -->
<!-- 					<div class="panel-heading m-2"><b>Comment</b></div> -->
<!-- 					<div class="panel-body"> -->
<!-- 						<textarea id = "reply__write__form" class="form-control" placeholder="write a comment..." rows="3"></textarea> -->
<!-- 						<br> -->
<%-- 						<button onclick="replyWrite(${detailDto.boardDto.board.id}, ${sessionScope.principal.id })" type="button" class="btn btn-primary pull-right">댓글쓰기</button> --%>
<!-- 						<div class="clearfix"></div> -->
<!-- 						<hr /> -->
<!-- 						댓글 리스트 시작 -->
<!-- 						<ul id="reply__list" class="media-list"> -->
						
<%-- 							<c:forEach var="replyDto" items="${detailDto.replyDtos}"> --%>
<!-- 								댓글 아이템 -->
<%-- 								<li id ="reply-${replyDto.reply.id}" class="media">	 --%>
<%-- 									<img onerror="this.src='/blog/image/userProfile.png'" src="${replyDto.userProfile}" alt="" class="img-circle">		 --%>
<!-- 									<div class="media-body"> -->
<%-- 										<strong class="text-primary">${replyDto.username}</strong> --%>
<!-- 										<p> -->
<%-- 											${replyDto.reply.content} --%>
<!-- 										</p> -->
<!-- 									</div> -->
<!-- 									<div class= "m-2">									 -->
<%-- 										<c:if test= "${replyDto.reply.userId eq sessionScope.principal.id}"> --%>
<%-- 											<i onclick="replyDelete(${replyDto.reply.id})" style= "cursor=pointer;" class="material-icons i__btn">delete</i> --%>
<%-- 										</c:if> --%>
<!-- 									</div> -->
<!-- 								</li> -->
<%-- 							</c:forEach> --%>
<!-- 						</ul> -->
<!-- 						댓글 리스트 끝 -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->

<!-- 		</div> -->
<!-- 	</div> -->


	<!-- </div> 네임이 없으면 전송을 못한다 .text() , val, html -->
	<!--  댓글 박스 끝 -->


<!--  
<script>
	function deleteById(boardId){

		$.ajax({
					type: "POST",
					url: "/blog/board?cmd=delete&id=" + boardId,
					dataType: "text"
				}).done(function(result){
					console.log(result);
					if(result == 1){
							alert("삭제 성공");
							loaction.herf="/blog/index.jsp";
						}else{
								alert("삭제 실패");
						}
				}).fail(function(error){
						console.log(error);
						console.log(error.responseText);
						console.log(error.status);
						alert("서버 오류");

					});

		

		}

</script>
-->


<script src="/js/detail.js"></script>



<%@ include file="../include/footer.jsp"%>