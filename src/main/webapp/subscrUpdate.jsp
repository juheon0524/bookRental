<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/subscrUpdate.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="script/book.js"></script>
<script type="text/javascript" src="script/adminNav.js"></script>
<title>구독권수정</title>

</head>

<body>
	<%@ include file="/header.jsp"%>
	<div class="shareContainer">
		<div class="shareImg" style="background: url(image/svisual_img.png);"></div>
		<div class="shareContentWrap">
			<div class="shareNav">
				<ul>
					<li class="navTitle">관리자 페이지</li>
					<li><span>도서 관리&nbsp;&nbsp;&nbsp;</span> <i
						class="fa-solid fa-chevron-down book-chevron-down"></i> <i
						class="fa-solid fa-chevron-up book-chevron-up"
						style="display: none;"></i></li>
					<li class="bookNav"><span style=""><a
							href="BookServlet?command=book_insert_form">도서등록</a></span></li>
					<li class="bookNav"><span>도서수정</span></li>
					<li class="bookNav"><span>도서연체 관리</span></li>
					<li class="bookNav"><span>대여도서 관리</span></li>
					<li class="bookNav"><span>반납도서 관리</span></li>
					<li><span>구독권 관리</span> <i
						class="fa-solid fa-chevron-down subscription-chevron-down"></i> <i
						class="fa-solid fa-chevron-up subscription-chevron-up"
						style="display: none;"></i></li>
					<li class="subscriptionNav"><span><a href="BookServlet?command=subscr_list">구독권 조회</a></span></li>
					<li class="subscriptionNav"><span class="keyword"><a href="BookServlet?command=subscr_insert_form">구독권 등록</a></span></li>
				</ul>
			</div>
			<div class="shareContentBox">
				<div class="shareContentTitle">
					<div class="contentTitle">구독권 수정</div>
					<div class="contentNav">
						<span>홈</span> <i class="arrow"
							style="background: url(image/ico_naviArrow.png) 0 50% no-repeat;"></i>
						<span>관리자 페이지</span> <i class="arrow"
							style="background: url(image/ico_naviArrow.png) 0 50% no-repeat;"></i>
						<span>구독권 관리</span> <i class="arrow"
							style="background: url(image/ico_naviArrow.png) 0 50% no-repeat;"></i>
						<span>구독권 수정</span>
					</div>
				</div>

				<div class="shareContent">
					<form action="BookServlet?command=subscr_update" method="post"
						name="frm" class="subscrUpdateWrap">
						<input type="hidden" name="command" value="subscr_update"> 
						<table>

							<tr>
								<th>구독권 아이디</th>
								<td><input type="text" name="subscrid" class="subscrUpdate" readonly="readonly" value="${subscr.subscrid }"></td>
							</tr>
							<tr>
								<th>구독권명</th>
								<td><input type="text" name="subscrname" class="subscrUpdate" value="${subscr.subscrname }"></td>
							</tr>
							<tr>
								<th>판매가격</th>
								<td><input type="text" name="price" class="subscrUpdate" value="${subscr.price }"></td>
							</tr>
							<tr>
								<th>판매개시일</th>
								<td><input type="text" name="salefromdate" class="subscrUpdate" value="${subscr.salefromdate }"></td>
							</tr>
							<tr>
								<th>판매종료일</th>
								<td><input type="text" name="saletodate" class="subscrUpdate" value="${subscr.saletodate }"></td>
							</tr>
							<tr>
								<th>구독기간</th>
								<td><input type="text" name="subscrperiod" class="subscrUpdate" value="${subscr.subscrperiod }"></td>
							</tr>
							<tr>
								<th>대여가능 도서수</th>
								<td><input type="text" name="allowedbookcnt" class="subscrUpdate" value="${subscr.allowedbookcnt }"></td>
							</tr>
							<tr>
								<th>등록자</th>
								<td><input type="text" name="memberid" class="subscrUpdate" value="${subscr.memberid }"></td>
							</tr>
							<tr>
								<th>등록일자</th>
								<td><input type="text" name="registereddate" class="subscrUpdate" value="${subscr.registereddate }"></td>
							</tr>
						</table>
						<div class="subscrUpdateBtnBox">
							<input type="submit" value="수정" onclick="return subscrUpdateCheck()">
							<input type="button" value="삭제" onclick="if(subscrDelCheck()) { location.href='BookServlet?command=subscr_delete&subscrid=${subscr.subscrid}'; }">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>

</html>