<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="service.*"%>
<%@ page import="service.dto.TalentDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%-- <%
	TalentService talentService = new TalentServiceImpl();
	MemberService memberService = new MemberServiceImpl();
	List<TalentDTO> talentList = (List<TalentDTO>)request.getAttribute("talentList");
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>재능글 검색결과</title>
<link rel="stylesheet" href="../css/talent.css" type="text/css">
</head>
<body>
<%@ include file="../../main/head.jsp"  %>
	<div class="nav">
		<form method="post" action="../detailedSearch/list.jsp">
		<p></p>
		<input type="text" id="reSearch" name="reSearch" placeholder="결과내 재검색">
		<p></p>
		<strong>카테고리</strong><br>
		<div class="category">
			<input type="checkbox" name="category" value="all" checked>모든 재능 <input type="checkbox" name="category" value="beauty">뷰티<br>
			<input type="checkbox" name="category" value="sports">운동 <input type="checkbox" name="category" value="foreignLanguage">외국어<br>
			<input type="checkbox" name="category" value="cook">요리 <input type="checkbox" name="category" value="law">법률<br>
			<input type="checkbox" name="category" value="it">IT <input type="checkbox" name="category" value="art">예술<br>
			<input type="checkbox" name="category" value="game">게임 <input type="checkbox" name="category" value="mechanic">수리<br>
		</div>
		<p></p>
		<strong>가격대</strong>
		<p></p>
		<input type="range" min="0" max="100000" step="1000" id="priceRange" name="price" value="50000">
		<p></p>
		<p></p>
		<strong>날짜</strong><br> <input type="date" name="startDate">~<input type="date" name="endDate">
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
					<img id="thumbnail" src="../img/loopy/img1.jpg" width="120" height="120">
				</div>
				<p>
					<a href="<c:url value='view.jsp'>
						<c:param name='talentId' value='${talent.talentId}'/>
						</c:url>"><strong>${ talent.title }</strong>
					</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${talent.writtenDate}
				</p>
				<p></p>
				<p></p>
				<p>${talent.content}</p>
			</div>
		</c:forEach>
			
		<%-- <div class="post">
			<div id="imgSection1">
				<img id="thumbnail1" src="img/loopy/img1.jpg" width="120" height="120">
			</div>
			<p>
				<a href="showTalent.jsp"><strong><% out.print(talent.getTitle()); %></strong></a> <!-- parameter넘기는 코드 필요 -->
			</p>
			<p></p>
			<p></p>
			<p>
				<%out.print(talent.getContent()); %>
			</p>
		</div>
		 --%>
	</div>
	<br>
	<!-- <a href="index.jsp">GO BACK</a>  -->
</body>
</html>