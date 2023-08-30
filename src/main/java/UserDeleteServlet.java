/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.mycompany.dash.cab.dao.UserDao;
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
public class UserDeleteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = null;
        try {
            UserDao dao = new UserDao();
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deleteUser(id);
            
            //Write other types here
            
            if(dao.getTypebyID(id) == 3) {
                url = "UserShowServlet";
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        response.sendRedirect(url);
    }
}
