<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재능 리스트</title>
<script language="JavaScript">
function keywordSearch() {
	keywordSearch.action = "keywordSearch/list.jsp";
	keywordSearch.submit();
	}
function categorySearch() {
	categorySearch.action = "categorySearch/list.jsp";
	categorySearch.submit();
}
</script>
<link rel=stylesheet href="<c:url value='/css/mainTalentList.css' />" type="text/css">
</head>
<body>
	<table class="talentList">
		<form name="keywordSearch" method="post">
			<tr class="search">
				<td colspan="5">
					<select name="search_options">
						<option value="0">제목과 내용</option>
						<option value="1">작성자</option>
						<option value="2">재능 주제</option>
					</select>
					<span><input name="search_bar" size="50"></span>
					<span><button type="button" class="btn_search" onClick="keywordSearch()"><img alt="돋보기" src="img/search.png"></button></span>
				</td>
			</tr>
		</form>	
		<form name="categorySearch" method="post">
			<tr>
				<td>
					<button type="button" class="btn_all">
						<img alt="모든 재능" src="img/talent.png">
						<div>모든 재능</div>
					</button>
				</td>
				<td>
					<button type="button" class="btn_IT">
						<img alt="IT" src="img/talent.png">
						<div>IT</div>
					</button>
				</td>
				<td>
					<button type="button" class="btn_cooking">
						<img alt="요리" src="img/cooking.png">
						<div>요리</div>
					</button>
				</td>
				<td>
					<button type="button" class="btn_exercise">
						<img alt="운동" src="img/exercise.png">
						<div>운동</div>
					</button>
				</td>
				<td>
					<button type="button" class="btn_languages">
						<img alt="외국어" src="img/languages.png">
						<div>외국어</div>
					</button>
				</td>
			</tr>
			<tr>
				<td>
					<button type="button" class="btn_law">
						<img alt="법" src="img/law.png">
						<div>법률</div>
					</button>
				</td>
				<td>
					<button type="button" class="btn_mechanic">
						<img alt="수리" src="img/mechanic.png">
						<div>수리</div>
					</button>
				</td>
				<td>
					<button type="button" class="btn_art">
						<img alt="예술" src="img/art.png">
						<div>예술</div>
					</button>
				</td>
				<td>
					<button type="button" class="btn_game">
						<img alt="게임" src="img/game.png">
						<div>게임</div>
					</button>
				</td>
				<td>
					<button type="button" class="btn_beauty">
						<img alt="뷰티" src="img/beauty.png">
						<div>뷰티</div>
					</button>
				</td>
			</tr>
		</form>	
	</table>
</body>
</html>