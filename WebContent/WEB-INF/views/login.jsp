<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>

<p><label>${error}</label></p>
<form action="${pageContext.request.contextPath}/login/" th:action="@{/login/}" method="post">
    <p>Username: <input type="text" name="username"><br/></p>
    <p>Password: <input type="password" name="password"><br/></p>

    <p><input type="submit" value="Login"/> <input type="reset" value="Reset"/></p>
    <p><a href="${pageContext.request.contextPath}/register/">Register</a></p>
</form>

</body>
</html>