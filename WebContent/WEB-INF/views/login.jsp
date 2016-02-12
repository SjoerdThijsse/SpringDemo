<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>

<br/>
<form action="<c:url value="/login/" />" method="POST">
    <label>${error}</label><br/>
    Username: <input type="text" name="username"><br/>
    Password: <input type="password" name="password"><br/>
    <input type="submit" name="login" value="Login">
    <c:url value="/register/" var="register"/>
    <a href="${register}">Register</a>
</form>

</body>
</html>