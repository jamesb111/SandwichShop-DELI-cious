package com.pluralsight.util;

public class MenuArrays {
    public static String[] menuMeats = {"Steak", "Ham", "Salami", "Roast beef", "Chicken", "Bacon"};
    public static String[] menuBreads = {"White", "Wheat", "Rye", "Wrap"};
    public static String[] menuCheeses = {"American", "Provolone", "Cheddar", "Swiss"};;
    public static String[] menuRegToppings = {"Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"};
    public static String[] menuSauces = {"Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Island", "Vinaigrette"};
    public static String[] menuDrinks = {"Vitamin water", "Sweet tea", "Sprite", "Pepsi", "Fanta Orange"};


    // method that will be used to check if the user input is an option contained within a menu array
    public static boolean isItemInMenu(String text, String[] arr) {
        for(String s : arr) {
            if(text.toLowerCase().contains(s.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
