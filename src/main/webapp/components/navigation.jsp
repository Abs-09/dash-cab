
<div class="sidebar">
    <div class="logo-details">
        <i class="logo"> <img src="${pageContext.request.contextPath}/img/logoBlack.PNG" alt="logo" width="50px"></i> 
        <span class="logo_name">DashCab</span>
    </div>
    <ul class="nav-links">
        <li>
            <a href="admin.jsp" id="dashboardSidebar" class="menu-link">
                <i class="bx bx-grid-alt"></i>
                <span class="links_name">Dashboard</span>
            </a>
        </li>
        <li>
            <a href="UserShowServlet?type=3" id="customerSidebar" class="menu-link">
                <i class="bx bx-list-ul"></i>
                <span class="links_name">Customers</span>
            </a>
        </li>
        <li>
            <a href="UserShowServlet?type=2" id="driverSidebar" class="menu-link">
                <i class="healthicons:truck-driver-outline"><iconify-icon icon="healthicons:truck-driver-outline"></iconify-icon></i>
                <span class="links_name">Drivers</span>
            </a>
        </li>
        <li>
            <a href="BookingRequestsServlet" id="bookingReqSidebar" class="menu-link">
                <i class="bx bx-box"></i>
                <span class="links_name">Booking Requests</span>
            </a>
        </li>
        <li>
            <a href="BookingsServlet" id="bookingSidebar" class="menu-link">
                <i class="bx bx-box"></i>
                <span class="links_name">Booking</span>
            </a>
        </li>
        <li>
            <a href="InvoicesServlet" id="invoiceSidebar" class="menu-link">
                <i class="bx bx-box"></i>
                <span class="links_name">Invoices</span>
            </a>
        </li>
        <li>
            <a href="ShowReportsMenuServlet" id="ReportsSidebar" class="menu-link">
                <i class="bx bx-book-alt"></i>
                <span class="links_name">Reports</span>
            </a>
        </li>
        <li>
            <a href="UserShowServlet?type=1" id="adminSidebar" class="menu-link">
                <i class="bx bx-user"></i>
                <span class="links_name">Team</span>
            </a>
        </li>
        <li class="log_out">
            <a href="LogoutServlet">
                <i class="bx bx-log-out"></i>
                <span class="links_name">Log out</span>
            </a>
        </li>
    </ul>
</div>
