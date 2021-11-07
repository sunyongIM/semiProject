<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>goodbye...</title>
<link rel="stylesheet" href="./css/myCss.css">
<script src="./js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="./js/bbs.js"></script>
</head>
<body>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm");
	String now = sdf.format(new Date());
%>
<form action="/BBS/CmdController?cmd=delete" method="post">
	<table>
		<tr>
		<th colspan="3"><h2>유익有匿 회원탈퇴</h2></th>
		</tr>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id" id="id"></td>
			<td><input type="button" name="checkId" value="id확인" id="checkId"></td>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pwd" id="pwd"></td>
			<td></td>
		</tr>
		<tr>
			<th>탈퇴일시</th>
			<td><input type="text" value="<%=now%>" readonly="readonly"></td>
			<td></td>
		</tr>
		<tr>
			<th colspan="3"><input type="submit" value="탈퇴"></th>
		</tr>
		
	</table>
	</form>
</body>
</html>