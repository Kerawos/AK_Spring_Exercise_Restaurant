package pl.akademiakodu.AK_Spring_Exercise_Restaurant.models;

public class Order {

    private Meal meal;
    private int orderTime;

    public Order(Meal meal) {
        this.meal = meal;
        updateOrderTime();
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
        updateOrderTime();
    }

    public int getOrderTime() {
        return orderTime;
    }

    private void updateOrderTime(){
        this.orderTime = meal.getName().length();
    }

}
