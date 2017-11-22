package pl.akademiakodu.AK_Spring_Exercise_Restaurant.models;

import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    List<Order> orderList;

    public OrderDaoImpl() {
        orderList = new ArrayList<>();
    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public void addMeal(Meal meal) {

    }

    @Override
    public void removeOrder(Meal meal) {

    }

    @Override
    public void placeOrder(Order order) {
        orderList.add(order);
    }
}
