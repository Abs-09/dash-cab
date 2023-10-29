/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dash.cab.dao;

import com.mycompany.dash.cab.model.Booking;
import com.mycompany.dash.cab.model.BookingRequest;
import com.mycompany.dash.cab.model.CompleteBooking;
import com.mycompany.dash.cab.model.Customer;
import com.mycompany.dash.cab.model.Invoice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookingDao {

    private Connection con;
    private Statement st;
    private PreparedStatement pst;
    LocalDateTime currentDateTime = LocalDateTime.now();

    //When an object is created a connection from the database is intialized
    public BookingDao() {
        this.con = Database.getDatabase().getConnection();
    }

    // BOOKING REQUESTS ==========================================
    //get all booking requsts from db
    public int getNumberOfBookingRequests() {
        int count = 0;

        try {
            pst = con.prepareStatement("SELECT * from booking_requests order by id desc;");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                count++;
            }

        } catch (SQLException ex) {
            System.out.println("Data showAllCustomer exception occoured");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            closePreparedStatement();
        }

        return count;
    }

    //get all booking requsts from db
    public List<BookingRequest> getBookingRequests() {
        List<BookingRequest> bookingRequests = new ArrayList<>();

        try {
            pst = con.prepareStatement("SELECT * from booking_requests order by id desc;");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                String pick_up_address = rs.getString("pick_up_address");
                String destination_address = rs.getString("destination_address");
                String scheduled_date_time = rs.getString("scheduled_date_time");
                int status = rs.getInt("status");
                String created_at = rs.getString("created_at");

                BookingRequest bookingRequest = new BookingRequest(id, user_id, pick_up_address, destination_address, scheduled_date_time, status, created_at);

                bookingRequests.add(bookingRequest);
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

    //get all booking requsts from db by id
    public List<BookingRequest> getBookingRequestsByID(int input_id) {
        List<BookingRequest> bookingRequests = new ArrayList<>();

        try {
            pst = con.prepareStatement("SELECT * from booking_requests WHERE user_id = ? order by id desc");
            pst.setString(1, Integer.toString(input_id));
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                String pick_up_address = rs.getString("pick_up_address");
                String destination_address = rs.getString("destination_address");
                String scheduled_date_time = rs.getString("scheduled_date_time");
                int status = rs.getInt("status");
                String created_at = rs.getString("created_at");

                BookingRequest bookingRequest = new BookingRequest(id, user_id, pick_up_address, destination_address, scheduled_date_time, status, created_at);

                bookingRequests.add(bookingRequest);

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

    public BookingRequest getLatestBookingRequest() {
        BookingRequest bookingRequest = null;
        try {
            pst = con.prepareStatement("SELECT * from booking_requests ORDER BY id DESC LIMIT 1;");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                String pick_up_address = rs.getString("pick_up_address");
                String destination_address = rs.getString("destination_address");
                String scheduled_date_time = rs.getString("scheduled_date_time");
                int status = rs.getInt("status");
                String created_at = rs.getString("created_at");

                bookingRequest = new BookingRequest(id, user_id, pick_up_address, destination_address, scheduled_date_time, status, created_at);

            }
        } catch (SQLException ex) {
            System.out.println("Data showAllCustomer exception occoured");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            closePreparedStatement();
        }

        return bookingRequest;
    }

    //get a booking requst from db by id
    public BookingRequest getBookingRequestByID(int input_id) {
        BookingRequest bookingRequest = null;
        try {
            pst = con.prepareStatement("SELECT * from booking_requests WHERE id = ?");
            pst.setString(1, Integer.toString(input_id));
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                String pick_up_address = rs.getString("pick_up_address");
                String destination_address = rs.getString("destination_address");
                String scheduled_date_time = rs.getString("scheduled_date_time");
                int status = rs.getInt("status");
                String created_at = rs.getString("created_at");

                bookingRequest = new BookingRequest(id, user_id, pick_up_address, destination_address, scheduled_date_time, status, created_at);

            }
        } catch (SQLException ex) {
            System.out.println("Data showAllCustomer exception occoured");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            closePreparedStatement();
        }

        return bookingRequest;
    }

    //Adding booking request to database
    public boolean insertBookingRequest(BookingRequest br) {
        String currentDateTimeAsString = currentDateTime.toString();
        try {
            pst = con.prepareStatement("INSERT INTO booking_requests" + " (user_id, pick_up_address, destination_address, scheduled_date_time, status, created_at) VALUES " + "(?, ?, ?, ?, ?, ?);");
            pst.setString(1, Integer.toString(br.getUser_id()));
            pst.setString(2, br.getPick_up_address());
            pst.setString(3, br.getDestination_address());
            pst.setString(4, br.getScheduled_date_time());
            pst.setString(5, Integer.toString(br.getStatus()));
            pst.setString(6, currentDateTimeAsString);
            System.out.println(pst);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //Adding booking request to database
    public boolean setBookingRequestStatus(int booking_request_id, int status) {
        String currentDateTimeAsString = currentDateTime.toString();
        try {
            pst = con.prepareStatement("UPDATE booking_requests SET status = ? WHERE id = ?;");
            pst.setString(1, Integer.toString(status));
            pst.setString(2, Integer.toString(booking_request_id));
            System.out.println(pst);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //BOOKINGS =============================
    public List<Booking> getBookings() {
        List<Booking> bookings = new ArrayList<>();

        try {
            pst = con.prepareStatement("SELECT * from bookings order by booking_request_id desc;");
            ResultSet rs = pst.executeQuery();
            System.out.println("");
            while (rs.next()) {
                int booking_request_id = rs.getInt("booking_request_id");
                int driver_id = rs.getInt("driver_id");
                String cancelled_at = rs.getString("cancelled_at");
                String ride_complete_at = rs.getString("ride_completed_at");
                String paid_at = rs.getString("paid_at");
                String created_at = rs.getString("created_at");

                Booking booking = new Booking(booking_request_id, driver_id, cancelled_at, ride_complete_at, paid_at, created_at);

                bookings.add(booking);
            }
        } catch (SQLException ex) {
            System.out.println("Data showAllCustomer exception occoured");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            closePreparedStatement();
        }

        return bookings;
    }

    //get all booking requsts from db by by driver id
    public List<Booking> getBookingsByDriverID(int input_id) {
        List<Booking> bookings = new ArrayList<>();

        try {
            pst = con.prepareStatement("select * from bookings where driver_id = ? order by booking_request_id desc");
            pst.setString(1, Integer.toString(input_id));
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int booking_request_id = rs.getInt("booking_request_id");
                int driver_id = rs.getInt("driver_id");
                String cancelled_at = rs.getString("cancelled_at");
                String ride_complete_at = rs.getString("ride_completed_at");
                String paid_at = rs.getString("paid_at");
                String created_at = rs.getString("created_at");

                Booking booking = new Booking(booking_request_id, driver_id, cancelled_at, ride_complete_at, paid_at, created_at);
                bookings.add(booking);

            }
        } catch (SQLException ex) {
            System.out.println("Data exception occoured");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            closePreparedStatement();
        }

        return bookings;
    }

    //get active bookings from db by by driver id
    public List<Booking> getActiveBookingsByDriverID(int input_driver_id) {
        List<Booking> bookings = new ArrayList<>();

        try {
            pst = con.prepareStatement("select * from bookings where driver_id = ? AND ride_completed_at IS NULL");
            pst.setString(1, Integer.toString(input_driver_id));
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int booking_request_id = rs.getInt("booking_request_id");
                int driver_id = rs.getInt("driver_id");
                String cancelled_at = rs.getString("cancelled_at");
                String ride_complete_at = rs.getString("ride_completed_at");
                String paid_at = rs.getString("paid_at");
                String created_at = rs.getString("created_at");

                Booking booking = new Booking(booking_request_id, driver_id, cancelled_at, ride_complete_at, paid_at, created_at);
                bookings.add(booking);
            }

        } catch (SQLException ex) {
            System.out.println("Data exception occoured");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            closePreparedStatement();
        }

        return bookings;
    }

    //get active bookings from db by userid
    public List<Booking> getBookingsByUserID(int input_id) {
        List<Booking> bookings = new ArrayList<>();

        try {
            pst = con.prepareStatement("select * from bookings b inner join booking_requests br on b.booking_request_id = br.id where br.user_id = ?");
            pst.setString(1, Integer.toString(input_id));
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int booking_request_id = rs.getInt("booking_request_id");
                int driver_id = rs.getInt("driver_id");
                String cancelled_at = rs.getString("cancelled_at");
                String ride_complete_at = rs.getString("ride_completed_at");
                String paid_at = rs.getString("paid_at");
                String created_at = rs.getString("created_at");

                Booking booking = new Booking(booking_request_id, driver_id, cancelled_at, ride_complete_at, paid_at, created_at);
                bookings.add(booking);

            }
        } catch (SQLException ex) {
            System.out.println("Data exception occoured");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            closePreparedStatement();
        }

        return bookings;
    }

    //get a booking requst from db by id
    public Booking getBookingByID(int input_id) {
        Booking booking = null;
        try {
            pst = con.prepareStatement("SELECT * from bookings WHERE booking_request_id = ?");
            pst.setString(1, Integer.toString(input_id));
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int booking_request_id = rs.getInt("booking_request_id");
                int driver_id = rs.getInt("driver_id");
                String cancelled_at = rs.getString("cancelled_at");
                String ride_complete_at = rs.getString("ride_completed_at");
                String paid_at = rs.getString("paid_at");
                String created_at = rs.getString("created_at");

                booking = new Booking(booking_request_id, driver_id, cancelled_at, ride_complete_at, paid_at, created_at);

            }
        } catch (SQLException ex) {
            System.out.println("Data exception occoured");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            closePreparedStatement();
        }

        return booking;
    }

    //setting completed at time
    public boolean setBookingCompletedAt(int booking_request_id) {
        String currentDateTimeAsString = currentDateTime.toString();
        try {
            pst = con.prepareStatement("UPDATE bookings SET ride_completed_at = ? WHERE booking_request_id = ?;");
            pst.setString(1, currentDateTimeAsString);
            pst.setString(2, Integer.toString(booking_request_id));
            System.out.println(pst);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //setting completed at time
    public boolean setBookingPaidAt(int booking_request_id) {
        String currentDateTimeAsString = currentDateTime.toString();
        try {
            pst = con.prepareStatement("UPDATE bookings SET paid_at = ? WHERE booking_request_id = ?;");
            pst.setString(1, currentDateTimeAsString);
            pst.setString(2, Integer.toString(booking_request_id));
            System.out.println(pst);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean insertBooking(Booking b) {
        String currentDateTimeAsString = currentDateTime.toString();
        try {
            pst = con.prepareStatement("INSERT INTO bookings" + "(booking_request_id, driver_id) VALUES " + "(?, ?);");
            pst.setInt(1, b.getBooking_request_id());
            pst.setInt(2, b.getDriver_id());
            System.out.println(pst);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //INVOICES ==============================================
    public List<Invoice> getCompletedInvoices() {
        List<Invoice> invoices = new ArrayList<>();

        try {
            pst = con.prepareStatement("SELECT * from invoices where booking_status = 2 order by booking_request_id desc");
            ResultSet rs = pst.executeQuery();
            System.out.println("");
            while (rs.next()) {
                int id = rs.getInt("id");
                int booking_request_id = rs.getInt("booking_request_id");
                double cost = rs.getDouble("cost");
                double total_cost = rs.getDouble("total_cost");
                String created_at = rs.getString("created_at");

                Invoice invoice = new Invoice(id, booking_request_id, cost, total_cost, created_at);

                invoices.add(invoice);
            }
        } catch (SQLException ex) {
            System.out.println("Data exception occoured");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            closePreparedStatement();
        }

        return invoices;
    }

    public int getTotalCompletedInvoices() {
        int count = 0;

        try {
            pst = con.prepareStatement("SELECT * from invoices where booking_status = 2 order by booking_request_id desc");
            ResultSet rs = pst.executeQuery();
            System.out.println("");
            while (rs.next()) {
                count ++;
            }
        } catch (SQLException ex) {
            System.out.println("Data exception occoured");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            closePreparedStatement();
        }

        return count;
    }

    //get invoice by booking reuewst id
    public Invoice getInvoiceByBookingRequestID(int bookingrequestid) {

        Invoice invoice = null;
        try {
            pst = con.prepareStatement("SELECT * from invoices where booking_request_id = ?");
            pst.setInt(1, bookingrequestid);
            ResultSet rs = pst.executeQuery();
            System.out.println("");
            while (rs.next()) {
                int id = rs.getInt("id");
                int booking_request_id = rs.getInt("booking_request_id");
                double total_cost = rs.getDouble("total_cost");
                double cost = rs.getDouble("cost");
                String created_at = rs.getString("created_at");

                invoice = new Invoice(id, booking_request_id, cost, total_cost, created_at);

            }
        } catch (SQLException ex) {
            System.out.println("Data exception occoured");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            closePreparedStatement();
        }

        return invoice;
    }

    //Adding booking request to database
    public boolean insertInvoice(Invoice inv) {

        String currentDateTimeAsString = currentDateTime.toString();
        try {
            pst = con.prepareStatement("INSERT INTO invoices" + " (booking_request_id, cost, total_cost) VALUES " + "(?, ?, ?);");
            pst.setString(1, Integer.toString(inv.getBooking_request_id()));
            pst.setString(2, Double.toString(inv.getCost()));
            pst.setString(3, Double.toString(inv.getTotal_cost()));
            System.out.println(pst);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //Settingn invoice booking sttatus
    public boolean setInvoiceBookingStatus(int bookingRequestID, int status) {
        try {
            pst = con.prepareStatement("UPDATE invoices SET booking_status = ? WHERE booking_request_id = ?;");
            pst.setInt(1, status);
            pst.setInt(2, bookingRequestID);
            System.out.println(pst);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    //COMPLETE BOOKING ===================================================
    public List<CompleteBooking> getCompleteBookingsByDriverAndDate(int driverID, String fromDate, String toDate) {

        //SQL does not show the dates that are equal to todate so we increment todate by 1 Day
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(toDate, formatter);
        LocalDate toDateIncrementedByOne = date.plusDays(1);

        List<CompleteBooking> completebookings = new ArrayList<>();

        try {
            pst = con.prepareStatement("select "
                    + "  br.user_id as customer_id, "
                    + "  customers.name as customer_name, "
                    + "  br.pick_up_address, "
                    + "  br.destination_address, "
                    + "  br.scheduled_date_time, "
                    + "  br.status as booking_request_status, "
                    + "  br.created_at as booking_request_created_at, "
                    + "  b.created_at as booking_created_at, "
                    + "  b.driver_id as driver_id, "
                    + "  drivers.name as driver_name, "
                    + "  b.ride_completed_at, "
                    + "  b.paid_at, "
                    + "  i.id as invoice_id, "
                    + "  i.created_at as invoice_created_at, "
                    + "  i.booking_request_id, "
                    + "  i.cost, "
                    + "  i.total_cost, "
                    + "  i.booking_status "
                    + "from invoices i "
                    + "inner join booking_requests br on i.booking_request_id = br.id "
                    + "inner join bookings b on i.booking_request_id = b.booking_request_id "
                    + "inner join users as customers on br.user_id = customers.id "
                    + "inner join users as drivers on b.driver_id = drivers.id "
                    + "where "
                    + "i.booking_status = 2 and "
                    + "b.driver_id = ? and "
                    + "b.ride_completed_at >= ? and "
                    + "b.ride_completed_at < ?");
            pst.setInt(1, driverID);
            pst.setString(2, fromDate);
            pst.setString(3, toDateIncrementedByOne.format(formatter));
            ResultSet rs = pst.executeQuery();

            System.out.println("");
            while (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                String customer_name = rs.getString("customer_name");
                String pick_up_address = rs.getString("pick_up_address");
                String destination_address = rs.getString("destination_address");
                String scheduled_date_time = rs.getString("scheduled_date_time");
                int booking_request_status = rs.getInt("booking_request_status");
                String booking_request_created_at = rs.getString("booking_request_created_at");
                String booking_created_at = rs.getString("booking_created_at");
                int driver_id = rs.getInt("driver_id");
                String driver_name = rs.getString("driver_name");
                String ride_completed_at = rs.getString("ride_completed_at");
                String paid_at = rs.getString("paid_at");
                int invoice_id = rs.getInt("invoice_id");
                String invoice_created_at = rs.getString("invoice_created_at");
                int booking_request_id = rs.getInt("booking_request_id");
                double cost = rs.getDouble("cost");
                double total_cost = rs.getDouble("total_cost");
                int booking_status = rs.getInt("booking_status");

                CompleteBooking completeBooking = new CompleteBooking(
                        customer_id,
                        customer_name,
                        pick_up_address,
                        destination_address,
                        scheduled_date_time,
                        booking_request_status,
                        booking_request_created_at,
                        booking_created_at,
                        driver_id,
                        driver_name,
                        ride_completed_at,
                        paid_at,
                        invoice_id,
                        invoice_created_at,
                        booking_request_id,
                        cost,
                        total_cost,
                        booking_status
                );

                completebookings.add(completeBooking);
            }
        } catch (SQLException ex) {
            System.out.println("Data exception occoured");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            closePreparedStatement();
        }

        return completebookings;
    }

    public int getDistictNumberOfCustomersServedByDriverAndDate(int driverID, String fromDate, String toDate) {
        //SQL does not show the dates that are equal to todate so we increment todate by 1 Day
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(toDate, formatter);
        LocalDate toDateIncrementedByOne = date.plusDays(1);

        int count = 0;
        try {
            pst = con.prepareStatement("select distinct"
                    + "  br.user_id as customer_id "
                    + "from invoices i "
                    + "inner join booking_requests br on i.booking_request_id = br.id "
                    + "inner join bookings b on i.booking_request_id = b.booking_request_id "
                    + "inner join users as customers on br.user_id = customers.id "
                    + "inner join users as drivers on b.driver_id = drivers.id "
                    + "where "
                    + "i.booking_status = 2 and "
                    + "b.driver_id = ? and "
                    + "b.ride_completed_at >= ? and "
                    + "b.ride_completed_at < ?");
            pst.setInt(1, driverID);
            pst.setString(2, fromDate);
            pst.setString(3, toDateIncrementedByOne.format(formatter));
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                count++;
            }

        } catch (SQLException ex) {
            System.out.println("Data exception occoured");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePreparedStatement();
        }
        return count;
    }

    //COMPLETE BOOKING ===================================================
    public List<CompleteBooking> getCompleteBookingsByDate(String fromDate, String toDate) {

        //SQL does not show the dates that are equal to todate so we increment todate by 1 Day
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(toDate, formatter);
        LocalDate toDateIncrementedByOne = date.plusDays(1);

        List<CompleteBooking> completebookings = new ArrayList<>();

        try {
            pst = con.prepareStatement("select "
                    + "  br.user_id as customer_id, "
                    + "  customers.name as customer_name, "
                    + "  br.pick_up_address, "
                    + "  br.destination_address, "
                    + "  br.scheduled_date_time, "
                    + "  br.status as booking_request_status, "
                    + "  br.created_at as booking_request_created_at, "
                    + "  b.created_at as booking_created_at, "
                    + "  b.driver_id as driver_id, "
                    + "  drivers.name as driver_name, "
                    + "  b.ride_completed_at, "
                    + "  b.paid_at, "
                    + "  i.id as invoice_id, "
                    + "  i.created_at as invoice_created_at, "
                    + "  i.booking_request_id, "
                    + "  i.cost, "
                    + "  i.total_cost, "
                    + "  i.booking_status "
                    + "from invoices i "
                    + "inner join booking_requests br on i.booking_request_id = br.id "
                    + "inner join bookings b on i.booking_request_id = b.booking_request_id "
                    + "inner join users as customers on br.user_id = customers.id "
                    + "inner join users as drivers on b.driver_id = drivers.id "
                    + "where "
                    + "i.booking_status = 2 and "
                    + "b.ride_completed_at >= ? and "
                    + "b.ride_completed_at < ?");
            pst.setString(1, fromDate);
            pst.setString(2, toDateIncrementedByOne.format(formatter));
            ResultSet rs = pst.executeQuery();

            System.out.println("");
            while (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                String customer_name = rs.getString("customer_name");
                String pick_up_address = rs.getString("pick_up_address");
                String destination_address = rs.getString("destination_address");
                String scheduled_date_time = rs.getString("scheduled_date_time");
                int booking_request_status = rs.getInt("booking_request_status");
                String booking_request_created_at = rs.getString("booking_request_created_at");
                String booking_created_at = rs.getString("booking_created_at");
                int driver_id = rs.getInt("driver_id");
                String driver_name = rs.getString("driver_name");
                String ride_completed_at = rs.getString("ride_completed_at");
                String paid_at = rs.getString("paid_at");
                int invoice_id = rs.getInt("invoice_id");
                String invoice_created_at = rs.getString("invoice_created_at");
                int booking_request_id = rs.getInt("booking_request_id");
                double cost = rs.getDouble("cost");
                double total_cost = rs.getDouble("total_cost");
                int booking_status = rs.getInt("booking_status");

                CompleteBooking completeBooking = new CompleteBooking(
                        customer_id,
                        customer_name,
                        pick_up_address,
                        destination_address,
                        scheduled_date_time,
                        booking_request_status,
                        booking_request_created_at,
                        booking_created_at,
                        driver_id,
                        driver_name,
                        ride_completed_at,
                        paid_at,
                        invoice_id,
                        invoice_created_at,
                        booking_request_id,
                        cost,
                        total_cost,
                        booking_status
                );

                completebookings.add(completeBooking);
            }
        } catch (SQLException ex) {
            System.out.println("Data exception occoured");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            closePreparedStatement();
        }

        return completebookings;
    }

    public int getDistictNumberOfCustomersServedByDate(String fromDate, String toDate) {
        //SQL does not show the dates that are equal to todate so we increment todate by 1 Day
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(toDate, formatter);
        LocalDate toDateIncrementedByOne = date.plusDays(1);

        int count = 0;
        try {
            pst = con.prepareStatement("select distinct"
                    + "  br.user_id as customer_id "
                    + "from invoices i "
                    + "inner join booking_requests br on i.booking_request_id = br.id "
                    + "inner join bookings b on i.booking_request_id = b.booking_request_id "
                    + "inner join users as customers on br.user_id = customers.id "
                    + "inner join users as drivers on b.driver_id = drivers.id "
                    + "where "
                    + "i.booking_status = 2 and "
                    + "b.ride_completed_at >= ? and "
                    + "b.ride_completed_at < ?");
            pst.setString(1, fromDate);
            pst.setString(2, toDateIncrementedByOne.format(formatter));
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                count++;
            }

        } catch (SQLException ex) {
            System.out.println("Data exception occoured");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePreparedStatement();
        }
        return count;
    }

    public int getDistictNumberOfCustomersServed() {

        int count = 0;
        try {
            pst = con.prepareStatement("select distinct"
                    + "  br.user_id as customer_id "
                    + "from invoices i "
                    + "inner join booking_requests br on i.booking_request_id = br.id "
                    + "inner join bookings b on i.booking_request_id = b.booking_request_id "
                    + "inner join users as customers on br.user_id = customers.id "
                    + "inner join users as drivers on b.driver_id = drivers.id "
                    + "where "
                    + "i.booking_status = 2");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                count++;
            }

        } catch (SQLException ex) {
            System.out.println("Data exception occoured");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePreparedStatement();
        }
        return count;
    }

    //HELPER FUNCTION  ===============================
    private void closePreparedStatement() {
        try {
            this.pst.close();
        } catch (SQLException ex) {
            System.out.println("DataAccessor PreparedStatement close failed");
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
