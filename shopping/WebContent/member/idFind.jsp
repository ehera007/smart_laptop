<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IdFind.jsp</title>
</head>
<body>
<c:if test="${idFail == null }">
${dto.memName }님의 Id는 ${dto.memId }입니다. <br/>
</c:if>
<c:if test="${idFail != null }">
${idFail} <br/>
</c:if>
<a href="main.sm">메인으로 가기</a>
</body>
</html>