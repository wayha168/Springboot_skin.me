package com.project.skin_me.config;

import com.stripe.Stripe;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StripeConfig {

    @Value("${stripe.secret.key}")
    private String stripeSecretKey;

    @PostConstruct
    public void init(){
        Stripe.apiKey = stripeSecretKey;
        System.out.println("Stripe initialized with secret key");

    }
}
