package com.pluralsight;

import com.pluralsight.models.Sandwich;
import com.pluralsight.models.Topping;
import com.pluralsight.util.ItemSize;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        ArrayList<Topping> topList = new ArrayList<>();
        topList.add(new Topping("steak"));
        topList.add(new Topping("swiss"));
        topList.add(new Topping("ham"));

        Sandwich newSanmmy = new Sandwich("wheat", topList, ItemSize.LARGE, true);

        System.out.println(newSanmmy.calculateTotalPrice());

        System.out.println(newSanmmy.getSizeInches() + " inches long");
    }
}
