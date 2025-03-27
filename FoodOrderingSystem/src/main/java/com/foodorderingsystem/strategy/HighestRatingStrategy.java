package com.foodorderingsystem.strategy;

import java.util.Map;

import com.foodorderingsystem.model.Restaurant;

public class HighestRatingStrategy implements OrderingStrategy {
    @Override
    public Restaurant findRestaurant(Map<String, Restaurant> restaurants, Map<String, Integer> order) {
        Restaurant bestRestaurant = null;
        double highestRating = 0.0;

        for (Restaurant restaurant : restaurants.values()) {
            if (restaurant.canFulfillOrder(order) && restaurant.getRating() > highestRating) {
                highestRating = restaurant.getRating();
                bestRestaurant = restaurant;
            }
        }
        return bestRestaurant;
    }
}
