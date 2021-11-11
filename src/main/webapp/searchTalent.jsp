<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="service.*"%>
<%@ page import="service.dto.TalentDTO"%>
<%@ page import="java.util.List"%>
<jsp:useBean id="talent" class="service.dto.TalentDTO" scope="page" />
<jsp:setProperty name="talent" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>재능글 검색결과</title>
</head>
<body>
	<%
	TalentService talentService = new TalentServiceImpl();
		List<TalentDTO> talentList = talentService.getTalent(talent.getTitle());

		for (int i = 0; i < talentList.size(); i++){
			out.print("재능글 id: " + talent.getTitle() + "<br>");
			out.print("재능글 제목: " + talent.getTitle() + "<br>");
			out.print("재능글 카테고리: " + talent.getTitle() + "<br>");
			out.print("타입: " + talent.getTitle() + "<br>");
			out.print("작성자: " + talent.getTitle() + "<br>");
			out.print("내용: " + talent.getTitle() + "<br>");
			//...			
		}
	%>
<br>
<!-- <a href="index.jsp">GO BACK</a>  -->
</body>
</html>
