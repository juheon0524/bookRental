<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/header.css">
<script type="text/javascript" src="script/header.js"></script>
<header>
	<!-- headerTop -->
	<div class="headerTopWrap">
		<div class="logo">
			<a href="index.jsp"><img src="image/logo.jpg" alt="logoImg"></a>
		</div>
		<div class="headerSerchWrap">
			<div class="headerSerchBox">
				<form>
					<div class="headerSerch">
						<input type="text">
					</div>
					<div class="headerSerchBtn">
						<button type="submit">
							<img src="image/serch.jpg" alt="serchIcon">
						</button>
					</div>
				</form>
			</div>
		</div>
		<div class="headerNav1">
			<c:choose>
				<c:when test="${not empty loginUser}">
					<!-- 사용자가 로그인한 경우 -->
					<ul>
						<li><a href="BookServlet?command=logout-form">로그아웃</a></li>
						<li>|</li>
						<li><a href="passCheck.jsp">정보수정</a></li>
						<li>|</li>
						<li><a href="sitemap.jsp">사이트맵</a></li>
					</ul>
					<a>안녕하세요, ${loginUser.membername}님!</a>
				</c:when>
				<c:otherwise>
					<!-- 사용자가 로그인하지 않은 경우 -->
					<ul>
						<li><a href="BookServlet?command=login-form">로그인</a></li>
						<li>|</li>
						<li><a href="joinselect.jsp">회원가입</a></li>
						<li>|</li>
						<li><a href="sitemap.jsp">사이트맵</a></li>
					</ul>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

	<!-- headerBottom -->
	<div class="headerBottomWrap">
		<div class="headerNav2">
			<nav>
				<ul>
					<li>도서관 안내
						<ul>
							<li><a href="#">회원 가입 안내</a></li>
							<li><a href="#">도서 대여 안내</a></li>
						</ul>
					</li>
					<li>도서검색
						<ul>
							<li><a href="#">통합도서 검색</a></li>
							<li><a href="BookServlet?command=book_dlist">신간도서 조회</a></li>
							<li><a href="BookServlet?command=book_plist">인기도서 조회</a></li>
						</ul>
					</li>
					<li>열린마당
						<ul>
							<li><a href="#">공지사항</a></li>
							<li><a href="#">Q&A</a></li>
							<li><a href="#">독후감</a></li>
						</ul>
					</li>
					<li>내 서재
						<ul>
							<li><a href="#">나의정보</a></li>
							<li><a href="#">구독내역 조회</a></li>
							<li><a href="#">대여내역 조회</a></li>
							<li><a href="#">반납현황 조회</a></li>
							<li><a href="#">나만의 책장</a></li>
						</ul>
					</li>
					<c:if test="${loginUser.memberflag == 01}">
						<li class="hiddenNav"><a href="BookServlet?command=admin_main">관리자 페이지</a>
							<ul>
								<li><a href="BookServlet?command=book_insert_form">도서관리</a></li>
								<li><a href="BookServlet?command=subscr_list">구독권관리</a></li>
							</ul>
						</li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
</header>