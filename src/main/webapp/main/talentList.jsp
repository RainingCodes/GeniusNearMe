<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재능 리스트</title>
<script language="JavaScript">
function submitForm() {
	   form.submit();
	}
</script>
<link rel=stylesheet href="<c:url value='/css/mainTalentList.css' />"
	type="text/css">
</head>
<body>
	<div class="search">
		<form name="form" method="get"
			action="<c:url value='/talent/keywordSearch' />">
			<select name="search_options">
				<option value="0">제목과 내용</option>
				<option value="1">작성자</option>
				<option value="2">재능 주제</option>
			</select> <input name="search_bar" size="50"></span> <input type="button" value="검색" onClick="submitForm()">
		</form>
	</div>
	<table class="talentList">
		<tr>
			<td>
				<a class="btn_all" href="<c:url value='/talent/categorySearch'>
											<c:param name='category' value='all' />
										</c:url>">
					<img alt="모든 재능" src="img/talent.png">
					<div>모든 재능</div>
				</a>

			</td>
			<td>
				<a class="btn_IT" href="<c:url value='/talent/categorySearch'>
											<c:param name='category' value='it' />
										</c:url>">
					<img alt="IT" src="img/it.png">
					<div>IT</div>
				</a>
			</td>
			<td>
				<a class="btn_cooking" href="<c:url value='/talent/categorySearch'>
											<c:param name='category' value='cook' />
										</c:url>">
					<img alt="요리" src="img/cooking.png">
					<div>요리</div>
				</a>
			</td>
			<td>
				<a class="btn_excercise" href="<c:url value='/talent/categorySearch'>
											<c:param name='category' value='excercise' />
										</c:url>">
					<img alt="운동" src="img/exercise.png">
					<div>운동</div>
				</a>
			</td>
			<td>
				<a class="btn_languages" href="<c:url value='/talent/categorySearch'>
											<c:param name='category' value='foreignLanguage' />
										</c:url>">
					<img alt="외국어" src="img/languages.png">
					<div>외국어</div>
				</a>
			</td>
		</tr>
		<tr>
			<td>
				<a class="btn_law" href="<c:url value='/talent/categorySearch'>
											<c:param name='category' value='law' />
										</c:url>">
					<img alt="법률" src="img/law.png">
					<div>법률</div>
				</a>
			</td>
			<td>
				<a class="btn_mechanic" href="<c:url value='/talent/categorySearch'>
											<c:param name='category' value='mechanic' />
										</c:url>">
					<img alt="수리" src="img/mechanic.png">
					<div>수리</div>
				</a>
			</td>
			<td>
				<a class="btn_art" href="<c:url value='/talent/categorySearch'>
											<c:param name='category' value='art' />
										</c:url>">
					<img alt="예술" src="img/art.png">
					<div>예술</div>
				</a>
			</td>
			<td>
				<a class="btn_game" href="<c:url value='/talent/categorySearch'>
											<c:param name='category' value='game' />
										</c:url>">
					<img alt="게임" src="img/game.png">
					<div>게임</div>
				</a>
			</td>
			<td>
				<a class="btn_beauty" href="<c:url value='/talent/categorySearch'>
											<c:param name='category' value='beauty' />
										</c:url>">
					<img alt="뷰티" src="img/beauty.png">
					<div>뷰티</div>
				</a>
			</td>
		</tr>
	</table>
</body>
</html>