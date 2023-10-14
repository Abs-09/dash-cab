<%-- 
    Document   : welcome
    Created on : Jul 19, 2023, 5:53:14 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.dash.cab.model.Admin"%>
<%@page import="com.mycompany.dash.cab.model.User"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/customer_style.css" />
    </head>
<body onload="navigateside()" >
        <%@include file = "/components/header_customer.jsp"%>
        <div class="mainArea">
            <div class="container" style="max-width: 90%;">
                <p>Nothing here yet</p>
            </div>
        </div>
    </body>
    <script>
        function navigateside() {
            document.getElementById("currBook").classList.toggle('active');
        }
    </script>
</html>
