
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>page</title>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-style.css" />
        <script src="https://code.iconify.design/iconify-icon/1.0.7/iconify-icon.min.js"></script>
        <link
            href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css" rel="stylesheet"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    </head>
    <body>
        <section class="home-section">
            <div>
                <h1>Booking</h1>
                <h3>Details</h3>
                <p>Id: ${bookingrequest.id}</p>                
                <p>USER ID: ${bookingrequest.user_id}</p>
                <p>USER Name: ${bookedUser.name}</p>
                <p>Pick up from: ${bookingrequest.pick_up_address}</p>
                <p>Drop Off To: ${bookingrequest.destination_address}</p>
                <p>Scheduled For: ${bookingrequest.scheduled_date_time}</p>
                <p>Status: ${bookingrequest.status}</p>
                <p>Requested At: ${bookingrequest.created_at}</p>
                <p>Assigned Driver: ${booking.driver_id} - ${bookedDriver.name}</p>
                <p>Ride Completed: ${booking.ride_complete_at}</p>
                <p>Paid: ${booking.paid_at}</p></br>
                <c:if test="${booking.ride_complete_at == null && booking.cancelled_at == null && user.type == 2}"><a href="CompleteBooking?bookingRequestId=${bookingrequest.id}">Mark Ride as Paid and Completed</a></c:if>
                <div class="remember-forgot">
                    <span style="color: red; margin-left: 22px; font-weight: bold">${error}</span>
                </div>

                <% 
                    if(request.getParameter("error") != null) {
                        out.write(request.getParameter("error"));
                    }
                %>
            </div>
        </section>
    </body>
</html>