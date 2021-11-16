<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="service.*" %>
<%@ page import="service.dto.MyMatchingDTO" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>나의 매칭 리스트</title>
</head>
<body>

<div class="container">   
	<br>
	<h4>나의 매칭 리스트</h4>
	<br>
	<table>
      <tbody> 
		<c:forEach var="matching" items="${matchingList}">  			  	
	  	    <tr>
			  <td>
			  	${matching.matchingId}     
			  </td>
			  <td>
				${matching.talentTitle}  
			  </td>
			  <td>
			    ${matching.matchingState} 
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