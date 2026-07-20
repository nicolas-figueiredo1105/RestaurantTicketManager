package com.example.restaurantticketmanager;

import java.util.ArrayList;

public class Ticket {
    ArrayList<MenuItem> items;

    public Ticket(ArrayList<MenuItem> items){
        this.items = items;
    }

    public Ticket(){
        items = new ArrayList<>();
    }

    //Methods
    @Override
    public String toString(){
        String str = "";
        for(int i = 0; i < items.size(); i++){
            str += items.get(i).toString() + "\n";
        }
        return str;
    }
}
