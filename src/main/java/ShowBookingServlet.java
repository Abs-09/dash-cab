/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.mycompany.dash.cab.dao.BookingDao;
import com.mycompany.dash.cab.dao.UserDao;
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
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class ShowBookingServlet extends HttpServlet {

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
        try {
            BookingDao brDao = new BookingDao();
            UserDao uDao = new UserDao();
            BookingRequest bookingRequest = (BookingRequest) brDao.getBookingRequestByID(Integer.parseInt(request.getParameter("bookingRequestId")));
            request.setAttribute("bookingrequest", bookingRequest);
            Booking booking = (Booking) brDao.getBookingByID(Integer.parseInt(request.getParameter("bookingRequestId")));
            request.setAttribute("booking", booking);
            User bookedUser = uDao.selectUser(bookingRequest.getUser_id());
            request.setAttribute("bookedUser", bookedUser);
            User bookedDriver = uDao.selectUser(booking.getDriver_id());
            request.setAttribute("bookedDriver", bookedDriver);

            String url= null;
            if (user.getType() == 1) {
                url = "/bookings/show.jsp";
            } else {
                url = "/bookings/showmy.jsp";
            }
            
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(AcceptOrRejectBookingRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
