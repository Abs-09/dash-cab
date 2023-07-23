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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/welcome_style.css" />
    </head>
    <body>
        <!-- Header -->
        <header class="header">
            <nav class="nav">
                <img src="${pageContext.request.contextPath}/img/logo.PNG" alt="logo" class="nav_logo" width="125px">
                <h2 class="user_name">
                    <%
                        User u1 = (User) request.getAttribute("user");
                        if(u1 != null){
                            out.println("User : "+u1.getName());
                            out.println("  Type : "+u1.getTypeByName());

                        }
                    %>
                </h2>

                <ul class="nav_items">
                    <li class="nav_item">
                        <a href="#" class="nav_link">Home</a>
                        <a href="#" class="nav_link">Product</a>
                    </li>
                </ul> 

                <button class="button" id="form-open" onclick="location.href ='${pageContext.request.contextPath}/index.jsp'">Logout</button>
            </nav>
        </header>

        <!-- Home -->
        <section class="home">
            
        </section>

        <script src="script.js"></script>
    </body>
</html>
