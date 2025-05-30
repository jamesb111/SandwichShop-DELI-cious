package com.pluralsight.util;

import com.pluralsight.models.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ReceiptWriter {
    //saves order receipt to a txt file
    public  void saveReceipt(Order order) {
        //gets current date and time.
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

        String nowFormatted = now.format(format1);

        try {
            //use to write to file
            BufferedWriter writer = new BufferedWriter( new FileWriter("src/main/resources/" + nowFormatted+ ".txt"));

            //writes header
            writer.write("ORDER RECEIPT-------------------------------------------------");
            writer.newLine();
            writer.write("──────────────────────────────────────────────────────────────");
            writer.newLine();
            writer.write("ITEMS & PRICES");
            writer.newLine();

            int counter = 0;

            //writes sandwiches
            if(order.getSandwiches() != null) {
                for(Sandwich s : order.getSandwiches()) {
                    // numbered header for sandwich
                    counter++;
                    writer.write("Sandwich #" + counter + " ---------------");
                    writer.newLine();

                    String sammyLine;
                    if(s.isToasted()) {
                        sammyLine = "Toasted " + s.getBread() + " | $" + String.format("%.2f", s.getBreadCost());
                    } else {
                        sammyLine =  s.getBread() + " | $" + String.format("%.2f", s.getBreadCost());
                    }
                    writer.write(sammyLine);
                    writer.newLine();

                    //writes toppings
                    for(Topping t : s.getToppingList()) {
                        String toppingLine = t.getName() + " | $" + String.format("%.2f", s.getToppingPrice(t));
                        writer.write(toppingLine);
                        writer.newLine();
                    }

                    writer.newLine();
                }
            } else {
                writer.write("NO SANDWICHES");
                writer.newLine();
            }


            writer.write("DRINKS & CHIPS ---------------");
            writer.newLine();

            //writes drinks
            if(order.getDrinks() != null) {
                for(Drink d : order.getDrinks()) {
                    String drinkLine = d.getName() + " | $" + String.format("%.2f", d.getPrice());
                    writer.write(drinkLine);
                    writer.newLine();
                }
            } else {
                writer.write("NO DRINKS");
                writer.newLine();
            }

            //writes drinks
            if(order.getChipsList() != null) {
                for(Chips c : order.getChipsList()) {
                    String chipLine = c.getName() + " | $" + String.format("%.2f", c.getPrice());
                    writer.write(chipLine);
                    writer.newLine();
                }
            } else {
                writer.write("NO CHIPS");
                writer.newLine();
            }


            writer.write("──────────────────────────────────────────────────────────────");
            writer.newLine();
            writer.write("ORDER TOTAL: $" + String.format("%.2f", order.getOrderTotal()));
            writer.newLine();
            writer.write("──────────────────────────────────────────────────────────────");
            writer.newLine();

            writer.close();
            System.out.println("Receipt written to: src/main/resources/" + nowFormatted + ".txt");

        }  catch (IOException e) {
            System.out.println("Error writing receipt file: " + e.getMessage());
        }
    }
}
