package com.shopping.list.infrastructure;  // Package declaration

import java.util.InputMismatchException;  // Import for handling input mismatch exceptions
import java.util.Scanner;  // Import for using the Scanner class
import com.shopping.list.model.GroceryItem;  // Import for using the GroceryItem class

public class GroceryRemove {  // Class declaration
    private GroceryList groceryList;  // Reference to the GroceryList object
    private Scanner scanner;  // Scanner object for reading user input

    // Constructor to initialize the GroceryRemove class
    public GroceryRemove(GroceryList groceryList) {
        this.groceryList = groceryList;  // Assign the provided grocery list to the class field
        this.scanner = new Scanner(System.in);  // Initialize the Scanner object
    }

    // Method to remove an item from the grocery list
    public void removeItem() {
        do {  // Loop until the user decides to stop
            int removalChoice = askRemovalMethod();  // Ask the user how they want to remove the item

            // Perform the removal based on the user's choice
            if (removalChoice == 1) {
                removeByIndex();  // Remove by index
            } else if (removalChoice == 2) {
                removeByName();  // Remove by name
            } else {
                System.out.println("Invalid choice. Please enter 1 for index or 2 for item name.");
                System.out.println(); // Empty line for formatting
                continue;  // Continue the loop if the choice is invalid
            }

            int choice = askToRemoveAnotherItem();  // Ask if the user wants to remove another item
            if (choice != 1) {
                break;  // Exit the loop if the user does not want to remove another item
            }
        } while (true);  // Continue looping
    }

    // Method to ask the user how they want to remove the item
    private int askRemovalMethod() {
        while (true) {  // Loop until a valid choice is made
            try {
                System.out.println("How do you want to remove the item?");
                System.out.println("1. By index");
                System.out.println("2. By item name");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();  // Read the user's choice
                scanner.nextLine(); // Consume newline

                if (choice == 1 || choice == 2) {
                    return choice;  // Return the choice if it is valid
                } else {
                    System.out.println("Invalid choice. Please enter 1 for index or 2 for item name.");
                    System.out.println(); // Empty line for formatting
                }
            } catch (InputMismatchException e) {  // Handle invalid input
                System.out.println("Invalid input. Please enter an integer (1 for index or 2 for item name).");
                System.out.println(); // Empty line for formatting
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    // Method to remove an item by index
    private void removeByIndex() {
        System.out.print("Enter index to remove: ");
        int index;
        while (true) {  // Loop until a valid index is entered
            try {
                index = scanner.nextInt();  // Read the index
                scanner.nextLine(); // Consume newline

                if (index >= 1 && index <= groceryList.size()) {
                    break; // Exit loop if the index is valid
                } else {
                    System.out.println("Index out of range. Please enter a valid index.");
                    System.out.println(); // Empty line for formatting
                    System.out.print("Enter index to remove: ");
                }
            } catch (InputMismatchException e) {  // Handle invalid input
                System.out.println("Invalid input. Please enter an integer index.");
                System.out.println(); // Empty line for formatting
                scanner.nextLine(); // Clear the invalid input
                System.out.print("Enter index to remove: ");
            }
        }

        GroceryItem removedItem = groceryList.removeItem(index - 1);  // Remove the item at the given index
        if (removedItem != null) {
            System.out.println("Item \"" + removedItem.getName() + "\" removed from the list.");
        } else {
            System.out.println("Failed to remove item at index " + index + ".");
        }
        System.out.println(); // Empty line for formatting
    }

    // Method to remove an item by name
    private void removeByName() {
        System.out.print("Enter item name to remove: ");
        String itemName = scanner.nextLine();  // Read the item name

        if (groceryList.removeItem(itemName)) {
            System.out.println("Item \"" + itemName + "\" removed from the list.");
        } else {
            System.out.println("Item \"" + itemName + "\" not found in the list.");
        }
        System.out.println(); // Empty line for formatting
    }

    // Method to ask if the user wants to remove another item
    private int askToRemoveAnotherItem() {
        while (true) {  // Loop until a valid choice is made
            try {
                System.out.print("Do you want to remove another item? (1 for yes, 2 for no): ");
                int choice = scanner.nextInt();  // Read the user's choice
                scanner.nextLine(); // Consume newline

                if (choice == 1 || choice == 2) {
                    return choice;  // Return the choice if it is valid
                } else {
                    System.out.println("Invalid choice. Please enter between 1 or 2 only.");
                    System.out.println(); // Empty line for formatting
                }

            } catch (InputMismatchException e) {  // Handle invalid input
                System.out.println("Invalid input. Please enter 1 for yes or 2 for no.");
                System.out.println(); // Empty line for formatting
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }
}
