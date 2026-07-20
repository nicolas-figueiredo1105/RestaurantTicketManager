package com.example.restaurantticketmanager;

import java.util.ArrayList;

public class MenuItem {
    private Menu intendedMenu;
    private String itemName;
    private boolean isAppetizer;
    private String category;
    private String description;
    private String [] possibleSides;

    //Constructors------------------------------------------------------------------------------
    public MenuItem(Menu intendedMenu,String category, String itemName, boolean isAppetizer, String description, String [] possibleSides){
        this.intendedMenu = intendedMenu;
        this.category = category;
        this.itemName = itemName;
        this.isAppetizer = isAppetizer;
        this.category = "";
        this.description = description;
        this.possibleSides = possibleSides;
    }

    public MenuItem(Menu intendedMenu, String category, String itemName, boolean isAppetizer, String [] possibleSides){
        this.intendedMenu = intendedMenu;
        this.category = category;
        this.itemName = itemName;
        this.isAppetizer = isAppetizer;
        this.category = "";
        this.description = "";
        this.possibleSides = possibleSides;
    }

    //Getters----------------------------------------------------------------------------------
    public boolean getIsAppetizer(){
        return isAppetizer;
    }

    public String getCategory(){
        return category;
    }

    public String getItemName(){
        return itemName;
    }

    public String getDescription(){
        return description;
    }

    public String[] getPossibleSides(){
        return possibleSides;
    }

    //Setters-----------------------------------------------------------------------------------
    public void addDescription(String newDescription){
        description = newDescription;
    }

    public void setCategory(String newCategory){ category = newCategory; }


    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder(itemName);

        if(!category.isEmpty()){
            builder.append(" [").append(category).append("]");
        }

        if(isAppetizer){
            builder.append(" - Appetizer");
        }

        if(!description.isEmpty()){
            builder.append("\n   ").append(description);
        }

        if(possibleSides.length > 0){
            builder.append("\n   Sides: ");
            for(int i = 0; i < possibleSides.length; i++){
                if(i > 0) builder.append(", ");
                builder.append(possibleSides[i]);
            }
        }

        return builder.toString();
    }

}

