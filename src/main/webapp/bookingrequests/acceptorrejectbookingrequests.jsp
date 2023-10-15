
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>page</title>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/booking-style.css" />
        <link
            href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css" rel="stylesheet"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    </head>
    <body>
        <div class="container" style="max-width: 800px;">
            <a href="/dash-cab/BookingRequestsServlet" class="back-button"><i class="bx bx-arrow-back"></i> Back to Booking List</a>
            <h1>Accept OR Reject Booking Request</h1>
            <h3>Booking Request Detail</h3>
            <div class="booking-details">
                <p>Id: ${bookingrequest.id}</p>                
                <p>USER ID: ${bookingrequest.user_id}</p>
                <p>USER Name: ${bookedUser.name}</p>
                <p>Pick up from: ${bookingrequest.pick_up_address}</p>
                <p>Drop Off To: ${bookingrequest.destination_address}</p>
                <p>Scheduled For: ${bookingrequest.scheduled_date_time}</p>
                <p>Status: ${bookingrequest.status}</p>
                <p>Requested At: ${bookingrequest.created_at}</p></br>
                <div class="form-container">
                    <form action="AcceptBookingRequestServlet" method="post">
                        <input type="hidden" name="booking_request_id" value="${bookingrequest.id}">
                        <label for="driver_id">Assign Driver</label>
                        <select id="driver_id" name="driver_id" required>
                            <c:forEach var="driver" items="${drivers}">
                                <option value="${driver.id}">${driver.name}</option>
                            </c:forEach>
                        </select>
                        <input type="hidden" name="status" value="2"></br>
                        <button class="accept-button" type="submit">Accept</button>
                    </form>
                    <form action="RejectBookingRequestServlet" method="post">
                        <input type="hidden" name="booking_request_id" value="${bookingrequest.id}">
                        <input type="hidden" name="status" value="3">
                        <button class="reject-button" type="submit">Reject</button>
                    </form>
                </div>
                <div class="error-message">
                    ${error}
                </div>

                <% 
                    if(request.getParameter("error") != null) {
                        out.write(request.getParameter("error"));
                    }
                %>
            </div>
        </div>
    </body>
</html>