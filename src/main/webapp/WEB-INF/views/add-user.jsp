<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Add user</title>
</head>
<body>
<h1>Add new user</h1>

<form action="add" method="post">
  <label for="name">Name:</label><br>
  <input type="text" id="name" name="name" required><br><br>

  <label for="lastName">Last name:</label><br>
  <input type="text" id="lastName" name="lastName" required><br><br>

  <label for="email">Email:</label><br>
  <input type="email" id="email" name="email" required><br><br>

  <button type="submit">Add</button>
  <a href="/">Back</a>
</form>
</body>
</html>
