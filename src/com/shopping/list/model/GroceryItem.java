package com.shopping.list.model;

/**
 * Represents a grocery item with a name and quantity.
 */
public class GroceryItem {
    private String name;     // The name of the grocery item
    private int quantity;    // The quantity of the grocery item

    /**
     * Constructs a new GroceryItem with the specified name and quantity.
     *
     * @param name     the name of the grocery item
     * @param quantity the quantity of the grocery item
     */
    public GroceryItem(String name, int quantity) {
        this.name = name;           // Initialize the name
        this.quantity = quantity;   // Initialize the quantity
    }

    /**
     * Retrieves the name of the grocery item.
     *
     * @return the name of the grocery item
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the quantity of the grocery item.
     *
     * @return the quantity of the grocery item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns a string representation of the grocery item.
     *
     * @return a string representation in the format "name (Quantity: quantity)"
     */
    @Override
    public String toString() {
        return name + " (Quantity: " + quantity + ")";
    }
}
