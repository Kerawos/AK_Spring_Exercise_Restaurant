package pl.akademiakodu.AK_Spring_Exercise_Restaurant.models;

import java.util.List;

public class Restaurant {

    private List<Meal> menu = new MealDatabase().getMeals();

    public boolean checkIfMealExist(String mealName){
        for (Meal meal : menu) {
            if (mealName.toLowerCase().equals(meal.getName().toLowerCase())){
                return true;
            }
        }
        return false;
    }

    public int calculateOrderPrice(Order order){
        int sum = 0;
        for (Meal meal : order.getMealList()) {
            sum+=meal.getPrice();
        }
        return sum;
    }

    public Meal getMeal(String mealName){
        for (Meal meal : menu) {
            if (mealName.equals(meal.getName())){
                return meal;
            }
        }
        return null;
    }

    public List<Meal> getMenu() {
        return menu;
    }
}
