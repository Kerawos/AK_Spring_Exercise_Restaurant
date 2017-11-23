package pl.akademiakodu.AK_Spring_Exercise_Restaurant.models.dao;

import org.springframework.stereotype.Repository;
import pl.akademiakodu.AK_Spring_Exercise_Restaurant.models.Meal;

import java.util.List;

@Repository
public interface OrderDao {
    List<OrderR> getAllOrders();
    void addOrder(OrderR order);
    void removeOrder(OrderR order);
    void addMealToOrder(OrderR order, Meal meal);
    void removeMealFromOrder(OrderR order, Meal meal);
    boolean checkIfMealAppearInOurOrder(OrderR order, Meal meal);
}
