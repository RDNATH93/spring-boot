package com.example.stripe_integration.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stripe_integration.dto.*;
import com.example.stripe_integration.service.StripeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/products/v1")
public class ProductController {

    private final StripeService stripeService;

    ProductController(StripeService stripeService){
        this.stripeService = stripeService;
    }

    @PostMapping(value="/checkout",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<StripeResponse> checkoutProduct(@RequestBody Product product){
        log.info("Calling checkout");
        StripeResponse response = stripeService.checkout(product);
        return ResponseEntity.ok(response);
    }

}

