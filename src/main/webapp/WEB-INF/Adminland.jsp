<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
</head>
<body>
    <main>
        <div class="function">
            <h3>Register a new user</h3>
            <a href="register">Go to User Registration</a>
        </div>

        <div class="function">
            <h3>Register a new student</h3>
            <a href="studentregister">Go to Student Registration</a>
        </div>

        <div class="function">
            <h3>Show all users</h3>
            <a href="showUsers">View All Users</a>
        </div>

        <div class="function">
            <h3>Show all students</h3>
            <a href="students">View All Students</a>
        </div>
        
          <div class="function">
            <h3>Update Users</h3>
            <a href="updateUser">Update Users</a>
        </div>

        <div class="function">
            <h3>Update Students</h3>
            <a href="updateStudent">Update Students</a>
        </div>
    </main>

    <button class="logout-button" onclick="location.href='logout'">Logout</button>
</body>
</html>
