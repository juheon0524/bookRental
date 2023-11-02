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
<link rel="stylesheet" type="text/css" href="css/bookInsert.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="script/book.js"></script>
<script type="text/javascript" src="script/adminNav.js"></script>
<title>도서등록</title>
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
					<li class="bookNav"><span class="keyword"><a
							href="BookServlet?command=book_insert_form">도서등록</a></span></li>
					<li class="bookNav"><span>도서수정</span></li>
					<li class="bookNav"><span>도서연체 관리</span></li>
					<li class="bookNav"><span>대여도서 관리</span></li>
					<li class="bookNav"><span>반납도서 관리</span></li>
					<li><span>구독권 관리</span> <i
						class="fa-solid fa-chevron-down subscription-chevron-down"></i> <i
						class="fa-solid fa-chevron-up subscription-chevron-up"
						style="display: none;"></i></li>
					<li class="subscriptionNav"><span><a
							href="BookServlet?command=subscr_list">구독권 조회</a></span></li>
					<li class="subscriptionNav"><span><a
							href="BookServlet?command=subscr_insert_form">구독권 등록</a></span></li>
				</ul>
			</div>
			<div class="shareContentBox">
				<div class="shareContentTitle">
					<div class="contentTitle">도서등록</div>
					<div class="contentNav">
						<span>홈</span> <i class="arrow"
							style="background: url(image/ico_naviArrow.png) 0 50% no-repeat;"></i>
						<span>관리자 페이지</span> <i class="arrow"
							style="background: url(image/ico_naviArrow.png) 0 50% no-repeat;"></i>
						<span>도서등록</span>
					</div>
				</div>

				<div class="shareContent">
					<form action="BookServlet?command=book_insert" method="post"
						name="frm" enctype="multipart/form-data" class="bookInsertWrap">
						<input type="hidden" name="command" value="book_update"> <input
							type="hidden" name="nomakeIMg" value="${book.bookimgurl }">
						<table>

							<tr>
								<th>도서 제목</th>
								<td><input type="text" name="title" class="bookInsert"></td>
							</tr>
							<tr>
								<th>ISBN</th>
								<td><input type="text" name="isbn" class="bookInsert"></td>
							</tr>
							<tr>
								<th>도서분류</th>
								<td><input type="text" name="genrecode" class="bookInsert"></td>
							</tr>
							<tr>
								<th>작가</th>
								<td><input type="text" name="author" class="bookInsert"></td>
							</tr>
							<tr>
								<th>출판사</th>
								<td><input type="text" name="publisher" class="bookInsert"></td>
							</tr>
							<tr>
								<th>발간일</th>
								<td><input type="text" name="publisheddate"
									class="bookInsert"></td>
							</tr>
							<tr>
								<th>총보유수량</th>
								<td><input type="text" name="totbookcnt" class="bookInsert"></td>
							</tr>
							<tr>
								<th>대여수량</th>
								<td><input type="text" name="rentedbookcnt"
									class="bookInsert"></td>
							</tr>
							<tr>
								<th>대여가능수량</th>
								<td><input type="text" name="curbookcnt" class="bookInsert"></td>
							</tr>
							<tr>
								<th>도서가격</th>
								<td><input type="text" name="price" class="bookInsert"></td>
							</tr>
							<tr>
								<th>누적대여횟수</th>
								<td><input type="text" name="cumrentalcnt"
									class="bookInsert"></td>
							</tr>
							<tr>
								<th>등록일자</th>
								<td><input type="text" name="registereddate"
									class="bookInsert"></td>
							</tr>
							<tr>
								<th>등록자</th>
								<td><input type="text" name="memberid" class="bookInsert"></td>
							</tr>
							<tr>
								<th>도서이미지정보</th>
								<td><input type="file" name="bookimgurl">(주의사항 :
									이미지를 변경하고자 할때만 선택하세요.)</td>
							</tr>
							<tr>
								<th>도서정보</th>
								<td><textarea rows="15" cols="100" name="bookcontent"
										class="bookInsert"> </textarea></td>
							</tr>
						</table>
						<div class="bookInsertBtnBox">
							<input type="submit" value="등록" onclick="return bookCheck()">
							<input type="reset" value="취소">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>