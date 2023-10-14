
<div class="navbar">
    <div class="logo-details">
        <i class="logo">
            <img src="${pageContext.request.contextPath}/img/logo.PNG" alt="logo">
        </i>
        <span class="logo_name">DashCab</span>
    </div>
    <div class="nav-list" >
        <ul>
            <li  id="bookRide" class="list-item">
                <b class="left-curve"></b>
                <b class="right-curve"></b>
                <a href="RequestBookingServlet">BOOK A RIDE</a>
            </li>
            <li id="currBook" class="list-item">
                <b class="left-curve"></b>
                <b class="right-curve"></b>
                <a href="/dash-cab/welcome.jsp">Current Booking</a>
            </li>
            <li id="bookHistory" class="list-item">
                <b class="left-curve"></b>
                <b class="right-curve"></b>
                <a href="/dash-cab/BookingRequestsServlet">Booking History</a>
            </li>
        </ul>
    </div>
    <div class="profile-details">
        <%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("index.jsp");
    }   
        %>
        <span class="admin_name">${user.name}</span>
        <a class="logout-button" href="/dash-cab/LogoutServlet" style="text-decoration:none;">Logout</a>
    </div>
</div>