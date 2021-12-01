<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%! int i = 1; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 작성한 재능 게시글</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="../css/talent.css" type="text/css">
</head>
<style>
.content {
	text-align:center;
	float: none;
	width: 900px;
	margin: 0px auto;
}
</style>
<body>
<%@ include file="../main/head.jsp"  %>
	<div class="content">
	<p>
	<h3>내가 작성한 게시글</h3>
	<p>
	<table border="1">
		<c:forEach var="talent" items="${talentList}" varStatus="status">
			<tr>
				<td>
					<a href="<c:url value='/talent/view'>
						<c:param name='talentId' value='${talent.talentId}'/></c:url>">
						<strong><c:out value="${talent.title}"/></strong>
					</a>					
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${talent.writtenDate}"/>
				<p></p>
				<p></p>
				<p><c:out value="${talent.content}"/></p>
				</td>
				<td>
					<c:if test="${matchingInfo[status.index] eq 0}"> 
						<a href="<c:url value='/talent/delete'>
							<c:param name='talentId' value='${talent.talentId}'/></c:url>">	
				  			게시글 삭제하기</a>
				  	</c:if>
				  	<c:if test="${matchingInfo[status.index] ne 0}"> 
				  		삭제 불가
				  	</c:if>
				</td>
		</c:forEach>
	
	</table>
	<p><br>
	매칭이 존재하면 게시글을 삭제할 수 없습니다.
	<a href="<c:url value='/member/view' />">목록으로 이동하기</a>   
	</div>
	
</body>
</html>