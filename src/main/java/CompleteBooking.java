/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.mycompany.dash.cab.dao.BookingDao;
import com.mycompany.dash.cab.model.Invoice;
import jakarta.servlet.RequestDispatcher;

/**
 *
 * @author admin
 */
public class CompleteBooking extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int bookingRequestID = Integer.parseInt(request.getParameter("bookingRequestId"));
        BookingDao bDao = new BookingDao();
        boolean completeSuccess = bDao.setBookingCompletedAt(bookingRequestID);
        boolean paidSuccess = bDao.setBookingPaidAt(bookingRequestID);

        //change here
        if (completeSuccess && paidSuccess) {
            Invoice invoice = new Invoice(bookingRequestID, 412.00);
            boolean insertInvoice = bDao.insertInvoice(invoice);

            if (insertInvoice) {
                request.setAttribute("error", "Successfull");                
                request.setAttribute("invoice", invoice);
                RequestDispatcher rd = request.getRequestDispatcher("bookings/success.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("error", "Something went wrong with inserting booking request");
                RequestDispatcher rd = request.getRequestDispatcher("ShowBookingServelet?bookingRequestId="+request.getParameter("bookingRequestId"));
                rd.forward(request, response);
            }
        } else {
            request.setAttribute("error", "Something went wrong with setting completed or paid");
            RequestDispatcher rd = request.getRequestDispatcher("ShowBookingServelet?bookingRequestId="+request.getParameter("bookingRequestId"));
            rd.forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
