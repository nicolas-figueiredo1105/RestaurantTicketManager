package com.example.restaurantticketmanager;

public class MenuItem {
    private String itemName;
    private boolean isAppetizer;
    private String category;
    private String description;
    private String side;

    //Constructors------------------------------------------------------------------------------
    public MenuItem(String itemName, boolean isAppetizer, String category, String description, String side){
        this.itemName = itemName;
        this.isAppetizer = isAppetizer;
        this.category = category;
        this.description = description;
        this.side = side;
    }

    public MenuItem(String itemName, boolean isAppetizer, String category, String side){
        this.itemName = itemName;
        this.isAppetizer = isAppetizer;
        this.category = category;
        this.description = "";
        this.side = side;
    }

    //Getters----------------------------------------------------------------------------------
    public boolean getIsAppetizer(){
        return isAppetizer;
    }

    public String getCategory(){
        return category;
    }

    //Setters-----------------------------------------------------------------------------------
    public void addDescription(String newDescription){
        description = newDescription;
    }

}

