<%@page import="bbsVO.memberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인</title>
<link rel="stylesheet" href="./css/myCss.css">
<%
	memberVO vo = null;
	vo = (memberVO)session.getAttribute("vo");
	String id = vo.getId();
	String pwd = vo.getPwd();
%>
</head>
<body>
"<%=id%>" 회원님의 비밀번호는 "<%=pwd%>" 입니다
</body>
</html>