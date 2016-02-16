<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Home of ${username}</title>
</head>
<body>
<h1>Home of ${username}</h1>


<p><label>${error}</label></p>
<form action="${pageContext.request.contextPath}/home/${userId}/" th:th:action="@{/home/${userId}/" method="post">
    <p>Username: <input type="text" name="username" value="${username}"><br/></p>
    <p>Password: <input type="password" name="password" value="${password}"><br/></p>
    <p>Password Again: <input type="password" name="passwordAgain" value="${password}"><br/></p>
    <p>Email: <input type="text" name="email" value="${email}"><br/></p>

    <p><input type="submit" value="Change"/></p>
</form>

<form action="${pageContext.request.contextPath}/login/" th:th:action="@{login}" method="get">
    <p> <input type="submit" value="Logout"/></p>
</form>


</body>
</html>