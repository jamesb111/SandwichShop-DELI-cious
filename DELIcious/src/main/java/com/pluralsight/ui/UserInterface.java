package com.pluralsight.ui;

import com.pluralsight.models.*;
import com.pluralsight.util.ItemSize;
import com.pluralsight.util.ReceiptWriter;

import java.util.ArrayList;
import java.util.Scanner;

import static com.pluralsight.util.MenuArrays.*;

public class UserInterface {


    static Scanner scan = new Scanner(System.in);

    //private constructor so no other instances of userinterface exist
    private UserInterface(){}

    public static void display() {

        //boolean for while loop
        boolean onHome = true;

        while(onHome) {
            System.out.println("─────────────────────────────────────DELICIOUS SANDWICHES───────────────────────────────────");
            System.out.println("Welcome to the best sandwich shop in town! Select a number from our options \n" +
                    "1) New Order \n" +
                    "0) Exit - exit the application");
            System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────");
            System.out.println();
            System.out.print("Enter option here: ");

            int userChoice = scan.nextInt();
            scan.nextLine();

            if(userChoice == 1) {
                orderScreen();
            } else if(userChoice == 0) {
                onHome = false;
            }
        }
    }

    public static void orderScreen() {
        ArrayList<Sandwich> sammyList = new ArrayList<>(); // stores sandwiches
        ArrayList<Drink> drinkList = new ArrayList<>(); // stores drinks
        ArrayList<Chips> chipList = new ArrayList<>(); // stores chips

        //boolean for while loop
        boolean onOrderScreen = true;

        //loops through methods that will build your order
        while(onOrderScreen) {
            System.out.println("────────────────────────────────────MENU PAGE─────────────────────────────────────────");
            System.out.println("MEATS                                CHEESES                                   BREADS \n" +
                               "-------------------------------------------------------------------------------------- \n" +
                               "Steak                                American                                  White \n" +
                               "Ham                                  Provolone                                 Wheat \n" +
                               "Salami                               Cheddar                                   Rye \n" +
                               "Roast Beef                           Swiss                                     Wrap \n" +
                               "Chicken \n" +
                               "Bacon");
            System.out.println("────────────────────────────────────────────────────────────────────────────────────────");
            System.out.println("SAUCES");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("Mayo  Mustard  Ketchup  Ranch  Thousand Island  Vinaigrette");
            System.out.println("────────────────────────────────────────────────────────────────────────────────────────");
            System.out.println();

            System.out.println("Click one of the number selections to start your order. \n" +
                    "1) Add Sandwich \n" +
                    "2) Add Drink \n" +
                    "3) Add Chips \n" +
                    "4) Checkout \n" +
                    "0) Cancel Order");
            System.out.println("────────────────────────────────────────────────────────────────────────────────────────");
            System.out.print("Enter option here: "); // user input
            int orderChoice = scan.nextInt();
            scan.nextLine();
            System.out.println("────────────────────────────────────────────────────────────────────────────────────────");
            System.out.println();



            switch(orderChoice) {
                case 1: //adds sandwich
                    sammyList.add(processAddSandwich());
                    break;
                case 2: //adds drink
                    drinkList.add(processAddDrink());
                    break;
                case 3: //adds chips
                    chipList.add(processAddChips());
                    break;
                case 4: //checks out by making order and saving it to a txt file
                    Order newOrder = new Order(sammyList, drinkList, chipList);
                    newOrder.getOrderDetails();

                    System.out.println("--------------------------------");
                    System.out.println("A) CHECKOUT");
                    System.out.println("B) CANCEL");
                    String userChoice = scan.nextLine();

                    if(userChoice.equalsIgnoreCase("a")) {
                        //new receipt writer to write to txt file
                        ReceiptWriter reWriter = new ReceiptWriter();
                        reWriter.saveReceipt(newOrder);
                        System.out.println("Order has been placed");
                        onOrderScreen = false;
                    } else {
                        System.out.println("Order discarded");
                        onOrderScreen = false;
                    }

                    break;
                case 0:
                    onOrderScreen = false;
                    break;
                default:
                    System.out.println("Invalid selection. Please enter a valid option (0-4).");
                    break;
            }

        }
    }

