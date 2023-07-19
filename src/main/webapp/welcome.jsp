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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>This is the welcome page</h1>
        <%
            Admin u1 = (Admin) request.getAttribute("user");
            out.println("<h1>"+u1.getName()+"</h1>");
        %>
    </body>
</html>
