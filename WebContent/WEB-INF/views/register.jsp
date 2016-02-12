<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Register</title>
</head>
<body>
<h1>Register</h1>

<label>${error}</label><br/>
<form action="${pageContext.request.contextPath}/register/success/" th:action="@{/register/success/}" method="post">
    <p>Username: <input type="text" name="username"></p>
    <p>Password: <input type="password" name="password"></p>
    <p>Again password: <input type="password" name="passwordAgain"></p>
    <p>Email: <input type="text" name="email"></p>

    <p><input type="submit" value="Register"> <input type="reset" value="Reset"/></p>
    <p><a href="${pageContext.request.contextPath}/login/">Back</a></p>
</form>

</body>
</html>