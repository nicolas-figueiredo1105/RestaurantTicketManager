package com.example.restaurantticketmanager;

public class QueueNode {
    private Ticket ticket;
    private QueueNode next;

    public QueueNode(Ticket ticket, QueueNode next){
        this.ticket = ticket;
        this.next = next;
    }

    //Getters
    public QueueNode getNext(){
        return next;
    }

    public Ticket getTicket(){
        return ticket;
    }
}
