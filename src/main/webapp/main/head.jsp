<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="controller.user.UserSessionUtils" %>
<%
	String nickname = (String)session.getAttribute("nickname");
%>
<script language="JavaScript">
function talentTest() {
	var url = "talentTest.jsp";
	var name = "talent test"
	var option = "width = 500, height = 500, top = 100, left = 200, location = no"
	window.open(url, name, option);
	}
function goHome() {
	location.herf="/";
}
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이웃집 똑똑이</title>
<link rel=stylesheet href="<c:url value='/css/head.css' />" type="text/css">
</head>
<body>
<table class="head_table">
	<tr>
		<td class="talent_test" valign="bottom">
			<button type="button" class="btn_talent_test">관심 재능 검사<img alt="돋보기" src="/img/search.png" class="search_icon"></button>
		</td> 
		<td class="logo" align="center">
			<a href="<c:url value='/' />">
				<img alt="로고" src="<c:url value='/img/logo.png' />" class="logo">
			</a>
		</td>
<%
	if(UserSessionUtils.hasLogined(request.getSession())) {
%>
		<td class="user" valign="bottom">
			<a href="<c:url value='/member/view' />"><%=nickname %>님</a>
		</td>
		<td valign="bottom">
			<a href="<c:url value='/member/logout' />">로그아웃</a>
		</td>
		<td valign="bottom">
			<a href="<c:url value='/talent/registerForm' />">재능 글 작성</a>
		</td>
		<!-- 
		<td class="" valign="bottom">
			<button type="button" class="btn_chat"><img alt="채팅" src="img/chat.png" class="img_chat"></button>
		</td> -->
<%
	} else {
%>		
		<td class="login" valign="bottom">
			<a href="<c:url value='/member/login/form' />">로그인</a>
		</td>
		<td class="join" valign="bottom">
			<a href="<c:url value='/member/register/form' />">회원가입</a>
		</td>
<%
	}
%>
	</tr>
</table>
<hr />
</body>
</html>