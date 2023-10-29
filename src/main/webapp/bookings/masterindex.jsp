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
        <meta charset="UTF-8" />
        <title>Bookings</title>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-style.css" />
        <script src="https://code.iconify.design/iconify-icon/1.0.7/iconify-icon.min.js"></script>
        <link
            href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css" rel="stylesheet"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <style>
            .pendingStatus {
                color: red;
                font-weight: bold;
            }

        </style>
    </head>
    <body onload="navigateside()">
        <%@include file = "/components/navigation.jsp"%>
        <section class="home-section">
            <%@include file = "/components/header.jsp"%>
            <div class="container">
                <div class="inbox-container">
                    <div class="button-container">
                        <h1>Bookings</h1>
                    </div>
                    <table>
                        <tr>
                            <th>Booking Request ID</th>                           
                            <th>driver id</th>
                            <th>Ride Completed</th>
                            <th>Paid at</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach var="booking" items="${bookings}">
                            <tr>                                
                                <td><c:out value="${booking.booking_request_id}" /></td>
                                <td><c:out value="${booking.driver_id}" /></td>
                                <td><c:if test="${booking.ride_complete_at == null}"><span class="pendingStatus">Pending</span></c:if> <c:if test="${booking.ride_complete_at != null}">Completed</c:if></td>
                                <td><c:if test="${booking.paid_at == null}"><span class="pendingStatus">Pending</span></c:if> <c:if test="${booking.paid_at != null}">Paid</c:if></td>
                                <td><a class="button" href="ShowBookingServlet?bookingRequestId=${booking.booking_request_id}">View Booking</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </section>
        <<script>
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
                document.getElementById("bookingSidebar").classList.toggle('active');
                document.getElementById("mainName").textContent = "Booking Requests";
            }
        </script>
    </body>
</html>