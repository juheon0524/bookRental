<%@page import="com.ezen.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/bookDetailView.css">
    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.0.min.js"></script>
    <title>도서상세정보</title>
</head>
<c:if test="${wishSu == 1}">
		<script type="text/javascript">
			alert("이미 추가하신 도서입니다.")
		</script>
	
</c:if>
<c:if test="${wishSu == 2}">
	<script type="text/javascript">
        var confirmResponse = confirm("추가하셨습니다. 내 서재로 이동하시겠습니까?");
        if (confirmResponse) {
            // 이동할 페이지의 URL을 여기에 입력
            window.location.href = "BookServlet?command=wish_lists";
        }
    </script>
</c:if>
<body>
<%@ include file="/header.jsp" %>
    <div class="shareContainer">
        <div class="shareImg" style="background: url(image/svisual_img.png);"></div>
        <div class="shareContentWrap">
            <div class="shareNav">
                <ul>
                    <li class="navTitle">도서검색</li>
                    <li><span>통합검색</span></li>
                    <li><span><a href="BookServlet?command=book_dlist">신간도서 조회</a></span></li>
                    <li><span><a href="BookServlet?command=book_plist">인기도서 조회</a></span></li>
                    <li><span class="keyword">도서 상세 페이지</span></li>
                </ul>
            </div>
            <div class="shareContentBox">
                <div class="shareContentTitle">
                    <div class="contentTitle">도서 상세 페이지</div>
                    <div class="contentNav">
                        <span>홈</span>
                        <i class="arrow" style="background: url(image/ico_naviArrow.png)0 50% no-repeat;"></i>
                        <span>도서검색</span>
                        <i class="arrow" style="background: url(image/ico_naviArrow.png)0 50% no-repeat;"></i>
                        <span>도서 상세 페이지</span>
                    </div>
                </div>

                <div class="shareContent">
                    <form class="bookDetailWrap">
                        <div class="bookDetailBox">
                            <div class="bookDetailImgBox">
                    			<c:choose>
								<c:when test="${empty bookVo.bookimgurl }">
									<img src="image/noimage.gif" >
								</c:when>
								<c:otherwise>
									<img src="image/${bookVo.bookimgurl }" alt="책이미지">
								</c:otherwise>
								</c:choose>
                            </div>
                            <div class="bookDetailInfoBox">
                                <ul>
                                	<li><span>${bookVo.title }</span></li>
                                    <li><span>ISBN</span> : ${bookVo.isbn }</li>
                                    <li><span>작가</span> : ${bookVo.author }</li>
                                    <li><span>출판사</span> : ${bookVo.publisher }</li>
                                    <li><span>출간일</span> : ${bookVo.publisheddate }</li>
                                    <li><span>도서분류</span> : ${bookGenre }</li>
                                    <li><span>독자평점</span> : ${bookScore }</li>
                                    <li><span>누적대여횟수</span> : ${bookVo.cumrentalcnt }</li>
                                    <li><span>대여가능수량</span> : ${bookVo.curbookcnt }</li>
                                </ul>
                            </div>
                        </div>

                        <div class="bookDetailIntro">
                            <div class="bookDetailIntroTitle">
                                <h2>책소개</h2>
                            </div>
                            <p>${bookVo.bookcontent }</p>
                        </div>
                        <div class="bookDetailReview">
                            <div class="bookDetailReviewTitle">
                                <h2>독자후기</h2>
                            </div>
                            <c:forEach var="ratings" items="${ ratingsList }">
	                            <h3>${ratings.memberid}, ${ratings.writedate}, ${ratings.score}</h3>
	                            <p>${ratings.content}</p>
                            </c:forEach>
                        </div>
                        <div class="bookDetailBtnBox">
                            <input type="button" value="위시리스트" onclick="location.href='BookServlet?command=wish_upload&isbn=${bookVo.isbn}&value=3'">
                            <input type="button" value="대여신청">        

                            <c:if test= "${sessionScope.loginUser.memberflag eq '01'}">
                            	<input type="button" value="도서정보수정" onclick="location.href='BookServlet?command=book_update_form&isbn=${bookVo.isbn }';">
                           	</c:if>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
<%@ include file = "footer.jsp"%>
</body>
</html>