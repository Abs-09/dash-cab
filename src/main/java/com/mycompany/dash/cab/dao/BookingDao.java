/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dash.cab.dao;

import com.mycompany.dash.cab.model.BookingRequest;
import com.mycompany.dash.cab.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookingDao {

    private Connection con;
    private Statement st;
    private PreparedStatement pst;

    //When an object is created a connection from the database is intialized
    public BookingDao() {
        this.con = Database.getDatabase().getConnection();
    }
    
    public List<BookingRequest> getBookingRequests()
    {
        List<BookingRequest> bookingRequests = new ArrayList<>();

        try {
            pst = con.prepareStatement("SELECT * from booking_requests");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String password = rs.getString("password");
//                String email = rs.getString("email");
//                String contact = rs.getString("contact");
//                String address = rs.getString("address");
//                int enabled = rs.getInt("enabled");
//                int type = rs.getInt("type");
//
//                Customer customer = new Customer(id, name, password, email, contact, address, enabled, type);

//                bookingRequests.add(customer);
            }
        } catch (SQLException ex) {
            System.out.println("Data showAllCustomer exception occoured");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            closePreparedStatement();
        }

        return bookingRequests;
    }

    private void closePreparedStatement() {
        try {
            this.pst.close();
        } catch (SQLException ex) {
            System.out.println("DataAccessor PreparedStatement close failed");
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
