/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.mycompany.dash.cab.dao.UserDao;
import com.mycompany.dash.cab.model.Customer;
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
public class CustomerAddServlet extends HttpServlet {

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
        try {
         UserDao dao = new UserDao();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String contact = request.getParameter("contact");
        String address = request.getParameter("address");
        int enabled = Integer.parseInt(request.getParameter("enabled")); // Assuming 0 or 1
		Customer newCustomer = new Customer(0,name, password, email, contact, address, enabled, 3);  // 3 for customer type
        
            dao.insertUser(newCustomer);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerAddServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("CustomerShowServlet");
    }


}
