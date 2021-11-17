<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<html>
    <head>
    <meta charset="UTF-8">
        <title>게시글 추가</title>
       <script language="JavaScript">
       var cnt = 0; 
		$(document).ready(function () {
			  $(document).on("click", "input[name='add']", function () {
				  if(cnt >= 10)
					  alert("최대 입력 값을 초과했습니다.");
				  else {
					  cnt++;
					  $("#add_btn").before("<p>학생 <input type='number' name='num" + cnt + "'> 명당 가격 <input type='number' name='price" + cnt +"' > 원</p>");
					  $("#student").val(cnt);
					  }
				  
			  });
			});
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
           <p>${talent.title }</p>
           <hr/>
           <table>
               <tr>
                   <td>
                        <h5>카테고리</h5>
                        <p>${talent.talentCName }
                   </td>
                   <td>
                       <h5>가격 </h5>
                       <p>학생 수 1:1 &nbsp; 가격
                      <input type="number" name="price" >원</p> 
                      <input type="button" name="add" value="추가하기" id="add_btn">
                   </td>
               </tr>
               <tr>
                   <td>
                    <h5>모집 시작일</h5>
                    <input type="date" name="startDate" >
                    <h5>모집 마감일</h5>
                    <input type="date" name="deadline" >
                   </td>
                   <td>
                        <h5>세부 설명 및 주의사항</h5>
                        <textarea rows="10" cols="50" name="content"></textarea>
                   </td>
               </tr>
           </table>
           <input type="hidden" id="student" name="student">
            <input type="button" value="등록" onClick="talentUpdate()"> &nbsp;
			<input type="button" value="목록" onClick="talentList('<c:url value='/talent/list' />')">
       </form>
    </body>
</html>