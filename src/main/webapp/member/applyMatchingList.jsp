<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>내가 신청한 매칭 리스트</title>
</head>
<body>
<div>   
	<br>
	<h4>내가 신청한 매칭 리스트</h4>
	<br>
	<table border = "1">
	<thead class="thead-inverse">
      	<tr>
		  <td>매칭 ID</td>
		  <td>재능 제목</td>
		  <td>재능 상태</td>
		  <td>매칭 결과에 따른 상호작용</td>
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
				interact(후에 추가 ex:유저정보 본다던가)
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