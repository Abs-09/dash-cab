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
    private String created_at;
    private int driver_id;
    private String cancelled_at;
    private String ride_complete_at;
    private String paid_at;
    
    public Booking(int booking_request_id, int driver_id, String cancelled_at, String ride_complete_at, String paid_at, String created_at) {
        this.booking_request_id = booking_request_id;
        this.driver_id = driver_id;
        this.cancelled_at = cancelled_at;
        this.ride_complete_at = ride_complete_at;
        this.paid_at = paid_at;
        this.created_at = created_at;
    }

    public Booking(int booking_request_id, int driver_id, String cancelled_at, String ride_complete_at, String paid_at) {
        this.booking_request_id = booking_request_id;
        this.driver_id = driver_id;
        this.cancelled_at = cancelled_at;
        this.ride_complete_at = ride_complete_at;
        this.paid_at = paid_at;
    }
    
    public Booking(int booking_request_id, int driver_id) {
        this.booking_request_id = booking_request_id;
        this.driver_id = driver_id;
    }

    public int getBooking_request_id() {
        return booking_request_id;
    }

    public void setBooking_request_id(int booking_request_id) {
        this.booking_request_id = booking_request_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public String getCancelled_at() {
        return cancelled_at;
    }

    public void setCancelled_at(String cancelled_at) {
        this.cancelled_at = cancelled_at;
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
