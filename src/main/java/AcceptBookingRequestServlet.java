/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.mycompany.dash.cab.dao.BookingDao;
import com.mycompany.dash.cab.model.Booking;
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
public class AcceptBookingRequestServlet extends HttpServlet {

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
        //retriving form  attributes
        int status = Integer.parseInt(request.getParameter("status"));
        int booking_request_id = Integer.parseInt(request.getParameter("booking_request_id"));
        int driver_id = Integer.parseInt("driver_id");

        BookingDao bDao = new BookingDao();
        boolean setStatusSuccess = bDao.setBookingRequestStatus(booking_request_id, status);

        if (!setStatusSuccess) {
            response.sendRedirect("AcceptOrRejectBookingRequest?bookingRequestId=" + Integer.toString(booking_request_id) + "&error=Something Went wrong. Contact IT admin");
        }

        //creates a booking
        Booking booking = new Booking(booking_request_id, driver_id);
        boolean insertBookingSuccess = bDao.insertBooking(booking);

        if (!insertBookingSuccess) {
            response.sendRedirect("AcceptOrRejectBookingRequest?bookingRequestId=" + Integer.toString(booking_request_id) + "&error=Something Went wrong. Contact IT admin");
        } else {
            response.sendRedirect("AcceptOrRejectBookingRequest?bookingRequestId=" + Integer.toString(booking_request_id) + "&error=Rejected");
        }

    }

}
