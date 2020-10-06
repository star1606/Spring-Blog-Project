<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>
<%@ include file="../include/authentication.jsp"%>




<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>



<div class= "container">	<!-- get 하면 body에 데이터 못들고감 -->
	<form action="/blog/board?cmd=writeProc" method="POST">
		<div class="form-group">
			<label for="title">Title:</label>
			<input type="text" class="form-control" placeholder="title" id="title" name="title">
		</div>
	
		<div class="form-group">
			<label for="content">Content:</label>
			<textarea class="form-control" rows="5" id="content" name="content"></textarea>
		</div>
						
			<!-- </div> 네임이 없으면 전송을 못한다 .text() , val, html -->
		<button type="submit" class="btn btn-primary">글쓰기 등록</button>		
	</form>
</div>

	<script>
		$('#content').summernote({
			placeholder : 'Hello Bootstrap 4',
			tabsize : 2,
			height : 100
		});
	</script>








	<%@ include file="../include/footer.jsp"%>