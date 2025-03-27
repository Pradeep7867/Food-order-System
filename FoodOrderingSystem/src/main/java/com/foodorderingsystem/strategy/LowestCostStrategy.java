package com.foodorderingsystem.strategy;

import java.util.Map;

import com.foodorderingsystem.model.Restaurant;

public class LowestCostStrategy implements OrderingStrategy {
    @Override
    public Restaurant findRestaurant(Map<String, Restaurant> restaurants, Map<String, Integer> order) {
        Restaurant bestRestaurant = null;
        int minCost = Integer.MAX_VALUE;

        for (Restaurant restaurant : restaurants.values()) {
            int cost = restaurant.calculateOrderCost(order);
            if (cost > 0 && cost < minCost) {
                minCost = cost;
                bestRestaurant = restaurant;
            }
        }
        return bestRestaurant;
    }
}
