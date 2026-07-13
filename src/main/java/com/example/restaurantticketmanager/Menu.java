package com.example.restaurantticketmanager;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private String name;
    private ArrayList<String> categories;
    private ArrayList <String> sides;
    private ArrayList<MenuItem> menuItems;

    public Menu(String name, ArrayList<MenuItem> menuItems){
        this.name = name;
        sides = new ArrayList<>();
        categories = new ArrayList<>();
        this.menuItems = menuItems == null ? new ArrayList<>() : menuItems;
    }

    public Menu(String name){
        this.name = name;
        sides = new ArrayList<>();
        categories = new ArrayList<>();
        this.menuItems = new ArrayList<>();
    }

    //Getters
    public ArrayList<String> getCategories(){ return categories; }

    public ArrayList<String> getSides(){ return sides; }

    public String getName() { return name; }

    public ArrayList<MenuItem> getMenuItems() { return menuItems; }

    //Methods
    public void createCategory(String category){
        if(categories.contains(category)){
            System.out.println("Duplicated categories are not allowed");
        } else {
            categories.add(category);
            System.out.println("Category added");
        }
    }

    public void createSide(String side){
        if(sides.contains(side)){
            System.out.println("Duplicated sides are not allowed.");
        } else {
            sides.add(side);
            System.out.println("Side added!");
        }
    }

    public void addMenuItem(MenuItem item){
        menuItems.add(item);
        System.out.println("Item added!");
    }

    public void resetMenu(Scanner input){
        String confirmation;

        System.out.println("Are you sure you want to reset the menu? (Y/N)");
        confirmation = input.nextLine();
        while(!confirmation.equalsIgnoreCase("Y") && !confirmation.equalsIgnoreCase("N")){
            System.out.println("Invalid input. You should answer with 'Y' or 'N'.");
            confirmation = input.nextLine();
        }

        if(confirmation.equalsIgnoreCase("Y")){
            sides.clear();
            categories.clear();
            menuItems.clear();
            System.out.println("Menu cleared.");
        } else {
            System.out.println("Menu not cleared.");
        }
    }

    @Override
    public String toString(){
        return name;
    }
}
