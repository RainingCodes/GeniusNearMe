<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>내가 신청한 매칭 리스트</title>
</head>
<body>
<%@ include file="../main/head.jsp"  %>
<div>   
	<br>
	<h4 style="text-align: center;">내가 신청한 매칭 리스트</h4>
	<br>
	<table border = "1"  align="center">
	<thead class="thead-inverse">
      	<tr>
		  <td>매칭 ID</td>
		  <td>재능 제목</td>
		  <td>매칭 상태</td>
		  <td>매칭 정보</td>
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
			</tr>
		 </c:forEach>
		</tbody>
	</table>		  	 
	<br>
	<div style="text-align:center;">
	<a href="<c:url value='/member/view' />">목록으로 이동하기</a>    		     
	</div>   
</div>

</body>
</html>