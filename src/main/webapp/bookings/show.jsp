
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>page</title>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/booking-style.css" />
        <link rel="stylesheet" href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css" />

        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    </head>
    <body>
        <div class="container" style="max-width: 800px;">
            <a href="/dash-cab/BookingsServlet" class="back-button"><i class="bx bx-arrow-back"></i> Back to Booking List</a>
            <div class="booking-details">
                <h1>Booking Details</h1>
                <p><strong>Id:</strong> ${bookingrequest.id}</p>                
                <p><strong>USER ID:</strong> ${bookingrequest.user_id}</p>
                <p><strong>USER Name:</strong> ${bookedUser.name}</p>
                <p><strong>Pick up from:</strong> ${bookingrequest.pick_up_address}</p>
                <p><strong>Drop Off To:</strong> ${bookingrequest.destination_address}</p>
                <p><strong>Scheduled For:</strong> ${bookingrequest.scheduled_date_time}</p>
                <p><strong>Status:</strong> ${bookingrequest.status}</p>
                <p><strong>Requested At:</strong> ${bookingrequest.created_at}</p>
                <p><strong>Assigned Driver:</strong> ${booking.driver_id} - ${bookedDriver.name}</p>
                <p><strong>Cancelled:</strong> ${booking.cancelled_at}</p>
                <p><strong>Ride Completed:</strong> ${booking.ride_complete_at}</p>
                <p><strong>Paid:</strong> ${booking.paid_at}</p></br>
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

    </body>
</html>