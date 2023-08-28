/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.google.gson.Gson;
import com.mycompany.dash.cab.dao.UserDao;
import com.mycompany.dash.cab.model.Customer;
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
public class CustomerEditServlet extends HttpServlet {
    
    private int id = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        Customer existingCustomer = null;

        id = Integer.parseInt(request.getParameter("id"));

        try {
            existingCustomer = dao.selectCustomer(id);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerEditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        String jsonData = new Gson().toJson(existingCustomer);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonData);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerShowServlet");
//        request.setAttribute("user", existingCustomer);
//        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        try {
//            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String contact = request.getParameter("contact");
            String address = request.getParameter("address");
            int enabled = Integer.parseInt(request.getParameter("enabled")); // Assuming 0 or 1
            int type = 3;

            Customer customer = new Customer(id, name, password, email, contact, address, enabled, type);

            dao.updateUser(customer);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerEditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("CustomerShowServlet");
    }

}
