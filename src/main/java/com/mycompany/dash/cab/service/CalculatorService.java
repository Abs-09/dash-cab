package com.mycompany.dash.cab.service;

public class CalculatorService {

    public double calculateCost(double distance) {
        double cost = distance * 0.025;
        return cost;
    }
    
    public double calculateTotalCost(double distance) {
        double cost = distance * 0.025;
        double total_cost = cost * 1.12;
        return total_cost;
    }
}
