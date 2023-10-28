/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dash.cab.service;

import java.util.Date;
import jakarta.jws.WebService;

@WebService(endpointInterface = "javasamples.one.TimeServer")
public class TimeServerImpl implements TimeServer {
    public String getTimeAsString() {
        return new Date().toString();
    }

    public long getTimeAsElapsed() {
        return new Date().getTime();
    }
}
