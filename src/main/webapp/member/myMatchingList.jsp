<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>나의 매칭 리스트</title>
</head>
<body>
<div>   
	<br>
	<h4>나의 매칭 리스트</h4>
	<br>
	<table border = "1">
	<thead class="thead-inverse">
      	<tr>
		  <td>매칭 ID</td>
		  <td>재능 제목</td>
		  <td>재능 상태</td>
		  <td>재능글 이동</td>
		</tr>
      </thead>
      <tbody> 
		<c:forEach var="li" items="${list}">  			  	
	  	    <tr>
			  <td>
			  	<c:out value="${li.matchingId}"/>     
			  </td>
			  <td>
				${li.talentTitle}  
			  </td>
			  <td>
			    ${li.matchingState} 
			  </td>
			  <td>
				<a href="<c:url value='/talent/view'>
						   <c:param name='talentId' value='${matching.talentId}'/>
				 		 </c:url>">		
				매칭글로 이동하기</a>
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