package com.example.EcommBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcommBackend.dto.OrderRequestDTO;
import com.example.EcommBackend.dto.OrderResponseDTO;
import com.example.EcommBackend.service.orders.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public OrderResponseDTO order(@RequestBody OrderRequestDTO request){
        return service.createOrder(request);
    }
    @GetMapping
    public List<OrderResponseDTO> getorder(){
        return service.getOrders();
    }
    @GetMapping("/{orderid}")
    public ResponseEntity<OrderResponseDTO> getorderByid(@PathVariable Integer orderid){
        OrderResponseDTO responseDTO = service.getOrders(orderid);
        return ResponseEntity.ok(responseDTO);
    }
}   
