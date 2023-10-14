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
        <title>Booking Requests</title>
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
                            <h1>Pending Booking Requests</h1>
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
                                    <td><c:if test="${bookingRequest.status == 1}"><a href="#">Assign Driver</a></c:if></td>
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