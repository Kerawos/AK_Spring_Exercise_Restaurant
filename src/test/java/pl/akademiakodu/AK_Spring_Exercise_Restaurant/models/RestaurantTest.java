package pl.akademiakodu.AK_Spring_Exercise_Restaurant.models;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.akademiakodu.AK_Spring_Exercise_Restaurant.models.dao.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RestaurantTest {

    private static Restaurant restaurant;

    @BeforeClass public static void start() {
        restaurant = new Restaurant();
    }

    @AfterClass public static void stop() throws Exception {
        restaurant = null;
    }

    @Test public void restaurantTests() throws Exception {
        assertNotNull(restaurant.getMenu());
        assertTrue(restaurant.checkIfMealExist("Pizza"));
        assertFalse(restaurant.checkIfMealExist("Pierogi"));
        assertEquals(restaurant.getMeal("Kluski").toString(), new Meal("Kluski", 9).toString());
        Order orderTest = new Order();
        orderTest.setOrderOwner("User");
        List<Meal> mealList = new ArrayList<>();
        mealList.add(restaurant.getMenu().get(0));
        mealList.add(restaurant.getMenu().get(3));
        mealList.add(restaurant.getMenu().get(6));
        orderTest.setMealList(mealList);
        assertEquals(restaurant.calculateOrderPrice(orderTest), 35);
    }
}