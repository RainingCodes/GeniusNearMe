<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<script>
function goToURI(targetUri) {
	form.action = targetUri;
	form.method="GET";		// register form 요청
	form.submit();
	//goToURI('<c:url value='/talent/list'/>')
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
        <table>
            <tr>
                <td colspan="3">
                	${talent.title}
                    <hr/>
                </td>
            </tr>
            <tr>
                <td rowspan="3">
                    분류:                    
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
                    모집 시작일: ${talent.startDate }
                    <br/>
                    모집 마감일: ${talent.deadLine}
                    <br/>
                    작성일: ${talent.writtenDate}
                </td>
                <td>
                    <p>[가격]</p>
                    <table border="1">
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
               	 작성자: ${nickName}
                <br/>
                <br>
                <a href="<c:url value='/matching/talent'>
                     	   <c:param name='talentId' value='${talent.talentId}'/>
                     	   <c:param name='writerId' value='${talent.writerId}'/>
                     	   <c:param name='userId' value='${userId}'/>
                </c:url>">1:1 매칭 신청하기</a>                     	  
                    <!-- <button type="button" onclick="쪽지">쪽지보내기</button> -->
                </td>
            </tr>
            <tr>
                <td>
                    <p>[상세 설명]</p>
                    <p style="text-align: center;">
                     ${talent.content}
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                     <!--  <button type="button" onclick="찜하기">🖤찜하기</button>
                     <a href="<c:url value='/talent/matching'>
                     	   <c:param name='talentId' value='${talent.talentId}'/>
                     	   <c:param name='userId' value='${userId}'/>
                     	  </c:url>">1:1 매칭</a> &nbsp; -->
                </td>
            </tr>
        </table>
        <c:if test="${userId eq talent.writerId}"> 
	        <a href="<c:url value='/talent/update'>
	                     	   <c:param name='talentId' value='${talent.talentId}'/>
	                     	   <c:param name='userId' value='${talent.writerId }'/>
	                     	  </c:url>">수정하기</a>&nbsp;
        </c:if>
                     	
        <p>
		
        <hr/>
        <table>
            <tr>
                <th>공동구매하기</th>
                <th>문의</th>
                <th>리뷰</th>
            </tr>
        </table>
        <div align = "center">
        <br><br><br><br><br><br><br>
    	    <input type="button" value="이전 페이지" onClick="history.go(-1)">

        </div>
    </body>
</html>