package com.foodorderingsystem.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.foodorderingsystem.model.Restaurant;
public class RestaurantService {
  private List<Restaurant> restaurants = new ArrayList<>();

  public void addRestaurant(String name, Map<String, Integer> menu, int maxOrders, double rating) {
      restaurants.add(new Restaurant(name, menu, maxOrders, rating));
  }

  public List<Restaurant> getAllRestaurants() {
      return restaurants;
  }

  public Restaurant getRestaurantByName(String name) {
      return restaurants.stream()
              .filter(r -> r.getName().equalsIgnoreCase(name))
              .findFirst()
              .orElse(null);
  }

  public void updateMenu(String restaurantName, String itemName, int price) {
    Restaurant restaurant = getRestaurantByName(restaurantName);
    if (restaurant != null) {
        if (restaurant.getMenu().containsKey(itemName)) {
            restaurant.getMenu().put(itemName, price);
        } else {
            System.out.println("Item does not exist in menu! Add it first.");
        }
    } else {
        System.out.println("Restaurant not found!");
    }
}


  public void completeOrder(String restaurantName) {
      Restaurant restaurant = getRestaurantByName(restaurantName);
      if (restaurant != null) {
          restaurant.completeOrder();
      }
      else {
        System.out.println("Restaurant not found! Cannot complete order.");
    }
  }
  public void removeRestaurant(String name) {
    restaurants.removeIf(r -> r.getName().equalsIgnoreCase(name));
}


}