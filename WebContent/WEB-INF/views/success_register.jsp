<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register</title>
    <meta http-equiv="Refresh" content="3; url=/nl.naturalis.springdemo/login/" />
</head>
<body>
<h1>Register was successful!</h1>
<h2>Welcome ${username}!</h2>

<br/>
<c:url value="/login/" var="login"/>
You are being redirected to the login page, click <a href="${login}">here</a> if you are not being redirected.
</body>
</html>