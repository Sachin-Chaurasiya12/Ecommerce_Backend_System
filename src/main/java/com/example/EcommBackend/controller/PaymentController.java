package com.example.EcommBackend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcommBackend.service.StripePaymentService;
import com.stripe.model.PaymentIntent;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    
    private StripePaymentService service;
    public PaymentController(StripePaymentService service){
        this.service = service;
    }
    
    @PostMapping("/create-payment")
    public Map<String,String> createPaymentIntent(@RequestBody Map<String,Object> data) throws Exception{
        Long amount = Long.valueOf(data.get("amount").toString());

        PaymentIntent intent = service.createPaymentIntent(amount);

        Map<String,String> response = new HashMap<>();
        response.put("clientsecret", intent.getClientSecret());

        return response;
    }
}
