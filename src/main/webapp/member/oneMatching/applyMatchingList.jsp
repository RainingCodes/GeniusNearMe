<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>내가 신청한 매칭 리스트</title>
</head>
<body>
<div id="apply">
<div>   
	<h3 style="text-align: center;">신청한 1:1 매칭 리스트</h3>
	<br>
	<table border = "1"  align="center">
	<thead class="thead-inverse">
      	<tr>
      		<td>매칭 id</td>
		  <td>재능 제목</td>
		  <td>매칭 상태</td>
		  <td>매칭 정보</td>
		  <td>리뷰</td>
		</tr>
      </thead>
      <tbody> 
		<c:forEach var="li" items="${applyList}" varStatus="status">  	
	  	
	  	    <tr>
	  	    <td>${li.matchingId }</td>
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
				  <c:set var="state" value="${li.matchingState}" />
					  <c:choose>
					  	<c:when test="${state eq '0'}">
					  		아직 매칭 신청 중입니다.
					    </c:when>
					    <c:when test="${state eq '1'}">
					    ${matchingWriterInfo[status.index].nickname}<br>
					  		${matchingWriterInfo[status.index].phone}
					    </c:when>
					    <c:when test="${state eq '2'}">
					  		매칭이 거절당했습니다.
					    </c:when>
					</c:choose>
			  </td>
			  <td>
			  	<c:set var="state" value="${li.matchingState}" />
			  		<c:choose>
			  			<c:when test="${state eq '0'}">
					  		아직 리뷰 작성이 불가합니다
					    </c:when>
					    <c:when test="${state eq '1'}">
						    <c:choose>
						    	<c:when test="${writtenReview[status.index] eq '0' }">
						    		<a href="../talent/registerReviewForm.jsp?talentId=${li.talentId}&matchingId=${li.matchingId}">리뷰하기</a>
						    	</c:when>
						    	<c:otherwise>
						    		리뷰가 이미 작성되었습니다.
						    	</c:otherwise>
						    </c:choose>
					    </c:when>
					    <c:when test="${state eq '2'}">
					  		X
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