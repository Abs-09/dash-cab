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
        <h1>All my booking request here</h1>
        <a href="RequestBookingServlet">Book a Ride</a>
        <div>
            User ID ${UserID}
            <table>
                <tr>
                    <th>ID</th>
                    <th>user_id</th>
                    <th>pick up</th>
                    <th>destination</th>
                    <th>time</th>
                    <th>request made at</th>
                </tr>
                <c:forEach var="bookingRequest" items="${bookingRequests}">
                    <tr>
                    <td><c:out value="${bookingRequest.id}" /></td>
                    <td><c:out value="${bookingRequest.user_id}" /></td>
                    <td><c:out value="${bookingRequest.pick_up_address}" /></td>
                    <td><c:out value="${bookingRequest.destination_address}" /></td>
                    <td><c:out value="${bookingRequest.scheduled_date_time}" /></td>
                    <td><c:out value="${created_at}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
