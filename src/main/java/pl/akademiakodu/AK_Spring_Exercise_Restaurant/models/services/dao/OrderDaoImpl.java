package pl.akademiakodu.AK_Spring_Exercise_Restaurant.models.services.dao;

/**
 * Imports section
 */
import org.springframework.stereotype.Service;
import pl.akademiakodu.AK_Spring_Exercise_Restaurant.models.Meal;
import pl.akademiakodu.AK_Spring_Exercise_Restaurant.models.OrderR;

import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for order logic
 */
@Service
public class OrderDaoImpl implements OrderDao {

    /**
     * Order list stored all created orders (individual)
     */
    private List<OrderR> orderList;

    /**
     * Constructor
     */
    public OrderDaoImpl() {
        orderList = new ArrayList<>();
    }

    @Override
    public List<OrderR> getAllOrders() {
        return orderList;
    }

    @Override
    public void addOrder(OrderR order) {
        orderList.add(order);
    }

    @Override
    public void removeOrder(OrderR order) {
        for (OrderR order1 : orderList) {
            if (order1.equals(order)){
                orderList.remove(order);
                break;
            }
        }
    }

    @Override
    public void addMealToOrder(OrderR order, Meal meal) {
        List<Meal> ourMeals = order.getMealList();
        ourMeals.add(meal);
        order.setMealList(ourMeals);
    }

    @Override
    public void removeMealFromOrder(OrderR order, Meal meal) {
        List<Meal> ourMeals = order.getMealList();
        for (Meal ourMeal : ourMeals) {
            if (meal.equals(ourMeal)){
                ourMeals.remove(ourMeal);
                break;
            }
        }
        order.setMealList(ourMeals);
    }

    @Override
    public boolean checkIfMealAppearInOurOrder(OrderR order, Meal meal){
        for (Meal meal1 : order.getMealList()) {
            if (meal1.equals(meal)){
                return true;
            }
        }
        return false;
    }
}
