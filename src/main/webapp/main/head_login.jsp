<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	
	String nickname = (String)session.getAttribute("nickname");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이웃집 똑똑이</title>
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
<link rel=stylesheet href="<c:url value='/css/head.css' />" type="text/css">
</head>
<body>
<table class="head_table">
	<tr>
		<td class="talent_test" valign="bottom">
			<button type="button" class="btn_talent_test" onclick="talentTest()">관심 재능 검사<img alt="돋보기" src="../img/logo.png" class="search_icon"></button>
		</td>
		<td class="logo" align="center">
			<a>
				<img alt="로고" src="img/logo.png">
			</a>
		</td>
		<td class="user" valign="bottom">
			<a href="<c:url value='../member/view' />"><%=nickname %>님</a>
		</td>
		<td>
			<a href="<c:url value='../member/logout' />">로그아웃</a>
		</td>
		<td class="" valign="bottom">
			<button type="button" class="btn_chat"><img alt="채팅" src="img/chat.png" class="img_chat"></button>
		</td>
	</tr>
</table>
<hr />
</body>
</html>