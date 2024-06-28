package com.shopping.list.infrastructure;  // Package declaration for the GroceryDisplay class

import com.shopping.list.model.GroceryItem;  // Import the GroceryItem class

public class GroceryDisplay {
    private GroceryList groceryList;  // Private member variable to store the GroceryList object

    // Constructor to initialize the groceryList
    public GroceryDisplay(GroceryList groceryList) {
        this.groceryList = groceryList;  // Assign the passed GroceryList object to the member variable
    }

    // Method to display the grocery list
    public void displayList() {
        if (groceryList.isEmpty()) {  // Check if the grocery list is empty
            // If the grocery list is empty, print a message
            System.out.println("The grocery list is empty.");
        } else {
            // Print the header of the list
            System.out.println("\nYour shopping list:");
            System.out.printf("%-5s %-20s %-10s%n", "No.", "Item Name", "Quantity");
            System.out.println("-------------------------------------");

            // Loop through the items in the list and print each item
            GroceryItem[] items = groceryList.getItems();  // Get the array of items
            for (int i = 0; i < groceryList.size(); i++) {  // Loop through the array
                GroceryItem item = items[i];  // Get the item at the current index
                System.out.printf("%-5d %-20s %-10d%n", (i + 1), item.getName(), item.getQuantity());  // Print the item details
            }
        }
    }
}
