package com.pluralsight.models;

import com.pluralsight.util.ItemSize;
import com.pluralsight.util.MenuArrays;

import java.util.ArrayList;
import static com.pluralsight.util.MenuArrays.*;


public class Sandwich {
    private String bread;
    private ArrayList<Topping> toppingList;
    private ItemSize size;
    private boolean isToasted;
    private double totalPrice;
    private int sizeInches;


    public Sandwich(String bread, ArrayList<Topping> toppingList, ItemSize size, boolean isToasted) {
        this.bread = bread;
        this.toppingList = toppingList;
        this.size = size;
        this.isToasted = isToasted;
        this.totalPrice = calculateTotalPrice();
        this.sizeInches = sizeToInches();
    }

    // will conditionally set size from small, medium, or large to a number of inches
    public int sizeToInches() {
        return switch (this.size) {
            case SMALL -> 4;
            case MEDIUM -> 8;
            case LARGE -> 12;
            default -> 0;
        };
    }

    //gets cost of bread
    public double getBreadCost() {
        return switch (this.size) {
            case SMALL -> 5.50;
            case MEDIUM -> 7.00;
            case LARGE -> 8.50;
            default -> 0;
        };
    }

    public double calculateTotalPrice() {
        //check for lambdas
        double meatCost = 0;
        double cheeseCost = 0;
        for(Topping t : toppingList) {
            //checks if toppings are meet or cheese (these are the only toppings that have a cost)
            boolean containsMeat = isItemInMenu(t.getName(), menuMeats);
            boolean containsCheese = isItemInMenu(t.getName(), menuCheeses);

            switch(this.size) {
                case SMALL:
                    if(containsMeat) {
                        meatCost += 1.00;
                        if(containsCheese) {
                            cheeseCost += 0.75;
                        }
                    } else if(containsCheese) {
                        cheeseCost += 0.75;
                    }
                    break;
                case MEDIUM:
                    if(containsMeat) {
                        meatCost += 2.00;
                        if(containsCheese) {
                            cheeseCost += 1.50;
                        }
                    } else if(containsCheese) {
                        cheeseCost += 1.50;
                    }
                    break;
                case LARGE:
                    if(containsMeat) {
                        meatCost += 3.00;
                        if(containsCheese) {
                            cheeseCost += 2.25;
                        }
                    } else if(containsCheese) {
                        cheeseCost += 2.25;
                    }
                    break;
            }
        }

        return meatCost + cheeseCost + getBreadCost();
    }

    public String getBread() {
        return bread;
    }

    public ArrayList<Topping> getToppingList() {
        return toppingList;
    }

    public ItemSize getSize() {
        return size;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public int getSizeInches() {
        return sizeInches;
    }
}
