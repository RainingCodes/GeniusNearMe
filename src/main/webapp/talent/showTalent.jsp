<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
        <title>게시글 화면</title>
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
                    유리공예 클래스
                    <hr/>
                </td>
            </tr>
            <tr>
                <td rowspan="3">
                    <img src="image.jpg" alt="이미지">
                    <br/>
                    모집 시작일: 2021-08-31   
                    <br/>
                    모집 마감일: 2021-12-31
                </td>
                <td>
                    <p>가격</p>
                    <ul>
                        <li>
                            1:1                                         10만 원
                        </li>
                        <li>
                            1:2                                         8만 원
                        </li>
                        <li>
                            1:3                                         6만 원
                        </li>
                        <li>
                            1:4                                         4만 원
                        </li>
                    </ul>
                </td>

                <td rowspan="3">
                    <button type="button" onclick="쪽지">쪽지보내기</button>
                </td>
            </tr>
            <tr>
                <td>
                    <p>상세설명</p>
                    <p style="text-align: center;">
                        유리공예 수업 모집해요.
                        <br/>
                        매주 토요일 저녁 8시 30분 시작 (4회)
                        <br/>
                        약 1시간 소요
                        <br/>
                        정원 최대 4명
                        <br/>
                        수강생 준비물: 필기구
                        <br/>
                        *수강료는 재료비 포함*
                        <br/>
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                     <button type="button" onclick="찜하기">🖤찜하기</button>
                     <button type="button" onclick="매칭">1:1 매칭신청</button>
                </td>
            </tr>
        </table>

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