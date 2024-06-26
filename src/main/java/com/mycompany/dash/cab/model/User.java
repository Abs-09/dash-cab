
package com.mycompany.dash.cab.model;

public abstract class User {
    private int id;
    private String name;
    private String password;
    private String email;
    private String contact;
    private String address;
    private int enabled;
    private int type;
    private String deleted_at;

    public User(int id, String name, String password, String email, String contact, String address, int enabled, int type, String deleted_at) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.enabled = enabled;
        this.type = type;
        this.deleted_at = deleted_at;
    }
    
    public User(int id, String name, String password, String email, String contact, String address, int enabled, int type) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.enabled = enabled;
        this.type = type;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int isEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public int getType() {
        return type;
    }
    
    public String getTypeByName() {
        if(this.type == 1) {
            return "Admin";
        } else if (this.type == 2) {
            return "Driver";
        } else if (this.type == 3) {
            return "Customer";
        } else {
            return "Undefined";
        }
    }

    public void setType(int type) {
        this.type = type;
    }
    
    
}
