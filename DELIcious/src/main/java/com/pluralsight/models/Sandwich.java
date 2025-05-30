package com.pluralsight.models;

import com.pluralsight.util.ItemSize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        double topCost = 0;
        for(Topping t : toppingList) {
            topCost += getToppingPrice(t);
        }

        return topCost + getBreadCost();
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

    public void getSandwichDetails() {
        // topping boolean idea
//        boolean hasMeat = toppingList.stream()
//                .anyMatch(topping -> isItemInMenu(topping.getName(), menuMeats));

        // lambdas that adds items to list if they match-----------------------
        List<Topping> meatToppings = toppingList.stream()
                .filter(topping -> Arrays.stream(menuMeats)
                        .anyMatch(val -> val.equalsIgnoreCase (topping.getName())))
                .toList();

        List<Topping> cheeseToppings = toppingList.stream()
                .filter(topping -> Arrays.stream(menuCheeses)
                        .anyMatch(val -> val.equalsIgnoreCase(topping.getName())))
                .toList();

        List<Topping> regToppings = toppingList.stream()
                .filter(topping -> Arrays.stream(menuRegToppings)
                        .anyMatch(val -> val.equalsIgnoreCase(topping.getName())))
                .toList();

        List<Topping> sauceOnTop = toppingList.stream()
                .filter(topping -> Arrays.stream(menuSauces)
                        .anyMatch(val -> val.equalsIgnoreCase(topping.getName())))
                .toList();

        List<Topping> extraToppings = toppingList.stream()
                .filter(topping -> topping.getName().equalsIgnoreCase("EXTRA"))
                        .toList();

//        System.out.println("Sandwich details ----------------------");
        //prints bread
        if(this.isToasted) {
            System.out.printf("Bread type: Toasted %s | Price: $%.2f \n", this.getBread(), this.getBreadCost());
        } else {
            System.out.printf("Bread type: %s | Price: $%.2f \n", this.getBread(), this.getBreadCost());
        }

        //prints out toppings
        meatToppings.forEach(topping -> System.out.printf("Meat: %s | Price: $%.2f \n", topping.getName(), getToppingPrice(topping)));
        cheeseToppings.forEach(topping -> System.out.printf("Cheese: %s | Price: $%.2f \n",  topping.getName(), getToppingPrice(topping)));
        regToppings.forEach(topping -> System.out.printf("Name: %s | Price: FREE \n", topping.getName()));
        sauceOnTop.forEach(topping -> System.out.printf("Name: %s | Price: FREE \n", topping.getName()));

        //gets extra toppings
        for(Topping t : toppingList) {
            if(t.getName().contains("EXTRA")) {
                System.out.printf("%s | $%.2f", t.getName(), getToppingPrice(t));
                System.out.println();
            }
        }

        System.out.printf("%d inch sandwich on %s bread costs $%.2f \n", this.getSizeInches(), this.getBread(), this.calculateTotalPrice());
        System.out.println();

    }

    // return prices of toppings based on size of sandwich
    public double getToppingPrice(Topping topping) {
        //booleans that'll check the menu arrays and set price based on matches

        boolean containsMeat = isItemInMenu(topping.getName(), menuMeats);
        boolean containsCheese = isItemInMenu(topping.getName(), menuCheeses);
        boolean containsRegToppings = isItemInMenu(topping.getName(), menuRegToppings);
        boolean containsSauces = isItemInMenu(topping.getName(), menuSauces);

        // non premium toppings are free
        if (containsRegToppings || containsSauces) {
            return 0;
        }

        // sets topping amount based on topping type and sandwich size
        switch (this.size) {
            case SMALL:
                // checks if topping is na extra based on boolean value
               if(topping.isExtraTopping()) {
                   if (containsMeat) {
                       return 0.50;
                   } else if (containsCheese) {
                       return 0.30;
                   }
               } else {
                   if (containsMeat) {
                       return 1.00;
                   } else if (containsCheese) {
                       return 0.75;
                   }
               }
            case MEDIUM:
                if(topping.isExtraTopping()) {
                    if (containsMeat) {
                        return 1.00;
                    } else if (containsCheese) {
                        return 0.60;
                    }
                } else {
                    if (containsMeat) {
                        return 2.00;
                    } else if (containsCheese) {
                        return 1.50;
                    }
                }
            case LARGE:
                if(topping.isExtraTopping()) {
                    if (containsMeat) {
                        return 1.50;
                    } else if (containsCheese) {
                        return 0.90;
                    }
                } else {
                    if (containsMeat) {
                        return 3.00;
                    } else if (containsCheese) {
                        return 2.25;
                    }
                }

            default:
                return 0;
        }

    }
}
