<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Task" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク編集</title>
<link rel="stylesheet" href="style.css"> 
</head>
<body>

<div class="container">
<h2>タスク編集</h2>
<hr>

<% Task task = (Task) request.getAttribute("task"); %>

<form action="task-servlet" method="post">
	<!-- IDは見えないように送る -->
	<input type="hidden" name="taskId" Value="<%=task.getId() %>">
	
	<br><br>
	タイトル
	<input type="text" name="title" Value="<%=task.getTitle() %>">
	
	<br><br>
	
	<input type="submit" name="action" value="更新">
	
</form>

<br>
<a href="task-servlet">戻る</a>

</div>
</body>
</html>