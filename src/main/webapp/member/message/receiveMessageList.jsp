<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>받은 쪽지함</title>
</head>
<body>
<div id='receive' align="center">
	<table border = "1" align="center">
	<thead class="thead-inverse">
      	<tr>
		  <td>보낸 사람</td>
		  <td>내용</td>
		  <td>보낸 시간</td>
		</tr>
      </thead>
      <tbody> 
		<c:forEach var="li" items="${list}" varStatus="status">
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
</div>
</body>
</html>