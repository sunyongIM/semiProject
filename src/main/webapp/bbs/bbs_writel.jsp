<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 새글쓰기</title>
<link rel="stylesheet" href="./css/myCss.css">
<link rel="stylesheet" href="../css/myCss.css">
<%
	/* String id = (String)request.getAttribute("id");
	String pwd = (String)request.getAttribute("pwd");
	request.setAttribute("id", id);
	request.setAttribute("pwd", pwd); */
	String id = (String)session.getAttribute("id");
	String pwd = (String)session.getAttribute("pwd");
%>
</head>
<body>
	<form action="/BBS/CmdController?cmd=writel" method="post">
	<input type="hidden" name="id" value=<%=id%>>
	<input type="hidden" name="pwd" value=<%=pwd%>>
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" class="bbsSub"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input type="text" name="message" class="bbsMes"></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="작성완료"></th>
			</tr>
		</table>
	</form>
</body>
</html>