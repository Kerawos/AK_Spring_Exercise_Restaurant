package pl.akademiakodu.AK_Spring_Exercise_Restaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akademiakodu.AK_Spring_Exercise_Restaurant.models.Order;
import pl.akademiakodu.AK_Spring_Exercise_Restaurant.models.UserRequest;

@Controller
public class OrderController {

    @GetMapping("/order") public String orderGet(Model model){
        model.addAttribute("userRequest", new UserRequest());
        return "order";
    }

    @PostMapping("/order") public String orderPost(@ModelAttribute("userRequest") UserRequest userRequest, Model model){
        model.addAttribute("message", "order placed");
        return "order";
    }

}
