<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="script/member.js"></script>
<title>로그인 창</title>
<c:if test="${join == 2}">
	<script type="text/javascript">
		alert("회원가입이 완료되었습니다.")
	</script>

</c:if>

<c:if test="${message == -1}">
	<script type="text/javascript">
		alert("없는 회원입니다.")
	</script>

</c:if>

<c:if test="${message == 0 }">
	<script type="text/javascript">
		alert("비밀번호가 틀렸습니다.")
	</script>
</c:if>
</head>
<body>
	<%@ include file="/header.jsp"%>
	<div class="shareContainer">
		<div class="shareImg" style="background: url(image/svisual_img.png);"></div>
		<div class="shareContentWrap">
			<div class="shareNav">
				<ul>
					<li class="navTitle">회원정보</li>
					<li><span class="keyword"><a href="login.jsp">로그인</a></span></li>
					<li><span><a href="agree.jsp">회원가입</a></span></li>
				</ul>
			</div>
			<div class="shareContentBox">
				<div class="shareContentTitle">
					<div class="contentTitle">로그인</div>
					<div class="contentNav">
						<span>홈</span> <i class="arrow"
							style="background: url(image/ico_naviArrow.png) 0 50% no-repeat"></i>
						<span>회원정보</span> <i class="arrow"
							style="background: url(image/ico_naviArrow.png) 0 50% no-repeat"></i>
						<span>로그인</span>
					</div>
				</div>

				<div class="shareContent">
					<div class="loginWrap">
						<form class="loginForm" action="BookServlet?command=logincheck"
							method="post" name="frm">
							<div class="loginBox">
								<div class="loginImgBox">
									<img src="image/login.jpg" alt="login">
								</div>
								<div class="loginInputBox">
									<div class="loginId">
										<img src="image/ico_loginID.png" alt="idicon"> <input
											type="text" id="memberid" name="memberid"
											placeholder="아이디 입력란">
									</div>
									<div class="loginPw">
										<img src="image/ico_loginPW.png" alt="pwicon"> <input
											type="password" id="passcode" name="passcode"
											placeholder="비밀번호 입력란">
									</div>
									<div class="loginSub">
										<ul>
											<li>아이디 찾기</li>
											<li>|</li>
											<li>비밀번호 재설정</li>
											<li>|</li>
											<li><a href="joinselect.jsp">회원가입</a></li>
										</ul>
									</div>
								</div>
								<div class="loginBtnBox">
									<input class="loginBtn" type="submit" value="로그인"
										onclick="return loginCheck()">
								</div>
							</div>
						</form>
						<div class="loginDesc">
							<ul>
								<li>※ 로그인이 안되시는 경우 한/영 키와 Caps Lock 키가 눌러져 있지 않은지 확인하세요.</li>
								<li>※ 계속해서 로그인이 안되시는 경우 관리자에게 문의하시기 바랍니다.</li>
							</ul>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<%@ include file="/footer.jsp"%>
</body>
</html>
