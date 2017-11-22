package pl.akademiakodu.AK_Spring_Exercise_Restaurant.models.services;

import pl.akademiakodu.AK_Spring_Exercise_Restaurant.models.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OrderService {

    private static OrderService ourInstance = new OrderService();
    private List<OrderObserver> observers;
    private ExecutorService cook;

    public static OrderService getOrderService(){
        return ourInstance;
    }

    private OrderService(){
        observers = new ArrayList<>();
        cook = Executors.newFixedThreadPool(3);
    }

    public void addObserver(OrderObserver observer){
        observers.add(observer);
    }

    public void removeObserver(OrderObserver observer){
        observers.remove(observers.size()-1);
    }

    public void notifyObservers(Order order){
        for (OrderObserver observer : observers) {
            observer.orderUpdate(order);
        }
    }

//    public void makeOrder(Order order){
//        Runnable orderToMake = new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    TimeUnit.SECONDS.sleep(order.getOrderTime());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        cook.execute(orderToMake);
//    }

//    public boolean isOrderNotComplicated(Order order){
//        return order.getOrderTime() > 10 ? false : true;
//    }




}
