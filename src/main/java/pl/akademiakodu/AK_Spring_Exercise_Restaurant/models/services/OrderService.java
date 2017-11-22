package pl.akademiakodu.AK_Spring_Exercise_Restaurant.models.services;

import pl.akademiakodu.AK_Spring_Exercise_Restaurant.models.Order;

public class OrderService {

    private static OrderService ourInstance = new OrderService();

    public static OrderService getOrderSercise(){
        return ourInstance;
    }

}
