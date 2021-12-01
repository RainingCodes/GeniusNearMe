<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>받은 쪽지 확인</title>
</head>
<body>
	<div class="receiveView" align="center">
	<br>
	<h1>보낸 쪽지 확인</h1>
	<p>
	받는 이 : ${nickname}
	<br>    
	<textarea cols="30" rows="15" name="content"style="resize: none; readonly">${message.content}</textarea>
		<form name="form" method="get" action="<c:url value='/message' />">
			<input type="hidden" name="senderId" value="${message.receiverId}"/>
			<input type="hidden" name="receiverId" value="${talent.talentId}"/>
			<input type="button" value="답장하기" onClick="submit()">
		</form>
	<input type="button" value="뒤로 돌아가기" onClick="history.go(-1)">
	</div>
</body>
</html>