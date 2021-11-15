<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이웃집 똑똑이</title>
<style type="text/css">
	table {
		width : 100%;
	}
	
	.search_icon {
		height : 15px;
		width : 15px;
	}
	.btn_talent_test {
		background-color : transparent;
		border : none;
	}
	img {
		width : 250px;
		height : 110px;
	}
	
</style>
</head>
<body>
<table>
	<tr>
		<td class="talent_test" valign="bottom">
			<button type="button" class="btn_talent_test">관심 재능 검사<img alt="돋보기" src="../img/search.png" class="search_icon"></button>
		</td> 
		<td class="logo" align="center">
			<a>
				<img alt="로고" src="<c:url value='img/logo.png' />">
			</a>
		</td>
		<td class="login" valign="bottom">
			<a href="<c:url value='../member/login/form' />">로그인</a>
		</td>
		<td class="join" valign="bottom">
			<a href="<c:url value='../member/register/form' />">회원가입</a>
		</td>
	</tr>
</table>
<hr />
</body>
</html>