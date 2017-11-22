package pl.akademiakodu.AK_Spring_Exercise_Restaurant.models.services;

import pl.akademiakodu.AK_Spring_Exercise_Restaurant.models.Order;

public interface OrderObserver {
    void orderUpdate(Order order);
}
