<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	int[] headCountList = (int[])session.getAttribute("headCountList");
	GroupDTO[] groupList = (int [])request.getAttribute("groupList");'
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
<h3>그룹 리스트</h3>
<form name="form">
	<c:forEach var="group" items="${groupList}" varStatus="status">
		<c:forEach var="a" begin="1" end="${group.getHeadCount}">
			<input type="button" name="join" value="참가하기" id="join_btn"> 
		</c:forEach>
	</c:forEach>
</form>
</body>
</html>