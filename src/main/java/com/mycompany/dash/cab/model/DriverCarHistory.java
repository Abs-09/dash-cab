/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dash.cab.model;

/**
 *
 * @author admin
 */
public class DriverCarHistory {
    
    private int id;
    private int car_id;
    private int driver_id;
    private String assigned_date;
    private String unassigned_date;

    public DriverCarHistory(int id, int car_id, int driver_id, String assigned_date, String unassigned_date) {
        this.id = id;
        this.car_id = car_id;
        this.driver_id = driver_id;
        this.assigned_date = assigned_date;
        this.unassigned_date = unassigned_date;
    }

    public DriverCarHistory(int car_id, int driver_id, String assigned_date) {
        this.car_id = car_id;
        this.driver_id = driver_id;
        this.assigned_date = assigned_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
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

    public String getUnassigned_date() {
        return unassigned_date;
    }

    public void setUnassigned_date(String unassigned_date) {
        this.unassigned_date = unassigned_date;
    }
    
    
    
}
