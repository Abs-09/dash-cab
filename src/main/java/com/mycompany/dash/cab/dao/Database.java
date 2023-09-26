
package com.mycompany.dash.cab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
        //-----------This is an sql connection class with singleton design pattern------------------------------------
    //declaring and intializing variables
    private Connection con;
    private final String URL = "jdbc:mysql://localhost:3306/dash_cab?useUnicode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true";
    private final String USERNAME = "root";
    private final String PASSWORD = "password";
    
    private static Database dash_cab = new Database();
    
    private Database() {
        //class name for mysql driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException ex) {
            System.out.println("My Sql database class driver not found");
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("My Sql database connection establish failed");
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Database getDatabase() {
        return dash_cab; //retrieve eager instantiated single instance of Database
    }

    public Connection getConnection() {
        return this.con; //retrieve the re-usable connection object
    }
    
}
