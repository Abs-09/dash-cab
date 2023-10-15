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
        <style>
          body {
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        h1 {
            margin: 0;
        }
        main {
            flex-grow: 1;
            max-width: 100%;
            background-color: #fff;
            padding: 20px;
            box-sizing: border-box;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }
        h2, p {
            text-align: center;
        }
        footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 10px 0;
            width: 100%;
        }
        </style>
    </head>
    <body onload="navigateside()" >
        <%@include file = "/components/header_customer.jsp"%>

       

        <main>
            <h2>WELCOME TO DASHCAB</h2>
            <p>Your convenience is our priority.</p>
        </main>

        <footer>
            <p>&copy; All rights reserved.</p>
        </footer>

    </body>
    <script>
        function navigateside() {
            document.getElementById("currBook").classList.toggle('active');
        }
    </script>
</html>
