package com.example.EcommBackend.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

@Service
public class StripePaymentService {
    
    public PaymentIntent createPaymentIntent(Long amount,Integer orderId) throws StripeException{
        
        Map<String, String> metadata = new HashMap<>();
        metadata.put("orderId", orderId.toString());
        PaymentIntentCreateParams params = new PaymentIntentCreateParams
                    .Builder()
                    .setAmount(amount)
                    .putMetadata("orderId", orderId.toString())
                    .setCurrency("inr")
                    .setAutomaticPaymentMethods(
                        PaymentIntentCreateParams.AutomaticPaymentMethods
                                .builder()
                                .setEnabled(true)
                                .build()
                    )
                    .build();
                    
        return PaymentIntent.create(params);
    }
}
