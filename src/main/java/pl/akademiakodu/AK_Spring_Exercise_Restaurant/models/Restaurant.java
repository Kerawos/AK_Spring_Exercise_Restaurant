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
}
