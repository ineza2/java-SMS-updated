<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Guest</title>
    <style>

        .dashboard-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 20px;
            max-width: 300px;
            margin: 20px auto;
        }

        .see-students {
            margin-top: 20px;
            padding: 10px;
            background-color: #3498db;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
            display: inline-block; /* Display as inline block */
            width: 100%; /* Take the full width of its container */
            box-sizing: border-box;
            transition: background-color 0.3s ease;
        }

        .see-students:hover {
            background-color: #2980b9;
        }

        .logout-button {
            margin-top: 20px;
            padding: 10px;
            background-color: #e74c3c;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        .logout-button:hover {
            background-color: #c0392b;
        }
    </style>
</head>
<body>
    <h1>Welcome to the Guest Dashboard</h1>

    <div class="dashboard-container">
        <h2>As a guest you can only</h2>
        <!-- Your dashboard content goes here -->

        <!-- See Students button -->
        <a href="students" class="see-students">See Students</a>

        <!-- Logout button -->
    <button class="logout-button" onclick="location.href='logout'">Logout</button>
    </div>

  
</body>
</html>
