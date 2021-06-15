<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList</title>
</head>
<body>
회원리스트 페이지입니다. <br/>
<table border=1>
	<tr><td>아이디</td><td>이름</td><td>연락처</td>
		<td>이메일</td><td>주소</td></tr>
	<c:forEach items="${lists }" var="dto"> <!-- 쉽게 사용하기 위해 만들어진 사용자 태그 -->
	<tr><td><a href="memInfo.mem?memId=${dto.memId }">${dto.memId }</a></td>
		<td>${dto.memName }</td>
		<td>${dto.memPhone }</td><td>${dto.memEmail }</td>
		<td>${dto.memAddress } ${dto.detailAdd }</td></tr>
	</c:forEach>
</table>
</body>
</html>