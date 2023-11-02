<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/pwCheck.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="script/member.js"></script>
    <title>로그인 창</title>
    <c:if test="${su == -1}">
		<script type="text/javascript">
			alert("비밀번호가 틀렸습니다.")
		</script>
	</c:if>
</head>
<body>
    <%@ include file="/header.jsp" %>
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
                            <i class="arrow" style="background: url(image/ico_naviArrow.png)0 50% no-repeat"></i>
                            <span>회원정보</span>
                            <i class="arrow" style="background: url(image/ico_naviArrow.png)0 50% no-repeat"></i>
                            <span>개인정보수정</span>
                        </div>
                    </div>
    
                    <div class="shareContent">
                        <div class="pwCheckWrap">
                            <h2>비밀번호 확인</h2>
                            <p>
                                · 공용 사용환경 등에서의 개인정보 보호를 위해 비밀번호를 확인합니다.<br/>
                                · 아래 입력창에 비밀번호를 입력하고 확인을 누르면 회원정보수정 페이지로 이동합니다.<br/>
                            </p>
                            <form class="pwCheckForm" action="BookServlet?command=passCheck" method="post" name="frm">
                                <div class="pwCheckInputWrap">
                                    <input type="text" id="passcode" name="passcode" placeholder="비밀번호 입력">
                                    <input type="submit" value="비밀번호 확인" onclick="return pwcheck()" class="pwCheckBtn">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <%@ include file="/footer.jsp" %>
</body>
</html>