    public static Sandwich processAddSandwich() {
        boolean onToppingMenu = true; //used to loop through and add multiple toppings
        ArrayList<Topping> topList = new ArrayList<>(); // stores sandwich
        boolean toastedBread; // determines if bread is toasted
        String breadType; // actual bread
        ItemSize sammySize; // stores size of sandwich
        boolean isExtra = false; // determines if topping is an extra


        System.out.println("-----------------------------------------SANDWICH VIEW-----------------------------------------");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────");


        //gets sandwich size
        System.out.println("What size Sandwich do you want? \n" +
                "S) Small \n" +
                "M) Medium \n" +
                "L) Large ");
        System.out.print("Enter option here: "); // user input
        String userSize = scan.nextLine();
        System.out.println();

        if (userSize.equalsIgnoreCase("s")) {
            sammySize = ItemSize.SMALL;
        } else if(userSize.equalsIgnoreCase("m")) {
            sammySize = ItemSize.MEDIUM;
        } else if(userSize.equalsIgnoreCase("l")) {
            sammySize = ItemSize.LARGE;
        } else {
            sammySize = ItemSize.SMALL;
        }

        System.out.println("What kind of bread would you like on your sandwich? \n" +
                "A) WHITE \n" +
                "B) WHEAT \n" +
                "C) RYE \n" +
                "D) WRAP");
        System.out.print("Enter option here: "); // user input
        String breadChoice = scan.nextLine();
        System.out.println();

        //sets bread to the specified type
        if (breadChoice.equalsIgnoreCase("a")) {
            breadType = "White";
        } else if(breadChoice.equalsIgnoreCase("b")) {
            breadType = "Wheat";
        } else if (breadChoice.equalsIgnoreCase("c")) {
            breadType = "Rye";
        } else if (breadChoice.equalsIgnoreCase("d")) {
            breadType = "Wrap";
        } else {
            breadType = "White";
        }

        //determines if bread will be toasted or not
        System.out.println("Would you like your bread toasted? Y/N");
        System.out.print("Enter option here: ");

        String toastOrNot = scan.nextLine();
        if(toastOrNot.equalsIgnoreCase("y")) {
            toastedBread = true;
        } else {
            toastedBread = false;
        }

        //topping menu loop
        while(onToppingMenu) {
            System.out.println("-----------------------------------------TOPPING VIEW------------------------------------------");
            System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────");
            System.out.println("PRICES BY SIZE Small | Medium | Large");
            System.out.println("MEATS          $1.00 | $2.00 | $3.00");
            System.out.println("CHEESES        $0.75 | $1.50 | $2.25");
            System.out.println("All other toppings are free and included with your order.");
            System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────");
            System.out.println("MEATS:");
            System.out.println("Steak | Ham | Salami | Roast Beef | Chicken | Bacon");
            System.out.println();
            System.out.println("CHEESES:");
            System.out.println("American | Provolone | Cheddar | Swiss");
            System.out.println();
            System.out.println("REGULAR TOPPINGS:");
            System.out.println("Lettuce | Peppers | Onions | Tomatoes | Jalapeños \n" +
                    "Cucumbers | Pickles | Guacamole | Mushrooms");
            System.out.println();
            System.out.println("SAUCES:");
            System.out.println("Mayo | Mustard | Ketchup | Ranch | Thousand Island | Vinaigrette");
            System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────");
            System.out.println("Would you like to add a topping? Y/N");
            System.out.print("Enter option here: ");
            String toppingYesOrNo = scan.nextLine();

            // adds topping if user selects yes
            if(toppingYesOrNo.equalsIgnoreCase("y")) {
                System.out.print("Enter Topping: ");
                String userTopping = scan.nextLine();

                //checks if the user topping is inside any of the menu arrays
                boolean isOnMenu = isItemInMenu(userTopping, menuMeats) || isItemInMenu(userTopping, menuCheeses) || isItemInMenu(userTopping, menuRegToppings) || isItemInMenu(userTopping, menuSauces);
                if (isOnMenu) {
                    topList.add(new Topping(userTopping, false));

                    System.out.println("Would you like extra " + userTopping +" ? Y/N");
                    System.out.print("Enter option: ");
                    String mayWantExtra = scan.nextLine();


                    if(mayWantExtra.equalsIgnoreCase("y")) {
                        // adds extra premium toppings
                        if (isItemInMenu(userTopping, menuMeats) || isItemInMenu(userTopping, menuCheeses)) {
                            topList.add(new Topping("EXTRA " + userTopping, true));

                        } else { // adds extra free toppings
                            topList.add(new Topping("EXTRA " + userTopping, true));
                        }

                    }
                }


            } else if(toppingYesOrNo.equalsIgnoreCase("n")) {
                onToppingMenu = false;
            }

        }

        return new Sandwich(breadType, topList, sammySize, toastedBread);
//        Sandwich newSammy = new Sandwich(breadType, topList, sammySize, toastedBread);

    }

