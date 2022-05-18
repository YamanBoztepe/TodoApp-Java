<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<%
String usernameCookie = "username";
String passwordCookie = "password";

String username = "";
String password = "";

Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (Cookie cookie : cookies) {
		if (usernameCookie.equals(cookie.getName())) {
			username = cookie.getValue();
			
		} else if (passwordCookie.equals(cookie.getName())) {
			password = cookie.getValue();
		}
	}
}
%>
<body>
	<h1>Login Form</h1>
	<form action="<%=request.getContextPath()%>/login" method="post">
		username: <input type="text" name="username"><br>
		password: <input type="password" name="password"><br>
		<input type="checkbox" name="rememberMe" value="active"> Remember Me <br>
		<p style="color:red;">User is not exists</p><br>
		<button type="submit">Submit</button>
	</form>
	<a href="<%=request.getContextPath()%>/signUp">Sign up</a>
</body>
</html>