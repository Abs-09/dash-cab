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
        <title>page</title>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-style.css" />
        <script src="https://code.iconify.design/iconify-icon/1.0.7/iconify-icon.min.js"></script>
        <link
            href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css" rel="stylesheet"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    </head>
    <script>
        function calculateDaysLeft(scheduledTime) {
            var currentTime = new Date();
            var scheduledDate = new Date(scheduledTime);
            var daysLeft = Math.floor((scheduledDate - currentTime) / (1000 * 60 * 60 * 24));
            return daysLeft;
        }

        function displayDaysLeft(scheduledTime) {
            var daysLeft = calculateDaysLeft(scheduledTime);

            if (daysLeft < 0) {
                return "<span style='color: red;'><strong>Overdue</strong></span>";
            } else if (daysLeft <= 5) {
                return "<span style='color: orange;'><strong>" + daysLeft + " days</strong></span>";
            } else {
                return "<span style='color: green;'><strong>" + daysLeft + " days</strong></span>";
            }
        }
    </script>
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
                            <th>ID</th>
                            <th>Customer ID</th>
                            <th>Scheduled time</th>
                            <th>Days left</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach var="bookingRequest" items="${bookingRequests}">
                            <tr>
                                <td><c:out value="${bookingRequest.id}" /></td>
                                <td><c:out value="${bookingRequest.user_id}" /></td>
                                <td><c:out value="${bookingRequest.scheduled_date_time}" /></td>
                                <td>
                                    <script>
                                        var scheduledTime = "<c:out value="${bookingRequest.scheduled_date_time}" />";
                                        document.write(displayDaysLeft(scheduledTime));
                                    </script>
                                </td>
                                <td><c:if test="${bookingRequest.status == 1}"><a class="button" href="AcceptOrRejectBookingRequest?bookingRequestId=${bookingRequest.id}">Assign Driver</a></c:if>
                                <c:if test="${bookingRequest.status == 2}">Driver Assigned</c:if>
                                <c:if test="${bookingRequest.status == 3}">Rejected</c:if></td>
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