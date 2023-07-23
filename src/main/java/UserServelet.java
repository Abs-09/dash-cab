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
        String email = request.getParameter("email");
        String typedPassword = request.getParameter("password");

        PrintWriter out = response.getWriter();
        UserDao dao = new UserDao();

        int type = dao.getType(email);

        if (type == 1) {
            user = dao.getAdmin(email);
        } else if (type == 2) {
            user = dao.getDriver(email);
        } else if (type == 3) {
            user = dao.getCustomer(email);
        } else {
            user = null;
        }

        if (user == null) {
//            out.println("<h1>User does not exist</h1>");  this one now changed to login page
            
//           user not found print in the login page (index.jsp)
            request.setAttribute("error", "User does not exist");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
                
                
        } else {
            if (validatePassword(typedPassword, user.getPassword())) {
                request.setAttribute("user", user);
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.forward(request, response);
            } else {
//                out.println("<h1>Incorrect password</h1>");  this one now changed to login page

//                Incorrect password error print in the login page (index.jsp)
                request.setAttribute("error", "Incorrect password");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
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
