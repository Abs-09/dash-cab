/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.google.gson.Gson;
import com.mycompany.dash.cab.dao.UserDao;
import com.mycompany.dash.cab.model.Admin;
import com.mycompany.dash.cab.model.Customer;
import com.mycompany.dash.cab.model.Driver;
import com.mycompany.dash.cab.model.User;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 96096
 */
public class UserEditServlet extends HttpServlet {

    private int id = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        User existingUser = null;

        id = Integer.parseInt(request.getParameter("id"));

        try {
            //add other types later
            
                existingUser = dao.selectUser(id);
            

        } catch (SQLException ex) {
            Logger.getLogger(UserEditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        String jsonData = new Gson().toJson(existingUser);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonData);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        int type=0;
        try {
//            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String contact = request.getParameter("contact");
            String address = request.getParameter("address");
            type = Integer.parseInt(request.getParameter("type"));
            int enabled = Integer.parseInt(request.getParameter("enabled")); // Assuming 0 or 1
            String licenseNumber = request.getParameter("licenseNumber");
            int availability = 0;

            if (type == 1) {
                Admin user = new Admin(id, name, password, email, contact, address, enabled, type);  // 3 for customer type
//                dao.updateAdmin(user);
            }

            if (type == 2) {
                Driver user = new Driver(id, name, password, email, contact, address, enabled, type, licenseNumber, availability);  // 2 for driver type
                dao.updateDriver(user);
            }

            if (type == 3) {
                Customer user = new Customer(id, name, password, email, contact, address, enabled, type);
                dao.updateCustomer(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserEditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("type", type);
        RequestDispatcher dispatcher = request.getRequestDispatcher("UserShowServlet");
        dispatcher.forward(request, response);
    }

}
