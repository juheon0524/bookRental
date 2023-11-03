<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/list.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>위시목록</title>

</head>

<body>
<%@ include file="/header.jsp"%>
    <div class="shareContainer">
        <div class="shareImg" style="background: url(image/svisual_img.png)"></div>
        <div class="shareContentWrap">
            <div class="shareNav">
                <ul>
                    <li class="navTitle">나의정보</li>
                    <li><span>도서이용정보</span></li>
                    <li><span class="keyword"><a href="">나만의 책장</a></span></li>
                    <li><span><a href="">희망도서신청조회</a></span></li>
                    <li><span>배달조회</span></li>
                    <li><span>구독권조회</span></li>
                </ul>
            </div>
            <div class="shareContentBox">
                <div class="shareContentTitle">
                    <div class="contentTitle">나만의책장</div>
                    <div class="contentNav">
                        <span>홈</span>
                        <i class="arrow" style=" background: url(image/ico_naviArrow.png)0 50% no-repeat;"></i>
                        <span>내서재</span>
                        <i class="arrow" style=" background: url(image/ico_naviArrow.png)0 50% no-repeat;"></i>
                        <span>나만의책장</span>
                    </div>
                </div>

                <div class="shareContent">
                    <c:forEach var="book" items="${ mywish }">
                    <form class="listWrap">
                        <div class="listImgBox">
	                        <c:choose>
								<c:when test="${empty book.bookimgurl }">
									<img src="image/noimage.gif"  alt="인기도서">
								</c:when>
								<c:otherwise>
									<img src="image/${book.bookimgurl }" alt="인기도서">
								</c:otherwise>
							</c:choose>
                        </div>
                        <div class="listContentBox">
                            <h2><a href="BookServlet?command=book_detail_view&isbn=${book.isbn}">${book.title }</a></h2>
                            <h3>${book.author }, ${book.publisher }, ${book.publisheddate }</h3>
                            <p>누적대여 횟수 : ${book.cumrentalcnt }, 대여가능 수량 : ${book.curbookcnt }, 구독자 평점 : ${book.score }</p>
                            <!-- 본문 내용추가 원하면 여기에 추가 -->
                        </div>
                        <div class="listBtnBox">
                            <input type="button" value="삭제하기"  onclick="location.href='BookServlet?command=delete_wish&isbn=${book.isbn}'">
                            <input type="button" value="대여하기">
                        </div>
                    </form>
                	</c:forEach>
                	
                	
                	               	    

                </div>
            </div>
        </div>
    </div>
<%@ include file="footer.jsp"%>
</body>
</html>