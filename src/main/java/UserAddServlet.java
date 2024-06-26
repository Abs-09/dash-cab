/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.mycompany.dash.cab.dao.UserDao;
import com.mycompany.dash.cab.model.Admin;
import com.mycompany.dash.cab.model.Customer;
import com.mycompany.dash.cab.model.Driver;
import com.mycompany.dash.cab.model.User;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
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
public class UserAddServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws jakarta.servlet.ServletException
     * @throws SQLException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int type = 0;
        String error = null; // Initialize error message to null
        try {
            UserDao dao = new UserDao();
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String contact = request.getParameter("contact");
            String address = request.getParameter("address");
            type = Integer.parseInt(request.getParameter("type"));
            System.out.println("Type: " + type);
            int enabled = Integer.parseInt(request.getParameter("enabled")); // Assuming 0 or 1
            String licenseNumber = request.getParameter("licenseNumber");
            int availability = 0;

            int existing_user_type = dao.getType(email);

            if (existing_user_type == 1 || existing_user_type == 2 || existing_user_type == 3) {
                error = "Email already exists.";
            } else {
                if (type == 1) {
                    Customer user = new Customer(0, name, password, email, contact, address, enabled, type);  // 3 for customer type
                dao.insertCustomer(user);
                }

                if (type == 2) {
                    Driver user = new Driver(0, name, password, email, contact, address, enabled, type, licenseNumber, availability);  // 3 for customer type
                    dao.insertDriver(user);
                }

                if (type == 3) {
                    Customer user = new Customer(0, name, password, email, contact, address, enabled, type);  // 3 for customer type
                    dao.insertCustomer(user);
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserAddServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("type", type);
        request.setAttribute("error", error);
        RequestDispatcher dispatcher = request.getRequestDispatcher("UserShowServlet");
        dispatcher.forward(request, response);
    }

}
