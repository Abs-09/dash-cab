
package com.mycompany.dash.cab.model;

public class Customer extends User{
    
    public Customer(int id, String name, String password, String email, String contact, String address, int enabled, int type, String deleted_at) {
        super(id, name, password, email, contact, address, enabled, type, deleted_at);
    }
    
    public Customer(int id, String name, String password, String email, String contact, String address, int enabled, int type) {
        super(id, name, password, email, contact, address, enabled, type);
    }
    
}
