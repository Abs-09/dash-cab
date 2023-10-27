/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.mycompany.dash.cab.dao.BookingDao;
import com.mycompany.dash.cab.model.Booking;
import com.mycompany.dash.cab.model.Invoice;
import com.mycompany.dash.cab.model.User;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author admin
 */
public class InvoicesServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        BookingDao dao = new BookingDao();
        List<Invoice> invoices;

        if (user.getType() == 1) {
            invoices = dao.getCompletedInvoices();
            request.setAttribute("UserID", user.getId());
            request.setAttribute("invoices", invoices);
            RequestDispatcher rd = request.getRequestDispatcher("invoices/masterindex.jsp");
            rd.forward(request, response);
        }

//        if (user.getType() == 3) {
//            invoices = dao.getBookingsByUserID(user.getId());
//            request.setAttribute("UserID", user.getId());
//            request.setAttribute("bookings", bookings);
//            RequestDispatcher rd = request.getRequestDispatcher("bookings/myindex.jsp");
//            rd.forward(request, response);
//        }
//        
//        if (user.getType() == 2) {
//            bookings = dao.getBookingsByDriverID(user.getId());
//            request.setAttribute("UserID", user.getId());
//            request.setAttribute("bookings", bookings);
//            RequestDispatcher rd = request.getRequestDispatcher("bookings/myindex.jsp");
//            rd.forward(request, response);
//        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


}
