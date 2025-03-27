package com.foodorderingsystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.foodorderingsystem.model.Order;
import com.foodorderingsystem.model.Restaurant;
import com.foodorderingsystem.model.User;
import com.foodorderingsystem.strategy.OrderingStrategy;

public class OrderService {
    private Map<String, Restaurant> restaurants;
    private List<Order> orders;
    private OrderingStrategy orderingStrategy;

    public OrderService(OrderingStrategy orderingStrategy) {
        this.restaurants = new HashMap<>();
        this.orders = new ArrayList<>();
        this.orderingStrategy = orderingStrategy;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getName(), restaurant);
    }

    public void setOrderingStrategy(OrderingStrategy strategy) {
        this.orderingStrategy = strategy;
    }

    public Order placeOrder(User user, Map<String, Integer> items) {
        if (orderingStrategy == null) {
            System.out.println("Error: No ordering strategy set.");
            return null;
        }

        Restaurant selectedRestaurant = orderingStrategy.findRestaurant(restaurants, items);
        if (selectedRestaurant == null) {
            System.out.println("No suitable restaurant found for this order.");
            return null;
        }

        Order newOrder = new Order(user, selectedRestaurant, items);
        orders.add(newOrder);
        selectedRestaurant.increaseOrderCount();

        System.out.println("Order placed successfully at: " + selectedRestaurant.getName());
        return newOrder;
    }

    public void completeOrder(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId && !order.isCompleted()) {
                order.markAsCompleted();
                System.out.println("Order #" + orderId + " has been completed.");
                return;
            }
        }
        System.out.println("Order not found or already completed.");
    }
}
