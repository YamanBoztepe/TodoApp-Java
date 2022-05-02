<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

</head>
<body>

	<h2>User Register Form</h2>
	<form action="<%=request.getContextPath()%>/signUp" method="post">
		username: <input type="text" name="username"><br>
		password: <input type="password" name="password"><br>
		name: <input type="text" name="name"><br>
		 <select
			name="select">
			<option value="male">male</option>
			<option value="female">female</option>
		</select>
		<p style="color:red;">User is already exists</p><br>
		<button type="submit">Submit</button>

	</form>
</body>
</html>