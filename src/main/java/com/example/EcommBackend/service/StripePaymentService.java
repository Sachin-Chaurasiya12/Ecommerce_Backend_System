package com.example.EcommBackend.service;

import org.springframework.stereotype.Service;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

@Service
public class StripePaymentService {
    
    public PaymentIntent createPaymentIntent(Long amount) throws StripeException{

        PaymentIntentCreateParams params = new PaymentIntentCreateParams
                    .Builder()
                    .setAmount(amount)
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
