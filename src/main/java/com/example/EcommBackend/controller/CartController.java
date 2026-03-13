package com.example.EcommBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcommBackend.dto.CartDTO;
import com.example.EcommBackend.dto.CartRequest;
import com.example.EcommBackend.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    
    @Autowired
    private CartService service;

    @PostMapping("/add")
    public CartDTO addCart(@RequestBody CartRequest cartRequest){
        return service.addCart(cartRequest);
    }
    @GetMapping("/{userId}")
    public CartDTO getCart(@PathVariable Long userId){
        return service.Cart(userId);
    }
}
