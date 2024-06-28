package com.shopping.list.infrastructure;  // Package declaration

import java.util.InputMismatchException;  // Import for handling input mismatch exceptions
import java.util.Scanner;  // Import for using Scanner class

public class GroceryAdd {
    private GroceryList groceryList;  // Reference to the GroceryList object
    private Scanner scanner;  // Scanner object for reading user input
    private InputValidation inputValidation;  // Reference to InputValidation object

    // Constructor to initialize GroceryAdd with a given GroceryList
    public GroceryAdd(GroceryList groceryList) {
        this.groceryList = groceryList;
        this.scanner = new Scanner(System.in);
        this.inputValidation = new InputValidation();
    }

    // Method to add items to the grocery list
    public void addItem() {
        int initialSize = askForListSize();  // Ask user for the initial size of the list
        groceryList.resize(initialSize);  // Resize the list to the initial size

        while (true) {  // Loop to continuously add items until the user decides to stop
            if (groceryList.isFull()) {  // Check if the list is full
                System.out.print("The list is full. Do you want to continue adding items? (1 for yes, 2 for no) ");
                System.out.println("");
                if (!askYesNoQuestion()) {  // Ask if the user wants to continue adding items
                    break;  // Exit the loop if the user says no
                }

                System.out.print("Do you want to resize the list? (1 for yes, 2 for no) ");
                System.out.println("");
                if (askYesNoQuestion()) {  // Ask if the user wants to resize the list
                    resizeList();  // Resize the list if the user says yes
                }
            } else {
                String name = inputValidation.getValidatedName();  // Get a validated item name
                int quantity = inputValidation.getValidatedQuantity();  // Get a validated quantity

                groceryList.addItem(name, quantity);  // Add the item to the list
                System.out.println("Item is successfully added to the list.");
                System.out.println("");

                // Ask if the user wants to add another item
                System.out.print("Do you want to add another item? (1 for yes, 2 for no): ");
                System.out.println("");
                if (!askYesNoQuestion()) {  // If the user says no, exit the loop
                    break;
                }
            }
        }
    }

    // Method to ask a yes/no question and return true for yes, false for no
    private boolean askYesNoQuestion() {
        while (true) {
            try {
                int choice = scanner.nextInt();  // Read the user's choice
                scanner.nextLine();  // Consume newline

                if (choice == 1) {  // Return true if the choice is 1
                    return true;
                } else if (choice == 2) {  // Return false if the choice is 2
                    return false;
                } else {
                    System.out.println("Invalid choice. Please enter 1 for yes or 2 for no.");
                    System.out.println("");
                }
            } catch (InputMismatchException e) {  // Handle invalid input
                System.out.println("Invalid input. Please enter 1 for yes or 2 for no.");
                System.out.println("");
                scanner.nextLine();  // Clear the invalid input
            }
        }
    }

    // Method to ask the user for the initial size of the list
    private int askForListSize() {
        int size = 0;
        while (true) {
            try {
                System.out.print("Enter the initial size of the list: ");
                System.out.println("");
                size = scanner.nextInt();  // Read the size
                scanner.nextLine();  // Consume newline
                if (size > 0) {  // Check if the size is greater than zero
                    break;  // Exit the loop if the size is valid
                } else {
                    System.out.println("Size must be greater than zero.");
                    System.out.println("");
                }
            } catch (InputMismatchException e) {  // Handle invalid input
                System.out.println("Invalid input. Please enter a valid integer.");
                System.out.println("");
                scanner.nextLine();  // Clear the invalid input
            }
        }
        return size;  // Return the valid size
    }

    // Method to resize the list
    private void resizeList() {
        int newSize = 0;
        while (true) {
            try {
                System.out.print("Enter the new size for the list: ");
                newSize = scanner.nextInt();  // Read the new size
                scanner.nextLine();  // Consume newline
                if (newSize > groceryList.size()) {  // Check if the new size is greater than the current size
                    groceryList.resize(newSize);  // Resize the list
                    System.out.println("The list has been resized.");
                    System.out.println(" ");
                    break;  // Exit the loop if resizing is successful
                } else {
                    System.out.println("The new size must be greater than the current size.");
                    System.out.println("");
                }
            } catch (InputMismatchException e) {  // Handle invalid input
                System.out.println("Invalid input. Please enter a valid integer.");
                System.out.println("");
                scanner.nextLine();  // Clear the invalid input
            }
        }
    }
}
