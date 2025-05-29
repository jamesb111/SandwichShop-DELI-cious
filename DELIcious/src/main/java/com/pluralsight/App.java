package com.pluralsight;

import com.pluralsight.models.*;
import com.pluralsight.ui.UserInterface;
import com.pluralsight.util.ItemSize;
import com.pluralsight.util.ReceiptWriter;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to launch the DELICIOUS SANDWICHES app? (Y/N)");

        String userStartApp = scan.nextLine();
        if(userStartApp.equalsIgnoreCase("y")) {
            UserInterface.display();
        }

    }
}
