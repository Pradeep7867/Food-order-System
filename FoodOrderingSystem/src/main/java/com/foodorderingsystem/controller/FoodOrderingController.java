package com.foodorderingsystem.controller;
import java.util.Map;

import com.foodorderingsystem.model.Order;
import com.foodorderingsystem.model.User;
import com.foodorderingsystem.service.OrderService;
import com.foodorderingsystem.service.RestaurantService;
import com.foodorderingsystem.strategy.LowestCostStrategy;

public class FoodOrderingController {
    @SuppressWarnings("FieldMayBeFinal")
    private OrderService orderService;
    @SuppressWarnings("FieldMayBeFinal")
    private RestaurantService restaurantService;  

    public FoodOrderingController() {
        this.orderService = new OrderService(new LowestCostStrategy()); 
        this.restaurantService = new RestaurantService();  
    }

    public String placeOrder(String userName, Map<String, Integer> order) {
        User user = new User(userName); 
        Order placedOrder = orderService.placeOrder(user, order);
        return placedOrder.toString(); // Ensure Order class has a meaningful toString() method
    }
    

    public void addRestaurant(String name, Map<String, Integer> menu, int maxOrders, double rating) {
        restaurantService.addRestaurant(name, menu, maxOrders, rating);
    }

    public void completeOrder(String restaurantName) {
        restaurantService.completeOrder(restaurantName);
    }
}
