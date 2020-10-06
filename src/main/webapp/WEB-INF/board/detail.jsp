
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
	<!-- get 하면 body에 데이터 못들고감 -->
	<a class = "btn btn-secondary" href ="javascript:history.back();">뒤로가기</a>
	<button class="btn btn-secondary" onclick="history.back()">뒤로가기</button>
	
	<c:if test="${sessionScope.principal.id == detailDto.boardDto.board.userId}">
		<%-- 로그인한사람하고 board id로 직접 쓴사람이 수정할 수 있게 설정--%>
	<a href="/blog/board?cmd=update&id=${detailDto.boardDto.board.id}" class="btn btn-warning">수정</a>
		
		<button class="btn btn-danger" onclick="deleteById(${detailDto.boardDto.board.id} )">삭제</button>
		
	</c:if>
	<br />
	<br />
	<h6 class="m-2">
		작성자 : <i>${detailDto.boardDto.username}</i> 조회수 : <i>${detailDto.boardDto.board.readCount}</i>
	</h6>
	<br />
	<h3 class="m-2">
		<b>${detailDto.boardDto.board.title}</b>
	</h3>
	<hr />
	<div class="form-group">
		<div class="container p-3 my-3 border">${detailDto.boardDto.board.content}</div>
	</div>

	<hr />
	
	</div>
	<hr />
	<!-- 댓글 박스 -->
	<div class="row bootstrap snippets">
		<div class="col-md-12">
			<div class="comment-wrapper">
				<div class="panel panel-info">
					<div class="panel-heading m-2"><b>Comment</b></div>
					<div class="panel-body">
						<textarea id = "reply__write__form" class="form-control" placeholder="write a comment..." rows="3"></textarea>
						<br>
						<button onclick="replyWrite(${detailDto.boardDto.board.id}, ${sessionScope.principal.id })" type="button" class="btn btn-primary pull-right">댓글쓰기</button>
						<div class="clearfix"></div>
						<hr />
						<!-- 댓글 리스트 시작-->
						<ul id="reply__list" class="media-list">
						
							<c:forEach var="replyDto" items="${detailDto.replyDtos}">
								<!-- 댓글 아이템 -->
								<li id ="reply-${replyDto.reply.id}" class="media">	
									<img onerror="this.src='/blog/image/userProfile.png'" src="${replyDto.userProfile}" alt="" class="img-circle">		
									<div class="media-body">
										<strong class="text-primary">${replyDto.username}</strong>
										<p>
											${replyDto.reply.content}
										</p>
									</div>
									<div class= "m-2">									
										<c:if test= "${replyDto.reply.userId eq sessionScope.principal.id}">
											<i onclick="replyDelete(${replyDto.reply.id})" style= "cursor=pointer;" class="material-icons i__btn">delete</i>
										</c:if>
									</div>
								</li>
							</c:forEach>
						</ul>
						<!-- 댓글 리스트 끝-->
					</div>
				</div>
			</div>

		</div>
	</div>
	


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



<script src = "/blog/js/detail.js"></script>
<script src="/blog/js/reply.js"></script>




<%@ include file="../include/footer.jsp"%>