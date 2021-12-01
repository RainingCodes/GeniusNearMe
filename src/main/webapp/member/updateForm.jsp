<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>이웃집 똑똑이 회원정보 수정</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script>
function userModify() {
	if (form.password.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.password.focus();
		return false;
	}
	if (form.password.value != form.password2.value) {
		alert("비밀번호가 일치하지 않습니다.");
		form.name.focus();
		return false;
	}
	if (form.nickname.value == "") {
		alert("닉네임을 입력하십시오.");
		form.name.focus();
		return false;
	}
	var phoneExp = /^\d{2,3}-\d{3,4}-\d{4}$/;
	if(phoneExp.test(form.phone.value)==false) {
		alert("전화번호 형식이 올바르지 않습니다.");
		form.phone.focus();
		return false;
	}
	form.submit();
}

function delete_check(){
	var answer;
	answer = confirm("정말로 탈퇴하시겠습니까? 되돌릴 수 없습니다.");
	if(answer == true){
		 document.form2.submit();
	} else {
		return;
	}
}

function gotoUri(targetUri) {
	form.action = targetUri;
	form.submit();
}
</script>
</head>
<body>
<br>
<!-- Update Form  -->
<%@ include file="../main/head.jsp"  %>
<form name="form" method="POST" action="<c:url value='/member/update' />">
  <input type="hidden" name="userId" value="${member.userId}"/>
  <input type="hidden" name="email" value="${member.email}"/>	  
  <table style="width: 100%;">
	<tr>
	  <td width="20"></td>
	  <td>
	    <table style="margin:auto;">
		  <tr>
			<td class="title"><b>이웃집 똑똑이 회원정보 수정</b></td>
		  </tr>
	    </table>  
	    <br>	 
	    <div align="center">
		    <c:if test="${updateFailed}">
		  	  <font color="red"><c:out value="${exception.getMessage()}" /></font><br><br>
		    </c:if>
	    </div>
	    <table style="margin:auto; background-color: YellowGreen;">
	  	  <tr height="40">
			<td width="150" align="center" bgcolor="E6ECDE">이메일 ID</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				${member.email}
			</td>
		  </tr>
		  <tr height="40">
			<td width="150" align="center" bgcolor="E6ECDE">비밀번호</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="password" style="width: 240" name="password">
			</td>
		  </tr>
		  <tr height="40">
			<td width="150" align="center" bgcolor="E6ECDE">비밀번호 확인</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="password" style="width: 240" name="password2">
			</td>
		  </tr>
		  <tr height="40">
			<td width="150" align="center" bgcolor="E6ECDE">닉네임</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="text" style="width: 240" name="nickname" value="${member.nickname}"
					<c:if test="${registerFailed}">value="${member.nickname}"</c:if>>
			</td>
		  </tr>
		  <tr height="40">
			<td width="150" align="center" bgcolor="E6ECDE">전화번호</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
		 		<input type="text" style="width: 240" name="phone" value="${member.phone}">
			</td>
		  </tr>		 
	    </table>
	    <br>	  
	    <table style="width: 100%">
		  <tr>
			<td align="center">
			<input type="button" value="수정" onClick="userModify()"> &nbsp;
			<input type="button" value="회원 탈퇴" onClick="delete_check()">
			</td>
		  </tr>
	    </table>
	  </td>
	</tr>
  </table>    
</form>
<div align = "center">
<form name="form2" method="post" action="<c:url value='/member/delete' />">
	<input type="hidden" name="userEmail" value="${member.email}"/>
</form>
<input type="button" value="내 정보로 돌아가기" onClick="gotoUri('<c:url value='/member/view' />')">
</div>
</body>
</html>