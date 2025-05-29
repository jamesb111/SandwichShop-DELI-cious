package com.pluralsight.models;

public class Topping {
    private String name; // is it a meat, cheese, or sauce
    private boolean isExtraTopping; // used to alter price of topping

    public Topping(String name) {
        this.name = name;
    }

    public Topping(String name, boolean isExtraTopping) {
        this.name = name;
        this.isExtraTopping = isExtraTopping;
    }

    public String getName() {
        return name;
    }

    public boolean isExtraTopping() {
        return isExtraTopping;
    }

    public void setExtraTopping(boolean extraTopping) {
        isExtraTopping = extraTopping;
    }
}
