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
        //getting parameters from view
        String email = request.getParameter("email");
        String typedPassword = request.getParameter("password");

        PrintWriter out = response.getWriter();
        
        UserDao dao = new UserDao();

        int type = dao.getType(email);

        //Return Admin || Driver || Customer type object
        if (type == 1) {
            user = dao.getAdmin(email);
        } else if (type == 2) {
            user = dao.getDriver(email);
        } else if (type == 3) {
            user = dao.getCustomer(email);
        } else {
            user = null;
        }

        //Validation
        if (user == null || validatePassword(typedPassword, user.getPassword()) ) {
            request.setAttribute("error", "User or password is incorrect ");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("user", user);
            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
            rd.forward(request, response);
           
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
