<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<!-- url mapping / jdbclogin을 만들고 (servlet)
		현재 JSP페이지에서 id와 pw를 전송하게 처리해보기.
		전송방식을 민감한 정보인 id와 pw는 post로 한다.
	-->
	
	<form action="../jdbclogin" method="post">
		<input type="text" name="id">
		<input type = "text" name = "pw"> 
		<input type = "submit">
	</form>
</body>
</html>