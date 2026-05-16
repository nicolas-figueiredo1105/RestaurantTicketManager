package com.example.restaurantticketmanager;

public class Queue {
    private QueueNode start;
    private QueueNode end;

    private int queueSize;

    public Queue(){
        start = end = null;
        queueSize = 0;
    }

    //Getters
    public QueueNode getStart(){ return start; }

    public QueueNode getEnd(){ return end; }

    //Methods
    public boolean isEmpty(){ return start == null; }

    public void finishTicket(){
        if(isEmpty()){
            System.out.println("The Queue is empty");
            return;
        }

        start = start.getNext();
        if(start == null) end = null;
        queueSize--;
    }

    public void addTicket(QueueNode newTicket){
        if(isEmpty()){
            start = end = newTicket;
        } else {
            end.setNext(newTicket);
            end = newTicket;
        }

        queueSize++;
    }

    public int getSize(){
        return queueSize;
    }
}
