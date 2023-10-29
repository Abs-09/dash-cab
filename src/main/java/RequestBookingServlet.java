/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.mycompany.dash.cab.dao.BookingDao;
import com.mycompany.dash.cab.dao.UserDao;
import com.mycompany.dash.cab.model.BookingRequest;
import com.mycompany.dash.cab.model.Invoice;
import com.mycompany.dash.cab.model.User;
import com.mycompany.dash.cab.service.Calculator;
import com.mycompany.dash.cab.service.CalculatorService;
import com.mycompany.dash.cab.service.Calculator_Service;
import com.mycompany.dash.cab.service.GoogleMapsApiService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 *
 * @author admin
 */
public class RequestBookingServlet extends HttpServlet {

    CalculatorService proxy = new CalculatorService();
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
        response.sendRedirect("bookings/add.jsp");
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
        //assigning attributes from form
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        String pick_up_address = request.getParameter("pick_up_address");
        String destination_address = request.getParameter("destination_address");
        String scheduled_date_time = request.getParameter("date") + " " + request.getParameter("time");

        //creating new object with attributes
        BookingRequest newbookingrequest = new BookingRequest(user_id, pick_up_address, destination_address, scheduled_date_time, 1);

        //inserting to database
        BookingDao bdao = new BookingDao();
        boolean success = bdao.insertBookingRequest(newbookingrequest);

        //getting User
        UserDao udao = new UserDao();
        User user = null;
        try {
            user = udao.selectUser(user_id);
        } catch (SQLException ex) {
            Logger.getLogger(RequestBookingServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (success) {
            try {
                GoogleMapsApiService mapsApi = new GoogleMapsApiService(pick_up_address, destination_address);
                String distanceInString = mapsApi.getDistance();
                double distance = Double.parseDouble(distanceInString);
                
                double cost = proxy.calculateCost(distance);
                double totalCost = proxy.calculateTotalCost(distance);
                
                //getting latest booking request
                BookingRequest bookingrequest = bdao.getLatestBookingRequest();
                //inserting invoice
                Invoice invoice = new Invoice(bookingrequest.getId(), cost, totalCost);
                boolean insertInvoice = bdao.insertInvoice(invoice);
                request.setAttribute("bookingrequest", bookingrequest);
                request.setAttribute("user", user);
                request.setAttribute("distance", distance);
                RequestDispatcher rd = request.getRequestDispatcher("bookingrequests/success.jsp");
                rd.forward(request, response);
            } catch (ParseException ex) {
                request.setAttribute("error", "Something went wrong");
                RequestDispatcher rd = request.getRequestDispatcher("bookingrequests/add.jsp");
                rd.forward(request, response);
                Logger.getLogger(RequestBookingServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            request.setAttribute("error", "Something went wrong");
            RequestDispatcher rd = request.getRequestDispatcher("bookings/add.jsp");
            rd.forward(request, response);
        }

    }

}
