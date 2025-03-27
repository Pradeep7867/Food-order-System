package com.foodorderingsystem.strategy;

import java.util.Map;

import com.foodorderingsystem.model.Restaurant;

public interface OrderingStrategy {
    Restaurant findRestaurant(Map<String, Restaurant> restaurants, Map<String, Integer> order);
}
