<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/list.css">
    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.0.min.js"></script>
    <title>인기도서조회</title>
</head>
<body>
<%@ include file="/header.jsp" %>
    <div class="shareContainer">
        <div class="shareImg" style="background: url(image/svisual_img.png)"></div>
        <div class="shareContentWrap">
            <div class="shareNav">
                <ul>
                    <li class="navTitle">도서검색</li>
                    <li><span>통합도서 검색</span></li>
                    <li><span><a href="BookServlet?command=book_dlist">신간도서 조회</a></span></li>
                    <li><span class="keyword"><a href="BookServlet?command=book_plist">인기도서 조회</a></span></li>
                    <li><span>도서 상세 페이지</span></li>
                </ul>
            </div>
            <div class="shareContentBox">
                <div class="shareContentTitle">
                    <div class="contentTitle">인기도서 조회</div>
                    <div class="contentNav">
                        <span>홈</span>
                        <i class="arrow" style=" background: url(image/ico_naviArrow.png)0 50% no-repeat;"></i>
                        <span>도서검색</span>
                        <i class="arrow" style=" background: url(image/ico_naviArrow.png)0 50% no-repeat;"></i>
                        <span>인기도서 조회</span>
                    </div>
                </div>

                <div class="shareContent">
                    <c:forEach var="book" items="${ bookList }">
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
                            <input type="button" value="위시리스트">
                            <input type="button" value="대여하기">
                        </div>
                    </form>
                	</c:forEach>
                	               	<ul class="bookListPage">
						<li><c:choose>
								<c:when test="${paging.page<=1}"> 
					               [이전]&nbsp;
					            </c:when>
								<c:otherwise>
									<a href="BookServlet?command=book_plist&page=${paging.page-1}">[이전]</a>&nbsp;
			          			</c:otherwise>
							</c:choose> <c:forEach var="a" begin="${paging.startPage}"
								end="${paging.endPage}" step="1">
								<c:choose>
									<c:when test="${a==paging.page}"> 
					                  [${a}]
					               	</c:when>
									<c:otherwise>
										<a href="BookServlet?command=book_plist&page=${a}">[${a}]</a>&nbsp;
			               			</c:otherwise>
								</c:choose>
							</c:forEach> <c:choose>
								<c:when test="${paging.page>=paging.maxPage}"> 
			             		  [다음]
			            		</c:when>
								<c:otherwise>
									<a href="BookServlet?command=book_plist&page=${paging.page+1}">[다음]</a>
								</c:otherwise>
							</c:choose></li>
					</ul>         	    
                </div>
            </div>
        </div>
    </div>
    <%@ include file = "footer.jsp"%>
</body>
</html>