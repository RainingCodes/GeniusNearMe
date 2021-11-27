<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>이웃집 똑똑이 멤버 마이페이지</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script>
function userRemove() {
	return confirm("정말 탈퇴하시겠습니까? 복구 할 수 없습니다.");		
}
</script>
</head>
<body>
<%@ include file="../main/head.jsp"  %>
  <br>
  <table style="width:100%; ">
    <tr>
	  <td width="20"></td>
	  <td align=center>
	    <table>
		  <tr>
			<td class="title">&nbsp;&nbsp;<b>이웃집 똑똑이 멤버 마이페이지</b>&nbsp;&nbsp;</td>
		  </tr>
	    </table>  
	    <br>	  	    
	  	<table style="background-color: YellowGreen">
	  	  <tr>
			<td width="120" align="center" bgcolor="E6ECDE" height="22">이메일 ID</td>
			<td width="400" bgcolor="ffffff" style="padding-left: 10">
				${member.email}
			</td>
		  </tr>
		  <tr>
			<td width="120" align="center" bgcolor="E6ECDE" height="22">닉네임</td>
			<td width="400" bgcolor="ffffff" style="padding-left: 10">
				${member.nickname}
			</td>
		  </tr>	  
		  <tr>
			<td width="120" align="center" bgcolor="E6ECDE" height="22">전화번호</td>
			<td width="400" bgcolor="ffffff" style="padding-left: 10">
				${member.phone} <%-- <%=user.getPhone()%> --%>
			</td>
		  </tr>
	 	</table>
	    <br>
	    <a href="<c:url value='/member/update'>
	     		   <c:param name='userEmail' value='${member.email}'/>
			 	 </c:url>">회원 정보 수정</a> &nbsp;
 	    <a href="<c:url value='/member/delete'>
				   <c:param name='userEmail' value='${member.email}'/>
			 	 </c:url>" onclick="return userRemove();">회원 탈퇴</a> <p>
		<a href="<c:url value='/member/ApplyMatching'></c:url>">내가 신청한 매칭 목록</a> &nbsp;
		<a href="<c:url value='/member/ReceiveMatching'></c:url>">내가 받은 매칭 목록</a>
		<a href="<c:url value='/member/myTalentList'></c:url>">내가 작성한 게시글 목록</a> <p>
		
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