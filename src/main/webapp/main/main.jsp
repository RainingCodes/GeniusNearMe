<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="controller.user.UserSessionUtils" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이웃집 똑똑이</title>
</head>
<body>

<%
	if(UserSessionUtils.hasLogined(request.getSession())) {
%>
<%@ include file="head_login.jsp"  %>
<%
	} else {
%>
<%@ include file="head.jsp"  %>
<%
	}
%>
<%@ include file="talentList.jsp" %>
</body>
</html>