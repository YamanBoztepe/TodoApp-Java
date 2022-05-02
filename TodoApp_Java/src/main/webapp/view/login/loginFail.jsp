<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
	<h1>Login Form</h1>
	<form action="<%=request.getContextPath()%>/login" method="post">
		username: <input type="text" name="username"><br>
		password: <input type="password" name="password"><br>
		<p style="color:red;">User is not exists</p><br>
		<button type="submit">Submit</button>
	</form>
	<a href="<%=request.getContextPath()%>/signUp">Sign up</a>
</body>
</html>