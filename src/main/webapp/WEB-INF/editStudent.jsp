<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Student</title>
    
</head>
<body>
    <h1>Edit Student</h1>
    <form action="updateStudent" method="post">
        <input type="hidden" name="code" value="${param.code}">
        
        <!-- Input field for updating name -->
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${student.name}" required>

    
        <!-- Input field for updating school -->
        <label for="school">School:</label>
        <input type="text" id="school" name="school" value="${student.school}" required>

        <!-- Input field for updating date of birth -->
        <label for="dob">Date of Birth:</label>
        <input type="date" id="dob" name="dob" value="<fmt:formatDate pattern='yyyy-MM-dd' value='${student.dob}' />" required>

        <!-- Input field for updating email -->
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${student.email}" required>

        <!-- Input field for updating mobile -->
        <label for="mobile">Mobile:</label>
        <input type="text" id="mobile" name="mobile" value="${student.mobile}" required>

        <button type="submit">Save Changes</button>
    </form>

    <!-- Back to Home link -->
    <div class="back-link">
        <p><a href="javascript:history.back();history.back()">Back</a></p>
    </div>
</body>
</html>
