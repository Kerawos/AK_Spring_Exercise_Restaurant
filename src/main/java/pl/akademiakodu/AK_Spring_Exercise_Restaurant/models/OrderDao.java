package pl.akademiakodu.AK_Spring_Exercise_Restaurant.models;

import java.util.List;

public interface OrderDao {
    List<Order> getAllOrders();
    void addOrder(Order order);
    void removeOrder(Order order);
    void addMealToOrder(Order order, Meal meal);
    void removeMealFromOrder(Order order, Meal meal);
    boolean checkIfMealAppearInOurOrder(Order order, Meal meal);
}
