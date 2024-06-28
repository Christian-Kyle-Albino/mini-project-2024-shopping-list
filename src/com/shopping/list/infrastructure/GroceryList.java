package com.shopping.list.infrastructure;

import com.shopping.list.model.GroceryItem;

public class GroceryList {
    private GroceryItem[] items;
    private int maxSize;
    private int currentSize;

    public GroceryList() {
        this.maxSize = 10; // Default max size
        this.items = new GroceryItem[maxSize];
        this.currentSize = 0;
    }

    public GroceryList(int initialMaxSize) {
        this.maxSize = initialMaxSize;
        this.items = new GroceryItem[maxSize];
        this.currentSize = 0;
    }

    public void addItem(String name, int quantity) {
        if (!isFull()) {
            items[currentSize++] = new GroceryItem(name, quantity);
        } else {
            System.out.println("Cannot add item. The list is full.");
        }
    }

    public boolean isFull() {
        return currentSize >= maxSize;
    }

    public void resize(int newSize) {
        if (newSize >= currentSize) {
            GroceryItem[] newItems = new GroceryItem[newSize];
            System.arraycopy(items, 0, newItems, 0, currentSize);
            this.items = newItems;
            this.maxSize = newSize;
        } else {
            System.out.println("Cannot resize. The new size is smaller than the current number of items.");
        }
    }

    public boolean removeItem(String name) {
        for (int i = 0; i < currentSize; i++) {
            if (items[i].getName().equalsIgnoreCase(name)) {
                System.arraycopy(items, i + 1, items, i, currentSize - i - 1);
                items[--currentSize] = null;
                return true;
            }
        }
        return false;
    }

    public GroceryItem removeItem(int index) {
        if (index >= 0 && index < currentSize) {
            GroceryItem item = items[index];
            System.arraycopy(items, index + 1, items, index, currentSize - index - 1);
            items[--currentSize] = null;
            return item;
        }
        return null;
    }

    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public GroceryItem[] getItems() {
        GroceryItem[] currentItems = new GroceryItem[currentSize];
        System.arraycopy(items, 0, currentItems, 0, currentSize);
        return currentItems;
    }
}
