package com.shopping.list.infrastructure;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private GroceryList groceryList;         // Instance of GroceryList to manage grocery items
    private GroceryAdd groceryAdd;           // Instance of GroceryAdd to add items to the list
    private GroceryRemove groceryRemove;     // Instance of GroceryRemove to remove items from the list
    private GroceryDisplay groceryDisplay;   // Instance of GroceryDisplay to display the list
    private Scanner scanner;                 // Scanner object to read user input

    /**
     * Constructor to initialize the Main class.
     * Initializes instances of GroceryList, GroceryAdd, GroceryRemove, and GroceryDisplay.
     * Initializes a Scanner to read user input from the console.
     */
    public Main() {
        groceryList = new GroceryList();
        groceryAdd = new GroceryAdd(groceryList);
        groceryRemove = new GroceryRemove(groceryList);
        groceryDisplay = new GroceryDisplay(groceryList);
        scanner = new Scanner(System.in);
    }

    /**
     * Method to handle user input for managing the shopping list.
     * Displays a menu, reads user input, and performs corresponding actions based on the choice.
     * Loops until the user chooses to exit.
     */
    public void handleUserInput() {
        int choice;  // Variable to store user's menu choice
        while (true) {
            try {
                // Displaying the menu options
                System.out.println("");
                System.out.println("    SHOPPING LIST MENU:     ");
                System.out.println("-----------------------------------------");
                System.out.println("1. Add an item to the list");
                System.out.println("2. Remove an item from the list");
                System.out.println("3. Display the current shopping list");
                System.out.println("4. Exit ");
                System.out.println("-----------------------------------------");
                System.out.print("Enter your choice: ");
                System.out.println("");

                choice = scanner.nextInt();  // Read user input for menu choice
                scanner.nextLine();  // Consume newline character

                switch (choice) {
                    case 1:
                        groceryAdd.addItem();  // Call method to add an item to the list
                        break;
                    case 2:
                        groceryRemove.removeItem();  // Call method to remove an item from the list
                        break;
                    case 3:
                        groceryDisplay.displayList();  // Call method to display the current shopping list
                        break;
                    case 4:
                        System.out.println("Exiting the program. Goodbye!");
                        scanner.close();  // Close the scanner
                        return;  // Exit the program
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                        System.out.println("");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                System.out.println();
                scanner.nextLine();  // Clear the invalid input
            }
        }
    }

    /**
     * Main method to start the application.
     * Creates an instance of Main and starts handling user input.
     *
     * @param args command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.handleUserInput();  // Start handling user input
    }
}
