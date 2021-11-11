<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="service.*" %>
<%@ page import="service.dto.TalentDTO" %>
<jsp:useBean id="talent" class="service.dto.TalentDTO" scope="page"/>
<jsp:setProperty name="talent" property="*"/>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>재능글 검색결과</title>
</head>
<body>
	<%
		TalentService talentService = new TalentServiceImpl();
	
	

	
	%>
</body>
</html>