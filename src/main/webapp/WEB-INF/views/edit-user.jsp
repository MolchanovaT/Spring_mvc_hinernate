<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Edit user</title>
</head>
<body>
<h1>Edit user</h1>

<form action="/users/edit/${user.id}" method="post">
  <label for="name">Name:</label><br>
  <input type="text" id="name" name="name" value="${user.name}" required><br><br>

  <label for="lastName">Last name:</label><br>
  <input type="text" id="lastName" name="lastName" value="${user.lastName}" required><br><br>

  <label for="email">Email:</label><br>
  <input type="email" id="email" name="email" value="${user.email}" required><br><br>

  <button type="submit">Save</button>
  <a href="/">Back</a>
</form>
</body>
</html>
