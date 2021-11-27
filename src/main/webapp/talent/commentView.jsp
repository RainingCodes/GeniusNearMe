<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>comment View By talentId</title>
<script>
	function submitForm() {
		form.submit();
	}
</script>
</head>
<body>
	<div class="comment" align="center">
		<table border = "1">
		<thead class="thead-inverse">
	      	<tr>
			  <td width = "200px" align="center">닉네임</td>
			  <td width = "500px" align="center">코멘트</td>
			</tr>
	      </thead>
	      <tbody> 
			<c:forEach var="li" items="${commentList}" varStatus="status">  			  	
		  	    <tr>
				  <td>
				  	${nickList[status.index]}
				  </td>
				  <td>
				  	${commentList.content}
				  	<c:if test="${commentWriterId ne '-1'}"> 
					        <a href="<c:url value='/talent/comment/delete'>
					        			<c:param name='commentId' value='${commentList.commentId}'/>
					       				</c:url>">&nbsp;&nbsp;&nbsp;삭제</a>&nbsp;
	       			</c:if>
				  </td>
				</tr>
			 </c:forEach>
			</tbody>
		</table>
	</div>

	<p>
	<hr>
	<div class="commentRegister" align="center">
		<c:if test="${commentWriterId eq '-1'}"> 
			덧글 등록은 회원만 하실 수 있습니다.
	    </c:if>
	    
	    <c:if test="${commentWriterId ne '-1'}">
			덧글 등록
			<form name="form" method="post" action="<c:url value='/talent/comment' />">
				<input type="hidden" name="email" value="${commentWriterId}"/>	  
				<input type="hidden" name="email" value="${talnetId}"/>
				<input name="content" size="50">
				<input type="button" value="덧글 작성" onClick="submitForm()">
			</form>
		</c:if>
	</div>
	
	
</body>
</html>