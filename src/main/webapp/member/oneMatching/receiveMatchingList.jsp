<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>내가 받은 매칭 리스트</title>
</head>
<script>
</script>
<body>
<div id="receive">
<div>   
	<h3 style="text-align: center;">받은 1:1 매칭 리스트</h3>
	<br>
	<table border = "1" align="center">
	<thead class="thead-inverse">
      	<tr>
      		<td>매칭 id</td>
		  <td>재능 제목</td>
		  <td>매칭 신청자</td>
		  <td>재능 상태</td>
		  <td>매칭 결정하기</td>
		</tr>
      </thead>
      <tbody> 
		<c:forEach var="li" items="${receiveList}" varStatus="status">
	  	    <tr>
	  	    	<td>${li.matchingId }</td>
			  <td>
			  	<a href="<c:url value='/talent/view'>
						   <c:param name='talentId' value='${li.talentId}'/>
				 		 </c:url>">		
				${li.talentTitle}</a>
			  </td>
			  <td>
			  	${nickList[status.index] }
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
				  		<form name="form1" method="POST" action="<c:url value='/matching/choose' />">
				  			<input type="hidden" name="matchingId" value="${li.matchingId}">
				  			<input type="hidden" name="talentId" value="${li.talentId}">
				  			<input type="hidden" name="state" value="decideMatching">
				  			<button type="submit">매칭 수락</button>
				  		</form>
				  		<form name="form2" method="POST" action="<c:url value='/matching/choose' />">
				  			<input type="hidden" name="matchingId" value="${li.matchingId}">
				  			<input type="hidden" name="talentId" value="${li.talentId}">
				  			<input type="hidden" name="state" value="denyMatching">
				  			<button type="submit">매칭 거절</button>
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
	
</div>
</div>
</body>
</html>