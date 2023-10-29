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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/customer_style.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-style.css" />
        <title>Bookings</title>
        <style>
            .pendingStatus {
                color: red;
                font-weight: bold;
            }

        </style>
    </head>
    <body onload="navigateside()" >
        <%@include file = "/components/header_customer.jsp"%>
        <div class="mainArea">
            <div class="container" style="max-width: 90%;">
                <div class="inbox-container">
                    <div class="button-container">
                        <h1>Bookings</h1>
                        <button class="button" id="filterButton" onclick="toggleBookingDisplay()">Show Pending Bookings</button>
                    </div>
                    <table>
                        <tr>
                            <th>Booking Request ID</th>
                            <th>Booking Created At</th>
                            <th>Ride</th>
                            <th>Payment</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach var="booking" items="${bookings}">
                            <tr>                                
                                <td><c:out value="${booking.booking_request_id}" /></td>
                                <td><c:out value="${booking.created_at}" /></td>
                                <td><c:if test="${booking.ride_complete_at == null}"><span class="pendingStatus">Pending</span></c:if> <c:if test="${booking.ride_complete_at != null}">Completed</c:if></td>
                                <td><c:if test="${booking.paid_at == null}"><span class="pendingStatus">Pending</span></c:if> <c:if test="${booking.paid_at != null}">Paid</c:if></td>
                                <td><a class="button" href="ShowBookingServlet?bookingRequestId=${booking.booking_request_id}">View Booking</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
    <script>
        function toggleBookingDisplay() {
            var rows = document.querySelectorAll('table tr'); // Select all table rows
            var filterButton = document.getElementById('filterButton');

            if (filterButton.innerText === 'Show Pending Bookings') {
                // Show only pending rides
                for (var i = 1; i < rows.length; i++) { // Start from index 1 to skip the table header row
                    var rideStatusCell = rows[i].cells[3]; // 4th cell (Ride status)
                    if (rideStatusCell.textContent.trim() !== 'Pending') {
                        rows[i].style.display = 'none'; // Hide the row
                    }
                }
                filterButton.innerText = 'Show All Bookings';
            } else {
                // Show all bookings
                for (var i = 1; i < rows.length; i++) { // Start from index 1 to skip the table header row
                    rows[i].style.display = ''; // Show the row
                }
                filterButton.innerText = 'Show Pending Bookings';
            }
        }

        function navigateside() {
            document.getElementById("myBookings").classList.toggle('active');
        }
    </script>

</html>
