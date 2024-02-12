<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.student.registration.model.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Users</title>
</head>
<body>
    <h1>All Users</h1>

    <table>
        <thead>
            <tr>
                <th>Username</th>
                <th>Email</th>
                <!-- Removed <th>Password</th> -->
                <th>Role</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <!-- Removed <td>${user.password}</td> -->
                    <td>${user.role}</td>
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
