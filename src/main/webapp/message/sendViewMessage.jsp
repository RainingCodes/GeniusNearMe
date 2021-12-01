<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보낸 쪽지 확인</title>
<script type="text/javascript">
	function delete_check(){
		var answer;
		answer = confirm("메세지 전송을 정말 취소하겠습니까? 되돌릴 수 없습니다.");
		if(answer == true){
			 document.form.submit();
		} else {
			return;
		}
	}
</script>
</head>
<body>
	<div class="sendView" align="center">
	<br>
	<h1>보낸 쪽지 확인</h1>
	<p>
	받는 이 : ${nickname}
	<br>전송 날짜 : ${message.writtenDate}
	<p>
	<br>
	<textarea cols="30" rows="15" name="content"style="resize: none; readonly">${message.content}</textarea>
	
	<c:if test="${message.state eq 0}">       
		<form name="form" method="post" action="<c:url value='/message/delete' />">
			<input type="hidden" name="messageId" value="${message.messageId}"/>
			<input type="button" value="전송 취소" onClick="delete_check()">
		</form>
	</c:if>
	<form name="go" method="post" action="<c:url value='/member/messageList' />">
		<input type="button" value="뒤로 돌아가기" onClick="submit()">
	</form>
	</div>
</body>
</html>