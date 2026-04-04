<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント作成画面</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<div class="container">

<h2>アカウントを作成</h2>

<h3>必要情報入力<br><br><br></h3>

<form action=create-servlet method="post">

	●ユーザ名<br>
	<input type="text" name="userId" required><br><br>
	●パスワード<br>
	<input type="password" name="password" required><br><br>
	●メールアドレス<br>
	<input type="email" name="mail" required><br><br>
	
	<input type="submit" value="登録">
	
</form>

	<% 
	String errorMsg = (String)request.getAttribute("errorMsg");
	if(errorMsg != null){
	%>
	※<%= errorMsg%>
	<%
	}
	%>
	<br><br>
	
	<a group="home"  href="login.jsp" >ホームへ</a>
	
	</div>
</body>
</html>