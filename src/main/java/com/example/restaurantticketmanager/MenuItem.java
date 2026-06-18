package com.example.restaurantticketmanager;

public class MenuItem {
    private Menu intendedMenu;
    private String itemName;
    private boolean isAppetizer;
    private String category;
    private String description;
    private String [] possibleSides;

    //Constructors------------------------------------------------------------------------------
    public MenuItem(Menu intendedMenu,String itemName, boolean isAppetizer, String description, String [] possibleSides){
        this.intendedMenu = intendedMenu;
        this.itemName = itemName;
        this.isAppetizer = isAppetizer;
        this.category = "";
        this.description = description;
        this.possibleSides = possibleSides;
    }

    public MenuItem(Menu intendedMenu, String itemName, boolean isAppetizer, String [] possibleSides){
        this.intendedMenu = intendedMenu;
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

