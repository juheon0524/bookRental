<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/join.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
 <%@ include file="/header.jsp" %>
    <div class="shareContainer">
        <div class="shareImg" style="background: url(image/svisual_img.png);"></div>
        <div class="shareContentWrap">
            <div class="shareNav">
                <ul>
                    <li class="navTitle">회원정보</li>
                    <li><span><a href="login.jsp">로그인</a></span></li>
                    <li><span class="keyword"><a href="joinselect.jsp">회원가입</a></span></li>
                </ul>
            </div>
            <div class="shareContentBox">
                <div class="shareContentTitle">
                    <div class="contentTitle">회원가입</div>
                    <div class="contentNav">
                        <span>홈</span>
                        <i class="arrow" style="background: url(image/ico_naviArrow.png)0 50% no-repeat;"></i>
                        <span>회원정보</span>
                        <i class="arrow" style="background: url(image/ico_naviArrow.png)0 50% no-repeat;"></i>
                        <span>회원가입</span>
                    </div>
                </div>

                <div class="shareContent">
                    <div class="joinTitle">
                        <h5>회원 정보 입력</h5>
                        <p>*표시가 있는 항목은 필수 입력 항목입니다.</p>
                    </div>
                   <form action="BookServlet" method="post" name="frm">
					<input type="hidden" name="command" value="join_success">
                        <table>
                            <tr>
                                <th>아이디(ID)</th>
                                <td>
                                    <input type="text" id="memberid" name="memberid" >
                                    <input class="joinBtn" type="button"  value="중복확인" onclick="idCheck()">
                                </td>
                            </tr>
                            <tr>
                                <th>이름</th>
                                <td>
                                    <input type="text" id="membername" name="membername">
                                </td>
                            </tr>
                            <tr>
                                <th>우편번호</th>
                                <td>
                                    <input type="text" id="postalcode" name="postalcode">
                                    <input class="joinBtn" type="button" value="검색" onclick="">
                                </td>
                            </tr>
                            <tr>
                                <th>주소</th>
                                <td>
                                    <input type="text" id="postaladdress" name="postaladdress">
                                </td>
                            </tr>
                            <tr>
                                <th>상세주소</th>
                                <td>
                                    <input type="text" id="detailaddress" name="detailaddress">
                                </td>
                            </tr>
                            <tr>
                                <th>전화번호</th>
                                <td>
                                    <input type="text" id="mphone" name="mphone">
                                </td>
                            </tr>
                            <tr>
                                <th>생년월일</th>
                                <td>
                                    <input type="text" id="birthdate" name="birthdate" placeholder="예시:'1971-08-08'">
                                </td>
                            </tr>
                            <tr>
                                <th>비밀번호</th>
                                <td>
                                    <input type="text" id="passcode" name="passcode">
                                </td>
                            </tr>
                            <tr>
                                <th>이메일</th>
                                <td>
                                    <input type="email" id="email" name="email">
                                </td>
                            </tr>
                        </table>
                        <input class="joinCheck" type="submit" value="회원가입 확인" onclick="return loginCheck2()">
                        <input class="joinCancel" type="reset" value="취소" >
                    </form>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="/footer.jsp" %>
</body>
</html>