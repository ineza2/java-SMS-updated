<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Users</title>
    <style>
        .update-button, .delete-button {
            background-color: #3498db;
            color: #fff;
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            transition: background-color 0.3s ease;
          
        }

        .delete-button {
            background-color: #e74c3c; /* Red color */
        }

        .update-button:hover, .delete-button:hover {
            background-color: #2980b9;
        }

        .back-link {
            margin-top: 20px;
            text-align: center;
        }

        .back-link a {
            text-decoration: none;
            color: #3498db;
            font-weight: bold;
            padding: 8px 12px;
            border: 1px solid #3498db;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }

        .back-link a:hover {
            background-color: #3498db;
            color: #fff;
        }
    </style>
</head>
<body>
    <h1>Update Users</h1>

    <table>
        <thead>
            <tr>
                <th>Username</th>
                <th>Email</th>
                <th>Role</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.role}</td>
                    <td>
                        <form action="updateUser" method="post" style="display: inline;">
                            <input type="hidden" name="userId" value="${user.id}">
                            <button type="submit" class="update-button">Update</button>
                        </form>
                        
                        <form action="deleteUser" method="post" style="display: inline; margin-left: 10px;">
                            <input type="hidden" name="userId" value="${user.id}">
                            <button type="submit" class="delete-button">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- Back to Home link -->
    <div class="back-link">
        <p><a href="javascript:history.back()">Back to Home</a></p>
    </div>
</body>
</html>
