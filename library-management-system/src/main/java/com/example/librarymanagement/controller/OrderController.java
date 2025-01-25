package com.example.librarymanagement.controller;



import com.example.librarymanagement.model.Order;
import com.example.librarymanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String getAllOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "orders/list";
    }

    @GetMapping("/create")
    public String createOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orders/create";
    }

    @PostMapping("/create")
    public String createOrder(@RequestParam Long studentId, @RequestParam Long bookId) {
        orderService.createOrder(studentId, bookId);
        return "redirect:/orders";
    }

    @GetMapping("/return/{id}")
    public String returnOrder(@PathVariable Long id) {
        orderService.returnOrder(id);
        return "redirect:/orders";
    }

    @PostMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }
}

