package pl.akademiakodu.AK_Spring_Exercise_Restaurant.models;

import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    private List<Order> orderList;

    public OrderDaoImpl() {
        orderList = new ArrayList<>();
    }

    @Override
    public List<Order> getAllOrders() {
        return orderList;
    }

    @Override
    public void addOrder(Order order) {
        orderList.add(order);
    }

    @Override
    public void removeOrder(Order order) {
        for (Order order1 : orderList) {
            if (order1.equals(order)){
                orderList.remove(order);
                break;
            }
        }
    }

    @Override
    public void addMealToOrder(Order order, Meal meal) {
        List<Meal> ourMeals = order.getMealList();
        ourMeals.add(meal);
        order.setMealList(ourMeals);
    }

    @Override
    public void removeMealFromOrder(Order order, Meal meal) {
        List<Meal> ourMeals = order.getMealList();
        for (Meal ourMeal : ourMeals) {
            if (meal.equals(ourMeal)){
                ourMeals.remove(ourMeal);
                break;
            }
        }
        order.setMealList(ourMeals);
    }

    @Override
    public boolean checkIfMealAppearInOurOrder(Order order, Meal meal){
        for (Meal meal1 : order.getMealList()) {
            if (meal1.equals(meal)){
                return true;
            }
        }
        return false;
    }
}
