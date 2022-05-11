<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.yeditepe.todo.helper.UserInfo"%>
<%@ page import="com.yeditepe.todo.model.Todo"%>
<%@ page import="com.yeditepe.todo.dao.TodosDao"%>
<%@ page import="com.yeditepe.todo.model.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%
TodosDao dao = new TodosDao();
%>
<%
User user = UserInfo.shared.getUser();
%>
<%
ArrayList<Todo> todos = dao.getTodo(user.getUserId());
%>

<body>

	<%
	for (Todo todo : todos) {
	%>
	<%
	if (todo.getStatus() != 3) {
	%>
	<table>
		<tr>
			<td><%=todo.getTitle()%></td>
			<td><%=todo.getTargetDate()%></td>
			<td><%=todo.getStringStatus()%></td>
			<td><a href = "<%=request.getContextPath()%>/editTodoForm?todoId=<%=todo.getTodoId()%>">Edit</a></td>
			<td><a href = "<%=request.getContextPath()%>/completeTodo?todoId=<%=todo.getTodoId()%>">Done</a></td>
		</tr>
	</table>
	<%
	}
	%>
	<%
	}
	%>

	<form action="<%=request.getContextPath()%>/todoForm">
		<input type="submit" value="Add Todo" />
	</form>

</body>
</html>