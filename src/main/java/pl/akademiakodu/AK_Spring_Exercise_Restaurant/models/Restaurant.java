package pl.akademiakodu.AK_Spring_Exercise_Restaurant.models;

import pl.akademiakodu.AK_Spring_Exercise_Restaurant.models.services.OrderObserver;
import pl.akademiakodu.AK_Spring_Exercise_Restaurant.models.services.OrderService;

public class Restaurant implements OrderObserver {

    private OrderService orderService = OrderService.getOrderService();



    @Override
    public void orderUpdate(Order order) {

    }
}
