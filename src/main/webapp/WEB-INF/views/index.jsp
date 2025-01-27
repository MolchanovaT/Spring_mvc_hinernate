<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List of users</title>
</head>
<body>
<h1>List of users</h1>
<a href="/mvc-hibernate/users/new">Add new user</a>
<ul>
    <c:forEach var="user" items="${users}">
        <li>${user.name}</li>
    </c:forEach>
</ul>
</body>
</html>
