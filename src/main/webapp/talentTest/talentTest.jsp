<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>재능 찾기 검사</title>
<style>
p {
	margin: 20px;
	font-size: 20px;
}

h1 {
	margin: 20px;
}

#step {
	width: 50%;
	height: 30px;
	margin: 60px 400px;
}

.title {
	margin: 50px 340px;
}

#question {
	border: 1px;
	padding: 10px;
	margin: 10px 250px;
	width: 400px;
	height: 60px;
	text-align: center;
	border-radius: 10px;
	background: rgb(52, 115, 219);
	color: white;
	margin: 30px 0px 30px 400px;
}

#answer1, #answer2 {
	border: 1px;
	padding: 10px;
	margin: 10px 300px;
	width: 300px;
	height: 60px;
	text-align: center;
	border-radius: 10px;
	background: rgb(224, 224, 224);
	margin: 10px 0px 0px 950px;
}

#answer1:hover, #answer2:hover {
	background: rgb(102, 102, 102);
	color: white;
}
</style>
<script type="text/javascript">
	var i = 0;
	var result = []
	
	function stepFunc(event) {
		var eventTest = event;
		result.push(eventTest);
		
		var questions = new Array("계획했던 과제를 다 못 끝냈을 땐?", "새로운 것을 배우는 것에 흥미를 느끼는 편인가요?", "정의 구현에 대한 생각은?");
		var answers1 = new Array("내일하지 뭐", "그럼요", "내가 해야지");
		var answers2 = new Array("더 하다 자야겠다.\n오늘 끝내고야 말겠어", "아니요..", "그런건 슈퍼맨이..");
		
		if (i == 3){
			document.result.result0.value = result[0];
			document.result.result1.value = result[1];
			document.result.result2.value = result[2];
			document.result.result3.value = result[3];
			document.result.submit();
			alert('결과 페이지로 이동합니다');
			i--;
		}
		
		document.getElementById("question").value = questions[i];
		document.getElementById("answer1").value = answers1[i];
		document.getElementById("answer2").value = answers2[i++];
		document.getElementById("step").value += 25;
	}
</script>
</head>
<body>
	<div class="title">
		<h1>재능 찾기 검사</h1>
		<p>당신에게 딱 맞는 재능을 추천해드립니다!검사 결과를 재능 구매/판매에 활용해보세요</p>
	</div>
	<div>
		<input type="button" id="question" disabled="disabled" value="활동적인 것을 좋아하시나요?">
		<input type="button" onClick="stepFunc(0)" id="answer1" value="그럼요!">
		<input type="button" onClick="stepFunc(1)" id="answer2" value="아니요..">
		
	</div>
	
	<form name="result" method="post" action="<c:url value='/talentTest/result' />">
		<input type="hidden" name="result0" value=0>
		<input type="hidden" name="result1" value=0>
		<input type="hidden" name="result2" value=0>
		<input type="hidden" name="result3" value=0>
	</form>

	<progress value="25" max="100" id="step"> </progress>
</body>
</html>