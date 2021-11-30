<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String talentId = request.getParameter("talentId");
	
%>
<script type="text/javascript">
	var cnt = 0;
	var head = new Array("${prices.size()}");
	var i = 0;
	$(document).ready(function() {
		$(document).on("click", "input[name='add']", function () {
			var thisGroup = $(this).attr('id');
			if(inGroup[thisGroup] >= 5)
				alert("더 이상 추가할 수 없습니다.");
			else {
				inGroup[thisGroup]++;
				$(this).before("<p>" + "그룹" +inGroup[thisGroup] + "</p>");
				if(inGroup[thisGroup] == 1)
					$(this).before("<input type='hidden' name='group" + head[thisGroup] + "' id='group" + head[thisGroup] + "' value='"+ inGroup[thisGroup] + "'>");
				else
					$("#group" + head[thisGroup]).val(inGroup[thisGroup]);
			}
		 });
	});
</script>
<div id='group'>
<h3>그룹 리스트</h3>
<c:if test="${groupList.size() eq 0}">
	<c:if test="${userId eq talent.writerId}"> 
		<form name="form" method="get" action="<c:url value='/group/register' />" >
			<c:forEach var="price" items="${prices}" varStatus="status">
				<p>
					<c:if test='${price.headCount ne 1}'>
						<p>
							<c:out value="${price.headCount}" />명 그룹 리스트
							<script>
							head[i++] = "${price.headCount}";
							document.write("<input type='button' name='add' value='추가하기' id='" + cnt +"' >");
							cnt++;
							</script>
						</p> 
					</c:if>
				</p>
			</c:forEach>
			
			<script>
				var inGroup = new Array(cnt);
				for(var i = 0; i< inGroup.length; i++)
					inGroup[i] = 0;
			</script>
			<input type="hidden" name="talentId" value="<%=talentId %>">
	    	<input type="submit" value="저장하기">
	    	<c:set var="priceList" scope="session" value="${prices}" />
		</form>
	</c:if>
</c:if>
<c:if test="${groupList ne null }">
	<c:if test="${userId ne '-1'}"> 
		<form name="form" method="get" action="<c:url value='/user/register' />">
			<c:forEach var="group" items="${groupList}" varStatus="status">
				<p>
					<c:out value="${group.headCount}" />명 그룹 / 그룹 아이디 : <c:out value="${group.groupId }" /> <br>
					<c:forEach var="a" begin="1" end="${group.headCount}">
						<c:if test="${userId ne talent.writerId }">
							<a href="<c:url value='/group/matching'>
								<c:param name='talentId' value='${talent.talentId}'/>
                                 <c:param name='groupId' value='${group.groupId }' />
                               	</c:url>">그룹 매칭 신청하기 </a>
						</c:if>
					</c:forEach>
				</p>
			</c:forEach>
		</form>
		<c:if test="${userId eq talent.writerId }">
							<a herf="<c:url value='/group/update'>
								<c:param name='talentId' value='${talent.talentId}'/>
				                <c:param name='userId' value='${talent.writerId }'/>
				              </c:url>">그룹 수정하기</a>
						</c:if>
	</c:if>
</c:if>
</div>