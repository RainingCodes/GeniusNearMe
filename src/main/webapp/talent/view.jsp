<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
var check = 1;
$(document).ready(function () {
	if(check == 1) {
		$("#comment").hide();
		$("#review").hide();
	}

	  $(document).on("click", "input[name='groupBtn']", function () {
		  	check = 1;
			  $("#group").show();
			  $("#comment").hide();
			  $("#review").hide();
	  });
	  $(document).on("click", "input[name='commentBtn']", function () {
		  	check = 2;
		  	$("#comment").show();
			$("#group").hide();
			$("#review").hide();
	  });
	  
	  $(document).on("click", "input[name='reviewBtn']", function () {
		  check = 3;
		  	$("#review").show();
			  $("#group").hide();
			  $("#comment").hide();
	  });
	  
	});
	
	function goWish(){
		
	}
</script>
<script>
function submitForm() {
	   form.submit();
}
</script>
<html>
    <head>
    <meta charset="UTF-8">
        <title>${talent.title }</title>
        <script>
        function userList(targetUri) {
        	form.action = targetUri;
        	form.submit();
        }
        </script>
        <style>
            table {
                width: 100%;
                text-align: center;
            }
        </style>
        
    </head>
    <%@ include file="../main/head.jsp"  %>
    <body>
    	<br>
		<img src="${dir}/${filename}" /> <br/>
        <table style="width: 65%; margin: auto;">
            <tr>
                <td colspan="3">
                	<strong>${talent.title}</strong>
                    <hr/>
                </td>
            </tr>
            <tr>
                <td rowspan="3">
                    <strong>분류:</strong>                    
                    <c:set var="category" value="${talent.talentCategoryName}" />
						<c:choose>
						  	<c:when test="${category eq 'foreignLanguage'}">
						  		외국어
						    </c:when>
						    <c:when test="${category eq 'sports'}">
						  		운동
						    </c:when>
						    <c:when test="${category eq 'game'}">
						  		게임
						    </c:when>
						    <c:when test="${category eq 'law'}">
						  		법률
						    </c:when>
						    <c:when test="${category eq 'cook'}">
						  		요리
						    </c:when>
						    <c:when test="${category eq 'mechanic'}">
						  		수리
						    </c:when>
						    <c:when test="${category eq 'art'}">
						  		예술
						    </c:when>
						    <c:when test="${category eq 'beauty'}">
						  		뷰티
						    </c:when>
						    <c:when test="${category eq 'it'}">
						  		IT
						    </c:when>
						</c:choose>
                    <br/><br>
                    <strong>모집 시작일:</strong><br>${talent.startDate }<br>
                    <br/>
                    <strong>모집 마감일:</strong><br>${talent.deadLine}<br>
                    <br/>
                    <strong>작성일:</strong><br>${talent.writtenDate}<br>
                </td>
                <td>
                    <p><strong>[가격]</strong></p>
                    <table border="1" style="width: 65%; margin: auto;">
                    <c:forEach var="price" items="${prices}">  			  	
				  	    <tr>
						  <td>
						  	<c:set var="count" value="${price.headCount}" />
						  	<c:choose>
						  		<c:when test="${count eq '1'}"> 1:1매칭 </c:when>
						  		<c:otherwise> 학생 ${count}명을 모을 시</c:otherwise>
						  	</c:choose>
						  </td>
						  <td>
						  	${price.price}원
						  </td>
						</tr>
					 </c:forEach>
					 </table>
                </td>

                <td rowspan="3">
                <br/>
               	 <strong>작성자:</strong> ${nickName}
                <br/>
                <br>
                <c:if test="${userId eq talent.writerId}"> 
				        <a href="<c:url value='/talent/update'>
				                     	   <c:param name='talentId' value='${talent.talentId}'/>
				                     	   <c:param name='userId' value='${talent.writerId }'/>
				                     	  </c:url>">재능글 수정하기</a>&nbsp;
       			</c:if>
       			<c:if test="${userId ne '-1'}"> 
                   <c:if test="${userId ne talent.writerId}"> 
                      <fmt:formatDate var="today" value="${now }" pattern="yyyy-MM-dd"/>
                      <c:choose>
                          <c:when test="today < ${talent.deadLine }"><a href="<c:url value='/matching/talent'>
                                <c:param name='talentId' value='${talent.talentId}'/>
                                 <c:param name='userId' value='${userId}'/>
                               </c:url>">1:1 매칭 신청하기</a>
                            </c:when>
                          <c:otherwise> <p>신청기한이 지났습니다.</p></c:otherwise>
                  </c:choose>
                   </c:if>
                </c:if>
                          	 
                </td>
            </tr>
            <tr>
                <td>
                    <p><strong>[상세 설명]</strong></p>
                    <p style="text-align: center;">
                     ${talent.content}
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                	 <input type="hidden" name="talentId" value=${talent.talentId }>
                     <button type="button" onclick="goWish()">🖤찜하기</button>
                    <!--  <a href="<c:url value='/talent/matching'>
                     	   <c:param name='talentId' value='${talent.talentId}'/>
                     	   <c:param name='userId' value='${userId}'/>
                     	  </c:url>">1:1 매칭</a> &nbsp; -->
                </td>
            </tr>
        </table>
                          	
        <p>
		
        <hr/>
        <span><input type="button" name="groupBtn" value="공동 구매하기"></span>
		<span><input type='button' name='commentBtn' value='문의'></span>
		<span><input type='button' name='reviewBtn' value='리뷰'></span>
		<%@ include file="/talent/groupMatching.jsp"  %>
		<%@ include file="/talent/commentView.jsp"  %>
        <div align = "center">
        <br><br><br><br><br><br><br>
        	
    	    <input type="button" value="이전 페이지" onClick="history.go(-1)">

        </div>
        
        <div>
			<form name="form" method="get" action="<c:url value='/talent/comment' />">
				<input type="hidden" name="talentId" value="${talent.talentId}"/>
				<input type="button" value="덧글 작성" onClick="submit()">
			</form>
		</div>
    </body>
</html>