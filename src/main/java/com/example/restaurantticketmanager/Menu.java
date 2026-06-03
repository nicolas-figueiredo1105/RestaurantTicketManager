package com.example.restaurantticketmanager;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private String name;
    private ArrayList<String> categories;
    private ArrayList <String> sides;

    public Menu(String name){
        this.name = name;
        sides = new ArrayList<>();
        categories = new ArrayList<>();
    }

    //Getters
    public ArrayList<String> getCategories(){ return categories; }

    public ArrayList<String> getSides(){ return sides; }

    public String getName() { return name; }

    //Methods
    public void createCategory(String category){
        if(!categories.add(category)){
            System.out.println("Duplicated categories are not allowed");
        } else {
            System.out.println("Category added");
        }
    }

    public void createSide(String side){
        if(!categories.add(side)){
            System.out.println("Duplicated sides are not allowed.");
        } else {
            System.out.println("Side added!");
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
