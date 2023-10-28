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
                <h1>Reports Section</h1>
                <button><a href="ShowDriverSummaryReportForm"> Driver Summary Report</a</button>
                <button><a href="ShowCustomersServedReportForm"> Customers Served Report</a></button>
            </div>

        </section>

    </body>
</html>