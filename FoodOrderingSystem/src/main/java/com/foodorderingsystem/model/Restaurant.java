package com.foodorderingsystem.model;

import java.util.Map;

public class Restaurant {
    private String name;
    private int maxOrders;
    private double rating;
    private Map<String, Integer> menu;
    private int activeOrders;

    public Restaurant(String name, Map<String, Integer> menu, int maxOrders, double rating) {
        this.name = name;
        this.menu = menu;
        this.maxOrders = maxOrders;
        this.rating = rating;
        this.activeOrders = 0; // Initialize active orders to 0
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public Map<String, Integer> getMenu() {
        return menu;
    }

    public boolean canAcceptOrder() {
        return activeOrders < maxOrders;
    }

    public void increaseOrderCount() {
        if (canAcceptOrder()) {
            activeOrders++;
        }
    }

    public void completeOrder() {
        if (activeOrders > 0) {
            activeOrders--;
        }
    }
    // Fix: Add this method to calculate order cost
    public int calculateOrderCost(Map<String, Integer> order) {
        int totalCost = 0;

        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String itemName = entry.getKey();
            int quantity = entry.getValue();

            if (menu.containsKey(itemName)) {
                totalCost += menu.get(itemName) * quantity;
            } else {
                return -1; // Invalid order (item not found in menu)
            }
        }
        return totalCost;
    }
    // Fix: Add this method to check if the restaurant can fulfill the order
    public boolean canFulfillOrder(Map<String, Integer> order) {
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String itemName = entry.getKey();
            int quantity = entry.getValue();

            // If item is not in menu OR the restaurant does not have enough quantity, return false
            if (!menu.containsKey(itemName) || menu.get(itemName) < quantity) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Restaurant: " + name + " (Rating: " + rating + ")\nMenu: " + menu;
    }
}