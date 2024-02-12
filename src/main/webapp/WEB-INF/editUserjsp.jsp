<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit User</title>
    </head>
<body>
    <h1>Edit User</h1>
    <form action="updateUser" method="post">
        <input type="hidden" name="userId" value="${param.userId}">
        
        <!-- Input field for updating username -->
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="${user.username}" required>

        <!-- Input field for updating email -->
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${user.email}" required>

        <!-- Input field for updating password -->
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" value="${user.password}" required>

        <!-- Input field for updating role -->
        <label for="role">Role:</label>
        <select id="role" name="role" required>
            <option value="Admin" ${user.role eq 'Admin' ? 'selected' : ''}>Admin</option>
            <option value="Guest" ${user.role eq 'Guest' ? 'selected' : ''}>Guest</option>
        </select>

        <button type="submit">Save Changes</button>
    </form>

    <!-- Back to Home link -->
    <div class="back-link">
    <p><a href="javascript:history.back();history.back()">Back</a></p>
    </div>
</body>
</html>
