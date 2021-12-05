<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
	<script>
	function reviewCreate(){
		if(form.content.value ==""){
			alert("리뷰를 입력하십시오.");
			form.content.focus();
			return false;
		} 
		form.submit();
	}
	</script>
<style type="text/css">
	.view {
		border : 1px solid;
	}
</style>
<div id="review">
	<h4>리뷰 목록</h4>
		<c:forEach var="review" items="${reviewList }">
			<div class="view">
			<p>${review.reviewContent }</p>
			<p>작성자ID: ${review.writerId }</p>
			<p>작성일: ${review.writtenDate }
			</div>
		</c:forEach>
		
</div>
