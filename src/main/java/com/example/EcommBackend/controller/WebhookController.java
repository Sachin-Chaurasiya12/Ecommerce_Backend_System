package com.example.EcommBackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcommBackend.Exceptions.ResourceNotFoundException;
import com.example.EcommBackend.model.Orders;
import com.example.EcommBackend.model.Status;
import com.example.EcommBackend.repository.OrderRepo;
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
    public ResponseEntity<String> handleWebhook(@RequestBody String payload,
        @RequestHeader("Stripe-Signature") String sigheader
    ){

        Event event;
        try {
            event = Webhook.constructEvent(payload, sigheader, "whsec_h9wQ6enaOR9fHNB1QEajL1vTYlxcpAqZ");
        } catch (SignatureVerificationException e) {
            return ResponseEntity.badRequest().body("Invalid Signature");
        }   

        if("payment_intent.succeeded".equals(event.getType())){

            var StripeObject = event.getDataObjectDeserializer().getObject();

            if(StripeObject.isPresent()){

                PaymentIntent intent = 
                    (com.stripe.model.PaymentIntent) StripeObject.get();

                String orderId = intent.getMetadata().get("orderId");

                Orders order = repo.findById(Integer.valueOf(orderId))
                            .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

                order.setStatus(Status.PAID);
                repo.save(order);
            }
        }
        
        return ResponseEntity.ok("success");
    }
}
