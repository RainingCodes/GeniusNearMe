<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 등록창</title>
</head>
<body>
<div align="center">
	<h1>리뷰 등록하기</h1>
		<% 
			String talentId = request.getParameter("talentId");
			String matchingId = request.getParameter("matchingId");
		%>
		<form name = "form" action="<c:url value='/talent/reviewRegister' />">
			 <textarea rows="5" cols="50" name="content" placeholder="리뷰를 적어주세요"></textarea>
			 <input type="hidden" name="talentId" value="<%=talentId%>">
			 <input type="hidden" name="matchingId" value="<%=matchingId%>">
			 <input type="button" value="등록" onClick="submit()">
		</form>
</div>
</body>
</html>