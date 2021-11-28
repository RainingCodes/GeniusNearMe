<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%! int i = 1; %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 찜한 재능 목록</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="../css/talent.css" type="text/css">
<script>
	function deleteWish(){
		
	}
</script>
</head>
<style>
.content {
	text-align:center;
	float: none;
	width: 900px;
	margin: 0px auto;
}
</style>
<%@ include file="../main/head.jsp"  %>
	<div class="content">
		<c:forEach var="talent" items="${talentList}">
			<div class="post">
				<div id="imgSection1">
					<img id="thumbnail" src="../img/loopy/img<%=i++ %>.jpg">
				</div>
				<p>
					<a href="<c:url value='/talent/view'>
						<c:param name='talentId' value='${talent.talentId}'/></c:url>">
						<strong><c:out value="${talent.title}"/></strong>
					</a>					
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${talent.writtenDate}"/>
				</p>
				<p></p>
				<p></p>
				<p><c:out value="${talent.content}"/></p>

				<form method="POST" action="<c:url value='/member/deleteWish' />">
					<input type="hidden" name="talentId" value="${talent.talentId }">
					<input type="button" value="찜 취소하기" onClick="submit()">
				</form>
				</div>
		</c:forEach>
	</div>
</body>
</html>