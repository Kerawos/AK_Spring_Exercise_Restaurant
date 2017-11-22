package pl.akademiakodu.AK_Spring_Exercise_Restaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.AK_Spring_Exercise_Restaurant.models.*;
import pl.akademiakodu.AK_Spring_Exercise_Restaurant.models.services.OrderService;

@Controller
public class OrderController {

    OrderDao orderDao = new OrderDaoImpl();

    @GetMapping("/order") public String orderGet(Model model){
        model.addAttribute("welcome", "Please place order and wait for preparing it");
        orderDao.placeOrder(new Order());
        model.addAttribute("userRequest", new UserRequest());
        return "order";
    }

    @PostMapping("/order") public String orderPost(@ModelAttribute("userRequest") UserRequest userRequest, Model model){
        model.addAttribute("welcome", "Please place order and wait for preparing it");
        model.addAttribute("userName", "Order placing by: " + userRequest.getName());
        model.addAttribute("message", "Order placed, please wait until done, you will be informed");
        model.addAttribute("currentOrder", "Your Current Order: " + orderDao.getAllOrders().get(0).getMealList().toString());
        return "order";
    }

    @RequestMapping(params = "addOrder", method = RequestMethod.POST) public String orderAdd(@ModelAttribute("userRequest") UserRequest userRequest, Model model){
        orderDao.addMeal();
        return "order";
    }

    @RequestMapping(params = "removeOrder", method = RequestMethod.POST) public String orderRemove(){
        return "order";
    }

    @RequestMapping(params = "placeOrder", method = RequestMethod.POST) public String orderPlace(){
        return "order";
    }

//    @PostMapping("/order") public String orderComplete(){
//
//        return "order";
//    }

}
