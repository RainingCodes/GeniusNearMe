<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>재능 찾기 검사 결과</title>
<style>

	.title {
		border: 1px;
		padding: 10px;
		margin: 10px 250px;
		width: 400px;
		height: 60px;
		text-align: center;
		border-radius: 10px;
		background: rgb(52, 115, 219);
		color: white;
		margin: 50px;
		display:table-cell;
		vertical-align:middle;
	}
	.result {
		border: 1px;
		padding: 10px;
		margin: 10px 300px;
		width: 300px;
		height: 60px;
		text-align: center;
		border-radius: 10px;
		background: rgb(224, 224, 224);
		margin: 50px;
		display:table-cell;
		vertical-align:middle;
	}

</style>
</head>
<body>
	<div align="center">
		<h1>재능 찾기 검사 결과</h1>
		<div class="title">
			<c:if test="${userId ne '-1'}"> 
				${nickName}
			</c:if>
			<c:if test="${userId eq '-1'}"> 
				비회원
			</c:if>
			님의 검사 결과는!
		</div>
		<p><br><p>
		<div class="result">
			${myType} 입니다.
		</div>
		<p><br><p>
		<div>
		<c:if test="${userId ne '-1'}"> 
			<c:if test="${lastType eq null}"> 
				${nickName}님은 재능 찾기 검사를 처음으로 하셨군요!
			</c:if>
			<c:if test="${lastType ne null}"> 
				${nickName}님은 이전 재능 찾기 검사 결과는 ${lastType}였습니다.
			</c:if>
		</c:if>
		</div>
		<p>
		<div>
			<c:if test="${userId ne '-1'}"> 
				${nickName}
			</c:if>
			<c:if test="${userId eq '-1'}"> 
				비회원
			</c:if>님과 어울리는 카테고리는 바로 ${myCategory}입니다!
		</div>
		<p><br><p>
		<div>
			<a href="<c:url value='/' />">홈 화면으로 이동하기</a>
		</div>
	</div>
</body>
</html>