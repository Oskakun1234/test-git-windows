<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Task" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理画面</title>
<link rel="stylesheet" href="style.css"> 
</head>

<body>
<div class="container">

<% 
String userId = (String)session.getAttribute("userId");
int Id = (int)session.getAttribute("Id");
%>
<h2>タスク管理</h2><br>
<h3> <p group="userId">ID:<%=Id %> 、ユーザ名 :<%=userId %></p></h3> 
 <hr>

タスク一覧

<% List<Task> taskList = (List<Task>)request.getAttribute("taskList");
	if(taskList != null && !taskList.isEmpty()){
%>
<%
	for(Task task : taskList){
%>
	
	<div class="task-item">
   		 <span class="task-text">
   		 <%=task.getId() %> : <%=task.getTitle() %>
   		 </span>
	 
	     <div class="buttons">
			<form action="task-servlet" method="post" >	
				<input type="hidden" name="taskId" value="<%=task.getId() %>">
				<!-- 削除ボタン -->
				<input type="submit" name="action" value="削除">
			</form>
			<form action="task-servlet" method="get">
				<input type="hidden" name="taskId" value="<%=task.getId() %>">
				<!-- 編集ボタン -->
				<input type="submit" name="action" value="編集">
			</form>
		 </div>
	 </div>

<%}
}else{ 
%>
<h3>タスクは存在しません。</h3>
<% }%>

<br><br>
	<!-- 追加ボタン -->
<div class="buttons">

	<form action="task-servlet" method="post">
		追加タスク
		<input type="text" name="taskadd" required >
		<input type="submit" name="action" value="追加">
	</form>
</div>

<% Integer result = (Integer)request.getAttribute("result");
	if(result != null && result > 0){ %>
<p><%=result %>件のタスクを挿入しました</p>
<% } %>
<br><br>
<br><br>

<form action="logout-servlet" method="get">
	<button type="submit" >ログアウト</button>
</form>

</div>
</body>
</html>