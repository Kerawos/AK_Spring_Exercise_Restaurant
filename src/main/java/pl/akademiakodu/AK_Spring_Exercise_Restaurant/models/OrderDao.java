package pl.akademiakodu.AK_Spring_Exercise_Restaurant.models;

import java.util.List;

public interface OrderDao {
    List<Order> getAllOrders();
    void addMeal(Meal meal);
    void removeOrder(Meal meal);
    void placeOrder(Order order);
}
