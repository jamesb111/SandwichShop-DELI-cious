package com.pluralsight.models;

import com.pluralsight.util.ItemSize;

public class Drink {

    private String name;
    private ItemSize size;
    private double price;

    public Drink(String name, ItemSize size) {
        this.name = name;
        this.size = size;
        this.price = generatePrice();
    }

    //sets the price of drink based on its size
    public double generatePrice() {
        switch(this.size) {
            case SMALL:
                return 2.00;
            case MEDIUM:
                return 2.50;
            case LARGE:
                return 3.00;
            default:
                return 0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemSize getSize() {
        return size;
    }

    public void setSize(ItemSize size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}


