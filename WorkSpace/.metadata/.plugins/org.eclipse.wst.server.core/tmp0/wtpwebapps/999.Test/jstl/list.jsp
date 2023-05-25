<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>요청성공</h1>
	<c:forEach items="${strArr}" var="str">
		<p>출력테스트: ${str }</p>
	</c:forEach>
	<form action="listdetail.js" method="get">
		<input type = "hidden" value = 1013 name = "q_bbsCode">
		<input type = "submit">
	</form>
</body>
</html>