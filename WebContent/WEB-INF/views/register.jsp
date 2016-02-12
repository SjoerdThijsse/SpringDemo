<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>Register</h1>

<br/>
<form action="<c:url value="/register/" />" method="POST">
    <label>${error}</label><br/>
    Username: <input type="text" name="username"><br/>
    Password: <input type="password" name="password"><br/>
    Again password: <input type="password" name="passwordAgain"><br/>
    Email: <input type="text" name="email"><br/>
    <input type="submit" name="register" value="Register">

</form>

<br/>
<form action="<c:url value="/login/" />" method="GET">
    <input type="submit" name="back" value="Back">
</form>
</body>
</html>