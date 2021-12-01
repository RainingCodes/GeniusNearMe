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
	<h1>받은 쪽지 확인</h1>
	<p>
	보낸 이 : ${nickname}
	<br>전송 날짜 : ${message.writtenDate}
	<br>    
	<textarea cols="30" rows="15" name="content"style="resize: none; readonly">${message.content}</textarea>
		<form name="form" method="get" action="<c:url value='/message' />">
			<input type="hidden" name="senderId" value="${message.receiverId}"/>
			<input type="hidden" name="receiverId" value="${message.senderId}"/>
			<input type="button" value="답장하기" onClick="submit()">
		</form>
		<form name="go" method="post" action="<c:url value='/member/messageList' />">
			<input type="button" value="뒤로 돌아가기" onClick="submit()">
		</form>
	</div>
</body>
</html>