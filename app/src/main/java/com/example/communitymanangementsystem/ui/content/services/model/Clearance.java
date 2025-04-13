package com.example.communitymanangementsystem.ui.content.services.model;

public class Clearance {
    private int id;
    private String clearanceName;
    private double price;

    public Clearance(int id, String clearanceName, double price) {
        this.id = id;
        this.clearanceName = clearanceName;
        this.price = price;
    }

    public String getClearanceName() {
        return clearanceName;
    }

    public double getPrice(){
        return price;
    }
}
