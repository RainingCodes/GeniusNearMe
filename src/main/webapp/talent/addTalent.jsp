<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
        <title>게시글 추가</title>
        <style>
            table{
                width: 100%;
            }
        
        </style>
    </head>
    <body>
       <form>
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
                       <h5>수강생에 대한 가격 설정</h5>
                      <input type="number" name="student"> &nbsp; 
                      <input type="number" name="cost" >
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
                        <textarea rows="10" cols="50"></textarea>
                   </td>
               </tr>
           </table>
            <input type="submit" value="등록">

       </form>
    </body>
</html>