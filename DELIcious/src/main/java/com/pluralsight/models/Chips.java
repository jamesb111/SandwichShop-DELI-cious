package com.pluralsight.models;

public class Chips {
    private String name;
    private double price;

    public Chips(String name) {
        this.name = name;
        this.price = 1.50;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
