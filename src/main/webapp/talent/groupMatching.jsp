<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	var cnt = 0;
	$(document).ready(function() {
		$(document).on("click", "input[name='add'])", function() {
				$("#add_btn" + cnt).before("<p id='group" + cnt +"'>" + cnt +"그룹<input type='hidden' name='group" + cnt + "'></p>");
		});
	});
</script>
<div id='group'>
<h3>그룹 리스트</h3>
<c:if test="${userId eq talent.writerId}"> 
	<form name="form" method="get" action="<c:url value='group/register' />" >
		<c:forEach var="price" items="${prices}" varStatus="status">
			<c:out value="${price.headCount}" />명 그룹
			<script>
			cnt++;
			document.write("<input type='button' name='add' value='추가하기' id='add_btn" + cnt +"' >");</script>
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
</div>