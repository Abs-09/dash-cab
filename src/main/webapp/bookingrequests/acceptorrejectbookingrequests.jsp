
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
        <%@include file = "/components/navigation.jsp"%>
        <section class="home-section">
            <%@include file = "/components/header.jsp"%>

            <div>
                <h1>title</h1>                
                <h1>-------------</h1>
                <h1>Accept OR Reject Booking Request</h1>
                <h3>Booking Request Detail</h3>
                <p>Id: ${bookingrequest.id}</p>                
                <p>USER ID: ${bookingrequest.user_id}</p>
                <p>USER Name: ${bookedUser.name}</p>
                <p>Pick up from: ${bookingrequest.pick_up_address}</p>
                <p>Drop Off To: ${bookingrequest.destination_address}</p>
                <p>Scheduled For: ${bookingrequest.scheduled_date_time}</p>
                <p>Status: ${bookingrequest.status}</p>
                <p>Requested At: ${bookingrequest.created_at}</p></br>
                <form action="AcceptBookingRequestServlet" method="post">
                    <input type="hidden" name="booking_request_id" value="${bookingrequest.id}">
                    <label for="driver_id">Assign Driver</label>
                    <select id="driver_id" name="driver_id" required>
                        <c:forEach var="driver" items="${drivers}">
                            <option value="${driver.id}">${driver.name}</option>
                        </c:forEach>
                    </select>
                    <input type="hidden" name="status" value="2"></br>
                    <button type="submit">ACcept</button>
                </form>
                <form action="RejectBookingRequestServlet" method="post">
                    <input type="hidden" name="booking_request_id" value="${bookingrequest.id}">
                    <input type="hidden" name="status" value="3">
                    <button type="submit">Reject</button>
                </form>
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