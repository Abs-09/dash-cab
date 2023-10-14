<%-- 
    Document   : success
    Created on : Oct 6, 2023, 8:18:01 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Booking COMPLETED</h1>
        <p>User: ${user.name}</p>
        <p>Booking Request ID ${invoice.booking_request_id}</p>
        <p>Total Cost: ${invoice.total_cost}</p>
        
        <a href="welcome.jsp">Go back</a>
    </body>
</html>
