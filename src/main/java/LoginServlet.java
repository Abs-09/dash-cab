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
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");

        UserDao dao = new UserDao();
        User user = dao.selectUserByMail(email);

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        String url = null;
        if (user.getType() == 1) {
            url = "admin.jsp";
        } else {
            url = "welcome.jsp";
        }

        response.sendRedirect(url);
    }

}
