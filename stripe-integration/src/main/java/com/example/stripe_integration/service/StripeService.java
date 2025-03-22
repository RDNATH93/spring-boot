package com.example.stripe_integration.service;

import java.math.BigDecimal;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.stripe_integration.dto.*;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service
public class StripeService {
  
  @Value("${stripe.publishKey}")
  private String stripePublishKey;

  @Value("${stripe.secretKey}")
  private String stripeSecretKey;

  public StripeResponse checkout(Product product){
    log.info("checkout service");
        Stripe.apiKey = stripeSecretKey;
        SessionCreateParams.LineItem.PriceData.ProductData productData =
        SessionCreateParams.LineItem.PriceData.ProductData.builder().setName(product.productName()).build();

        SessionCreateParams.LineItem.PriceData priceData =
        SessionCreateParams.LineItem.PriceData.builder()
        .setCurrency(product.currency() != null ? product.currency() : "USD")
        .setUnitAmountDecimal(BigDecimal.valueOf(product.amount()))
        .setProductData(productData)
        .build();

        SessionCreateParams.LineItem lineItem= 
        SessionCreateParams.LineItem.builder().setQuantity(product.quantity())
        .setPriceData(priceData).build();
        
        String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        log.info("baseUrl: "+baseUrl);

        SessionCreateParams params = SessionCreateParams.builder()
          .setMode(SessionCreateParams.Mode.PAYMENT)
          .setSuccessUrl("https://literate-space-capybara-xxvjxxwvx64f9qw6-8080.app.github.dev/success")
          .setCancelUrl("https://literate-space-capybara-xxvjxxwvx64f9qw6-8080.app.github.dev/cancel")
          .addLineItem(lineItem)
          .build();

          Session session =null;
        try{
          session =  Session.create(params);
        }catch(StripeException ex){
            log.error("Exception ", ex);    
        }

        // return StripeResponse.builder()
        // .setStatus("SUCCESS").setMessage("Payment session created")
        // .setSessionId(session.getId()).setSessionUrl(session.getUrl()).build();
        return new StripeResponse("SUCCESS","Payment session created",session.getId(),session.getUrl());
             
  }
}
