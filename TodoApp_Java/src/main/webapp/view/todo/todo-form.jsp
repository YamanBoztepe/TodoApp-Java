<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/addTodo" method="post">
		<h2>Add New Todo</h2>
		Title: <input type="text" name="title"><br> Status: <select
			name="status">
			<option value="1">Not Started</option>
			<option value="2">In Progress</option>
			<option value="3">Complete</option>
		</select><br> Date: <input type="date" name="targetDate"><br>

		<button type="submit">Save</button>
	</form>
</body>
</html>