    //adds drink to the drink list
    public static Drink processAddDrink() {
        //variables to store drink and item size
        int drinkChoice;
        String drinkWord;
        ItemSize size;

        //gets drink choice as number
        System.out.println("------------------------------------------DRINKS VIEW------------------------------------------");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("What kind of drink would you like? \n" +
                "1) Vitamin water\n" +
                "2) Sweet tea\n" +
                "3) Sprite\n" +
                "4) Pepsi\n" +
                "5) Fanta Orange");
        System.out.print("Enter option here: ");
        drinkChoice = scan.nextInt();
        scan.nextLine();

        //sets drink choice to actual word based on number
        switch (drinkChoice) {
            case 1:
                drinkWord = "Vitamin water";
                break;
            case 2:
                drinkWord = "Sweet tea";
                break;
            case 3:
                drinkWord = "Sprite";
                break;
            case 4:
                drinkWord = "Pepsi";
                break;
            case 5:
                drinkWord = "Fanta Orange";
                break;
            default:
                drinkWord = "Vitamin Water";
        }

        System.out.println("What size drink do you want? \n" +
                "S) Small \n" +
                "M) Medium \n" +
                "L) Large ");
        String userSize = scan.nextLine();

        if (userSize.equalsIgnoreCase("s")) {
            size = ItemSize.SMALL;
        } else if(userSize.equalsIgnoreCase("m")) {
            size = ItemSize.MEDIUM;
        } else if(userSize.equalsIgnoreCase("l")) {
            size = ItemSize.LARGE;
        } else {
            size = ItemSize.SMALL;
        }

        return new Drink(drinkWord, size);
//        Drink newDrink = new Drink(drinkWord, size);
//        drinkList.add(newDrink);
    }

    //adds chips to list
    public static Chips processAddChips() {
        //variables to store chips
        int chipChoice;
        String chipWord;
        System.out.println("-------------------------------------------CHIPS VIEW------------------------------------------");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("What kind of chips would you like? \n" +
                "1) Doritos\n" +
                "2) Cheetos\n" +
                "3) Lays\n" +
                "4) Sun Chips\n" +
                "5) Fritos");

        System.out.print("Enter option here: ");
        chipChoice = scan.nextInt();
        scan.nextLine();

        //sets chip choice to actual word based on number
        switch (chipChoice) {
            case 1:
                chipWord = "Doritos";
                break;
            case 2:
                chipWord = "Cheetos";
                break;
            case 3:
                chipWord = "Lays";
                break;
            case 4:
                chipWord = "Sun Chips";
                break;
            case 5:
                chipWord = "Fritos";
                break;
            default:
                chipWord = "Fritos";
        }

        return new Chips(chipWord);
//        Chips newChips = new Chips(chipWord);
//        chipList.add(newChips);
    }

}
