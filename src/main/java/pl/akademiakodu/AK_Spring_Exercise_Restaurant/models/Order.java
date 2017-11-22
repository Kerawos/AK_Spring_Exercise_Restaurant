package pl.akademiakodu.AK_Spring_Exercise_Restaurant.models;

public class Order {

    private Meal meal;
    private String orderOwner;
    private int orderTime;

    public Order(Meal meal, String orderOwner) {
        this.meal = meal;
        this.orderOwner = orderOwner;
        updateOrderTime();
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
        updateOrderTime();
    }

    public String getOrderOwner() {
        return orderOwner;
    }

    public void setOrderOwner(String orderOwner) {
        this.orderOwner = orderOwner;
    }

    public int getOrderTime() {
        return orderTime;
    }

    private void updateOrderTime(){
        this.orderTime = meal.getName().length();
    }

}
