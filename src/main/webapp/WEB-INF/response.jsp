<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Student Registration</title>
</head>
<body>
    <div>
        <h1>Student Registration Response</h1>
        <table>
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Age</th>
                <th>School</th>
                <th>Email</th>
                <th>Mobile</th>
            </tr>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.code}</td>
                    <td>${student.name}</td>
                    <td>${student.age}</td>
                    <td>${student.school}</td> 
                    <td>${student.email}</td>
                    <td>${student.mobile}</td>
                </tr>
            </c:forEach>
        </table>
        <p><a href="javascript:history.back()">Back</a></p>
    </div>
</body>
</html>
