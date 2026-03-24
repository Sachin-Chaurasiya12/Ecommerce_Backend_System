package com.example.EcommBackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcommBackend.Exceptions.ResourceNotFoundException;
import com.example.EcommBackend.model.Orders;
import com.example.EcommBackend.model.OrderStatus;
import com.example.EcommBackend.repository.OrderRepo;
import com.google.gson.JsonObject;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.Event;
import com.stripe.model.PaymentIntent;
import com.stripe.net.Webhook;

@RestController
@RequestMapping("/api")
public class WebhookController {

    private final OrderRepo repo;

    public WebhookController(OrderRepo repo){
        this.repo = repo;
    }

    @PostMapping("/webhook")
    public ResponseEntity<String> handleWebhook(@RequestBody String payload){

    System.out.println("Webhook called!");

    JsonObject json = Event.GSON.fromJson(payload, JsonObject.class);

    String eventType = json.get("type").getAsString();
    System.out.println("Event type: " + eventType);

    if ("payment_intent.succeeded".equals(eventType)) {

        JsonObject dataObject = json
                .getAsJsonObject("data")
                .getAsJsonObject("object");

        String orderId = dataObject
                .getAsJsonObject("metadata")
                .get("orderId")
                .getAsString();

        System.out.println("OrderId: " + orderId);

        Orders order = repo.findById(Integer.valueOf(orderId))
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        order.setStatus(OrderStatus.PAID);
        repo.save(order);

        System.out.println("Order updated to PAID");
    }

    return ResponseEntity.ok("success");
}
}
