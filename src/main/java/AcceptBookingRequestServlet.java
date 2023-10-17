/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.mycompany.dash.cab.dao.BookingDao;
import com.mycompany.dash.cab.model.Booking;
import com.mycompany.dash.cab.model.BookingRequest;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

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
        int driver_id = Integer.parseInt(request.getParameter("driver_id"));
        BookingDao bDao = new BookingDao();
        BookingRequest requestedBooking = bDao.getBookingRequestByID(booking_request_id);
        //check for booking request collision
        boolean bookingCollides = doesBookingRequestsCollision(requestedBooking, driver_id);
        System.out.println("booking collides = " + bookingCollides);
        if(bookingCollides) {
            System.out.println("Inside booking collide");
            response.sendRedirect("AcceptOrRejectBookingRequest?bookingRequestId=" + Integer.toString(booking_request_id) + "&error=Booking Collision for the selected driver");
            return;
        }

        boolean setStatusSuccess = bDao.setBookingRequestStatus(booking_request_id, status);
        if (!setStatusSuccess) {
            response.sendRedirect("AcceptOrRejectBookingRequest?bookingRequestId=" + Integer.toString(booking_request_id) + "&error=Something Went wrong. Contact IT admin");
            return;
        }

        //creates a booking
        Booking booking = new Booking(booking_request_id, driver_id);
        boolean insertBookingSuccess = bDao.insertBooking(booking);

        if (!insertBookingSuccess) {
            response.sendRedirect("AcceptOrRejectBookingRequest?bookingRequestId=" + Integer.toString(booking_request_id) + "&error=Something Went wrong. Contact IT admin");
            return;
        } else {
            response.sendRedirect("AcceptOrRejectBookingRequest?bookingRequestId=" + Integer.toString(booking_request_id) + "&error=Driver Assigned");
        }

    }

    protected boolean doesBookingRequestsCollision(BookingRequest requestedBooking, int requested_driver_id) {
        System.out.println("Inside booking collide");
        String requestedDateInString = requestedBooking.getScheduled_date_time();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime requestedDate = LocalDateTime.parse(requestedDateInString, formatter);

        BookingDao bdao = new BookingDao();
        List<Booking> bookings = bdao.getActiveBookingsByDriverID(requested_driver_id);
        for (Booking booking : bookings) {
            BookingRequest relatedBookingRequest = bdao.getBookingRequestByID(booking.getBooking_request_id());
            String bookingScheduledDate = relatedBookingRequest.getScheduled_date_time();
            LocalDateTime relatedBookingRequestScheduleDateTime = LocalDateTime.parse(bookingScheduledDate, formatter);
            System.out.println("Reqesuted Date: " + requestedDate);            
            System.out.println("Booking Scheduled Date: " + relatedBookingRequestScheduleDateTime);

            // Compare dateTimeA with dateTimeB
            long hoursDifference = ChronoUnit.HOURS.between(requestedDate, relatedBookingRequestScheduleDateTime);
            System.out.println("TIme DIfference: " + hoursDifference);
            if (hoursDifference == 0) {
                System.out.println("dateTimeA is more than 1 hour less than dateTimeB.");
                return true;
            }
        }
        return false;
    }

}
