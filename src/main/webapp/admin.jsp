<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="UTF-8" />
        <title>Admin Dashboard</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-style.css" />
        <script src="https://code.iconify.design/iconify-icon/1.0.7/iconify-icon.min.js"></script>
        <link
            href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css" rel="stylesheet"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    </head>
    <body onload="navigateside()">
        <%@include file = "components/navigation.jsp"%>
        <section class="home-section">
            <%@include file = "components/header.jsp"%>

            <div class="home-content">
                <div class="overview-boxes">
                    <div class="box">
                        <div class="right-side">
                            <div class="box-topic">Booking Requests</div>
                            <div class="number">${totalBookingRequests}</div>
                        </div>
                        <i class="bx bx-cart-alt cart"></i>
                    </div>
                    <div class="box">
                        <div class="right-side">
                            <div class="box-topic">Bookings Completed</div>
                            <div class="number">${totalBookingsCompleted}</div>
                        </div>
                        <i class="bx bxs-cart-add cart two"></i>
                    </div>
                </div>
                <div class="overview-boxes">
                    
                    <div class="box">
                        <div class="right-side">
                            <div class="box-topic">Total Distinct Customer Served</div>
                            <div class="number">${totalCustomersServed}</div>
                        </div>
                        <i class="bx bx-user cart three"></i>
                    </div>
                    <div class="box">
                        <div class="right-side">
                            <div class="box-topic">Total Drivers</div>
                            <div class="number">${totalDrivers}</div>
                        </div>
                        <i class="bx bxs-car cart four"></i>
                    </div>
                </div>
                
            </div>
        </section>

        <script>
            let sidebar = document.querySelector(".sidebar");
            let sidebarBtn = document.querySelector(".sidebarBtn");
            sidebarBtn.onclick = function () {
                sidebar.classList.toggle("active");
                if (sidebar.classList.contains("active")) {
                    sidebarBtn.classList.replace("bx-menu", "bx-menu-alt-right");
                } else
                    sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
            };
            function navigateside() {
                document.getElementById("dashboardSidebar").classList.toggle('active');
            }
        </script>
    </body>
</html>
