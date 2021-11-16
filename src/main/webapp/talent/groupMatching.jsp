<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="service.dto.GroupDTO" %>
<% 
	GroupDTO[] groupList = (GroupDTO[])request.getAttribute("groupList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그룹 리스트</title>
</head>
<body>
<h3>그룹 리스트</h3>
<form name="form" method="get" action="<c:url value='/user/register' />">
	<c:forEach var="group" items="${groupList}" varStatus="status">
		<c:forEach var="a" begin="1" end="${group.headCount}">
			<input type="button" name="join" value="참가하기" id="join_btn"> 
		</c:forEach>
	</c:forEach>
</form>
</body>
</html>