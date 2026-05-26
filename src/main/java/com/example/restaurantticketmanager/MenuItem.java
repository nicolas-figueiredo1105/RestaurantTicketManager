package com.example.restaurantticketmanager;

public class MenuItem {
    private String itemName;
    private boolean isAppetizer;
    private String category;
    private String description;
    private String [] possibleSides;

    //Constructors------------------------------------------------------------------------------
    public MenuItem(String itemName, boolean isAppetizer, String description, String [] possibleSides){
        this.itemName = itemName;
        this.isAppetizer = isAppetizer;
        this.category = "";
        this.description = description;
        this.possibleSides = possibleSides;
    }

    public MenuItem(String itemName, boolean isAppetizer, String [] possibleSides){
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

    //Setters-----------------------------------------------------------------------------------
    public void addDescription(String newDescription){
        description = newDescription;
    }

    public void setCategory(String newCategory){ category = newCategory; }

}

