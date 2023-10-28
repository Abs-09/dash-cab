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
    </head>
    <body onload="navigateside()">
        <%@include file = "/components/navigation.jsp"%>
        <section class="home-section">
            <%@include file = "/components/header.jsp"%>
            <div class="container">
                <h1>Summary Report Form</h1>
                <form action="ShowDriverSummaryReport" method="POST"> 

                    <label for="driver_id">Select Driver</label>
                    <select id="driver_id" name="driver_id" required>
                        <c:forEach var="driver" items="${drivers}">
                            <option value="${driver.id}">${driver.name}</option>
                        </c:forEach>
                    </select>
                    <div class="input-box">
                        <input type="date" placeholder="From Date" name="fromdate" required>
                    </div>
                    <div class="input-box">
                        <input type="date" placeholder="To Date" name="todate" required>
                    </div>
                    <div class="input-box">
                        <div>Generate Report For?</div>
                        <input type="radio" id="html" name="all_drivers" value="0" checked>
                        <label for="html">Selected Driver Only</label><br>
                        <input type="radio" id="css" name="all_drivers" value="1">
                        <label for="css">All Drivers</label><br>
                    </div>
                    <button class="" type="submit">Generate Report</button>

                    <div class="remember-forgot">
                        <!--showing the error message in here-->
                        <span style="color: red; margin-left: 22px; font-weight: bold">${error}</span>
                    </div>

                </form>
            </div>

        </section>

    </body>
</html>