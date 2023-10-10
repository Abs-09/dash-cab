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
    <body onload="navigateside()">
        <%@include file = "/components/navigation.jsp"%>
        <section class="home-section">
            <%@include file = "/components/header.jsp"%>

            <div class="container">
                <div class="inbox-container">
                    <div class="button-container">
                        <h1>Customer Details</h1>
                        <button class="button" onclick="openEditPopup(null)">Add New Customer</button>
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
                        <c:forEach var="user" items="${userList}">
                            <tr>
                                <td><c:out value="${user.id}" /></td>
                                <td><c:out value="${user.name}" /></td>
                                <td><c:out value="${user.email}" /></td>
                                <td><c:out value="${user.contact}" /></td>
                                <td><c:out value="${user.address}" /></td>
                                <td>
                                    <a class="button button-secondary" onclick="openEditPopup(<c:out value='${user.id}' />, <c:out value='${user.type}' />)" >Edit</a>
                                    <a href="UserDeleteServlet?id=<c:out value='${user.id}' />" class="button">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>

            <div class="overlay" id="overlay">
                <div class="popup">
                    <h2 id="popupTitle" >Add New Customer</h2>
                    <form id="userForm" action="UserAddServlet" method="post">
                        <input type="hidden" id="id" name="id" value="" />
                        
                        <input type="hidden" id="type" name="type" value="3" />
                        
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


            // Function to close the pop-up form
            function closePopup() {
                document.getElementById("overlay").style.display = "none";
            }


            function openEditPopup(id) {
                if (id !== null) {
                    document.getElementById("userForm").action = "UserEditServlet";
                    document.getElementById("popupTitle").textContent = "Editing User: " + id;
                    

                    fetch('UserEditServlet?' + new URLSearchParams({id: id, type: type}))
                            .then(response => response.json())
                            .then(data => {
                                document.getElementById("name").value = data.name;
                                document.getElementById("email").value = data.email;
                                document.getElementById("password").value = data.password;
                                document.getElementById("contact").value = data.contact;
                                document.getElementById("address").value = data.address;
                                document.getElementById("enabled").value = data.enabled;
                                // Show the popup
                                document.getElementById('overlay').style.display = "flex";
                            });
                } else {
                    // Reset fields for adding new customer
                    document.getElementById("id").value = "";
                    document.getElementById("name").value = "";
                    document.getElementById("email").value = "";
                    document.getElementById("password").value = "";
                    document.getElementById("contact").value = "";
                    document.getElementById("address").value = "";
                    document.getElementById("enabled").value = "";

                    document.getElementById("userForm").action = "UserAddServlet";
                    document.getElementById("popupTitle").textContent = "Add New Customer";
                    // Show the popup
                    document.getElementById('overlay').style.display = "flex";
                }

            }
            function navigateside() {
               document.getElementById("customerSidebar").classList.toggle('active');
               document.getElementById("mainName").textContent="Customers";
            }
        </script>
    </body>
</html>
