
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>
<nav>
    <div class="sidebar-button">
        <i class="bx bx-menu sidebarBtn"></i>
        <span id="mainName" class="dashboard">Dashboard</span>
    </div>
    <div class="search-box">
        <input type="text" placeholder="Search..." />
        <i class="bx bx-search"></i>
    </div>
    <div class="profile-details">
        <i class="bx bx-user"></i>
        <%
            if (session == null) {
                response.sendRedirect("index.jsp");
            }   
        %>

        <span class="admin_name">${user.name}</span>
    </div>
</nav>