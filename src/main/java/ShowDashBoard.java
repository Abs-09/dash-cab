/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.mycompany.dash.cab.dao.BookingDao;
import com.mycompany.dash.cab.dao.UserDao;
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
public class ShowDashBoard extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookingDao bDao = new BookingDao();
        UserDao uDao = new UserDao();
        
        RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
        request.setAttribute("totalCustomersServed", bDao.getDistictNumberOfCustomersServed());        
        request.setAttribute("totalBookingRequests", bDao.getNumberOfBookingRequests());
        request.setAttribute("totalBookingsCompleted", bDao.getTotalCompletedInvoices());        
        request.setAttribute("totalDrivers", uDao.showTotalNumberOfAllDrivers());


        rd.forward(request, response);
    }

}
