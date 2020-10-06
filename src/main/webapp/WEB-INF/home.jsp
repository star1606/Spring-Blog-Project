<%-- <%@page import="com.cos.springblog.model.User"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "include/nav.jsp" %>    <!-- 같은 위치에 있으니까 -->


<div class = "container">
	<div class="col-md-12 m-2">
	  <form class="form-inline justify-content-end" action="/blog/board">
	  	<input type ="hidden" name="cmd" value="search" />
	  	<input type="hidden" name="page" value="0" />
	    <input type="text" class="form-control mr-sm-2" name="keyword" placeholder="Search">
	    <button class="btn btn-primary" type="submit">검색</button>
	  </form>
	</div>
</div>



<c:forEach var="post" items="${posts}">
	<div class="container">	
	
	<div class="card m-2" style="width:100%">
  
	   	<div class="card-body">
	   		
 		  글번호 ${post.id}   <h4 class ="card-title">${post.title}</h4>  <%-- 중요 :el표현식은 변수명을 적으면 getter가 호출된다 --%>
		   <p class = "card-text">${post.content}</p>	<%-- gettitle()함수 호출임 --%>
	 	   <a href="" class="btn btn-primary">상세보기</a>
	    </div>
	</div>

</div>

</c:forEach>



<%-- <%@ include file ="include/paging.jsp" %> --%>

	
  <!--  123 1  456 2 789 3   10 11 12 4 -->

	
<!--  표현식 문법은 제대로 했는가 if문은 제대로 썼을까? -->

<!-- <script src="/blog/js/dontnew.js"></script> -->
<%@ include file = "include/footer.jsp" %>