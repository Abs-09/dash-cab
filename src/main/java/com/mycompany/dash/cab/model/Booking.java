/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dash.cab.model;

/**
 *
 * @author admin
 */
public class Booking {
    
    private int booking_request_id;
    private int driver_id;
    private String assigned_date;
    private String ride_complete_at;
    private String paid_at;

    public Booking(int booking_request_id, int driver_id, String assigned_date, String ride_complete_at, String paid_at) {
        this.booking_request_id = booking_request_id;
        this.driver_id = driver_id;
        this.assigned_date = assigned_date;
        this.ride_complete_at = ride_complete_at;
        this.paid_at = paid_at;
    }

    public int getBooking_request_id() {
        return booking_request_id;
    }

    public void setBooking_request_id(int booking_request_id) {
        this.booking_request_id = booking_request_id;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public String getAssigned_date() {
        return assigned_date;
    }

    public void setAssigned_date(String assigned_date) {
        this.assigned_date = assigned_date;
    }

    public String getRide_complete_at() {
        return ride_complete_at;
    }

    public void setRide_complete_at(String ride_complete_at) {
        this.ride_complete_at = ride_complete_at;
    }

    public String getPaid_at() {
        return paid_at;
    }

    public void setPaid_at(String paid_at) {
        this.paid_at = paid_at;
    }
    
    
    
}
