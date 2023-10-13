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
            </div>
        </section>
        <<script>
            function navigateside() {
                document.getElementById("bookingReqSidebar").classList.toggle('active');
                document.getElementById("mainName").textContent = "Booking Requests";
            }
        </script>
    </body>
</html>