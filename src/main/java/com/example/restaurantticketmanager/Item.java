package com.example.restaurantticketmanager;

public class Item {
    private String itemName;
    private boolean isAppetizer;
    private String description;
    private String instructions;

    public Item(String itemName, boolean isAppetizer, String description, String instructions){
        this.itemName = itemName;
        this.isAppetizer = isAppetizer;
        this.description = description;
        this.instructions = instructions;
    }

    public Item(String itemName, boolean isAppetizer){
        this.itemName = itemName;
        this.isAppetizer = isAppetizer;
        this.description = "";
        this.instructions = "";
    }
}

