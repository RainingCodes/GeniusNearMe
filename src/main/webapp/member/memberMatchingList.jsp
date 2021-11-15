<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="service.*" %>
<%@ page import="service.dto.MemberDTO" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Talent Service Test</title>
</head>
<body>
<%
	MemberService memberSvc = new MemberServiceImpl();
	List<MemberDTO> list = memberSvc.ListingMembers();
	request.setAttribute("memberList", list);
%>

<div class="container">   
	<br>
	<h4>사용자 목록</h4>
	<br>
	<table class="table table-bordered">
      <tbody> 
		<c:forEach var="user" items="${userList}">  			  	
	  	    <tr>
			  <td>
			  	${user.userId}     
			  </td>
			  <td>
				<a href="<c:url value='/user/view'>
						   <c:param name='userId' value='${user.userId}'/>
				 		 </c:url>">
				  ${user.name}</a>	 
			  </td>
			  <td>
			    ${user.email} 
			  </td>
			  <td>
				<a href="<c:url value='/community/view'>
						   <c:param name='commId' value='${user.commId}'/>
				 		 </c:url>">		
				${user.commName}</a>
			  </td>
			</tr>
		 </c:forEach> 
	  </tbody>
	</table>		  	 
	<br>   
	<a href="<c:url value='/user/register' />" class="btn btn-primary">사용자 추가 </a>    		     
</div>

</body>
</html>