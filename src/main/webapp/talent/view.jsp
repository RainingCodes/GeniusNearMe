<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="service.dto.TalentDTO" %>
<%
	TalentDTO talent = (TalentDTO)request.getAttribute("talent");
%>
<!DOCTYPE html>
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
                    <img src="image.jpg" alt="이미지">
                    <br/>
                    분류: ${talent.talentCategoryName }
                    <br/>
                    모집 시작일: ${talent.startDate }
                    <br/>
                    모집 마감일: ${talent.deadLine }
                    <br/>
                    작성일: ${talent.writtenDate }
                </td>
                <td>
                    <p>가격</p>
                    <ul>
                        <li>
                            1:1  ${talent.price }
                        </li>
             
                    </ul>
                </td>

                <td rowspan="3">
                <br/>
               	 작성자: ${talent.writerId }
                <br/>
                    <button type="button" onclick="쪽지">쪽지보내기</button>
                </td>
            </tr>
            <tr>
                <td>
                    <p>상세설명</p>
                    <p style="text-align: center;">
                     ${ talent.content}
                       
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                     <button type="button" onclick="찜하기">🖤찜하기</button>
                     <a href="<c:url value='/talent/matching'>
                     	   <c:param name='talentId' value='${talent.talentId}'/>
                     	  </c:url>">1:1 매칭</a> &nbsp;
                </td>
            </tr>
        </table>
        <a href="<c:url value='/talent/update'>
                     	   <c:param name='talentId' value='${talent.talentId}'/>
                     	   <c:param name='userId' value='${talent.writerId }'/>
                     	  </c:url>">수정</a>&nbsp;
		<input type="button" value="목록" onClick="talentList('<c:url value='/talent/list' />')">
        <hr/>
        <table>
            <tr>
                <th>공동구매하기</th>
                <th>문의</th>
                <th>리뷰</th>
            </tr>
        </table>
    </body>
</html>