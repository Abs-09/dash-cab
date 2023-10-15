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
        <title>Booking Requests</title>
    </head>
    <body onload="navigateside()" >
        <%@include file = "/components/header_customer.jsp"%>
        <div class="mainArea">
            <div class="container" style="max-width: 90%;">
                <div class="inbox-container">
                    <div class="button-container">
                        <h1>My Booking Requests</h1>
                    </div>
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
            </div>
        </div>
    </body>
    <script>
        function navigateside() {
            document.getElementById("bookHistory").classList.toggle('active');
        }
    </script>
</html>
