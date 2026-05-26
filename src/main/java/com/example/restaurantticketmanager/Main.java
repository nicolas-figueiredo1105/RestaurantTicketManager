package com.example.restaurantticketmanager;

import java.util.HashSet;
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

    public static void pressContinue(Scanner scanner){
        System.out.println("(Press Enter To Continue) \n");
        scanner.nextLine();
    }

    public static void main(String [] args){

        Scanner input = new Scanner(System.in);

        Menu menu = new Menu();

        int choice;

        do {
            System.out.println("==== Restaurant Ticket Manager ====");
            System.out.println("1) Create a Menu");
            System.out.println("2) Create a Menu Item");
            System.out.println("3) Make an Order");
            System.out.println("0) Exit");
            System.out.print("Choice: ");

            choice = validateIntInput(input);

            switch(choice){
                case 1:
                    input.nextLine();

                    int menuChoice;
                    HashSet<String> categories = menu.getCategories();

                    System.out.println("--- Create a Menu ---");
                    System.out.println("1) Create a Category");
                    System.out.println("2) View Categories");
                    System.out.println("3) Create New Side");
                    System.out.println("4) View Sides");
                    System.out.println("0) Exit");
                    System.out.print("Choice: ");

                    menuChoice = validateIntInput(input);

                    switch (menuChoice){
                        case 1:
                            input.nextLine();

                            String category;

                            System.out.println("-- Create a Category --");
                            System.out.print("Category's name:");
                            category = input.nextLine();

                            menu.createCategory(category);
                            pressContinue(input);
                            break;
                        case 2:
                            input.nextLine();

                            int count = 1;
                            System.out.println("-- View Categories --");
                            if(menu.getCategories().isEmpty()){
                                System.out.println("No categories added yet.");
                            } else {
                                for(String c : categories) {
                                    System.out.println(count + ") " + c);
                                }
                            }
                            pressContinue(input);
                            break;
                    }
                    break;

                case 2:
                    int menuItemChoice;

                    System.out.println("--- Create a Menu Item ---");
                    System.out.println("1) Create an Item");
                    System.out.println("2) View Items");
                    System.out.println("0) Exit");
                    System.out.print("Choice: ");

                    menuItemChoice = validateIntInput(input);

                    switch(menuItemChoice){
                        case 1:
                            input.nextLine();
                            String itemName;
                            boolean isAppetizer = false; String description; String side;
                            String confirmation;

                            System.out.println("-- Create an Item --");

                            System.out.print("Item's name: ");
                            itemName = input.nextLine();

                            System.out.print("Is an appetizer? (Y/N)");
                            confirmation = input.nextLine();
                            while(!confirmation.equalsIgnoreCase("Y") || !confirmation.equalsIgnoreCase("N")){
                                if(confirmation.equalsIgnoreCase("Y")){
                                    isAppetizer = true;
                                } else if(confirmation.equalsIgnoreCase("N")){
                                    isAppetizer = false;
                                } else {
                                    System.out.println("Invalid input. You should answer with 'Y' or 'N'.");
                                    input.nextLine();
                                    confirmation = input.nextLine();
                                }
                            }

                            System.out.println("Would you like to add a description of the item? (Y/N): ");
                            confirmation = input.nextLine();
                            while(!confirmation.equalsIgnoreCase("Y") || !confirmation.equalsIgnoreCase("N")){
                                if(confirmation.equalsIgnoreCase("Y")){
                                    System.out.println("Enter the description: ");
                                    description = input.nextLine();
                                } else if(confirmation.equalsIgnoreCase("N")){
                                    description = "";
                                } else {
                                    System.out.println("Invalid input. You should answer with 'Y' or 'N'.");
                                    input.nextLine();
                                    confirmation = input.nextLine();
                                }
                            }


                    }
            }

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
