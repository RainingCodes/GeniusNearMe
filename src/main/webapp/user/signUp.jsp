<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이웃집 솜솜이 회원 가입</title>
</head>
<body>
<div align="center"><h2>이웃집 솜솜이 회원 가입</h2><hr>
<form name="signUp" method="post" action="createUser.jsp">
	<table border = "1" cellspacing="1" cellpadding="5">
		<tr>
			<td>아이디</td>
			<td><input type="text" size="20" name="id"></td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td><input type="password" size="20" name="pwd"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" size="20" name="tel"></td>
		</tr>
		<tr>
			<td>닉네임</td>
			<td><input type="text" size="20" name="nickname"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="확인">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>