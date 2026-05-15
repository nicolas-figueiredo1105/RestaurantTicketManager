package com.example.restaurantticketmanager;

public class MenuItem {
    private String itemName;
    private boolean isAppetizer;
    private String description;

    //Constructors------------------------------------------------------------------------------
    public MenuItem(String itemName, boolean isAppetizer, String description){
        this.itemName = itemName;
        this.isAppetizer = isAppetizer;
        this.description = description;
    }

    public MenuItem(String itemName, boolean isAppetizer){
        this.itemName = itemName;
        this.isAppetizer = isAppetizer;
        this.description = "";
    }

    //Getters----------------------------------------------------------------------------------
    public boolean getIsAppetizer(){
        return isAppetizer;
    }

    //Setters-----------------------------------------------------------------------------------
    public void addDescription(String newDescription){
        description = newDescription;
    }

}

