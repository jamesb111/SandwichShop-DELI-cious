package com.pluralsight.ui;

import com.pluralsight.models.Chips;
import com.pluralsight.models.Drink;
import com.pluralsight.models.Order;
import com.pluralsight.models.Sandwich;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    static Order order;
    static ArrayList<Sandwich> sammyList;
    static ArrayList<Drink> drinkList;
    static ArrayList<Chips> chipList;

    static Scanner scan = new Scanner(System.in);

    //private constructor so no other instances of userinterface exist
    private UserInterface(){}

    public static void display() {

        //boolean for while loop
        boolean onHome = true;

        while(onHome) {
            System.out.println("─────────────────────────────────────DELICIOUS SANDWICHES───────────────────────────────────");
            System.out.println("Welcome to the best sandwich shop in town! Select a letter from our list of options \n" +
                    "1) New Order \n" +
                    "0) Exit - exit the application");
            System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────");
            System.out.println();
            System.out.print("Enter option here: ");

            int userChoice = scan.nextInt();
            scan.nextLine();

            if(userChoice == 1) {
                //insert method
            } else if(userChoice == 0) {
                onHome = false;
            }
        }
    }

    public static void orderScreen() {
        //boolean for while loop
        boolean onOrderScreen = true;

        while(onOrderScreen) {
            System.out.println("─────────────────────────────────────────ORDER PAGE─────────────────────────────────────────────");
            System.out.println("Order page. Click one of the numbers to select one of our options. \n" +
                    "1) Add Sandwich \n" +
                    "2) Add Drink \n" +
                    "3) Add Chips \n" +
                    "4) Checkout \n" +
                    "0) Cancel Order");
            System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────");
            System.out.println();



        }
    }
}
