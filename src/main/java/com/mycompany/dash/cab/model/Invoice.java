/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dash.cab.model;

/**
 *
 * @author admin
 */
public class Invoice {

    private int id;
    private int booking_request_id;
    private double total_cost;
    private int booking_status;
    private String created_at;

    public Invoice(int id, int booking_request_id, double total_cost, String created_at, int booking_status) {
        this.id = id;
        this.booking_request_id = booking_request_id;
        this.total_cost = total_cost;
        this.created_at = created_at;
        this.booking_status = booking_status;
    }

    public Invoice(int id, int booking_request_id, double total_cost, String created_at) {
        this.id = id;
        this.booking_request_id = booking_request_id;
        this.total_cost = total_cost;
        this.created_at = created_at;
    }

    public Invoice(int booking_request_id, double total_cost) {
        this.booking_request_id = booking_request_id;
        this.total_cost = total_cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBooking_request_id() {
        return booking_request_id;
    }

    public void setBooking_request_id(int booking_request_id) {
        this.booking_request_id = booking_request_id;
    }

    public double getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(double total_cost) {
        this.total_cost = total_cost;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getBooking_status() {
        return booking_status;
    }

    public void setBooking_status(int booking_status) {
        this.booking_status = booking_status;
    }
    
    

}
