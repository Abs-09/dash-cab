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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
    LocalDateTime currentDateTime = LocalDateTime.now();

    //When an object is created a connection from the database is intialized
    public UserDao() {
        this.con = Database.getDatabase().getConnection();
    }

    public int getTypebyID(int id) {
        try {
            pst = con.prepareStatement("select type from users where id = ?");
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt("type");
            } else {
                System.out.println("user not found");
                return 0;
            }

        } catch (SQLException ex) {
            System.out.println("Data getType exception occoured");
            System.out.println("Error: " + ex);
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
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
            System.out.println("Data getType exception occoured");
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

    public List<Customer> showAllCustomers() {
        List<Customer> customerList = new ArrayList<>();

        try {
            pst = con.prepareStatement("SELECT * from users where type = 3");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String contact = rs.getString("contact");
                String address = rs.getString("address");
                int enabled = rs.getInt("enabled");
                int type = rs.getInt("type");

                Customer customer = new Customer(id, name, password, email, contact, address, enabled, type);

                customerList.add(customer);
            }
        } catch (SQLException ex) {
            System.out.println("Data showAllCustomer exception occoured");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            closePreparedStatement();
        }

        return customerList;
    }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        pst = con.prepareStatement("delete from users where id = ?;");
        pst.setInt(1, id);

        rowDeleted = pst.executeUpdate() > 0;

        return rowDeleted;
    }

    public void insertCustomer(Customer user) throws SQLException {
        String currentDateTimeAsString = currentDateTime.toString();
        pst = con.prepareStatement("INSERT INTO users" + " (password, name, address, email, contact, type, enabled, created_by, created_at, updated_at) VALUES " + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
        pst.setString(1, user.getPassword());
        pst.setString(2, user.getName());
        pst.setString(3, user.getAddress());
        pst.setString(4, user.getEmail());
        pst.setString(5, user.getContact());
        pst.setInt(6, user.getType());
        pst.setInt(7, user.isEnabled());
        pst.setString(8, "Absal");
        pst.setString(9, currentDateTimeAsString);
        pst.setString(10, currentDateTimeAsString);
        System.out.println(pst);
        pst.executeUpdate();
    }

//    public Customer selectCustomer(int id) throws SQLException {
//        Customer customer = null;
//        // Step 1: Establishing a Connection
//        pst = con.prepareStatement("select id, name, password, email, contact, address, enabled, type from users where id =?;");
//        pst.setInt(1, id);
//        System.out.println(pst);
//        // Step 3: Execute the query or update query
//        ResultSet rs = pst.executeQuery();
//
//        // Step 4: Process the ResultSet object.
//        while (rs.next()) {
//            String name = rs.getString("name");
//            String password = rs.getString("password");
//            String email = rs.getString("email");
//            String contact = rs.getString("contact");
//            String address = rs.getString("address");
//            int enabled = rs.getInt("enabled");
//            int type = rs.getInt("type");
//            customer = new Customer(id, name, password, email, contact, address, enabled, type);
//        }
//
//        return customer;
//    }
    public boolean updateCustomer(Customer user) throws SQLException {
        boolean rowUpdated;
        String currentDateTimeAsString = currentDateTime.toString();
        pst = con.prepareStatement("update users set name = ?, password= ?, address= ?, email= ?, contact= ?, type= ?, enabled= ?, created_by= ?, updated_at= ? where id = ?;");
        pst.setString(1, user.getName());
        pst.setString(2, user.getPassword());
        pst.setString(3, user.getAddress());
        pst.setString(4, user.getEmail());
        pst.setString(5, user.getContact());
        pst.setInt(6, user.getType());
        pst.setInt(7, user.isEnabled());
        pst.setString(8, "Absal");
        pst.setString(9, currentDateTimeAsString);
        pst.setInt(10, user.getId());

        rowUpdated = pst.executeUpdate() > 0;

        return rowUpdated;
    }

//---------------------------------------Driver Cruds-----------------------------------------
    public List<Driver> showAllDrivers() {
        List<Driver> driverList = new ArrayList<>();

        try {
            pst = con.prepareStatement("SELECT * from users where type = 2");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String contact = rs.getString("contact");
                String address = rs.getString("address");
                int enabled = rs.getInt("enabled");
                int type = rs.getInt("type");
                String licenseNumber = rs.getString("license_number");
                int availability = rs.getInt("availability");

                Driver driver = new Driver(id, name, password, email, contact, address, enabled, type, licenseNumber, availability);

                driverList.add(driver);
            }
        } catch (SQLException ex) {
            System.out.println("Data showAllDriver exception occoured");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            closePreparedStatement();
        }

        return driverList;
    }

    public List<Driver> showEnabledAllDrivers() {
        List<Driver> driverList = new ArrayList<>();

        try {
            pst = con.prepareStatement("SELECT * from users where type = 2 AND enabled = 1");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String contact = rs.getString("contact");
                String address = rs.getString("address");
                int enabled = rs.getInt("enabled");
                int type = rs.getInt("type");
                String licenseNumber = rs.getString("license_number");
                int availability = rs.getInt("availability");

                Driver driver = new Driver(id, name, password, email, contact, address, enabled, type, licenseNumber, availability);

                driverList.add(driver);
            }
        } catch (SQLException ex) {
            System.out.println("Data showAllDriver exception occoured");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            closePreparedStatement();
        }

        return driverList;
    }

    public void insertDriver(Driver user) throws SQLException {
        String currentDateTimeAsString = currentDateTime.toString();
        pst = con.prepareStatement("INSERT INTO users" + " (password, name, address, email, contact, type, enabled, license_number, availability, created_by, created_at, updated_at) VALUES " + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
        pst.setString(1, user.getPassword());
        pst.setString(2, user.getName());
        pst.setString(3, user.getAddress());
        pst.setString(4, user.getEmail());
        pst.setString(5, user.getContact());
        pst.setInt(6, user.getType());
        pst.setInt(7, user.isEnabled());
        pst.setString(8, user.getLicenseNumber());
        pst.setInt(9, user.getAvailability());
        pst.setString(10, "Absal");
        pst.setString(11, currentDateTimeAsString);
        pst.setString(12, currentDateTimeAsString);
        System.out.println(pst);
        pst.executeUpdate();
    }

    public User selectUser(int id) throws SQLException {
        User user = null;
        pst = con.prepareStatement("select name, password, email, contact, address, enabled, type, license_number, availability from users where id =?;");
        pst.setInt(1, id);
        System.out.println(pst);
        // Step 3: Execute the query or update query
        ResultSet rs = pst.executeQuery();

        // Step 4: Process the ResultSet object.
        while (rs.next()) {
            String name = rs.getString("name");
            String password = rs.getString("password");
            String email = rs.getString("email");
            String contact = rs.getString("contact");
            String address = rs.getString("address");
            int enabled = rs.getInt("enabled");
            int type = rs.getInt("type");
            String licenseNumber = rs.getString("license_number");
            int availability = rs.getInt("availability");

            // Determine the user type based on the "type" field in the database
            if (type == 3) {
                user = new Customer(id, name, password, email, contact, address, enabled, type);
            } else if (type == 2) {
                user = new Driver(id, name, password, email, contact, address, enabled, type, licenseNumber, availability);
            }else if (type == 1) {
                user = new Admin(id, name, password, email, contact, address, enabled, type);
            }
        }

        return user;
    }

    public boolean updateDriver(Driver user) throws SQLException {
        boolean rowUpdated;
        String currentDateTimeAsString = currentDateTime.toString();
        pst = con.prepareStatement("update users set name = ?, password= ?, address= ?, email= ?, contact= ?, type= ?, enabled= ?, license_number= ?, availability= ?, created_by= ?, updated_at= ? where id = ?;");
        pst.setString(1, user.getName());
        pst.setString(2, user.getPassword());
        pst.setString(3, user.getAddress());
        pst.setString(4, user.getEmail());
        pst.setString(5, user.getContact());
        pst.setInt(6, user.getType());
        pst.setInt(7, user.isEnabled());
        pst.setString(8, user.getLicenseNumber());
        pst.setInt(9, user.getAvailability());
        pst.setString(10, "Absal");
        pst.setString(11, currentDateTimeAsString);
        pst.setInt(12, user.getId());

        rowUpdated = pst.executeUpdate() > 0;

        return rowUpdated;
    }

//--------------------------------------------Admin Cruds--------------------------------------------
    public List<Admin> showAllAdmins() {
        List<Admin> adminList = new ArrayList<>();

        try {
            pst = con.prepareStatement("SELECT * from users where type = 1");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String contact = rs.getString("contact");
                String address = rs.getString("address");
                int enabled = rs.getInt("enabled");
                int type = rs.getInt("type");

                Admin admin = new Admin(id, name, password, email, contact, address, enabled, type);

                adminList.add(admin);
            }
        } catch (SQLException ex) {
            System.out.println("Data showAllCustomer exception occoured");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            closePreparedStatement();
        }

        return adminList;
    }

    public boolean updateAdmin(Admin user) throws SQLException {
        boolean rowUpdated;
        String currentDateTimeAsString = currentDateTime.toString();
        pst = con.prepareStatement("update users set name = ?, password= ?, address= ?, email= ?, contact= ?, type= ?, enabled= ?, created_by= ?, updated_at= ? where id = ?;");
        pst.setString(1, user.getName());
        pst.setString(2, user.getPassword());
        pst.setString(3, user.getAddress());
        pst.setString(4, user.getEmail());
        pst.setString(5, user.getContact());
        pst.setInt(6, user.getType());
        pst.setInt(7, user.isEnabled());
        pst.setString(8, "Absal");
        pst.setString(9, currentDateTimeAsString);
        pst.setInt(10, user.getId());

        rowUpdated = pst.executeUpdate() > 0;

        return rowUpdated;
    }

    private void closePreparedStatement() {
        try {
            this.pst.close();
        } catch (SQLException ex) {
            System.out.println("DataAccessor PreparedStatement close failed");
            Logger.getLogger(CarDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
