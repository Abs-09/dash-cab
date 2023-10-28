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
    <body onload="navigateside()">
        <%@include file = "/components/navigation.jsp"%>
        <section class="home-section">
            <%@include file = "/components/header.jsp"%>
            <div class="container">
                <h1>Summary Report</h1>
                <h4>From ${fromdate} to ${todate}</h4>
                <table>
                        <tr>
                            <th>Booking Req ID</th>
                            <th>Driver</th>
                            <th>Customer</th>
                            <th>Scheduled For</th>
                            <th>Pick Up Address</th>
                            <th>Destination Address</th>
                            <th>Completed Date</th>
                            <th>Cost</th>
                            <th>Total Cost</th>
                        </tr>
                        <c:forEach var="completebooking" items="${completebookings}">
                            <tr>
                                <td><c:out value="${completebooking.booking_request_id}" /></td>                                
                                <td><c:out value="${completebooking.driver_name}" /> - <c:out value="${completebooking.driver_id}" /></td>                                
                                <td><c:out value="${completebooking.customer_name}" /> - <c:out value="${completebooking.customer_id}" /></td>
                                <td><c:out value="${completebooking.scheduled_date_time}" /></td>
                                <td><c:out value="${completebooking.pick_up_address}" /></td>
                                <td><c:out value="${completebooking.destination_address}" /></td>
                                <td><c:out value="${completebooking.ride_completed_at}" /></td>
                                <td><c:out value="${completebooking.cost}" /></td>
                                <td><c:out value="${completebooking.total_cost}" /></td>
                            </tr>
                        </c:forEach>
                    </table>
                <div>Total Trips: ${completebookings.size()}</div>                              
                <div>Number of Distinct Customers Served: ${totaluniquecustomers}</div>
            </div>

        </section>

    </body>
</html>