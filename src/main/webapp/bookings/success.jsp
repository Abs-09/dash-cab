<%-- 
    Document   : success
    Created on : Oct 6, 2023, 8:18:01 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Booking Confirmation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            text-align: center;
            margin: 0;
            padding: 0;
        }

        .container {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            margin: 20px auto;
            padding: 20px;
            max-width: 400px;
        }

        h1 {
            color: #0074cc;
        }

        p {
            margin: 10px 0;
        }

        a {
            text-decoration: none;
            background-color: #0074cc;
            color: #fff;
            padding: 10px 20px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Booking COMPLETED</h1>
        <p><strong>User:</strong> ${user.name}</p>
        <p><strong>Booking Request ID:</strong> ${invoice.booking_request_id}</p>
        <p><strong>Total Cost:</strong> ${invoice.total_cost}</p>
        
        <a href="welcome.jsp">Go back</a>
    </div>
</body>
</html>
