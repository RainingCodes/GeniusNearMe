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
	<h2>받은 쪽지 확인</h2>
	<p>
	보낸 이 : ${nickname}
	<br>    
	<form name="form" method="post" action="<c:url value='/message' />">
		<input type="hidden" name="senderId" value="${senderId}"/>	  
		<input type="hidden" name="receiverId" value="${receiverId}"/>
		<textarea cols="30" rows="15" name="content" style="resize: none;"></textarea>
		
		<p><input type="button" value="쪽지 전송" onClick="submit()">
		<input type="button" value="취소하기" onClick="history.go(-1)">
	</form>
	</div>
</body>
</html>