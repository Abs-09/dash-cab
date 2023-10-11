/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.mycompany.dash.cab.dao.BookingDao;
import com.mycompany.dash.cab.dao.UserDao;
import com.mycompany.dash.cab.model.BookingRequest;
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
public class AcceptOrRejectBookingRequest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            BookingDao brDao = new BookingDao();
            UserDao uDao = new UserDao();
            BookingRequest bookingRequest = (BookingRequest) brDao.getBookingRequestByID(Integer.parseInt(request.getParameter("bookingRequestId")));
            request.setAttribute("bookingrequest", bookingRequest);
            User bookedUser = uDao.selectUser(bookingRequest.getUser_id());
            request.setAttribute("bookedUser", bookedUser);
            List drivers = uDao.showEnabledAllDrivers();
            request.setAttribute("drivers", drivers);
            RequestDispatcher rd = request.getRequestDispatcher("/bookingrequests/acceptorrejectbookingrequests.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AcceptOrRejectBookingRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getParameter(LEGACY_DO_HEAD);

    }

}
