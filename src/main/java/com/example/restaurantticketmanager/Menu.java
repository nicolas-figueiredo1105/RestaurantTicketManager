package com.example.restaurantticketmanager;

import java.util.HashMap;
import java.util.HashSet;

public class Menu {
    private HashSet<String> categories;

    public Menu(){
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
}
