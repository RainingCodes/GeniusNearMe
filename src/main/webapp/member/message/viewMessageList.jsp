<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
var check = 1;
$(document).ready(function () {
	if(check == 1) {
		$("#sender").hide();
	}

	  $(document).on("click", "input[name='receiveBtn']", function () {
		  	check = 1;
			$("#receive").show();
			$("#sender").hide();
	  });
	  $(document).on("click", "input[name='sendBtn']", function () {
		  	check = 2;
		  	$("#receive").hide();
			$("#sender").show();
	  });	  
	});
</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>나의 메세지 보관함</title>
</head>
<body>
<%@ include file="../../main/head.jsp"  %>
<div>   
	<span><input type='button' name='receiveBtn' value='받은 메세지함'></span>
	<span><input type='button' name='sendBtn' value='보낸 메세지함'></span>
	<jsp:include page="receiveMessageList.jsp"/>
	<jsp:include page="sendMessageList.jsp"/>
	
	<br>
	<p>
	<div style="text-align:center;">
	<a href="<c:url value='/member/view' />">목록으로 이동하기</a>    		     
	</div>   
</div>

</body>
</html>