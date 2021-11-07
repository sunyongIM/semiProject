<%@page import="java.util.ArrayList"%>
<%@page import="bbsVO.bbsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원게시판</title>
<link rel="stylesheet" href="./css/myCss.css">
<%
	String id = (String)session.getAttribute("id");
%>
</head>
<body>
<h2>안녕하세요 <%=id%>님</h2>
<form action="/BBS/CmdController?cmd=postl" method="post">
	<table>
		<tr>
			<th class="bbsId">아이디</th>
			<th class="bbsSub">제목</th>
			<th id="message">글내용</th>
		</tr>
		<%
		ArrayList<bbsVO> list = (ArrayList<bbsVO>)session.getAttribute("list");
		for(bbsVO vo : list){
		%>
		<tr>
			<td><%=vo.getId()%></td>
			<td><%=vo.getTitle()%></td>
			<td><%=vo.getMessage()%></td>
		</tr>
		<%
		}
		%>
		<tr>
			<th colspan="3"><input type="submit" value="새글작성"> <a href="/BBS/bbs/main.jsp" id="logout"><input type="button" value="로그아웃"></a></th>
		</tr>
	</table>
	</form>
</body>
</html>