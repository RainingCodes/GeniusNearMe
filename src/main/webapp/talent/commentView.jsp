<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>덧글</title>
<script>
	function submitForm() {
		form.submit();
	}
</script>
</head>
<body>
<div id='comment'>
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
				  	<c:if test="${li.writerId eq commentWriterId}"> 
				  		<span style="color:red">${nickList[status.index]}</span>
				  	</c:if>
				  	<c:if test="${li.writerId ne commentWriterId}"> 
				  		<span>${nickList[status.index]}</span>
				  	</c:if>
				  </td>
				  <td>
				  	<span>${li.content}</span>
				  	<span style="display: inline-block; width: 100%; text-align: right;">
				  	<c:if test="${commentWriterId eq li.writerId}">
					        <a href="<c:url value='/talent/comment/delete'>
					        			<c:param name='talentId' value='${li.talentId}'/>
					        			<c:param name='commentId' value='${li.commentId}'/>
					       				</c:url>">삭제</a>&nbsp;
	       			</c:if>
	       			</span>
				  </td>
				</tr>
			 </c:forEach>
			</tbody>
		</table>
	</div>
	<p>
	<hr>
	<div class="commentRegister" align="center">
	<br>
	덧글 등록
	<br>
		<c:if test="${commentWriterId eq '-1'}"> 
			덧글 등록은 회원만 하실 수 있습니다.
	    </c:if>
	    
	    <c:if test="${commentWriterId ne '-1'}">
			
			<form name="form" method="post" action="<c:url value='/talent/comment/register' />">
				<input type="hidden" name="commentWriterId" value="${commentWriterId}"/>	  
				<input type="hidden" name="talentId" value="${talentId}"/>
				<span style="color:red">${userNicekname}</span>
				<textarea cols="30" rows="3" name="content" style="resize: none;"></textarea>
				<input type="button" value="덧글 작성" onClick="submit()">
			</form>
		</c:if>
	</div>
</div>
</body>
</html>