/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dash.cab.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import static com.mysql.cj.exceptions.MysqlErrorNumbers.get;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GoogleMapsApiService {

    private String apiKey = "AIzaSyAd3T6I7teyv_qI3Dy6nJf4sSw93vYb_Dk";
    String origin, destination;
    HttpURLConnection connection;
    URL url;
    public JSONObject jsonObject;

    public GoogleMapsApiService(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
        intiateDistanceApiURL(origin, destination);
    }

    public boolean intiateDistanceApiURL(String origin, String destination) {
        String plusOrigin = replaceSpacesWithPlus(origin.trim());
        String plusDestination = replaceSpacesWithPlus(destination.trim());
        String apiUrl = "https://maps.googleapis.com/maps/api/distancematrix/json"
                + "?origins=" + plusOrigin
                + "&destinations=" + plusDestination
                + "&key=" + this.apiKey;

        System.out.println("APi URL =" + apiUrl);

        // Create a URL object and open a connection
        try {
            this.url = new URL(apiUrl);
            this.connection = (HttpURLConnection) url.openConnection();
            // Set the HTTP request method to GET
            this.connection.setRequestMethod("GET");
        } catch (MalformedURLException ex) {
            Logger.getLogger(GoogleMapsApiService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(GoogleMapsApiService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    public String getDistance() throws ParseException, IOException {
        int responseCode = connection.getResponseCode();

        // Read the response data
        if (responseCode == 200) {
            Scanner scan = new Scanner(url.openStream());
            StringBuilder apiresponse = new StringBuilder();

            while (scan.hasNext()) {
                apiresponse.append(scan.nextLine());
            }

            scan.close();

            // Parse the JSON string
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(apiresponse.toString(), JsonObject.class);

            // Extract the value field from the JSON object
            double value = jsonObject.getAsJsonArray("rows")
                    .get(0).getAsJsonObject()
                    .getAsJsonArray("elements")
                    .get(0).getAsJsonObject()
                    .getAsJsonObject("distance")
                    .get("value").getAsInt();
            
            String distance = Double.toString(value);
            
            System.out.println("Distance is" + distance);
            return distance;

        } else if (responseCode == 400) {
            System.out.println("Error: Bad Request (HTTP Response Code 400)");
            Scanner errorScan = new Scanner(connection.getErrorStream());
            while (errorScan.hasNext()) {
                System.out.println(errorScan.nextLine());
            }
            errorScan.close();
            return null;
        } else {
            System.out.println("Error: HTTP Response Code " + responseCode);
            return null;
        }

    }

    public static String replaceSpacesWithPlus(String input) {
        if (input == null) {
            return null;
        }
        String in = input.replace(" ", "+");
        return in;

    }

}
