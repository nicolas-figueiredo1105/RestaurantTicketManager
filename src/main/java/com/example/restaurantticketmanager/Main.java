package com.example.restaurantticketmanager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void createMenu(ArrayList<Menu> menus, Scanner scanner){
        String menuName;
        System.out.print("Enter menu's name: ");
        menuName = scanner.nextLine();

        Menu newMenu = new Menu(menuName);
        menus.add(newMenu);
        System.out.println("Menu successfully created!");
    }

    public static Menu selectMenu(ArrayList<Menu> menus, Scanner scanner){
        if(menus.isEmpty()){
            System.out.println("No menu created yet.");
            scanner.nextLine();
            pressContinue(scanner);

            return null;
        } else {
            int choice;
            System.out.println("-- Select a Menu --");
            createMenuList(menus);
            System.out.print("Choice: ");
            choice = scanner.nextInt();

            return menus.get(choice - 1);
        }
    }

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

    public static boolean checkQuestionInput(Scanner scanner){

        while(true){
            String answer = scanner.nextLine().trim().toLowerCase();
            switch(answer){
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.println("Invalid input. You should enter 'Y' or 'N'.");
            }
        }
    }

    public static void pressContinue(Scanner scanner){
        System.out.print("(Press Enter To Continue) \n");
        scanner.nextLine();
    }

    public static void createList(ArrayList<String> data){
        int count = 1;
        for(String d : data){
            System.out.println(count + ") " + d);
            count++;
        }
    }

    public static void createMenuList(ArrayList<Menu> menus){
        int count = 1;
        for(Menu m : menus){
            System.out.println(count + ") " + m.getName());
            count++;
        }
    }

    public static int checkOutOfBoundsInput(ArrayList<Menu> menus, int inputIndex, Scanner scanner){
        validateIntInput(scanner);
        while(inputIndex > menus.size()){
            System.out.println("Error. Selected number must be listed on the options.");
            scanner.nextInt();
            if(menus.size() == 1){
                System.out.println("Select a menu: ");
            } else {
                System.out.println("Select a menu (1- " + menus.size() + "): ");
            }
            inputIndex = scanner.nextInt();
        }
        return inputIndex;
    }

    public static void main(String [] args){

        Scanner input = new Scanner(System.in);

        ArrayList <Menu> menus = new ArrayList<>();
        Menu selectedMenu;

        int choice;

        do {

            //STARTING MESSAGE=================================================================
            System.out.println("==== Restaurant Ticket Manager ====");
            System.out.println("Welcome to Restaurant Ticket Manager!");
            System.out.println("To get started, create a menu.");
            createMenu(menus, input);
            selectedMenu = menus.getFirst();

            System.out.println("==== Restaurant Ticket Manager ====");
            System.out.println("Selected menu: " + selectedMenu.getName());
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
                    int index = 0;


                    if(menus.isEmpty()){
                        String menuName;
                        System.out.println("--- Create a Menu ---");
                        System.out.println("No menus yet.");
                        createMenu(menus, input);

                        pressContinue(input);
                        break;
                    } else if(selectedMenu == null) {
                        System.out.println("--- Menu ---");
                        createMenuList(menus);


                        System.out.print("Select a menu (1- " + menus.size() + "): ");

                        index = checkOutOfBoundsInput(menus, index, input);

                    }

                    System.out.println("Selected Menu: " + selectedMenu.getName());
                    System.out.println("1) Create a New Menu");
                    System.out.println("2) Create a Category");
                    System.out.println("3) View Categories");
                    System.out.println("4) Create New Side");
                    System.out.println("5) View Sides");
                    System.out.println("6) Delete a Menu");
                    System.out.println("0) Exit");
                    System.out.print("Choice: ");

                    menuOptionsChoice = validateIntInput(input);

                    index--;
                    selectedMenu = menus.get(index);
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
                            pressContinue(input);
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

                            System.out.println("-- View Categories --");
                            if(selectedMenu.getCategories().isEmpty()){
                                System.out.println("No categories added yet.");
                            } else {
                                createList(categories);
                            }

                            pressContinue(input);
                            break;
                        case 4: //CREATE NEW SIDE=================================================
                            input.nextLine();
                            String side;

                            System.out.println("-- Create New Side --");
                            System.out.print("Insert a new side: ");
                            side = input.nextLine();

                            selectedMenu.createSide(side);

                            pressContinue(input);
                            break;
                        case 5: //VIEW SIDES=====================================================
                            if(selectedMenu.getSides().isEmpty()){
                                System.out.println("No sides added yet.");
                            } else {
                                createList(selectedMenu.getSides());
                            }

                            pressContinue(input);
                            break;
                        case 6: //DELETE A MENU==================================================
                            System.out.println("-- Delete a Menu --");
                            if(!menus.isEmpty()){
                                System.out.println("Select a menu to delete:");
                                createMenuList(menus);
                                System.out.print("Choice: ");
                                int deleteIndex = validateIntInput(input);
                                menus.remove(deleteIndex - 1);
                            } else {
                                System.out.println("No menus to delete.");
                                pressContinue(input);

                            }
                            break;
                    }



                break;

                //MENU ITEM=======================================================================
                case 2:


                    int menuItemChoice;

                    selectedMenu = selectMenu(menus, input);

                    if(selectedMenu == null) break;

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
                            String confirmation = "";

                            System.out.println("-- Create an Item --");

                            System.out.print("Item's name: ");
                            itemName = input.nextLine();

                            System.out.print("Is an appetizer? (Y/N): ");
                            isAppetizer = checkQuestionInput(input);

                            System.out.println("Would you like to add a description of the item? (Y/N): ");
                            boolean addDescription = checkQuestionInput(input);

                            if(addDescription){
                                System.out.println("Enter a description: ");
                                description = input.nextLine();
                            }

                            System.out.println("Possible sides: ");
                            createList(selectedMenu.getSides());
                            ArrayList<String> sideChoices = new ArrayList<>();
                            String sc;
                            System.out.println("Select the sides. Press 'Enter' to finish.");
                            do {
                                int count = 1;
                                System.out.println("Side " + count + ": ");
                                sc = input.nextLine();

                                if(sideChoices.isEmpty()) {
                                    System.out.println("You must select at least one side.");
                                } else {
                                    sideChoices.add(sc);
                                    count++;
                                }
                            } while(sc.isBlank() && !sideChoices.isEmpty());

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
