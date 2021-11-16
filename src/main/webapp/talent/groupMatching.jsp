<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	int[] headCountList = (int[])session.getAttribute("headCountList");
%>
<script src="https://code.jquery.com/jquery-1.12.4.min.js" />
<script language="JavaScript">
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그룹 리스트</title>
</head>
<body>
<h1>그룹 리스트</h1>
<form name="form"><
	<c:forEach var="headCount" items="${headCountList}" varStatus="status">
		${headcount}<c:if test="${!status.last}">, </c:if>
			<input type="button" name="join" value="참가하기" id="join_btn">
	</c:forEach>
</form>
</body>
</html>