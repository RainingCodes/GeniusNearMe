<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
var check = 1;
$(document).ready(function () {
	if(check == 1) {
		$("#receive").hide();
	}
	
	$(document).on("click", "input[name='applyBtn']", function () {
		check = 1;
		$("#apply").show();
		$("#receive").hide();
	});
	$(document).on("click", "input[name='receiveBtn']", function () {
		check = 2;
		$("#apply").hide();
		$("#receive").show();
	});	  
});
</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>1:1 매칭 관리</title>
<style>
.ellipsis { overflow:hidden; text-overflow:ellipsis; -o-text-overflow:ellipsis; white-space:nowrap; max-width:95%; } 
</style>
</head>
<body>
<%@ include file="../../main/head.jsp"  %>
<div align="center"> 
<p><br>
	<span><input type='button' name='applyBtn' value='신청한 매칭 리스트'></span>
	<span><input type='button' name='receiveBtn' value='받은 매칭 리스트'></span>
	<jsp:include page="applyMatchingList.jsp"/>
	<jsp:include page="receiveMatchingList.jsp"/>
	
	<br>
	<p>
	<div style="text-align:center;">
	<a href="<c:url value='/member/view' />">목록으로 이동하기</a>    		     
	</div>   
</div>

</body>
</html>