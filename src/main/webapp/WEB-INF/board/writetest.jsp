<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>
<%@ include file="../include/authentication.jsp"%>

<html lang="en">
<head>
<meta charset="UTF-8">
<title>Summernote with Bootstrap 4</title>


<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>



	<form action="/blog/board?cmd=writeProc" method="POST">
		<div class="form-group">
			<label for="title">Title:</label> <input type="text" class="form-control" placeholder="title" id="title" name="title">
		</div>

		<div class="form-group">
			<label for="content">Content:</label>
			<textarea class="form-control" rows="5" id="content" name="content"></textarea>
		</div>
		<div class="container">
			<form action="/blog/board?cmd=writeProc" method="POST">
				<!-- get 하면 body에 데이터 못들고감 -->
		</div>
		<div class="form-group">
	</form>

	<!-- </div> 네임이 없으면 전송을 못한다 .text() , val, html -->
	<button type="submit" class="btn btn-primary">글쓰기 등록</button>

	</div>
	<script>
		$('#content').summernote({
			placeholder : 'Hello Bootstrap 4',
			tabsize : 2,
			height : 100
		});
	</script>
	</from>



</body>
</html>



<%@ include file="../include/footer.jsp"%>