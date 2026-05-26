package com.example.restaurantticketmanager;

import java.util.ArrayList;
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

        ArrayList <Menu> menus = new ArrayList<>();


        int choice;

        do {
            //STARTING MESSAGE=================================================================
            System.out.println("==== Restaurant Ticket Manager ====");
            System.out.println("1) Menu");
            System.out.println("2) Menu Item");
            System.out.println("3) Make an Order");
            System.out.println("0) Exit");
            System.out.print("Choice: ");

            choice = validateIntInput(input);

            switch(choice){
                //MENU=========================================================================
                case 1:
                    input.nextLine();

                    int menuChoice;
                    int menuOptionsChoice;


                    if(menus.isEmpty()){
                        String menuName;
                        System.out.println("--- Create a Menu ---");
                        System.out.println("No menus yet.");
                        System.out.print("Enter menu's name: ");
                        menuName = input.nextLine();
                        Menu newMenu = new Menu(menuName);

                        menus.add(newMenu);
                        System.out.println("Menu successfully added.");
                    } else {
                        System.out.println("--- Menu ---");
                        int count = 1;
                        for(Menu m : menus){
                            System.out.println(count + ")" + m.getName());
                        }

                        int index;
                        System.out.print("Select a menu (1- " + count + "): ");
                        index = validateIntInput(input);

                        while(index > menus.size()){
                            System.out.println("Error. Selected number must be listed on the options.");
                            input.nextInt();
                            System.out.println("Select a menu (1- " + count + "): ");
                            index = input.nextInt();
                        }



                        System.out.println("1) Create a New Menu");
                        System.out.println("2) Create a Category");
                        System.out.println("3) View Categories");
                        System.out.println("4) Create New Side");
                        System.out.println("5) View Sides");
                        System.out.println("0) Exit");
                        System.out.print("Choice: ");

                        menuOptionsChoice = validateIntInput(input);

                        index--;
                        Menu selectedMenu = menus.get(index);
                        ArrayList<String> categories = selectedMenu.getCategories();

                        switch (menuOptionsChoice){
                            case 1:
                                input.nextLine();

                                String menuName;
                                System.out.println("-- Create a New Menu --");
                                System.out.print("Enter menu's name: ");

                                menuName = input.nextLine();
                                Menu newMenu = new Menu(menuName);
                                menus.add(newMenu);

                                System.out.println("Menu successfully added.");
                                break;
                            case 2:
                                input.nextLine();

                                String category;

                                System.out.println("-- Create a Category --");
                                System.out.print("Category's name:");
                                category = input.nextLine();
                                selectedMenu.createCategory(category);

                                pressContinue(input);
                                break;
                            case 3: //VIEW CATEGORY================================================
                                input.nextLine();

                                int i = 1;
                                System.out.println("-- View Categories --");
                                if(selectedMenu.getCategories().isEmpty()){
                                    System.out.println("No categories added yet.");
                                } else {
                                    for(String c : categories) {
                                        System.out.println(i + ") " + c);
                                    }
                                }
                                pressContinue(input);
                                break;
                            case 4: //CREATE NEW SIDE=================================================
                                String side;

                                System.out.println("-- Create New Side --");
                                System.out.print("Insert a new side: ");
                                side = input.nextLine();

                                selectedMenu.createSide(side);
                                break;
                        }
                    }


                    break;

                //MENU ITEM=======================================================================
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
