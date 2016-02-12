<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome ${name}</title>
</head>
<body>
<h1>Ant + Spring MVC Web Project Example</h1>

<p>Hello ${name}</p>

<form action="<c:url value="/buttons/" />" method="GET">
    <input type="submit" name="action" value="Henk" />
    <input type="submit" name="action"  value="Jan" />
</form>
<br/>
<form action="<c:url value="/input/" />" method="GET">
    First name: <input type="text" name="fname"><br/>
    Last name: <input type="text" name="lname"><br/>
    <input type="submit" name="action" value="Submit">
</form>
</body>
</html>