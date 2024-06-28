package com.shopping.list.infrastructure;  // Package declaration

import java.util.Scanner;  // Import for using Scanner class
import java.util.regex.Pattern;  // Import for using Pattern class for regex

public class InputValidation {
    private Scanner scanner;  // Scanner object for reading user input

    // Constructor to initialize the InputValidation class
    public InputValidation() {
        this.scanner = new Scanner(System.in);
    }

    // Method to get a validated quantity from the user
    public int getValidatedQuantity() {
        int quantity;  // Variable to store the validated quantity
        while (true) {  // Loop until a valid quantity is entered
            System.out.print("Enter item quantity: ");
            String input = scanner.nextLine();  // Read the input from the user

            try {
                quantity = Integer.parseInt(input);  // Try to parse the input as an integer
                if (quantity >= 0) {  // Check if the quantity is non-negative
                    break;  // Exit the loop if the quantity is valid
                } else {
                    System.out.println("Quantity must be a non-negative number. Please try again.");
                }
            } catch (NumberFormatException e) {  // Handle invalid input
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return quantity;  // Return the validated quantity
    }

    // Method to get a validated name from the user
    public String getValidatedName() {
        String name;  // Variable to store the validated name
        Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9\\s-]*$");  // Regex pattern to validate the name

        while (true) {  // Loop until a valid name is entered
            System.out.print("Enter item name: ");
            name = scanner.nextLine();  // Read the input from the user

            if (pattern.matcher(name).matches()) {  // Check if the name matches the pattern
                break;  // Exit the loop if the name is valid
            } else {
                System.out.println("Invalid name. Name must start with a letter and can only contain letters, numbers, hyphens, and spaces. Please try again.");
            }
        }
        return name;  // Return the validated name
    }
}
