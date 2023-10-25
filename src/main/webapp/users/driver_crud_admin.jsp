<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="UTF-8" />
        <title>Driver info</title>
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


            <div class="container">
                <div class="inbox-container">
                    <div class="button-container">
                        <h1>Driver Details</h1>
                        <button class="button" onclick="openEditPopup(null)">Add New Driver</button>
                    </div>
                    <table>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>License</th>
                            <th>Email</th>
                            <th>Contact</th>
                            <th>Address</th>
                            <th>Actions</th>
                        </tr>
                        <c:forEach var="user" items="${userList}">
                            <tr>
                                <td><c:out value="${user.id}" /></td>
                                <td><c:out value="${user.name}" /></td>
                                <td><c:out value="${user.licenseNumber}" /></td>
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
                    <h2 id="popupTitle" >Add New Driver</h2>
                    <form id="userForm" action="UserAddServlet" method="post" onsubmit="return validateForm()">
                        <input type="hidden" id="id" name="id" value="" />
                        <input type="hidden" id="type" name="type" value="2" />
                        <input type="hidden" id="availability" name="availability" value="0" /> <!<!-- Deafult availability as No(0) -->

                        <label for="name">Name:</label>
                        <input type="text" id="name" name="name" value="" />

                        <label for="licenseNumber">License:</label>
                        <input type="text" id="licenseNumber" name="licenseNumber" value="" />

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

                        <label for="nothing"></label>
                        <div class="remember-forgot">
                            <span id="error" style="color: red; margin-left: 22px; font-weight: bold">${error}</span>
                        </div>

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
                    document.getElementById("popupTitle").textContent = "Editing Driver: " + id;


                    fetch('UserEditServlet?' + new URLSearchParams({id: id, type: type}))
                            .then(response => response.json())
                            .then(data => {
                                document.getElementById("name").value = data.name;
                                document.getElementById("email").value = data.email;
                                document.getElementById('email').readOnly = true;
                                document.getElementById("password").value = data.password;
                                document.getElementById("contact").value = data.contact;
                                document.getElementById("address").value = data.address;
                                document.getElementById("enabled").value = data.enabled;
                                document.getElementById("licenseNumber").value = data.licenseNumber;
                                // Show the popup
                                document.getElementById('overlay').style.display = "flex";
                            });
                } else {
                    // Reset fields for adding new customer
                    document.getElementById("id").value = "";
                    document.getElementById("name").value = "";
                    document.getElementById("email").value = "";
                    document.getElementById('email').readOnly = false;
                    document.getElementById("password").value = "";
                    document.getElementById("contact").value = "";
                    document.getElementById("address").value = "";
                    document.getElementById("enabled").value = "";
                    document.getElementById("licenseNumber").value = "";

                    document.getElementById("userForm").action = "UserAddServlet";
                    document.getElementById("popupTitle").textContent = "Add New Driver";
                    // Show the popup
                    document.getElementById('overlay').style.display = "flex";
                }

            }


            // Automatically open the popup if there's an error
            window.addEventListener('load', function () {
                var errorMessage = document.getElementById("error").textContent;

                if (errorMessage.trim() !== "") {
                    document.getElementById('overlay').style.display = "flex";
                }

            });

            window.addEventListener('load', function () {
                document.getElementById("driverSidebar").classList.toggle('active');
                document.getElementById("mainName").textContent = "Drivers";
            });

            function validateForm() {
                var name = document.getElementById("name").value;
                var email = document.getElementById("email").value;
                var password = document.getElementById("password").value;
                var contact = document.getElementById("contact").value;
                var address = document.getElementById("address").value;
                var enabled = document.getElementById("enabled").value;
                var licenseNumber = document.getElementById("licenseNumber").value;

                // Check if all fields are null or empty
                if (name.trim() === "" || email.trim() === "" || password.trim() === "" || contact.trim() === "" || address.trim() === "" || enabled.trim === "" || licenseNumber.trim === "") {
                    // Display an error message
                    document.getElementById('error').textContent = "All fields required.";
                    return false; // Prevent form submission
                }
                if (!/^\d+$/.test(contact)) {
                    document.getElementById('error').textContent = "Enter a valid contact";
                    return false; // Prevent form submission
                }

                // If the form is valid, clear any previous error message and allow submission
                document.getElementById('error').textContent = "";
                return true;
            }
        </script>
    </body>
</html>
