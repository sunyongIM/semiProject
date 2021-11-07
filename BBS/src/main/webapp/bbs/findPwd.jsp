<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 조회</title>
<link rel="stylesheet" href="./css/myCss.css">
</head>
<body>
<form action="/BBS/CmdController?cmd=showPwd" method="post">
	<table>
		<tr><th><h2>비밀번호 조회</h2></th></tr>
		<tr><th><input type="text" name="findPwd" value="아이디를 입력해 주세요"></th></tr>
		<tr><th><input type="submit" value="비밀번호 조회"></th></tr>
	</table>
</form>
</body>
</html>