<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
        <title>게시글 추가</title>
        <script>
        function talentCreate(){
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
        </script>
        <style>
            table{
                width: 100%;
            }
        
        </style>
    </head>
    <body>
    <!-- talent registration from -->
       <from name = "from" method="POST" action="<c:url value='/talent/register' />">
           <h5>제목</h5>
           <input type="text" name="title">
           <hr/>
           <table>
               <tr>
                   <td>
                        <h5>카테고리 선택</h5>
                        <select name="category" size="4" multiple>
                            <option value="1" selected>뷰티</option>
                            <option value="2">운동</option>
                            <option value="3">IT</option>
                            <option value="4">기타</option>
                        </select>
                   </td>
                   <td>
                       <h5>가격 </h5>
                       <p>학생 수
                       <input type="number" name="student"> &nbsp; 가격
                      <input type="number" name="cost" ></p>
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
            <input type="button" value="등록" onClick="talentCreate()">

       </form>
    </body>
</html>