/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.mycompany.dash.cab.dao.BookingDao;
import com.mycompany.dash.cab.model.Booking;
import com.mycompany.dash.cab.model.BookingRequest;
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
public class BookingsServlet extends HttpServlet {


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
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        BookingDao dao = new BookingDao();
        List<Booking> bookings;

        if (user.getType() == 1) {
            bookings = dao.getBookings();
            request.setAttribute("UserID", user.getId());
            request.setAttribute("bookings", bookings);
            RequestDispatcher rd = request.getRequestDispatcher("bookings/masterindex.jsp");
            rd.forward(request, response);
        }

        if (user.getType() == 3) {
            bookings = dao.getBookingsByUserID(user.getId());
            request.setAttribute("UserID", user.getId());
            request.setAttribute("bookings", bookings);
            RequestDispatcher rd = request.getRequestDispatcher("bookings/myindex.jsp");
            rd.forward(request, response);
        }
        
        if (user.getType() == 2) {
            bookings = dao.getBookingsByDriverID(user.getId());
            request.setAttribute("UserID", user.getId());
            request.setAttribute("bookings", bookings);
            RequestDispatcher rd = request.getRequestDispatcher("bookings/myindex.jsp");
            rd.forward(request, response);
        }
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
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
