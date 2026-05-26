package com.example.restaurantticketmanager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Menu {
    private HashSet<String> categories;
    private HashSet <String> sides;

    public Menu(){
        sides = new HashSet<>();
        categories = new HashSet<>();
    }

    //Getters
    public HashSet<String> getCategories(){ return categories; }

    //Methods
    public void createCategory(String category){
        if(!categories.add(category)){
            System.out.println("Duplicated categories are not allowed");
        } else {
            System.out.println("Category added");
        }
    }

    public void resetMenu(Scanner input){
        String confirmation;

        System.out.println("Are you sure you want to reset the menu? (Y/N)");
        confirmation = input.nextLine();
        while(!confirmation.equalsIgnoreCase("Y") || !confirmation.equalsIgnoreCase("N")){
            if(confirmation.equalsIgnoreCase("Y")){
                sides.clear();
                categories.clear();
                System.out.println("Menu cleared.");
            } else if(confirmation.equalsIgnoreCase("N")){
                System.out.println("Menu not cleared.");
            } else {
                System.out.println("Invalid input. You should answer with 'Y' or 'N'.");
                input.nextLine();
                confirmation = input.nextLine();
            }
        }
    }
}
