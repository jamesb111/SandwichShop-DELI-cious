package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

import com.pluralsight.util.ItemSize;


public class Order {
    private ArrayList<Sandwich> sandwiches;
    private ArrayList<Drink> drinks;
    private ArrayList<Chips> chipsList;
    private double orderTotal;

    public Order(ArrayList<Sandwich> sandwiches, ArrayList<Drink> drinks, ArrayList<Chips> chipsList) {
        this.sandwiches = sandwiches;
        this.drinks = drinks;
        this.chipsList = chipsList;
        this.orderTotal = getOrderTotal();
    }

    public double getOrderTotal() {
        //adds up all sandwiches
        double sandwichSum = sandwiches.stream()
                .mapToDouble(Sandwich::calculateTotalPrice)
                .sum();
        //adds up all drinks
        double drinkSum = drinks.stream()
                .mapToDouble(Drink::getPrice)
                .sum();
        //adds up all chips
        double chipsSum = chipsList.stream()
                .mapToDouble(Chips::getPrice)
                .sum();

        return sandwichSum + drinkSum + chipsSum;
    }

    public void getOrderDetails() {
        System.out.println("──────────────────────────────────────────────────────────────");
        System.out.println("                        ORDER RECEIPT                           ");
        System.out.println("──────────────────────────────────────────────────────────────");
        System.out.println("ITEM | PRICE:");
        System.out.println();

        //gets all sandwich details
        for(Sandwich s : sandwiches) {
            s.getSandwichDetails();
        }

        //gets all chips details
        chipsList.forEach(chip -> System.out.printf("Chips: %s | Price: $%.2f \n", chip.getName(), chip.getPrice()));

        //gets all drink details
        drinks.forEach(drink -> System.out.printf ("Drink: %s %s | Price: $%.2f \n", drink.getSize(), drink.getName(), drink.generatePrice()));

        System.out.println("──────────────────────────────────────────────────────────────");
        System.out.printf("ORDER TOTAL: $%.2f \n",  getOrderTotal());
        System.out.println("──────────────────────────────────────────────────────────────");
    }

    // add methods that'll put items in the specified lists--------------
    public void addSandwich(Sandwich sammy) {
        sandwiches.add(sammy);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chips) {
        chipsList.add(chips);
    }

    //--------------------------------------------------------------------

    public ArrayList<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public ArrayList<Chips> getChipsList() {
        return chipsList;
    }
}
