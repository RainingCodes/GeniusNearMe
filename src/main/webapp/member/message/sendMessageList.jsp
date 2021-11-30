<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보낸 쪽지함</title>
</head>
<body>
<div id="sender">
<h2>보낸 쪽지함</h2>
	<table border = "1" align="center">
	<thead class="thead-inverse">
      	<tr>
		  <td>받는 사람</td>
		  <td>내용</td>
		  <td>보낸 날짜</td>
		  <td>수신 여부</td>
		</tr>
      </thead>
      <tbody> 
		<c:forEach var="li" items="${sendList}" varStatus="status">
	  	    <tr>
			  <td>
			  	${sendListNicekname[status.index]}
			  </td>
			  <td>
			  	<a href="<c:url value='/message/read'>
						   <c:param name='message' value='${li}'/>
						   <c:param name='type' value='send'/>
				 		 </c:url>">	
				 	<div class="ellipsis" style="width: 170px"><c:out value="${li.content}" /></div>	
				</a>
				
			  </td>
			  <td>
			  	${li.writtenDate}
			  </td>
			  <td>
			  	<c:if test="${li.state eq 0}"> 
			  		읽지 않음
			  	</c:if>
			  	<c:if test="${li.state eq 1}"> 
			  		읽음
			  	</c:if>
			  </td>
			</tr>
		 </c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>