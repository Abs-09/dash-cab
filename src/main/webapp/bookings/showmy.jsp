

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Booking Details</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/booking-style.css" />
    <link rel="stylesheet" href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAd3T6I7teyv_qI3Dy6nJf4sSw93vYb_Dk"></script>

</head>
<body>
    <div class="container">
        <a href="/dash-cab/BookingsServlet" class="back-button"><i class="bx bx-arrow-back"></i> Back to Booking List</a>
        <h1>Booking Details</h1>
        <div id="map"></div>
        <div class="booking-details">
            <p><strong>Booking ID:</strong> ${bookingrequest.id}</p>
            <p><strong>User ID:</strong> ${bookingrequest.user_id}</p>
            <p><strong>User Name:</strong> ${bookedUser.name}</p>
            <p><strong>Pickup Address:</strong> ${bookingrequest.pick_up_address}</p>
            <p><strong>Destination Address:</strong> ${bookingrequest.destination_address}</p>
            <p><strong>Scheduled For:</strong> ${bookingrequest.scheduled_date_time}</p>
            <p><strong>Status:</strong> ${bookingrequest.status}</p>
            <p><strong>Requested At:</strong> ${bookingrequest.created_at}</p>
            <p><strong>Assigned Driver:</strong> ${booking.driver_id} - ${bookedDriver.name}</p>
            <p><strong>Ride Completed:</strong> ${booking.ride_complete_at}</p>
            <p><strong>Paid:</strong> ${booking.paid_at}</p>
        </div>
        <c:if test="${booking.ride_complete_at == null && booking.cancelled_at == null && user.type == 2}">
            <a href="CompleteBooking?bookingRequestId=${bookingrequest.id}" class="complete-booking-button">Mark Ride as Paid and Completed</a>
        </c:if>
        <div class="error-message">
            ${error}
        </div>
        <% 
            if (request.getParameter("error") != null) {
                out.write(request.getParameter("error"));
            }
        %>
    </div>
    <script>
        function initMap() {
            var map = new google.maps.Map(document.getElementById('map'), {
                center: {lat: 0, lng: 0}, // Center the map at a default location
                zoom: 6
            });

            var directionsService = new google.maps.DirectionsService;
            var directionsDisplay = new google.maps.DirectionsRenderer;
            directionsDisplay.setMap(map);

            var origin = "${bookingrequest.pick_up_address}"; // Replace with your origin
            var destination = "${bookingrequest.destination_address}"; // Replace with your destination

            var request = {
                origin: origin,
                destination: destination,
                travelMode: 'DRIVING'
            };

            directionsService.route(request, function(response, status) {
                if (status === 'OK') {
                    directionsDisplay.setDirections(response);
                } else {
                    alert('Directions request failed due to ' + status);
                }
            });
        }
        // Initialize the map when the page loads
        initMap();
    </script>
</body>
</html>
