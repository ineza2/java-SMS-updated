<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Registration Form</title>
</head>
<body>
    <div class="container">
        <h1>Student Registration Form</h1>
        <form action="<%= request.getContextPath() %>/studentregister" method="post">
            <table>
                <tr>
                    <td>Code</td>
                    <td><input type="number" name="code" /></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" /></td>
                </tr>
                <tr>
                    <td>School</td>
                    <td><input type="text" name="school" /></td>
                </tr>
                <tr>
                    <td>Dob</td>
                    <td><input type="date" name="dob" /></td>
                </tr>
                 <tr>
                    <td>Email</td>
                    <td><input type="email" name="email" /></td>
                </tr>
                <tr>
    <td>Mobile</td>
    <td><input type="text" name="mobile" pattern="[0-9]{10}" title="Please enter a 10-digit number" /></td>
</tr>

            </table>
            <input type="submit" value="Submit" />
            <p><a href="javascript:history.back()">Back to Home</a></p>
        </form>
        
    </div>
</body>
</html>
