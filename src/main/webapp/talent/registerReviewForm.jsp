<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 유저아이디와 매칭 상태, 게시글 아이디를 비교하여 리뷰를 달 수 있는 사용자인지 아닌지에 따라서
		리뷰 등록 폼 보여주기 / 안보여주기-->
		<form name = "form" action="<c:url value='/talent/reviewRegister' />">
			 <textarea rows="5" cols="50" name="content" placeholder="리뷰를 적어주세요"></textarea>
			 <input type="hidden" name="talentId" value="${talentId}"/>
			 <input type="button" value="등록" onClick="submit()">
		</form>
</body>
</html>