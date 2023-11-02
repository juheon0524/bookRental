<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/joinSelect.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>회원유형선택</title>
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
                    <div class="joinNav">
                        <ul>
                            <li class="keyNav">01. 회원유형 선택<img src="image/joinStep_arrOn.png" alt="navicon"></li>
                            <li>02. 약관동의<img src="image/joinStep_arr.png" alt="navicon"></li>
                            <li>03. 회원 정보 입력<img src="image/joinStep_arr.png" alt="navicon"></li>
                        </ul>
                    </div>

                    <div class="joinSelectTitle">
                        <h5>회원 유형 선택</h5>
                        <p>
                            · 아래아래 회원유형 중에서 본인에게 해당되는 회원유형을 선택하세요.<br/>
                            · 회원유형 별로 가입절차에 차이가 있으니 반드시 본인에게 해당하는 유형을 선택하시기 바랍니다.<br/>
                            · !'만 14세 미만' 어린이 회원 가입 진행 시 꼭 읽어보세요<br/>
                        </p>
                    </div>

                    <div class="joinSelectBox">
                        <div>
                            <h2>만 <span>14세 이상</span> 회원가입</h2>
                            <p class="joinSelectText">
                            가입자의 나이가 만 14세 이상의<br/>
                            일반인의 경우 선택하시기 바랍니다.<br/>
                            가입자의 본인확인 절차가 필요합니다.<br/>
                            </p>
                            <input type="button" value="일반회원 가입하기" onclick="location.href='agree.jsp'">
                        </div>

                        <div>
                            <h2>만 <span>14세 미만</span> 회원가입</h2>
                            <p>
                            가입자의 나이가 만 14세 미만의<br/>
                            경우 선택하시기 바랍니다.<br/>
                            보호자(법정대리인)와 가입자 각각의<br/>
                            본인확인 절차가 필요합니다.<br/>
                            </p>
                            <input type="button" value="어린이회원 가입하기" onclick="location.href='agree.jsp'">
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <%@ include file="/footer.jsp" %>
</body>
</html>