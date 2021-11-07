<%@page import="bbsVO.guestVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>익명게시판</title>
<link rel="stylesheet" href="./css/myCss.css">
</head>
<body>
<h2>안녕하세요 guest님</h2>
<form action="/BBS/bbs/bbs_writeg.jsp" method="post">
	<table>
		<tr>
			<th class="bbsSub">제목</th>
			<th id="message">글내용</th>
		</tr>
		<%
		ArrayList<guestVO> list = (ArrayList<guestVO>)session.getAttribute("list");
		for(guestVO vo : list){
		%>
		<tr>
			<td><%=vo.getTitle()%></td>
			<td><%=vo.getMessage()%></td>
		</tr>
		<%
		}
		%>
		<tr>
			<th colspan="3"><input type="submit" value="새글작성"> <a href="/BBS/bbs/main.jsp" id="logout"><input type="button" value="나가기"></a></th>
		</tr>
	</table>
	</form>
</body>
</html>