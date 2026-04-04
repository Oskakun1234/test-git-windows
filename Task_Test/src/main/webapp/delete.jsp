<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録削除</title>
<link rel="stylesheet"  href="style.css" > 
</head>
<body>

<div class="container">

<h2>登録削除</h2>
<hr>

<h3>下記に削除したいuserIdを入力してください</h3><br><br>
	<form action="delete-servlet" method="post">
		ユーザーID<br>
		<input type="text" name="userId" required><br><br>
		パスワード<br>
		<input type="password" name="password" required><br><br>
		
		<input type="submit" value="削除">
	</form>

<% String errorMsg = (String)request.getAttribute("errorMsg"); 
	if(errorMsg != null){
%>
	<p class="errorMsg"><%= errorMsg %></p>
<% } %>

<a href="login.jsp">ログインへ</a>

</div>
</body>
</html>