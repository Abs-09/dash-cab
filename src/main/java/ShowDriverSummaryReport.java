/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.mycompany.dash.cab.dao.BookingDao;
import com.mycompany.dash.cab.dao.UserDao;
import com.mycompany.dash.cab.model.CompleteBooking;
import com.mycompany.dash.cab.model.User;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class ShowDriverSummaryReport extends HttpServlet {

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
    }

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
        // getting params
        int driver_id = Integer.parseInt(request.getParameter("driver_id"));
        String fromDate = request.getParameter("fromdate");
        String toDate = request.getParameter("todate");
        int generateForAllDrivers = Integer.parseInt(request.getParameter("all_drivers"));

        //getting list and total number of unique customers served
        BookingDao bDao = new BookingDao();
        List<CompleteBooking> completeBookings = null;
        int totalUniqueCustomersServed = 0;
        if (generateForAllDrivers == 1) {
            completeBookings = bDao.getCompleteBookingsByDate(fromDate, toDate);
            totalUniqueCustomersServed = bDao.getDistictNumberOfCustomersServedByDate(fromDate, toDate);
        } else {
            completeBookings = bDao.getCompleteBookingsByDriverAndDate(driver_id, fromDate, toDate);
            totalUniqueCustomersServed = bDao.getDistictNumberOfCustomersServedByDriverAndDate(driver_id, fromDate, toDate);
        }

        //getting total cost
        double totalCost = calculateTotalCost(completeBookings);

        RequestDispatcher rd = request.getRequestDispatcher("reports/driversummaryreport.jsp");
        request.setAttribute("completebookings", completeBookings);
        request.setAttribute("totaluniquecustomers", totalUniqueCustomersServed);
        request.setAttribute("todate", toDate);
        request.setAttribute("fromdate", fromDate);
        request.setAttribute("totalcost", totalCost);
        rd.forward(request, response);

    }

    public double calculateTotalCost(List<CompleteBooking> completebookings) {
        double total = 0;
        for (CompleteBooking completeBooking : completebookings) {
            total += completeBooking.getTotal_cost();
        }
        return total;
    }

}
