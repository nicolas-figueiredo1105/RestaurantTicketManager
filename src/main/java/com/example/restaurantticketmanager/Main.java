package com.example.restaurantticketmanager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static int validateIntInput(Scanner scanner){
        int input;

        try {
            input = scanner.nextInt();
            return input;
        } catch (InputMismatchException ex){
            System.out.println("Invalid input. This field requires a positive integer.");
            scanner.nextLine();
            return -1;
        }
    }

    public static boolean checkEmptyInput(Scanner scanner){
        String input;

        input = scanner.nextLine();

        return input.trim().isEmpty();
    }


    public static void main(String [] args){

        Scanner input = new Scanner(System.in);


        int choice;

        do {
            System.out.println("==== Restaurant Ticket Manager ====");
            System.out.println("1) Create a Menu Item");
            System.out.println("2) Create a Menu");
            System.out.println("3) Create a Ticket");
            System.out.println("0) Exit");

            choice = validateIntInput(input);

        } while(choice != 0);


    }
//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//    }


}
