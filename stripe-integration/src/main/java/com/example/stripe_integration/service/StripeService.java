package com.example.stripe_integration.service;

import java.math.BigDecimal;


import org.springframework.beans.factory.annotation.Value;

import com.example.stripe_integration.dto.*;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

import lombok.extern.slf4j.Slf4j;



@Slf4j
public class StripeService {
  
  @Value("${stripe.publishKey}")
  private String stripePublishKey;

  @Value("${stripe.secretKey}")
  private String stripeSecretKey;

  public StripeResponse checkoutResponse(Product product){
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
        
        SessionCreateParams params = SessionCreateParams.builder()
          .setMode(SessionCreateParams.Mode.PAYMENT)
          .setSuccessUrl("https://literate-tribble-wj9674pp6gcg65w.github.dev:8080/success")
          .setCancelUrl("https://literate-tribble-wj9674pp6gcg65w.github.dev:8080/cancel")
          .addLineItem(lineItem)
          .build();

          Session session =null;
        try{
          session =  Session.create(params);
        }catch(StripeException ex){
            log.error("Exception ", ex);    
        }

        return StripeResponse.builder()
        .setStatus("SUCCESS").setMessage("Payment successful")
        .setSessionId(session.getId()).setSessionUrl(session.getUrl()).build();
        
             
  }
}
