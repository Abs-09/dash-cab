/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dash.cab.model;

/**
 *
 * @author admin
 */
public class CompleteBooking {
    int customer_id;
    String customer_name;
    String pick_up_address;
    String destination_address;
    String scheduled_date_time;
    int booking_request_status;
    String booking_request_created_at;
    String booking_created_at;
    int driver_id;
    String driver_name;
    String ride_completed_at;
    String paid_at;
    int invoice_id;
    String invoice_created_at;
    int booking_request_id;
    double cost;
    double total_cost;
    int booking_status;

    public CompleteBooking(int customer_id, String customer_name, String pick_up_address, String destination_address, String scheduled_date_time, int booking_request_status, String booking_request_created_at, String booking_created_at, int driver_id, String driver_name, String ride_completed_at, String paid_at, int invoice_id, String invoice_created_at, int booking_request_id, double cost, double total_cost, int booking_status) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.pick_up_address = pick_up_address;
        this.destination_address = destination_address;
        this.scheduled_date_time = scheduled_date_time;
        this.booking_request_status = booking_request_status;
        this.booking_request_created_at = booking_request_created_at;
        this.booking_created_at = booking_created_at;
        this.driver_id = driver_id;
        this.driver_name = driver_name;
        this.ride_completed_at = ride_completed_at;
        this.paid_at = paid_at;
        this.invoice_id = invoice_id;
        this.invoice_created_at = invoice_created_at;
        this.booking_request_id = booking_request_id;
        this.cost = cost;
        this.total_cost = total_cost;
        this.booking_status = booking_status;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getPick_up_address() {
        return pick_up_address;
    }

    public String getDestination_address() {
        return destination_address;
    }

    public String getScheduled_date_time() {
        return scheduled_date_time;
    }

    public int getBooking_request_status() {
        return booking_request_status;
    }

    public String getBooking_request_created_at() {
        return booking_request_created_at;
    }

    public String getBooking_created_at() {
        return booking_created_at;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public String getRide_completed_at() {
        return ride_completed_at;
    }

    public String getPaid_at() {
        return paid_at;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public String getInvoice_created_at() {
        return invoice_created_at;
    }

    public int getBooking_request_id() {
        return booking_request_id;
    }

    public double getCost() {
        return cost;
    }

    public double getTotal_cost() {
        return total_cost;
    }

    public int getBooking_status() {
        return booking_status;
    }
    
}
