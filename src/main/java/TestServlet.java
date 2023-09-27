/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TravelMode;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Absal
 */
public class TestServlet extends HttpServlet {

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
        String apiKey = "AIzaSyAd3T6I7teyv_qI3Dy6nJf4sSw93vYb_Dk";
        
        // Create a GeoApiContext with your API key
        GeoApiContext context = new GeoApiContext.Builder()
            .apiKey(apiKey)
            .build();
        
               // Define the origin and destination for the directions
        String origin = "New York, NY";
        String destination = "Los Angeles, CA";
        
        try {
            // Create a DirectionsApiRequest
            DirectionsApiRequest mapsrequest = DirectionsApi.newRequest(context)
                .origin(origin)
                .destination(destination)
                .mode(TravelMode.DRIVING); // You can change the travel mode

            // Execute the request and get the result
            DirectionsResult result = mapsrequest.await();
            
            // Print the directions result
            System.out.println(result.routes[0].summary);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("test.jsp");
        dispatcher.forward(request, response);
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
