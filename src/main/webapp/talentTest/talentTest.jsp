<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재능찾기검사</title>
<style>
p {
	margin: 20px;
	font-size: 20px;
}

h1 {
	margin: 20px;
}

.title{
	margin: 50px 340px;
}

.question {
	border: 1px;
	padding: 10px;
	margin: 10px 250px;
	width: 400px;
	text-align: center;
	border-radius: 10px;
	background: rgb(52, 115, 219);
	color: white;
	margin: 30px 0px 30px 400px;
}

.answer1 {
	border: 1px;
	padding: 10px;
	margin: 10px 300px;
	width: 200px;
	text-align: center;
	border-radius: 10px;
	background: rgb(224, 224, 224);
	margin: 10px 0px 0px 900px;
}

.answer1:hover {
	background: rgb(102, 102, 102);
	color: white;
}

.step-box {
	width: 1000px;
	padding : 0 10px 10px 10px;
	border: 1px solid #ddd;
	margin: 30px 280px;
	background: #fff;
	padding: 0 10px 10px 10px;
}

.step-state {
	padding: 10px 0 15px;
	margin-top: 10px;
	background: #f7f7f7
}

.step-state ul:after {
	content: '';
	display: block;
	clear: both
}

.step-state ul li {
	float: left;
	position: relative;
	width: 20%;
	/* 5개 진행바를 5등분 */
	padding-top: 50px;
	/* 진행바 영역 확보 */
	font-size: 15px;
	font-weight: bold;
	text-align: center;
	line-height: 12px;
	color: #666
}

.step-state ul li:first-child {
	font-size: 13px
}
/* 도전중, 달성 텍스트 영역 */
.step-state ul li p:after {
	position: absolute;
	/* absolute 기준은 li 영역 */
	width: 41px;
	height: 24px;
	margin-right: -20px;
	background-size: auto 24px;
	background-position: -58px 0;
	top: 0;
	right: 0;
	color: #fff;
	font-size: 11px;
	line-height: 16px;
	letter-spacing: -.5px;
}

.step-state ul li:first-child p {
	padding-top: 6px
}

.step-state ul li span {
	display: block;
	margin-top: 2px;
	font-weight: normal;
	color: rgb(52, 115, 219);
	font-size: 12px
}
/* 회색 진행바 생성 */
.step-state ul li:before {
	position: absolute;
	top: 35px;
	left: 0;
	right: 0;
	height: 3px;
	background: #ddd;
	content: ''
}
/* 첫 번째 진행바 반만 생성*/
.step-state ul li:nth-child(1):before {
	left: 50%
}
/* 마지막 진행바 반만 생성*/
.step-state ul li:nth-child(4):before {
	right: 50%
}
/* 화살표 상태 아이콘 */
.step-state ul li:after {
	position: absolute;
	top: 27px;
	left: 50%;
	width: 20px;
	height: 20px;
	margin-left: -10px;
	background: url(https://t1.daumcdn.net/cfile/tistory/241D463E58AFAEAB16)
		no-repeat 0 0;
	background-size: auto 24px;
	background-position: 0 0;
	content: ''
}
/* 활성화 진행바 및 활성화 화살표 아이콘 표시 */ /* 활성화 상태바 */
.step-state.step1 ul li:nth-child(1):before, .step-state.step2 ul li:nth-child(-n+2):before,
	.step-state.step2-ing ul li:nth-child(-n+2):before, .step-state.step3 ul li:nth-child(-n+3):before,
	.step-state.step3-ing ul li:nth-child(-n+3):before, .step-state.step4 ul li:nth-child(-n+4):before,
	.step-state.step4-ing ul li:nth-child(-n+4):before, .step-state.step5 ul li:nth-child(-n+5):before
	{
	background: rgb(52, 115, 219)
}
/* 활성화 아이콘 표시 */
.step-state.step1 ul li:nth-child(0):after, .step-state.step2 ul li:nth-child(-n+2):after,
	.step-state.step2-ing ul li:nth-child(-n+2):after, .step-state.step3 ul li:nth-child(-n+3):after,
	.step-state.step3-ing ul li:nth-child(-n+3):after, .step-state.step4 ul li:nth-child(-n+4):after,
	.step-state.step4-ing ul li:nth-child(-n+4):after, .step-state.step5 ul li:nth-child(-n+5):after
	{
	background-position: -20px 0
}
/* 도전 중일 경우의 1/2 영역 비활성화 상태바 영역 */
.step-state ul li p:before {
	position: absolute;
	top: 35px;
	left: 50%;
	right: 0;
	height: 3px;
	content: '';
}

.step-state.step2 ul li:nth-child(2) p:before, .step-state.step3 ul li:nth-child(3) p:before,
	.step-state.step4 ul li:nth-child(4) p:before {
	background: #ddd
}
/* "도전중" 텍스트 표시 */
.step-state.step1 ul li:nth-child(1) p:after, .step-state.step2-ing ul li:nth-child(2) p:after,
	.step-state.step3-ing ul li:nth-child(3) p:after, .step-state.step4-ing ul li:nth-child(4) p:after
	{
	content: '진행중';
}
/* "달성" 텍스트 표시 */
.step-state.step2 ul li:nth-child(2) p:after, .step-state.step3 ul li:nth-child(3) p:after,
	.step-state.step4 ul li:nth-child(4) p:after, .step-state.step5 ul li:nth-child(5) p:after
	{
	content: '달성';
	right: 50%
}
</style>
</head>
<body>
	<div class="title">
		<h1>재능 찾기 검사</h1>
		<p>당신에게 딱 맞는 재능을 추천해드립니다!검사 결과를 재능 구매/판매에 활용해보세요</p>
	</div>
	<div class="question1">
		<h2 class="question">활동적인 것을 좋아하시나요?</h2>
		<h3 class="answer1">그럼요!</h3>
		<h3 class="answer1">아니요..</h3>
	</div>
	<div class="step-box">
		<div class="step-state step1">
			<ul>
				<li><p>1</p></li>
				<li><p>2</p></li>
				<li><p>3</p></li>
				<li><p>4</p></li>
			</ul>
		</div>
	</div>
</body>
</html>