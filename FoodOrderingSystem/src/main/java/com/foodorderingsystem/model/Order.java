package com.foodorderingsystem.model;

import java.util.Map;

public class Order {
    private static int idCounter = 1;
    final int orderId;
    final User user;
    final Restaurant assignedRestaurant;
    public Map<String, Integer> items;
    private boolean isCompleted;

    public Order(User user, Restaurant restaurant, Map<String, Integer> items) {
        this.orderId = idCounter++;
        this.user = user;
        this.assignedRestaurant = restaurant;
        this.items = items;
        this.isCompleted = false;
    }

    public int getOrderId() {
        return orderId;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
        assignedRestaurant.completeOrder();
    }

    @Override
public String toString() {
    return "Order{orderId=" + orderId + ", user=" + user.getName() + ", items=" + items + "}";
}
}