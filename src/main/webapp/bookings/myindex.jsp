<%-- 
    Document   : index
    Created on : Sep 26, 2023, 9:05:30 PM
    Author     : Absal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>All my bookings here</h1>
        <div>
            User ID ${UserID}
            <table>
                <tr>
                    <th>Booking Request ID</th>                           
                    <th>driver id</th>
                    <th>Booking Created At</th>
                    <th>cancelled</th>
                    <th>Ride Completed</th>
                    <th>Paid at</th>
                </tr>
                <c:forEach var="booking" items="${bookings}">
                    <tr>                                
                        <td><c:out value="${booking.booking_request_id}" /></td>
                        <td><c:out value="${booking.driver_id}" /></td>
                        <td><c:out value="${booking.created_at}" /></td>
                        <td><c:out value="${booking.cancelled_at}" /></td>
                        <td><c:out value="${booking.ride_complete_at}" /></td>                                
                        <td><c:out value="${booking.paid_at}" /></td>
                        <td><a href="ShowBookingServlet?bookingRequestId=${booking.booking_request_id}">View Booking</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
