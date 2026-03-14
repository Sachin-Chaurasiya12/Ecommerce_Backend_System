package com.example.EcommBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcommBackend.dto.OrderDTO;
import com.example.EcommBackend.dto.OrderRequest;
import com.example.EcommBackend.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }
    
    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderRequest request){
        return orderService.createOrder(request);
    }
}
