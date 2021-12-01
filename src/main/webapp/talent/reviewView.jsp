<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰</title>
<style type="text/css">
	.view {
		border : 1px solid;
	}
</style>
</head>
<body>
	<h4>리뷰 목록</h4>
		<c:forEach var="review" items="${reviewList }">
			<div class="view">
			<p>${review.content }</p>
			<p>작성자ID: ${review.writerId }</p>
			<p>하트 개수: ${review.likes }</p>
			<p>작성일: ${review.writtenDate }
			</div>
		</c:forEach>
		유저아이디와 매칭 상태, 게시글 아이디를 비교하여 리뷰를 달 수 있는 사용자인지 아닌지에 따라서
		리뷰 등록 폼 보여주기 / 안보여주기
		<form action="talent/reviewView">
			
		</form>
</body>
</html>