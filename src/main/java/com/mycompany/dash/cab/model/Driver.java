package com.mycompany.dash.cab.model;

public class Driver extends User {
    
    String licenseNumber;
    int availability;
    
    public Driver(int id, String name, String password, String email, String contact, String address, int enabled, int type, String licenseNumber, int availability) {
        super(id, name, password, email, contact, address, enabled, type);
        this.licenseNumber = licenseNumber;
        this.availability = availability;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
 
}
