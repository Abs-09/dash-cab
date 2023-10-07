/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dash.cab.model;

/**
 *
 * @author admin
 */
public class BookingRequest {
    
    private int id;
    private int user_id;
    private String pick_up_address;
    private String destination_address;
    private String scheduled_date_time;
    private int status;
    private String created_at;

    public BookingRequest(int id, int user_id, String pick_up_address, String destination_address, String scheduled_date_time, int status, String created_at) {
        this.id = id;
        this.user_id = user_id;
        this.pick_up_address = pick_up_address;
        this.destination_address = destination_address;
        this.scheduled_date_time = scheduled_date_time;
        this.status = status;
        this.created_at = created_at;
    }
    

    public BookingRequest(int user_id, String pick_up_address, String destination_address, String scheduled_date_time, int status) {
        this.user_id = user_id;
        this.pick_up_address = pick_up_address;
        this.destination_address = destination_address;
        this.scheduled_date_time = scheduled_date_time;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPick_up_address() {
        return pick_up_address;
    }

    public void setPick_up_address(String pick_up_address) {
        this.pick_up_address = pick_up_address;
    }

    public String getDestination_address() {
        return destination_address;
    }

    public void setDestination_address(String destination_address) {
        this.destination_address = destination_address;
    }

    public String getScheduled_date_time() {
        return scheduled_date_time;
    }

    public void setScheduled_date_time(String scheduled_date_time) {
        this.scheduled_date_time = scheduled_date_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    
    
    
}
