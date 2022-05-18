<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="com.yeditepe.todo.model.Todo"%>
<%@ page import="com.yeditepe.todo.dao.TodosDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
Todo todo = new Todo();
String todoId = request.getParameter("todoId");
String errorMessage = request.getParameter("errorMessage");
if (todoId != null && !todoId.isBlank()) {
	todo = new TodosDao().selecTodo(Integer.parseInt(todoId));
} else {
	todo = null;
}

%>
<body>
	<form action="<%=request.getContextPath()%><%=todo == null ? "/addTodo" : "/editTodo" %>" method="post">
		<h2><%=todo == null ? "Add New Todo" : "Edit Todo" %></h2>
		Title: <input type="text" name="title" value="<%=todo == null ? "" : todo.getTitle() %>"><br> 
		Status: <select
			name="status">
			<%
			if(todo != null && todo.getStatus() == 1) {
			%>
			<option value="1" selected>Not Started</option>
			<%
			} else {
			%>
			<option value="1">Not Started</option>
			<%
			}
			%>
			
			
			<%
			if(todo != null && todo.getStatus() == 2) {
			%>
			<option value="2" selected>In Progress</option>
			<%
			} else {
			%>
			<option value="2">In Progress</option>
			<%
			}
			%>
			
			<%
			if(todo != null && todo.getStatus() == 3) {
			%>
			<option value="3" selected>Complete</option>
			<%
			} else {
			%>
			<option value="3">Complete</option>
			<%
			}
			%>
			
		</select><br> 
		Date: <input type="date" name="targetDate" value = "<%=todo == null ? "" : todo.getTargetDate()%>"><br>
		<input type="hidden" name="todoId" value="<%=todoId%>">
		<p style="color:red;"><%=errorMessage == null ? "" : errorMessage %></p>
		<button type="submit">Save</button>
	</form>
</body>
</html>