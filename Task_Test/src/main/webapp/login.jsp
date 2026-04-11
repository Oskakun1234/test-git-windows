<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet"  href="style.css" > 
</head>
<body>

<div class="container">
<h2>ログイン</h2>

<hr>
	<%
	String deleteMsg = (String)request.getAttribute("deleteMsg");
	String del_Id = (String)request.getAttribute("del_Id");
	if(deleteMsg != null){
	%>
	<p class="deleteMsg"> <%= deleteMsg%></p>
	削除されたID：<%= del_Id%><br><br><br>
	<% } %>
	
	<h3>ログイン情報入力</h3>
	<form action="login-servlet" method="post">
		ユーザーID<br>
		<input type="text" name="userId" required><br><br>
		パスワード<br>
		<input type="password" name="password" required><br><br>
		<input type="submit" value="ログイン"><br><br>
	</form>

	<%
	String errorMsg = (String)request.getAttribute("errorMsg");
	String userId = (String)request.getAttribute("userId");
	String password = (String)request.getAttribute("password");
	
	if(errorMsg != null){
	%>
	<p class="errorMsg"> <%=errorMsg %></p>
	<%=userId %>
	<%=password %>
	
	<%} %>

	<div class="TypeA">
		<a  href="Create.jsp">【会員登録】</a>
		・
		<a href="delete.jsp"> 【登録解除】</a>
	</div>
</div>

</body>
</html>