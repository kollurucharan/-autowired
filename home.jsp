<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	

	<form action="user" method="post">
	User id:	<input type="text" name="userName"><br> 
	Password:	<input type="text" name="password"><br><input
			type="submit" value="Login">
	</form>
</body>
</html>