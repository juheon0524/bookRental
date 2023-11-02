<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/join.css">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
<%@ include file="header.jsp" %>
    <div class="shareContainer">
        <div class="shareImg" style="background: url(image/svisual_img.png);"></div>
        <div class="shareContentWrap">
            <div class="shareNav">
                <ul>
                    <li class="navTitle">회원정보</li>
                    <li><span class="keyword"><a href="passCheck.jsp">개인정보수정</a></span></li>
                    <li><span><a href="pwupdate.jsp">비밀번호변경</a></span></li>
                    <li><span><a href="delete.jsp">회원탈퇴</a></span></li>
                </ul>
            </div>
            <div class="shareContentBox">
                <div class="shareContentTitle">
                    <div class="contentTitle">개인정보수정</div>
                    <div class="contentNav">
                        <span>홈</span>
                        <i class="arrow" style="background: url(image/ico_naviArrow.png)0 50% no-repeat;"></i>
                        <span>회원정보</span>
                        <i class="arrow" style="background: url(image/ico_naviArrow.png)0 50% no-repeat;"></i>
                        <span>개인정보수정</span>
                    </div>
                </div>

                <div class="shareContent">
                    <div class="joinTitle">
                        <p>*표시가 있는 항목은 필수 입력 항목입니다.</p>
                    </div>
                    <form action="BookServlet" method="post" name="frm">
					<input type="hidden" name="command" value="update_success">
                        <table>
                            <tr>
                                <th>아이디(ID)</th>
                                <td>
                                    <input type="text" id="memberid" name="memberid" value = ${loginUser.memberid} readonly="readonly" >
                          
                                </td>
                            </tr>
                            <tr>
                                <th>이름</th>
                                <td>
                                    <input type="text" id="membername" name="membername" value = ${loginUser.membername} >
                                </td>
                            </tr>
                            <tr>
                                <th>우편번호</th>
                                <td>
                                    <input type="text" id="postalcode" name="postalcode" value = ${loginUser.postalcode}>
                                    <input class="joinBtn" type="button" value="검색" onclick="" >
                                </td>
                            </tr>
                            <tr>
                                <th>주소</th>
                                <td>
                                    <input type="text" id="postaladdress" name="postaladdress" value = ${loginUser.postaladdress} >
                                </td>
                            </tr>
                            <tr>
                                <th>상세주소</th>
                                <td>
                                    <input type="text" id="detailaddress" name="detailaddress" value = ${loginUser.detailaddress} >
                                </td>
                            </tr>
                            <tr>
                                <th>전화번호</th>
                                <td>
                                    <input type="text" id="mphone" name="mphone" value = ${loginUser.mphone} >
                                </td>
                            </tr>
                            <tr>
                                <th>생년월일</th>
                                <td>
                                    <input type="text" id="birthdate" name="birthdate" placeholder="예시:'1971-08-08'" value = ${loginUser.birthdate} >
                                </td>
                            </tr>
                            <tr>
                                <th>이메일</th>
                                <td>
                                    <input type="email" id="email" name="email" value = ${loginUser.email} >
                                </td>
                            </tr>
                        </table>
                        <input class="joinCheck" type="submit" value="수정 확인" onclick="return loginCheck3()">
                        <input class="joinCancel" type="reset" value="취소" >
                    </form>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>