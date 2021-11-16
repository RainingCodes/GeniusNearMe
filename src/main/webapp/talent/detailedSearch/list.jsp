<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="service.*"%>
<%@ page import="service.dto.TalentDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Iterator" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세검색 결과페이지</title>
<link rel="stylesheet" href="../css/talent.css" type="text/css">
</head>
<body>
	<%
		// 카테고리값(체크박스)들을 모두 읽어와서 저장
		String[] selectedCategory = request.getParameterValues("category");
		TalentService talentService = new TalentServiceImpl();
		
		List<TalentDTO> talentList = talentService.getTalentByTalentCategory(selectedCategory);
		request.setAttribute("talentList", talentList);
		
		// 결과내 재검색 키워드 저장
		String reSearch = request.getParameter("reSearch");
		
		//price값 저장
		String price = request.getParameter("price");
		
		//시작날짜, 종료날짜 저장
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
	%>
		<div class="nav">
		<form method="post" action="../detailedSearch/list.jsp">
		<p></p>
		<input type="text" id="reSearch" name="reSearch" placeholder="결과내 재검색" value=<%=reSearch%>>
		<p></p>
		<strong>카테고리</strong><br>
		<div class="category">
			<input type="checkbox" name="category" value="all"
				<% if (Arrays.asList(selectedCategory).contains("all")==true){
					out.print(" checked");
				}
				%>>모든 재능
			<input type="checkbox" name="category" value="beauty"
				<% if (Arrays.asList(selectedCategory).contains("beauty")==true){
					out.print(" checked");
				}%>>뷰티<br>
			<input type="checkbox" name="category" value="sports"
				<% if (Arrays.asList(selectedCategory).contains("sports")==true){
					out.print(" checked");
				}%>>운동
			<input type="checkbox" name="category" value="foreignLanguage"
				<% if (Arrays.asList(selectedCategory).contains("foreignLanguage")==true){
					out.print(" checked");
				}%>>외국어<br>
			<input type="checkbox" name="category" value="cook"
				<% if (Arrays.asList(selectedCategory).contains("cook")==true){
					out.print(" checked");
				}%>>요리
			<input type="checkbox" name="category" value="law"
				<% if (Arrays.asList(selectedCategory).contains("law")==true){
					out.print(" checked");
				}%>>법률<br>
			<input type="checkbox" name="category" value="it"
				<% if (Arrays.asList(selectedCategory).contains("it")==true){
					out.print(" checked");
				}%>>IT
			<input type="checkbox" name="category" value="art"
				<% if (Arrays.asList(selectedCategory).contains("art")==true){
					out.print(" checked");
				}%>>예술<br>
			<input type="checkbox" name="category" value="game"
				<% if (Arrays.asList(selectedCategory).contains("game")==true){
					out.print(" checked");
				}%>>게임
			<input type="checkbox" name="category" value="mechanic"
				<% if (Arrays.asList(selectedCategory).contains("mechanic")==true){
					out.print(" checked");
				}%>>수리<br>
		</div>
		<p></p>
		<strong>가격대</strong>
		<p></p>
		<input type="range" min="0" max="100000" step="1000" id="priceRange" name="price" value=<%=price%>>
		<p></p>
		<p></p>
		<strong>날짜</strong><br> <input type="date" name="startDate" value=<%=startDate%>>~<input type="date" name="endDate" value=<%=endDate%>>
		<p></p>
		<input type="submit" value="상세 검색" style="width: 150px;">
		</form>
	</div>
	<div class="content">
		<div id="sort" style="margin-left: 680px;"><!-- | <button>리뷰많은순</button> -->
		</div>
		
		<c:forEach var="talent" items="${talentList}">
			<div class="post">
				<div id="imgSection1">
					<img id="thumbnail" src="img/loopy/img1.jpg" width="120" height="120">
				</div>
				<p>
					<a href="<c:url value='showTalent.jsp'>
						<c:param name='talentTitle' value='${talent.talentTitle}'/>
						</c:url>"><strong>${ talent.title }</strong>
					</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;%{talent.writtenDate}
				</p>
				<p></p>
				<p></p>
				<p>${ talent.content }</p>
			</div>
		</c:forEach>
	</div>
</body>
</html>