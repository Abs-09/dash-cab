<%-- 
    Document   : index
    Created on : Sep 26, 2023, 9:05:30 PM
    Author     : Absal
--%>

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
        <style>

            /*            .popup form {
                            display: block;
                        }*/

            .reportcontainer {
                max-width: 800px;
                margin: 0 auto;
                padding: 20px;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                border-radius: 5px;
            }
            h1 {
                font-size: 24px;
                margin: 0 0 20px;
            }
            .report-button {
                display: block;
                margin: 10px 0;
                padding: 15px;
                background-color: #C29908;
                color: #fff;
                text-align: center;
                text-decoration: none;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s;
                width: 100%; /* Set the width to 100% to make the button expand horizontally */
            }
            .report-button:hover {
                background-color: #e8c74e;
                color: #000;
            }
        </style>
    </head>
    <body>
        <%@include file = "/components/navigation.jsp"%>
        <section class="home-section">
            <%@include file = "/components/header.jsp"%>
            <div class="container">
                <div class="reportcontainer">
                    <h1>Reports Section</h1>
                    <a class="report-button" href="ShowDriverSummaryReportForm"> Driver Summary & Turnover Report</a>
                    <a class="report-button" href="ShowCustomersServedReportForm"> Customers Served Report</a>
                </div>
            </div>
            <div class="overlay" id="overlay">
                <div class="popup">
                    <h2 id="FormHeading">Summary Report Form</h2>
                    <form action="ShowDriverSummaryReport" method="POST" id="popUpForm"> 

                        <div class="input-box">

                            <input type="radio" id="Single" name="all_drivers" value="0" checked>
                            <label id="SingleLabel" for="Single">Selected Driver Report</label><br>
                        </div>
                        <div class="input-box">
                            <input type="radio" id="All" name="all_drivers" value="1">
                            <label id="AllLabel" for="All">All Drivers Report</label>
                        </div>
                        <label id="driver_idLabel" for="driver_id">Select Driver</label>
                        <select id="driver_id" name="driver_id" required>
                            <c:forEach var="driver" items="${drivers}">
                                <option value="${driver.id}">${driver.name}</option>
                            </c:forEach>
                        </select>
                        <label for="fromdate">Select Starting Date</label>
                        <input id="fromdate" type="date" placeholder="From Date" name="fromdate" required>

                        <label for="todate">Select End Date</label>
                        <input id="todate" type="date" placeholder="To Date" name="todate" required>

                        <button class="" type="submit">Generate Report</button>
                        <a  href="ShowReportsMenuServlet"><button type="button" onclick="closePopup()">CLose</button></a>

                        <div class="remember-forgot">
                            <!--showing the error message in here-->
                            <span style="color: red; margin-left: 22px; font-weight: bold">${error}</span>
                        </div>

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

            // Add an event listener to the radio buttons
            
            const FormHeading = document.getElementById("FormHeading");
            const allDriversRadio = document.getElementById("All");
            const SingleDriversRadio = document.getElementById("Single");
            const allDriversLabel = document.getElementById("AllLabel");
            const SingleDriversLabel = document.getElementById("SingleLabel");
            const selectDriverDropdown = document.getElementById("driver_id");
            const selectDriverLabel = document.getElementById("driver_idLabel");
            const overlay = document.getElementById("overlay");
            const popUpForm = document.getElementById("popUpForm");
            

            allDriversRadio.addEventListener("change", function () {
                if (allDriversRadio.checked) {
                    // If the "All Drivers" radio button is checked, hide the dropdown
                    selectDriverDropdown.style.display = "none";
                    selectDriverLabel.style.display = "none";
                }
                if (SingleDriversRadio.checked) {
                    // If the "All Drivers" radio button is not checked, show the dropdown
                    selectDriverDropdown.style.display = "block";
                    selectDriverLabel.style.display = "block";
                }
            });

            SingleDriversRadio.addEventListener("change", function () {
                if (SingleDriversRadio.checked) {
                    // If the "All Drivers" radio button is not checked, show the dropdown
                    selectDriverDropdown.style.display = "block";
                    selectDriverLabel.style.display = "block";
                }
            });


            window.addEventListener('load', function () {
                // Check for the request attribute from url to show the overlay
                var showOverlay = <%= request.getAttribute("showOverlay") %>; // Assuming JSP syntax
                if (showOverlay === true) {
                    popUpForm.action= "ShowDriverSummaryReport";
                    FormHeading.textContent= "Summary Report Form";
                    overlay.style.display = "flex";
                } else if (showOverlay === false) {
                    allDriversRadio.style.display = "none";
                    SingleDriversRadio.style.display = "none";
                    allDriversLabel.style.display = "none";
                    SingleDriversLabel.style.display = "none";
                    selectDriverDropdown.style.display = "none";
                    selectDriverDropdown.removeAttribute("required");
                    selectDriverLabel.style.display = "none";
                    popUpForm.action= "ShowCustomersServedReport";
                    FormHeading.textContent= "Customers Served Form";
                    overlay.style.display = "flex";
                }

            });

            window.addEventListener('load', function () {
                document.getElementById("ReportsSidebar").classList.toggle('active');
                document.getElementById("mainName").textContent = "Reports";
            });

        </script>
    </body>
</html>