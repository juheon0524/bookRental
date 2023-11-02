<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="script/member.js"></script>
<title>아이디중복확인</title>
</head>
<body>
<h3>아이디 중복체크</h3>
<form action="BookServlet" method="get" name="frm">
	<input type="hidden" name="command" value="idcheck">
	아이디 <input type="text" name="memberid" value="${memberid}">
	<input type="submit" value="중복체크">
	<br>
	<c:if test="${result == 1}">
		<script type="text/javascript">
			opener.document.frm.memberid.value="";
		</script>
		${memberid}는 이미 사용 중인 아이디입니다.
	</c:if>

	<c:if test="${result == 0 }">
		${memberid}는 사용 가능한 아이디입니다.
		<input type="button" value="사용"  onclick="idOk()">
	</c:if>
</form>
</body>
</html>