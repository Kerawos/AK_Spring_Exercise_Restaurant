package pl.akademiakodu.AK_Spring_Exercise_Restaurant.models;

import java.util.List;

public class Order {

    private String orderOwner;
    private List<Meal> mealList;

    public Order() {
    }

    public Order(String orderOwner, List<Meal> mealList) {
        this.orderOwner = orderOwner;
        this.mealList = mealList;
    }

    public String getOrderOwner() {
        return orderOwner;
    }

    public void setOrderOwner(String orderOwner) {
        this.orderOwner = orderOwner;
    }

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }

}
