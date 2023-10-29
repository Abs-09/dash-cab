
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>
<nav>
    <div class="sidebar-button">
        <i class="bx bx-menu sidebarBtn"></i>
        <span id="mainName" class="dashboard">Dashboard</span>
    </div>
    <div class="profile-details">
        <i class="bx bx-user"></i>
        <%
            if (session == null || session.getAttribute("user") == null) {
                response.sendRedirect("index.jsp");
            }  
        %>

        <span class="admin_name">${user.name}</span>
    </div>
</nav>