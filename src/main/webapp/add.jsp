<%-- 
    Document   : add.jsp
    Created on : Aug 21, 2023, 7:11:27 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="/CarAddServlet" method="POST">
            <label for="license_plate">text</label>
            <input id="license_plate" type="text" name="license_plate"/>
            
            <label for="model">text</label>
            <input id="model" type="text" name="model"/>
            
            <button type="submit">Submit</button>
        </form>
    </body>
</html>
