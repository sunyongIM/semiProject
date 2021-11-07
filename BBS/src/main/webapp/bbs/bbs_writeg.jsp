<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>익명 새글쓰기</title>
<link rel="stylesheet" href="./css/myCss.css">
<link rel="stylesheet" href="../css/myCss.css">
</head>
<body>
	<form action="/BBS/CmdController?cmd=writeg" method="post">
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