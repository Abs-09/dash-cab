/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dash.cab.dao;

import com.mycompany.dash.cab.model.Admin;
import com.mycompany.dash.cab.model.Customer;
import com.mycompany.dash.cab.model.Driver;
import com.mycompany.dash.cab.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class UserDao {

    private Connection con;
    private Statement st;
    private PreparedStatement pst;

    //When an object is created a connection from the database is intialized
    public UserDao() {
        this.con = Database.getDatabase().getConnection();
    }

    public int getType(String email) {
        try {
            pst = con.prepareStatement("select * from users where email = ?");
            pst.setString(1, email);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt("type");
            } else {
                System.out.println("user not found");
                return 0;
            }

        } catch (SQLException ex) {
            System.out.println("Data getAdmin exception occoured");
            System.out.println("Error: " + ex);
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public Admin getAdmin(String email) {
        try {
            pst = con.prepareStatement("select * from users where email = ?");
            pst.setString(1, email);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return new Admin(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getString("email"), rs.getString("contact"), rs.getString("address"), rs.getInt("enabled"), rs.getInt("type"));
            } else {
                System.out.println("user not found");
                return null;
            }

        } catch (SQLException ex) {
            System.out.println("Data getAdmin exception occoured");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Driver getDriver(String email) {
        try {
            pst = con.prepareStatement("select * from users where email = ?");
            pst.setString(1, email);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return new Driver(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getString("email"), rs.getString("contact"), rs.getString("address"), rs.getInt("enabled"), rs.getInt("type"), rs.getString("license_number"), rs.getInt("availability"));
            } else {
                System.out.println("user not found");
                return null;
            }

        } catch (SQLException ex) {
            System.out.println("Data getDriver exception occoured");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Customer getCustomer(String email) {
        try {
            pst = con.prepareStatement("select * from users where email = ?");
            pst.setString(1, email);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getString("email"), rs.getString("contact"), rs.getString("address"), rs.getInt("enabled"), rs.getInt("type"));
            } else {
                System.out.println("user not found");
                return null;
            }

        } catch (SQLException ex) {
            System.out.println("Data getCustomer exception occoured");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
