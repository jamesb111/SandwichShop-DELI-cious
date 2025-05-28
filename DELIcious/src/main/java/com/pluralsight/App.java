package com.pluralsight;

import com.pluralsight.models.*;
import com.pluralsight.util.ItemSize;
import com.pluralsight.util.ReceiptWriter;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        ArrayList<Topping> topList = new ArrayList<>();
        topList.add(new Topping("steak"));
        topList.add(new Topping("swiss"));
        topList.add(new Topping("ham"));

        Sandwich newSammmy = new Sandwich("wheat", topList, ItemSize.LARGE, true);

        ArrayList<Topping> topList2 = new ArrayList<>();
        topList.add(new Topping("steak"));
        topList.add(new Topping("salami"));
        topList.add(new Topping("cheddar"));


        Sandwich newSammmy2 = new Sandwich("rye", topList, ItemSize.MEDIUM, false);

        ArrayList<Sandwich> sammys = new ArrayList<>();
        sammys.add(newSammmy);
        sammys.add(newSammmy2);

        ArrayList<Chips> newChips = new ArrayList<>();
        newChips.add(new Chips("Doritos"));
        newChips.add(new Chips("Cheetos"));

        ArrayList<Drink> drinkz = new ArrayList<>();
        drinkz.add(new Drink("Sprite", ItemSize.LARGE));
        drinkz.add(new Drink("Pepsi", ItemSize.MEDIUM));


        Order newOrder = new Order(sammys, drinkz, newChips);
        newOrder.getOrderDetails();

        ReceiptWriter rWriter = new ReceiptWriter();
        rWriter.saveReceipt(newOrder);

    }
}
