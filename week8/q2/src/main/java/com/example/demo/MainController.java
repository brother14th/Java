package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewOrder (@RequestBody Order order) {
        Order newOrder = new Order();
        newOrder.setUserId(order.getUserId());
        newOrder.setStatus(order.getStatus());
        orderRepository.save(newOrder);
        return "Saved";
    }

    @GetMapping(path="/order")
    public @ResponseBody Optional<Order> getOrder(@RequestParam long orderId) {
        return orderRepository.findById(orderId);
    }
}