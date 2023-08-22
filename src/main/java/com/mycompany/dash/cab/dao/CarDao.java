/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dash.cab.dao;

import com.mycompany.dash.cab.model.Car;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class CarDao {

    private Connection con;
    private Statement st;
    private PreparedStatement pst;

    //When an object is created a connection from the database is intialized
    public CarDao() {
        this.con = Database.getDatabase().getConnection();
    }

    public boolean addCar(Car car) {
        try {
            String sql = "INSERT INTO cars (license_plate, model, created_at) VALUES (?, ?, ?,) ";
            pst = con.prepareStatement(sql);
            pst.setString(1, new String(car.getLicense_plate()));
            pst.setString(2, new String(car.getModel()));
            pst.setString(3, new String(car.getCreated_at()));
            pst.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println("Failed writing user details to database in DataAccessor Level");
            Logger.getLogger(CarDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            closePreparedStatement();
        }
    }
    
   // public ArrayList getCar (){
   //        try{
   //            String  sql = "SELECT * FROM cars";
   //            pst = con.prepareStatement(sql);
   //            
   //            ResultSet rs = pst.executeQuery();
   //            return true;
   //        } catch (SQLException ex){
   //            System.out.println("Failed querying car details from database in DataAccessor Level");   
   //            return false;
   //        } finally{
   //            closePreparedStatement();
   //        }
   // }
    
    public Car getCarByID(int ID){
        try{
            String sql = "SELECT * FROM Cars WHERE id = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, ID);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return new Car(rs.getInt("id"), rs.getString("license_plate"), rs.getString("model"), rs.getString("created_at"));
            } else {
                System.out.println("Car not found");
                return null;
            }

        } catch (SQLException ex) {
            System.out.println("Data getCarByID exception occoured");
            System.out.println("Error: " + ex);
            Logger.getLogger(CarDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    private void closePreparedStatement() {
        try {
            this.pst.close();
        } catch (SQLException ex) {
            System.out.println("DataAccessor PreparedStatement close failed");
            Logger.getLogger(CarDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}