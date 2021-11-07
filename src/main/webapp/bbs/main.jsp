<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome BBS</title>
<link rel="stylesheet" href="../css/myCss.css">
<link rel="stylesheet" href="./css/myCss.css">
</head>
<body>
<script type="text/javascript">
	function goGuest(){
	alert("익명게시판으로 이동합니다.");
}
</script>


<form action="/BBS/CmdController?cmd=logIn" method="post">
	<table>
		<tr>
			<th colspan="2"><h1>유익有匿 커뮤니티</h1></th>
			<th><a href="/BBS/CmdController?cmd=join"><h4>회원가입</h4></a></th>
		</tr>
		<tr>
			<th>아이디: <input type="text" name="id"></th>
			<th rowspan="2"><input type="submit" value="로그인" id="submit"></th>
			<th><a href="/BBS/CmdController?cmd=find"><h4>비밀번호 조회</h4></a></th>
		</tr>
		<tr>
			<th>비밀번호: <input type="password" name="pwd"></th>
			<th><a href="/BBS/CmdController?cmd=signout"><h4>회원탈퇴</h4></a></th>
		</tr>
		<tr>
			<th colspan="3">익명게시판: <a href="/BBS/CmdController?cmd=bbsg"><input type="button" onclick="goGuest()" value="Guest"></a></th>
		</tr>
	</table>
</form>
</body>
</html>