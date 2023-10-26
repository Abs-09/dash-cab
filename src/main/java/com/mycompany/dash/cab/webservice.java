/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.dash.cab;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

/**
 *
 * @author admin
 */
@WebService(serviceName = "webservice")
public class webservice {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello() {
        return "Hello Dash Cab !";
    }
}
