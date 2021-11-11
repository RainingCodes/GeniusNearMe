<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="service.*" %>
<%@ page import="service.dto.MemberDTO" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Talent Service Test</title>
</head>
<body>
<%
	MemberService memberSvc = new MemberServiceImpl();
	List<MemberDTO> list = memberSvc.ListingMembers();
	request.setAttribute("memberList", list);
%>
<h2>유저 목록</h2>
<c:forEach var="member" items="${memberList}">  
 	${member.userId} &nbsp;&nbsp;&nbsp;&nbsp; ${member.nickname} &nbsp;
 	<a href="<c:url value='getStudent.jsp'>
	   	<c:param name='stuName' value='${student.stuName}'/>
		</c:url>">조회</a> &nbsp;
	<a href="<c:url value='deleteStudent.jsp'>
	   	<c:param name='stuNo' value='${student.stuNo}'/>
		</c:url>">삭제</a><br>		  	
</c:forEach>
<br>
<h2>등록</h2>
<form method="post" action="setStudent.jsp">
학번:	<input type="text" name="stuNo" value="20150003" /><br>
이름:	<input type="text" name="stuName" value="Jain" /><br>
비밀번호:	<input type="text" name="pwd" value="1111" /><br>
연락처:	<input type="text" name="stuPhoneNo" value="010-3456-7890" /><br>
학년:	<input type="text" name="year" value="3" /><br>
학과:	<input type="text" name="dept" value="Computer" /><br>
지도교수:	<input type="text" name="profName" value="Andy" /><br>
<input type="submit" value="등록" />
</form>
<br>
<h2>변경</h2>
<form method="post" action="updateStudent.jsp">
학번:	<input type="text" name="stuNo" value="20150003" /><br>
연락처:	<input type="text" name="stuPhoneNo" value="010-1111-2222" /><br>
학년:	<input type="text" name="year" value="4" /><br>
<input type="submit" value="변경" />
</form>
</body>
</html>