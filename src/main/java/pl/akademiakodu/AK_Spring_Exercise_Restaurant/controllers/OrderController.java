package pl.akademiakodu.AK_Spring_Exercise_Restaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.AK_Spring_Exercise_Restaurant.models.*;

@Controller
public class OrderController {

    private OrderDao orderDao = new OrderDaoImpl();
    private Restaurant restaurant = new Restaurant();
    private Order ourOrder;

    @GetMapping("/order") public String orderGet(Model model){
        model.addAttribute("welcome", "Please place order and wait for preparing it");
        model.addAttribute("menu", "Our Menu: " + restaurant.getMenu().toString());
        orderDao.addOrder(new Order());
        ourOrder = orderDao.getAllOrders().get(0);
        model.addAttribute("userRequest", new UserRequest());
        return "order";
    }


    @RequestMapping(params = "addOrder", method = RequestMethod.POST) public String orderAdd(
            @ModelAttribute("userRequest") UserRequest userRequest, Model model){
        model.addAttribute("welcome", "Please place order and wait for preparing it");
        model.addAttribute("menu", "Our Menu: " + restaurant.getMenu().toString());
        if (ourOrder.getOrderOwner()==null && !userRequest.getName().equals("")){
            ourOrder.setOrderOwner(userRequest.getName());
        }
        if (ourOrder.getOrderOwner()!=null){
            model.addAttribute("userName", "Order placing by: " + ourOrder.getOrderOwner());
        }
        if (restaurant.checkIfMealExist(userRequest.getMealName())){
            orderDao.addMealToOrder(ourOrder, restaurant.getMeal(userRequest.getMealName()));
        }
        if (ourOrder.getMealList().size()>0){
            model.addAttribute("currentOrder", "Your Current Order: " + ourOrder.getMealList().toString());
        }
        return "order";
    }

    @RequestMapping(params = "removeOrder", method = RequestMethod.POST) public String orderRemove(
            @ModelAttribute("userRequest") UserRequest userRequest, Model model){
        model.addAttribute("welcome", "Please place order and wait for preparing it");
        model.addAttribute("menu", "Our Menu: " + restaurant.getMenu().toString());
        if (ourOrder.getOrderOwner()==null && !userRequest.getName().equals("")){
            ourOrder.setOrderOwner(userRequest.getName());
        }
        if (ourOrder.getOrderOwner()!=null){
            model.addAttribute("userName", "Order placing by: " + ourOrder.getOrderOwner());
        }
        if (orderDao.checkIfMealAppearInOurOrder(ourOrder, restaurant.getMeal(userRequest.getMealName()))){
            orderDao.removeMealFromOrder(ourOrder, restaurant.getMeal(userRequest.getMealName()));
        }

        if (ourOrder.getMealList().size()>0){
            model.addAttribute("currentOrder", "Your Current Order: " + ourOrder.getMealList().toString());
        }
        return "order";
    }

    @RequestMapping(params = "placeOrder", method = RequestMethod.POST) public String orderPlace(
            @ModelAttribute("userRequest") UserRequest userRequest, Model model){
        model.addAttribute("welcome", "Please place order and wait for preparing it");
        model.addAttribute("menu", "Our Menu: " + restaurant.getMenu().toString());
        if (ourOrder.getMealList().size()>0){
            model.addAttribute("currentOrder", "Your Current Order: " +
                    ourOrder.getMealList().toString());
            model.addAttribute("message", "Order Total: $" +
                    restaurant.calculateOrderPrice(ourOrder));
        } else {
            model.addAttribute("message", "Order has been cancelled..");
        }
        orderDao.removeOrder(ourOrder);
        orderDao.addOrder(new Order());
        return "order";
    }

//    @PostMapping("/order") public String orderComplete(){
//
//        return "order";
//    }

}
