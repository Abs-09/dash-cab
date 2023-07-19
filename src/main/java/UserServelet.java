/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.mycompany.dash.cab.dao.UserDao;
import com.mycompany.dash.cab.model.Admin;
import com.mycompany.dash.cab.model.User;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class UserServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user;
        int id = Integer.parseInt(request.getParameter("id"));
        String typedPassword = request.getParameter("password");

        PrintWriter out = response.getWriter();
        UserDao dao = new UserDao();

        int type = dao.getType(id);

        if (type == 1) {
            user = dao.getAdmin(id);
        } else if (type == 2) {
            user = dao.getDriver(id);
        } else if (type == 3) {
            user = dao.getCustomer(id);
        } else {
            user = null;
        }

        if (user == null) {
            out.println("<h1>User does not exist</h1>");
        } else {
            if (validatePassword(typedPassword, user.getPassword())) {
                request.setAttribute("user", user);
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.forward(request, response);
            } else {
                out.println("<h1>Incorrect password</h1>");
            }
        }
        
    }

    private boolean validatePassword(String typedPassword, String actualPassword) {
        if(typedPassword.contentEquals(actualPassword)){
            return true;
        } else {
            return false;
        }
    }

}
