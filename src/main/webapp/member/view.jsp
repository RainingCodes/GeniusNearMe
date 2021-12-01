<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>이웃집 똑똑이 멤버 마이페이지</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
</style>
</head>
<body>
<%@ include file="../main/head.jsp"  %>
<div align="center">
	<h2>이웃집 똑똑이 멤버 마이페이지</h2>
  <table>
  	<tr>
	  	<td>
	  		<table>
	  			<tr>
	  				<td width="200"><a href="<c:url value='/member/update'>
		     		   <c:param name='userEmail' value='${member.email}'/>
				 	 </c:url>">회원 정보 수정</a>
				 	</td>
	  			</tr>
	  			<tr>
	  				<td><a href="<c:url value='/member/ApplyMatching'></c:url>">신청 매칭 목록</a></td>
	  			</tr>
	  			<tr>
	  				<td><a href="<c:url value='/member/ReceiveMatching'></c:url>">받은 매칭 목록</a></td>
	  			</tr>
	  			<tr>
	  				<td><a href="<c:url value='/member/myTalentList'></c:url>">작성한 재능 목록</a></td>
	  			</tr>
	  			<tr>
	  				<td><a href="<c:url value='/member/wishList'></c:url>">위시리스트</a></td>
	  			</tr>
	  			<tr>
	  				<td><a href="<c:url value='/member/messageList'></c:url>">메세지 보관함</a> </td>
	  			</tr>
	  		</table>
	  	</td>
	  	<td align=center>     
		  	<table style="background-color: YellowGreen">
		  	  <tr>
				<td width="120" align="center" bgcolor="E6ECDE" height="22">이메일 ID</td>
				<td width="250" bgcolor="ffffff" style="padding-left: 10">
					${member.email}
				</td>
			  </tr>
			  <tr>
				<td width="120" align="center" bgcolor="E6ECDE" height="22">닉네임</td>
				<td width="250" bgcolor="ffffff" style="padding-left: 10">
					${member.nickname}
				</td>
			  </tr>	  
			  <tr>
				<td width="120" align="center" bgcolor="E6ECDE" height="22">전화번호</td>
				<td width="250" bgcolor="ffffff" style="padding-left: 10">
					${member.phone} <%-- <%=user.getPhone()%> --%>
				</td>
			  </tr>
		 	</table>
	  	</td>
  	</tr>
  </table>
</div>
<!--  
  <table style="width:100%; ">
    <tr>
	  <td width="20"></td>
	  <td align=center>
        <c:if test="${updateFailed || deleteFailed}">
	      <font color="red"><c:out value="${exception.getMessage()}" /></font>
	    </c:if>    
	  </td>
	</tr>
  </table>
-->
</body>
</html>