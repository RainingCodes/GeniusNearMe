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
<div id="receive">
<h2>받은 쪽지함</h2>
	<div class = "receive" align="center">
		<table border = "1" align="center">
		<thead class="thead-inverse">
	      	<tr>
			  <td>보낸 사람</td>
			  <td>내용</td>
			  <td>보낸 시간</td>
			</tr>
	      </thead>
	      <tbody> 
			<c:forEach var="li" items="${receiveList}" varStatus="status">
		  	    <tr>
				  <td>
				  	${receiveListNicekname[status.index]}
				  </td>
				  <td>	
					<a href="<c:url value='/message/read'>
						   <c:param name='message' value='${li.messageId}'/>
						   <c:param name='type' value='receive'/>
				 		 </c:url>">		
				 		 <div class="ellipsis" style="width: 170px"><c:out value="${li.content}" /></div>
					</a>
					
				  </td>
				  <td>
				  	${li.writtenDate}
				  </td>
				</tr>
			 </c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>