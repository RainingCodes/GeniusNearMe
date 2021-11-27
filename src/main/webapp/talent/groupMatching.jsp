<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<html>
<head>
<meta charset="UTF-8">
<title>그룹 리스트</title>
<script type="text/javascript">
	var cnt = 0;
	$(document).ready(function() {
		$(document).on("click", "input[name='add'])", function() {
			if(cnt >= 5)
				alert("그룹 최대치를 초과했습니다.");
			else {
				cnt++;
				$("#add_btn").before("<p id='group" + cnt +"'>" + cnt +"그룹<input type='hidden' name='group" + cnt + "'></p>");
			}
		}
	})
</script>
</head>
<body>
<h3>그룹 리스트</h3>
<c:if test="${userId eq talent.writerId}"> 
	<form name="form" method="get" action="<c:url value='group/register' />" >
		<c:forEach var="n" items="${num}" varStatus="status">
			${n.length}명 그룹
			<input type="button" name="add" value="추가하기" id="add_btn">
		</c:forEach>
	</form>
</c:if>
<c:if test="${userId ne '-1'}"> 
	<c:if test="${userId ne talent.writerId }">
		<form name="form" method="get" action="<c:url value='/user/register' />">
			<c:forEach var="group" items="${groupList}" varStatus="status">
				<c:forEach var="a" begin="1" end="${group.headCount}">
					<input type="button" name="join" value="참가하기" id="join_btn"> 
				</c:forEach>
			</c:forEach>
		</form>
	</c:if>
</c:if>
</body>
</html>