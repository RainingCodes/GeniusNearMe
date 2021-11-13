<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="service.*"%>
<%@ page import="service.dto.TalentDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="talent" class="service.dto.TalentDTO" scope="page" />
<jsp:setProperty name="talent" property="*" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>재능글 검색결과</title>
<style type="text/css">
body {
	font: 14p, sans-serif;
}

frame {
	margin: 0 auto;
	border: 1px solid #aaa;
}

.nav {
	float: left;
	width: 200px;
	margin-left: 200px;
}

.nav-list {
	margin: 0;
	padding: 10px 10px;
}

.nav-item {
	margin: 10px 0;
}

.content {
	float: left;
	width: 900px;
	background: #fff;
	margin: 10px 0px 0px 30px;
}

button {
	border: 0;
	outline: 0;
	background: #fff;
}

.post {
	border: 1px solid;
	padding: 10px;
	margin: 10px;
}

.category {
	display: inline-block;
	width: 200px;
	line-height: 30px;
}

.container {
	float: center;
}

.post {
	display: inline-block;
	border: 1px solid;
	padding: 10px;
	margin: 15px 10px 10px 10px;
	width: 800px;
	height: 150px;
	border-radius: 30px;
}

#thumbnail1 {
	border-radius: 30px;
	margin: 15px 30px 10px 30px;
	float: left;
}

#imgSection {
	width: 100px;
	margin: 15px;
	float: left;
}

#priceRange {
	width: 100px;
}

p {
	margin: 15px;
}
</style>
</head>
<body>
	<%
	TalentService talentService = new TalentServiceImpl();
	MemberService memberService = new MemberServiceImpl();
	List<TalentDTO> talentList = talentService.ListingTalents();
	request.setAttribute("talentList", talentList);
	
	// 체크박스값들을 모두 읽어옴
	String selectedCategory[] = request.getParameterValues("category");
	%>
	<div class="nav">
		<form name="reSearchForm" method="post"> <!-- 상세검색/재검색 -->
		<p></p>
		<input type="text" id="value" placeholder="결과내 재검색" style="width:100px"> <input type="submit" value="검색">
		<p></p>
		<strong>카테고리</strong><br>
		<div class="category">
			<input type="checkbox" name="category" value="all" checked>모든 재능<input type="checkbox" name="category" value="beauty">뷰티<br>
			<input type="checkbox" name="category" value="sports">운동<input type="checkbox" name="category" value="foreignLanguage">외국어<br>
			<input type="checkbox" name="category" value="cook">요리<input type="checkbox" name="category" value="law">법률<br>
			<input type="checkbox" name="category" value="it">IT<input type="checkbox" name="category" value="art">예술<br>
		</div>
		<p></p>
		<strong>가격대</strong>
		<p></p>
		<input type="range" min="0" max="100000" step="1000" id="priceRange">
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
					<img id="thumbnail1" src="img/loopy/img1.jpg" width="120" height="120">
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
		</div>  --%>
		
		
		<%-- <div class="post">
			<div id="imgSection1">
				<img id="thumbnail1" src="img/loopy/img1.jpg" width="120" height="120">
			</div>
			<p>
				<strong>석고방향제 원데이 클래스</strong>
			</p>
			<p></p>
			<p></p>
			<p>나만의 특별한 향을 간직하고 있는 방향제를 만들고 싶다면 저의 수업을 들어보세요! 선물로도 딱이랍니다</p>
		</div>
		<div class="post">
			<div id="imgSection1">
				<img id="thumbnail1" src="img/loopy/img2.jpg" width="120" height="120">
			</div>
			<p>
				<strong>석고방향제 주문제작</strong>
			</p>
			<p></p>
			<p></p>
			<p>원하는 향과 도안으로 주문제작 해드립니다.</p>
		</div>
		<div class="post">
			<div id="imgSection1">
				<img id="thumbnail1" src="img/loopy/img3.jpg" width="120" height="120">
			</div>
			<p>
				<strong>디퓨저/석고방향제/캔들 제작</strong>
			</p>
			<p></p>
			<p></p>
			<p>향 관련 제품들 모두 주문가능하니 둘러보세요!궁금한 점이나 요청사항 있으시면 쪽지,댓글 주세요.제작일정 때문에
				확인이 조금 느릴 수 있는 점 양해부탁드려요</p>
		</div>
		<div class="post">
			<div id="imgSection1">
				<img id="thumbnail1" src="img/loopy/img4.jpg" width="120" height="120">
			</div>
			<p>
				<strong>석고방향제 원데이 클래스</strong>
			</p>
			<p></p>
			<p></p>
			<p>나만의 특별한 향을 간직하고 있는 방향제를 만들고 싶다면 저의 수업을 들어보세요! 선물로도 딱이랍니다</p>
		</div> --%>
	</div>
	<br>
	<!-- <a href="index.jsp">GO BACK</a>  -->
</body>
</html>