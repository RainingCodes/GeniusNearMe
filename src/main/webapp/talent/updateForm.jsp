<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<html>
    <head>
    <meta charset="UTF-8">
        <title>게시글 추가</title>
       <script>
      
        function talentUpdate(){
        	if(from.title.value ==""){
        		alert("제목를 입력하십시오.");
        		form.title.focus();
        		return false;
        	} 
        	if(from.student.value ==""){
        		alert("학생 수를 입력하십시오.");
        		form.student.focus();
        		return false;
        	} 
        	if(from.cost.value ==""){
        		alert("가격을 입력하십시오.");
        		form.cost.focus();
        		return false;
        	} 
        	if(from.startDate.value ==""){
        		alert("모집 시작일을 입력하십시오.");
        		form.startDate.focus();
        		return false;
        	} 
        	if(from.deadline.value ==""){
        		alert("모집마감일을 입력하십시오.");
        		form.deadline.focus();
        		return false;
        	} 
        	if(from.content.value ==""){
        		alert("설명을 입력하십시오.");
        		form.content.focus();
        		return false;
        	} 
        	form.submit();
        }
        
        function talentList(targetUri) {
        	form.action = targetUri;
        	form.submit();
        }
        </script>
        <style>
            table{
                width: 100%;
            }
        
        </style>
    </head>
    <body>
    <!-- talent update from -->
     <input type="hidden" name="talentId" value="${talent.talentId}"/>	  
       <form name = "form" method="POST" action="<c:url value='/talent/update' />">
           <h5>제목</h5>
           <p>${talent.title}</p>
           <hr/>
           <table>
               <tr>
                   <td>
                        <h5>카테고리</h5>
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
                    <br/>
                   </td>
                   <td>
                       <h5>가격 </h5>
                       	<table border="1">
                   		 <c:forEach var="price" items="${list}">  			  	
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
               </tr>
               <tr>
                   <td>
                    <h5>모집 시작일</h5>
                    <input type="date" name="startDate" value="${talent.startDate }">
                    <h5>모집 마감일</h5>
                    <input type="date" name="deadline" value="${talent.deadLine }" >
                    <h5>작성일</h5>
                    ${talent.writtenDate}
                   </td>
                   <td>
                        <h5>세부 설명 및 주의사항</h5>
                        <textarea rows="10" cols="50" name="content" value="${talent.content }"></textarea>
                   </td>
               </tr>
           </table>
            <input type="button" value="수정하기" onClick="talentUpdate()"> &nbsp;
			<input type="button" value="목록" onClick="talentList('<c:url value='/talent/list' />')">
       </form>
    </body>
</html>