<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>

<h2>Register</h2>

<form action="registerServlet" method="post">
    Username: <input type="text" name="username" required><br><br>
    Password: <input type="password" name="password" required><br><br>

    <select name="role" required>
        <option value="member">Member</option>
        <option value="trainer">Trainer</option>
        <option value="manager">Gym Manager</option>
    </select><br><br>

    <input type="submit" value="Register">
</form>

<a href="login.jsp">Login</a>

</body>
</html>