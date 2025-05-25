package com.pluralsight.models;

public class Topping {
    private String name; // is it a meat, cheese, or sauce
    private boolean isPremium;

    public Topping(String name) {
        this.name = name;
        this.isPremium = getToppingType();
    }

    public String getName() {
        return name;
    }

    public boolean isPremium() {
        return isPremium;
    }

    //sets if topping is premium or not based on topping name
    public boolean getToppingType() {
        switch (this.name) {
            //premium meats
            case "Steak":
            case "Ham":
            case "Salami":
            case "Roast beef":
            case "Chicken":
            case "Bacon":
                //premium cheeses
            case "American":
            case "Provolone":
            case "Cheddar":
            case "Swiss":
                return true;
                //regular toppings
            case "Lettuce":
            case "Peppers":
            case "Onions":
            case "Tomatoes":
            case "Jalapeños":
            case "Cucumbers":
            case "Pickles":
            case "Guacamole":
            case "Mushrooms":
                //sauces
            case "Mayo":
            case "Mustard":
            case "Ketchup":
            case "Ranch":
            case "Thousand Island":
            case "Vinaigrette":
                return false;

            default:
                return false;
        }


    }
}
