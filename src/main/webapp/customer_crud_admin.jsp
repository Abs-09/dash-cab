<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="UTF-8" />
        <title>Customer info</title>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-style.css" />
        <script src="https://code.iconify.design/iconify-icon/1.0.7/iconify-icon.min.js"></script>
        <link
            href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css" rel="stylesheet"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    </head>
    <body>
        <div class="sidebar">
            <div class="logo-details">
                <i class="logo"> <img src="${pageContext.request.contextPath}/img/logoBlack.PNG" alt="logo" width="50px"></i>
                <span class="logo_name">DashCab</span>
            </div>
            <ul class="nav-links">
                <li>
                    <a href="admin.jsp">
                        <i class="bx bx-grid-alt"></i>
                        <span class="links_name">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="#" class="active">
                        <i class="bx bx-list-ul"></i>
                        <span class="links_name">Customers</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="bx bx-box"></i>
                        <span class="links_name">Bookings</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="healthicons:truck-driver-outline"
                           ><iconify-icon
                                icon="healthicons:truck-driver-outline"
                                ></iconify-icon
                            ></i>
                        <span class="links_name">Drivers</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="bx bx-coin-stack"></i>
                        <span class="links_name">Cars</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="bx bx-book-alt"></i>
                        <span class="links_name">User Reports</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="bx bx-user"></i>
                        <span class="links_name">Team</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="bx bx-message"></i>
                        <span class="links_name">Messages</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="bx bx-heart"></i>
                        <span class="links_name">Favrorites</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="bx bx-cog"></i>
                        <span class="links_name">Setting</span>
                    </a>
                </li>
                <li class="log_out">
                    <a href="index.jsp">
                        <i class="bx bx-log-out"></i>
                        <span class="links_name">Log out</span>
                    </a>
                </li>
            </ul>
        </div>
        <section class="home-section">
            <nav>
                <div class="sidebar-button">
                    <i class="bx bx-menu sidebarBtn"></i>
                    <span class="dashboard">Dashboard</span>
                </div>
                <div class="search-box">
                    <input type="text" placeholder="Search..." />
                    <i class="bx bx-search"></i>
                </div>
                <div class="profile-details">
                    <i class="bx bx-user"></i>
                    <span class="admin_name">Ahzam Ahmed Asim</span>

                </div>
            </nav>

            <div class="container">
                <div class="inbox-container">
                    <div class="button-container">
                        <h1>Customer Details</h1>
                        <button class="button" onclick="openPopup()">Add New Customer</button>
                    </div>
                    <table>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Contact</th>
                            <th>Address</th>
                            <th>Actions</th>
                        </tr>
                        <c:forEach var="user" items="${customerList}">
                            <tr>
                                <td><c:out value="${user.id}" /></td>
                                <td><c:out value="${user.name}" /></td>
                                <td><c:out value="${user.email}" /></td>
                                <td><c:out value="${user.contact}" /></td>
                                <td><c:out value="${user.address}" /></td>
                                <td>
                                    <a href="edit?id=<c:out value='${user.id}' />" class="button button-secondary">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
                                        href="CustomerDeleteServlet?id=<c:out value='${user.id}' />" class="button">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>

            <div class="overlay" id="overlay">
                <div class="popup">
                    <h2>Add New Customer</h2>
                    <form action="CustomerAddServlet" method="post">
                        <input type="hidden" id="id" name="id" value="" />

                        <label for="name">Name:</label>
                        <input type="text" id="name" name="name" value="" />

                        <label for="email">Email:</label>
                        <input
                            type="email"
                            id="email"
                            name="email"
                            value=""
                            />

                        <label for="password">password:</label>
                        <input type="password" id="password" name="password" value="" />

                        <label for="contact">Contact:</label>
                        <input type="tel" id="contact" name="contact" value="" />

                        <label for="address">Address:</label>
                        <input type="text" id="address" name="address" value=""/>

                        <label for="enabled">Enabled:</label>
                        <select id="enabled" name="enabled">
                            <option value="0">No</option>
                            <option value="1">Yes</option> 
                        </select>

                        <button type="submit">Save</button>
                        <button type="button" onclick="closePopup()">Cancel</button>
                    </form>
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
            // Function to open the pop-up form
            function openPopup() {

                document.getElementById("overlay").style.display = "flex";
            }

            // Function to close the pop-up form
            function closePopup() {
                document.getElementById("overlay").style.display = "none";
            }
        </script>
    </body>
</html>
