package com.example.restaurantticketmanager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class Main {

    //FILE I/O METHODS===========================================================================


    //===========================================================================================


    public static void createMenu(ArrayList<Menu> menus, Scanner scanner){
        System.out.print("Enter menu's name: ");
        String menuName = scanner.nextLine().trim();

        if(menuName.isEmpty()){
            System.out.println("Menu name cannot be empty.");
            return;
        }

        menus.add(new Menu(menuName));
        System.out.println("Menu successfully created!");
    }

    public static Menu selectMenu(ArrayList<Menu> menus, Scanner scanner){
        if(menus.isEmpty()){
            System.out.println("No menu created yet.");
            pressContinue(scanner);
            return null;
        }

        System.out.println("-- Select a Menu --");
        createMenuList(menus);
        int choice = readBoundedInt(scanner, "Choice: ", 0, menus.size());

        if(choice == 0){
            return null;
        }

        return menus.get(choice - 1);
    }

    public static int validateIntInput(Scanner scanner){
        try {
            int input = scanner.nextInt();
            scanner.nextLine();
            return input;
        } catch (InputMismatchException ex){
            System.out.println("Invalid input. This field requires a positive integer.");
            scanner.nextLine();
            return -1;
        }
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
                    System.out.print("Invalid input. Enter 'Y' or 'N': ");
            }
        }
    }

    public static void pressContinue(Scanner scanner){
        System.out.print("(Press Enter To Continue)");
        scanner.nextLine();
    }

    public static void createList(ArrayList<String> data){
        for(int i = 0; i < data.size(); i++){
            System.out.println((i + 1) + ") " + data.get(i));
        }
        System.out.println("0) Back");
    }

    public static void createMenuList(ArrayList<Menu> menus){
        for(int i = 0; i < menus.size(); i++){
            System.out.println((i + 1) + ") " + menus.get(i).getName());
        }
        System.out.println("0) Back");
    }

    public static void printTitle(String subtitle){
        System.out.println();
        System.out.println("==== Restaurant Ticket Manager ====");
        System.out.println(subtitle);
    }

    private static int readBoundedInt(Scanner scanner, String prompt, int min, int max){
        int input;

        do {
            System.out.print(prompt);
            input = validateIntInput(scanner);
            if(input < min || input > max){
                System.out.println("Please enter a number from " + min + " to " + max + ".");
            }
        } while(input < min || input > max);

        return input;
    }

    private static void manageMenus(ArrayList<Menu> menus, Scanner input){
        printTitle("Menu");
        System.out.println("1) Create a New Menu");
        System.out.println("2) Select a Menu");
        System.out.println("3) Delete a Menu");
        System.out.println("0) Back");

        int menuOptionsChoice = readBoundedInt(input, "Choice: ", 0, 3);

        switch (menuOptionsChoice){
            case 1:
                createMenu(menus, input);
                pressContinue(input);
                break;
            case 2:
                Menu selectedMenu = selectMenu(menus, input);
                if(selectedMenu != null){
                    manageSelectedMenu(selectedMenu, input);
                }
                break;
            case 3:
                deleteMenu(menus, input);
                break;
            default:
                break;
        }
    }

    private static void manageSelectedMenu(Menu selectedMenu, Scanner input){
        int choice;

        do {
            printTitle("Selected Menu: " + selectedMenu.getName());
            System.out.println("1) Create a Category");
            System.out.println("2) View Categories");
            System.out.println("3) Create New Side");
            System.out.println("4) View Sides");
            System.out.println("5) Create an Item");
            System.out.println("6) View Items");
            System.out.println("0) Back");

            choice = readBoundedInt(input, "Choice: ", 0, 6);

            switch (choice){
                case 1:
                    createCategory(selectedMenu, input);
                    break;
                case 2:
                    viewList("Categories", selectedMenu.getCategories(), input);
                    break;
                case 3:
                    createSide(selectedMenu, input);
                    break;
                case 4:
                    viewList("Sides", selectedMenu.getSides(), input);
                    break;
                case 5:
                    createMenuItem(selectedMenu, input);
                    break;
                case 6:
                    viewMenuItems(selectedMenu, input);
                    break;
                default:
                    break;
            }
        } while(choice != 0);
    }

    private static void deleteMenu(ArrayList<Menu> menus, Scanner input){
        System.out.println("-- Delete a Menu --");
        if(menus.isEmpty()){
            System.out.println("No menus to delete.");
            pressContinue(input);
            return;
        }

        createMenuList(menus);
        int deleteIndex = readBoundedInt(input, "Choice: ", 0, menus.size());
        if(deleteIndex != 0){
            Menu removed = menus.remove(deleteIndex - 1);
            System.out.println(removed.getName() + " deleted.");
            pressContinue(input);
        }
    }

    private static void createCategory(Menu selectedMenu, Scanner input){
        System.out.println("-- Create a Category --");
        System.out.print("Category's name: ");
        String category = input.nextLine().trim();

        if(category.isEmpty()){
            System.out.println("Category name cannot be empty.");
        } else {
            selectedMenu.createCategory(category);
        }

        pressContinue(input);
    }

    private static void createSide(Menu selectedMenu, Scanner input){
        System.out.println("-- Create New Side --");
        System.out.print("Insert a new side: ");
        String side = input.nextLine().trim();

        if(side.isEmpty()){
            System.out.println("Side name cannot be empty.");
        } else {
            selectedMenu.createSide(side);
        }

        pressContinue(input);
    }

    private static void viewList(String title, ArrayList<String> data, Scanner input){
        System.out.println("-- View " + title + " --");
        if(data.isEmpty()){
            System.out.println("No " + title.toLowerCase() + " added yet.");
        } else {
            createList(data);
        }

        pressContinue(input);
    }

    private static void createMenuItem(Menu selectedMenu, Scanner input){
        System.out.println("-- Create an Item --");

        System.out.print("Item's name: ");
        String itemName = input.nextLine().trim();
        if(itemName.isEmpty()){
            System.out.println("Item name cannot be empty.");
            pressContinue(input);
            return;
        }

        System.out.print("Is an appetizer? (Y/N): ");
        boolean isAppetizer = checkQuestionInput(input);

        String category = "";
        if(!selectedMenu.getCategories().isEmpty()){
            System.out.println("Select a category:");
            createList(selectedMenu.getCategories());
            System.out.println("0) None");
            int categoryChoice = readBoundedInt(input, "Choice: ", 0, selectedMenu.getCategories().size());
            if(categoryChoice != 0){
                category = selectedMenu.getCategories().get(categoryChoice - 1);
            }
        } else {
            System.out.println("No categories created yet. Please create a category.");
            System.out.print("Category name: ");
            category = input.nextLine().trim();

            while(category.isEmpty()){
                System.out.println("Category name cannot be empty.");
                input.nextLine();
                category = input.nextLine().trim();
            }

            selectedMenu.createCategory(category);
            System.out.println("Item/Category created.");

        }

        String description = "";
        System.out.print("Would you like to add a description of the item? (Y/N): ");
        if(checkQuestionInput(input)){
            System.out.print("Enter a description: ");
            description = input.nextLine().trim();
        }

        String[] possibleSides = selectSides(selectedMenu, input);
        MenuItem newItem = description.isEmpty()
                ? new MenuItem(selectedMenu, category, itemName, isAppetizer, possibleSides)
                : new MenuItem(selectedMenu, category, itemName, isAppetizer, description, possibleSides);
        newItem.setCategory(category);

        selectedMenu.addMenuItem(newItem);
        pressContinue(input);
    }

    private static String[] selectSides(Menu selectedMenu, Scanner input){
        ArrayList<String> availableSides = selectedMenu.getSides();
        ArrayList<String> selectedSides = new ArrayList<>();

        if(availableSides.isEmpty()){
            return new String[0];
        }

        int choice;
        do {
            System.out.println("Select possible sides for this item:");
            createList(availableSides);
            System.out.println("0) Done");
            choice = readBoundedInt(input, "Choice: ", 0, availableSides.size());

            if(choice != 0){
                String side = availableSides.get(choice - 1);
                if(selectedSides.contains(side)){
                    System.out.println("That side is already selected.");
                } else {
                    selectedSides.add(side);
                    System.out.println(side + " selected.");
                }
            }
        } while(choice != 0);

        return selectedSides.toArray(new String[0]);
    }

    private static void viewMenuItems(Menu selectedMenu, Scanner input){
        System.out.println("-- View Items --");

        if(selectedMenu.getMenuItems().isEmpty()){
            System.out.println("No items added yet.");
        } else {
            ArrayList<MenuItem> items = selectedMenu.getMenuItems();
            for(int i = 0; i < items.size(); i++){
                System.out.println((i + 1) + ") " + items.get(i));
            }
        }

        pressContinue(input);
    }

    private static void placeAnOrder(ArrayList<Menu> menus, Queue queue, Scanner input){
        if(menus.isEmpty()){
            System.out.println("You must create a menu first.");
            return;
        }

        ArrayList<MenuItem> order = new ArrayList<>();

        Menu selectedMenu;
        MenuItem selectedMenuItem;

        int choiceMenu;
        int choiceCategory;
        int choiceItem;
        int choiceSides;

        do{
            printTitle("Place an Order");
            //MENU
            System.out.println("Select a Menu:");
            createMenuList(menus);
            choiceMenu = readBoundedInt(input, "Choice: ", 0, menus.size());
            selectedMenu = menus.get(choiceMenu - 1);

            System.out.println();
            //CATEGORY
            String selectedCategory;
            do{
                System.out.println("Selected Menu: " +  selectedMenu);
                System.out.println();
                System.out.println("Select a Category:");
                createList(selectedMenu.getCategories());
                choiceCategory = readBoundedInt(input, "Choice: ", 0, selectedMenu.getCategories().size());
                selectedCategory = selectedMenu.getCategories().get(choiceCategory - 1);

                ArrayList<MenuItem> itemsInCategory = selectedMenu.filterByCategory(selectedCategory);

                for(int i = 0; i < itemsInCategory.size(); i++){
                    System.out.println((i + 1) + ") " + itemsInCategory.get(i).getItemName());
                }
                System.out.println("0) Back");
                System.out.print("Choose an Item: ");
                choiceItem = readBoundedInt(input, "Choice: ", 0, menus.size());
                selectedMenuItem = itemsInCategory.get(choiceItem - 1);

            } while(choiceCategory != 0);



            order.add(selectedMenuItem);
        } while(choiceMenu != 0);

        Ticket newTicket = new Ticket(order);
        queue.addTicket(newTicket);
    }

    public static void viewOrders(Scanner input, Queue orders){
        System.out.println("-- View Orders --");
        System.out.println(orders.toString());
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Menu> menus = new ArrayList<>();

        Queue orders = new Queue();

        int choice;
        do {
            printTitle("Welcome to Restaurant Ticket Manager!");
            System.out.println("1) Menu");
            System.out.println("2) Place an Order");
            System.out.println("3) View Order(s)");
            System.out.println("0) Exit");

            choice = readBoundedInt(input, "Choice: ", 0, 3);

            if(choice == 1){
                manageMenus(menus, input);
            }

            if (choice == 2){
                placeAnOrder(menus, orders, input);
                System.out.println("Order placed successfully!");
            }

            if (choice == 3){
                viewOrders(input, orders);
            }

        } while(choice != 0);

        System.out.println("Goodbye!");
    }
}
