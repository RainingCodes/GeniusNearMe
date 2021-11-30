<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String commentTalentId = request.getParameter("commentTalentId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>덧글</title>
</head>
<body>
	<div class="messageSend" align="center">
	<br>
	<h1>메세지 보내기</h1>
	<p>
	받는 이 : ${rNickname}
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