/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.mycompany.dash.cab.dao.BookingDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author admin
 */
public class ShowCustomersServedReport extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fromDate = request.getParameter("fromdate");
        String toDate = request.getParameter("todate");
        
        BookingDao bDao = new BookingDao();
        List<com.mycompany.dash.cab.model.CompleteBooking> completeBookings = bDao.getCompleteBookingsByDate(fromDate, toDate);
        int totalUniqueCustomersServed = bDao.getDistictNumberOfCustomersServedByDate(fromDate, toDate);
        
        RequestDispatcher rd = request.getRequestDispatcher("reports/customersservedreport.jsp");
        request.setAttribute("completebookings", completeBookings);
        request.setAttribute("totaluniquecustomers", totalUniqueCustomersServed);
        request.setAttribute("todate", toDate);
        request.setAttribute("fromdate", fromDate);
        rd.forward(request, response);
    }

}
