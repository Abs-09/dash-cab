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
        <h1>Booking SUCCESS</h1>
        <p>User: ${user.name}</p>
        <p>Pick Up: ${bookingrequest.pick_up_address}</p>
        <p>Destination: ${bookingrequest.destination_address}</p>
        <p>Date & Time: ${bookingrequest.scheduled_date_time}</p>
        <p>Amount: ${distance}</p>
        
        <a href="BookingRequestsServlet">Go back</a>
    </body>
</html>
