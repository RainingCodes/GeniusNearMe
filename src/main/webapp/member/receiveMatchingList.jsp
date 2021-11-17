<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>내가 받은 매칭 리스트</title>
</head>
<script>
function matching() {
	var url = "/matching/choose";
	var name = "talent test"
	var option = "width = 500, height = 500, top = 100, left = 200, location = no"
	window.open(url, name, option);
	form.submit();
}
function submitForm() {
	   form.submit();
}
</script>
<body>
<div>   
	<br>
	<h4>내가 받은 매칭 리스트</h4>
	<br>
	<table border = "1">
	<thead class="thead-inverse">
      	<tr>
		  <td>매칭 ID</td>
		  <td>재능 제목</td>
		  <td>재능 상태</td>
		  <td>매칭 결정하기</td>
		</tr>
      </thead>
      <tbody> 
		<c:forEach var="li" items="${list}">  			  	
	  	    <tr>
			  <td>
			  	<c:out value="${li.matchingId}"/>     
			  </td>
			  <td>
			  	<a href="<c:url value='/talent/view'>
						   <c:param name='talentId' value='${li.talentId}'/>
				 		 </c:url>">		
				${li.talentTitle}</a>
			  </td>
			  <td>
				<c:set var="state" value="${li.matchingState}" />
				  <c:choose>
				  	<c:when test="${state eq '0'}">
				  		매칭 신청 중
				    </c:when>
				    <c:when test="${state eq '1'}">
				  		매칭 성공
				    </c:when>
				    <c:when test="${state eq '2'}">
				  		매칭 거절
				    </c:when>
				</c:choose>
			  </td>
			  <td>
				<c:choose>
				  	<c:when test="${state eq '0'}">
				  		<form name="form" method="POST" action="<c:url value='/matching/choose' />">
				  			<input type="hidden" name="matchingId" value="${li.matchingId}">
				  			<input type="hidden" name="talentId" value="${li.talentId}">
				  			<input type="button" onClick="submitForm()" value="매칭ㅇ">
				  		</form>
				    </c:when>
				    <c:when test="${state eq '1'}">
				  		매칭 성공
				    </c:when>
				    <c:when test="${state eq '2'}">
				  		매칭 거절
				    </c:when>
				</c:choose>
			  </td>
			</tr>
		 </c:forEach>
		</tbody>
	</table>		  	 
	<br>   
	<a href="<c:url value='/member/view' />">목록으로 이동하기</a>    		     
</div>

</body>
</html>