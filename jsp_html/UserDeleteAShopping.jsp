<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>付款</title>
<title>付款</title>
<link rel="stylesheet" type="text/css" href="css/admin_login.css" />
</head>
<body>
<%
String num=request.getParameter("deletenum");


%>
	<div class="admin_login_wrap">
		<img src="./img/2wm.png">
		<h2>请扫描二维码付款</h2>
		<h1>点击下面按钮假装付款成功！</h1>
		<form action="./ubcs?deletenum=<%=num %>" method="post">
			<input class="btn btn-primary btn2" name="sub" value="确认付款"
				type="submit">
		</form>
	</div>
</body>
</html>