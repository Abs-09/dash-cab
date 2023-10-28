<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>
<div class="navbar">
    <div class="logo-details">
        <i class="logo">
            <img src="${pageContext.request.contextPath}/img/logo.PNG" alt="logo">
        </i>
        <span class="logo_name">DashCab</span>
    </div>
    <div class="nav-list" >
        <ul>
            <li id="currBook" class="list-item">
                <b class="left-curve"></b>
                <b class="right-curve"></b>
                <a href="/dash-cab/welcome.jsp">Welcome</a>
            </li>
            <c:if test="${user.type == 3}">
                <li  id="bookRide" class="list-item">
                    <b class="left-curve"></b>
                    <b class="right-curve"></b>
                    <a href="/dash-cab/RequestBookingServlet">BOOK A RIDE</a>
                </li>
                <li id="bookHistory" class="list-item">
                    <b class="left-curve"></b>
                    <b class="right-curve"></b>
                    <a href="/dash-cab/BookingRequestsServlet">My Booking Requests</a>
                </li>
            </c:if>
            <li id="myBookings" class="list-item">
                <b class="left-curve"></b>
                <b class="right-curve"></b>
                <a href="/dash-cab/BookingsServlet">My Bookings</a>
            </li>
        </ul>
    </div>
    <div class="profile-details">
        <%
            if (session == null || session.getAttribute("user") == null) {
                response.sendRedirect("index.jsp");
            }
        %>
        <span class="admin_name">${user.name}</span>
        <a class="logout-button" href="/dash-cab/LogoutServlet" style="text-decoration:none;">Logout</a>
    </div>
</div>