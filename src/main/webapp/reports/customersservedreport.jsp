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
        <script src="https://code.iconify.design/iconify-icon/1.0.7/iconify-icon.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/report-style.css" />
        <link
            href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css" rel="stylesheet"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    </head>
    <body>
        <div class="header">
            <a class="back-button" href="ShowReportsMenuServlet"><span>&#8592;</span> Back</a>
            <h1 class="report-title">Summary Report</h1>
        </div>

        <div class="container">
            <h4>From <span id="fromdate">${fromdate}</span> to <span id="todate">${todate}</span></h4>

            <table class="report-table">
                <thead>
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
                </thead>
                <tbody id="report-data">
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
                </tbody>
            </table>

            <div class="summary">
                <div>Total Trips: <span id="total-trips">${completebookings.size()}</span></div>
                <div>Number of Distinct Customers Served: <span id="distinct-customers">${totaluniquecustomers}</span></div>
            </div>
        </div>
    </body>
</html>