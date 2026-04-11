<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録完了画面</title>
<link rel="stylesheet" href="style.css"> 
</head>
<body>
<div class="container">

<h2>ユーザ登録完了</h2>
<hr>
<br>
<br>
	<h3>登録内容</h3>
	<%
		String userId = (String)session.getAttribute("userId");
		String mail = (String)session.getAttribute("mail");
		if (userId != null && mail != null){
	%>		
		ユーザーID ： <%= userId %><br>
		メールアドレス ： <%= mail %>
	<%
		}
	%>
	
	<br><br>
	<a href= "login.jsp" >ログイン画面へ</a>

</div>
</body>
</html>