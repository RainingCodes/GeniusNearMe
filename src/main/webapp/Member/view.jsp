<%@page contentType="text/html; charset=utf-8" %>
<%@page import="service.dto.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	MemberDTO member = (MemberDTO) request.getAttribute("member");
%>
<html>
<head>
<title>사용자 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
<script>
function userRemove() {
	return confirm("정말 삭제하시겠습니까?");		
}
</script>
</head>
<body>
  <br>
  <table style="width:100%">
    <tr>
	  <td width="20"></td>
	  <td>
	    <table>
		  <tr>
			<td class="title">&nbsp;&nbsp;<b>이웃집 솜솜이 멤버 마이페이지</b>&nbsp;&nbsp;</td>
		  </tr>
	    </table>  
	    <br>	  	    
	  	<table style="background-color: YellowGreen">
	  	  <tr>
			<td width="120" align="center" bgcolor="E6ECDE" height="22">이메일 ID</td>
			<td width="470" bgcolor="ffffff" style="padding-left: 10">
				<%=member.getEmail()%>
			</td>
		  </tr>
		  <tr>
			<td width="120" align="center" bgcolor="E6ECDE" height="22">이름</td>
			<td width="470" bgcolor="ffffff" style="padding-left: 10">
				<%=member.getNickname()%>
			</td>
		  </tr>	  
		  <tr>
			<td width="120" align="center" bgcolor="E6ECDE" height="22">전화번호</td>
			<td width="470" bgcolor="ffffff" style="padding-left: 10">
				${member.phone} <%-- <%=user.getPhone()%> --%>
			</td>
		  </tr>
	 	</table>
	    <br>
	    <a href="<c:url value='/member/update'>
	     		   <c:param name='userId' value='<%=member.getUserId()%>'/>
			 	 </c:url>">회원 정보 수정</a> &nbsp;
 	    <a href="<c:url value='/member/delete'>
				   <c:param name='userId' value='<%=member.getUserId()%>'/>
			 	 </c:url>" onclick="return userRemove();">회원 탈퇴</a> &nbsp;
 	    <a href="<c:url value='/' />">이웃집 솜솜이 메인페이지</a> 	    
 	    <br><br>	   
 	    
 	    <!-- 수정 또는 삭제가  실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
        <c:if test="${updateFailed || deleteFailed}">
	      <font color="red"><c:out value="${exception.getMessage()}" /></font>
	    </c:if>    
	  </td>
	</tr>
  </table>  
</body>
</html>