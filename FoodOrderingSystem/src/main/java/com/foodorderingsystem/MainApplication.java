package com.foodorderingsystem;

import java.util.HashMap;
import java.util.Map;

import com.foodorderingsystem.model.Restaurant;
import com.foodorderingsystem.model.User;
import com.foodorderingsystem.service.OrderService;
import com.foodorderingsystem.service.RestaurantService;
import com.foodorderingsystem.strategy.HighestRatingStrategy;
import com.foodorderingsystem.strategy.LowestCostStrategy;
import com.foodorderingsystem.strategy.OrderingStrategy;

public class MainApplication {
    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println(" Namaste! Swagatam To Our Food Ordering App");
        System.out.println("==========================================\n");

        // Step 1: Create Restaurant Service
        RestaurantService restaurantService = new RestaurantService();

        // Adding restaurants
        Map<String, Integer> menu1 = new HashMap<>();
        menu1.put("Veg Biryani", 100);
        menu1.put("Chicken Biryani", 150);
        restaurantService.addRestaurant("Restaurant 1", menu1, 5, 4.5);

        Map<String, Integer> menu2 = new HashMap<>();
        menu2.put("Idli", 10);
        menu2.put("Dosa", 50);
        menu2.put("Veg Biryani", 80);
        menu2.put("Chicken Biryani", 175);
        restaurantService.addRestaurant("Restaurant 2", menu2, 5, 4.0);

        Map<String, Integer> menu3 = new HashMap<>();
        menu3.put("Idli", 15);
        menu3.put("Dosa", 30);
        menu3.put("Gobi Manchurian", 150);
        menu3.put("Chicken Biryani", 175);
        restaurantService.addRestaurant("Restaurant 3", menu3, 1, 4.9);

        // Step 2: Choose an Ordering Strategy
        OrderingStrategy strategy = new LowestCostStrategy();  // Change to HighestRatingStrategy if needed
        OrderService orderService = new OrderService(strategy);

        // Register Restaurants in OrderService
        for (Restaurant restaurant : restaurantService.getAllRestaurants()) {
            orderService.addRestaurant(restaurant);
        }

        // Step 3: Create Users
        User user1 = new User("Pradeep");
        User user2 = new User("Vinayak");
        User user3 = new User("Shubham");
        User user4 = new User("Saloni");

        // Step 4: Place Orders
        Map<String, Integer> order1 = new HashMap<>();
        order1.put("Idli", 3);
        order1.put("Dosa", 1);
        System.out.println();
        System.out.println(orderService.placeOrder(user1, order1));

        Map<String, Integer> order2 = new HashMap<>();
        order2.put("Idli", 3);
        order2.put("Dosa", 1);
        System.out.println(orderService.placeOrder(user2, order2));

        Map<String, Integer> order3 = new HashMap<>();
        order3.put("Veg Biryani", 3);
        order3.put("Dosa", 1);

        //am Now Changing the ORder strategy
        orderService.setOrderingStrategy(new HighestRatingStrategy());  // Switching strategy
        System.out.println(orderService.placeOrder(user3, order3));

        // Step 5: Complete an order
        orderService.completeOrder(1);  // Assuming Order ID = 1

        // Step 6: Place another order after completion
        System.out.println(orderService.placeOrder(user2, order2));

        // Step 7: Invalid Order (Item not available)
        Map<String, Integer> invalidOrder = new HashMap<>();
        invalidOrder.put("Idli", 3);
        invalidOrder.put("Paneer Tikka", 1);
        System.out.println(orderService.placeOrder(user4, invalidOrder));
    }
}
